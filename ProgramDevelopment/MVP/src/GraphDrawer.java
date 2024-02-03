package MVP.src;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphDrawer extends JPanel {

    private final int spaceBetweenGraphAndForm = 30;
    private final int spaceBetweenLabelAndForm = 30;
    private final List<Double> cumCasesBySpecimenDate, newCasesBySpecimenDate;
    List<Double> testWith0To1;
    private final List<String> date;

    public GraphDrawer(List<Double> cumCasesBySpecimenDate, List<String> yAxis, List<Double> xAxis) {
        this.cumCasesBySpecimenDate = cumCasesBySpecimenDate;
        this.date = yAxis;
        this.newCasesBySpecimenDate = xAxis;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //region DRAW X AND Y-AXIS
        // create x and y-axis
        g2.drawLine(
                spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                spaceBetweenGraphAndForm);
        g2.drawLine(
                spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                getWidth() - spaceBetweenGraphAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm);
        //endregion

        //region DRAWING LABEL FOR Y-AXIS
        int numberYDivisions = 11;
        g2.setColor(Color.BLACK); //color for label
        for (int i = 0; i < numberYDivisions; i++)
        {
            //String labelForYAxis = new BigDecimal(((int) ((Collections.min(cumCasesBySpecimenDate) + (Collections.max(cumCasesBySpecimenDate) - Collections.min(cumCasesBySpecimenDate)) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "").divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP) + "M";  //getting the label from the list and converting to the nearest millions.
            String labelForYAxis = (int) ((Collections.min(cumCasesBySpecimenDate) + ((Collections.max(cumCasesBySpecimenDate) - Collections.min(cumCasesBySpecimenDate)) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";

            //draw - for the label
            g2.drawLine(
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberYDivisions + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm - 4,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberYDivisions + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm));  //drawing the dash mark for the Y-axis
            g2.drawString(labelForYAxis,
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm - (g2.getFontMetrics().stringWidth(labelForYAxis)) - 5,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberYDivisions + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm) + (g2.getFontMetrics().getHeight() / 2) - 3);
            }
        //endregion

        //region DRAWING LABEL FOR X-AXIS
        List<Double> predictionTestList = new ArrayList<>();
        for (int i = 0; i < cumCasesBySpecimenDate.size() ; i++)
        {
            predictionTestList.add((double) i);
            // increase the number for more spacing
            if (i % 60 == 0)
            {
                g2.drawLine(((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (cumCasesBySpecimenDate.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                        ((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (cumCasesBySpecimenDate.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm + 4);
                g2.drawString(date.get(i),
                        ((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (cumCasesBySpecimenDate.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm) - g.getFontMetrics().stringWidth(date.get(i)) / 2,
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm + g2.getFontMetrics().getHeight() + 3);
            }
        }
        //endregion

        //region CREATING AND JOINING POINTS
        //adding points to list
        List<Point> dataPointsOnGraph = IntStream.range(0, cumCasesBySpecimenDate.size())
                .mapToObj(i -> new Point(
                        (int) (i * (((double) getWidth() - (2 * spaceBetweenGraphAndForm) - spaceBetweenLabelAndForm) / (cumCasesBySpecimenDate.size() - 1)) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        (int) ((Collections.max(cumCasesBySpecimenDate) - cumCasesBySpecimenDate.get(i)) * (((double) getHeight() - 2 * spaceBetweenGraphAndForm - spaceBetweenLabelAndForm) / (Collections.max(cumCasesBySpecimenDate) - Collections.min(cumCasesBySpecimenDate))) + spaceBetweenGraphAndForm)
                )).collect(Collectors.toList());
        g2.setColor(Color.red); //any Color you want
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //smoother strokes in graph lines
        //draw the lines together (note: dot is not plotted)
        for (int i = 0; i < dataPointsOnGraph.size() - 1; i++)
            g2.drawLine(dataPointsOnGraph.get(i).x,
                    dataPointsOnGraph.get(i).y,
                    dataPointsOnGraph.get(i + 1).x,
                    dataPointsOnGraph.get(i + 1).y);
        //endregion

        //region TESTING PREDICTION
        // For the prediction, CONVERT THE DATES TO DAYS FOR THE INPUT
        System.out.println("last value of x: " + predictionTestList.get(predictionTestList.size() - 1) + " last value of y: " + cumCasesBySpecimenDate.get(cumCasesBySpecimenDate.size()-1));
        for(int i = 1; i < 5; i++)
            System.out.println("value to predict for " +  (predictionTestList.get(predictionTestList.size() - 1) + i) + " is " + myLinearProgression(predictionTestList,cumCasesBySpecimenDate,(predictionTestList.get(predictionTestList.size() - 1) + i)));

        //endregion
    }


    //https://courses.lumenlearning.com/introstats1/chapter/the-regre
    // ssion-equation/
    double myLinearProgression(List<Double> x, List<Double> y,double z){
        double sumOfX = x.stream().mapToDouble(Double::doubleValue).sum();
        double sumOfY = y.stream().mapToDouble(Double::doubleValue).sum();
        double meanOfSumOfX = sumOfX / x.size();
        double meanOfSumOfY = sumOfY / x.size();


        double sumOfZxZy = IntStream.range(0, x.size()).mapToDouble(i -> (x.get(i) - meanOfSumOfX) * (y.get(i) - meanOfSumOfY)).sum();
        double SumOfXMinusXMean = x.stream().mapToDouble(aDouble -> Math.pow((aDouble - meanOfSumOfX), 2)).sum();

        double slope = sumOfZxZy / SumOfXMinusXMean;
        double intercept = meanOfSumOfY - (slope * meanOfSumOfX);
        return intercept + (slope  * z);

    }

    public static void main(String[] args) {

    }
}
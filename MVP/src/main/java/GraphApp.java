import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphApp extends JPanel {

    private final int spaceBetweenGraphAndForm = 50;
    private final int spaceBetweenLabelAndForm = 50;
    private final List<Double> yAxisValues;
    private List<Double> secondYAxisValues;
    private List<Double> newYAxisValues;
    private final List<String> xAxisValues;
    private List<String> newXAxisValues;
    private int predictValue;
    public GraphApp(List<Double> yAxisValues, List<String> xAxisValues, int predictValue) {
        this.yAxisValues = yAxisValues;
        this.xAxisValues = xAxisValues;
        this.predictValue = predictValue;
    }
    public GraphApp(List<Double> yAxisValues, List<String> xAxisValues, List<Double> secondYAxisValues, int predictValue) {
        this.yAxisValues = yAxisValues;
        this.xAxisValues = xAxisValues;
        this.predictValue = predictValue;
        this.secondYAxisValues = secondYAxisValues;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D newGraphics = (Graphics2D) g;
        predict(predictValue);
        //region Y-AXIS PLOTTING
        newGraphics.drawLine(spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                spaceBetweenGraphAndForm); //drawing y-axis line
        //region DRAWING LABEL FOR Y-AXIS
        int numberOfLabelToShowForYAxis = 18; //how many labels to show
        newGraphics.setColor(Color.BLACK);//color for label
        for (int i = 0; i < numberOfLabelToShowForYAxis; i++) {
            newGraphics.drawLine( //drawing dashes for the label
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberOfLabelToShowForYAxis + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm - 4,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberOfLabelToShowForYAxis + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm));  //drawing the dash mark for the Y-axis

            String labelForYAxis = "";
            if (Collections.min(yAxisValues) < 5){
                labelForYAxis = new BigDecimal(((int) ((Collections.min(yAxisValues) + (Collections.max(yAxisValues) - Collections.min(yAxisValues)) * ((i * 1.0) / numberOfLabelToShowForYAxis)) * 100)) / 100.0 + "").divide(new BigDecimal("10")).setScale(0, RoundingMode.HALF_UP) + "";  //getting the label from the list and converting to the nearest thousands.
            } else if (Collections.max(yAxisValues) > 800000){
                labelForYAxis = new BigDecimal(((int) ((Collections.min(yAxisValues) + (Collections.max(yAxisValues) - Collections.min(yAxisValues)) * ((i * 1.0) / numberOfLabelToShowForYAxis)) * 100)) / 100.0 + "").divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP) + ",000,000";  //getting the label from the list and converting to the nearest thousands.
            } else {
                labelForYAxis = new BigDecimal(((int) ((Collections.min(yAxisValues) + (Collections.max(yAxisValues) - Collections.min(yAxisValues)) * ((i * 1.0) / numberOfLabelToShowForYAxis)) * 100)) / 100.0 + "").divide(new BigDecimal("1000")).setScale(0, RoundingMode.HALF_UP) + ",000";  //getting the label from the list and converting to the nearest thousands.
            }
            if (i == 0){
                labelForYAxis = "0";
            }
            newGraphics.drawString( //writing label for values
                    labelForYAxis,
                    spaceBetweenGraphAndForm + spaceBetweenLabelAndForm - (newGraphics.getFontMetrics().stringWidth(labelForYAxis)) - 6,
                    getHeight() - ((i * (getHeight() - spaceBetweenGraphAndForm * 2 - spaceBetweenLabelAndForm)) / numberOfLabelToShowForYAxis + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm) + (newGraphics.getFontMetrics().getHeight() / 2) - 3);
        }
        //endregion
        //endregion

        //region X-AXIS PLOTTING
        newGraphics.drawLine(spaceBetweenGraphAndForm + spaceBetweenLabelAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                getWidth() - spaceBetweenGraphAndForm,
                getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm); // drawing x-axis line
        //region DRAWING LABEL FOR X-AXIS
        List<Double> predictionTestList = new ArrayList<>();
        int numberOfLabelToShowForXAxis = 45; // increase the number for more spacing
        for (int i = 0; i < yAxisValues.size() ; i++)
        {
            predictionTestList.add((double) i);
            if (i % numberOfLabelToShowForXAxis == 0)
            {
                newGraphics.drawLine(((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (yAxisValues.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm,
                        ((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (yAxisValues.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm + 4);
                newGraphics.drawString(xAxisValues.get(i),
                        ((i * (getWidth() - (spaceBetweenGraphAndForm * 2) - spaceBetweenLabelAndForm)) / (yAxisValues.size() - 1) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm) - g.getFontMetrics().stringWidth(xAxisValues.get(i)) / 2,
                        getHeight() - spaceBetweenGraphAndForm - spaceBetweenLabelAndForm + newGraphics.getFontMetrics().getHeight() + 3);
            }
        }
        //endregion
        //endregion

        //region CREATING AND JOINING POINTS
        //adding points to list

        List<Point> dataPointsOnGraph = IntStream.range(0, newYAxisValues == null ? yAxisValues.size() : newYAxisValues.size())
                .mapToObj(i -> new Point(
                        (int) (i * (((double) getWidth() - (2 * spaceBetweenGraphAndForm) - spaceBetweenLabelAndForm) / ((newYAxisValues == null ? yAxisValues.size() : newYAxisValues.size()) - 1)) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                        (int) (((newYAxisValues == null ? Collections.max(yAxisValues) : Collections.max(newYAxisValues)) - (newYAxisValues == null ? yAxisValues.get(i) : newYAxisValues.get(i))) * (((double) getHeight() - 2 * spaceBetweenGraphAndForm - spaceBetweenLabelAndForm) / ((newYAxisValues == null ? Collections.max(yAxisValues) : Collections.max(newYAxisValues)) - Collections.min(yAxisValues))) + spaceBetweenGraphAndForm))).collect(Collectors.toList());
        newGraphics.setColor(Color.red); //any Color you want
        newGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //smoother strokes in graph lines
        //draw the lines together (note: dot is not plotted)
        for (int i = 0; i < dataPointsOnGraph.size() - 1; i++) {
            if (i + 1 == yAxisValues.size())
                newGraphics.setColor(Color.green);
            newGraphics.drawLine(dataPointsOnGraph.get(i).x,
                    dataPointsOnGraph.get(i).y,
                    dataPointsOnGraph.get(i + 1).x,
                    dataPointsOnGraph.get(i + 1).y);
            //System.out.println(dataPointsOnGraph.get(i).x + "    " + dataPointsOnGraph.get(i).y);
        }
        if(secondYAxisValues != null) {
            List<Point> dataPointsOnGraph2 = IntStream.range(0, newYAxisValues == null ? yAxisValues.size() : newYAxisValues.size())
                    .mapToObj(i -> new Point(
                            (int) (i * (((double) getWidth() - (2 * spaceBetweenGraphAndForm) - spaceBetweenLabelAndForm) / ((newYAxisValues == null ? yAxisValues.size() : newYAxisValues.size()) - 1)) + spaceBetweenGraphAndForm + spaceBetweenLabelAndForm),
                            (int) ((Collections.max(secondYAxisValues) - secondYAxisValues.get(i)) * (((double) getHeight() - 2 * spaceBetweenGraphAndForm - spaceBetweenLabelAndForm) / (Collections.max(secondYAxisValues) - Collections.min(yAxisValues))) + spaceBetweenGraphAndForm))).collect(Collectors.toList());
            newGraphics.setColor(Color.blue); //any Color you want
            //draw the lines together (note: dot is not plotted)
            //System.out.println(dataPointsOnGraph.get(i).x + "    " + dataPointsOnGraph.get(i).y);
            IntStream.range(0, dataPointsOnGraph2.size() - 1).forEach(i -> {
                newGraphics.drawLine(dataPointsOnGraph2.get(i).x,
                        dataPointsOnGraph2.get(i).y,
                        dataPointsOnGraph2.get(i + 1).x,
                        dataPointsOnGraph2.get(i + 1).y);
            });
        }
        //endregion
    }

    public void predict(int weeks)
    {
        weeks = weeks * 7;
        List<Double> temp = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        int lastDate;
        boolean differentDelimiter = false;
        try {
            String month = xAxisValues.get(xAxisValues.size() - 1).split("/")[1];
            String year = xAxisValues.get(xAxisValues.size() - 1).split("/")[2];
            lastDate = Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("/")[0]) + (Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("/")[1]) * 30) + (Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("/")[2]) * 365);
            differentDelimiter = true;
            int j = 0;
            for (int i = 0; i < xAxisValues.size(); i++) {
                String s = xAxisValues.get(i);
                if (Objects.equals(s.split("/")[1], month) && Objects.equals(s.split("/")[2], year)) {
                    x.add((double) j++);
                    y.add(yAxisValues.get(i));
                }
            }
        }catch (Exception e)
        {
            String month = xAxisValues.get(xAxisValues.size() - 1).split("-")[1];
            String year = xAxisValues.get(xAxisValues.size() - 1).split("-")[0];
            lastDate = Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("-")[2]) + (Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("-")[1]) * 30) + (Integer.parseInt(xAxisValues.get(xAxisValues.size() - 1).split("-")[0]) * 365);

            int j = 0;
            for (int i = 0; i < xAxisValues.size(); i++) {
                String s = xAxisValues.get(i);
                if (Objects.equals(s.split("-")[1], month) && Objects.equals(s.split("-")[0], year)) {
                    x.add((double) j++);
                    y.add(yAxisValues.get(i));
                }
            }
        }


        for (int i = 1; i <= weeks; i++)
        {
            temp.add(Math.max(0,linearRegression(x,y,Collections.max(x) + i)));
            int b = lastDate + i;
            int year = (b/365);
            int month = (b%365)/30;
            int day = (b%365)%30;
            if(differentDelimiter)
                temp2.add(day+"/"+month+"/"+year);
            else
                temp2.add(year+"-"+month+"-"+day);

        }
        newYAxisValues = Stream.concat(yAxisValues.stream(), temp.stream())
                .collect(Collectors.toList());
        newXAxisValues = Stream.concat(xAxisValues.stream(), temp2.stream())
                .collect(Collectors.toList());
    }

    public double linearRegression(List<Double> x, List<Double> y,double predictionFor){
        double sumOfX = x.stream().mapToDouble(Double::doubleValue).sum();
        double sumOfY = y.stream().mapToDouble(Double::doubleValue).sum();
        double meanOfSumOfX = sumOfX / x.size();
        double meanOfSumOfY = sumOfY / x.size();
        double sumOfZxZy = IntStream.range(0, x.size()).mapToDouble(i -> (x.get(i) - meanOfSumOfX) * (y.get(i) - meanOfSumOfY)).sum();
        double SumOfXMinusXMean = x.stream().mapToDouble(aDouble -> Math.pow((aDouble - meanOfSumOfX), 2)).sum();
        double slope = sumOfZxZy / SumOfXMinusXMean;
        double intercept = meanOfSumOfY - (slope * meanOfSumOfX);
        return intercept + (slope  * predictionFor);

    }
}
package MVPv3.src.main.java;


import MVPv2.GraphApp;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

// testing for adding pdf functionality

public class GUIWindow extends JFrame {
    public String graphDisplayCB = "New Cases";

    public GUIWindow() throws FileNotFoundException {
        List<String> date = new ArrayList<>();
        List<Double> dailyCases = new ArrayList<>();
        List<Double> dailyDeaths = new ArrayList<>();
        List<Double> cumulativeCases = new ArrayList<>();
        List<Double> cumulativeDeaths = new ArrayList<>();

        Scanner sc = new Scanner(new File("allData-29Nov.csv"));
        if(sc.hasNextLine())
            sc.nextLine();
        while (sc.hasNextLine()) {
            String[] tempArr = sc.nextLine().split(",");
            //System.out.println(Arrays.toString(tempArr));
            date.add(tempArr[0]);
            dailyCases.add(Double.valueOf(tempArr[1]));
            cumulativeCases.add(Double.valueOf(tempArr[2]));
            dailyDeaths.add(Double.valueOf(tempArr[3]));
            cumulativeDeaths.add(Double.valueOf(tempArr[4]));
        }

        Collections.reverse(date);
        Collections.reverse(dailyCases);
        Collections.reverse(cumulativeCases);
        Collections.reverse(dailyDeaths);
        Collections.reverse(cumulativeDeaths);

        // sets App thumbnail in taskbar
        ImageIcon NHSLogo = new ImageIcon("nhslogo.png");
        setIconImage(NHSLogo.getImage());

        // Logo Panel
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0,122,194));
        JLabel NHSLogoNB = new JLabel(new ImageIcon("nhslogonobackground.png"));
        logoPanel.add(NHSLogoNB);
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(logoPanel, BorderLayout.NORTH);

        // Graph Panel
        JPanel graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout((new FlowLayout(FlowLayout.RIGHT)));
        graphPanel.add(buttonPanel, BorderLayout.NORTH);
        String[] displayChoice = {"New Cases", "New Deaths", "New Cases & Deaths", "Cumulative Cases", "Cumulative Deaths", "Cumulative Cases & Deaths"};
        JComboBox<String> choiceComboBox = new JComboBox<>(displayChoice);
        buttonPanel.add(choiceComboBox);
        JButton btnUpdate = new JButton("Update Graph");
        buttonPanel.add(btnUpdate);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,9,0,20));
        inputPanel.setPreferredSize(new Dimension(30, 130));

        JLabel blankLabel = new JLabel();
        inputPanel.add(blankLabel);

        JLabel displayLabel = new JLabel("Display:");
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputPanel.add(displayLabel);
        String[] displayOptions = {"All Time", "Next 2 Weeks", "Next 4 Weeks", "Next 6 Weeks"};
        JComboBox<String> displayComboBox = new JComboBox<>(displayOptions);
        inputPanel.add(displayComboBox);

        JLabel blankLabel2 = new JLabel();
        inputPanel.add(blankLabel2);

        JButton toPDFButton = new JButton("Convert to PDF");
        inputPanel.add(toPDFButton);

        JLabel blankLabel3 = new JLabel();
        inputPanel.add(blankLabel3);

        JLabel algorithmLabel = new JLabel("Algorithm:");
        algorithmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputPanel.add(algorithmLabel);
        String[] algorithmOptions = {"Linear Regression", "Logistic Regression", "Support Vector Machines"};
        JComboBox<String> algorithmComboBox = new JComboBox<>(algorithmOptions);
        inputPanel.add(algorithmComboBox);

        JLabel blankLabel4 = new JLabel();
        inputPanel.add(blankLabel4);
        JLabel blankLabel5 = new JLabel();
        inputPanel.add(blankLabel5);

        JButton highlightHighWeek = new JButton("Highlight Highest Week");
        inputPanel.add(highlightHighWeek);
        JButton highlightLowWeek = new JButton("Highlight Lowest Week");
        inputPanel.add(highlightLowWeek);

        JLabel blankLabel6 = new JLabel();
        inputPanel.add(blankLabel6);
        JLabel blankLabel7 = new JLabel();
        inputPanel.add(blankLabel7);
        JLabel blankLabel8 = new JLabel();
        inputPanel.add(blankLabel8);

        JCheckBox accessibleViewCheckBox = new JCheckBox();
        accessibleViewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
        inputPanel.add(accessibleViewCheckBox);
        JLabel accessibleLabel = new JLabel("Accessible View");
        inputPanel.add(accessibleLabel);

        // Action Listeners

        btnUpdate.addActionListener(e -> {
            int noOfWeeks = 0;

            if (displayComboBox.getSelectedIndex() == 0){noOfWeeks = 0;}
            else if (displayComboBox.getSelectedIndex() == 1){noOfWeeks = 2;}
            else if (displayComboBox.getSelectedIndex() == 2){noOfWeeks = 4;}
            else if (displayComboBox.getSelectedIndex() == 3){noOfWeeks = 6;}

            if (choiceComboBox.getSelectedIndex() == 0){
                graphPanel.removeAll();
                graphPanel.add(choiceComboBox);
                graphPanel.add(btnUpdate);
                GraphApp graphOutput = new GraphApp(dailyCases, date, noOfWeeks);
                graphPanel.add(graphOutput);
                graphPanel.updateUI();
            }

            if (choiceComboBox.getSelectedIndex() == 1) {
                graphPanel.removeAll();
                graphPanel.add(choiceComboBox);
                graphPanel.add(btnUpdate);
                GraphApp graphOutput = new GraphApp(dailyDeaths, date,noOfWeeks);
                graphPanel.add(graphOutput);
                graphPanel.updateUI();
            }


            if (choiceComboBox.getSelectedIndex() == 2){
                System.out.println("New Cases & Deaths");
                graphPanel.removeAll();
                graphPanel.add(choiceComboBox);
                graphPanel.add(btnUpdate);
                GraphApp graphOutput = new GraphApp(dailyCases, date,dailyDeaths,noOfWeeks);
                graphPanel.add(graphOutput);
                graphPanel.updateUI();
            }

            if (choiceComboBox.getSelectedIndex() == 3){
                graphPanel.removeAll();
                graphPanel.add(choiceComboBox);
                graphPanel.add(btnUpdate);
                GraphApp graphOutput = new GraphApp(cumulativeCases, date,noOfWeeks);
                graphPanel.add(graphOutput);
                graphPanel.updateUI();
            }

            if (choiceComboBox.getSelectedIndex() == 4){
                System.out.println("Cumulative Deaths");
                graphPanel.removeAll();
                graphPanel.add(choiceComboBox);
                graphPanel.add(btnUpdate);
                GraphApp graphOutput = new GraphApp(cumulativeDeaths, date,noOfWeeks);
                graphPanel.add(graphOutput);
                graphPanel.updateUI();
            }

            if (choiceComboBox.getSelectedIndex() == 5){
                System.out.println("Cumulative Cases & Deaths");
            }

        });


        toPDFButton.addActionListener(e -> {
            PdfWriter writer = null;
            try {
                writer = new PdfWriter("/MVPv3/src/main/java/CE201Output.pdf");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph("Hello World!"));
            document.close();
        });


        add(graphPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws FileNotFoundException {
        GUIWindow GUI = new GUIWindow();

        GUI.setTitle("NHS Covid-19 App");
        GUI.setSize(1600,1000);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);





    }
}

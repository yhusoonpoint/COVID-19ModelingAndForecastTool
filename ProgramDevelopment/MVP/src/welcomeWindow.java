package MVP.src;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class welcomeWindow extends JFrame {
    public welcomeWindow(){
        // Image Icon
        ImageIcon NHSLogo = new ImageIcon("nhslogo.png");
        setIconImage(NHSLogo.getImage());

        // Logo Panel
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0,122,194));

        JLabel NHSLogoNB = new JLabel(new ImageIcon("nhslogonobackground.png"));
        logoPanel.add(NHSLogoNB);
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        add(logoPanel, BorderLayout.NORTH);

        // Graph Panel
        JPanel graphPanel = new JPanel();
        graphPanel.setBackground(new Color(0,122,194));

        add(graphPanel, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0,122,194));

        JLabel timeFrameLabel = new JLabel("How many weeks do you want to forecast");
        timeFrameLabel.setForeground(Color.WHITE);
        String[] timeFrameOptions = {"2 Weeks", "4 Weeks", "6 Weeks"};
        JComboBox<String> timeFrameDrop = new JComboBox<>(timeFrameOptions);

        JLabel infoDisplayedLabel = new JLabel("Select what data you want to be displayed");
        infoDisplayedLabel.setForeground(Color.WHITE);
        String[] infoDisplayedOptions = {"Cases", "Deaths", "Both"};
        JComboBox<String> infoDisplayedDrop = new JComboBox<>(infoDisplayedOptions);

        JButton display = new JButton("Display Graph");

        inputPanel.add(timeFrameLabel);
        inputPanel.add(timeFrameDrop);
        inputPanel.add(infoDisplayedLabel);
        inputPanel.add(infoDisplayedDrop);
        inputPanel.add(display);

        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws FileNotFoundException {
        welcomeWindow welcomeFrame = new welcomeWindow();

        java.util.List<Double> cumCasesBySpecimenDate = new ArrayList<>();
        java.util.List<String> date = new ArrayList<>();
        List<Double> newCasesBySpecimenDate = new ArrayList<>();

        Scanner sc = new Scanner(new File("MVP/src/test.csv"));
        if(sc.hasNextLine())
            sc.nextLine();
        while (sc.hasNextLine())
        {
            String[] tempArr = sc.nextLine().split(",");
            cumCasesBySpecimenDate.add(Double.valueOf(tempArr[4]));
            date.add(tempArr[3]);
            //newCasesBySpecimenDate.add(Double.valueOf(tempArr[3]));

        }
        List<Double> y = date.stream().mapToDouble(s -> (Double.parseDouble(s.split("-")[0]) * 365) + (Double.parseDouble(s.split("-")[1]) * 30) + (Double.parseDouble(s.split("-")[2])))
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(cumCasesBySpecimenDate);
        Collections.reverse(date);
        Collections.reverse(y);
        Collections.reverse(newCasesBySpecimenDate);

        System.out.println(y);
        GraphDrawer graphDrawer = new GraphDrawer(cumCasesBySpecimenDate, date, y);
        welcomeFrame.add(graphDrawer,BorderLayout.CENTER);
        graphDrawer.setBackground(new Color(0,122,194));


        welcomeFrame.setTitle("NHS Covid-19 App");
        welcomeFrame.setSize(1500,900 );
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);
    }

}

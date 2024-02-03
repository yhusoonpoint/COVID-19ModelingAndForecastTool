# Test Report

## Testing Performed
| Test ID | Test Case | Expected | Actual | Result | Comments |
|---------|-----------|----------|--------|--------|----------|
|1|Initial Window|All the buttons should be displayed and the NHS logo but no graph should be displayed.|I ran the code and the window opened up with all the buttons, NHS logo at the top, and dropdown boxes. There was no graph as expected.|Pass|Image 1 below shows the initial window.|
|2|Drop down box to Select the information Displayed|There should be 6 options to choose from: 1.New Cases 2.New Deaths 3.New Cases & Deaths 4.Cumulative Cases 5.Cumulative Deaths 6.Cumulative Cases & Deaths. Each of these options should display a different graph.|There are 6 options appear at the top to choose and as you scroll down the options show up. I tested all the 6 options and the graph updated accordingly to display the desired option selected.|Pass|Images 2, 3 and 4 show the options New Cases, New Deaths, New Cases & Deaths selected, and the graph updated. Image 5 shows all the 6 options displayed and the option Cumulative Cases & Deaths selected, and the graph is updated.|
|3|Update Graph button|When clicked on the button the graph should be updated to the desired options that the user has selected.|The graph updates with all the options available. I have tested various different possible options and every option works as the graph updates accordingly.|Pass|Images 2, 3, 4, 5, 10, 11, 12, 13, 14, 15 and 16 show the button works as all the graphs are updated when the desired option is selected.|
|4|Create PDF button|This button should display a save as option so it can save anywhere on the user’s computer. The PDF should be created and saved to the users desired location on the computer.|When clicked on the button the save as option is displayed and I chose to save it on my desktop. The PDF was created and saved to the desktop with the file name as COVID-Report.pdf so it is in the correct format. I opened the PDF file, and the desired graph is saved.|Pass|Images 6 and 7 show that the PDF is created and saved on the desktop. Image 8 shows the graph once the pdf is opened.|
|5|Display Data From dropdown box|There should be 9 options in the dropdown box which are: 1)All data 2)2 weeks 3)4 Weeks 4)6 Weeks 5)8 weeks 6)10 Weeks 7)3 Months 8)6 Months 9)1 Year The graph should only display the option selected so for example if the option 2 weeks has been selected then the graph must only display data for 2 weeks.|All 9 options display in the dropdown box or can scroll to see options one by one. I have tested the 9 options and the data is displayed only for the selected option. I have tested this along with the Select the Information displayed button so for the New Cases & deaths as well as Cumulative Cases & Deaths. All the options work and the graph updates and displays correctly.|Pass|Image 9 shows all the options are displayed and the first option was chosen so all the data is displayed. The options display at the top near the NHS logo but this is due to the screen size. However, on a larger screen the dropdown box is formatted correctly.|
|6|Prediction Length dropdown box|The dropdown box should display 4 options: 1.None 2.Next 2 Weeks 3.Next 4 Weeks 4.Next 6 Weeks When any of the 4 options is selected the graph should draw a green line for the prediction.|All 4 options are available in the dropdown box, and I have tested all the options. The graph correctly predicts with a green line. I have also tested by changing the information to display to New Cases & Deaths and also for Cumulative Cases & Deaths, as expected the graph updates and predicts.|Pass|Image 10 shows the prediction for the next 2 weeks. The options display at the top near the NHS logo but this is due to the screen size.However, on a larger screen the dropdown box is formatted correctly|
|7|Algorithm dropdown box|There should be 3 options: 1.Linear Regression 2.Logistic regression 3. Support Vector Machines|The 3 options are displayed in the dropdown box, and I have tested all 3 options. The graph updates and displays the graph according to the selected option.|Pass|Image 11 shows linear regression graph. Image 12 shows logistic regression graph and image 13 shows the support vector machines graph.The options display at the top near the NHS logo but this is due to the screen size. However, on a larger screen the dropdown box is formatted correctly.|
|8|Highlight Highest Date checkbox|The highest week on the graph should be pinpointed in the colour green|I clicked on the box next to the Highlight Highest Date and a blue tick shows up on the box. I clicked on the update graph button and the highest date was pinpointed in the colour green.|Pass|Image 14 shows the highest date highlighted on the graph.|
|9|Highlight Lowest Date checkbox|The lowest week on the graph should be pinpointed in the colour purple and a blue tick should appear in the box when clicked on it.|I performed the exact same test as the Highlight Highest Date for the Highlight Lowest Date checkbox and as expected the blue tick appears once the box has been checked and once the graph has been updated the lowest date is pinpointed in the colour purple. Moreover, the date of highest and lowest is displayed on the graph and the number of new cases at the highest date and lowest date.If the option New Cases & Deaths is chosen, then highest and lowest date is highlighted on the new cases line graph separately to the new deaths line graph, so each line graph is highlighted.|Pass|Image 15 shows the lowest date highlighted on the graph.Image 16 shows both the highest and lowest date highlighted on the graph with a prediction. The highlighted points overlap as they are in the same place or very close to each other. However, this would not be an issue on a larger screen|
|10|Accessible View|||Pass|Image 17 shows the accessible view window.|

### Screenshots 
**Image 1:** The image below shows the inital window that the user sees once the program has ben run. 
![](/FinalProduct/ProductTestingImages/Image_1.png)

**Image 2:** The image below shows the graph displayed when the new cases option is selected. 
![](/FinalProduct/ProductTestingImages/Image_2.png)

**Image 3:** The image below shows the graph dispalyed when the new deaths option is selected. 
![](/FinalProduct/ProductTestingImages/Image_3.png)

**Image 4:** The image below shows the graph dispalyed when the new cases & deaths option is selected. 
![](/FinalProduct/ProductTestingImages/Image_4.png)

**Image 5:** The image below shows the graph dispalyed when the cumulative cases & deaths option is selected as well as the 6 options in the dropdown box.
![](/FinalProduct/ProductTestingImages/Image_5.png)

**Image 6:** The image below shows the save as window that appears once the 'Create PDF' button is clicked. 
![](/FinalProduct/ProductTestingImages/Image_6.png)

**Image 7:** The image below shows the PDF file has been created and saved to the desktop.  
![](/FinalProduct/ProductTestingImages/Image_7.png)

**Image 8:** The image below shows the graph dispalyed when the PDF file is opened which was the graph the user selected when clciking on the 'Create PDF' button. 
![](/FinalProduct/ProductTestingImages/Image_8.png)

**Image 9:** The image below shows the 4 options displayed for the 'Display Date From:' dropdown box. 
![](/FinalProduct/ProductTestingImages/Image_9.png)

**Image 10:** The image below shows the graph dispalyed when the option new cases & the prediction length is for the next 2 weeks. The 4 options for the predition length are displayed. 
![](/FinalProduct/ProductTestingImages/Image_10.png)

**Image 11:** The image below shows the graph dispalyed with the options new cases, prediction length 2 weeks, display data from: 2 weeks and the algorithm slected is linear regression. The 3 options are also displayed for the Algorithm dropdown box. 
![](/FinalProduct/ProductTestingImages/Image_11.png)

**Image 12:** The image below shows the graph dispalyed with the options new cases, prediction length 2 weeks, display data from: 2 weeks and the algorithm slected is logistic regression. 
![](/FinalProduct/ProductTestingImages/Image_12.png)

**Image 13:** The image below shows the graph dispalyed with the options new cases, prediction length: 4 weeks, display data from: All Data, and the algorithm selected is Support vector machines. 
![](/FinalProduct/ProductTestingImages/Image_13.png)

**Image 14:** The image below shows the graph dispalyed when the new cases & deaths option is selected and the highest date is highlighted. 
![](/FinalProduct/ProductTestingImages/Image_14.png)

**Image 15:** The image below shows the graph dispalyed when the new cases & deaths option is selected and the lowest date is highlighted.
![](/FinalProduct/ProductTestingImages/Image_15.png)

**Image 16:** The image below shows the graph dispalyed when both the highest and lowest date are ticked. 
![](/FinalProduct/ProductTestingImages/Image_16.png)

**Image 17:** The image below shows the graph dispalyed when the accessible view option is selected with the highest and lowest date highlighted. 
![](/FinalProduct/ProductTestingImages/Image_17.png)

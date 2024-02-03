# Product Demonstration Report
## Project Summary
As a team we have managed to complete all the main tasks that were required for a successful project. We create visualisations of the COVID data, that was kept up to date using the latest government statistics. The user was also able to see forecasts for the next 2, 4 and 6 weeks as requested. The graph was displayed on the program GUI as well as the user having the option to create a PDF with the graph in.

We used CSEEGit and Jira to manage the collaborative working aspect of the project. We used Jira to assign and manage the tasks for each team member and ensure the project was on track for completion. We used CSEEGit, especially the branches feature, to ensure that we could all work on our own sections of the code before combining it into the final file.

## Product Demonstration
For the final product we switched to Python rather than Java, as we were originally using in the MVP version. We made this decision as we believed it allowed us to make the improvements we wanted in the most efficient and effective manner. We had to make some enforced changes to the GUI, however we did make some unenforced changed in order to make the GUI look cleaner and make it easier to use/understand for the user.

### Initial Window
The image below shows the initial window that the user sees upon starting the program. 
![InitialWindow1](ProductDemonstrationImages/InitialWindow1.png)
From the image above you can see all the different buttons and options the user has. The user has two buttons available:
1. Update Graph
2. Create PDF

The user has four dropdowns available to select different options from. These dropdowns are as follows:
1. Select the Information Displayed
2. Display Data From
3. Prediction Length
4. Algorithm

The user also has three checkboxes available to them, which are:
1. Highlight Highest Date
2. Highlight Lowest Date
3. Accessible View

The rest of the product demonstration will be split up based on these inputs.

### Buttons
##### Update Graph #####
The update graph button is used whenever the user wants a new graph to be displayed after they have changed any number of options. An example of a graph being displayed after the update graph button has been pressed is shown below.
![UpdateGraph1](ProductDemonstrationImages/UpdateGraph1.png)
The image above shows the resulting graph if the user presses the update graph with all the default options. The output when the options have been changed can be seen later on in the product demonstration report.

##### Create PDF #####
The create PDF button is used when the user wants to create a PDF version. When the user presses the button the save as window is displayed allowing the user to select the name and save location of the file. This is shown in the images below.
![CreatePDF1](ProductDemonstrationImages/CreatePDF1.png)
Save as window

![CreatePDF2](ProductDemonstrationImages/CreatePDF2.png)
File saved

![CreatePDF3](ProductDemonstrationImages/CreatePDF3.png)
What the PDF output looks like

### Dropdown Lists
All the images below have all the options set to the default except from the dropdown that is being demonstrated. This is so it is easy to distinguish what the actual effect of changing the given dropdown is.

##### Select the Information Displayed #####
The images below show the different graph outputs depending on the option selected in the Select the Information Displayed dropdown. The 6 options are as follows:
1. New Cases (Default)
2. New Deaths
3. New Cases & Deaths
4. Cumulative Cases
5. Cumulative Deaths
6. Cumulative Cases & Deaths
<!-- end of the list -->
1. New Cases (Default)
![InfoDisplayed1](ProductDemonstrationImages/InfoDisplayed1.png)


2. New Deaths
![InfoDisplayed2](ProductDemonstrationImages/InfoDisplayed2.png)


3. New Cases & Deaths
![InfoDisplayed3](ProductDemonstrationImages/InfoDisplayed3.png)


4. Cumulative Cases
![InfoDisplayed4](ProductDemonstrationImages/InfoDisplayed4.png)


5. Cumulative Deaths
![InfoDisplayed5](ProductDemonstrationImages/InfoDisplayed5.png)


6. Cumulative Cases & Deaths
![InfoDisplayed6](ProductDemonstrationImages/InfoDisplayed6.png)

The images above show one improvement that we could make to our code should we have more time to improve/develop it. The images of the graphs with two lines show that the scaling is not very good as one of the lines is almost flat which makes it hard to read. If we had more time we could improve this by either using a more suitable data set or use standardisation of logarithms.

##### Display Data From #####
The images below show the different graph outputs depending on the option selected in the Display Data From dropdown. The dropdown allows the user to decide how many week prior to the current date are displayed on the graph. For example if the current date is 07/04 and the user selects 2 weeks the data for the period 21/02 - 07/03 will be displayed. The 9 options are as follows:
1. All data (Default)
2. 2 Weeks
3. 4 Weeks
4. 6 Weeks
5. 8 Weeks
6. 10 Weeks
7. 3 Months
8. 6 Months
9. 1 Year
<!-- end of the list -->
1. All Data (Default)
![DisplayData1](ProductDemonstrationImages/DisplayData1.png)


2. 2 Weeks
![DisplayData2](ProductDemonstrationImages/DisplayData2.png)


3. 4 Weeks
![DisplayData3](ProductDemonstrationImages/DisplayData3.png)


4. 6 Weeks
![DisplayData4](ProductDemonstrationImages/DisplayData4.png)


5. 8 Weeks
![DisplayData5](ProductDemonstrationImages/DisplayData5.png)


6. 10 Weeks
![DisplayData6](ProductDemonstrationImages/DisplayData6.png)


7. 3 Months
![DisplayData7](ProductDemonstrationImages/DisplayData7.png)


8. 6 Months
![DisplayData8](ProductDemonstrationImages/DisplayData8.png)


9. 1 Year
![DisplayData9](ProductDemonstrationImages/DisplayData9.png)

##### Prediction Length #####
The prediction length dropdown allows the user to select the amount of time into the future that the prediction model will predict for. This dropdown will also is dependent on the Algorithm dropdown for what the line will actually look like (the examples below use the linear regression algorithm). The user has 4 options for this dropdown, which are:
1. None (Default)
2. 2 Weeks
3. 4 Weeks
4. 6 Weeks
<!-- end of the list -->
1. None (Default)
![PredictionLength1](ProductDemonstrationImages/PredictionLength1.png)


2. 2 Weeks
![PredictionLength2](ProductDemonstrationImages/PredictionLength2.png)


3. 4 Weeks
![PredictionLength3](ProductDemonstrationImages/PredictionLength3.png)


4. 6 Weeks
![PredictionLength4](ProductDemonstrationImages/PredictionLength4.png)

##### Algorithm #####
For the algorithm to input to have an effect on the graph displayed, the prediction length must not be set to none. Therefore, in the images below prediction length is set to 2 weeks, as opposed to being default as explained at the start of the dropdown lists section. The 3 options are:
1. Linear Regression (Default)
2. Logistic Regression
3. Support Vector Machines
<!-- end of the list -->
1. Linear Regression (Default)
![Algorithm1](ProductDemonstrationImages/Algorithm1.png)


2. Logistic Regression
![Algorithm2](ProductDemonstrationImages/Algorithm2.png)


3. Support Vector Machines
![Algorithm3](ProductDemonstrationImages/Algorithm3.png)

 
The images above show that there are many improvements that we could still make to the program should we have more time to complete it. At the moment only the linear regression model works as intended and that does not give us the most accurate prediction of the future data. Also, we were unable to get the other two prediction models to work as intended.

### Checkboxes
The checkboxes allowed the user a few more options when creating their graph. These options were made checkboxes as they could either been displayed or not displayed (there was no other information required).

##### Highlight Highest Date #####
When the Highlight Highest Date checkbox is selected, the point of the date with the highest value will be highlighted with a green dot. A label is also added displaying the date and value from that date. 

![HighlightHighest1](ProductDemonstrationImages/HighlightHighest1.png)
Highlight Highest Date on graph with one line

![HighlightHighest2](ProductDemonstrationImages/HighlightHighest2.png)
Highlight Highest Date on graph with two lines


##### Highlight Lowest Date #####
When the Highlight Lowest Date checkbox is selected, the point of the date with the lowest value will be highlighted with a purple dot. A label is also added displaying the date and value from that date. 

![HighlightLowest1](ProductDemonstrationImages/HighlightLowest1.png)
Highlight Lowest Date on graph with one line

![HighlightLowest2](ProductDemonstrationImages/HighlightLowest2.png)
Highlight Lowest Date on graph with two lines

The images for the Highlight Lowest Date show some more improvements that could be made to our code should we make improvements/developments in the future. At the moment due to the lowest value for both lines being 0 on the same date the labels overlap, so to improve this we could ensure that only on label is added if both the date and value is the same.

##### Highlight Highest & Lowest #####
When both the Highlight Highest and Lowest Date checkboxes are selected, both points will be highlighted the same way as they are individually above.

![HighlightHighAndLow1](ProductDemonstrationImages/HighlightHighAndLow1.png)
Highlight Highest and Lowest Date on graph with one line

![HighlightHighAndLow2](ProductDemonstrationImages/HighlightHighAndLow2.png)
Highlight Highest and Lowest Date on graph with two lines

##### Accessible View #####
The accessible view was an important feature that we wanted to add to our program. We wanted to add this in order to allow people with colour blindness to use our program. The accessible view changes one of the line to a dashed line from a solid line, allowing someone with colour blindness to be able to see the different lines clearer. The accessible view only makes a difference to the graph if there is multiple lines being displayed. If the graph only has one line this input will have no effect on the output displayed.

![AccessibleView1](ProductDemonstrationImages/AccessibleView1.png)
Accessible view used on the New Deaths and Cases graph

### Other Features
##### Auto-Updating Data File #####
The other main feature of our program was the automatic updating of the COVID data file. The NHS website automatically updates the COVID data file daily (except from weekends), and you can use a link to download the up-to-date COVID file. We implemented some code that automatically downloaded the data file from this link and then saved it with the same name and location everytime so that it could always be found by the program.

![AutoFile1](ProductDemonstrationImages/AutoFile1.png)
The code for getting and downloading the file

![AutoFile2](ProductDemonstrationImages/AutoFile2.png)
The resulting file. This was downloaded on 08/03/2022 (the data only goes to the previous day for obvious reasons).

## Highlights of our Program
1. Accessible View feature - We are very happy with the implementation of an accessible view feature into our program. We are proud of this feature as it allows everyone to use the program, even if they may have vision difficulties that may have prevented them otherwise.
![AccessibleView1](ProductDemonstrationImages/AccessibleView1.png)
2. Auto Update File feature - The auto update file feature is particularly important to the program as it allows the user to see up-to-date information without them needing to download the latest file manually everytime. An example file is shown in the image below
![AutoFile2](ProductDemonstrationImages/AutoFile2.png)
3. Create PDF feature - The create PDF feature allows the user to create a PDF file containing the graph and save it with a name and location of their choice. This will also allow the user to print the graph if necessary. An example graph output is shown below:
![CreatePDF4](ProductDemonstrationImages/CreatePDF4.png)

## Did we make all the Improvements Suggested in the MVP?
| Improvement Suggested        | Was it Implemented? | What did we do & Did it Work                                                                                                                                                                                                                                                                                                                          |
|------------------------------|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Improve the Prediction Model | Unsuccessfully      | We tried to implement different prediction models as the linear regression model was inaccurate as mentioned in the MVP documentation. Although we added additional prediction methods, we were unable to get them to work successfully. Also, we did not have enough time to research and implement causal analysis.                                 |
| Export Image of Graph to PDF | Yes                 | We were able to implement a method that created a PDF document containing the image of the graph, as suggested in the improvements for the MVP.                                                                                                                                                                                                       |
| Add Functionality to Buttons | Yes                 | This improvement was made successfully as we were able to add functionality to all of the buttons. All of the buttons now work as expected allowing the user to use the program without issues.                                                                                                                                                       |
| 2 Lines on the Same Graph    | Yes, partially      | We fixed the issue of the scaling of the axis when there was multiple lines displayed on the same graph. However, in doing this we noticed another issue that the deaths line was almost flat due to the huge difference in value compared to cases. Therefore to improve this we either need to find a more appropriate data set or format the data. |
| Use Live Data                | Yes                 | A function was added that downloads the up-to-date data file from the link and saves it to the same location with the same name everytime. This function is called at the start of the program, so that the data file is always up to date.                                                                                                           |


## Future Improvements 
1. Improve Data Used (2 Lines on the same graph) - The deaths line on the graphs with two lines is almost flat which makes it hard to read and compare the data. If we had more time we could improve this by either using a more suitable data set or use standardisation of logarithms.
2. Prediction Models - Although this was suggested as one of our MVP improvements, we were unable to successfully implement more suitable prediction models. At the moment only the linear regression model works as intended and that does not give us the most accurate prediction of the future data. Also, if we had more time we could do some research into causal analysis and look at how that could potentially be implemented.
3. Overlapping Text Highest/Lowest Date - Currently some labels for the highest and lowest date overlap, particularly when there is multiple lines on the graph. To improve this we could ensure that the labels do not overlap so that the user can read them.








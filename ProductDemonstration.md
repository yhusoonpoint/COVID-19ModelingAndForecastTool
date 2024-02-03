# Product Demonstration Report

## Project Summary
We aim to fulfil the requests of the data analytics department of the NHS. They asked us to analyse COVID-19 data regarding the daily infections and deaths. From this we were requested to build develop a forecast via a computer system of infections over upcoming weeks. Here is a breakdown of how it went:

1. For team work purposes, we linked our gitlab and intellij together to code graph. 

![git](/uploads/c1284617cfd7cfcb7520f2236486cf72/git.png)

2. We generated NHS files to implement our graph
3. Created pseudocode to code
4. Code

## Product Demonstration

### Dropdown Lists
Dropdown 1: Allows the user to select what information they want to be displayed on the graph

![Dropdown1](demoimages/button.png) 



Dropdown 2: Allows the user to select how many weeks (0, 2, 4 or 6 weeks) they want to be predicted/forecast.

![Dropdown2](/uploads/a58f43773628fd1ab381e40044647b14/button2.png)



Dropdown 3: The user can select what prediction algorithm is used to predict/forecast the data.

![Dropdown3](/uploads/f80a9bd427b59f8b7bca18a28e0f172a/button3.png) 


### Buttons

Result of update button, based on the user selection, as described above the image.This section includes screenshots of all case types with against all time periods. The update button generate the graph based on the users selection:

![update_button](/uploads/4cddf7035b7862975a71acc52e6abd13/update_button.png)

<br>
Case Type: New Cases &nbsp; &nbsp; Time Period: All time

![image](/uploads/93abce9111917e435aeb47b1eb8392d4/image.png)

<br><br><br>
Case Type: New Cases &nbsp; &nbsp; Time Period: 2 Weeks

![image](/uploads/292aed6389158c2341ad618913a1829f/image.png)

<br><br><br>
Case Type: New Cases &nbsp; &nbsp; Time Period: 4 Weeks

![image](/uploads/a3bac311e9004fd7578b8569772f2e3e/image.png)

<br><br><br>
Case Type: New Cases &nbsp; &nbsp; Time Period: 6 Weeks

![image](/uploads/84e4e4412f6463c0433b53814848e42b/image.png)

<br><br><br>
Case Type: New Deaths &nbsp; &nbsp; Time Period: All time

![image](/uploads/18ab889b81a08b4e3531b43d3003ee4e/image.png)

<br><br><br>
Case Type: New Deaths &nbsp; &nbsp; Time Period: 2 Weeks

![image](/uploads/eb2ffc5bf7eab44f391fe6093e0b27f4/image.png)

<br><br><br>
Case Type: New Deaths &nbsp; &nbsp; Time Period: 4 Weeks

![image](/uploads/a20bae887734a190898c51f518c8c70e/image.png)

<br><br><br>
Case Type: New Deaths &nbsp; &nbsp; Time Period: 6 Weeks

![image](/uploads/78609959bb26b2fb07665ff488fedf45/image.png)

<br><br><br>
Case Type: New Cases and Deaths &nbsp; &nbsp; Time Period: All Time (There is only all time for New Cases and Deaths as we were unable to get the prediction model to work for a graph with multiple lines)

![image](/uploads/f5ffc398da8a2b2a16a5c6d3c2e77438/image.png)

<br><br><br>
Case Type: Cumulative cases &nbsp; &nbsp; Time Period: All time
![image](/uploads/6b37477e57a5a00d71295ac9ff16d743/image.png)

<br><br><br>
Case Type: Cumulative cases &nbsp; &nbsp; Time Period: 2 Weeks
![image](/uploads/20c1ba28db055a94bcfafa5914f2c0e4/image.png)

<br><br><br>
Case Type: Cumulative cases &nbsp; &nbsp; Time Period: 4 Weeks
![image](/uploads/22ae985562d6abe973e20a651b0c7a44/image.png)

<br><br><br>
Case Type: Cumulative cases &nbsp; &nbsp; Time Period: 6 Weeks
![image](/uploads/2cccf933e297a83d28910ca5d74db582/image.png)

<br><br><br>
Case Type: Cumulative Deaths &nbsp; &nbsp; Time Period: All time
![image](/uploads/7bd7076912c24f912193a807e11eb4bd/image.png)

<br><br><br>
Case Type: Cumulative Deaths &nbsp; &nbsp; Time Period: 2 Weeks
![image](/uploads/0dda8f497f552151f895863a57bc55a7/image.png)

<br><br><br>
Case Type: Cumulative Death: &nbsp; &nbsp; Time Period: 4 Weeks
![image](/uploads/4f4e717db98cc6c3d3413c13f2020bdb/image.png)

<br><br><br>
Case Type: Cumulative Deaths &nbsp; &nbsp; Time Period: 6 Weeks
![image](/uploads/8954eb4839f6d586f741b29c95f80f56/image.png)

<br><br><br>
Case Type: Cumulative Cases and Deaths &nbsp; &nbsp; Time Period: All time (There is only all time for New Cases and Deaths as we were unable to get the prediction model to work for a graph with multiple lines)

![image](/uploads/b957ebf0881def8b1c26a1479baf18d1/image.png)

<br><br><br>
The image below is of the Convert to PDF button.

![](/demoimages/PDFbutton.png)

When the user presses this button the PDF document is created, as shown below:

![](/demoimages/PDFoutput.png)

## Highlights of Our Program
There are particular features of the graph that we are all proud of. The 'update graph' button is a one of the most important features of the graph, it also works well:
![update_button](/uploads/4cddf7035b7862975a71acc52e6abd13/update_button.png)

Another impressive feature is use of a red and blue line in the 'New Cases and deaths' against 'all time' which shows the difference beteewen them clearly:
![image](/uploads/f5ffc398da8a2b2a16a5c6d3c2e77438/image.png)

## Improvements
There are many improvements that we could make to our program, but some of the main ones are:

1. Improve the prediction model - Currently we use linear regression for our prediction model, however this only results in an inaccurate prediction. For the next stage of the project we will try to develop/use a more accurate prediction model. One idea we had was to research causal analysis, as this would provided a link between the causes and effects in our predictions.

2. Export image of graph to PDF - Another improvement we could make is to the way the data/information is outputted on the created PDF file. Currently the PDF file contains a table with all the data that is stored in the CSV file used to create the graphs. To improve this we could output the graph generated by the user to the PDF, as well as only the data used to create that graph (rather than all the data stored in the CSV). We could also give the user the option to select exactly what they want to be displayed on the PDF file.

3. Add functionality to buttons - Some of the buttons currently do not have any functionality. For example, the highlight highest and highlight lowest buttons as well as the accessible view check box, do not currently work. The obvious improvement here would be to get these user input to perform the desired action.

4. 2 lines on the same graph - Although we have been able to get 2 lines to be displayed on the same graph there has some been some issues encounter which means that this functionality does not work as we wish. Currently the scaling of the graph is often only based of the first line as well as the second line often going below zero at points. We are also unable to get the prediction model to work on graphs with more than one line. We will try to fix these issues as part of the final product.

5. Use live data - Using live data would be a key improvement that would need to be made in our program. Using the live date would allow the user to see the most up to date data available, rather than the last set of data that had been downloaded. This would be key as otherwise the predictions and graphs would become outdatted.

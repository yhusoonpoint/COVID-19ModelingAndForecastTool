import platform
from tkinter import *
from tkinter import filedialog
import pandas as pd
import numpy as np
from PIL import ImageTk, Image
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
from statistics import mean
from datetime import datetime
import re
from datetime import timedelta
from urllib import request

from sklearn import svm
from sklearn.linear_model import LogisticRegression


# file link to try for live update:  https://api.coronavirus.data.gov.uk/v2/data?areaType=overview&metric=
# cumCasesByPublishDate&metric=cumDeaths28DaysByPublishDate&metric=newCasesByPublishDate&metric=newDeaths28DaysByPublishDate&format=csv

# all keys needed 'date', 'cumCasesByPublishDate',
#        'cumDeaths28DaysByPublishDate', 'newCasesByPublishDate',
#        'newDeaths28DaysByPublishDate'

def linear_regression(y, valueToPredict):
    x = [i for i in range(1, len(y) + 1)]
    y.reverse()
    slope = sum((int(x[i]) - mean(x)) * (int(y[i]) - mean(y)) for i in range(0, len(x))) / sum(pow((int(i) - mean(x)),
                                                                                                   2) for i in x)
    interception = mean(y) - (slope * mean(x))
    return slope * valueToPredict + interception


def support_vector_machine_prediction(y, howManyWeeks):
    x = np.arange(len(y)).reshape(-1, 1)
    y1 = []
    for i in y:
        y1.append(i)
    y1.reverse()
    y = y1
    y = np.array(y)

    clf = svm.SVC(decision_function_shape='ovr')
    clf.fit(x, y)
    clf.decision_function([[1]])

    predictY = np.array([len(y) + i for i in range(0, (howManyWeeks * 7))]).reshape(-1, 1)
    return clf.predict(predictY)


def logistic_prediction(y, howManyWeeks):
    x = np.arange(len(y)).reshape(-1, 1)
    y1 = []
    for i in y:
        y1.append(i)
    y1.reverse()
    y = y1
    y = np.array(y)
    model = LogisticRegression(solver='liblinear', random_state=0).fit(x, y)
    predictY = np.array([len(y) + i for i in range(0, (howManyWeeks * 7))]).reshape(-1, 1)
    return model.predict(predictY)


def dates_addition(lastDate, howManyWeeks):
    output = []
    howManyWeeks = howManyWeeks * 7
    date = datetime.strptime(lastDate, '%Y-%m-%d')
    for i in range(0, howManyWeeks):
        date += timedelta(days=1)
        output.append(date.strftime('%Y-%m-%d'))
    output.reverse()
    return output


def linear_prediction(y, howManyWeeks):
    howManyWeeks = howManyWeeks * 7
    output = []
    for i in range(0, howManyWeeks):
        result = linear_regression([i for i in y[0:5]], 6 + i)
        output.append(0 if result < 0 else result)
    output.reverse()
    return output


def get_file():
    # This code is adapted from the code found in the link below:
    # https://gist.githubusercontent.com/BetterProgramming/783706e162704d534a3341b88ce67782/raw/a0be14ddf15f98670cf4727aa6750df2be860e20/urllibrequest.py
    url = 'https://api.coronavirus.data.gov.uk/v2/data?areaType=overview&metric=' \
                 'cumCasesByPublishDate&metric=cumDeaths28DaysByPublishDate&metric=newCasesByPublishDate&metric=' \
                 'newDeaths28DaysByPublishDate&format=csv'

    fileName = 'covid_date_file.csv'
    request.urlretrieve(url, fileName)


def update_graph(*args):
    colour1 = '-r'
    colour2 = '-b'
    if accessibleViewValue.get():
        colour2 = '--b'

    timePeriodToNrows = {'All data': [None, 50],
                         '2 Weeks': [14, 1],
                         '4 Weeks': [28, 2],
                         '6 Weeks': [42, 3],
                         '8 Weeks': [56, 4],
                         '10 Weeks': [70, 5],
                         '3 Months': [91, 6],
                         '6 Months': [183, 13],
                         '1 Year': [365, 26]}

    file = pd.read_csv("covid_date_file.csv", nrows=timePeriodToNrows[timeDataSelected.get()][0])

    dropdownToKey = {'New Cases': file['newCasesByPublishDate'],
                     'New Deaths': file['newDeaths28DaysByPublishDate'],
                     'New Cases & Deaths': [file['newCasesByPublishDate'], file['newDeaths28DaysByPublishDate']],
                     'Cumulative Cases': file['cumCasesByPublishDate'],
                     'Cumulative Deaths': file['cumDeaths28DaysByPublishDate'],
                     'Cumulative Cases & Deaths': [file['cumCasesByPublishDate'], file['cumDeaths28DaysByPublishDate']]}

    if platform.system() == "Windows":
        graphFig = Figure(figsize=(11, 6))

    else:
        graphFig = Figure(figsize=(15, 8))

    graph = graphFig.add_subplot(1, 1, 1)

    x = file['date']
    optionSelected = selectInfoOnGraph.get()
    duration = 0 if predictionLengthSelected.get() == "None" else int(re.search(r'\d+', predictionLengthSelected.get()).
                                                                      group())

    if optionSelected == "New Cases & Deaths" or optionSelected == "Cumulative Cases & Deaths":
        y1 = dropdownToKey[optionSelected][0]
        y2 = dropdownToKey[optionSelected][1]

        if duration != 0:
            if algorithmSelected.get() == "Linear Regression":
                for i in y1:
                    print(i)
                graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], linear_prediction(y1, duration)
                           + [y1[i] for i in range(0, 5)], '-y')
                graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], linear_prediction(y2, duration)
                           + [y2[i] for i in range(0, 5)], '-y')
            else:
                ou = []
                if algorithmSelected.get() == "Logistic Regression":
                    for i in logistic_prediction(y1, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y1[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], ou, '-y')
                    ou.clear()
                    for i in logistic_prediction(y2, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y2[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], ou, '-y')
                else:
                    for i in support_vector_machine_prediction(y1, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y1[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], ou, '-y')
                    for i in support_vector_machine_prediction(y2, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y1[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], ou, '-y')

        splitOption = optionSelected.split()
        graph.plot(x, y1, colour1)
        graph.plot(x, y2, colour2)
        if showHighestValue.get():
            graph.plot(x[y1.idxmax()], y1.max(), 'go')
            label1 = "Date:  " + x[y1.idxmax()] + "\nNumber of " + splitOption[0] + " Cases:  " + str(y1.max())
            graph.text(x[y1.idxmax()], (y1.max() + (y1.max() * 0.01)), label1, ha='center')
            graph.plot(x[y2.idxmax()], y2.max(), 'go')
            label2 = "Date:  " + x[y2.idxmax()] + "\nNumber of " + splitOption[0] + " Deaths:  " + str(y2.max())
            graph.text(x[y2.idxmax()], (y2.max() + (y2.max() * 0.01)), label2, ha='center')

        if showLowestValue.get():
            graph.plot(x[y1.idxmin()], y1.min(), c='mediumorchid', marker='o')
            label1 = "Date:  " + x[y1.idxmin()] + "\nNumber of " + splitOption[0] + " Cases:  " + str(y1.min())
            graph.text(x[y1.idxmin()], (y1.min() + (y1.min() * 0.01)), label1, ha='center')
            graph.plot(x[y2.idxmin()], y2.min(), c='mediumorchid', marker='o')
            label2 = "Date:  " + x[y2.idxmin()] + "\nNumber of " + splitOption[0] + " Deaths:  " + str(y2.min())
            graph.text(x[y2.idxmin()], (y2.min() + (y2.min() * 0.01)), label2, ha='center')

    else:
        y = dropdownToKey[optionSelected]

        if duration != 0:
            if algorithmSelected.get() == "Linear Regression":
                graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], linear_prediction(y, duration)
                           + [y[i] for i in range(0, 5)], '-y')
            else:
                if algorithmSelected.get() == "Logistic Regression":
                    ou = []
                    for i in logistic_prediction(y, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)],
                               ou, '-y')
                else:
                    ou = []
                    for i in support_vector_machine_prediction(y, duration):
                        ou.append(i)
                    for i in range(0, 5):
                        ou.append(y[i])
                    graph.plot(dates_addition(x[0], duration) + [x[i] for i in range(0, 5)], ou, '-y')

        graph.plot(x, y, colour1)
        if showHighestValue.get():
            graph.plot(x[y.idxmax()], y.max(), 'go')
            label = "Date:  " + x[y.idxmax()] + "\nNumber of " + optionSelected + ":  " + str(y.max())
            graph.text(x[y.idxmax()], (y.max() + (y.max() * 0.01)), label, ha='center')

        if showLowestValue.get():
            graph.plot(x[y.idxmin()], y.min(), c='mediumorchid', marker='o')
            label = "Date:  " + x[y.idxmin()] + "\nNumber of " + optionSelected + ":  " + str(y.min())
            graph.text(x[y.idxmin()], (y.min() + (y.min() * 0.01)), label, ha='center')

    graph.invert_xaxis()
    graph.set_xlabel("Date")
    graph.set_ylabel("Number of People")
    if platform.system() == "Windows":
        graph.set_xticks(np.arange(0, len(x) + (duration * 7) + 1, timePeriodToNrows[timeDataSelected.get()][
            1] * (duration / 6 + 1.5)))  # use to change number of ticks on x-axis
    else:
        graph.set_xticks(np.arange(0, len(x) + (duration * 7) + 1, timePeriodToNrows[timeDataSelected.get()][
            1]))  # use to change number of ticks on x-axis

    graphFig.tight_layout()
    graphAdd = FigureCanvasTkAgg(graphFig, mainWindow)
    graphAdd.get_tk_widget().place(x=150, y=75)

    return graphFig


def create_pdf():
    curGraph = update_graph()
    file = filedialog.asksaveasfilename(defaultextension='.pdf', initialfile="COVID-Report")
    curGraph.savefig(file, bbox_inches="tight")


get_file()

# GUI Creation

mainWindow = Tk()

mainWindow.geometry("1450x800")
mainWindow.minsize(1450, 800)
mainWindow.maxsize(1450, 800)
mainWindow.title("NHS Covid-19 App")

logo_image = ImageTk.PhotoImage(Image.open("nhslogonobackground.png"))
logo_label = Label(image=logo_image, width=1600, bg="#007ac2")
logo_label.pack()

infoDisplayedLabel = Label(mainWindow, text="Select the Information Displayed:")
infoDisplayedLabel.place(x=50, y=700)
infoDisplayedList = ["New Cases", "New Deaths", "New Cases & Deaths", "Cumulative Cases", "Cumulative Deaths",
                     "Cumulative Cases & Deaths"]
selectInfoOnGraph = StringVar(mainWindow)
selectInfoOnGraph.set("New Cases")
infoOnGraphSelect = OptionMenu(mainWindow, selectInfoOnGraph, *infoDisplayedList)
infoOnGraphSelect.place(x=260, y=700, width=200, height=25)

displayGraphButton = Button(mainWindow, text="Update Graph", command=update_graph)
displayGraphButton.place(x=155, y=730, width=100, height=25)

createPDFButton = Button(mainWindow, text="Create PDF", command=create_pdf)
createPDFButton.place(x=155, y=760, width=100, height=25)

timeDisplayedLabel = Label(mainWindow, text="Display Data From:")
timeDisplayedLabel.place(x=565, y=700)
timeDisplayed = ["All data", "2 Weeks", "4 Weeks", "6 Weeks", "8 Weeks", "10 Weeks", "3 Months", "6 Months", "1 Year"]
timeDataSelected = StringVar(mainWindow)
timeDataSelected.set("All data")
timeDisplayedSelect = OptionMenu(mainWindow, timeDataSelected, *timeDisplayed)
timeDisplayedSelect.place(x=695, y=700, width=190, height=25)

predictionLengthLabel = Label(mainWindow, text="Prediction Length:")
predictionLengthLabel.place(x=565, y=730)
predictionLengthOptions = ["None", "Next 2 Weeks", "Next 4 Weeks", "Next 6 Weeks"]
predictionLengthSelected = StringVar(mainWindow)
predictionLengthSelected.set("None")
predictionLengthSelect = OptionMenu(mainWindow, predictionLengthSelected, *predictionLengthOptions)

predictionLengthSelect.place(x=695, y=730, width=190, height=25)

algorithmLabel = Label(mainWindow, text="Algorithm:")
algorithmLabel.place(x=565, y=760)
algorithmOptions = ["Linear Regression", "Logistic Regression", "Support Vector Machines"]
algorithmSelected = StringVar(mainWindow)
algorithmSelected.set("Linear Regression")
algorithmSelect = OptionMenu(mainWindow, algorithmSelected, *algorithmOptions)
algorithmSelect.place(x=695, y=760, width=190, height=25)

showHighestValue = BooleanVar(mainWindow)
showHighestValue.set(False)
showHighestCheck = Checkbutton(mainWindow, text="Highlight Highest Date", variable=showHighestValue)
showHighestCheck.place(x=1200, y=700)

showLowestValue = BooleanVar(mainWindow)
showLowestValue.set(False)
showLowestCheck = Checkbutton(mainWindow, text="Highlight Lowest Date", variable=showLowestValue)
showLowestCheck.place(x=1200, y=730)

accessibleViewValue = BooleanVar(mainWindow)
accessibleViewValue.set(False)
accessibleView = Checkbutton(mainWindow, text="Accessible View", variable=accessibleViewValue)
accessibleView.place(x=1200, y=760)

mainWindow.mainloop()

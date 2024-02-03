**COVID-19 Modeling and Visualiser Tool**

Our program is designed to allow users to view data based on COVID-19 cases and deaths by applying different filters. The program is capable of displaying all up-to-date data or specifying the last 2 weeks, 4 weeks, 6 weeks, 8 weeks, 10 weeks, 3 months, 6 months, or year. The program is also capable of forecasting the next 2, 4 or 6 weeks using a variety of forecasting models that the user can choose between. The data is always up to date as it is directly downloaded from the NHS website every time the program is run.

The program utalises different libraries to achieve the required functionality. A list of all used libraries as follows: platform, from tkinter import *, from tkinter import filedialog, pandas as pd, numpy as np, from PIL import ImageTk, Image, from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, from matplotlib.figure import Figure, from statistics import mean, from datetime import datetime, re, from datetime import timedelta, from urllib import request, from sklearn import svm, from sklearn.linear_model import LogisticRegression.

The "main" method that includes the call to run the program is located in the mainProgram.py file as the code itself is iterative with function calls to different functionality.

The CSV file that contains all data for deaths and cases is located in the same directory as the main program. A new version of this file is downloaded everytime the program is run to ensure the most up-to-date information is used. This file will automatically be stored in the same directory as the program. 

Python Link: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_vito1/-/blob/43adce04f3e644f14225460e4966fa987eec847d/mainProgram.py

Credits:
- Adam Akhlaq
- Kieran Andrews
- Victoria Ogunnaike
- Abdulquadri Allison
- Carol Alle
- Aaron Glen

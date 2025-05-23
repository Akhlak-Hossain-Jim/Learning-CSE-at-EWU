# -*- coding: utf-8 -*-
"""Team_I_Analyzing Financial Factors in Loan Approvals-CSE303-Section_4.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/13jKfjpDnsH84kcN8konn7ZziGy_GjetN

# Importing libraries and file.
"""

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df = pd.read_csv("LoanData_Preprocessed_v1.1.csv")

print(df.head())

"""# Findind data types"""

print(df.dtypes)

"""# Cheking if the Dataset is balanced or not"""

counts = df["default"].value_counts()
percentages = df["default"].value_counts(normalize=True) * 100

print("Class Distribution (Count):\n", counts)
print("\nClass Distribution (Percentage):\n", percentages)

"""# Description of the data"""

print(df.columns)

pd.set_option("display.max_columns", None)
print(df.describe())

"""# Statistical calculations"""

print("Continuous Columns:")
continuous_cols = ["age", "income", "debtinc", "creddebt", "othdebt"]
print(continuous_cols)

for col in continuous_cols:
    print(f"\n Statistics for {col}:")
    print("Mean:", df[col].mean())
    print("Median:", df[col].median())
    print("Variance:", df[col].var())
    print("Standard Deviation:", df[col].std())

print("Discrete Columns:")
discrete_cols = ["employ", "address", "ed", "default"]
print(discrete_cols)

for col in discrete_cols:
    print(f"\n Frequency and Percentage for {col}:")
    counts = df[col].value_counts()
    percentages = df[col].value_counts(normalize=True) * 100
    summary = pd.concat([counts, percentages], axis=1)
    summary.columns = ["Count", "Percentage"]
    print(summary)

"""## Visualisations

### Bar Chart: Education Level
"""

df["ed"].value_counts().sort_index().plot(kind="bar")
plt.title("Distribution of Education Level")
plt.xlabel("Education Level")
plt.ylabel("Count")
plt.grid(True)
plt.show()

"""### Pie Chart: Loan Default Distribution"""

df["default"].value_counts().plot(
    kind="pie", autopct="%1.1f%%", labels=["No Default", "Default"], startangle=90
)
plt.title("Loan Default Rate")
plt.ylabel("")
plt.show()

"""### Line Graph: Average Income by Education Level"""

df.groupby("ed")["income"].mean().plot(kind="line", marker="o")
plt.title("Average Income by Education Level")
plt.xlabel("Education Level")
plt.ylabel("Average Income")
plt.grid(True)
plt.show()

"""### Bar Chart: Employment Years"""

df["employ"].value_counts().sort_values(ascending=False).plot(kind="bar")
plt.title("Years of Employment")
plt.xlabel("Years of Employment")
plt.ylabel("Frequency")
plt.grid(True)
plt.show()

"""## Correlation Heatmap"""

import seaborn as sns

corr = df.corr()

plt.figure(figsize=(10, 8))
sns.heatmap(corr, annot=True, cmap="coolwarm", fmt=".2f", linewidths=0.5)
plt.title("Correlation Heatmap")
plt.show()

"""## Check for missing values"""

print(df.isnull().sum())

"""Handling the missing values"""

df["age"] = df["age"].fillna(df["age"].median())
df["income"] = df["income"].fillna(df["income"].median())
df["ed"] = df["ed"].fillna(df["ed"].mode()[0])

"""checking for the missing values again"""

print(df.isnull().sum())

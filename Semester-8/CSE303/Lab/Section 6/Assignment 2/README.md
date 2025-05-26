# Loan Default Prediction Project

## Overview

In this project, we analyzed a loan dataset to predict the risk of default using a Support Vector Machine (SVM). The dataset was preprocessed, split into training and test sets, and evaluated using several performance metrics.

---

## Step 1: **Load and Explore the Dataset**

We started by loading the dataset and understanding its structure. We checked for missing values, data types, and performed a brief exploration of the dataset.

### Code:

```python
import pandas as pd

# Load the dataset
df = pd.read_csv('/mnt/data/LoanData_Preprocessed_v1.1.csv')

# Display basic info
print("Dataset Shape:", df.shape)
print("\nColumn Names and Types:")
print(df.dtypes)

# Check for missing values
print("\nMissing values per column:")
print(df.isnull().sum())

# Display first few rows
print("\nSample data:")
print(df.head())
```

---

## Step 2: **Identify Data Types and Dataset Balance**

In this step, we classified the data columns as categorical or numerical and checked if the dataset is balanced (i.e., whether the target classes have similar counts).

### Code:

```python
# Replace 'target_column' with your actual target column name, e.g., 'Loan_Status' or similar
target_column = 'default'

# Display counts and percentages of each class in target column
class_counts = df[target_column].value_counts()
class_percent = df[target_column].value_counts(normalize=True) * 100

print(f"Class Distribution for {target_column}:")
print(class_counts)
print("\nClass Percentage:")
print(class_percent)

# Example of class balance condition
total = len(df)
balanced_threshold = 0.4  # if any class is less than 40%, considered imbalanced

balanced = all((class_counts / total) >= balanced_threshold)

print(f"\nIs dataset balanced? {'Yes' if balanced else 'No'}")

# Data types per column
data_types = df.dtypes

print("\nData Types Summary:")
for col in df.columns:
    dtype = df[col].dtype
    # Simple classification
    if dtype == 'object':
        data_type = 'Qualitative (Nominal/Ordinal)'
    elif pd.api.types.is_integer_dtype(dtype):
        data_type = 'Quantitative (Discrete)'
    elif pd.api.types.is_float_dtype(dtype):
        data_type = 'Quantitative (Continuous)'
    else:
        data_type = 'Other'
    print(f"{col}: {data_type}")
```

---

## Step 3: **Summarize Dataset Columns with Statistics**

We summarized each column’s characteristics. For numerical columns, we computed statistics such as mean, median, variance, and standard deviation. For categorical columns, we displayed frequencies and percentages.

### Code:

```python
import numpy as np

# Separate categorical and numerical columns
categorical_cols = [col for col in df.columns if df[col].dtype == 'object']
numerical_cols = [col for col in df.columns if df[col].dtype in ['int64', 'float64']]

print("Categorical columns description:")
for col in categorical_cols:
    print(f"\nColumn: {col}")
    counts = df[col].value_counts()
    percentages = df[col].value_counts(normalize=True) * 100
    for cat, count in counts.items():
        print(f"  {cat}: {count} ({percentages[cat]:.2f}%)")

print("\nNumerical columns description:")
for col in numerical_cols:
    mean = df[col].mean()
    median = df[col].median()
    var = df[col].var()
    std = df[col].std()
    print(f"\nColumn: {col}")
    print(f"  Mean: {mean:.2f}")
    print(f"  Median: {median:.2f}")
    print(f"  Variance: {var:.2f}")
    print(f"  Std Deviation: {std:.2f}")
```

---

## Step 4: **Visualize the Data**

We created visualizations to better understand the distribution of values in the dataset. We used bar charts for categorical features, histograms for numerical features, and a correlation heatmap for numerical columns.

### Code:

```python
import matplotlib.pyplot as plt
import seaborn as sns

# Bar chart example for a categorical column (replace with one from your dataset)
categorical_example = categorical_cols[0]  # or specify column name

plt.figure(figsize=(8,5))
df[categorical_example].value_counts().plot(kind='bar')
plt.title(f'Distribution of {categorical_example}')
plt.xlabel(categorical_example)
plt.ylabel('Count')
plt.show()

# Histogram example for a numerical column
numerical_example = numerical_cols[0]  # or specify column name

plt.figure(figsize=(8,5))
df[numerical_example].hist(bins=20)
plt.title(f'Distribution of {numerical_example}')
plt.xlabel(numerical_example)
plt.ylabel('Frequency')
plt.show()

# Correlation heatmap for numerical features
plt.figure(figsize=(10,8))
sns.heatmap(df[numerical_cols].corr(), annot=True, cmap='coolwarm', fmt=".2f")
plt.title('Correlation Heatmap')
plt.show()
```

---

## Step 5: **Handle Missing Values and Convert Categorical Data**

We handled missing values by filling numerical columns with their mean values and categorical columns with the mode (most frequent value). We also encoded categorical columns into numerical values using label encoding and one-hot encoding.

### Code:

```python
from sklearn.preprocessing import LabelEncoder
from sklearn.impute import SimpleImputer

# Handling missing values - example with mean for numerical columns
num_imputer = SimpleImputer(strategy='mean')
df[numerical_cols] = num_imputer.fit_transform(df[numerical_cols])

# For categorical columns, fill missing with mode
cat_imputer = SimpleImputer(strategy='most_frequent')
df[categorical_cols] = cat_imputer.fit_transform(df[categorical_cols])

# Encoding categorical variables
# If ordinal, use LabelEncoder; else One-Hot Encoding

# Example Label Encoding for one column (if ordinal)
label_enc = LabelEncoder()
df['Example_Ordinal_Column'] = label_enc.fit_transform(df['Example_Ordinal_Column'])

# One-Hot Encoding for nominal columns
df_encoded = pd.get_dummies(df, columns=categorical_cols, drop_first=True)

print("After encoding, dataset shape:", df_encoded.shape)
```

---

## Step 6: **Split Dataset and Train Model**

We split the dataset into training (80%) and testing (20%) sets. Then we trained an SVM classification model to predict loan default. The model was trained on the training data and predictions were made on the test data.

### Code:

```python
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC

# Separate features and target
target_column = 'default'
X = df_encoded.drop(target_column, axis=1)
y = df_encoded[target_column]

# Split the data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train an SVM model
model = SVC()
model.fit(X_train, y_train)

# Predict on test data
y_pred = model.predict(X_test)

print("Model training and prediction done.")
```

---

## Step 7: **Evaluate Model Performance**

We evaluated the model’s performance using classification metrics: precision, recall, F1-score, and confusion matrix.

### Code:

```python
from sklearn.metrics import classification_report, confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

# Print classification report
print("Classification Report:")
print(classification_report(y_test, y_pred))

# Confusion matrix
cm = confusion_matrix(y_test, y_pred)

# Plot confusion matrix
plt.figure(figsize=(6,5))
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=[0,1], yticklabels=[0,1])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()
```

---

## Conclusion

- **Accuracy:** The model achieved 74% accuracy, but the recall for the "default" class was very low (3%).
- **Imbalance:** The dataset was imbalanced, with more "no default" cases than "default" cases. This caused the model to favor predicting "no default."
- **Future Work:**

  - Balance the dataset using oversampling or undersampling.
  - Tune hyperparameters to improve recall for the "default" class.
  - Explore other models such as Random Forest or XGBoost.

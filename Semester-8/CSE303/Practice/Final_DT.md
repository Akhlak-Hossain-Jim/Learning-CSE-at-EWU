# Decision Tree Practice Problems: Entropy, Gini Index & Information Gain

## Problem 1: Student Admission Prediction

A university wants to predict whether a student will be **Admitted** or **Rejected** based on their profile.

**Dataset:**
| Student | GPA (numerical) | Extracurricular | Interview Score | Admission |
|---------|-----------------|-----------------|-----------------|-----------|
| 1       | 3.8            | Yes             | High            | Admitted  |
| 2       | 2.1            | No              | Low             | Rejected  |
| 3       | 3.9            | Yes             | High            | Admitted  |
| 4       | 2.5            | No              | Medium          | Rejected  |
| 5       | 3.2            | Yes             | Medium          | Admitted  |
| 6       | 1.8            | No              | Low             | Rejected  |
| 7       | 3.6            | Yes             | High            | Admitted  |
| 8       | 2.8            | No              | Medium          | Rejected  |
| 9       | 3.4            | Yes             | Medium          | Admitted  |
| 10      | 2.0            | No              | Low             | Rejected  |

**Tasks:**
1. Convert GPA (numerical) to categorical: Low (≤2.5), Medium (2.5-3.5), High (>3.5)
2. Calculate the entropy of the root node
3. Calculate the Gini index of the root node
4. Calculate information gain for each feature
5. Which feature should be selected as the root node split?

---

## Problem 2: Customer Purchase Behavior

An e-commerce company wants to predict whether a customer will **Buy** or **Not Buy** a product.

**Dataset:**
| Customer | Age (numerical) | Income Level | Previous Purchase | Purchase Decision |
|----------|-----------------|--------------|-------------------|-------------------|
| 1        | 25             | Low          | No                | Not Buy          |
| 2        | 45             | High         | Yes               | Buy              |
| 3        | 35             | Medium       | Yes               | Buy              |
| 4        | 22             | Low          | No                | Not Buy          |
| 5        | 50             | High         | Yes               | Buy              |
| 6        | 28             | Medium       | No                | Not Buy          |
| 7        | 42             | High         | Yes               | Buy              |
| 8        | 31             | Medium       | Yes               | Buy              |
| 9        | 26             | Low          | No                | Not Buy          |
| 10       | 38             | Medium       | No                | Not Buy          |
| 11       | 55             | High         | Yes               | Buy              |
| 12       | 29             | Low          | Yes               | Buy              |

**Tasks:**
1. Convert Age (numerical) to categorical: Young (≤30), Middle (30-45), Senior (>45)
2. Calculate the entropy of the root node
3. Calculate the Gini index of the root node
4. Calculate information gain for each feature using entropy
5. Calculate Gini gain for each feature
6. Compare the feature rankings using both methods

---

## Problem 3: Employee Performance Prediction

A company wants to predict employee **Performance** (Good/Poor) based on various factors.

**Dataset:**
| Employee | Years Experience (numerical) | Education | Department | Performance |
|----------|----------------------------|-----------|------------|-------------|
| 1        | 2.5                       | Bachelor  | IT         | Poor        |
| 2        | 8.2                       | Master    | Finance    | Good        |
| 3        | 5.1                       | Bachelor  | IT         | Good        |
| 4        | 1.8                       | Bachelor  | HR         | Poor        |
| 5        | 12.3                      | PhD       | Finance    | Good        |
| 6        | 3.7                       | Master    | IT         | Good        |
| 7        | 0.9                       | Bachelor  | HR         | Poor        |
| 8        | 6.8                       | Master    | Finance    | Good        |
| 9        | 4.2                       | Bachelor  | IT         | Poor        |
| 10       | 15.1                      | PhD       | Finance    | Good        |
| 11       | 2.1                       | Master    | HR         | Poor        |
| 12       | 9.5                       | Master    | IT         | Good        |
| 13       | 7.3                       | Bachelor  | Finance    | Good        |
| 14       | 1.2                       | Bachelor  | HR         | Poor        |

**Tasks:**
1. Convert Years Experience to categorical: Junior (≤3), Mid-level (3-8), Senior (>8)
2. Calculate entropy and Gini index for the root node
3. For the feature "Department", calculate:
   - Information gain using entropy
   - Gini gain
4. For the converted "Experience Level", calculate:
   - Information gain using entropy
   - Gini gain
5. Build the first level of the decision tree by selecting the best feature
6. Calculate the weighted entropy/Gini for the selected split

---

## Formulas to Remember:

**Entropy:** 
H(S) = -∑(p_i × log₂(p_i))

**Gini Index:** 
Gini(S) = 1 - ∑(p_i)²

**Information Gain:** 
IG(S,A) = H(S) - ∑((|S_v|/|S|) × H(S_v))

**Gini Gain:** 
GiniGain(S,A) = Gini(S) - ∑((|S_v|/|S|) × Gini(S_v))

Where:
- S = dataset
- A = attribute/feature
- p_i = proportion of samples belonging to class i
- S_v = subset of S for which attribute A has value v

---

## Practice Tips:

1. Always convert numerical features to categorical first
2. Count class distributions carefully for each subset
3. Use log₂ for entropy calculations
4. Double-check your arithmetic, especially with fractions
5. The feature with the highest information gain (or Gini gain) should be selected for splitting
6. Remember that lower entropy/Gini index indicates better class purity

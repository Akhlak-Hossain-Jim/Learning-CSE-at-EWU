# F(n) problems

## Basic Level Problems

### Problem 1
```pseudo
function example1(param):
    return 5
```
### Problem 2
```pseudo
function example2(param):
    x = 10
    y = 20
    z = x + y
    return z
```
### Problem 3
```pseudo
function example3(param):
    if param == 0:
        return 1
    else:
        return 2
```
### Problem 4
```pseudo
function example4(param):
    print("Hello")
    print("World")
```
### Problem 5
```pseudo
function example5(param):
    if param == 0:
        print("Case 1")
    else:
        print("Case 2")
    return 1
```
### Problem 6
```pseudo
function example6(param):
    for i = 0 to 3:
        print("Iteration ", i)
```
### Problem 7
```pseudo
function example7(param):
    for i = 0 to param - 1:
        print("Iteration ", i)
```
### Problem 8
```pseudo
function example8(param):
    sum = 0
    for i = 1 to param:
        sum = sum + 1
    return sum
```
### Problem 9
```pseudo
function example9(param):
    for i = 0 to 3:
        for j = 0 to 2:
            print(i, j)
```
### Problem 10
```pseudo
function example10(param):
    for i = 0 to param:
        if i % 2 == 0:
            print(i, " is even")
```
## Medium Level Problems: Nested Loops

### Problem 1 (Independent Loops)
```pseudo
function example1(param):
    for i = 0 to 4: # Independent of param
        print(i)
    for j = 0 to 3: # Independent of param
        print(j)
```
### Problem 2 (Outer Loop Dependent, Inner Loop Independent)
```pseudo
function example2(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to 3: # Independent of param
            print(i, j)
```
### Problem 3 (Both Loops Dependent on param)
```pseudo
function example3(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to param: # Dependent on param
            print(i, j)
```
### Problem 4 (Inner Loop Dependent on Outer Loop)
```pseudo
function example4(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to i: # Dependent on outer loop (i)
            print(i, j)
```
### Problem 5 (Outer Loop Dependent, Inner Loop Independent)
```pseudo
function example5(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to 5: # Independent of param
            print(i, j)
```
### Problem 6 (Inner Loop Grows Faster than Outer Loop)
```pseudo
function example6(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to 2 * param: # Dependent on param, grows faster
            print(i, j)
```
### Problem 7 (Reverse Dependence)
```pseudo
function example7(param):
    for i = 0 to param: # Dependent on param
        for j = param to i: # Dependent on outer loop (i)
            print(i, j)
```
### Problem 8 (Three Nested Loops)
```pseudo
function example8(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to i: # Dependent on outer loop (i)
            for k = 0 to j: # Dependent on second loop (j)
                print(i, j, k)
```
### Problem 9 (Partial Dependence)
```pseudo
function example9(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to 5: # Independent of param
            for k = 0 to j: # Dependent on j (inner loop only)
                print(i, j, k)
```
### Problem 10 (Mixed Dependence)
```pseudo
function example10(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to param - i: # Dependent on both param and outer loop (i)
            print(i, j)
```
## Intermediate Level Problems: Nested Loops and Mixed Dependencies

### Problem 1 (Dependent on Powers of param)
```pseudo
function example1(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to i^2: # Dependent on outer loop (i)
            print(i, j)
```
### Problem 2 (Dependent on Logarithmic Growth)
```pseudo
function example2(param):
    i = 1
    while i <= param: # Logarithmic growth
        for j = 0 to i: # Dependent on outer loop (i)
            print(i, j)
        i = i * 2
```
### Problem 3 (Alternating Growth)
```pseudo
function example3(param):
    for i = 0 to param: # Dependent on param
        for j = i to param: # Dependent on both param and outer loop (i)
            for k = 0 to j: # Dependent on second loop (j)
                print(i, j, k)
```
### Problem 4 (Reducing Inner Loop)
```pseudo
function example4(param):
    for i = 0 to param: # Dependent on param
        for j = param to i step -1: # Reduces with outer loop (i)
            print(i, j)
```
### Problem 5 (Inner Loop Skipping Steps)
```pseudo
function example5(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to param step 2: # Independent but skips steps
            print(i, j)
```
### Problem 6 (Double Loop with Mixed Ranges)
```pseudo
function example6(param):
    for i = 1 to param: # Dependent on param
        for j = 1 to param / i: # Inversely proportional to outer loop
            print(i, j)
```
### Problem 7 (Loop with Multiplicative Growth)
```pseudo
function example7(param):
    for i = 0 to param: # Dependent on param
        for j = 1 to param:
            for k = j to j * 2: # Dependent on inner loop (j)
                print(i, j, k)
```
### Problem 8 (Recursive Calls Simulating Loops)
```pseudo
function example8(param):
    if param <= 0:
        return
    for i = 0 to param: # Dependent on param
        print(i)
    example8(param - 1) # Recursive reduction
```
### Problem 9 (Unbalanced Nested Loops)
```pseudo
function example9(param):
    for i = 0 to param: # Dependent on param
        for j = 0 to i: # Dependent on outer loop (i)
            print(i, j)
        for k = 0 to 2 * param: # Independent of outer loop
            print(i, k)
```
### Problem 10 (Dependent + Logarithmic Combination)
```pseudo
function example10(param):
    for i = 1 to param: # Dependent on param
        j = 1
        while j <= i: # Logarithmic growth w.r.t. i
            print(i, j)
            j = j * 2
```

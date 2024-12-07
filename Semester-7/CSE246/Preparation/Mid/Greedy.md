# Greedy Technique: Minimum Coin Change - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
Using the denominations \([1, 5, 10]\), find the minimum number of coins required to make the amount \(23\).

---

### **Problem 2**  
Explain why the greedy approach works for denominations like \([1, 5, 10, 25]\).

---

### **Problem 3**  
Using the denominations \([1, 2, 5]\), calculate the minimum number of coins to make the amount \(11\).

---

### **Problem 4**  
What is the time complexity of the greedy algorithm for the minimum coin change problem?

---

### **Problem 5**  
Given the denominations \([1, 3, 4]\), use the greedy approach to determine the minimum number of coins to make the amount \(6\).

---

### **Problem 6**  
Why does the greedy algorithm fail for denominations like \([1, 3, 4]\)? Explain with an example.

---

### **Problem 7**  
Find the minimum number of coins required to make the amount \(30\) using the denominations \([1, 5, 10, 25]\).

---

### **Problem 8**  
Explain how to determine the largest denomination to use in each step of the greedy approach.

---

### **Problem 9**  
Using denominations \([1, 2, 5, 10]\), find the minimum number of coins to make \(27\).

---

### **Problem 10**  
Describe a real-world scenario where the greedy algorithm for coin change is applicable.

---

## **Medium Level Problems**

### **Problem 1**  
Given the denominations \([1, 5, 10, 20]\), find the minimum coins required to make \(37\) and explain the steps.

---

### **Problem 2**  
Prove why the greedy approach works for denominations \([1, 5, 10, 25]\), but not for denominations like \([1, 3, 4]\).

---

### **Problem 3**  
Using the denominations \([1, 7, 10]\), find the minimum coins to make \(14\) and explain why the greedy approach fails.

---

### **Problem 4**  
Write a pseudocode for the greedy algorithm to solve the coin change problem.

---

### **Problem 5**  
Find the minimum number of coins to make the amount \(63\) using the denominations \([1, 5, 10, 25, 50]\).

---

### **Problem 6**  
Compare the greedy approach and dynamic programming approach for solving the coin change problem.

---

### **Problem 7**  
Find the minimum coins required to make \(29\) using denominations \([1, 3, 4, 5]\). Does the greedy approach succeed?

---

### **Problem 8**  
Explain the limitations of the greedy algorithm for coin change and provide an example.

---

### **Problem 9**  
Implement the greedy algorithm for coin change in pseudocode and analyze its space complexity.

---

### **Problem 10**  
Using denominations \([1, 6, 10]\), find the minimum coins to make \(12\) and explain why the greedy approach fails.

---

## **Intermediate Level Problems**

### **Problem 1**  
Design a hybrid algorithm that uses the greedy approach for certain denominations and switches to dynamic programming for others.

---

### **Problem 2**  
Using the denominations \([1, 7, 10]\), analyze the time complexity of finding the minimum coins required to make \(21\) using both greedy and dynamic programming methods.

---

### **Problem 3**  
Prove that the greedy algorithm works correctly if all denominations are multiples of each other (e.g., \([1, 2, 4, 8]\)).

---

### **Problem 4**  
Given an arbitrary set of denominations, devise a method to determine whether the greedy algorithm will always yield the correct result.

---

### **Problem 5**  
Using denominations \([1, 3, 4, 6]\), find the minimum coins required to make \(13\) using both greedy and dynamic programming approaches. Compare the results.

---

### **Problem 6**  
Discuss the impact of coin denominations on the correctness of the greedy algorithm. Provide examples where it succeeds and fails.

---

### **Problem 7**  
Explain how the coin change problem can be modified for infinite and finite coin supplies, and how the greedy algorithm adapts to each scenario.

---

### **Problem 8**  
Implement a dynamic programming algorithm to solve the coin change problem and compare its performance with the greedy approach.

---

### **Problem 9**  
For denominations \([1, 3, 5, 7]\), determine the smallest amount for which the greedy algorithm fails to find the minimum coins.

---

### **Problem 10**  
Given a large set of denominations, analyze when it is computationally better to use dynamic programming over the greedy approach.

---

# Greedy Technique: Fractional Knapsack - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
Explain the concept of the fractional knapsack problem and how it differs from the 0/1 knapsack problem.

---

### **Problem 2**  
Given the following items with weights and values:  
\[
\text{Items: } [(Weight, Value)] = [(10, 60), (20, 100), (30, 120)]
\]  
Find the maximum value for a knapsack of capacity \(50\) using the fractional knapsack approach.

---

### **Problem 3**  
Explain why sorting items by their value-to-weight ratio is crucial for the fractional knapsack problem.

---

### **Problem 4**  
What is the time complexity of the greedy approach for solving the fractional knapsack problem? Justify your answer.

---

### **Problem 5**  
Sort the following items by their value-to-weight ratio:  
\[
\text{Items: } [(Weight, Value)] = [(5, 25), (10, 50), (15, 60)]
\]  

---

### **Problem 6**  
Given a knapsack capacity of \(40\), and items:  
\[
\text{Items: } [(Weight, Value)] = [(20, 100), (10, 60), (30, 120)]
\]  
Determine the items to pick and their respective fractions to maximize value.

---

### **Problem 7**  
Explain the difference between the greedy approach for the fractional knapsack problem and the dynamic programming approach for the 0/1 knapsack problem.

---

### **Problem 8**  
Why is the greedy technique always optimal for the fractional knapsack problem but not for the 0/1 knapsack problem?

---

### **Problem 9**  
Describe how the greedy algorithm handles cases where a single item's weight exceeds the knapsack's capacity.

---

### **Problem 10**  
Given the items:  
\[
\text{Items: } [(Weight, Value)] = [(25, 100), (15, 60), (10, 40)]
\]  
Find the maximum value for a knapsack of capacity \(35\).

---

## **Medium Level Problems**

### **Problem 1**  
Given the following items:  
\[
\text{Items: } [(Weight, Value)] = [(10, 60), (20, 100), (30, 120)]
\]  
Write pseudocode to implement the fractional knapsack algorithm.

---

### **Problem 2**  
Prove that the greedy algorithm for the fractional knapsack problem always yields the optimal solution.

---

### **Problem 3**  
Find the maximum value of a knapsack with capacity \(70\), given:  
\[
\text{Items: } [(Weight, Value)] = [(10, 20), (40, 80), (30, 120)]
\]  
Show the steps of selecting fractions of items.

---

### **Problem 4**  
Discuss the limitations of the fractional knapsack problem and provide examples of real-world scenarios where it is applicable.

---

### **Problem 5**  
Modify the fractional knapsack algorithm to return the selected items and their respective fractions.

---

### **Problem 6**  
Given a knapsack capacity of \(50\), and items:  
\[
\text{Items: } [(Weight, Value)] = [(10, 60), (40, 40), (20, 100), (30, 120)]
\]  
Apply the fractional knapsack algorithm and determine the maximum value achievable.

---

### **Problem 7**  
Explain how sorting affects the performance of the fractional knapsack algorithm. Provide examples with and without sorting.

---

### **Problem 8**  
Given the items:  
\[
\text{Items: } [(Weight, Value)] = [(5, 30), (10, 40), (15, 45)]
\]  
Find the maximum value for a knapsack of capacity \(20\). Discuss the impact of rounding off the fractions.

---

### **Problem 9**  
Write a Python function to solve the fractional knapsack problem. Analyze its time complexity.

---

### **Problem 10**  
Explain the role of the greedy choice property in the fractional knapsack problem. How does this property ensure optimality?

---

## **Intermediate Level Problems**

### **Problem 1**  
Design a hybrid algorithm that combines the fractional and 0/1 knapsack approaches for scenarios where some items cannot be divided.

---

### **Problem 2**  
Given the items:  
\[
\text{Items: } [(Weight, Value)] = [(50, 200), (30, 120), (20, 100)]
\]  
and a knapsack capacity of \(60\), determine the maximum value using both greedy and dynamic programming approaches. Compare their results.

---

### **Problem 3**  
Prove that if the weights are all equal, the fractional knapsack problem reduces to sorting items by their values.

---

### **Problem 4**  
How would you modify the fractional knapsack algorithm to handle negative item values? Discuss its implications.

---

### **Problem 5**  
Given the items:  
\[
\text{Items: } [(Weight, Value)] = [(10, 40), (40, 60), (20, 100), (30, 120)]
\]  
and a knapsack capacity of \(60\), solve the problem and verify the result using multiple approaches.

---

### **Problem 6**  
Analyze the fractional knapsack problem for \(n = 10^6\) items with random weights and values. Discuss the practical runtime of the greedy algorithm.

---

### **Problem 7**  
Extend the fractional knapsack problem to 3D, where each item has a weight, value, and volume, and the knapsack has both weight and volume limits.

---

### **Problem 8**  
Discuss why the fractional knapsack problem cannot be solved using a brute force method efficiently. Provide a complexity analysis.

---

### **Problem 9**  
Implement the fractional knapsack algorithm to maximize the total weight of selected items instead of value, with given constraints on total value.

---

### **Problem 10**  
Analyze the fractional knapsack problem in terms of amortized analysis. Determine the average runtime for \(k\) operations of selecting fractions of items.

# Greedy Technique: Huffman Encoding/Decoding - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
What is Huffman encoding? Explain how it uses the greedy approach.

---

### **Problem 2**  
Given the characters \(['a', 'b', 'c', 'd']\) with frequencies \([10, 20, 30, 40]\), construct the Huffman Tree and determine the codes for each character.

---

### **Problem 3**  
Explain the difference between a full binary tree and the Huffman Tree. Why is Huffman Tree always a full binary tree?

---

### **Problem 4**  
Given the string "aaaabbc", calculate the frequencies of the characters and explain the first step of constructing the Huffman Tree.

---

### **Problem 5**  
What is the time complexity of constructing a Huffman Tree using a priority queue?

---

### **Problem 6**  
Using the frequencies \([5, 7, 10, 15, 20, 45]\), show the first three steps of merging nodes in the Huffman algorithm.

---

### **Problem 7**  
Explain why Huffman encoding results in a prefix-free code.

---

### **Problem 8**  
Construct the Huffman Tree for characters \(['x', 'y', 'z']\) with frequencies \([2, 3, 6]\). Determine the encoded value of the string "xyz".

---

### **Problem 9**  
Describe a real-world scenario where Huffman encoding is used.

---

### **Problem 10**  
What is the main advantage of Huffman encoding over fixed-length encoding?

---

## **Medium Level Problems**

### **Problem 1**  
Given characters \(['a', 'b', 'c', 'd', 'e']\) with frequencies \([3, 6, 8, 2, 10]\), construct the Huffman Tree and determine the encoded binary strings for each character.

---

### **Problem 2**  
For the string "hellohello", calculate the frequencies of the characters and determine the encoded representation using Huffman encoding.

---

### **Problem 3**  
Write pseudocode for constructing the Huffman Tree using a priority queue.

---

### **Problem 4**  
Given the encoded message "1011100" and the following Huffman Tree:  
```
    (*)
   /   \
(*)     c
/  \
a   b
```

Decode the message into the original characters.

---

### **Problem 5**  
Prove that Huffman encoding always produces an optimal prefix code.

---

### **Problem 6**  
Given characters with frequencies \([4, 5, 6, 8, 10, 15]\), show the steps of constructing the Huffman Tree and calculate the total weighted path length.

---

### **Problem 7**  
Compare the size of the encoded message for the string "aaaaabbbcc" using Huffman encoding and fixed-length encoding.

---

### **Problem 8**  
Explain how Huffman encoding handles ties when merging nodes with equal frequencies.

---

### **Problem 9**  
Given the Huffman codes \({'a': '0', 'b': '10', 'c': '11'}\), encode the string "abcabc".

---

### **Problem 10**  
Discuss the limitations of Huffman encoding for compressing data with uniform frequency distributions.

---

## **Intermediate Level Problems**

### **Problem 1**  
Design an algorithm to construct the Huffman Tree for a dynamic input stream of characters. Discuss the challenges.

---

### **Problem 2**  
Given the string "ABRACADABRA", calculate the frequency of each character, construct the Huffman Tree, and determine the encoded representation.

---

### **Problem 3**  
Prove that Huffman encoding minimizes the weighted path length of the tree compared to other binary prefix encoding methods.

---

### **Problem 4**  
Discuss the differences between static and adaptive Huffman encoding. Provide an example of adaptive Huffman encoding.

---

### **Problem 5**  
Given a set of characters with frequencies \([1, 1, 2, 2, 3, 3, 4, 4]\), construct the Huffman Tree. Explain how the tree shape depends on the merging order.

---

### **Problem 6**  
Implement the Huffman decoding algorithm in pseudocode and analyze its time complexity.

---

### **Problem 7**  
How does Huffman encoding handle input with a single character? Discuss the implications for both encoding and decoding.

---

### **Problem 8**  
Given a pre-constructed Huffman Tree, design an efficient algorithm to encode a string and analyze its space complexity.

---

### **Problem 9**  
How would Huffman encoding perform on highly skewed frequency distributions, such as frequencies \([1, 1000]\)? Discuss its efficiency.

---

### **Problem 10**  
Design an extended Huffman encoding scheme that supports multi-byte characters (e.g., UTF-8). Discuss the challenges and benefits.

---

# Greedy Technique: Job Sequencing - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
What is the Job Sequencing problem? Explain its objective and constraints.

---

### **Problem 2**  
Given jobs with the following deadlines and profits:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(A, 2, 100), (B, 1, 19), (C, 2, 27), (D, 1, 25), (E, 3, 15)]
\]  
Schedule the jobs to maximize profit.

---

### **Problem 3**  
Explain why sorting jobs by profit in descending order is the first step in the greedy solution to the Job Sequencing problem.

---

### **Problem 4**  
Write down the steps of the greedy algorithm to solve the Job Sequencing problem.

---

### **Problem 5**  
How does the greedy approach ensure the optimal solution for the Job Sequencing problem? 

---

### **Problem 6**  
Given jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(1, 1, 5), (2, 2, 10), (3, 1, 15)]
\]  
Determine the optimal sequence of jobs.

---

### **Problem 7**  
What is the time complexity of the greedy algorithm for the Job Sequencing problem? Explain the steps that contribute to this complexity.

---

### **Problem 8**  
What happens when two jobs have the same profit? How does the greedy algorithm handle this scenario?

---

### **Problem 9**  
Given the jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(A, 3, 20), (B, 2, 15), (C, 1, 10)]
\]  
Determine the maximum profit achievable with a schedule of at most \(3\) slots.

---

### **Problem 10**  
Explain the significance of the deadline constraint in the Job Sequencing problem.

---

## **Medium Level Problems**

### **Problem 1**  
Given jobs with the following details:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(1, 2, 100), (2, 1, 50), (3, 2, 20), (4, 1, 10), (5, 3, 70)]
\]  
Find the job sequence that maximizes the profit. Show each step of the process.

---

### **Problem 2**  
Write pseudocode for implementing the greedy algorithm to solve the Job Sequencing problem.

---

### **Problem 3**  
Given a set of jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(A, 4, 50), (B, 1, 10), (C, 3, 40), (D, 2, 30)]
\]  
Construct the job sequence and calculate the total profit.

---

### **Problem 4**  
Discuss the limitations of the greedy approach for the Job Sequencing problem.

---

### **Problem 5**  
Modify the Job Sequencing algorithm to handle jobs with overlapping deadlines.

---

### **Problem 6**  
For the following jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(A, 2, 100), (B, 2, 50), (C, 1, 20), (D, 3, 200), (E, 1, 60)]
\]  
Determine the job sequence that maximizes profit for a total of \(3\) slots.

---

### **Problem 7**  
Explain how to extend the Job Sequencing problem for cases where some jobs have zero profit. Provide an example.

---

### **Problem 8**  
Compare the greedy approach for Job Sequencing with a dynamic programming approach. Discuss the strengths and weaknesses of both methods.

---

### **Problem 9**  
Given the jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(1, 3, 35), (2, 4, 30), (3, 4, 25), (4, 2, 20)]
\]  
Analyze the greedy algorithm's performance for this input.

---

### **Problem 10**  
Explain how the Job Sequencing problem can be applied in real-world scenarios such as task scheduling and resource allocation.

---

## **Intermediate Level Problems**

### **Problem 1**  
Design an algorithm to solve a modified Job Sequencing problem where some jobs can be executed simultaneously on different machines.

---

### **Problem 2**  
Prove that the greedy algorithm for Job Sequencing produces the optimal solution for inputs where the deadlines are all distinct.

---

### **Problem 3**  
For the following jobs:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(A, 5, 200), (B, 3, 180), (C, 3, 190), (D, 2, 300), (E, 4, 250)]
\]  
Determine the sequence of jobs for a total of \(5\) slots. Discuss any conflicts and resolutions.

---

### **Problem 4**  
Extend the Job Sequencing problem to include penalties for jobs that are not scheduled. Discuss how the greedy approach can be modified to minimize penalties.

---

### **Problem 5**  
Analyze the behavior of the greedy algorithm for inputs where all profits are equal. Provide an example and discuss the outcome.

---

### **Problem 6**  
Implement a job sequencing solution where the maximum number of slots is dynamic and changes during runtime.

---

### **Problem 7**  
Given jobs with deadlines and profits:  
\[
\text{Jobs: } [(ID, Deadline, Profit)] = [(1, 2, 100), (2, 1, 50), (3, 3, 20), (4, 1, 10), (5, 3, 70)]
\]  
Schedule the jobs for \(2\) machines and calculate the total profit.

---

### **Problem 8**  
Discuss the impact of unsorted input on the performance of the greedy Job Sequencing algorithm. Show an example where sorting is essential.

---

### **Problem 9**  
Design a hybrid greedy-dynamic programming algorithm for scenarios where jobs have interdependencies.

---

### **Problem 10**  
Prove or disprove: The greedy algorithm for Job Sequencing produces the optimal result for inputs where profits are inversely proportional to deadlines.

---

# Greedy Technique: Activity Selection & Scheduling - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
What is the Activity Selection problem? Describe its objective and constraints.

---

### **Problem 2**  
Given the activities \([(1, 2), (3, 4), (0, 6), (5, 7), (8, 9), (5, 9)]\), select the maximum number of activities that can be performed if a person can only work on one activity at a time.

---

### **Problem 3**  
Why does sorting activities by their finish time in ascending order help in solving the Activity Selection problem using the greedy approach?

---

### **Problem 4**  
Write the steps of the greedy algorithm for the Activity Selection problem.

---

### **Problem 5**  
Given activities \([(1, 3), (2, 4), (3, 5)]\), find the optimal schedule for maximum activities.

---

### **Problem 6**  
What is the time complexity of the greedy algorithm for Activity Selection? Explain the contributing factors.

---

### **Problem 7**  
For activities \([(1, 5), (2, 6), (4, 8)]\), explain why certain activities must be excluded from the final selection.

---

### **Problem 8**  
Explain the difference between the Activity Selection problem and Job Sequencing problem.

---

### **Problem 9**  
Given the activities \([(1, 4), (3, 5), (0, 6), (5, 7)]\), select the maximum number of activities. Show your process.

---

### **Problem 10**  
What happens if activities are sorted by start time instead of finish time in the greedy approach? Discuss the impact on the solution.

---

## **Medium Level Problems**

### **Problem 1**  
Given activities \([(1, 2), (3, 4), (0, 6), (5, 7), (8, 9), (5, 9)]\), solve the Activity Selection problem for multiple people, where each person can work on one activity at a time.

---

### **Problem 2**  
Write pseudocode for the greedy algorithm to solve the Activity Selection problem.

---

### **Problem 3**  
For the activities \([(0, 3), (1, 4), (2, 5), (3, 6)]\), find the maximum number of activities. Explain why overlapping intervals are excluded.

---

### **Problem 4**  
Discuss the conditions under which the greedy approach to Activity Selection fails to produce an optimal solution.

---

### **Problem 5**  
Modify the greedy algorithm for Activity Selection to handle overlapping intervals with priorities (e.g., some activities have a higher importance than others).

---

### **Problem 6**  
Given activities \([(1, 2), (3, 5), (4, 6), (5, 8), (7, 9)]\), find the maximum number of activities. Also, calculate the total idle time between the selected activities.

---

### **Problem 7**  
Compare the greedy approach for Activity Selection with a dynamic programming approach. Discuss the scenarios where one is more efficient than the other.

---

### **Problem 8**  
Given activities with start and end times: \([(2, 3), (3, 5), (1, 6), (5, 7), (6, 8), (8, 9)]\), calculate the maximum number of non-overlapping activities.

---

### **Problem 9**  
Discuss the significance of sorting in the greedy approach for Activity Selection. Show an example where unsorted input produces an incorrect result.

---

### **Problem 10**  
Given overlapping activities \([(1, 4), (2, 5), (3, 6), (5, 7), (6, 8)]\), explain how to adapt the greedy approach to prioritize shorter intervals.

---

## **Intermediate Level Problems**

### **Problem 1**  
Design an algorithm to solve the Activity Selection problem for a weighted version, where each activity has a profit associated with it.

---

### **Problem 2**  
For the activities \([(1, 3), (2, 5), (3, 6), (5, 7), (6, 8), (8, 10)]\), find the maximum number of activities and demonstrate the steps of the greedy algorithm.

---

### **Problem 3**  
Prove that the greedy algorithm for the Activity Selection problem produces an optimal solution when activities are sorted by finish time.

---

### **Problem 4**  
Extend the Activity Selection problem to handle cases where activities are partitioned into groups, and only one activity from each group can be selected.

---

### **Problem 5**  
For the activities \([(0, 5), (1, 2), (3, 4), (6, 7), (5, 9), (8, 10)]\), adapt the greedy algorithm to handle a scenario where activities can have flexible start times.

---

### **Problem 6**  
Given the activities \([(1, 3), (3, 5), (5, 7), (7, 9)]\), solve the problem for a scenario where activities can overlap by up to one unit of time.

---

### **Problem 7**  
Analyze the behavior of the greedy algorithm for inputs with large gaps between activities. For example: \([(1, 2), (10, 11), (20, 21)]\).

---

### **Problem 8**  
Design an algorithm to solve the Activity Selection problem with deadlines, where each activity must be completed before a given time.

---

### **Problem 9**  
Given a real-world scheduling scenario (e.g., meeting scheduling), explain how to model the problem as an Activity Selection problem and solve it.

---

### **Problem 10**  
Implement a hybrid greedy-dynamic programming solution for the Activity Selection problem where activities can overlap but only partially.

---

# String Pattern Matching: Rabin-Karp Algorithm - Practice Problems

---

## **Basic Level Problems**

### **Problem 1**  
Explain the Rabin-Karp algorithm. How does it differ from a naive pattern-matching approach?

---

### **Problem 2**  
What is the role of the hash function in the Rabin-Karp algorithm? Why is it crucial for efficiency?

---

### **Problem 3**  
Given a text `T = "abcdabcabc"` and a pattern `P = "abc"`, explain how the Rabin-Karp algorithm calculates the hash values of substrings.

---

### **Problem 4**  
Illustrate how the Rabin-Karp algorithm uses rolling hash to improve performance compared to recomputing the hash for every substring.

---

### **Problem 5**  
For a text `T = "abcdef"` and a pattern `P = "cd"`, manually calculate the hash values and find the match using the Rabin-Karp algorithm.

---

### **Problem 6**  
Why can hash collisions occur in the Rabin-Karp algorithm? How are they handled?

---

### **Problem 7**  
What is the time complexity of the Rabin-Karp algorithm in the average case and the worst case? Explain the factors contributing to each case.

---

### **Problem 8**  
Describe the conditions under which the Rabin-Karp algorithm is most efficient compared to other string matching algorithms.

---

### **Problem 9**  
Given a text `T = "aabbaabbaab"` and a pattern `P = "aab"`, demonstrate the Rabin-Karp algorithm step-by-step.

---

### **Problem 10**  
Why is modular arithmetic used in the Rabin-Karp algorithm for computing hash values? Explain with an example.

---

## **Medium Level Problems**

### **Problem 1**  
Write pseudocode for the Rabin-Karp algorithm to find all occurrences of a pattern `P` in a text `T`.

---

### **Problem 2**  
Given a text `T = "ababcabcabc"` and a pattern `P = "abc"`, trace the execution of the Rabin-Karp algorithm using a hash function with base \( 10 \) and modulus \( 7 \).

---

### **Problem 3**  
Discuss the trade-offs between choosing a small modulus and a large modulus for the hash function in Rabin-Karp.

---

### **Problem 4**  
Implement the Rabin-Karp algorithm for a scenario where multiple patterns need to be matched in the same text.

---

### **Problem 5**  
Given the text `T = "abracadabra"` and pattern `P = "cad"`, calculate hash values using base \( 31 \) and modulus \( 101 \). Find the match using the Rabin-Karp algorithm.

---

### **Problem 6**  
Explain how Rabin-Karp can be extended to solve the **substring anagram problem** (e.g., finding all permutations of a pattern in the text).

---

### **Problem 7**  
Describe a scenario where Rabin-Karp performs worse than the naive approach. Provide an example to support your explanation.

---

### **Problem 8**  
For a text `T = "aaaaaaa"` and a pattern `P = "aaa"`, calculate the hash values and explain how Rabin-Karp efficiently handles repetitive patterns.

---

### **Problem 9**  
Modify the Rabin-Karp algorithm to search for patterns in a 2D grid of characters instead of a single string.

---

### **Problem 10**  
Compare Rabin-Karp with the Knuth-Morris-Pratt (KMP) algorithm. Highlight their strengths and weaknesses in different scenarios.

---

## **Intermediate Level Problems**

### **Problem 1**  
Prove that the rolling hash function in Rabin-Karp runs in \( O(1) \) time for updating the hash of a substring.

---

### **Problem 2**  
Design a Rabin-Karp based solution to find duplicate substrings of length \( k \) in a given text.

---

### **Problem 3**  
Given a text `T = "abcdefabcdef"` and pattern `P = "def"`, adapt Rabin-Karp to find overlapping occurrences of the pattern.

---

### **Problem 4**  
Explain how Rabin-Karp can be adapted to find **longest repeated substrings** in a given text. Outline the approach and its complexity.

---

### **Problem 5**  
Implement Rabin-Karp for a DNA sequence analysis problem where the goal is to match a pattern sequence \( P \) within a large DNA string \( T \).

---

### **Problem 6**  
Design a Rabin-Karp based approach to search for patterns in a compressed text (e.g., using Run-Length Encoding).

---

### **Problem 7**  
Extend the Rabin-Karp algorithm to solve the **maximum substring match problem**, where partial matches of a pattern in the text are also considered.

---

### **Problem 8**  
For a scenario where multiple patterns of different lengths need to be searched in a text, how can Rabin-Karp be adapted? Provide an efficient solution.

---

### **Problem 9**  
Solve a plagiarism detection problem using the Rabin-Karp algorithm to identify common substrings between two large documents.

---

### **Problem 10**  
For a distributed system, explain how the Rabin-Karp algorithm can be parallelized to perform string pattern matching on large datasets.

---

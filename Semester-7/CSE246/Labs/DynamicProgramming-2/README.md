# Dynamic Programming Problems

## 1. Coin Change

You are given `n` types of coins and another number `K`. Your task is to determine whether it is possible to generate `K` using those coins if:

1. The number of each coin is infinite.
   **Sample Input:**

   ```shell
   3
   1 3 5
   8
   ```

   **Sample Output:**

   ```shell
   1 0 0 0 0 0 0 0 0
   1 1 1 1 1 1 1 1 1
   1 1 1 2 2 2 3 3 3
   1 1 1 2 2 3 4 4 5

   5
   ```

2. The number of each coin is finite.
   **Sample Input:**

   ```shell
   3
   1 2 2 3 3 1
   5
   ```

   **Sample Output:**

   ```shell
   1 0 0 0 0 0
   1 1 1 0 0 0
   1 1 2 1 2 1
   1 1 2 2 3 3

   3
   ```

## 2. Longest Increasing Subsequence (LIS)

Given an array of integers, your task is to find the length as well as the sequence of the longest increasing subsequence within the array.

**Sample Input:**

```shell
8
5 2 8 6 3 6 9 7
```

**Sample Output:**

```shell
4
2, 3, 6, 9
```

## 3. Longest Common Subsequence (LCS)

You are given two strings, and your task is to find the length of the longest common subsequence (LCS) between them. Also, print the LCS.

**Sample Input:**

```shell
string1: "ABCDGH"
string2: "AEDFHR"
```

**Sample Output:**

```shell
3
"ADH"
```

## 4. Longest Common Substring

You are given two strings, and your task is to find the length of the longest common substring between them. Also, find the substring itself.

**Sample Input:**

```shell
string1: "ABCDGH"
string2: "ACDGHR"
```

**Sample Output:**

```shell
4
"CDGH"
```

## 5. Longest Palindromic Subsequence (LPS)

You are given a string, and your task is to find the length of the longest palindromic subsequence (LPS) within the string.

**Sample Input:**

```shell
string: "BBABCBCAB"
```

**Sample Output:**

```shell
7
"BABCBAB"
```

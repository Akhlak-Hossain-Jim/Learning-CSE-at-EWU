# Greedy Technique Problems 1

## 1. Fractional Knapsack

Given the weights and profits of N items, in the form of {profit, weight}, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack. In Fractional Knapsack, we can break items for maximizing the total value of the knapsack.

### Sample Input

```shell
{60, 10}
{100, 20}
{120, 30}
W = 50
```

### Sample Output

```shell
240
```

## 2. Minimum Number of Coins

Given an array of `coins[]` of size `n` and a target value `sum`, where `coins[i]` represent the coins of different denominations. You have an infinite supply of each of the coins. The task is to find the minimum number of coins required to make the given value `sum`. If it’s not possible to make a change, return -1.

### Input

```shell
coins[] = [9, 6, 5, 1], sum = 19
```

### Output

```shell
3
```

### Explanation

```shell
19 = 9 + 9 + 1
```

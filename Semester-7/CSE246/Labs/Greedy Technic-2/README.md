# Greedy Technique Problems 2

## 1. Activity Selection Problem

You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

**Sample Input:**

```shell
start = {10, 12, 20}
finish = {20, 25, 30}
```

**Sample Output:**

```shell
2
```

## 2. Scheduling Problem

Given a schedule containing arrival and departure time of trains in a station, find the minimum number of platforms needed in the station to avoid any delay in the arrival of any train.

**Sample Input:**

```shell
Number of schedules: 6
Arrival: 2.00 2.10 3.00 3.20 3.50 5.00
Departure: 2.30 3.40 3.20 4.30 4.00 5.20
```

**Sample Output:**

```shell
2
```

## 3. Job Sequencing Problem

Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

**Sample Input:**

```shell
a 4 20
b 1 10
c 1 40
d 1 30
```

**Sample Output:**

```shell
c, a
```

## 4. Job Sequencing Problem – Loss Minimization

We are given N jobs numbered 1 to N. For each activity, let Ti denote the number of days required to complete the job. For each day of delay before starting to work for job i, a loss of Li is incurred. You are required to find a sequence to complete the jobs so that overall loss is minimized. You can only work on one job at a time.

**Sample Input:**

```shell
L = {3, 1, 2, 4}
T = {4, 1000, 2, 5}
```

**Sample Output:**

```shell
3, 4, 1, 2
```

## 5. Assign Mice to Holes

There are N mice and N holes placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x - 1. Any of these moves consumes 1 minute. Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

**Sample Input:**

```shell
Positions of mice are:
4 -4 2
Positions of holes are:
4 0 5
```

**Sample Output:**

```shell
4
```

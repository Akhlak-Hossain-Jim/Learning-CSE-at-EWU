# Lab Manual: 09

Lab Topic: File Handling
Course Code: CSE110 (Object Oriented Programming)
Course Instructor: Tanni Mittra, Senior Lecturer, CSE
Lab Objective

1. Learn a mechanism to handle File in Java program

Lab Activities:

**Lab Problem 1:**

Write a program to create a file named `Lab08_01.txt` if it does not exist. Append new data to it if it
already exists. Write 100 integers created randomly into the file using text I/O. Integers are separated by
a space.

**Lab Problem 2:**

Write a program to create a file named `Lab08_02.dat` if it does not exist. Append new data to it if it
already exists. Write 100 integers created randomly into the file using binary I/O. Integers are separated
by a space.

**Lab Problem 3:**

Write a program that reads lines of characters from a text file and writes each line as a UTF-8 string into
a binary file.

**Lab Problem 4:**

Consider the following class diagram and convert the class diagram into corresponding Java code.

| List                  |
| --------------------- |
| Index:int             |
| MaxSize:int           |
| Data:int[MaxSize]     |
| ===================   |
| + List ()             |
| + List (int MaxSize)  |
| + push(int data):void |
| + pop(): void         |
| + display(): void     |
| + top:int             |

- Inside the no argument constructor set MaxSize attributes to 10 and initialize Index attributes to -1. Inside the second constructor set MaxSize variables by user provided value and also initialize Index attributes to -1.
- Inside the push method add a new item in the Data array and the index of the array will be handled by Index instance variables. Each time a new data is added and Index attributes will be incremented by 1.
- The pop method will remove one element of the array from last. Each time an element removed from element Index attribute will be decreased by one.
- The top method will return an element which is added at last in the list.
- The display method will display the list of the Data array

Write a program that creates five List objects and stores them in a file named Lab08_04.dat

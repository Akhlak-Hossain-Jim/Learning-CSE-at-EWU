# Problem set

Here are some Java coding problems to solve with sample input and output for all the questions:

1. **Problem 1:**

   Create a program that reads a text file and prints the words that are palindromes. A palindrome is a word or phrase that reads the same backward as forward.

   **Sample input:**

   ```md
   racecar
   madam
   civic
   ```

   **Sample output:**

   ```md
   racecar
   madam
   civic
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `palindromes` variable is a list of strings that stores the palindromes found in the file.
   - The `Scanner` class is used to read the file line by line.
   - The `isPalindrome()` method is a helper method that checks if a string is a palindrome.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

2. **Problem 2:**

   Create a program that reads a text file and prints the words that are anagrams of each other. Two words are anagrams if they are made up of the same letters, but in a different order.

   **Sample input:**

   ```md
   cat
   act
   tac
   ```

   **Sample output:**

   ```md
   cat act tac
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `anagrams` variable is a list of lists of strings that stores the anagrams found in the file.
   - The `isAnagram()` method is a helper method that checks if two strings are anagrams of each other.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

3. **Problem 3:**

   Create a program that reads a text file and prints the words that are the longest in each line.

   **Sample input:**

   ```md
   This is a short sentence.
   This is a longer sentence.
   This is the longest sentence.
   ```

   **Sample output:**

   ```md
   longest
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `longestWords` variable is a list of strings that stores the longest words in each line.
   - The `getLongestWord()` method is a helper method that gets the longest word in a line.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

4. **Problem 4:**

   Create a program that reads a text file and prints the words that are unique. A unique word is a word that does not appear in the file more than once.

   **Sample input:**

   ```md
   This is a sentence with some repeated words.
   The word "the" appears twice in this sentence.
   ```

   **Sample output:**

   ```md
   sentence
   repeated
   words
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `uniqueWords` variable is a set of strings that stores the unique words found in the file.
   - The `isUnique()` method is a helper method that checks if a word is unique.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

5. **Problem 5:**

   Create a program that reads a text file and prints the words that are sorted alphabetically.

   **Sample input:**

   ```md
   This is a sentence with some words in random order.
   ```

   **Sample output:**

   ```md
   is
   sentence
   some
   this
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `sortedWords` variable is a list of strings that stores the words in the file, sorted alphabetically.
   - The `sort()` method is a helper method that sorts a list of strings alphabetically.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

6. **Problem 6:**

   Create a program that reads a text file and prints the words that are sorted by their length.

   **Sample input:**

   ```md
   This is a sentence with some words of different lengths.
   ```

   **Sample output:**

   ```md
   is
   this
   sentence
   with
   some
   words
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `sortedWords` variable is a list of strings that stores the words in the file, sorted by their length.
   - The `compare()` method is a helper method that compares two strings by their length.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

7. **Problem 7:**

   Create a program that reads a text file and prints the words that are sorted by their frequency.

   **Sample input:**

   ```md
   This is a sentence with some words that appear multiple times.
   The word "the" appears twice in this sentence.
   ```

   **Sample output:**

   ```md
   the
   sentence
   is
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `sortedWords` variable is a list of strings that stores the words in the file, sorted by their frequency.
   - The `getFrequency()` method is a helper method that gets the frequency of a word in a file.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

8. **Problem 8:**

   Create a program that reads a text file and prints the top 10 most frequent words.

   **Sample input:**

   ```md
   This is a sentence with some words that appear multiple times.
   The word "the" appears twice in this sentence.
   ```

   **Sample output:**

   ```md
   the
   sentence
   is
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `top10Words` variable is a list of strings that stores the top 10 most frequent words in the file.
   - The `getTop10()` method is a helper method that gets the top 10 most frequent words in a file.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

9. **Problem 9:**

   Create a program that reads a text file and prints the words that are palindromes and have a frequency of at least 2.

   **Sample input:**

   ```md
   racecar
   madam
   civic
   ```

   **Sample output:**

   ```md
   racecar
   ```

   **Creative explanation:**

   - The `fileName` variable is a string that stores the name of the file to be read.
   - The `palindromes` variable is a list of strings that stores the palindromes found in the file with a frequency of at least 2.
   - The `getPalindromes()` method is a helper method that gets the palindromes in a file with a frequency of at least 2.
   - The `main()` method is the entry point of the program.
   - The `try-catch` block is used to handle the `FileNotFoundException` exception.

10. **Problem 10:**

    Create a program that reads a text file and prints the words that are anagrams of each other and have a frequency of at least 2.

    **Sample input:**

    ```md
    cat
    act
    tac
    ```

    **Sample output:**

    ```md
    cat act tac
    ```

    **Creative explanation:**

    - The `fileName` variable is a string that stores the name of the file to be read.
    - The `anagrams` variable is a list of lists of strings that stores the anagrams found in the file with a frequency of at least 2.
    - The `getAnagrams()` method is a helper method that gets the anagrams in a file with a frequency of at least 2.
    - The `main()` method is the entry point of the program.
    - The `try-catch` block is used to handle the `FileNotFoundException` exception.

11. **Problem 11**

    **Input:**

    ```md
    test.txt
    the
    ```

    **Output:**

    ```md
    The number of lines that contain the word "the" is 5.
    ```

    Here is a creative explanation of the variables, methods, which class should implement which class, what kind of Java Exceptions to handle where to handle, description of user define Exception class if needed, where to use file, what type of file, also use of generic class with class description:

    - The `fileName` variable is a string that stores the name of the file to be read.
    - The `word` variable is a string that stores the word to be searched for in the file.
    - The `lineCounter` variable is an object of the `LineCounter` interface.
    - The `count` variable is an integer that stores the number of lines that contain the word.
    - The `FileNotFoundException` is a Java exception that is thrown when the file cannot be found.
    - The `FileLineCounter` class implements the `LineCounter` interface.
    - The `countLines()` method is the implementation of the `LineCounter` interface.
    - The `main()` method is the entry point of the program.
    - The `try-catch` block is used to handle the `FileNotFoundException` exception.
    - The `Scanner` class is used to read the file line by line.

# Final Practice Questions

## HTML Questions

1. [Level: Beginner] [Type: Conceptual]  
   Explain the purpose of semantic HTML elements like `<header>`, `<nav>`, `<article>`, and `<footer>`, and why they are preferred over generic `<div>` elements in modern web development.

2. [Level: Beginner] [Type: Coding]  
   Write HTML code to create a simple form for user registration that includes fields for username, email, password, and a submit button. Ensure the form uses appropriate input types and labels for accessibility.

3. [Level: Intermediate] [Type: Conceptual]  
   What happens when you nest anchor tags (`<a>`) inside each other, and how does the browser handle such a structure? Discuss any implications for navigation and accessibility.

4. [Level: Intermediate] [Type: Debugging]  
   The following HTML code is intended to display an image with alternative text, but the image doesn't load properly in the browser. Identify the issue(s) and suggest how to fix it.  
   ```html
   <img src="image.jpg" alt="A beautiful landscape" width=300 height=200>
   ```

5. [Level: Intermediate] [Type: Coding]  
   Write HTML code to structure a basic blog post page, including a heading, author name with a link to their profile, publication date, main content paragraph, and a list of related tags.

6. [Level: Advanced] [Type: Conceptual]  
   Explain the concept of the HTML Document Object Model (DOM) and how it interacts with JavaScript for dynamic content updates. Include considerations for performance when manipulating large DOM trees.

7. [Level: Advanced] [Type: Debugging]  
   This HTML snippet is meant to embed a responsive iframe for a YouTube video, but it doesn't resize correctly on mobile devices. Identify the problem and propose a fix.  
   ```html
   <iframe width="560" height="315" src="https://www.youtube.com/embed/videoID" frameborder="0" allowfullscreen></iframe>
   ```

8. [Level: Advanced] [Type: Coding]  
   Write HTML code for a responsive data table that includes a `<caption>`, proper `<thead>` and `<tbody>` sections, and uses the `scope` attribute on header cells for better accessibility.

9. [Level: Beginner] [Type: Debugging]  
   The following HTML link does not navigate when clicked. Identify the issue and provide the corrected code.  
   ```html
   <a name="contact">Contact Us</a>
   ```


## CSS Questions

1. [Level: Beginner] [Type: Conceptual]  
   Explain the difference between inline, internal, and external CSS, and provide scenarios where each might be most appropriate in a web project.

2. [Level: Beginner] [Type: Coding]  
   Write CSS rules to style a button with a blue background, white text, rounded corners, and a hover effect that changes the background to dark blue.

3. [Level: Intermediate] [Type: Conceptual]  
   What happens when multiple CSS rules target the same element with conflicting styles? Describe the cascade and specificity rules that determine the final applied style.

4. [Level: Intermediate] [Type: Debugging]  
   The following CSS is supposed to center a div horizontally and vertically within its parent, but it only centers horizontally. Find the error and explain how to correct it.  
   ```css
   .parent {
       position: relative;
   }
   .child {
       position: absolute;
       top: 50%;
       left: 50%;
       transform: translate(-50%, -50%);
   }
   ```

5. [Level: Intermediate] [Type: Coding]  
   Write CSS to create a responsive navigation bar that displays horizontally on desktop screens (width > 768px) and stacks vertically on mobile, using media queries.

6. [Level: Advanced] [Type: Conceptual]  
   Discuss CSS Grid versus Flexbox for layout purposes. When would you choose one over the other, and what are the performance implications for complex layouts on resource-constrained devices?

7. [Level: Advanced] [Type: Coding]  
   Write CSS to implement a card flip animation on hover for a product card, where the front shows an image and title, and the back reveals a description. Use transitions and 3D transforms.

8. [Level: Advanced] [Type: Debugging]  
   The following CSS custom properties (variables) are defined, but the fallback color is not applying correctly in older browsers. Explain the problem and suggest an improvement.  
   ```css
   :root {
       --primary-color: #0066ff;
   }
   button {
       background-color: var(--primary-color, blue);
   }
   ```

9. [Level: Beginner] [Type: Coding]  
   Write CSS to create a simple loading spinner using only a single `<div>` element and CSS animations (pure CSS, no JavaScript).

10. [Level: Intermediate] [Type: Conceptual]  
    Explain how the CSS `box-sizing` property affects element width calculations and why `border-box` is often preferred in modern layouts.


## JavaScript Questions

1. [Level: Beginner] [Type: Conceptual]  
   Explain the difference between `let`, `const`, and `var` for declaring variables in JavaScript, including scope and reassignment rules.

2. [Level: Beginner] [Type: Coding]  
   Write JavaScript code to create a function that takes two numbers as arguments and returns their sum, then logs the result of adding 5 and 10 to the console.

3. [Level: Intermediate] [Type: Conceptual]  
   What happens when you use `==` versus `===` for comparisons in JavaScript? Provide examples of when type coercion might lead to unexpected results.

4. [Level: Intermediate] [Type: Debugging]  
   This JavaScript function is intended to filter an array for even numbers, but it returns incorrect results. Identify the bug and suggest a fix.  
   ```javascript
   function getEvenNumbers(arr) {
       return arr.filter(num => num % 2 = 0);
   }
   console.log(getEvenNumbers([1, 2, 3, 4])); // Expected: [2, 4]
   ```

5. [Level: Intermediate] [Type: Coding]  
   Write JavaScript code to fetch data from a JSON API endpoint (e.g., 'https://api.example.com/users') using the Fetch API, then display the list of user names in an unordered list on the page.

6. [Level: Advanced] [Type: Conceptual]  
   Explain closures in JavaScript and how they can be used for data privacy. Discuss potential memory leak issues with closures in long-running applications.

7. [Level: Advanced] [Type: Debugging]  
   The following async JavaScript code is meant to log data after fetching, but it logs 'undefined' instead. Find the issue and explain how to resolve it for proper asynchronous handling.  
   ```javascript
   async function fetchData() {
       const response = await fetch('https://api.example.com/data');
       return response.json();
   }
   const data = fetchData();
   console.log(data);
   ```

8. [Level: Advanced] [Type: Coding]  
   Write JavaScript code to implement a debounce function that limits how frequently a given callback can be executed (e.g., useful for search input handlers). Include a simple example usage.

9. [Level: Beginner] [Type: Conceptual]  
   What happens when you try to access an array index that doesn't exist in JavaScript? Explain the returned value and how it differs from trying to access a property on an undefined object.

10. [Level: Intermediate] [Type: Coding]  
    Write JavaScript code to add a click event listener to all buttons with the class "delete-btn" that prompts the user for confirmation before removing the parent list item from the DOM.

11. [Level: Advanced] [Type: Conceptual]  
    Discuss the event loop in JavaScript, including the roles of the call stack, task queue, and microtask queue. Explain why this matters for handling asynchronous operations like Promises versus setTimeout.

## PHP Questions

1. [Level: Beginner] [Type: Conceptual]  
   Explain the role of PHP in server-side web development and how it differs from client-side languages like JavaScript.

2. [Level: Beginner] [Type: Coding]  
   Write PHP code to create a script that echoes "Hello, World!" followed by the current date in the format 'YYYY-MM-DD'.

3. [Level: Intermediate] [Type: Conceptual]  
   What happens when you use `include` versus `require` for loading external PHP files? Discuss error handling differences and when to use each.

4. [Level: Intermediate] [Type: Debugging]  
   This PHP code is supposed to calculate the average of an array of numbers, but it produces a division by zero error. Identify the problem and suggest a fix.  
   ```php
   <?php
   function calculateAverage($numbers) {
       $sum = array_sum($numbers);
       $average = $sum / count($numbers);
       return $average;
   }
   echo calculateAverage([]);
   ?>
   ```

5. [Level: Intermediate] [Type: Coding]  
   Write PHP code to handle a POST form submission for user login, validating that both username and password fields are not empty, and echoing a success message if valid.

6. [Level: Advanced] [Type: Conceptual]  
   Discuss prepared statements in PHP for database interactions. Explain how they prevent SQL injection attacks and provide an example scenario where they're essential.

7. [Level: Advanced] [Type: Coding]  
   Write PHP code to create a simple RESTful API endpoint that accepts a GET request with an 'id' parameter, queries a MySQL database for a user by that ID (assume connection is established), and returns the user data as JSON. Include basic error handling for no results.

8. [Level: Advanced] [Type: Debugging]  
   The following PHP session code starts a session but the data is not persisting across page requests. Identify potential causes and suggest fixes.  
   ```php
   <?php
   session_start();
   $_SESSION['user_id'] = 123;
   echo "Session set";
   ?>
   ```

9. [Level: Beginner] [Type: Coding]  
   Write PHP code to loop through an array of fruits `['apple', 'banana', 'orange']` and output each one as an unordered list item in HTML.

10. [Level: Intermediate] [Type: Coding]  
    Write PHP code to connect to a MySQL database using PDO (assume host, database name, username, and password are provided as variables), then execute a simple SELECT query to fetch all rows from a "products" table and display the results.

11. [Level: Advanced] [Type: Conceptual]  
    Explain the security risks of using user input directly in SQL queries (SQL injection) and how PHP's password_hash() and password_verify() functions help mitigate risks when storing and checking passwords.

12. [Level: Intermediate] [Type: Debugging]  
    This PHP form processing script is vulnerable to cross-site scripting (XSS). Identify the issue and suggest a secure fix.  
    ```php
    <?php
    if ($_POST['comment']) {
        echo "<p>Comment received: " . $_POST['comment'] . "</p>";
    }
    ?>
    ```

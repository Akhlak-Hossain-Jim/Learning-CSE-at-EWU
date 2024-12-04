# Greedy Technic 2

## 1. Activity selection problem:

- You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
    <table>
      <thead>
        <tr>
          <th>Sample Input</th>
          <th>Sample output</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>start = {10, 12, 20}</td>
          <td rowspan="2">2</td>
        </tr>
        <tr>
          <td>finish = {20, 25, 30}</td>
        </tr>
      </tbody>
    </table>

## 2. Scheduling problem:

- Given a schedule containing arrival and departure time of trains in a station, find minimum number of platforms needed in the station so to avoid any delay in arrival of any train.
    <table>
      <thead>
        <tr>
          <th>Sample Input</th>
          <th>Sample Output</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><strong>Number of schedules:</strong> 6</td>
          <td rowspan="3">2</td>
        </tr>
        <tr>
          <td><strong>Arrival:</strong> 2.00 2.10 3.00 3.20 3.50 5.00</td>
        </tr>
        <tr>
          <td><strong>Departure:</strong> 2.30 3.40 3.20 4.30 4.00 5.20</td>
        </tr>
      </tbody>
    </table>

## 3. Job sequencing Problem:

- Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.
    <table>
        <thead>
            <tr>
                <th>Sample Input</th>
                <th>Sample Output</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>a 4 20<br>
    b 1 10<br>
    c 1 40<br>
    d 1 30</td>
                <td>c, a</td>
            </tr>
        </tbody>
    </table>

  **Explanation:** (Akhlak's Extra)

  1. **Jobs**: You have a list of jobs, each with:
     - _Deadline_: The last time by which the job must be completed.
     - _Profit:_ The amount earned if the job is completed on time.
     - Each job takes exactly one unit of time to complete.
  2. **Rules:**
     - You can only work on one job at a time.
     - You must finish each job before its deadline.
  3. **Goal:** Schedule the jobs to maximize your total profit.
  4. **Output Explanation:**

     > **Schedule the jobs:**
     >
     > - **Job c**: Deadline is 1. Schedule it on day 1 (it gives the highest profit).
     > - **Job d**: Deadline is 1, but day 1 is already taken by Job c. So, skip it.
     > - **Job a**: Deadline is 4. Schedule it on day 2 (it fits within its deadline and adds profit).
     > - **Job b**: Deadline is 1, but day 1 is already taken. So, skip it.

## 4. Job sequencing problem – Loss minimization:

- We are given N jobs numbered 1 to N. For each activity, let `T[i]` denotes the number of days required to complete the job. For each day of delay before starting to work for job `i`, a loss of `L[i]` is incurred. You are required to find a sequence to complete the jobs so that overall loss is minimized. You can only work on one job at a time.
    <table>
    <thead>
    <tr>
    <th>Sample Input</th>
    <th>Sample Output</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <td>L = {3, 1, 2, 4}<br>
    T = {4, 1000, 2, 5}</td>
    <td>3, 4, 1, 2</td>
    </tr>
    </tbody>
    </table>

  **Explanation:** (Akhlak's Extra)

  1. **Jobs**: You have a list of jobs, each with:

     - **\( T[i] \)**: Time required to complete the job.
     - **\( L[i] \)**: Daily loss incurred for every day of delay before starting the job.

  2. **Rules**:

     - You can only work on **one job at a time**.
     - The loss for each job accumulates based on the number of days it is delayed before you start it.

  3. **Goal**: Find the order of jobs to minimize the **total loss** caused by delays.

  4. **Strategy**:
     - Prioritize jobs that have a **high daily loss rate (\( L[i] \))** and **shorter durations (\( T[i] \))**.
     - Use the ratio \( L[i] / T[i] \) (loss rate) to determine job priority.
     - Schedule jobs in descending order of their loss rates.

  **Output**

  - **Job Sequence**: \( 3, 4, 1, 2 \)
  - This sequence minimizes the total loss because:
    > - Job 3 is prioritized due to the highest loss rate.
    > - Job 4 follows, with the next highest loss rate.
    > - Job 1 is scheduled next.
    > - Job 2, with the lowest loss rate, is completed last, as delaying it has the least impact on the total loss.

## 5. Assign mice to hole:

- There are N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x -1. Any of these moves consumes 1 minute. Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
    <table>
            <thead>
                <tr>
                    <th>Sample Input</th>
                    <th>Sample Output</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>positions of mice are:<br>
    4 -4 2<br>
    positions of holes are:<br>
    4 0 5</td>
                    <td>4</td>
                </tr>
            </tbody>
        </table>

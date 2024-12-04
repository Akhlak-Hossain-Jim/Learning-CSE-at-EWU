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

## 4. Job sequencing problem – Loss minimization:

- We are given N jobs numbered 1 to N. For each activity, let Ti denotes the number of days required to complete the job. For each day of delay before starting to work for job i, a loss of Li is incurred. You are required to find a sequence to complete the jobs so that overall loss is minimized. You can only work on one job at a time.
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

# CSE495 IT Project Management and Entrepreneurship
**Proma Chowdhury**
Lecturer, East West University

---

## Project Scheduling & Arrow Diagrams
The first step toward building a viable project schedule is organizing activities. One way to get organized is by using an arrow diagram.

### Arrow Diagrams in Project Management
Arrow diagrams are project network charts used in the planning stage of project management to schedule activities, which are represented by arrows, to better meet deadlines and use the right resources at the right time.

**Why Are Arrow Diagrams Important?**
* The arrow diagram is important for the project schedule because it leads to determining the critical path.
* They also reveal scheduling and resource problems that might come up and how to resolve them.
* An arrow diagram assists in meeting deadlines.
* It makes it easier to figure out a sequence of events in the project, allowing project managers to drive efficiencies while meeting the timeframe of the project.

---

## Types of Arrow Diagrams

### 1. Activity on Node (AON) Diagram
In this type of diagram, the activities are represented by nodes. The nodes are then connected by arrows. These arrows are used to show the relationship between the activities.

**Example: Building a deck for a house**
First, create a table of three columns: the name of the tasks and an ID, the immediately preceding activity (IPA), and the duration.

| Task | IPA | Duration |
| :--- | :--- | :--- |
| Choose site, A | | 1 |
| Make plans, B | A | 2 |
| Get permit, C | B | 14 |
| Buy materials, D | B | 2 |
| Assemble deck, E | D | 7 |
| Paint or stain, F | E | 1 |
| Inspect work, G | F | 1 |

*Note: Create a box or node broken into two parts. One part has the name of the tasks and the other has the duration. If the activities can occur at the same time, such as submitting the permit and purchasing materials, then they are stacked.*

### 2. Activity on Arrow Diagram
These arrows are then connected by nodes, with the back of the arrow indicating the start of the activity and the front point at the end. The length of the arrow is the duration of that activity, drawn in scale to fit on the diagram.

---

## Project Schedule
A project schedule is a timetable that organizes tasks, resources and due dates in an ideal sequence so that a project can be completed on time. It is created during the planning phase.

**What's Included in a Project Schedule?**
* Deliverables & Tasks
* Task start and end dates
* Task dependencies
* Project calendar
* Work packages
* Task duration and project timeline
* Budgets & Resource availability
* Schedule risk analysis

---

## Critical Path Method (CPM)
The Critical Path Method (CPM) is a project management technique used to identify the longest sequence of dependent tasks that determine the minimum project duration.

* CPM works by calculating key dates for each activity: Early Start (ES), Early Finish (EF), Late Start (LS), and Late Finish (LF) dates.
* These calculations are done by performing forward pass (for ES and EF) and backward pass (for LS and LF) analyses through the project's network, without considering resource constraints.

### Key Calculations

**1. Early Start (ES)**
The earliest time a task can begin without violating dependencies.
* If the task has no predecessors, $ES = 0$ (start of the project)
* If the task has predecessors, $ES =$ maximum EF of all predecessors

**2. Early Finish (EF)**
The earliest time a task can finish if it starts at ES.
* Formula: $EF = ES + \text{duration of the task}$

**3. Late Finish (LF)**
The latest time a task can finish without delaying the project's completion.
* For last task in project $\rightarrow LF = EF$ of project (from forward pass)
* For other tasks $\rightarrow LF =$ minimum LS of all successors

**4. Late Start (LS)**
The latest time a task can start without delaying the project.
* Formula: $LS = LF - \text{duration}$

---

### CPM Example Project

**Initial Task Table**

| Task | Duration (days) | Predecessors |
| :--- | :--- | :--- |
| A | 2 | |
| B | 4 | A |
| C | 3 | A |
| D | 2 | B | C |
| E | 1 | D |

**Forward & Backward Pass / Float Calculation Table**

| Task | Predecessors | Duration | ES | EF | LS | LF | Float | Critical? |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **A** | | 2 | 0 | 2 | 0 | 2 | 0 | **Yes** |
| **B** | A | 4 | 2 | 6 | 2 | 6 | 0 | **Yes** |
| **C** | A | 3 | 2 | 5 | 3 | 6 | 1 | No |
| **D** | B, C | 2 | 6 | 8 | 6 | 8 | 0 | **Yes** |
| **E** | D | 1 | 8 | 9 | 8 | 9 | 0 | **Yes** |

**Analyzing the Float:**
* $\text{Float} = LS - ES = LF - EF$
* Tasks with $LS=ES$ (or $LF=EF$, i.e., $Float = 0$) are **critical tasks**.
* If $Float > 0$, the task has some flexibility.
* **Critical Path:** A $\rightarrow$ B $\rightarrow$ D $\rightarrow$ E
* **Total Duration:** 2 + 4 + 2 + 1 = **9 days** (Shortest time to finish; any delay in these tasks delays the project).

---

## Practice

| Task | Duration (days) | Predecessors |
| :--- | :--- | :--- |
| A | 3 | |
| B | 2 | |
| C | 4 | A |
| D | 3 | A |
| E | 2 | B |
| F | 3 | C, E |
| G | 2 | D, F |
| H | 1 | G |

---

**Thank You**

# CSE495 IT Project Management and Entrepreneurship
**Critical Chain Project Management**
*Continuing from the Critical Path Method*
Proma Chowdhury, Lecturer, East West University

---

## Lecture Outline
1. **Critical Path Method: Network and Schedule:** Task network, forward pass, backward pass, and float.
2. **Resource Constrained Scheduling:** Identifying and resolving conflicts when tasks share a resource.
3. **From the Critical Path Method to the Critical Chain Method:** Removing estimating safety and introducing a shared project buffer.
4. **Buffer Types in CCPM:** Project buffer, feeding buffer, and resource buffer.
5. **Worked Examples:** Two complete projects, scheduled and analyzed end to end.

---

## PART ONE: Critical Path Method
*Network diagram, forward pass, backward pass, and float.*

### Task Data

**Task List**
| Task | Depends On | Duration |
| :--- | :--- | :--- |
| Requirements (A1) | None | 8 days |
| Backend Coding (A2) | A1 | 20 days |
| QA Testing (A3) | A2 | 10 days |
| UI Development (B1) | None | 12 days |
| Integration (B2) | B1, A2 | 8 days |

**Project Overview**
The project consists of five tasks organized into two branches, labeled A and B. The A branch progresses through requirements, backend coding, and QA testing. The B branch progresses through UI development before joining the A branch at the Integration task.

### Network Diagram
* **Branch A:** Requirements (A1 | 8) $\rightarrow$ Backend Coding (A2 | 20) $\rightarrow$ QA Testing (A3 | 10)
* **Branch B:** UI Development (B1 | 12) $\rightarrow$ Integration (B2 | 8)
* *Note: B2 also depends on A2.*

**Reading the Diagram:** Tasks A3 and B2 are both terminal nodes. Neither task has a successor. The project is complete only when both branches are complete, so the project duration is governed by whichever branch finishes last.

### Forward Pass (Early Start and Early Finish)
| Task | ES | Duration | EF |
| :--- | :--- | :--- | :--- |
| A1 Requirements | 0 | 8 | 8 |
| A2 Backend Coding | 8 | 20 | 28 |
| B1 UI Development | 0 | 12 | 12 |
| B2 Integration | $max(28,12)=28$ | 8 | 36 |
| A3 QA Testing | 28 | 10 | 38 |

**Project Completion:** 38 days. The early finish of the final task in each branch determines the project completion date. Task A3 completes last, at day 38.

### Backward Pass (Late Finish, Late Start, and Float)
| Task | LF | LS | Float |
| :--- | :--- | :--- | :--- |
| A3 QA Testing | 38 | 28 | 0 |
| B2 Integration | 38 | 30 | 8 |
| A2 Backend Coding | 28 | 8 | 0 |
| B1 UI Development | 30 | 18 | 18 |
| A1 Requirements | 8 | 0 | 0 |

**Reading the Table:** Tasks with zero float lie on the critical path. Task B1 has 18 days of float.

### Critical Path Summary
* **Critical Path:** A1 $\rightarrow$ A2 $\rightarrow$ A3
* **Total Duration:** 38 Days
* **Critical Tasks (0 Float):** Requirements, Backend Coding, and QA Testing have zero float. Any delay on these tasks delays the entire project.
* **Float on UI Development:** Task B1 may begin as much as 18 days later than scheduled without affecting the project completion date.

---

## PART TWO: Resource Constrained Scheduling
*Identifying and resolving resource conflicts.*

### Resource Assignments
| Task | Depends On | Duration | Resource |
| :--- | :--- | :--- | :--- |
| Requirements (A1) | None | 8 days | Analyst |
| Backend Coding (A2) | A1 | 20 days | Senior Developer |
| QA Testing (A3) | A2 | 10 days | QA Engineer |
| UI Development (B1) | None | 12 days | UI Developer, Senior Developer |
| Integration (B2) | B1, A2 | 8 days | Senior Developer |

**Resource Conflict:** 3 Tasks share the Senior Developer (A2, B1, B2). Since one person cannot perform two tasks at once, the unconstrained schedule is not feasible. 
* **One Person, Three Tasks:** In the unconstrained schedule, Backend Coding occupies the Senior Developer from day 8 to day 28, while UI Development occupies the same resource from day 0 to day 12. These intervals overlap from day 8 to day 12. Integration begins only after both predecessor tasks are complete, so it does not introduce an additional conflict.

### Resource Leveling (Two Feasible Orderings)
Since Backend Coding and UI Development share the Senior Developer, one task must precede the other. Both orderings are resource feasible, but they do not produce the same project duration.

**Ordering 1: Backend Coding First**
| Task | Start | End |
| :--- | :--- | :--- |
| A1 | 0 | 8 |
| A2 | 8 | 28 |
| A3 | 28 | 38 |
| B1 | 28 | 40 |
| B2 | 40 | 48 |
*Project Duration: 48 Days*

**Ordering 2: UI Development First**
| Task | Start | End |
| :--- | :--- | :--- |
| A1 | 0 | 8 |
| B1 | 0 | 12 |
| A2 | 12 | 32 |
| A3 | 32 | 42 |
| B2 | 32 | 40 |
*Project Duration: 42 Days*

**Conclusion:** Ordering 2 yields the shorter project duration and is adopted for the remaining analysis.

---

## PART THREE: From CPM to the Critical Chain Method
*Removing estimating safety and introducing a shared buffer.*

### Estimating Safety Margins
1. Individual task durations conventionally include a safety margin to account for uncertainty.
2. When tasks are scheduled sequentially because they share a resource, these safety margins accumulate from one task to the next.
3. Under Ordering 2, the resource constrained schedule already extends the unconstrained duration from 38 to 42 days, before any task overruns its own estimate.
4. The Critical Chain Method removes the embedded safety from each task and instead protects the project with a single shared buffer.

**Removing Estimating Safety:** Each estimate is assumed to contain approximately 50 percent safety margin. This margin is removed from individual tasks and reintroduced later as a single project buffer.

| Task | Original Estimate | Reduced Estimate |
| :--- | :--- | :--- |
| A1 | 8 | 4 |
| A2 | 20 | 10 |
| A3 | 10 | 5 |
| B1 | 12 | 6 |
| B2 | 8 | 4 |

### Identifying the Critical Chain
Using the reduced durations and the resource ordering established in Part Two, the schedule is rebuilt with UI Development scheduled before Backend Coding.

| Task | Duration | Start | End | Notes |
| :--- | :--- | :--- | :--- | :--- |
| B1 UI Development | 6 | 0 | 6 | **Critical Chain = 21 days** |
| A1 Requirements | 4 | 0 | 4 | The chain links UI Development, |
| A2 Backend Coding | 10 | $max(4,6)=6$ | 16 | Backend Coding, and QA Testing |
| A3 QA Testing | 5 | 16 | 21 | through task dependency and the |
| B2 Integration | 4 | 16 | 20 | shared Senior Developer constraint. |

### Adding the Project Buffer
The project buffer is conventionally sized at 50 percent of the critical chain length and placed at the end of the schedule.
* **Critical Chain:** 21 days (UI Development, Backend Coding, QA Testing)
* **Project Buffer:** 11 days (Approximately 50% of the critical chain, rounded)
* **CCPM Total:** 21 + 11 = **32 days** (The protected completion date)

### Schedule Comparison Summary
* CPM Unconstrained: **38 days**
* Resource Leveled Ordering 1: **48 days**
* Resource Leveled Ordering 2: **42 days**
* CCPM: **32 days**

*The Critical Chain Method achieves the shortest planned duration by removing redundant individual safety margins while protecting the overall schedule with a single shared buffer.*

---

## PART FOUR: Buffer Types in CCPM

### 1. Project Buffer (PB)
Placed at the end of the critical chain. It absorbs delays that occur on critical chain tasks so that the planned completion date remains achievable. It is typically sized at 50 percent of the critical chain length.

### 2. Feeding Buffer (FB)
Placed where a non-critical path merges into the critical chain. It absorbs delays on the feeding path so that the critical chain itself is not delayed. It is typically sized at 50 percent of the feeding path length.

### 3. Resource Buffer (RB)
Not a time buffer. It is an advance notification placed before a critical chain task that requires a resource not already engaged on the chain, ensuring that resource is available exactly when needed.

---

## WORKED EXAMPLE 1: Inventory Management System

### Project Data
| Task | Depends On | Duration | Resource |
| :--- | :--- | :--- | :--- |
| Database Design (D1) | None | 10 days | Database Architect |
| API Development (D2) | D1 | 16 days | Backend Developer |
| Testing (D3) | D2 | 8 days | QA Analyst |
| Frontend UI (E1) | None | 12 days | Database Architect, Frontend Developer |
| Integration (E2) | D2, E1 | 6 days | Backend Developer |

* **Two Branches:** D1 $\rightarrow$ D2 $\rightarrow$ D3 forms one branch. E1 $\rightarrow$ E2 forms a second branch. Both branches require the Database Architect at the outset.

### Network and Resource Leveling
* **Unconstrained:** 34 days
* **Resource Leveled:** 34 days
* *Note:* Sequencing Database Design before Frontend UI allows the Database Architect to complete the critical path task first. As a result, resource leveling does not extend the project duration in this case. Reversing the order, Frontend UI before Database Design, would extend the project to 46 days.

### Critical Chain and Project Buffer
| Task | Reduced Duration | Start | End |
| :--- | :--- | :--- | :--- |
| D1 Database Design | 5 | 0 | 5 |
| E1 Frontend UI | 6 | 5 | 11 |
| D2 API Development | 8 | 5 | 13 |
| D3 Testing | 4 | 13 | 17 |
| E2 Integration | 3 | 13 | 16 |

* **Critical Chain:** 17 days
* **Protected Finish:** 26 days, including project buffer
* *Note:* The critical chain follows Database Design, API Development, and Testing, totaling 17 days. The project buffer is approximately 50 percent of this length, rounded to 9 days, giving a protected completion date of 26 days.

---

## WORKED EXAMPLE 2: App Launch Project

### Locating the Buffers
The critical chain comprises Design, Build, and Deploy. A feeding chain, consisting of Content Preparation and Asset Review, merges into the chain before Deploy, which also requires an external DevOps Engineer.

* **Critical Chain:** Design (4) $\rightarrow$ Build (6) $\rightarrow$ Deploy (4) $\rightarrow$ PB (7)
* **Feeding Chain:** Content (4) $\rightarrow$ Review (2) $\rightarrow$ FB (3)
* **Resource Buffer (RB):** Alert: DevOps Engineer required before "Deploy".

*The feeding buffer protects Deploy from a delayed feeding chain. The resource buffer ensures the DevOps Engineer is available exactly when Deploy begins. The project buffer protects the final completion date.*

### Buffer Sizing and Final Schedule
| Chain | Tasks | Length | Buffer, 50% |
| :--- | :--- | :--- | :--- |
| Critical chain | Design, Build, Deploy | $4+6+4=14$ | $PB=7$ |
| Feeding chain | Content, Review | $4+2=6$ | $FB=3$ |
| Resource, Deploy | DevOps Engineer flagged | Not applicable | RB: alert, not days |

**Protected Finish: 21 days**

### Final Schedule
| Milestone | Day |
| :--- | :--- |
| Design and Build finish | 10 |
| Content, Review, and FB finish | 9, ahead of Deploy |
| Deploy finishes | 14 |
| Project buffer ends | 21 |

*Note:* 14 days on the critical chain plus 7 days of project buffer. The feeding chain finishes ahead of schedule even after its own buffer, so it does not threaten the start of Deploy. The resource buffer adds no days to the schedule, since it is a timely notification rather than a time allowance.

---

## SUMMARY (Key Takeaways)
1. The Critical Path Method identifies the logical sequence of tasks that determines the minimum project duration, prior to any resource considerations.
2. Resource constraints can alter the achievable schedule. The order in which conflicting tasks are scheduled materially affects total project duration.
3. The Critical Chain Method removes individual task safety margins and instead protects the project with a single shared project buffer.
4. Feeding buffers protect the critical chain from delays on merging paths. Resource buffers ensure that externally shared resources are available when required.

---

**Thank You**

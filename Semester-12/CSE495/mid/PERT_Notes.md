# CSE495 IT Project Management and Entrepreneurship
**Proma Chowdhury**
Lecturer, East West University

---

## PERT
* PERT stands for Program Evaluation and Review Technique.
* It's a project management tool used to plan, schedule, and control complex projects, especially when task durations are uncertain.
* It's often used alongside CPM (Critical Path Method), but while CPM assumes deterministic (fixed) times, PERT deals with uncertainty by using probabilistic time estimates.

## When to Use PERT?
* The project involves new or uncertain tasks (e.g., R&D, software development).
* You need to estimate total project time or find which tasks are critical.
* You want to quantify schedule risk (probability of finishing on time).

---

## PERT Time Estimates

| Type | Meaning | Formula Symbol |
| :--- | :--- | :--- |
| **Optimistic time (O)** | Minimum possible time if everything goes well | a |
| **Most likely time (M)** | Best estimate under normal conditions | m |
| **Pessimistic time (P)** | Maximum possible time if things go wrong | b |

From these, PERT computes:

**Expected Time (TE):**
$$TE=\frac{a+4m+b}{6}$$
*Weighted average (more weight to the most likely time).*

**Variance ($\sigma^{2}$):**
$$\sigma^{2}=\left(\frac{b-a}{6}\right)^{2}$$
*Measures the uncertainty of each task's duration.*

---

## Example 1

| Work | a | m | b | $TE = (a+4m+b)/6$ | $Var = ((b-a)/6)^{2}$ | Predecessor |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| A | 1 | 2 | 3 | 2 | 0.11 | |
| B | 2 | 3 | 8 | 3.67 | 1 | A |
| C | 1 | 1 | 1 | 1 | 0 | A |
| D | 3 | 4 | 5 | 4 | 0.11 | B, C |

### Find All Paths
* **Path 1:** $A \rightarrow B \rightarrow D = 2.0 + 3.67 + 4.0 = 9.67$
* **Path 2:** $A \rightarrow C \rightarrow D = 2.0 + 1.0 + 4.0 = 7.0$

* **Critical Path:** A-B-D, total duration = **9.67 weeks**
* **Total variance:** $0.11 + 1.0 + 0.11 = 1.22$
* **Standard Deviation:** $\sigma = \sqrt{1.22} \approx 1.1$

### Schedule Risk
If the deadline is $T = 11$ weeks, then:
$$Z = \frac{T - TE_{project}}{\sigma} = \frac{11 - 9.67}{1.1} = 1.21$$

From the Z-table, $P(Z=1.21) \approx 0.887$
*So, there's an **88.7% chance** the project finishes by 11 weeks.*

---

## Summary

| Metric | Formula / Definition |
| :--- | :--- |
| **Expected Time** | $(a+4m+b)/6$ |
| **Variance** | $((b-a)/6)^{2}$ |
| **Critical Path** | Longest path in network |
| **Std. Deviation** | $\sqrt{\text{sum of variances}}$ |
| **Z-Score** | $(T - TE_{project}) / \sigma$ |

---

## Example Question 2

| Activity | Predecessor | a | m | b | TE | Variance | ES | EF | LS | LF | Float |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **A** | | 2 | 4 | 6 | 4 | 0.444 | 0 | 4 | 0 | 4 | 0 |
| **B** | A | 3 | 5 | 9 | 5.33 | 1 | 4 | 9.33 | 4 | 9.33 | 0 |
| **C** | A | 4 | 6 | 8 | 6 | 0.444 | 4 | 10 | 6.33 | 12.33 | 2 |
| **D** | B | 2 | 3 | 8 | 3.67 | 1 | 9.33 | 13 | 9.33 | 13 | 0 |
| **E** | B | 1 | 2 | 3 | 2 | 0.111 | 9.33 | 11.33 | 11 | 13 | 1.67 |
| **F** | C | 3 | 4 | 5 | 4 | 0.111 | 10 | 14 | 12.33 | 16.33 | 2.33 |
| **G** | D, E | 4 | 6 | 10 | 6.33 | 1 | 13 | 19.33 | 13 | 19.33 | 0 |
| **H** | E, F | 2 | 3 | 4 | 3 | 0.111 | 14 | 17 | 16.33 | 19.33 | 2.33 |
| **I** | G, H | 5 | 7 | 9 | 7 | 0.444 | 19.33 | 26.33 | 19.33 | 26.33 | 0 |

*(Note: Activity 'I' inferred from the final row representing the G, H predecessor).*

### Calculate Variance and Standard Deviation of the Project
**Project variance:**
$$Var_{project} = 0.444 + 1 + 1 + 1 + 0.444 = 3.888$$

**Project standard deviation:**
$$\sigma = \sqrt{Var_{project}} = \sqrt{3.888} \approx 1.9718 \text{ days}$$

---

**Thank You**

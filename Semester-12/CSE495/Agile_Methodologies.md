# Agile Processes and Methodologies
**Proma Chowdhury**, Lecturer, East West University

---

## What is Agility?
* Response to changing requirements appropriately
* Effective communication among all stakeholders
* Drawing the customer onto the team
* Organizing a team so that it is in control of the work performed
* Rapid, incremental delivery of software

### Why is Agility Necessary?
* It is difficult to predict in advance which software requirements will persist and which will change. It is equally difficult to predict how customer priorities will change as the project proceeds.
* For many types of software, design and construction are interleaved. It is difficult to predict how much design is necessary before construction is used to prove the design.
* Analysis, design, construction, and testing are not as predictable (from a planning point of view) as we might like.

### Characteristics of an Agile Process
* Is driven by customer descriptions of what is required (scenarios)
* Recognizes that plans are short-lived
* Develops software iteratively with a heavy emphasis on construction activities
* Delivers multiple software increments
* Adapts as changes occur

### Agility Principles
* Satisfy the customer through early and continuous delivery of valuable software.
* Welcome changing requirements, even late in development. Agile processes harness change for the customer's competitive advantage.
* Deliver working software frequently, from a couple of weeks to a couple of months, with a preference to the shorter timescale.
* Business people and developers must work together daily throughout the project.

### Common Agile Processes
* Extreme Programming (XP)
* Adaptive Software Development (ASD)
* Scrum
* Dynamic Systems Development Method (DSDM)
* Crystal
* Feature Drive Development (FDD)
* Lean Software Development (LSD)
* Agile Modeling (AM)
* Agile Unified Process (AUP)

---

## Extreme Programming (XP)
Extreme Programming (XP) is an Agile software development methodology that focuses on delivering high-quality software through frequent and continuous feedback, collaboration, and adaptation. XP emphasizes a close working relationship between the development team, the customer, and stakeholders, with an emphasis on rapid, iterative development and deployment.

### Key Concepts in XP
* **User Stories:** A User Story is a conventional description by the user of a feature of the required system. It does not mention finer details such as the different scenarios that can occur.
* **Metaphor:** Based on User stories, the project team proposes Metaphors. Metaphors are a common vision of how the system would work.
* **Spike:** The development team may decide to build a Spike for some features. A Spike is a very simple program that is constructed to explore the suitability of a solution being proposed. It can be considered similar to a prototype.

### Good Practices in XP
* **Pair Programming:** A collaborative programming practice in which two developers work together at a single workstation. One developer ("the driver") writes the code, while the other ("the navigator") continuously reviews each line as it is typed.
* **Test-Driven Development (TDD):** A disciplined development approach where automated tests are written before the actual code.
* **Incremental Development:** Building software in small, functional increments, each of which adds measurable value to the product.
* **Continuous Integration (CI):** Developers frequently merge their code changes into a shared repository, often several times per day. Each integration triggers an automated build and test sequence.
* **Refactoring:** The process of restructuring existing code without altering its external behavior. Refactoring improves internal design, readability, and maintainability.
* **Collective Code Ownership:** A team principle stating that no single developer "owns" any part of the code; instead, the entire team shares responsibility for the whole codebase.
* **Planning Game:** An XP planning technique where customers and developers collaborate to define, prioritize, and schedule features.
* **On-site Customer:** A representative of the customer works directly with the development team on a daily basis.

---

## Scrum
* Scrum is an agile development methodology used in the development of Software based on an iterative and incremental processes.
* Scrum is adaptable, fast, flexible and effective agile framework that is designed to deliver value to the customer throughout the development of the project.
* The primary objective of Scrum is to satisfy the customer's need through an environment of transparency in communication, collective responsibility and continuous progress.
* The development starts from a general idea of what needs to be built, elaborating a list of characteristics ordered by priority (product backlog) that the owner of the product wants to obtain.

### Scrum Core Roles
* **Product Owner:** Owns the Product Backlog and maximizes ROI. Defines and prioritizes product features. Chooses what goes into each Sprint. Represents the voice of customers and stakeholders. One and only one Product Owner per product.
* **Development Team:** 5-9 cross-functional members who build the product. Self-organizing. Multi-skilled (analysis, design, coding, testing, etc.). No fixed job titles. 100% dedicated during the Sprint.
* **Scrum Master:** A servant-leader and coach for the team. Ensures Scrum is understood and applied correctly. Removes impediments and shields the team from external pressure. Facilitates continuous improvement. They are not a traditional project manager.

### Core Artifacts
* **Product Backlog:** The master list of everything that might be built. Prioritized by the Product Owner for maximum business value. Continuously refined. Uses user stories or other requirement forms.
* **Sprint Backlog:** Created during Sprint Planning. A list of Product Backlog items chosen for the Sprint + the tasks to complete them. Owned and updated by the team daily.
* **Increment / "Definition of Done":** The integrated, tested, documented, potentially shippable product increment. "Done" means it meets all quality criteria with nothing left for later testing or fixing.

### Scrum Events (The 5 Ceremonies)

| Event | Purpose | Duration | Participants |
| :--- | :--- | :--- | :--- |
| **1. Sprint** | Fixed iteration producing a usable product increment | 1-4 weeks | Whole team |
| **2. Sprint Planning** | Decide what to deliver and how | 2 parts: what + how (1h/week of Sprint per part) | Team, Product Owner, Scrum Master |
| **3. Daily Scrum** | 15-minute stand-up to synchronize and plan next 24 hours | Daily | Team (SM observes) |
| **4. Sprint Review** | Inspect the product and gather feedback | 1h/week of Sprint | Team, PO, Stakeholders |
| **5. Sprint Retrospective** | Inspect the process and improve it | 45 min/week of Sprint | Team, SM, (PO optional) |

### How Scrum Flows
1. **Prepare the Product Backlog:** The Product Owner lists, prioritizes, and refines all desired work.
2. **Plan the Sprint:** The team selects top-priority items they can complete this Sprint and defines a Sprint Goal.
3. **Execute and Inspect Daily:** The team develops, tests, and integrates work every day, discussing progress and blockers in the Daily Scrum.
4. **Review the Increment:** The team demonstrates completed work to stakeholders; feedback goes back into the Product Backlog.
5. **Reflect and Improve:** In the Retrospective, the team identifies what to keep, stop, or change in the next Sprint.

---

## Differences Between Scrum and XP

| Aspect | Scrum | Extreme Programming (XP) |
| :--- | :--- | :--- |
| **Main Focus** | Managing the process and teamwork | Improving code quality and adaptability |
| **Goal** | Deliver working product in short Sprints | Build clean, high-quality, easily changeable code |
| **Iteration Name & Length** | Sprint (1-4 weeks, fixed scope) | Iteration (1-2 weeks, flexible scope) |
| **Customer Role** | Product Owner represents the customer | On-site Customer works with team daily |
| **Planning Method** | Sprint Planning (what & how for each Sprint) | Planning Game (priorities + estimates) |
| **Roles** | Product Owner, Scrum Master, Development | Developers + On-site Customer |
| **Engineering Practices** | Not defined (team decides) | Strict practices: TDD, Pair Programming, CI |
| **Testing** | Testing within Sprint, not prescribed | Test-Driven Development (tests before code) |
| **Integration** | Done during Sprint | Continuous Integration |
| **Refactoring** | Optional, up to team | Core, frequent activity |
| **Code Ownership** | Shared responsibility encouraged | Collective ownership required |
| **Documentation** | Light (Backlogs, Definition of Done) | Minimal, focus on communication |
| **Feedback** | After each Sprint | Continuous (daily) |
| **Adaptation** | Sprint Retrospective | Ongoing improvement through feedback |
| **Team Size** | 5-9 members | Small, highly collaborative team |
| **Cultural Values / Best For** | Transparency, inspection, adaptation / Managing complex projects & delivery flow | Communication, simplicity, courage, respect / Ensuring technical excellence & flexibility |

# CSE495 Software Engineering
**Proma Chowdhury**
Lecturer, East West University

---

## Why Do Projects Fail?
* Scope Creep
* Poor Estimation
* Unclear Deliverables
* Communication Gaps

> "A Work Breakdown Structure is one of the first tools that makes your project manageable and measurable."

---

## Introduction
* A Work Breakdown Structure (WBS) is a hierarchical decomposition of a project into smaller, manageable components called work packages.
* It helps project teams understand the scope of the project and organize work into sections that are easier to plan, assign, track, and complete.
* **Objective:** To break down the total scope of work into smaller parts to ensure project completeness and clear responsibilities.

## The 100% Rule
* Every deliverable, task, and activity needed to complete the project's objectives must appear somewhere in the WBS.
* It also means that no work outside the WBS is part of the project.
* There should be no overlap between components (each belongs to exactly one parent).
* Ensures completeness, clarity, and control.

---

## Practice Scenario
You're managing a software project called "CampusConnect" which is a university portal that lets students register for courses, check grades, and chat with advisors.

In the kickoff meeting, the client says: 
*"The portal should include a web dashboard, a mobile app, and a back-end system for storing student data. After launch, we also need user training and documentation."*

### Proposed WBS Draft
1.0 CampusConnect System
* 1.1 UI/UX Design
* 1.2 Frontend Development
* 1.3 Backend Development
* 1.4 Mobile App Development
* 1.5 Database Design
* 1.6 API Development
* 1.7 Testing
* 1.8 Deployment
* 1.9 Documentation

### What violations did the WBS make?
* **Missing Deliverable (Incomplete Scope):** The scenario mentions "User Training," but it is not listed in the draft.
* **Overlap (Double-counting work):** * "Frontend Development" and "Mobile App Development" both include UI work.
  * "API Development" and "Backend Development" might cover the same logic layer hence, duplicated effort.

---

## Structure and Components
The structure flows from PROJECT → Task → Sub-Task → Work Package.

**Levels of WBS:**
* **Level 1:** The overall project (e.g., "Website Development Project")
* **Level 2:** Major deliverables or phases (e.g., "Frontend", "Backend", "Testing")
* **Level 3:** Sub-deliverables or tasks (e.g., "UI Design", "API Integration")
* **Level 4:** Work packages (e.g., "Login Page Design")

*Note: Each element should represent a measurable deliverable, not just an activity.*

---

## Significance of WBS
* Provides a clear roadmap of tasks
* Helps in estimating costs and time
* Facilitates resource allocation
* Aids in risk identification
* Improves communication across teams
* Serves as a basis for scheduling and tracking progress

---

## How to Build a WBS
* Begin with the Charter, focusing on Objectives and Deliverables
* Break the main product(s) down into sub-products
* Set the structure to match how you'll manage the project
* Lowest level not too detailed, not too large

---

## Example WBS Structures

### 1. Planning a Press Conference
* **Planning:** Plan approval, Budget, Coordination
* **Venue:** Deciding venue, Booking venue, Arranging catering
* **Speakers:** Deciding topics, The speech of the Head of the hospital, Briefing the other speakers
* **Marketing:** Printing flyers, Mailing flyers, Preparing press-kits, Sending email reminders
* **Registration:** Creating a register, Registering media representatives, Approval from committee, Balancing accounts

### 2. Renovation Project (Process Style)
* **Design:** Kitchen Design, Bathroom Design, Ensuite Design, Painting Design
* **Renovation Phase:** Work Packages 1 to 4
* **Finishing Phase:** Work Packages 1 to 4

### 3. Company Holiday Party
* **Initiation:** Choose party date/time, Decide food/beverages, Decide on party activities, Cost estimation, Create party invites
* **Preparation:** Send invites, Acquire food/beverages, Book venue, Create party playlist
* **Execution:** Arrive at venue for setup, Welcome guests, Enjoy party, Clean up after party
* **Follow-up:** Thank guests for coming, Follow up survey, Discuss improvements for next year

---

## Types of WBS
1. **Deliverable-based:** Based on deliverables or outputs
2. **Phase-based:** Based on phases of the project life cycle
3. **Function-based:** Based on departments or functions (e.g., Design, QA)

---

### Type 1: Deliverable-based WBS
*"What we produce."* Breaks down the project by final outputs or tangible deliverables, not by time or team. Used when your goal is clear, concrete products.

**E-Commerce Website Project**

| Level | WBS Element | Implementation Details |
| :--- | :--- | :--- |
| **1** | **E-Commerce Website Project** | |
| **1.1** | **User Interface Design** | |
| 1.1.1 | Wireframes & Mockups | Sketch homepage, product page, checkout flow using Figma |
| 1.1.2 | UI Style Guide | Define fonts, color palette, button styles, icons |
| 1.1.3 | Responsive Layout Implementation | CSS grid setup, media queries for mobile/tablet |
| **1.2** | **Product Catalog System** | |
| 1.2.1 | Database Schema for Products | Create products, categories, inventory tables in PostgreSQL |
| 1.2.2 | Admin Panel for Product Entry | Develop CRUD operations for products (Django Admin) |
| 1.2.3 | Product Search & Filters | Implement search bar, category filters, pagination |
| **1.3** | **Shopping Cart & Checkout** | |
| 1.3.1 | Cart Functionality | Add/remove items, track quantities, sync to session |
| 1.3.2 | Order Summary & Coupons | Calculate subtotal, discounts, and tax dynamically |
| 1.3.3 | Checkout Workflow | Build order form, address verification, confirmation screen |
| **1.4** | **Payment Gateway Integration** | |
| 1.4.1 | API Setup for Payment Provider | Connect to Stripe API sandbox |
| 1.4.2 | Transaction Logging | Store payment status and transaction IDs securely |
| 1.4.3 | Security & Encryption Tests | Test SSL, prevent duplicate transactions |
| **1.5** | **User Support Portal** | |
| 1.5.1 | FAQ Section | Create markdown content for FAQs |
| 1.5.2 | Chatbot or Contact Form | Integrate ChatGPT API or custom Flask form |
| 1.5.3 | Ticket Management System | Build backend queue for support requests |

---

### Type 2: Phase-based WBS
Breaks the project down by sequential phases of the life cycle e.g., Initiation → Planning → Execution → Closure. Used when your process matters more than the product.

**Mobile App Project**

| Level | WBS Element | Implementation Details |
| :--- | :--- | :--- |
| **1** | **Mobile App Project** | |
| **1.1** | **Initiation Phase** | |
| 1.1.1 | Requirement Gathering | Conduct stakeholder interviews, prepare MoSCOW list |
| 1.1.2 | Feasibility Study | Analyze app platform (iOS/Android), cloud cost estimate |
| 1.1.3 | Project Charter Approval | Draft and sign approval with steering committee |
| **1.2** | **Design Phase** | |
| 1.2.1 | Wireframe Design | Design UI flow in Figma |
| 1.2.2 | UI Prototype | Build clickable prototype for usability testing |
| 1.2.3 | Architecture Planning | Choose Flutter + Firebase stack, define API routes |
| **1.3** | **Development Phase** | |
| 1.3.1 | Frontend Coding | Develop screens (login, dashboard, chat) |
| 1.3.2 | Backend Development | Create REST APIs for user data, notifications |
| 1.3.3 | Integration Testing | Connect front-end and back-end, fix API mismatches |
| **1.4** | **Implementation Phase** | |
| 1.4.1 | User Acceptance Testing | Pilot test with 20 students |
| 1.4.2 | Deployment to App Store | Configure signing keys, upload to Google Play |
| 1.4.3 | Data Migration | Import student data from CSV into Firebase |
| **1.5** | **Closure Phase** | |
| 1.5.1 | Final Documentation | Prepare user manual and API reference |
| 1.5.2 | User Training & Handover | Record tutorial videos, deliver admin credentials |

---

### Type 3: Function-Based WBS
Breaks down work by department, discipline, or specialization. Used in organizations with distinct teams or divisions.

**New Product Launch Project**

| Level | WBS Element | Implementation Details |
| :--- | :--- | :--- |
| **1** | **Product Launch Project** | |
| **1.1** | **Design Department** | |
| 1.1.1 | Industrial Design Concepts | Brainstorm sketches for eco-bottle |
| 1.1.2 | CAD Modeling | Create 3D model using SolidWorks |
| 1.1.3 | Prototype Mockups | 3D print initial prototypes for testing |
| **1.2** | **Engineering Department** | |
| 1.2.1 | Component Testing | Measure tensile strength, heat resistance |
| 1.2.2 | Assembly Process Design | Design assembly line layout in AutoCAD |
| 1.2.3 | Quality Assurance | Develop inspection checklist, ISO audit |
| **1.3** | **Marketing Department** | |
| 1.3.1 | Branding Strategy | Define logo, slogan, and color palette |
| 1.3.2 | Advertising Campaigns | Run digital ads on Instagram & YouTube |
| 1.3.3 | Product Launch Event | Organize media event, influencer outreach |
| **1.4** | **Finance Department** | |
| 1.4.1 | Budget Estimation | Estimate cost per unit and break-even point |
| 1.4.2 | Cost Tracking | Update cost ledger weekly |
| 1.4.3 | ROI Analysis | Calculate profit margin post-launch |

---

## Final Practice Example
A company plans to develop a mobile application to enhance customer engagement and service delivery. The app must include features like user registration, real-time notifications, payment integration, and analytics.

To manage the project efficiently, a Work Breakdown Structure (WBS) is required that outlines key deliverables and decomposes them into smaller, manageable tasks.

**Objective:** Develop a WBS that clearly structures all phases and components of the mobile app development process to ensure timely, cost-effective, and quality delivery.

---

**Thank You**

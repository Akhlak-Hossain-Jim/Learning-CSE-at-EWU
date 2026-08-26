# Data Center Design
*Building & Redesigning for Reliability*
CSE407 Green Computing · Class 11 of 22 · Aug 5, 2025 · Tuesday · 1h 30min

From site selection to Tier certification — how data centers are engineered for reliability and density, and what triggers a redesign once one is already running.

**References:** 📘 Velete Ch.12 (all) | 📗 Lamb Ch.6 (all) | 🎯 CO3 | 🧠 EP1, EP2, EP5 | 🚌 Field Trip: Data Center

**Key stats:**
- **99.995%** — Tier IV uptime guarantee — ≈26 min downtime allowed per year
- **2N** — Full redundancy model — every component path fully duplicated
- **15–20** — Years — typical design life before a major redesign is triggered
- **4** — Uptime Institute Tier levels (I–IV) used worldwide to rate reliability

## Quick recap & homework review
*Opening · 5 min*
University sustainability case studies recap + midterm assessment debrief

- Before the midterm break, we looked at university and institutional case studies through the Greening University Toolkit. Today we move into one of the most concrete engineering topics in this course: how data centers are actually designed from the ground up — and what it takes to redesign one once it's already in operation.
- **🏫 Greening University Toolkit** — A structured framework for auditing and improving sustainability across campus IT — energy, procurement, e-waste, and culture.
- **📋 Case study method** — AS-IS vs TO-BE analysis, stakeholder interviews, and evidence-based recommendations — the same rigor applies to data center audits.
- **🎯 Midterm assessment** — Your IoT energy-monitoring dashboards are underway. Today's PUE and capacity concepts feed directly into that deliverable.
- 🗣 Homework Debrief (5 min)
- **?**
- From your midterm energy-monitoring work so far: what's the single biggest inefficiency you've spotted in your lab or infrastructure, and what would fixing it require in terms of physical redesign — not just software? — 2–3 groups share findings

## Designing a data center from scratch
*Foundation · 10 min*
Site selection, load estimation, and the design decisions that lock in for decades

- A data center is one of the few pieces of civil engineering where a bad early decision can't be patched with software later. Site selection, structural loading, and electrical capacity are largely fixed once construction begins — so design starts long before the first server rack arrives.

> **🧭 The core design question**
> Every design decision traces back to one question: what level of risk is acceptable, and what will the organization pay to reduce it? A bank's core transaction system and a university's research file server have very different answers — and that difference drives everything from Tier level to redundancy to site choice.

- 18–24 — Months — typical construction timeline for a purpose-built enterprise data center
- 2–4× — Land footprint multiplier needed beyond the building itself, for cooling plant, generators, and expansion
- ≥2 — Independent utility power feeds recommended from separate substations
- ≥2 — Diverse fiber paths recommended, physically separated to avoid a single backhoe cutting both
- Site selection weighs a fixed set of criteria that rarely change, only their relative importance:
- **📍 Site selection criteria**
- Grid power availability & cost per kWh — Natural disaster risk (flood, earthquake, cyclone) — Climate — cooling potential, humidity — Fiber connectivity & network latency to users — Water availability for cooling — Land cost, zoning, and tax incentives
- **📐 Early design decisions**
- Target Tier level (reliability vs. cost) — Raised floor vs. slab — cabling & airflow strategy — Modular vs. monolithic build-out — Target rack density (kW/rack) for the building's life — Structural load rating for future high-density racks

> **⚠️ The over-build vs. under-build trap**
> Building for peak day-one capacity wastes capital and runs infrastructure at inefficient partial load for years. Building too small forces a disruptive expansion later. Modular design — building the shell for full capacity but installing power and cooling in phases as demand grows — is now the industry-standard compromise.

## The Uptime Institute Tier classification system
*Core Concept · 15 min*
The industry-standard vocabulary for describing data center reliability

- When someone says a data center is "Tier III," they're referencing a specific, certifiable standard from the Uptime Institute. Four tiers describe increasing levels of redundancy and fault tolerance — and each step up costs significantly more to build and operate.

| Tier | Description | Uptime % | Max downtime/yr | Redundancy |
|---|---|---|---|---|
| **Tier I** | Basic capacity — single path for power & cooling, no redundancy | 99.671% | 28.8 hrs | N |
| **Tier II** | Redundant components, still a single distribution path | 99.741% | 22.0 hrs | N+1 |
| **Tier III** | Concurrently maintainable — any component can be serviced without downtime | 99.982% | 1.6 hrs | N+1 |
| **Tier IV** | Fault tolerant — a single failure anywhere causes no impact | 99.995% | 0.4 hrs (26 min) | 2N or 2N+1 |

> **💡 The key distinction: redundancy vs. concurrent maintainability**
> Tier II has spare components (N+1), but taking the single distribution path down for maintenance still causes an outage. Tier III's defining feature is that every capacity component and distribution path can be shut down for planned maintenance with zero impact on IT operations — a subtle but critical engineering difference.

- **💰 Cost reality** — Each Tier step roughly adds 20–50% to both capital and operating cost. Tier IV facilities can cost 2× or more per kW of IT capacity versus Tier I — the price of near-zero downtime.
- **🏦 Who needs what** — Core banking systems and stock exchanges typically demand Tier III or IV. Most enterprise back-office and university systems are well served by Tier II or III.

## Redundancy models & capacity planning
*Key Technique · 15 min*
N, N+1, and 2N — how much spare capacity is enough?

- Redundancy notation describes how much spare capacity exists beyond what's strictly needed to run the load. **N** is the number of units required to meet demand — everything else is expressed relative to N.
- **N — No Redundancy**
- **Bare minimum capacity** — Every unit installed is required — no spares
- **Reliability** — Any single component failure causes an outage. Lowest cost, lowest reliability.
- **Typical use** — Development/test environments, non-critical internal tools, Tier I facilities.
- **N+1**
- **One spare unit** — One extra unit beyond what's required
- **Reliability** — Tolerates one component failure or one unit down for maintenance without impact.
- **Typical use** — Most Tier II/III enterprise data centers — the most common commercial standard.
- **2N**
- **Full duplication** — The entire capacity path is built twice, end to end
- **Reliability** — Two completely independent power/cooling paths — a failure in one path has zero effect on the other.
- **Typical use** — Tier IV facilities, financial exchanges, national critical infrastructure.
- **2N+1**
- **Full duplication + spare** — Two full paths, each with its own N+1 spare
- **Reliability** — Highest commercially deployed reliability tier — extremely rare given the cost.
- **Typical use** — Central bank settlement systems, stock exchange matching engines, hyperscale flagship sites.
- **🔧 Interactive: Capacity Planning Calculator**
- **Pick a redundancy model and IT load. See the total infrastructure you'd need to install (assuming 4 parallel modules cover the base N load).**
- **N** (×1 capacity, Tier I, downtime 28.8 hrs/yr) — **N+1** (×1.25 capacity, Tier III, downtime 1.6 hrs/yr) — **2N** (×2 capacity, Tier IV, downtime 0.4 hrs/yr) — **2N+1** (×2.25 capacity, Tier IV+, downtime ~5 min/yr)
- Required IT load (kW) — **800 kW**
- **Total installed capacity** — 800 kW — Overbuild: 0 kW (0%)
- Maps to roughly: Tier I
- N (cheapest)2N+1 (most reliable)
- Est. downtime: 28.8 hrs/yr

## Redesigning an existing data center
*Applied · 10 min*
What triggers a redesign, and greenfield vs. retrofit trade-offs

- Most data centers in operation today weren't built for today's workloads — especially GPU-dense AI clusters. Redesign is rarely a full rebuild; it's usually a series of targeted interventions layered onto an existing facility.
- 📈 **Density growth** — new equipment (especially AI/HPC) exceeds the original per-rack design limit.
- 📉 **PUE degradation** — aging cooling plant becomes less efficient than modern alternatives, raising operating cost.
- 🔌 **End of equipment life** — UPS batteries, chillers, and generators typically need replacement every 10–15 years — a natural moment to upgrade rather than replace like-for-like.
- 📜 **New compliance requirements** — regulators (e.g. a central bank mandating a Tier III standard for banking data) can force reliability upgrades.
- 🌱 **Sustainability targets** — corporate net-zero commitments driving efficiency retrofits and renewable power sourcing.

|   | Greenfield (new build) | Brownfield (retrofit) |
|---|---|---|
| **Design freedom** | Full control of layout, density, site | Constrained by existing structure & layout |
| **Downtime risk** | None — built before go-live | High — must work around live systems |
| **Capital cost** | Highest — land, structure, everything new | Lower — reuses existing shell & some infrastructure |
| **Time to deploy** | 18–24+ months | Often 3–9 months for targeted upgrades |

> **🧩 Modular & containerized data centers**
> Prefabricated, containerized modules (power, cooling, and IT space built off-site and shipped in) let operators add capacity in discrete chunks rather than committing to a full facility upfront. This shortens deployment time from years to months and is increasingly used for both greenfield expansion and rapid capacity relief at brownfield sites.

## Math practice — small, quick calculations
*Practice · 10 min*
Apply today's formulas (PUE, DCiE, redundancy, density) to five short problems

- Try to solve each problem on paper first — they're all short, one- or two-step calculations. Tap a card to reveal the worked answer.
- **1** — A facility's IT equipment load is **600 kW**. Total facility power draw (IT + cooling + everything else) is **900 kW**. What is the PUE?
- PUE = Total power ÷ IT power — 900 ÷ 600 = 1.5 — A PUE of 1.5 means 0.5 kW of overhead for every 1 kW that actually reaches computing — roughly industry average.
- **2** — A cooling system needs exactly **3 chillers (N=3)** to meet full load. Under an **N+1** redundancy model, how many chillers must be installed in total?
- N+1 = required units + 1 spare — 3 + 1 = 4 chillers — Any one chiller can fail — or be taken offline for maintenance — while the remaining three still cover the full 3-chiller load.
- **3** — If a facility's PUE is **1.25**, what is its DCiE (Data Center Infrastructure Efficiency), expressed as a percentage?
- DCiE = 1 ÷ PUE × 100% — 1 ÷ 1.25 = 0.80 → 80% — DCiE is just the inverse of PUE — it tells you what fraction of total power reaches the IT equipment. 80% is a strong (well above average) result.
- **4** — A server hall is **500 m²**. Each rack (including aisle space) needs **2 m²**, and average density is **6 kW/rack**. How many racks fit, and what's the hall's total IT capacity?
- Racks = area ÷ footprint; Capacity = racks × density — 500 ÷ 2 = 250 racks
250 × 6 kW = 1,500 kW — This simple area-and-density calculation is the starting point for any electrical and cooling capacity plan.
- **5** — Tier III promises **99.982%** uptime. There are 525,600 minutes in a year. How many minutes of downtime does that allow?
- Downtime = (1 − uptime%) × minutes/year — (1 − 0.99982) × 525,600 ≈ 94.6 min — That's under 1 hour and 35 minutes of allowed downtime for the entire year — roughly matching the 1.6 hrs figure from the Tier table.

## Data center design in Bangladesh
*Local Context · 10 min*
Flood risk, grid reliability, and the National Data Center

- Bangladesh's geography and infrastructure landscape make certain design criteria far more decisive here than in many other countries.
- **🌊 Flood & elevation risk** — Much of Bangladesh is low-lying and flood-prone. Site elevation and drainage are often the single deciding constraint on location — critical infrastructure like the National Data Center is deliberately sited on elevated, well-drained land (Kaliakoir Hi-Tech Park, Gazipur).
- **🔌 Grid reliability** — Voltage fluctuation and occasional load shedding make N+1 diesel generator capacity close to mandatory rather than optional, adding capital cost and Scope 1 emissions that greener grids elsewhere avoid.
- **🏦 Regulatory pressure** — Bangladesh Bank's data protection and IT governance guidance increasingly pushes banks toward Tier III-equivalent facilities for core systems — directly connecting today's material to the sector many of you may eventually work with.
- **🏗️ Retrofit reality** — Most existing private data centers in Dhaka were not built to modern Tier standards. Redesign here typically means phased retrofits — containment, UPS upgrades, generator redundancy — rather than full rebuilds.
- **Site scenario** — A bank wants to build a new data center near the Buriganga River for cheap land and easy cooling water access. What's your first objection?
- Answer — Flood and monsoon risk — riverside sites are attractive for water-side cooling but carry high inundation risk. Recommend a site with adequate elevation and drainage first, then solve cooling water access through closed-loop systems or piped supply instead.
- **Redesign scenario** — An existing Dhaka data center is Tier II. A new central bank guideline requires Tier III for core banking systems. What's the minimum change needed?
- Answer — Achieving Tier III doesn't just mean adding spares (already N+1) — it requires concurrent maintainability: redundant distribution paths so any single component can be serviced live. This usually means dual power paths to each rack (dual-corded PDUs) and isolatable cooling loops, not just extra units.
- 🗣 Class Discussion (5 min)
- **1**
- On our upcoming field trip, what design evidence would tell you — just by walking the floor — whether a facility is closer to Tier II or Tier III? Think about what you'd physically look for. — Open discussion — pairs first, then class

## Class quiz — data center design & redesign
*Assessment · 10 min*
6 questions covering today's content

## Summary & next steps
*Wrap-up · 5 min*
Key takeaways and Class 12 preview

- 🏗️ **Design locks in early** — Site, structure, and electrical capacity are largely fixed once construction starts — get these decisions right the first time.
- 🏆 **Four Tiers** — Tier I (basic) through Tier IV (fault tolerant, 2N). Each step adds ~20–50% cost for meaningfully higher uptime.
- 🔁 **Redundancy notation** — N → N+1 → 2N → 2N+1: each step adds spare capacity and cost, in exchange for tolerating more simultaneous failures.
- 🧮 **The formulas are simple** — PUE, DCiE, and capacity planning are all one- or two-step calculations — the engineering judgment is in choosing the right inputs.
- 🔄 **Redesign is usually phased** — Density growth, aging equipment, and new compliance rules trigger redesign — rarely a full rebuild, usually targeted retrofits.
- 🇧🇩 **Bangladesh's constraints** — Flood risk and grid reliability dominate site and redundancy decisions here more than in most other markets.

> **📚 Next Class — Class 12**
> Virtualization. We move from physical infrastructure to how virtualization multiplies the value of every watt built today — server consolidation, hypervisors, and the efficiency gains that make modern data centers viable. Read: Velete Ch.12 (all) and Lamb Ch.6 (all) before class if not already done.

> **🚌 Reminder — Field Trip**
> Our data center field trip is tentatively scheduled around this module. Confirm your attendance and any site-visit paperwork with the instructor — bring notebook and closed-toe shoes.

## Class Quiz

**Q1. What is the key distinguishing feature that separates a Tier III data center from a Tier II data center?**
▫️ A. Tier III has more diesel generators installed
✅ B. Tier III is concurrently maintainable — every component and distribution path can be serviced without any downtime, not just redundant components
▫️ C. Tier III uses liquid cooling exclusively
▫️ D. Tier III has a lower PUE than Tier II by definition
> **Explanation:** Tier II adds redundant components (N+1) but still routes through a single distribution path — maintaining that path causes downtime. Tier III requires concurrent maintainability: every component and path can be taken offline for service with zero impact on IT operations. This is a design property, not just a component count.

**Q2. A facility installs 4 chillers when only 3 (N=3) are strictly required to meet the cooling load. What redundancy model is this?**
▫️ A. N
✅ B. N+1
▫️ C. 2N
▫️ D. 2N+1
> **Explanation:** N+1 means one spare unit beyond what's required to meet the load. Here N=3 (required) and one extra unit is added, giving 4 total — the standard N+1 pattern.

**Q3. A data center has an IT load of 750 kW and total facility power draw of 1,050 kW. What is its PUE?**
*Context: Recall: PUE = Total facility power ÷ IT equipment power.*
▫️ A. 0.71
▫️ B. 1.05
✅ C. 1.40
▫️ D. 1.75
> **Explanation:** PUE = 1,050 ÷ 750 = 1.4. A PUE of 1.4 means 0.4 kW of overhead (cooling, power distribution, etc.) for every 1 kW that reaches the actual computing equipment.

**Q4. Why does 2N redundancy cost substantially more than N+1, even though both tolerate some failures?**
▫️ A. 2N uses more expensive individual components per unit
✅ B. 2N duplicates the entire capacity and distribution path end-to-end, roughly doubling capital cost, rather than adding just one spare unit
▫️ C. 2N requires a larger physical building footprint only, with no cost difference otherwise
▫️ D. There is no meaningful cost difference between N+1 and 2N
> **Explanation:** N+1 adds one spare unit to a shared distribution path. 2N builds a second, fully independent path — power, distribution, and often cooling — doubling most of the infrastructure rather than adding a single component. That's why 2N approaches roughly double the capital cost of N.

**Q5. Which site-selection factor is often the single deciding constraint for new data center locations in Bangladesh specifically?**
▫️ A. Average land cost per square meter nationwide
✅ B. Flood risk and site elevation, given the country's low-lying, flood-prone geography
▫️ C. Availability of English-speaking technical staff
▫️ D. Time zone alignment with North American markets
> **Explanation:** Bangladesh's low elevation and monsoon flood risk make site elevation and drainage a dominant, often deciding, factor — outweighing land cost or other criteria that matter more in less flood-prone countries.

**Q6. A data center operator wants to raise rack density from 5 kW/rack to 25 kW/rack to support new GPU servers, without a full facility rebuild. What is the most practical redesign approach?**
▫️ A. Add more standard CRAC units at the room level and hope airflow improves
✅ B. Retrofit targeted high-density zones with rear-door heat exchangers or direct liquid cooling, rather than rebuilding the entire facility
▫️ C. Reduce the number of racks so total power stays the same as before
▫️ D. Immediately convert the entire data center to full immersion cooling
> **Explanation:** A full rebuild is rarely justified for a density increase in specific zones. Retrofitting rear-door heat exchangers or direct liquid cooling to the high-density racks handles 25–100+ kW/rack without disturbing the rest of the facility — a phased, targeted redesign rather than a ground-up rebuild.

## Sidebar Reference Notes

### Book References
- **Velete — Green IT**
Chapter 12: all — **Lamb — The Greening of IT**
Chapter 6: all

### Tier Quick Reference
- ① Tier I → N → 28.8 hrs/yr — ② Tier II → N+1 → 22.0 hrs/yr — ③ Tier III → N+1 (concurrent) → 1.6 hrs/yr — ④ Tier IV → 2N → 0.4 hrs/yr

### ⚠️ Deadline Reminder
- **Term paper progress check-in** — be ready to share your methodology and data plan with the instructor this week.

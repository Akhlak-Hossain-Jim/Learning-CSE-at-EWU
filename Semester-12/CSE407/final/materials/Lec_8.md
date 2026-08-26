# Sustainable Hardware —
*Designing & Buying Green from Day One*
CSE407 Green Computing · Class 8 of 22 · Jun 29, 2025 · Sunday · 1h 30min

Certifications, lifecycle assessments, green procurement frameworks, and how to spot greenwashing — everything engineers need to make responsible hardware decisions.

**References:** 📘 Velete Ch.8 (all) | 🎯 CO1, CO2 | 🧠 EP1, EP2, EP5

**Key stats:**
- **70–80%** — Of a device's lifetime carbon footprint from manufacturing — before first use
- **Energy Star** — Top 25% of energy efficiency in each product category
- **TCO** — Certified — the most comprehensive sustainable electronics standard
- **$725** — Annual per-worker cost of inefficient hardware (Gartner) — green pays

## Recap & homework debrief
*Opening · 5 min*
E-waste recap + greenwashing homework review

- Last class we covered what happens to electronics at the *end* of their life — e-waste, toxic materials, EPR, and the circular economy. Today we go back to the *beginning*: how to choose, specify, and design hardware sustainably from the very first procurement decision.
- **♻️ E-waste recap** — 62Mt/year globally, 17% formally recycled. Urban mine worth $57B/year. Circular hierarchy: Reuse → Repair → Refurbish → Remanufacture → Recycle. Bangladesh E-Waste Rules 2021 establish EPR framework.
- **🔧 Today's angle** — Sustainable hardware is not just about recycling at the end — 70–80% of a device's total carbon footprint happens during manufacturing, before it's ever switched on. The biggest lever is procurement and design, not disposal.
- **🎯 Class goal** — By the end: able to evaluate any hardware product's sustainability credentials, spot greenwashing, apply a procurement scorecard, and specify sustainability requirements for hardware purchases.
- 🗣 Homework Debrief (4 min)
- **?**
- What device did you research? What sustainability claim did the manufacturer make? Was it specific and verifiable — or vague greenwashing? Share your assessment with the class. — 3–4 students share, class reacts — we'll revisit in Section 5

## Why hardware choices are the biggest lever
*Foundation · 10 min*
Embodied carbon, supply chains, and why "most efficient" ≠ "most sustainable"

- When most people think "sustainable hardware," they think energy efficiency during use. But for most consumer and enterprise devices, the single largest environmental impact happens long before the device is plugged in — during **manufacturing**.
- 70% — Smartphone lifetime carbon from manufacturing (before first use)
- 1,500kWh — Energy to manufacture one laptop — equivalent to 3 years of operating it
- 2× — Carbon saved by extending a phone from 2 to 4 years vs. replacing with newest model
- 60+ — Elements from the periodic table in a single modern smartphone

> **📘 From Velete Ch.8 — Embodied carbon vs. operational carbon**
> Embodied carbon is the CO₂e emitted to manufacture, transport, and eventually dispose of a device — it's "locked in" before the device is ever used. Operational carbon is emitted while using the device (electricity consumption). For smartphones and laptops, embodied carbon dominates. For servers running 24/7 for years, operational carbon can catch up. This split determines which sustainability strategy matters most for each device type.

- **📱 Consumer devices (phone/laptop)**
- Manufacturing = 70–80% of lifetime footprint — Most important action: **extend device lifespan** — Buying a new phone every year vs. every 4 years: 3× more carbon per year of use — Second most important: **choose repairability** (Fairphone scores highest)
- **🖥️ Enterprise servers (24/7 operation)**
- Manufacturing = 20–40% of lifetime footprint (operational catches up) — Most important action: **maximize utilization** (virtualization) — Second: **choose energy-efficient models** (Energy Star, EPEAT) — Third: **power from renewables** (Scope 2 reduction)

## Sustainable hardware certifications
*Core Content · 18 min*
The labels that actually mean something — and what each one requires

- Walk into any electronics store and you'll see dozens of green claims. Most are marketing. A handful represent rigorous third-party verification with real technical requirements. Knowing which is which is a core competency for sustainable procurement.
- **Energy Star**
- **Energy Efficiency Labeling Program** — US EPA · Voluntary · Widely recognised globally
- Products must fall in the top 25% of energy efficiency for their category to earn the Energy Star label. Covers computers, monitors, servers, storage, imaging equipment, and data centers. The label means the product uses significantly less electricity than standard models — saving money and reducing Scope 2 emissions over its operational life.
- **What it covers** — Operational energy efficiency only — how much electricity the product uses during active and idle states. Does NOT cover materials, manufacturing, or end-of-life practices.
- **Typical saving** — Energy Star computers use 30–65% less energy than standard models. For a 200-computer office, this can mean saving $10,000–$30,000/year in electricity.
- **Procurement relevance** — Mandatory for US federal government procurement. Referenced in Bangladesh ICT Policy 2018 for government purchases. Increasingly required by large enterprise buyers globally.
- **Limitation** — Covers only operational energy — a product can be Energy Star certified while being made with toxic materials, having no recycling program, and generating significant manufacturing emissions.
- **EPEAT**
- **Electronic Product Environmental Assessment Tool** — Green Electronics Council · Voluntary · Gold/Silver/Bronze tiers
- EPEAT is a comprehensive lifecycle environmental rating system for electronics — going far beyond Energy Star by covering materials, manufacturing, design for end-of-life, and corporate sustainability practices. Products are scored on required and optional criteria to achieve Bronze, Silver, or Gold ratings.
- **What it covers** — Materials selection (hazardous substance restrictions), product longevity and upgradability, end-of-life management (take-back programs), energy conservation, and corporate performance.
- **Tiers** — Bronze: meets all required criteria. Silver: Bronze + 50% optional criteria. Gold: Bronze + 75% optional criteria. Gold is the benchmark for best-in-class sustainable hardware.
- **Procurement relevance** — Required by US federal agencies for IT purchases. Referenced in EU GPP (Green Public Procurement) criteria. Increasingly written into enterprise sustainability procurement policies worldwide.
- **Bangladesh applicability** — Not yet formally required in Bangladesh government procurement, but used as a reference standard by foreign-funded projects (World Bank, ADB) and by Bangladeshi companies serving EU/US markets.
- **TCO Certified**
- **Total Cost of Ownership Certified** — TCO Development (Sweden) · Most comprehensive standard available
- TCO Certified is widely considered the most rigorous and comprehensive sustainable electronics certification globally. It covers the full product lifecycle and — uniquely — includes **social responsibility criteria** covering labor conditions in manufacturing supply chains, going beyond purely environmental requirements.
- **Environmental scope** — Hazardous substances, energy efficiency, product lifespan design, recycling programs, packaging, and corporate environmental reporting. Annual factory audits by third-party verifiers.
- **Social scope (unique)** — Covers working conditions in factories: minimum wage, working hours, child labor prohibition, forced labor prohibition, health and safety. Supply chain traceability required.
- **Conflict minerals** — Requires documented responsible sourcing of conflict minerals (tin, tantalum, tungsten, gold — 3TG) per OECD Due Diligence Guidance — going beyond US Dodd-Frank Act requirements.
- **Best for** — Organizations wanting the highest assurance level across all sustainability dimensions — particularly relevant for organizations with ESG reporting obligations or those serving European institutional clients.
- **80 PLUS**
- **Power Supply Unit (PSU) Efficiency Certification** — Plug Load Solutions · Focused on PSU energy efficiency
- 80 PLUS certifies that a power supply unit (PSU) converts AC mains power to DC with at least 80% efficiency at 20%, 50%, and 100% load. Higher tiers (Bronze, Silver, Gold, Platinum, Titanium) require progressively higher efficiency — up to 96% for Titanium. This matters because every watt lost in conversion becomes waste heat.
- **Why PSU efficiency matters** — A 500W server with an 80% efficient PSU wastes 100W as heat. The same server with a 93% Gold PSU wastes only 38W — saving 62W continuously, or ~543 kWh/year per server.
- **Tiers (efficiency at 50% load)** — Basic: 80%. Bronze: 85%. Silver: 88%. Gold: 92%. Platinum: 94%. Titanium: 96%. Each tier jump is significant at data-center scale.
- **Data center relevance** — PSU losses compound with PUE: a watt wasted in the PSU becomes ~1.5W wasted in total (the cooling system then has to remove the extra heat too). Gold PSUs are the minimum recommended for data centers.
- **Bangladesh tip** — Many locally assembled PCs use budget PSUs with 70–75% efficiency. Specifying 80 PLUS Gold for all builds is a low-cost, high-impact green procurement requirement with fast payback in electricity savings.
- **RoHS**
- **Restriction of Hazardous Substances Directive** — European Union · Legally binding for EU market · Adopted widely worldwide
- RoHS restricts ten hazardous substances in electrical and electronic equipment (EEE) sold in the EU. Originally six substances (2003), expanded to ten in RoHS 3 (2019). Compliance is mandatory for any product sold in the EU — making it the most globally influential materials standard in electronics history.
- **Restricted substances** — Lead (Pb), Mercury (Hg), Cadmium (Cd), Hexavalent Chromium (Cr VI), Polybrominated Biphenyls (PBB), Polybrominated Diphenyl Ethers (PBDE), plus four phthalates added in RoHS 3.
- **Maximum concentration values** — 0.1% by weight for most substances; 0.01% for cadmium. Products exceeding these limits cannot be sold in the EU — forcing global supply chains to comply since manufacturers rarely make EU-only product variants.
- **Why it matters for recycling** — RoHS-compliant devices contain far less toxic material — making informal recycling less hazardous and formal recycling more economically viable (less hazardous waste treatment required).
- **Bangladesh** — Not domestically mandated, but any Bangladeshi exporter to the EU must supply RoHS-compliant products. Bangladesh E-Waste Rules 2021 reference RoHS thresholds as guidance for domestic product safety standards.

> **💡 Quick reference — which certification to specify when?**
> For energy efficiency only: Energy Star + 80 PLUS Gold (PSU). For full lifecycle sustainability: EPEAT Gold or TCO Certified. For hazardous substance compliance: RoHS (mandatory for EU; best practice everywhere). For a complete green procurement spec: require all four — they address different dimensions and don't overlap significantly.

## Lifecycle Assessment for hardware
*Method · 12 min*
Interactive: compare the carbon footprint of different devices across their full life

- A **Lifecycle Assessment (LCA)** quantifies the total environmental impact of a product from raw material extraction through manufacturing, use, and disposal — "cradle to grave." For hardware, LCA reveals a surprising result: the phase engineers spend most time optimizing (operational energy) is often NOT the largest contributor to total impact.
- **🔬 Interactive: Device Carbon Footprint by Lifecycle Phase**
- **Select a device type to see how its ~total lifetime CO₂e is distributed across lifecycle phases.**
- 📱 Smartphone — 💻 Laptop — 🖥️ Server (3yr) — 🖥 Monitor
- Total lifetime CO₂e — ~70 kg
- For a smartphone, manufacturing is the dominant impact. The single most effective action is extending device lifespan — every extra year of use spreads the manufacturing carbon over more time.

> **💡 The LCA insight that changes priorities**
> For consumer devices (phones, laptops), the LCA reveals that buying a slightly less energy-efficient model but keeping it twice as long is usually better for the environment than buying the most energy-efficient model and replacing it on schedule. Longevity beats efficiency for embodied-carbon-dominant devices.

- **🛠️ Design implications**
- Prioritize repairability — user-replaceable battery is the #1 longevity feature — Modular design — upgrade CPU/RAM without replacing whole unit — Software support commitment — minimum 5 years of OS updates — Durable materials — scratch/drop resistance reduces cosmetic-damage-driven replacement — Spare parts availability guaranteed for 7–10 years (EU Right to Repair requirement)
- **🛒 Procurement implications**
- Specify minimum 4-year refresh cycle (not 2–3 year) — Require manufacturer sustainability report with per-product LCA data — Evaluate total cost of ownership (TCO) including energy over 4 years — Prefer EPEAT Gold / TCO Certified as baseline — Consider certified refurbished over new for non-critical workloads

**Lifecycle carbon footprint by device type:**

- **Smartphone (2yr life, ~70 kg CO₂e total)** — total ~70 kg CO₂e
  - Insight: Manufacturing dominates at 75%. Extending life to 4 years halves per-year carbon. Repairability is the key design lever.
  - Manufacturing: 75% (52 kg)
  - Use phase (charging): 17% (12 kg)
  - Transport & packaging: 5% (3.5 kg)
  - End of life: 3% (2 kg)
- **Laptop (4yr life, ~300 kg CO₂e total)** — total ~300 kg CO₂e
  - Insight: Manufacturing is still 70% for laptops. Operational energy is more significant than for phones due to higher power draw. Both longevity AND energy efficiency matter.
  - Manufacturing: 70% (210 kg)
  - Use phase (AC power): 22% (66 kg)
  - Transport & packaging: 5% (15 kg)
  - End of life: 3% (9 kg)
- **Server (3yr constant use, ~3,000 kg CO₂e total)** — total ~3,000 kg CO₂e
  - Insight: For servers running 24/7, operational energy catches up significantly. Both manufacturing footprint (high-end CPUs) and operational efficiency matter equally.
  - Manufacturing: 35% (1,050 kg)
  - Use phase (24/7 operation): 58% (1,740 kg)
  - Transport & packaging: 4% (120 kg)
  - End of life: 3% (90 kg)
- **Monitor (5yr life, ~400 kg CO₂e total)** — total ~400 kg CO₂e
  - Insight: Monitor manufacturing (panel, backlight, chassis) is significant. LED vs. CCFL backlighting made a major difference. OLED next generation will shift the balance further.
  - Manufacturing: 60% (240 kg)
  - Use phase: 33% (132 kg)
  - Transport & packaging: 5% (20 kg)
  - End of life: 2% (8 kg)

## Greenwashing detector
*Critical Thinking · 12 min*
Tap each claim to analyze whether it's genuine sustainability or marketing spin

- **Greenwashing** is the practice of making misleading or exaggerated environmental claims about a product or company. In the hardware industry, it ranges from outright false claims to technically true but deeply misleading statements. Engineers specifying hardware must be able to identify and reject greenwashed claims.

> **🚩 The 7 sins of greenwashing (TerraChoice)**
> Hidden trade-off (one green attribute hides other harms) · No proof (unverifiable claim) · Vagueness ("eco-friendly") · Irrelevance (true but meaningless) · Lesser of two evils · Fibbing (false claim) · False labels (fake certification logos). Tap each claim below to see which sin applies.

- **🧪 Claim Analysis — tap each claim to reveal the verdict**
- "Our laptop uses 40% less energy than the previous model." — ⚠️ **Mixed — potentially misleading.** This *could* be genuine if it means 40% less energy during use AND if the previous model was the market standard. But if the previous model was unusually energy-hungry, the new one might still be below average. Ask: compared to *what baseline?* Is there a third-party certification (Energy Star) confirming the claim? What happened to manufacturing emissions? A good sustainability claim is specific, verifiable, and puts savings in context.
- "Our servers are built with eco-friendly materials." — ❌ **Greenwashing — vagueness sin.** "Eco-friendly" is meaningless without specification. What does it mean? RoHS compliant? Recycled content? Sustainably sourced? Recyclable at end of life? Any company can print "eco-friendly" with zero verification. Demand specific, measurable, third-party-verified claims. If a company can't tell you exactly what "eco-friendly" means in numbers or certifications, assume it means nothing.
- "This monitor is Energy Star certified and uses 35% less energy — saving you $28/year in electricity." — ✅ **Genuine — specific, verifiable, quantified.** Energy Star is a real third-party certification. "35% less" is a specific measurable claim. "$28/year" is a calculated financial benefit the buyer can verify against their electricity rate. This is what good sustainability communication looks like: specific standard + specific metric + specific benefit in user-relevant terms. Still worth asking: what about manufacturing emissions and end-of-life? But the operational claim itself is credible.
- "Our company is committed to being carbon neutral by 2040." — ⚠️ **Insufficient without details.** A commitment 15+ years away with no interim milestones, no Scope 3 inclusion, and no third-party accountability is easy to make and hard to hold companies to. Key questions: Does "carbon neutral" include Scope 3 (manufacturing, supply chain, product use)? What are the 2025 and 2030 interim targets? Is this verified by Science Based Targets initiative (SBTi)? Is offsetting (planting trees) doing most of the work instead of actual emission reduction? A credible net-zero commitment answers all of these.
- "This printer is CFC-free!" (Chlorofluorocarbons have been banned globally since 1987.) — ❌ **Greenwashing — irrelevance sin.** This is technically true but completely meaningless. CFCs have been banned by the Montreal Protocol since 1987 — *every* printer is CFC-free. This claim creates a false impression of green virtue while saying nothing meaningful about the product's actual environmental performance. Classic "lesser compliance masquerading as achievement."

## Green hardware procurement scorecard
*Applied Tool · 10 min*
Rate any hardware product across 6 sustainability dimensions — interactive

- When your organization needs to choose between competing hardware products, use this scorecard to evaluate sustainability systematically. Rate each dimension 1–3 stars based on evidence — not marketing claims.
- **🛒 Hardware Sustainability Scorecard — rate 1–3 stars per dimension**
- **1★ = No evidence / poor · 2★ = Partial / unverified · 3★ = Strong evidence / certified**
- Total score — **0 / 18**
- **Rate all dimensions to see verdict** — 14–18: Excellent · 9–13: Acceptable · <9: Avoid
- **Procurement scenario** — Product A costs $400 (no certifications, 3-year lifespan). Product B costs $520 (EPEAT Gold, Energy Star, 5-year lifespan, 80 PLUS Gold PSU). Which is the better procurement?
- Answer — Product B. Total cost of ownership: Product A at $400 × 5/3 years = $667 equivalent over 5 years. Product B = $520 over 5 years. Plus: Energy Star saves ~$30/year × 5 = $150. Product B effectively costs $370 over 5 years vs. $667 for Product A — nearly half, while being significantly greener. Green procurement is usually better value, not worse.
- **Specification scenario** — You're writing the IT hardware specification for a new 300-person EWU computer lab. List 4 specific sustainability requirements you would include in the tender document.
- Answer — 1. Energy Star certified (or equivalent, top 25% efficiency). 2. EPEAT Silver or Gold registered. 3. PSU must be 80 PLUS Gold or higher. 4. Minimum 5-year warranty with spare parts availability guaranteed. Bonus: RoHS compliant, take-back program at end of life, recycled content ≥10% in chassis.
- **Bangladesh scenario** — A local PC assembler offers laptops without any certifications at 30% below market price. Should EWU's IT department buy them for the new lab?
- Answer — Likely no. Without Energy Star or equivalent: higher electricity bill over 5 years offsets much of the price saving. Without RoHS: toxic materials create disposal liability. Without warranty: higher replacement rate. Without EPEAT/TCO: no accountability for supply chain. The 30% upfront saving is typically eaten by operational costs, shorter lifespan, and disposal costs. Request sustainability documentation before accepting the lower price as a genuine saving.

**Scorecard dimensions (rate 1-3 stars each):**
- Energy efficiency certification (Energy Star / equivalent) (weight 2×)
- Full lifecycle certification (EPEAT Gold / TCO Certified) (weight 2×)
- Hazardous substance compliance (RoHS) (weight 1×)
- Repairability & longevity design (user-replaceable battery, spare parts) (weight 2×)
- Recycled material content (documented %) (weight 1×)
- End-of-life take-back program (manufacturer) (weight 1×)

## The engineer's role in sustainable hardware
*Practical · 8 min*
Design, specify, procure, and advocate — four levers every engineer controls

- Whether you're a product engineer designing hardware, a systems engineer specifying infrastructure, a procurement officer buying equipment, or a software engineer running on hardware — each role has specific sustainable hardware levers.
- 🔧 **Product engineers (hardware designers)** — Choose RoHS-compliant materials. Design for disassembly. Make the battery user-replaceable. Minimize the number of distinct material types. Commit to spare parts availability. Use recycled content where structurally valid. Your material and structural decisions at design stage lock in most of the product's lifetime environmental impact.
- 🖥️ **Systems/infrastructure engineers** — Specify Energy Star, EPEAT, 80 PLUS Gold in procurement requirements. Maximize virtualization before adding hardware. Choose servers with high utilization capability. Design for longest possible hardware refresh cycle with upgrade paths. Document asset lifecycle for Scope 3 reporting.
- 💰 **Procurement officers / IT managers** — Write sustainability requirements into tender documents (not just price). Evaluate total cost of ownership (TCO) over 4–5 years, not just purchase price. Maintain asset registers with acquisition dates to trigger certified disposal — not casual binning. Prefer certified refurbished for non-critical use cases.
- 💻 **Software engineers** — Efficient code = less hardware needed = fewer devices = less manufacturing carbon. A software team that cuts CPU usage by 30% may defer a hardware upgrade cycle by 2 years — avoiding millions in embodied carbon across a large fleet. Sustainability is a software quality metric, not just hardware.

> **📘 From Velete Ch.8 — The procurement multiplier**
> A single procurement officer at a large organization signing one hardware tender can determine the environmental performance of thousands of devices over 4–5 years. Their specification choices multiply across the entire fleet. Writing "EPEAT Gold required" into a 500-laptop tender has more environmental impact than any individual action any of those 500 laptop users will ever take — including recycling them at end of life.

- 🗣 Discussion (3 min)
- **?**
- Look at the device you're using in class right now. Does it have Energy Star? EPEAT? TCO Certified? Can you find a per-product LCA on the manufacturer's website? How does the homework claim you found hold up against today's framework? — Individual reflection → brief class share

## Class quiz — sustainable hardware
*Assessment · 10 min*
6 questions covering today's content

## Summary & next steps
*Wrap-up · 5 min*
Key takeaways and Class 9 preview

- 🏭 **Manufacturing dominates** — 70–80% of a smartphone's lifetime carbon happens before first use. Longevity and repairability matter more than operational efficiency for embodied-carbon-dominant devices.
- 🏅 **5 key certifications** — Energy Star (energy efficiency) · EPEAT Gold (full lifecycle) · TCO Certified (most comprehensive + social) · 80 PLUS Gold (PSU) · RoHS (hazardous substances). Each covers different dimensions.
- 📊 **LCA reveals surprises** — Lifecycle Assessment shows that keeping a device 2× longer often does more for the environment than replacing it with a more energy-efficient model.
- 🔍 **Spot greenwashing** — 7 sins: hidden trade-off, no proof, vagueness, irrelevance, lesser of two evils, fibbing, false labels. Demand specific, measurable, third-party-verified claims.
- 📋 **Procurement scorecard** — Rate on: energy cert, lifecycle cert, hazardous sub compliance, repairability, recycled content, and take-back. TCO beats sticker price as decision criterion.
- ✍️ **Write it into tenders** — A procurement officer specifying EPEAT Gold for 500 laptops has more environmental impact than any individual user action. Specification is the highest-leverage moment.

> **📚 Next Class — Class 9 (Jul 2, Wednesday)**
> Technology Company Case Studies. We shift to real-world examples: how do Apple, Google, Microsoft, and major tech companies actually approach sustainability? What can we learn — and critique — from their approaches? Guest lecture from industry CXO. Read: Velete Ch.9 (all) and Lamb Ch.11 (all) before class.

> **📝 Before Class 9**
> Pick one major tech company (Apple, Google, Samsung, Microsoft, or a local telco/IT company) and find their latest sustainability or ESG report. Note: (1) their most impressive specific claim with evidence, and (2) one area where their reporting seems vague or incomplete. We'll compare company approaches in Class 9.

## Class Quiz

**Q1. A smartphone manufacturer claims their new model has "70% lower carbon footprint." However, 75% of that reduction comes from a one-time offset program (planting trees), not from emission reductions. Which greenwashing sin does this represent?**
▫️ A. False labels — they have no real certification
▫️ B. Vagueness — the 70% figure is not specific enough
✅ C. Hidden trade-off — they achieved the number but through offsetting rather than genuine operational reduction — masking that the actual product emissions barely changed
▫️ D. No proof — unverifiable claim
> **Explanation:** This is the "hidden trade-off" sin: the headline number (70% lower footprint) is technically achievable through offsetting, but hides the fact that the product itself is not significantly greener. Real carbon reduction means actual emissions prevented — not offset via tree planting which has its own verification problems. Credible claims specify what percentage is actual reduction vs. offset, use Science Based Targets (SBTi) methodology, and include Scope 3 in the accounting.

**Q2. For a smartphone used for 3 years, approximately what percentage of its total lifetime carbon footprint comes from manufacturing (before the user ever turns it on)?**
▫️ A. About 10–20% — operational energy dominates over 3 years
▫️ B. About 30–40% — roughly equal split between manufacturing and use
✅ C. About 70–80% — manufacturing is the dominant phase for short-lifespan consumer devices
▫️ D. 100% — phones use no electricity during operation
> **Explanation:** For smartphones, manufacturing (including raw material extraction, component fabrication, and assembly) accounts for approximately 70–80% of the total lifetime CO₂e footprint. This is because phones have relatively low operational power (charging uses ~3–5W) but are replaced frequently (average 2.5 years) and require energy- and material-intensive manufacturing. This is why extending device lifespan is the single most impactful individual sustainability action for smartphones — it spreads the fixed manufacturing carbon over more years of use.

**Q3. Which certification evaluates the most comprehensive set of sustainability criteria — including social responsibility (labor conditions in factories) alongside environmental performance?**
▫️ A. Energy Star — because it covers energy efficiency most rigorously
▫️ B. RoHS — because it restricts the most dangerous substances
▫️ C. EPEAT Gold — because it has the most product categories
✅ D. TCO Certified — uniquely covers energy, materials, social labor conditions, and supply chain traceability in a single standard
> **Explanation:** TCO Certified is the most comprehensive sustainable electronics certification, uniquely incorporating social responsibility criteria — factory working conditions, wages, child labor prohibition, and supply chain traceability for conflict minerals — alongside environmental requirements (energy efficiency, hazardous substances, end-of-life). Energy Star covers only operational energy. RoHS covers only hazardous substance restrictions. EPEAT covers lifecycle environmental criteria but does not include labor/social criteria in its core requirements.

**Q4. A PSU rated 80 PLUS Gold achieves 92% efficiency at 50% load. A basic PSU achieves 78% efficiency. For a 400W server running at 50% load (200W IT load), how much more power does the basic PSU waste compared to the Gold unit?**
*Context: Calculate: Power drawn from wall = IT load ÷ PSU efficiency. Wasted power = Power from wall − IT load.*
▫️ A. About 5W extra
✅ B. About 30W extra — Gold PSU draws ~217W, basic PSU draws ~256W from the wall, a 39W difference
▫️ C. The difference is negligible — PSU efficiency barely matters at this scale
▫️ D. Basic PSU wastes less because it runs cooler
> **Explanation:** Gold PSU: 200W ÷ 0.92 = 217W from wall. Basic PSU: 200W ÷ 0.78 = 256W from wall. Difference = 39W wasted continuously. At 8,760 hours/year, that's 342 kWh/year per server. For a 100-server data center: 34,200 kWh/year saved — at $0.10/kWh that's $3,420/year in electricity savings, plus reduced heat load on cooling. Specifying 80 PLUS Gold is a small upfront cost with a fast payback.

**Q5. An organization is choosing between Product A (no certifications, $350, 3-year expected lifespan) and Product B (EPEAT Gold, Energy Star, $480, 5-year expected lifespan, Energy Star saves $25/year). Which is the better total cost of ownership (TCO) choice?**
*Context: Normalize to 5-year TCO: Product A cost over 5 years = (5/3) × $350 (buy 1.67 units). Product B cost over 5 years = $480 − (5 × $25 energy saving).*
▫️ A. Product A — it is $130 cheaper upfront
✅ B. Product B — 5-year normalized TCO is significantly lower, plus sustainability benefits
▫️ C. They are equivalent over 5 years
▫️ D. Product A — certifications add no financial value
> **Explanation:** Product A 5-year TCO: $350 × (5/3) = $583 (must buy 1.67 units to cover 5 years). Product B 5-year TCO: $480 − $125 energy savings = $355. Product B costs $355 vs $583 for Product A over the same 5-year period — a saving of $228 per unit, while being certified sustainable. This demonstrates the fundamental principle: TCO analysis almost always makes green hardware the financially rational choice, even when it costs more upfront.

**Q6. A laptop manufacturer prints "Made with 20% recycled aluminum" on the box. How should a sustainability-minded engineer evaluate this claim?**
▫️ A. Accept it as a strong green credential — 20% recycled content is excellent
▫️ B. Reject it entirely — any recycled content claim is greenwashing
✅ C. Evaluate carefully: verify the percentage applies to the whole product (not just one component), check if it's third-party verified, and consider it as one positive factor among many rather than the whole picture
▫️ D. Only accept the claim if the percentage is 100% recycled
> **Explanation:** 20% recycled content in the aluminum chassis is a real improvement over 0% — aluminum recycling uses ~95% less energy than primary production. However, proper evaluation means: (1) Does "20% recycled" apply to the chassis, the whole device, or just one small part? Selective framing can make a small gain look bigger. (2) Is this independently verified or self-reported? Third-party verification (e.g., through EPEAT) is more credible. (3) What about the other 80%? And the battery, screen, PCB? A good claim answers all these. Treat it as a positive data point, not a pass/fail sustainability verdict.

## Sidebar Reference Notes

### Book References
- **Velete — Green IT**
Chapter 8: all

### Certifications Quick Ref
- ⭐ Energy Star — operational efficiency — 🌿 EPEAT Gold — full lifecycle — 🔬 TCO Certified — most complete — ⚡ 80 PLUS Gold — PSU efficiency — ⚗️ RoHS — hazardous substances

### Greenwashing Sins
- 1. Hidden trade-off — 2. No proof — 3. Vagueness — 4. Irrelevance — 5. Lesser of two evils — 6. Fibbing — 7. False labels

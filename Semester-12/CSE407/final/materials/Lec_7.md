# Recycling & *E-Waste Management*
CSE407 Green Computing · Class 7 of 22 · Jun 25, 2025 · Wednesday · 1h 30min · 🎤 Guest Lecture: ICS & Logistics EWU

What happens to electronics when we're done with them — the materials inside, the lifecycle, the regulatory frameworks, and what engineers must design for from day one.

**References:** 📘 Velete Ch.7 (all) | 🎤 Guest: ICS & Logistics EWU | 🎯 CO2 | 🧠 EP1, EP2, EP5

**Key stats:**
- **62M** — Tonnes of e-waste generated globally in 2023 — a new record
- **17.4%** — Of e-waste formally recycled — the rest is dumped, burned, or landfilled
- **$57B** — Value of raw materials lost inside unrecycled e-waste each year
- **800+** — Chemicals in a modern smartphone, many toxic if released

## Recap, homework debrief & guest introduction
*Opening · 5 min*
Paperless recap + old device homework + guest speaker welcome

- Last class we tackled paper as a waste stream — and showed that going paperless has a clear financial and environmental ROI. Today we tackle the *other* end of the IT lifecycle: what happens when hardware dies? The answer — for most of the world, including Bangladesh — is deeply troubling.
- **📄 Paperless recap** — True cost of paper is 10–20× perceived. Six-phase roadmap: audit → legal → technology → pilot → rollout → monitor. E-signatures legally valid in Bangladesh under ICT Act 2006.
- **♻️ Today's pivot** — From software/process waste to hardware waste. E-waste is the world's fastest-growing waste stream — and engineers who design devices have the most power to change this.
- **🎤 Guest lecture** — Today's guest from ICS & Logistics, EWU will bring a supply-chain and logistics perspective to e-waste management in Bangladesh. Please save your questions for the Q&A after Section 5.
- 🗣 Homework Debrief (3 min)
- **?**
- What old device did you find? What is it, when was it bought, and where is it now? Let's do a quick class tally. How many devices are sitting in drawers in this room alone — and what's their combined raw material value? — Quick round-the-room tally — instructor notes on board

## The e-waste crisis — scale and consequences
*Foundation · 10 min*
Why e-waste is the world's fastest-growing waste stream

- Electronic waste — or **e-waste** — encompasses any discarded electrical or electronic device. It is growing at 3–4× the rate of any other waste category, driven by shortening device lifespans, falling hardware prices, and the explosive growth of connected devices. The problem is not just volume — it is what happens to that volume.
- 62Mt — E-waste generated in 2023 — equivalent to 62 Eiffel Towers in weight
- 17% — Formally recycled — 83% discarded unsafely or informally processed
- 2.6kg — E-waste generated per person globally each year — rising every year
- 500% — Projected growth in e-waste from developing nations by 2050 vs. 2010

> **☠️ What happens to the 83% not formally recycled**
> Open burning: Wire insulation is burned to expose copper — releasing dioxins, furans, and polyaromatic hydrocarbons directly into air and soil. Prevalent in informal recycling clusters in Agbogbloshie (Ghana), Guiyu (China), and in parts of Bangladesh. Landfill leaching: Lead, cadmium, and mercury from batteries and solder leach into groundwater. A single CRT monitor contains up to 4kg of lead. Informal acid baths: Circuit boards immersed in acid to dissolve and recover gold — releasing toxic heavy metals directly into waterways.

- **📈 Why it's growing so fast**
- Device lifespans shortening: average smartphone replaced every 2.5 years (down from 4+ years in 2010) — Falling prices → more devices per household → more eventual waste — IoT explosion: 50 billion+ devices by 2030, each with a finite lifespan — Planned obsolescence: software updates cease, batteries degrade, repairability is designed out — Fast-growing middle class in Asia and Africa buying first electronics
- **🌍 Who generates and who suffers**
- High-income countries generate most e-waste per capita (~22kg/person/year in Norway) — Much illegal export of e-waste to lower-income countries under "second-hand goods" labeling — Informal recycling workers — often children — suffer direct toxic exposure — Bangladesh receives e-waste from India, Gulf states, and through informal trade networks — The Basel Convention bans hazardous e-waste export — but enforcement is weak

## What's inside electronic devices
*Materials Science · 12 min*
Tap each material to see its value, toxicity, and where it comes from

- A modern smartphone contains over 60 different elements from the periodic table — including precious metals worth recovering, critical minerals with constrained supply chains, and toxic materials that cause serious harm if released. Understanding what's inside is the foundation of responsible design and recycling.
- 🥇 **Gold** — Precious · Recoverable
- 🥈 **Silver** — Precious · Recoverable
- 🔶 **Copper** — Base metal · High value
- 🔋 **Cobalt** — Critical mineral · Battery
- ⚡ **Lithium** — Critical mineral · Battery
- ☠️ **Lead** — Toxic · Solder & CRT
- 🌡️ **Mercury** — Highly toxic · Switches
- 📱 **Tantalum** — Conflict mineral · Capacitors
- **Gold (Au) — ~0.03g per smartphone, ~$2 per phone.** Used in circuit board connectors and microchip bonding wires for its excellent conductivity and corrosion resistance. One tonne of smartphones contains ~300g of gold — 40–80× richer than gold ore. Urban mining (recovering gold from e-waste) can be 6–13× more economical than primary mining. However, informal acid-bath extraction releases toxic compounds. Formal smelters use controlled processes that recover gold without toxic emissions.
- **Silver (Ag) — ~0.3g per smartphone, ~$0.20 per phone.** Used in conductive inks on PCBs, contacts, and RFID antennas. Second most electrically conductive element after copper. One tonne of smartphones contains ~3kg of silver. Recovery rate in formal recycling: ~85%. Informal recovery by burning circuit boards loses silver in slag.
- **Copper (Cu) — ~15g per smartphone, ~$0.15 per phone.** Used extensively in wiring, connectors, PCB traces, and coils. By weight, the most valuable common metal in e-waste. One tonne of smartphones yields ~15kg copper — at ~$9,000/tonne. Globally, e-waste copper represents a ~2 million tonne annual urban mine. Well-established formal recycling processes achieve 95%+ recovery. Wire burning is the informal alternative — releasing toxic dioxins.
- **Cobalt (Co) — ~5–10g per smartphone battery.** Critical for lithium-ion cathodes (LiCoO₂). ~70% of primary cobalt comes from the Democratic Republic of Congo, where artisanal mining is associated with child labour and serious human rights abuses. Battery demand is causing supply pressure. EV + mobile = cobalt recycling imperative. Battery recycling recovery rate for cobalt: currently ~5% globally — a massive value and resource loss.
- **Lithium (Li) — ~1–3g per smartphone battery.** Essential for rechargeable batteries in everything from phones to EVs. Primary lithium comes from Chilean/Argentinian salt flats (water-intensive extraction) and Australian hard rock mines. Lithium recycling from batteries is technically possible but economically challenged at current lithium prices. Recycling rate: ~1% globally. As EV adoption drives lithium prices higher, battery recycling economics will improve dramatically.
- **Lead (Pb) — up to 4kg in a CRT monitor; ~0.01g in modern smartphones (RoHS-restricted).** Formerly used extensively in solder (now largely replaced by tin-silver-copper alloys under RoHS) and CRT glass. Legacy CRT TVs and monitors still entering the waste stream are the primary lead source. Lead causes neurological damage especially in children — informal recycling exposing children to CRT lead is a documented global health crisis. Modern RoHS-compliant devices have greatly reduced lead content.
- **Mercury (Hg) — fluorescent backlights in older LCD screens; thermostats; some switches.** Highly toxic to the nervous system, kidneys, and respiratory system. Bioaccumulates in aquatic food chains. LED backlights (now standard) have eliminated mercury from most new displays — a major success story of design-for-environment. However, legacy fluorescent-lit LCDs entering the waste stream still pose a mercury risk. Requires specialist hazardous waste handling.
- **Tantalum (Ta) — capacitors in smartphones and laptops.** Critical for capacitors that provide stable power regulation in devices. ~60% of primary tantalum comes from the DRC and neighboring countries — classified as a "conflict mineral" under the US Dodd-Frank Act Section 1502. Companies must audit their supply chains to ensure tantalum is not financing armed conflict. Recycling tantalum from e-waste reduces dependence on conflict-affected sources — both economically and ethically.

> **💡 The urban mine concept**
> "Urban mining" treats e-waste stockpiles as a mineable resource rather than a waste problem. The concentration of gold, silver, copper, and critical minerals in e-waste is orders of magnitude higher than in natural ore deposits — yet remains overwhelmingly unextracted. The UNEP estimates the annual urban mine is worth over $57 billion — currently being burned or buried.

## Product lifecycle & Extended Producer Responsibility
*Policy & Design · 12 min*
Who is responsible for a device from cradle to grave — and what the law says

- **Extended Producer Responsibility (EPR)** is the policy principle that manufacturers are responsible for the entire lifecycle of their products — including collection and recycling at end of life. It directly shifts the financial and operational burden of e-waste from governments and consumers to the companies that created the products in the first place.

> **📘 From Velete Ch.7 — Why EPR changes engineering**
> When a manufacturer pays for end-of-life recycling costs, they have a financial incentive to design products that are cheaper to recycle — using fewer materials, fewer material types, fewer toxic substances, and designing for disassembly. EPR thus creates a direct feedback loop from end-of-life economics into product design decisions. This is why RoHS (Restriction of Hazardous Substances) and WEEE (Waste EEE Directive) together transformed European electronics design.

- **Raw Materials**
- **Extraction, refining & supply chain** — Scope 3 emissions | Conflict minerals | Water use
- **Embodied carbon** — Manufacturing a smartphone emits ~70kg CO₂e — 70-80% of its lifetime footprint. This happens before the device is even switched on. Engineers who choose materials and manufacturing processes shape this footprint most.
- **Critical minerals** — Cobalt (DRC), lithium (South America), rare earths (China, 60%+ supply) create supply chain concentration risk and geopolitical dependencies. Recycling reduces these dependencies.
- **Water consumption** — Semiconductor fabrication is extremely water-intensive: a single 300mm silicon wafer requires ~2,200 litres of ultra-pure water to manufacture.
- **Engineering lever** — Material substitution, reduced material use per device, responsibly sourced minerals (RMI certification), and design for longevity all reduce this phase's impact.
- **Manufacturing**
- **Assembly, testing & packaging** — Scope 1 & 2 emissions | Chemical waste | Packaging waste
- **Energy source matters** — A factory powered by coal vs. renewables can have 10× different carbon intensity for the same manufacturing process. Apple and Samsung have commitments to 100% renewable manufacturing.
- **Chemical waste** — PCB etching, soldering, and cleaning processes generate hazardous chemical waste streams that require careful management — a direct responsibility of manufacturing engineers.
- **Packaging design** — Apple's elimination of chargers and headphones from iPhone packaging reduced box size 70% — fitting more units per shipping container, cutting transport emissions significantly.
- **RoHS compliance** — EU Restriction of Hazardous Substances Directive prohibits lead, mercury, cadmium, hexavalent chromium, PBB, and PBDE in EEE — directly constraining material choice in manufacturing.
- **Use Phase**
- **Operational energy & lifespan** — Scope 2 emissions | Software obsolescence | Repairability
- **Operational energy** — For most consumer devices, energy use during the use phase is 20-30% of lifetime emissions (vs. 70-80% for manufacturing). Efficiency improvements here matter less than extending device lifespan.
- **Software obsolescence** — When a manufacturer stops providing OS updates, a device becomes insecure even if hardware is functional. EU's Right to Repair Regulation requires 5–10 year software support windows for many product categories.
- **Right to Repair** — EU regulation (2021+) requires manufacturers to supply spare parts for 7–10 years after sale, and to make repair manuals publicly available. Apple, Samsung, and Google now offer self-repair programs.
- **Longevity is greenest** — Extending a phone's life from 2 to 4 years cuts its per-year manufacturing emissions in half — the single most impactful consumer action on device carbon footprint.
- **End of Life**
- **Collection, sorting, recovery & disposal** — EPR obligation | Basel Convention | Informal sector
- **Collection systems** — Manufacturer take-back schemes, retail drop-off points, municipal collection events, and certified recycler networks. Collection rate is the primary bottleneck — getting devices from consumer hands to certified recyclers.
- **Formal recycling process** — Manual disassembly (battery removal, hazardous component separation) → mechanical shredding → material separation (eddy current, magnetic, density) → hydrometallurgical/pyrometallurgical recovery of metals.
- **Design for disassembly** — Snap-fits instead of glue, fewer material types, battery accessibility, modular components — all reduce recycling cost and improve material recovery rates. Frameworks: IEC 62474, iNEMI.
- **Informal sector reality** — In many developing countries including Bangladesh, informal recyclers handle the majority of e-waste using hazardous methods — but also provide livelihoods. Formalizing the informal sector (training, equipment, certification) is more realistic than eliminating it.
- **EPR Frameworks**
- **Extended Producer Responsibility in law** — WEEE (EU) | E-Waste Rules 2021 (BD) | Basel Convention
- **EU WEEE Directive** — Manufacturers must finance collection and recycling systems. Collection targets: 65% of average weight placed on market in last 3 years. Recovery targets: 75-85% by device type. Producer responsibility organisations (PROs) pool costs.
- **Bangladesh E-Waste Rules 2021** — Establishes EPR for EEE manufacturers and importers. Requires registration with DoE (Department of Environment), take-back schemes, and certified recycler partnerships. Enforcement currently limited but framework exists.
- **Basel Convention** — International treaty controlling transboundary movement of hazardous waste including e-waste. "Basel Ban Amendment" (2019) prohibits hazardous e-waste export from developed to developing nations. 187 parties, but enforcement varies widely.
- **Engineering obligation** — Under EPR, engineers who specify toxic materials, design devices that are hard to disassemble, or choose non-recyclable material combinations are creating future financial liabilities for their employer — not just environmental harm.

## How e-waste is actually recycled
*Technical · 10 min + Guest Q&A*
The technical process from collection to recovered materials — and the guest lecture

- Formal e-waste recycling is a sophisticated multi-stage industrial process — very different from the informal burning and acid-bath methods that dominate in many lower-income regions. Understanding how it works lets engineers design for it.
- 1️⃣ **Collection & logistics** — The biggest challenge: getting devices from consumers to certified facilities. Methods: retail take-back (Apple Genius Bar), municipal events, mail-in programs, certified recycler drop-offs. In Bangladesh: informal aggregators, e-waste collection drives by DoE, and WEEE-accredited processors.
- 2️⃣ **Data destruction** — Before any physical processing: cryptographic wiping (NIST 800-88 standard) or physical destruction of storage media. Critical for data privacy compliance — GDPR/Bangladesh Data Protection Act. Certificate of destruction required for business assets.
- 3️⃣ **Manual pre-processing** — Trained technicians remove: batteries (fire hazard if shredded), capacitors, CRT screens (lead glass), mercury-containing components, and large PCBs for separate processing. Protects downstream equipment and workers.
- 4️⃣ **Mechanical shredding & separation** — Remaining material fed into industrial shredders → mixed material stream separated using: eddy-current separators (non-ferrous metals), magnetic separators (ferrous metals), density separation (plastics vs. metals), and optical/IR sorting.
- 5️⃣ **Hydrometallurgical recovery** — Circuit board concentrates processed via chemical leaching and solvent extraction to recover gold, silver, palladium, and platinum group metals. Requires chemical expertise and waste treatment infrastructure.
- 6️⃣ **Pyrometallurgical smelting** — High-temperature (1,300°C+) smelting of mixed metal fractions to recover copper, precious metals, and other base metals. Energy-intensive but achieves very high recovery rates for multiple metal streams simultaneously.

> **🎤 Guest Lecture — ICS & Logistics, EWU**
> Our guest speaker brings direct industry experience in logistics and supply chain management for e-waste in Bangladesh. Topics to be covered: local collection network challenges, certified recycler availability, reverse logistics economics, and the informal sector interface. Please hold questions until after their presentation, then we'll open for Q&A.

## The circular economy in IT
*Strategy · 10 min*
From linear "take-make-waste" to circular "design-use-recover-redesign"

- The current IT hardware model is overwhelmingly **linear**: extract raw materials → manufacture → use → discard. A **circular economy** model aims to keep materials in use at their highest value for as long as possible — through reuse, repair, remanufacturing, and only finally recycling when all other options are exhausted.
- **🔄 The Circular Economy for IT Hardware**
- LINEAR MODEL (CURRENT — WASTEFUL)
- Extract
- Manufacture
- Use
- Discard
- 🗑️
- CIRCULAR MODEL — PREFERRED HIERARCHY
- IN USE
- Device
- Reuse
- Repair / Refurbish
- Remanufacture
- Recycle
- (last resort)

> **💡 The preferred hierarchy**
> In circular economy thinking, recycling is the last resort , not the goal. The preferred hierarchy (highest to lowest value retention): Reuse (give/sell device to another user) → Repair (fix and continue using) → Refurbish (restore to good condition) → Remanufacture (industrial-scale restoration to like-new) → Recycle (break down to recover materials). Engineers who enable these earlier stages — through repairability, modularity, and longevity — create far more value than optimizing the recycling process alone.

- **Design scenario** — A phone manufacturer glues the battery in place to achieve a thinner form factor. What circular economy impact does this have — and what should the engineer do?
- Answer — Glued batteries prevent user replacement — the most common repair that extends device life. When the battery degrades (~500 cycles), the entire device is typically discarded instead of a $20 battery swap. This pushes devices from Repair directly to Recycle, losing enormous embodied value. The engineer should advocate for accessible battery design — the EU Right to Repair regulation now requires it for many categories.
- **Procurement scenario** — EWU IT department needs to replace 100 computers. A vendor offers new machines at $500 each OR certified refurbished machines at $280 each. What should IT recommend, and why?
- Answer — Recommend certified refurbished — saves $22,000, reduces embodied carbon (manufacturing already done), keeps devices in the Remanufacture loop instead of triggering new manufacturing demand. Ensure: certification standard (e.g., R2/RIOS), data wipe certificate from the refurbisher, warranty coverage, and performance spec compatibility. This is a better financial AND environmental decision.
- **E-waste scenario** — An employee finds 30 old smartphones in a storage room — still functional but outdated. They're about to be sent to the e-waste bin. What's the circular economy response?
- Answer — Evaluate first: are any suitable for reuse (security staff, student loans, IoT sensors)? If not, are they refurbishable for donation (schools, NGOs)? If not, are any repairable with minor work? Only send to certified recycler what cannot be reused or repaired. Also: document the process as part of your organization's Scope 3 e-waste reporting. The circular hierarchy should be applied before the recycling bin.

## E-waste in Bangladesh
*Local Focus · 8 min*
The scale, the informal sector, the rules, and what engineers here can do

- Bangladesh generates approximately 200,000–400,000 tonnes of e-waste annually — much of it from rapid adoption of mobile phones, consumer electronics, and industrial equipment. The vast majority is managed by the informal sector.
- **📊 Key local facts**
- ~100,000 informal e-waste workers in Bangladesh — primarily in Dhaka's Nimtoli, Islampur, and Mitford areas — Bangladesh is a net importer of second-hand and end-of-life electronics from India, Gulf states, and Southeast Asia — Mobile phone penetration now exceeds 90% — creating a massive future e-waste pipeline — Only a handful of DoE-certified formal recyclers currently operate in Bangladesh — Lead poisoning from informal CRT and battery recycling is documented in Dhaka's recycling clusters
- **⚖️ The regulatory framework**
- **E-Waste Management Rules 2021** — EPR framework: registration, take-back, certified disposal required for manufacturers/importers — **DoE enforcement** — currently limited resources; most formal activity is registration-only — **Bangladesh National 3R (Reduce/Reuse/Recycle) Strategy** — prioritizes waste reduction hierarchy — **Basel Convention party** — Bangladesh is a signatory; import of hazardous e-waste is technically regulated

> **🔧 Engineering opportunity**
> The gap between Bangladesh's formal e-waste framework (E-Waste Rules 2021) and informal sector reality is enormous — and represents a significant engineering and entrepreneurial opportunity. Needed: affordable informal-to-formal sector transition models, low-cost testing/sorting equipment for small recyclers, IoT-enabled e-waste collection tracking systems, and public-private collection schemes. Engineers with knowledge of both the technical and regulatory landscape are ideally positioned to design these solutions.

- 🗣 Discussion (3 min)
- **?**
- If you were designing an e-waste collection system for a university like EWU — how would you design it? What would it look like, where would the collected devices go, and how would you make it self-sustaining financially? — Pairs → 2 ideas shared with class

## Class quiz — recycling & e-waste
*Assessment · 10 min*
6 questions covering today's content

## Summary & next steps
*Wrap-up · 5 min*
Key takeaways and Class 8 preview

- ⚠️ **62Mt — and growing** — E-waste is the world's fastest-growing waste stream. Only 17% is formally recycled. The rest is burned, landfilled, or informally processed with toxic consequences.
- 🔬 **The urban mine** — E-waste contains gold, silver, copper, cobalt, lithium — worth $57B annually. Also contains lead, mercury, cadmium — toxic if released. Both realities drive formal recycling.
- ⚖️ **EPR changes design** — When manufacturers pay for end-of-life recycling, they have incentive to design for recyclability. RoHS + WEEE + Bangladesh E-Waste Rules 2021 create this accountability.
- 🔁 **Circular hierarchy** — Reuse → Repair → Refurbish → Remanufacture → Recycle. Recycling is last resort. Engineers who enable earlier stages create far more value and less waste.
- 🇧🇩 **Bangladesh context** — 200,000–400,000t/year, mostly informal sector. E-Waste Rules 2021 exist but enforcement is weak. Large opportunity gap for formal sector engineering solutions.
- 🛠️ **Design from day one** — Material choice, disassembly design, repairability, and longevity are engineering decisions with direct recycling consequences. Design for the end from the beginning.

> **📚 Next Class — Class 8 (Jun 29, Sunday)**
> Sustainable Hardware. Moving from end-of-life back to the beginning: how do we design, specify, and procure IT hardware sustainably? Energy Star, TCO certification, lifecycle assessment for hardware, and green procurement frameworks. Read: Velete Ch.8 (all) before class.

> **📝 Before Class 8**
> Look up the Energy Star rating or TCO Certification status of any device you own or use regularly (laptop, monitor, phone). Find one sustainability claim the manufacturer makes about that device — and think critically: is it specific and verifiable, or vague greenwashing? Bring the claim and your assessment to Class 8.

## Class Quiz

**Q1. Globally, approximately what percentage of e-waste is formally recycled through certified processes?**
▫️ A. About 50% — most countries have good recycling infrastructure
✅ B. About 17% — the vast majority is dumped, burned, or informally processed
▫️ C. About 80% — regulations have been very effective
▫️ D. About 5% — recycling infrastructure barely exists anywhere
> **Explanation:** According to the Global E-Waste Monitor, only approximately 17.4% of e-waste generated globally is formally collected and recycled. The remaining ~83% is either landfilled, burned, or handled by informal recyclers using hazardous methods (open burning, acid baths). This is despite the fact that e-waste contains $57 billion worth of recoverable materials annually.

**Q2. A 30-year-old CRT television is being disposed of. Which toxic material is it most likely to contain in significant quantities, and what is the health concern?**
▫️ A. Gold — which is valuable and non-toxic
✅ B. Lead — up to 4kg in the glass screen, causing neurological damage especially in children who encounter informal recycling sites
▫️ C. Mercury — used as a coolant in CRT tubes
▫️ D. Cobalt — from the cathode ray tube cathode
> **Explanation:** CRT (Cathode Ray Tube) monitors and televisions contain up to 4kg of lead in their glass screens — lead was used to shield users from X-ray radiation emitted by the electron gun. When CRTs are crushed or incinerated in informal recycling, this lead is released. Lead exposure causes serious irreversible neurological damage, especially in children, affecting IQ, behaviour, and development. This is why specialist CRT handling is required under WEEE and similar regulations.

**Q3. What is "Extended Producer Responsibility" (EPR) and what is its most important effect on product engineering?**
▫️ A. A rule requiring manufacturers to respond to extended warranty claims quickly
✅ B. A policy that makes manufacturers financially responsible for end-of-life collection and recycling — creating a financial incentive to design products that are cheaper and easier to recycle
▫️ C. A tax on electronics sold above a certain price point
▫️ D. A requirement that engineers take responsibility for product marketing claims
> **Explanation:** EPR shifts end-of-life costs from governments and consumers back to the manufacturer. When a company pays the bill for recycling their own products, they have a direct financial incentive to: reduce material complexity (fewer material types = cheaper to sort), eliminate toxic materials (less costly hazardous waste handling), design for disassembly (lower labour cost to process), and extend product life (fewer units entering the waste stream). EPR thus creates a market feedback loop from end-of-life economics into engineering decisions — which is why WEEE + RoHS together transformed European electronics design.

**Q4. In the circular economy hierarchy for IT hardware, which action should an engineer prioritize FIRST when a device reaches end of useful life in an organization?**
▫️ A. Send it to a certified e-waste recycler immediately
▫️ B. Incinerate it securely to prevent data breaches
✅ C. Evaluate whether the device can be reused, repaired, or refurbished before considering recycling
▫️ D. Landfill it since recycling is too expensive for single devices
> **Explanation:** The circular economy hierarchy places recycling as the LAST resort, not the first response. The preferred order is: Reuse (can another user in the organization use it? Can it be donated?) → Repair (can a minor fix extend its life?) → Refurbish (can it be restored to good condition?) → Remanufacture (industrial restoration) → Recycle (break down to materials only when all other options are exhausted). Each earlier stage retains far more value — embodied energy, materials, and functionality — than recycling, which only recovers raw materials.

**Q5. Which of the following statements about the materials inside a modern smartphone is CORRECT?**
▫️ A. Smartphones are mostly plastic and glass — they contain very few metals worth recovering
✅ B. A single smartphone contains gold, silver, copper, cobalt, lithium, and rare earth elements — making a tonne of smartphones 40–80× richer in gold than gold ore, qualifying as an "urban mine"
▫️ C. Smartphones are designed to contain only non-toxic materials under modern regulations
▫️ D. The most valuable material in a smartphone is its plastic casing
> **Explanation:** Modern smartphones contain 60+ elements including gold (~0.03g/phone), silver (~0.3g/phone), copper (~15g/phone), cobalt (battery), lithium (battery), palladium, tantalum, and rare earth elements. A tonne of smartphones yields ~300g of gold — 40–80× richer than the average gold ore concentration. This is the basis of the "urban mine" concept: e-waste stockpiles are more valuable mineral resources than many primary mines, currently being wasted through informal processing or landfilling.

**Q6. Bangladesh's E-Waste Management Rules 2021 establish which specific mechanism for making manufacturers responsible for e-waste?**
▫️ A. A direct tax on electronic devices at point of sale, paid to the government for recycling programs
✅ B. Extended Producer Responsibility (EPR) — requiring manufacturers and importers to register, establish take-back schemes, and ensure certified disposal of their end-of-life products
▫️ C. A ban on all second-hand electronics imports into Bangladesh
▫️ D. A requirement that consumers pay a recycling fee when purchasing new devices
> **Explanation:** Bangladesh's E-Waste Rules 2021 establish an EPR framework specifically: manufacturers and importers of Electrical and Electronic Equipment (EEE) must register with the Department of Environment (DoE), establish or contribute to take-back collection schemes, and ensure end-of-life devices go to certified recyclers who provide documentation. This mirrors the EU WEEE Directive model. Current enforcement is limited in practice, but the legal framework is now in place — and is expected to tighten as the DoE builds capacity.

## Sidebar Reference Notes

### Book References
- **Velete — Green IT**
Chapter 7: all

### Circular Hierarchy
- 1️⃣ Reuse (highest value) — 2️⃣ Repair — 3️⃣ Refurbish — 4️⃣ Remanufacture — 5️⃣ Recycle (last resort) — ❌ Landfill / Burn

### Key Toxic Materials
- ☠️ Lead — CRT glass, solder — 🌡️ Mercury — backlights, switches — ⚗️ Cadmium — batteries, coatings — 🔴 Chromium VI — corrosion protection — RoHS restricts all of these in new EEE

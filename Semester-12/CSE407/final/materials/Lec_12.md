# Green IoT Technologies
*Part 1 — Sensing, Connecting, Powering the Edge*
CSE407 Green Computing · Class 16 of 22 · Aug 24, 2025 · Sunday · 1h 30min

Billions of tiny devices, each drawing almost nothing — but at planetary scale, "almost nothing" adds up. Today: the Green IoT paradox, low-power hardware design, and the wireless protocols built for years of battery life.

**References:** 📘 Lecture Slides — Green IoT | 🎯 CO3 | 🧠 EP1, EP2

**Key stats:**
- **29B** — Projected connected IoT devices worldwide by 2030
- **<1W** — Typical power draw of a low-power IoT sensor node
- **10+** — Years of battery life achievable with proper low-power design
- **15km+** — Typical LoRaWAN range in open, rural environments

## Quick recap & homework review
*Opening · 5 min*
Cloud computing recap — where the edge picks up where the cloud leaves off

- Last class we looked at cloud computing — centralizing compute into large, efficient hyperscale facilities. Today we go the opposite direction: to the "edge," where billions of small, distributed, low-power devices sense the physical world and feed data back toward that cloud. Green IoT sits at the intersection of both worlds.
- **☁️ Cloud elasticity** — On-demand compute lets workloads scale up and down, avoiding the idle-server waste of fixed on-premise infrastructure.
- **🌍 Shared responsibility** — Provider secures and greens the infrastructure; the customer is responsible for how efficiently they use it — right-sizing matters.
- **📡 The edge connection** — Not everything can or should go to the cloud — sensors generating small, frequent readings need a different design philosophy entirely.
- 🗣 Homework Debrief (5 min)
- **?**
- Think of one IoT device you use or have seen (smart bulb, fitness tracker, weather station, etc.). Roughly how long does its battery last, and does that match what you'd now expect from a "green" design? — 2–3 students share findings

## The Green IoT paradox — two meanings, one term
*Foundation · 10 min*
Greening of IoT vs. Greening by IoT

- "Green IoT" is used in two related but distinct senses, and mixing them up causes real confusion in research and industry alike. Both matter, and today's material touches both.

> **⚖️ The paradox in one line**
> IoT can be an enormous tool for sustainability (smart grids, precision agriculture, leak detection) while simultaneously being an enormous source of energy and e-waste burden if devices, networks, and data pipelines aren't designed efficiently.

- **🔧 Greening of IoT** — Making the IoT devices and networks themselves energy-efficient: low-power hardware, efficient protocols, energy harvesting, and responsible end-of-life recycling for the devices themselves.
- **🌱 Greening by IoT** — Using IoT sensing and control to reduce energy use elsewhere: smart thermostats, smart grids, precision irrigation, leak detection, traffic optimization — IoT as a sustainability tool for other systems.
- 1.5% — Estimated share of global electricity consumption attributable to ICT devices and networks including IoT (varies by study)
- 30%+ — Potential energy savings in a building from smart sensing and automated HVAC/lighting control
- 1000s — Sensor nodes that can be deployed for the embodied-carbon cost of a single server — a real trade-off to weigh
- 2–5 yrs — Typical replacement cycle for poorly-designed IoT devices — a major e-waste driver at scale

## Low-power hardware design
*Core Concept · 15 min*
Duty cycling, sleep states, and the "1% rule" of sensor design

- A battery-powered sensor that needs to run for years cannot simply stay "on." The entire design philosophy revolves around spending as much time as possible in the deepest sleep state the application allows, waking briefly only to sense, compute, and transmit.

> **💡 The 1% rule**
> Well-designed IoT sensor nodes are often active for well under 1% of their lifetime . A soil-moisture sensor that wakes for 100 milliseconds every 10 minutes is awake roughly 0.017% of the time — nearly all of its energy budget is therefore spent on sleep current, not active current.

| Power state | Typical current draw | What's running |
|---|---|---|
| **Active / transmit** | 10–120 mA | CPU at full clock, radio transmitting — the most power-hungry state, kept as brief as possible |
| **Active / compute only** | 1–15 mA | CPU processing sensor readings, radio off |
| **Idle** | 0.5–2 mA | CPU clocked down, peripherals mostly off, waiting for a timer or interrupt |
| **Sleep / standby** | 1–50 µA | Only a real-time clock and wake logic powered; RAM often retained |
| **Deep sleep / shutdown** | 0.02–1 µA | Nearly everything off; wake only via external reset or long timer |

- Three design techniques dominate low-power IoT hardware:
- **⏱️ Duty cycling** — Sensing and radio hardware are powered on only for short, scheduled bursts, then returned to sleep — the single biggest lever for battery life.
- **🎯 Event-driven wake** — Instead of polling on a timer, hardware interrupts (motion, threshold crossing) wake the device only when something actually changes.
- **📶 Radio efficiency** — Radio transmission is typically the single most expensive operation per event — minimizing payload size and transmission frequency matters more than CPU efficiency in most designs.
- **🧮 Right-sized compute** — Ultra-low-power microcontrollers (not general-purpose CPUs) are chosen specifically for their sleep-current specifications, sometimes trading raw speed for standby efficiency.

## Low-power wide-area network (LPWAN) protocols
*Key Technique · 15 min*
Choosing the right radio technology for range, power, and data needs

- No single wireless protocol is best for every IoT application — each trades off range, power, bandwidth, and cost differently. Choosing the wrong one is one of the most common (and expensive) green-IoT design mistakes.
- **LoRaWAN**
- **Long Range, Wide Area Network** — Unlicensed spectrum — operator-independent
- **Range** — 2–5 km urban, 15+ km rural line-of-sight — excellent for sparse, wide-area deployments.
- **Power** — Extremely low — years of battery life on a coin cell for infrequent, small messages.
- **Data rate** — 0.3–50 kbps — designed for small, infrequent payloads, not streaming data.
- **Best for** — Agricultural sensors, rural utility metering, environmental monitoring across large, unpowered areas.
- **NB-IoT**
- **Narrowband IoT** — Licensed cellular spectrum — runs on existing telecom towers
- **Range** — 1–10 km, benefits from existing dense cellular tower coverage — no new gateways needed.
- **Power** — Very low, though somewhat higher than LoRaWAN — still years of battery life achievable.
- **Data rate** — Up to ~250 kbps — more headroom than LoRaWAN, still modest.
- **Best for** — Smart metering and asset tracking where telecom coverage already exists — no private gateway infrastructure to maintain.
- **Zigbee**
- **Mesh networking protocol** — Short range, self-healing mesh topology
- **Range** — 10–100 m per hop, but devices relay for each other — a mesh can span a whole building.
- **Power** — Low, though relay nodes (routers) draw more than simple end devices, which stay in deep sleep.
- **Data rate** — Up to 250 kbps — enough for smart-home control messages.
- **Best for** — Dense indoor deployments — smart lighting, home automation, building sensor networks.
- **BLE**
- **Bluetooth Low Energy** — Short range, ubiquitous smartphone compatibility
- **Range** — 10–50 m typical — designed for personal-area, not wide-area, coverage.
- **Power** — Very low for advertisement/beacon use cases; months to years on a coin cell.
- **Data rate** — Up to ~2 Mbps — the fastest of this group, useful for occasional bulk syncs.
- **Best for** — Wearables, proximity beacons, and any device that syncs directly with a nearby smartphone.

| Protocol | Typical range | Power profile | Data rate | Spectrum |
|---|---|---|---|---|
| **LoRaWAN** | 2–15+ km | Very low | 0.3–50 kbps | Unlicensed |
| **NB-IoT** | 1–10 km | Very low | Up to ~250 kbps | Licensed cellular |
| **Zigbee** | 10–100 m/hop | Low | Up to 250 kbps | Unlicensed (mesh) |
| **BLE** | 10–50 m | Very low | Up to ~2 Mbps | Unlicensed |

## Energy harvesting — beyond the battery
*Applied · 10 min*
Solar, vibration, and thermal sources that can eliminate battery replacement entirely

- The greenest battery is the one you never have to replace or dispose of. When paired with the ultra-low power budgets from the previous section, small amounts of harvested ambient energy can keep a sensor running indefinitely.
- **☀️ Photovoltaic (solar)** — Small solar cells, even indoors under artificial light, can generate 10–200 mW outdoors — often more than enough to trickle-charge a supercapacitor or small battery for a duty-cycled sensor.
- **📳 Piezoelectric (vibration)** — Converts mechanical vibration or strain into electricity — used on industrial machinery, bridges, and railway sensors where vibration is constant and free.
- **🌡️ Thermoelectric** — Harvests energy from temperature differentials (e.g., a pipe's surface vs. ambient air) — useful in industrial monitoring near heat sources.
- **📶 RF harvesting** — Captures ambient radio-frequency energy from Wi-Fi or cellular signals — powers only extremely low-draw devices, but requires zero dedicated infrastructure.
- **🔧 Interactive: IoT Power Budget & Battery Life Calculator**
- **Adjust the active/sleep profile of a sensor node and see estimated battery life on a typical coin-cell battery.**
- Active current (mA) — **30 mA**
- Active time per day (seconds) — **30 s**
- Sleep current (µA) — **5 µA**
- Battery capacity (mAh) — **1000 mAh**
- **Estimated battery life**
- —
- <1 yr10+ yrs

> **💡 Why this matters at scale**
> A sensor that needs a battery swap every 18 months versus one that lasts 10 years isn't just a convenience difference — across a 10,000-node deployment, it's the difference between roughly 6,700 truck-rolls and battery replacements per year versus almost none. Design choices at the single-device level compound enormously at fleet scale.

## Math practice — small, quick calculations
*Practice · 10 min*
Apply today's formulas (duty cycle, battery life, range, harvesting) to five short problems

- Try each problem on paper first — they're all short, one- or two-step calculations. Tap a card to reveal the worked answer.
- **1** — A sensor wakes up and is active for **2 seconds** every **10 minutes**. What is its duty cycle, as a percentage?
- Duty cycle = active time ÷ period × 100% — 2 s ÷ 600 s × 100% ≈ 0.33% — The sensor spends 99.67% of its life asleep — which is exactly why sleep current, not active current, dominates the total energy budget.
- **2** — A sensor draws a steady **5 µA** in deep sleep (ignore brief wake spikes). Its battery is rated **1000 mAh**. Roughly how many years will it last?
- Life (hrs) = capacity (mAh) ÷ current (mA) — 1000 ÷ 0.005 = 200,000 hrs ≈ 22.8 years — In practice, self-discharge and wake spikes shorten this — but it shows why a well-designed sleep current can make the battery outlast the product itself.
- **3** — A LoRaWAN gateway has a usable range of **15 km** in every direction. Approximately how large an area (in km²) can one gateway cover?
- Area = π × radius² — π × 15² ≈ 706.9 km² — This is why a single LoRaWAN gateway can economically cover a large rural district with a sparse network of sensors.
- **4** — A network has **500 sensors**, each sending a **20-byte** message every **10 minutes**. How much total data does the network send per day?
- Msgs/day = (1440 min ÷ 10) × sensors; Data = msgs × bytes — 144 × 500 = 72,000 msgs → × 20 B ≈ 1.44 MB/day — Despite 500 devices running continuously, the entire network's daily traffic is smaller than a single typical photo — a hallmark of well-designed IoT traffic.
- **5** — A small solar panel produces an average of **50 mW** over **6 hours** of usable sunlight per day. How much energy (in mWh) does it harvest daily?
- Energy = power × time — 50 mW × 6 h = 300 mWh/day — Compare this to a coin-cell battery's total lifetime capacity (often just a few hundred mWh) — one good day of harvesting can rival an entire battery's stored energy.

## Green IoT in Bangladesh
*Local Context · 10 min*
Smart agriculture, flood sensing, and deploying IoT where grid power isn't guaranteed

- Bangladesh is, in many ways, an ideal proving ground for Green IoT — a large agricultural sector, real flood risk to monitor, and a rural population not always well served by continuous grid power. Low-power design here isn't a nice-to-have; it's often the only thing that makes deployment feasible at all.
- **🌾 Smart agriculture** — Soil moisture and irrigation sensors deployed across dispersed farmland benefit directly from LoRaWAN's long range and multi-year battery life — no mains power or frequent site visits needed.
- **🌊 Flood & water-level sensing** — Remote river and embankment sensors in flood-prone regions must survive years unattended, often solar-powered, reporting infrequently to conserve energy — exactly the low-duty-cycle design pattern from today's class.
- **📶 Cellular coverage advantage** — Bangladesh's relatively dense mobile network coverage makes NB-IoT attractive for metering and tracking applications — no need to build private gateway infrastructure.
- **🔌 Off-grid power reality** — Rural and even some urban deployment sites can't rely on continuous mains power — solar or battery-only operation isn't optional, it's the default design constraint from day one.
- **Deployment scenario** — A team wants to deploy 200 soil-moisture sensors across a large rice field with no mains power nearby. Which protocol and power strategy fits best?
- Answer — LoRaWAN — its long range covers the whole field from one or two gateways, and its very low power profile pairs well with a small solar panel or multi-year battery, avoiding the need for mains power entirely.
- **Flood monitoring scenario** — A river water-level sensor must run unattended for 5+ years in a remote area. What design choices matter most?
- Answer — Aggressive duty cycling (report every 15–30 min, not continuously), deep-sleep hardware, a small solar panel with a supercapacitor buffer for cloudy days, and a long-range low-power protocol like LoRaWAN to avoid frequent site visits.
- 🗣 Class Discussion (5 min)
- **1**
- If your midterm energy-monitoring dashboard used battery-powered wireless sensors instead of wired ones, what would need to change about how often you sample and transmit data? — Open discussion — pairs first, then class

## Class quiz — Green IoT Technologies (Part 1)
*Assessment · 10 min*
6 questions covering today's content

## Summary & next steps
*Wrap-up · 5 min*
Key takeaways and Class 17 preview

- ⚖️ **Two kinds of green** — Greening of IoT (efficient devices) and greening by IoT (using sensing to save energy elsewhere) are related but distinct goals.
- 🔋 **The 1% rule** — Well-designed sensors are active under 1% of the time. Sleep current, not active current, usually dominates battery life.
- 📡 **No universal protocol** — LoRaWAN, NB-IoT, Zigbee, and BLE each trade off range, power, and data rate differently — match the protocol to the deployment.
- ☀️ **Harvesting beats replacing** — Solar, vibration, thermal, and RF harvesting can eliminate battery swaps entirely when paired with an ultra-low power budget.
- 🧮 **The math is simple** — Duty cycle, battery life, coverage area, and harvested energy are all short, direct calculations once you know the formula.
- 🇧🇩 **Bangladesh use cases** — Smart agriculture and flood sensing make low-power, long-range design a necessity here, not a luxury.

> **📚 Next Class — Class 17**
> Green IoT Technologies — Part 2. We continue with IoT data pipelines and edge vs. cloud processing trade-offs, security and privacy considerations for low-power devices, and the e-waste and lifecycle challenges of deploying IoT at massive scale.

> **📝 Ongoing — Term Paper**
> Keep progressing on your term paper research. If your topic touches sensing, monitoring, or smart infrastructure, today's material on power budgets and protocol choice may be directly relevant to your methodology section.

## Class Quiz

**Q1. What is the key difference between "Greening of IoT" and "Greening by IoT"?**
▫️ A. They mean exactly the same thing and are used interchangeably
✅ B. Greening of IoT means making IoT devices and networks themselves energy-efficient; Greening by IoT means using IoT sensing to reduce energy use in other systems
▫️ C. Greening of IoT only applies to industrial sensors, while Greening by IoT only applies to consumer devices
▫️ D. Greening by IoT refers only to solar-powered devices
> **Explanation:** Greening of IoT is about efficient hardware, protocols, and lifecycle for the devices themselves. Greening by IoT is about using IoT as a tool — smart grids, precision agriculture, leak detection — to reduce energy consumption elsewhere. Both matter, but they are distinct goals that are often conflated.

**Q2. A well-designed battery-powered sensor node is described as following the "1% rule." What does this mean?**
▫️ A. The device must cost less than 1% of the total project budget
✅ B. The device is active (awake, sensing, transmitting) for well under 1% of its total operating time — the rest is spent in deep sleep
▫️ C. The device must achieve at least 1% energy savings compared to a wired sensor
▫️ D. The device's battery must retain at least 1% charge at all times
> **Explanation:** Well-designed IoT sensors spend the overwhelming majority of their life in deep sleep, waking only briefly to sense and transmit. This is why sleep current — often just a few microamps — dominates the total energy budget far more than active/transmit current.

**Q3. A rural water-level monitoring project needs to cover a large area with infrequent, small data packets, with no existing gateway infrastructure. Which protocol is the best fit?**
▫️ A. Bluetooth Low Energy (BLE), because it has the highest data rate
▫️ B. Zigbee, because mesh networks always have the longest range
✅ C. LoRaWAN, because of its multi-kilometer range and very low power draw for small, infrequent payloads
▫️ D. NB-IoT, because it requires no cellular coverage at all
> **Explanation:** LoRaWAN is purpose-built for exactly this scenario: wide geographic coverage (kilometers) with very low power consumption for small, infrequent messages, using unlicensed spectrum and operator-independent gateways.

**Q4. Why is radio transmission usually the single most energy-expensive operation in an IoT sensor's duty cycle?**
▫️ A. Radios always draw more current than any other component in every possible state
✅ B. Even though brief, transmitting typically draws the highest instantaneous current of any operation the device performs — minimizing payload size and transmission frequency has an outsized effect on total energy use
▫️ C. Radios cannot be turned off between transmissions
▫️ D. Radio transmission energy cost is independent of message size or frequency
> **Explanation:** While a radio's "on" time may be brief, its current draw during transmission is often the highest peak in the entire duty cycle — frequently tens to over a hundred mA. This is why reducing payload size and transmission frequency yields outsized energy savings compared to optimizing CPU compute alone.

**Q5. A sensor draws 3 µA continuously in deep sleep. Its battery is rated at 600 mAh. Approximately how many years of battery life does this provide (ignoring active-mode draw and self-discharge)?**
*Context: Life (hours) = battery capacity (mAh) ÷ current (mA). 1 year ≈ 8,760 hours.*
▫️ A. About 2.3 years
▫️ B. About 10 years
✅ C. About 22.8 years
▫️ D. About 45 years
> **Explanation:** 600 mAh ÷ 0.003 mA = 200,000 hours. 200,000 ÷ 8,760 ≈ 22.8 years. This illustrates why sleep current in the low single-digit microamp range can make a sensor's battery outlast the product itself.

**Q6. Why is off-grid, solar or battery-only power often the default design constraint — not an optional feature — for IoT deployments in rural Bangladesh?**
▫️ A. Solar panels are mandated by national law for all electronics
✅ B. Many rural and even some urban deployment sites lack reliable continuous mains power, so devices must be designed from the outset to run on harvested or battery power alone
▫️ C. Rural areas in Bangladesh have no need for IoT sensors at all
▫️ D. Grid electricity is more expensive in rural areas than solar panels, making solar always cheaper
> **Explanation:** Unlike a data center where designers choose redundancy and efficiency trade-offs, many rural IoT deployment sites in Bangladesh simply don't have reliable mains power nearby. Off-grid operation (solar, battery, or harvesting) isn't a nice-to-have efficiency choice — it's the baseline requirement that makes deployment possible at all.

## Sidebar Reference Notes

### Reference
- **Lecture Slides**
Green IoT Technologies

### Protocol Quick Reference
- 📡 LoRaWAN → 2–15+ km, very low power — 📶 NB-IoT → 1–10 km, licensed cellular — 🕸️ Zigbee → 10–100 m/hop, mesh — 🔵 BLE → 10–50 m, fastest data rate

### ⚠️ Reminder
- **Term paper progress** — continue collecting data and refining your methodology this week.

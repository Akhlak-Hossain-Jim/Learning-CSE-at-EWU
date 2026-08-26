# Virtualization & Server Consolidation
*Multiplying Watt Efficiency via Abstraction*
CSE407 Green Computing · Class 12 of 22 · Aug 7, 2025 · Thursday · 1h 30min

How hypervisors, server consolidation, and dynamic resource allocation eliminate server sprawl, elevate CPU utilization from sub-15% to 70%+, and slash idle power draw.

**References:** 📘 Velete Ch.12 (all) | 📗 Lamb Ch.6 (all) | 🎯 CO3 | 🧠 EP1, EP2, EP5 | 💻 Lab: VM Consolidation

**Key stats:**
- **10–15%** — Average CPU utilization in traditional non-virtualized enterprise data centers
- **10:1** — Typical consolidation ratio — collapsing 10 physical servers into 1 host
- **60–70%** — Base power drawn by an idle server relative to its peak power consumption
- **Type 1** — Bare-metal hypervisors providing the highest efficiency for enterprise workloads

## Class 11 recap & transition to software layer
*Opening · 5 min*
From physical infrastructure and Tier designs to software-defined efficiency

- In Class 11, we explored the physical constraints of data center engineering: site selection, Uptime Institute Tiers (I–IV), N+1/2N redundancy, and PUE calculations. Today, we step into the software layer. Even the greenest Tier IV data center with a 1.15 PUE is inherently wasteful if its underlying servers sit idle at 10% utilization.
- **🏢 Physical infrastructure (C11)** — Provides reliable power, cooling, and space. Focuses on minimizing facility overhead power (PUE).
- **💻 Logical abstraction (C12)** — Decouples software from physical hardware. Maximizes IT compute yield per watt delivered.
- **🎯 Combined impact** — Cooling optimization reduces overhead; server consolidation eliminates unnecessary hardware loads entirely.
- 🗣 Quick Discussion (5 min)
- **?**
- Why does a physical server drawing 200W idle power consume ~120W even when doing zero active processing? What makes idle server power such a critical problem in green computing? — 2–3 students share responses

## Virtualization fundamentals & server sprawl
*Foundation · 10 min*
How hardware abstraction tackles server sprawl and low utilization

- Before virtualization, the enterprise standard was "one application per physical server." This isolated workloads safely but led to massive **server sprawl**—racks filled with machines running at 5% to 15% average CPU utilization, consuming massive base electrical power 24/7.

> **🧭 The virtualization promise**
> Virtualization introduces a software abstraction layer between hardware and operating systems. By running multiple Virtual Machines (VMs) on a single physical host, hardware resources (CPU, RAM, Storage, NICs) are pooled and dynamically shared, transforming idle capacity into active compute.

- 10–15% — Typical legacy physical server utilization
- 65–80% — Target utilization for a well-consolidated virtualized host cluster
- 50–70% — Average reduction in physical server hardware footprint after virtualization
- 3:1 to 15:1 — Typical VM-to-physical host consolidation ratios in enterprise environments
- **❌ The bare-metal trap (Legacy)**
- 1 application = 1 physical server — Power consumed primarily by idle baseline overhead — High capital cost (CapEx) and floor space consumption — Complex disaster recovery and slow provisioning (weeks)
- **✅ Virtualized paradigm (Modern)**
- N applications isolated safely on 1 physical host — Power consumption scales proportionally with actual work — Drastic reduction in power, cooling, and rack footprint — Rapid VM provisioning (minutes) and live migration capabilities

## Hypervisors: Type 1 (Bare-Metal) vs Type 2 (Hosted)
*Core Concept · 15 min*
Architectural differences and energy efficiency profiles

- The **hypervisor** (or Virtual Machine Monitor - VMM) is the core software engine that manages hardware resources and isolates VMs. The architectural placement of the hypervisor dictates its efficiency and overhead.

| Feature | Type 1 (Bare-Metal) | Type 2 (Hosted) |
|---|---|---|
| **Architecture** | Runs directly on hardware bare-metal | Runs on top of a host Operating System (OS) |
| **Performance Overhead** | Near-zero (~1–3%) | Moderate to High (~10–20%) |
| **Energy Efficiency** | Optimal — full control of hardware CPU states | Suboptimal — wasted OS overhead layer |
| **Security Isolation** | High — thin attack surface | Lower — vulnerable to host OS exploits |
| **Typical Examples** | VMware ESXi, KVM, Microsoft Hyper-V, Xen | Oracle VirtualBox, VMware Workstation |
| **Target Deployment** | Enterprise Data Centers & Cloud Infrastructure | Developer workstations, testing, client desktops |

> **💡 Green IT Rule for Virtualization Architecture**
> Always deploy **Type 1 (Bare-Metal)** hypervisors in enterprise environments. Type 2 hypervisors duplicate OS overhead, waste CPU cycles on host system kernel calls, and prevent direct CPU low-power state adjustments (C-states/P-states), creating unnecessary thermal and power overhead.

## Server consolidation & the power curve
*Key Technique · 15 min*
Understanding non-linear power-to-utilization curves

- Server power draw is not linear. An idle physical server consumes roughly **50% to 70%** of its maximum power draw. By consolidating VMs onto fewer physical servers and turning off unused hosts, energy savings drop dramatically.
- **10 Hosts @ 10% Load**
- **Unconsolidated Sprawl** — 10 physical servers, each running 1 light workload
- **Power Usage** — 10 servers × 140W (idle + light load) = **1,400 Watts**.
- **Efficiency Rating** — Extremely wasteful. 90% of electrical energy powers idle silicon.
- **2 Hosts @ 50% Load**
- **Static Consolidation** — Workloads combined onto 2 active hosts; 8 decommissioned
- **Power Usage** — 2 active servers × 180W (50% load) = **360 Watts**.
- **Energy Reduction** — **74% power reduction** compared to unconsolidated baseline.
- **Dynamic Power Mgmt (DPM)**
- **Automated Cluster Optimization** — Live migration shifts VMs dynamically based on load
- **Power Usage** — Off-peak: 1 host @ 70% load = 200W. Unneeded hosts placed into deep ACPI sleep.
- **Energy Reduction** — **Up to 85% off-peak savings** while fully maintaining SLA guarantees.
- **⚡ Interactive: Server Consolidation Power Calculator**
- **Adjust the consolidation parameters below to calculate direct electrical savings and CO₂ reductions.**
- Original Physical Servers — **50**
- Consolidation Ratio (VMs/Host) — **10:1**
- Idle Power / Host (W) — **130 W**
- **New Physical Hosts Needed** — 5 — 45 physical servers decommissioned
- Power Saved: 82%
- 0% Saved90% Saved
- Est. Energy Saved: ~51,246 kWh/yr

## Live Migration & Dynamic Resource Management
*Advanced Applied · 10 min*
vMotion, DRS, and automated host power-down (DPM)

- Virtualization is not static. Technologies like **Live Migration** (e.g., VMware vMotion, KVM Live Migration) move running VMs between physical hosts with zero application downtime, enabling dynamic load balancing and power management.
- 🔄 **Live VM Migration** — Transfers a running VM's memory state, CPU execution context, and network bindings across hosts over dedicated network links without dropping client connections.
- ⚖️ **Dynamic Resource Scheduler (DRS)** — Continuously monitors CPU and RAM demand across a host cluster, migrating VMs to eliminate hot spots and maintain application performance SLAs.
- 🌙 **Distributed Power Management (DPM)** — When cluster demand drops (e.g., nighttime), DPM consolidates VMs onto a minimal subset of hosts and uses IPMI/iLO to place idle hosts into deep standby (S5/Wake-on-LAN). When demand spikes, hosts wake up automatically.

> **⚠️ The Live Migration Energy Trade-off**
> Live migration consumes network bandwidth and temporary CPU overhead on both source and destination hosts during state transfer. Migrating VMs *too frequently* can create an overall energy net-loss. DRS/DPM algorithms must enforce threshold hysteresis before triggering migrations.

## Math practice — virtualization & energy calculations
*Practice · 10 min*
Solve quick numerical problems covering consolidation ratios, power curves, and host reductions

- Work through these five practical calculations on paper first, then tap any card to reveal the step-by-step solution.
- **1** — An enterprise has **80 physical servers** drawing an average of **150W** each. After virtualization, these workloads run on **8 hosts** drawing **250W** each. What is the total power saved in kW?
- P_orig = 80 × 150W = 12,000W
P_new = 8 × 250W = 2,000W — Saved = 10,000 W = 10 kW — This represents an 83.3% direct electrical reduction, before even factoring in associated cooling energy savings.
- **2** — A server has a maximum load power of **300W** and an idle power of **180W** (60% of max). If CPU load rises linearly with power, what is its power draw at **70% CPU load**?
- P = P_idle + Load% × (P_max − P_idle) — 180 + 0.70 × (300 − 180) = 264 W — Dynamic power range is only 120W; 180W is drawn continuously regardless of utilization.
- **3** — A data center consolidates **120 physical workloads** into a cluster with a consolidation ratio of **12:1**. How many physical hosts are needed, and how many servers are decommissioned?
- Hosts = Total VMs ÷ Ratio; Decom = Total − Hosts — Hosts = 120 ÷ 12 = 10 hosts
Decommissioned = 110 servers — Consolidating 110 physical units drastically lowers floor space requirements, switch port consumption, and maintenance costs.
- **4** — Decommissioning 20 idle servers saves **3 kW** of IT power continuous load. With a data center **PUE of 1.5**, what is the total facility power reduction (including cooling)?
- Facility Power = IT Power × PUE — 3 kW × 1.5 = 4.5 kW — Every watt eliminated at the IT layer saves an additional 0.5W in facility cooling and power distribution losses.
- **5** — A virtualized cluster saves **15 kW** of continuous power. Over a full year (8,760 hours), how many **kWh** of electrical energy are saved?
- Energy (kWh) = Power (kW) × Time (hours) — 15 kW × 8,760 h = 131,400 kWh — At $0.10 per kWh, this simple consolidation initiative generates $13,140 in annual direct utility bill savings.

## Virtualization adoptability in Bangladesh
*Local Context · 10 min*
Financial sector mandates, legacy applications, and UPS runtime extensions

- In Bangladesh, virtualization serves a dual purpose: besides cutting long-term operational costs, it directly mitigates local infrastructure challenges such as generator fuel expenses and UPS battery wear.
- **🔋 Prolonging UPS runtime** — During grid load-shedding, server load reduction translates into extended UPS battery autonomy. Halving IT power consumption through VM consolidation effectively doubles the backup runtime available on battery banks.
- **🏦 Bank compliance & private cloud** — Bangladesh Bank regulatory circulars require strict isolation and high availability for core banking software (CBS). Hypervisor HA clusters allow local financial institutions to achieve compliance without duplicate hardware sprawl.
- **Dhaka Data Center Scenario** — A local enterprise in Motijheel suffers frequent 30-minute power cuts. Their UPS battery bank is degrading. How does virtualization help immediate emergency survival?
- Answer — By consolidating workloads onto 30% of the host fleet, overall rack draw drops significantly. Lower discharge rate extends UPS runtime during load-shedding, allowing diesel generators sufficient time to stabilize without dropping loads.
- **Legacy Application Scenario** — A government ministry relies on an old 32-bit legacy tax accounting software that cannot run on modern 64-bit server hardware directly. How does virtualization resolve this sustainably?
- Answer — Virtualization encapsulates the legacy 32-bit OS inside a Virtual Machine. This allows the ancient application to run safely on efficient, modern high-density hardware, eliminating the need to maintain power-hungry legacy physical servers.

## Class quiz — virtualization & green IT
*Assessment · 10 min*
6 questions testing concepts from today's lecture

## Summary & Class 13 preview
*Wrap-up · 5 min*
Key takeaways and upcoming topics

- 🧩 **Hardware Abstraction** — Virtualization breaks the "1 App = 1 Server" constraint, directly addressing low physical CPU utilization.
- ⚡ **Bare-Metal Efficiency** — Type 1 hypervisors run directly on hardware, avoiding host OS overhead and enabling maximum compute yield per watt.
- 📉 **Idle Power Elimination** — Idle servers draw 50–70% base power. Consolidation collapses workloads so unnecessary hosts can be powered down.
- 📦 **Dynamic Migration** — Technologies like vMotion/DRS/DPM continuously optimize VM placement and automate standby states off-peak.
- 🧮 **Multiplied Savings** — Every IT watt saved via server reduction multiplies overall facility savings when factored through the site PUE.
- 🇧🇩 **UPS Autonomy** — Consolidating loads drastically improves emergency battery backup times during local grid load-shedding events.

> **📚 Next Class — Class 13**
> Data Center Storage & Network Energy Efficiency. We will analyze storage tiering, thin provisioning, deduplication, and Energy Efficient Ethernet (EEE) standards to optimize non-compute data center infrastructure.

## Class Quiz

**Q1. Why does running a non-virtualized physical server at 10% CPU utilization result in extremely poor energy efficiency?**
*Context: Recall the server power-to-load curve profile.*
▫️ A. Modern CPU chips consume zero power when idle
✅ B. An idle physical server still draws 50% to 70% of its maximum power draw just maintaining baseline hardware states
▫️ C. Physical servers draw maximum power regardless of CPU load
▫️ D. Low utilization damages server power supplies
> **Explanation:** Servers exhibit significant idle power overhead. A server drawing 200W at 100% load often draws 120W–140W at 0% load. Operating at 10% utilization wastes the vast majority of consumed power on baseline overhead.

**Q2. What is the primary operational advantage of a Type 1 (Bare-Metal) hypervisor over a Type 2 (Hosted) hypervisor in green data center design?**
▫️ A. Type 1 hypervisors are free open-source software
✅ B. Type 1 hypervisors run directly on hardware without a host OS layer, reducing CPU overhead and maximizing power efficiency
▫️ C. Type 2 hypervisors require specialized liquid cooling systems
▫️ D. Type 1 hypervisors only work with ARM processors
> **Explanation:** Type 1 hypervisors bypass host operating system kernel layers. This eliminates host OS CPU overhead, reduces memory footprint, and grants the hypervisor direct control over hardware CPU low-power state management.

**Q3. An enterprise consolidates 60 legacy physical servers (drawing 150W each) onto 6 virtualized host servers (drawing 300W each). What is the total reduction in IT power draw?**
*Context: Calculate baseline total power versus consolidated total power.*
▫️ A. 1,800 W
▫️ B. 3,600 W
✅ C. 7,200 W
▫️ D. 9,000 W
> **Explanation:** Original Power = 60 × 150W = 9,000W. New Power = 6 × 300W = 1,800W. Total Power Saved = 9,000W − 1,800W = 7,200 Watts (7.2 kW).

**Q4. What role does Distributed Power Management (DPM) play in a virtualized host cluster?**
▫️ A. It increases voltage supplied to active processors during peak business hours
✅ B. It automatically live-migrates VMs to consolidate loads off-peak and shuts down/sleeps unneeded physical hosts
▫️ C. It permanently locks all CPU clock speeds at 50% capacity
▫️ D. It manages diesel generator fuel consumption during power outages
> **Explanation:** DPM extends dynamic resource scheduling. When aggregate cluster load drops off-peak, DPM moves VMs onto fewer hosts and automatically places unused physical servers into low-power sleep modes to eliminate idle power.

**Q5. Why must dynamic VM live migration algorithms incorporate threshold hysteresis before triggering VM moves between hosts?**
✅ A. Live migration consumes network bandwidth and CPU cycles; migrating too frequently creates a net energy loss
▫️ B. Hypervisors limit live migrations to once per day maximum
▫️ C. Live migration corrupts virtual hard disks if executed repeatedly
▫️ D. Migrating VMs changes physical IP addresses across hosts
> **Explanation:** Transferring a VM's memory state over the network taxes CPU and network infrastructure. If threshold parameters flutter, excessive migration overhead negates the target consolidation energy savings.

**Q6. In Bangladesh, how does server consolidation directly benefit data center operations during local utility grid load-shedding?**
▫️ A. It eliminates the need for emergency backup diesel generators completely
✅ B. By reducing total IT power draw, it extends the operational battery backup runtime of UPS systems
▫️ C. It allows servers to run on solar energy without inverter conversions
▫️ D. It automatically increases grid AC voltage during blackouts
> **Explanation:** UPS battery banks discharge based on total electrical load. Lowering the continuous wattage draw via server consolidation significantly extends battery backup duration during load-shedding intervals.

## Sidebar Reference Notes

### Book References
- **Velete — Green IT**
Chapter 12: Virtualization — **Lamb — The Greening of IT**
Chapter 6: Consolidation

### Quick Reference
- • Idle Power: ~50-70% of Max — • Type 1: Bare-Metal (ESXi, KVM) — • Type 2: Hosted (VirtualBox) — • Consolidation Target: ~70-80% CPU

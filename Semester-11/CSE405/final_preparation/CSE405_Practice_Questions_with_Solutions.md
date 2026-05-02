# CSE405 / ICE302 — Computer Networks
# Practice Question Bank with Full Solutions
### East West University | Instructor Pattern: Md. Khalid Mahbub Khan

---

## EXAM PATTERN SUMMARY

| Feature | Detail |
|---------|--------|
| Total Questions | 5 (ALL compulsory) |
| Marks | 30 total, 6 per question |
| Time | 1 Hour |
| Split marks | 3+3 / 2+2+2 / 2+4 |
| Style | Always scenario-based with specific IPs, MACs, and network figures |
| Action verbs | **Illustrate, Apply, Construct, Explain, Show, Solve** |
| Cognitive Level | C2 (Understand) + C3 (Apply/Analyze) |

---

# PART A: FULL EXAM-STYLE PRACTICE SETS

---

## PRACTICE EXAM SET 1
### (30 Marks | 1 Hour | Answer ALL Questions)

---

### Q1. [CO2, C3 | Mark: 6]

Fig. 1 shows a network where four hosts are connected through a hub. The network details are:

| Host | IP Address | MAC Address |
|------|-----------|-------------|
| A | 137.196.7.88 | 0C:C4:11:6F:E3:98 |
| B | 137.196.7.14 | 58:23:D7:FA:20:B0 |
| C | 137.196.7.78 | 1A:2F:BB:76:09:AD |
| D | 137.196.7.23 | 71:65:F7:2B:08:53 |

Host C wants to find the MAC address of Host A. Host B only knows its physical address and wants to discover its own IP address.

a) **Apply** the ARP protocol to show how Host C discovers Host A's MAC address. Show all ARP packet fields for both the request and reply. [3]
b) **Apply** the RARP protocol to show how Host B discovers its IP address. Explain the packet format difference from ARP and show the request and reply process. [3]

---

### Q1 — SOLUTION

#### Part a) ARP Process — Host C finds Host A's MAC

**Step 1: ARP Request (BROADCAST)**

Host C does not know Host A's MAC → it broadcasts an ARP request to ALL hosts.
Ethernet frame destination: `FF:FF:FF:FF:FF:FF` (broadcast)

```
ARP REQUEST PACKET FIELDS:
┌──────────────────────────────────────────────────────┐
│ Hardware Type:       0x0001 (Ethernet)               │
│ Protocol Type:       0x0800 (IPv4)                   │
│ Hardware Length:     6 bytes                         │
│ Protocol Length:     4 bytes                         │
│ Operation:           1 (REQUEST)                     │
│ Sender HW Address:   1A:2F:BB:76:09:AD  ← Host C   │
│ Sender Protocol Addr: 137.196.7.78      ← Host C   │
│ Target HW Address:   00:00:00:00:00:00  ← UNKNOWN  │
│ Target Protocol Addr: 137.196.7.88      ← Host A   │
└──────────────────────────────────────────────────────┘
```

→ All hosts receive this request.
→ Host B and D check: "Is 137.196.7.88 my IP?" → **No** → They discard it.
→ Host A checks: "Is 137.196.7.88 my IP?" → **YES** → Host A responds.

**Step 2: ARP Reply (UNICAST)**

Host A sends a unicast reply **directly to Host C only**.

```
ARP REPLY PACKET FIELDS:
┌──────────────────────────────────────────────────────┐
│ Hardware Type:       0x0001 (Ethernet)               │
│ Protocol Type:       0x0800 (IPv4)                   │
│ Hardware Length:     6 bytes                         │
│ Protocol Length:     4 bytes                         │
│ Operation:           2 (REPLY)                       │
│ Sender HW Address:   0C:C4:11:6F:E3:98  ← Host A   │  ← THE ANSWER
│ Sender Protocol Addr: 137.196.7.88      ← Host A   │
│ Target HW Address:   1A:2F:BB:76:09:AD  ← Host C   │
│ Target Protocol Addr: 137.196.7.78      ← Host C   │
└──────────────────────────────────────────────────────┘
```

→ Host C receives reply → caches: `137.196.7.88 → 0C:C4:11:6F:E3:98` (State: RESOLVED)

> **KEY RULE: ARP Request = BROADCAST | ARP Reply = UNICAST**

---

#### Part b) RARP Process — Host B finds its own IP

RARP is the REVERSE of ARP. The host knows its own MAC but NOT its IP.

**Step 1: RARP Request (BROADCAST)**

Host B broadcasts: *"My MAC is 58:23:D7:FA:20:B0. What is my IP address?"*

```
RARP REQUEST PACKET FIELDS:
┌──────────────────────────────────────────────────────┐
│ Operation:           3 (RARP REQUEST)                │
│ Sender HW Address:   58:23:D7:FA:20:B0  ← Host B   │
│ Sender Protocol Addr: 00:00:00:00       ← UNKNOWN  │
│ Target HW Address:   58:23:D7:FA:20:B0  ← same     │ ← asking for SELF
│ Target Protocol Addr: 00:00:00:00       ← UNKNOWN  │ ← this is what we want
└──────────────────────────────────────────────────────┘
```

→ Broadcast to all, only the **RARP Server** responds.

**Step 2: RARP Reply (UNICAST)**

RARP Server looks up: `58:23:D7:FA:20:B0 → 137.196.7.14` and sends unicast reply.

```
RARP REPLY PACKET FIELDS:
┌──────────────────────────────────────────────────────┐
│ Operation:           4 (RARP REPLY)                  │
│ Target HW Address:   58:23:D7:FA:20:B0  ← Host B   │
│ Target Protocol Addr: 137.196.7.14      ← THE ANSWER│
└──────────────────────────────────────────────────────┘
```

**Key Differences — ARP vs RARP:**

| Feature | ARP | RARP |
|---------|-----|------|
| Known input | IP address | MAC address |
| Desired output | MAC address | IP address |
| Operation codes | Request=1, Reply=2 | Request=3, Reply=4 |
| Unknown field in request | Target HW address | Sender & Target protocol addr |
| Requires special server | No | **Yes — RARP Server** |
| Ethernet type field | 0x0806 | 0x8035 |

> **KEY RULE: RARP Request = BROADCAST | RARP Reply = UNICAST**

---

### Q2. [CO2, C3 | Mark: 6]

Fig. 2 shows a network with six nodes. Connections and costs are:
**A-B: 2, A-D: 4, B-C: 3, B-D: 1, C-E: 2, C-F: 5, D-E: 3, E-F: 1**

```
        B ---3--- C
       /|\        |\
      2 1 \       2 5
     /  |  \      |  \
    A   |   +--   |   F
     \  |       \ |  /
      4 |        \| 1
       \|         E
        D ---3----+
```

a) **Construct** the link-state routing table (neighbor information table) for nodes **A**, **B**, and **D**. [2]
b) **Apply** Dijkstra's algorithm from node **A** to find the shortest path to **ALL other nodes**. Show the complete step-by-step priority table. Identify the shortest path from **A to F**. [4]

---

### Q2 — SOLUTION

#### Part a) Link-State Routing Tables

In Link-State routing, each node only stores its **directly connected neighbors** and their costs. This information is flooded to all nodes so the entire topology is known.

**Node A's Link-State Table:**
| Neighbor | Link Cost |
|----------|-----------|
| B | 2 |
| D | 4 |

**Node B's Link-State Table:**
| Neighbor | Link Cost |
|----------|-----------|
| A | 2 |
| C | 3 |
| D | 1 |

**Node D's Link-State Table:**
| Neighbor | Link Cost |
|----------|-----------|
| A | 4 |
| B | 1 |
| E | 3 |

> Each node broadcasts its link-state table (with a sequence number and TTL) to ALL nodes in the network. After flooding, every node has a complete map of the network and runs Dijkstra independently.

---

#### Part b) Dijkstra's Algorithm from Node A

**Network edges:** A-B=2, A-D=4, B-C=3, B-D=1, C-E=2, C-F=5, D-E=3, E-F=1

**Dijkstra Table (D = distance from A, NH = Next Hop):**

| Step | Node Visited | A | B | C | D | E | F | Priority Queue |
|------|-------------|---|---|---|---|---|---|----------------|
| Init | — | **0** | ∞ | ∞ | ∞ | ∞ | ∞ | {A:0} |
| 1 | **A** (0) | 0 | 2(A) | ∞ | 4(A) | ∞ | ∞ | {B:2, D:4} |
| 2 | **B** (2) | 0 | 2 | 5(B) | **3(B)** ↓ | ∞ | ∞ | {D:3, C:5} |
| 3 | **D** (3) | 0 | 2 | 5 | 3 | 6(D) | ∞ | {C:5, E:6} |
| 4 | **C** (5) | 0 | 2 | 5 | 3 | 6 | 10(C) | {E:6, F:10} |
| 5 | **E** (6) | 0 | 2 | 5 | 3 | 6 | **7(E)** ↓ | {F:7} |
| 6 | **F** (7) | 0 | 2 | 5 | 3 | 6 | 7 | Done ✓ |

**Step-by-Step Explanation:**

**Step 1 — Visit A (cost=0):**
- Neighbor B: 0+2 = **2** ✓
- Neighbor D: 0+4 = **4** ✓

**Step 2 — Visit B (cost=2, minimum in queue):**
- Neighbor C: 2+3 = **5** ✓
- Neighbor D: min(4, 2+1) = min(4, **3**) = **3** ← Updated via B!

**Step 3 — Visit D (cost=3, minimum):**
- Neighbor E: 3+3 = **6** ✓

**Step 4 — Visit C (cost=5, minimum):**
- Neighbor E: min(6, 5+2) = min(6,7) = 6 → no change
- Neighbor F: 5+5 = **10** ✓

**Step 5 — Visit E (cost=6, minimum):**
- Neighbor F: min(10, 6+1) = **7** ← Updated via E!

**Step 6 — Visit F (cost=7):** Algorithm complete ✓

**Final Shortest Path Results from A:**

| Destination | Shortest Distance | Path |
|-------------|------------------|------|
| A | 0 | A |
| B | 2 | A → B |
| D | 3 | A → B → D |
| C | 5 | A → B → C |
| E | 6 | A → B → D → E |
| **F** | **7** | **A → B → D → E → F** |

> **Shortest path A to F = 7 via A→B→D→E→F**
> Verification: 2 + 1 + 3 + 1 = **7** ✓

---

### Q3. [CO2, C2 | Mark: 6]

Host A (IP: 192.168.1.2) wants to establish a TCP connection with Server B (IP: 203.0.113.1). Host A uses initial sequence number **seq=8000**. Server B uses initial sequence number **seq=15000**. After the connection is established, Host A sends 2000 bytes of data in two segments.

a) **Show** the complete three-way handshaking process for connection establishment. Include all segment details (flags, seq, ack numbers). [3]
b) **Illustrate** the connection termination (three-way handshaking) initiated by Host A. Explain which segments consume sequence numbers and why. [3]

---

### Q3 — SOLUTION

#### Part a) Connection Establishment

```
Host A (192.168.1.2)                        Server B (203.0.113.1)
         |                                          |
  Active |  ── Segment 1: SYN ──────────────────► | Passive
   Open  |  seq=8000, SYN=1, ACK=0                |  Open
         |  [No data, but consumes 1 seq#]         |
         |                                          |
         |  ◄─── Segment 2: SYN+ACK ──────────── |
         |  seq=15000, ack=8001                    |
         |  SYN=1, ACK=1                           |
         |  [Consumes 1 seq# for B's SYN]         |
         |                                          |
         |  ── Segment 3: ACK ──────────────────► |
         |  seq=8001, ack=15001                   | Connection
         |  SYN=0, ACK=1                           | Established ✓
         |  [No data, consumes NO seq#]            |
```

**Segment-by-Segment Explanation:**

| Segment | From | Flags | seq | ack | Seq# consumed? |
|---------|------|-------|-----|-----|----------------|
| 1 SYN | A→B | SYN=1, ACK=0 | 8000 | — | **YES (+1)** → next A seq = 8001 |
| 2 SYN+ACK | B→A | SYN=1, ACK=1 | 15000 | **8001** | **YES (+1)** → next B seq = 15001 |
| 3 ACK | A→B | SYN=0, ACK=1 | 8001 | **15001** | **NO** (pure ACK, no data) |

> **ack=8001** means: "I received up to byte 8000, I expect byte 8001 next."
> **ack=15001** means: "I received up to byte 15000, I expect byte 15001 next."

**Rules:**
- A SYN segment carries no real data, but **consumes 1 sequence number** (treated as 1 imaginary byte).
- A SYN+ACK segment **also consumes 1 sequence number**.
- A pure ACK (no data) consumes **0 sequence numbers**.

---

#### Part b) Connection Termination

Assume after data transfer: Host A's next seq = **x**, Server B's next seq = **y**

```
Host A                                       Server B
  |                                              |
  |  ── Segment 1: FIN ────────────────────► |
  |  seq=x, ack=y, FIN=1, ACK=1             |
  |  [FIN consumes 1 seq# if no data]        |
  |                                            |
  |  ◄─── Segment 2: FIN+ACK ────────────── |
  |  seq=y, ack=x+1, FIN=1, ACK=1          |
  |  [FIN+ACK consumes 1 seq#]              |
  |                                            |
  |  ── Segment 3: ACK ────────────────────► | Connection
  |  seq=x, ack=y+1, ACK=1                 | Terminated ✓
  |  [Pure ACK — consumes NO seq#]          |
```

**Sequence Number Summary for Termination:**

| Segment | Type | Seq# Consumed | Explanation |
|---------|------|--------------|-------------|
| FIN | Close request | **YES, +1** | Acts as 1 imaginary byte |
| FIN+ACK | Acknowledge + close other direction | **YES, +1** | Also 1 imaginary byte |
| ACK | Final acknowledgment | **NO** | Pure ACK carries no data |

> **ack=x+1 in Segment 2** means Server received Host A's FIN (seq=x) and expects x+1.
> **ack=y+1 in Segment 3** means Host A received Server's FIN (seq=y) and expects y+1.

---

### Q4. [CO2, C3 | Mark: 6]

A network has four nodes: A, B, C, D. Direct link costs are:
**A-B: 3, A-C: 1, B-D: 2, C-B: 1, C-D: 5**

```
A ---3--- B ---2--- D
|         ^         |
1         1         5
|         |         |
C---------+---------+
```

a) **Construct** the initial distance vector routing tables for ALL four nodes. [3]
b) Node A receives a distance vector update from Node C. **Show** the step-by-step update process and construct A's new routing table with next hops. [3]

---

### Q4 — SOLUTION

#### Part a) Initial Distance Vector Tables

Each node initializes its table with **only directly connected neighbors**. All unknown destinations = ∞.

**Node A's Initial Table:**
| To | Cost | Next Hop |
|----|------|----------|
| A | 0 | — |
| B | 3 | B (direct) |
| C | 1 | C (direct) |
| D | ∞ | — (unknown) |

**Node B's Initial Table:**
| To | Cost | Next Hop |
|----|------|----------|
| A | 3 | A (direct) |
| B | 0 | — |
| C | 1 | C (direct) |
| D | 2 | D (direct) |

**Node C's Initial Table:**
| To | Cost | Next Hop |
|----|------|----------|
| A | 1 | A (direct) |
| B | 1 | B (direct) |
| C | 0 | — |
| D | 5 | D (direct) |

**Node D's Initial Table:**
| To | Cost | Next Hop |
|----|------|----------|
| A | ∞ | — (unknown) |
| B | 2 | B (direct) |
| C | 5 | C (direct) |
| D | 0 | — |

---

#### Part b) A Receives Update from C → Updates Table

**Step 1: C sends its current distance vector to A:**
`C's vector: {A:1, B:1, C:0, D:5}`

**Step 2: A modifies C's vector by adding the cost of the A→C link (cost=1):**

| Dest | C's cost | + A-C link cost (1) | Modified cost | Route via C |
|------|----------|---------------------|---------------|-------------|
| A | 1 | +1 | 2 | via C |
| B | 1 | +1 | **2** | via C |
| C | 0 | +1 | 1 | via C |
| D | 5 | +1 | **6** | via C |

**Step 3: A compares modified values with its OLD table (take the minimum):**

| To | A's Old Cost | New (via C) | min() | New Cost | New Next Hop | Updated? |
|----|-------------|-------------|-------|----------|--------------|---------|
| A | 0 | 2 | 0 | **0** | — | No |
| B | 3 | **2** | 2 | **2** | **C** | ✅ YES |
| C | 1 | 1 | 1 | **1** | — | No |
| D | ∞ | **6** | 6 | **6** | **C** | ✅ YES |

**Node A's Updated Routing Table:**

| To | Cost | Next Hop | Change |
|----|------|----------|--------|
| A | 0 | — | — |
| **B** | **2** | **C** | ← Updated (was 3 direct, now 2 via C→B) |
| C | 1 | — | — |
| **D** | **6** | **C** | ← Updated (was ∞, now 6 via C→D) |

**Explanation:**
- A→B via C costs: A→C (1) + C→B (1) = **2** → better than direct A→B = 3 ✓
- A→D via C costs: A→C (1) + C→D (5) = **6** → new path discovered ✓

> Note: A→D via C→B→D = 1+1+2=4 is even shorter, but A doesn't know this yet — it only received C's old table. This will be discovered in the next round of updates.

---

### Q5. [CO2, C3 | Mark: 6]

Fig. 4 shows a network where data flows from Source → Node I → Node II → Node III → Node IV → Destination. Congestion has occurred at **Node III**.

**Apply** the following congestion control mechanisms for this network:

a) **Backpressure** — Explain how the signal propagates and what each node does. [2]
b) **Choke Packet** — Explain how it works and contrast it with Backpressure. [2]
c) **TCP Slow Start** — If cwnd starts at 1 MSS and ssthresh = 8 MSS, show cwnd values for rounds 1–6 and explain what happens when cwnd reaches ssthresh. [2]

---

### Q5 — SOLUTION

#### Part a) Backpressure

Backpressure is a **node-to-node** congestion control where a congested node tells its **immediate upstream neighbor** to slow down.

```
Data flow direction: ──────────────────────────────────────►
Source ──► Node I ──► Node II ──► Node III ──► Node IV ──► Destination
                                  [CONGESTED]

STEP 1: Node III congested → tells Node II to SLOW DOWN
◄── [Backpressure: III notifies II]

Source ──► Node I ──► Node II ──slow──► Node III ──► Node IV ──► Destination

STEP 2: Node II slows → may become congested → tells Node I to SLOW DOWN
◄── [Backpressure propagates: II notifies I]

Source ──► Node I ──slow──► Node II ──► Node III ──► Node IV ──► Destination

STEP 3: Node I slows → tells Source to SLOW DOWN
◄── [Backpressure reaches Source]

Source ──slow──► Node I ──► Node II ──► Node III ──► Node IV ──► Destination
```

**Key Points:**
- Signal travels **hop-by-hop backward** (opposite to data flow)
- Intermediate nodes (I and II) are also affected and may become congested
- Works only in **virtual-circuit networks** where each node knows its upstream node
- Slow to reach the source (must propagate node by node)

---

#### Part b) Choke Packet

A Choke Packet is sent **directly from the congested node to the SOURCE**, bypassing all intermediate nodes.

```
Data flow:   Source ──► Node I ──► Node II ──► Node III ──► Node IV ──► Destination
                                               [CONGESTED]
                                                    |
                        CHOKE PACKET               |
                        ◄─────────────────────────── (direct to Source)

Node I and Node II are NOT warned — they continue operating normally.
Source receives choke packet → immediately reduces transmission rate.
```

**What happens step-by-step:**
1. Node III detects congestion (queue filling, dropping packets)
2. Node III generates a **Choke Packet** (a special control message)
3. Choke Packet travels **directly to the Source** (not hop-by-hop)
4. Source receives it → reduces its transmission rate
5. Intermediate nodes I and II are **not involved**

**Backpressure vs Choke Packet:**

| Feature | Backpressure | Choke Packet |
|---------|-------------|--------------|
| Signal travels | Node-by-node BACKWARD | Direct to source |
| Intermediate nodes warned? | YES | NO |
| Speed reaching source | Slow (hop by hop) | Fast (direct) |
| Network type | Virtual-circuit ONLY | Any network |
| Real-world example | X.25 | ICMP Source Quench |

---

#### Part c) TCP Slow Start Algorithm

cwnd starts at **1 MSS**, ssthresh = **8 MSS**.

**Rule:** Below ssthresh → cwnd **doubles** each round (×2, exponential).
At/above ssthresh → cwnd increases by **+1 per round** (additive).

| Round | cwnd (MSS) | Rule Applied | Phase |
|-------|-----------|--------------|-------|
| Start | **1** | Initial | Slow Start |
| Round 1 | **2** | 1 × 2 | Slow Start |
| Round 2 | **4** | 2 × 2 | Slow Start |
| Round 3 | **8** | 4 × 2 = ssthresh ← | Slow Start **STOPS here** |
| Round 4 | **9** | 8 + 1 | Congestion Avoidance |
| Round 5 | **10** | 9 + 1 | Congestion Avoidance |
| Round 6 | **11** | 10 + 1 | Congestion Avoidance |

**What happens at ssthresh (Round 3, cwnd = 8):**
- Exponential growth STOPS
- **Congestion Avoidance (Additive Increase)** begins
- cwnd grows by only **1 MSS per round** instead of doubling
- This linear growth prevents overwhelming the network

**If congestion detected (timeout event at any round):**
- ssthresh is set to **cwnd / 2** (Multiplicative Decrease)
- cwnd **resets to 1 MSS**
- Slow Start begins again from scratch

> **The goal of Slow Start:** Start conservatively, grow quickly to find the network's capacity, then grow carefully to avoid congestion.

---

---

## PRACTICE EXAM SET 2
### (30 Marks | 1 Hour | Answer ALL Questions)

---

### Q1. [CO2, C3 | Mark: 6]

Four hosts are connected through a hub with the following details:
- Host P: IP=10.20.30.5, MAC=AA:BB:11:22:33:44
- Host Q: IP=10.20.30.10, MAC=CC:DD:55:66:77:88
- Host R: IP=10.20.30.15, MAC=EE:FF:99:00:AB:CD
- Host S: IP=10.20.30.20, MAC=12:34:56:78:9A:BC

Host R wants to communicate with Host S but does not know S's MAC address. A new host T (MAC=DE:AD:BE:EF:00:01) just joined the network and only knows its MAC.

a) **Illustrate** the complete ARP process: show the broadcast request and unicast reply. Fill in ALL ARP packet fields for both packets. [3]
b) **Illustrate** the complete RARP process for Host T discovering its IP. Explain the role of the RARP server and why RARP is limited compared to DHCP. [3]

---

### Q1 — SET 2 SOLUTION

#### Part a) ARP: Host R finds Host S's MAC

**ARP REQUEST (Broadcast) from R:**
```
┌─────────────────────────────────────────────────────┐
│ Operation:            1 (REQUEST)                   │
│ Sender HW Address:    EE:FF:99:00:AB:CD  ← Host R  │
│ Sender Protocol Addr: 10.20.30.15        ← Host R  │
│ Target HW Address:    00:00:00:00:00:00  ← BLANK   │
│ Target Protocol Addr: 10.20.30.20        ← Host S  │
│ Ethernet Dest MAC:    FF:FF:FF:FF:FF:FF  BROADCAST  │
└─────────────────────────────────────────────────────┘
```

All hosts receive the broadcast. Only Host S (10.20.30.20) recognizes its own IP and responds.

**ARP REPLY (Unicast) from S:**
```
┌─────────────────────────────────────────────────────┐
│ Operation:            2 (REPLY)                     │
│ Sender HW Address:    12:34:56:78:9A:BC  ← Host S  │  ← ANSWER
│ Sender Protocol Addr: 10.20.30.20        ← Host S  │
│ Target HW Address:    EE:FF:99:00:AB:CD  ← Host R  │
│ Target Protocol Addr: 10.20.30.15        ← Host R  │
│ Ethernet Dest MAC:    EE:FF:99:00:AB:CD  UNICAST    │
└─────────────────────────────────────────────────────┘
```

Result: R caches `10.20.30.20 → 12:34:56:78:9A:BC`

#### Part b) RARP: Host T finds its IP

1. T broadcasts RARP Request: "My MAC = DE:AD:BE:EF:00:01, what is my IP?"
2. RARP Server has a pre-configured table: `DE:AD:BE:EF:00:01 → 10.20.30.25`
3. RARP Server sends unicast reply: "Your IP is 10.20.30.25"
4. T receives reply and configures itself with IP 10.20.30.25

**Why RARP is limited:**
- RARP only provides an IP address — nothing else (no subnet mask, gateway, DNS)
- Requires a RARP server on EVERY physical network (cannot cross routers)
- Static configuration — admin must manually add each MAC to the server's table
- DHCP replaced RARP: DHCP provides IP + subnet mask + gateway + DNS dynamically

---

### Q2. [CO2, C3 | Mark: 6]

A network has nodes A, B, C, D, E, F with costs:
**A-B: 5, A-D: 1, B-C: 2, B-E: 3, C-F: 1, D-B: 3, D-E: 6, E-F: 2**

a) **Construct** the link-state routing table for nodes A, D, and E. [2]
b) **Apply** Dijkstra's algorithm from Node A to find the shortest path to all nodes. Show the step-by-step table. What is the shortest path from A to F? [4]

---

### Q2 — SET 2 SOLUTION

#### Part a) Link-State Tables

**Node A:** {B:5, D:1}
**Node D:** {A:1, B:3, E:6}
**Node E:** {B:3, D:6, F:2}

#### Part b) Dijkstra from A

Edges: A-B=5, A-D=1, B-C=2, B-E=3, C-F=1, D-B=3, D-E=6, E-F=2

| Step | Visited | A | B | C | D | E | F | Queue |
|------|---------|---|---|---|---|---|---|-------|
| Init | — | **0** | ∞ | ∞ | ∞ | ∞ | ∞ | {A:0} |
| 1 | **A**(0) | 0 | 5(A) | ∞ | 1(A) | ∞ | ∞ | {D:1,B:5} |
| 2 | **D**(1) | 0 | **4(D)**↓ | ∞ | 1 | 7(D) | ∞ | {B:4,E:7} |
| 3 | **B**(4) | 0 | 4 | 6(B) | 1 | **7(B)**=7 | ∞ | {C:6,E:7} |
| 4 | **C**(6) | 0 | 4 | 6 | 1 | 7 | **7(C)** | {E:7,F:7} |
| 5 | **E**(7) | 0 | 4 | 6 | 1 | 7 | **7** (tie) | {F:7} |
| 6 | **F**(7) | 0 | 4 | 6 | 1 | 7 | **7** | Done ✓ |

**Detail of Step 2 (Visit D, cost=1):**
- B: min(5, 1+3) = **4** via D ← updated!
- E: min(∞, 1+6) = **7** via D ✓

**Final Results:**

| Dest | Distance | Shortest Path |
|------|----------|--------------|
| D | 1 | A→D |
| B | 4 | A→D→B |
| C | 6 | A→D→B→C |
| E | 7 | A→D→B→E |
| **F** | **7** | **A→D→B→C→F** |

> Verification: A→D(1)→B(3)→C(2)→F(1) = **7** ✓
> Alternative: A→D(1)→B(3)→E(3)→F(2) = **9** (longer)
> **Shortest: A→D→B→C→F = 7**

---

### Q3. [CO2, C2 | Mark: 6]

Host A (IP: 192.168.1.2) sends a SYN to Host B (IP: 203.0.113.1) to establish a TCP connection. Host B replies with a SYN-ACK, but the **final ACK from Host A is delayed significantly**.

a) **Explain** the mechanism that ensures the connection is eventually established even when the final ACK is delayed. **Show** the proper three-way handshake diagram. [3]
b) **Explain** the SYN Flooding Attack that exploits this mechanism, and describe how the **SYN Cookie** defense works. [3]

---

### Q3 — SET 2 SOLUTION

#### Part a) Delayed ACK Scenario

```
Host A (192.168.1.2)                   Server B (203.0.113.1)
  |                                          |
  |  ── SYN ──────────────────────────────► |
  |  seq=1000, SYN=1                        |
  |                                          |
  |  ◄─── SYN+ACK ──────────────────────── |
  |  seq=5000, ack=1001, SYN=1, ACK=1      |
  |                                          |
  |                    [ACK IS DELAYED]      |
  |  ....  (Server waits with timer) ....   |
  |                                          |
  |  ── ACK (arrives late) ───────────────► | Connection
  |  seq=1001, ack=5001, ACK=1             | Established ✓
```

**How TCP handles delayed ACK:**
1. Server B starts a **retransmission timer** after sending SYN+ACK
2. If ACK doesn't arrive within the timeout period, Server B **retransmits** SYN+ACK
3. Eventually when Host A's ACK arrives (even if delayed), the connection is established
4. Once ACK received, timer is cancelled — connection is confirmed
5. The connection state machine moves from **SYN-RECEIVED → ESTABLISHED** upon receiving ACK

#### Part b) SYN Flooding Attack & SYN Cookies

**The Attack:**
1. Attacker sends thousands of SYN packets to Server B with **fake/spoofed source IPs**
2. Server B allocates resources and sends SYN+ACK to each fake IP
3. No real ACK ever comes back → **half-open connections** pile up
4. Server B's connection table fills up completely
5. **Legitimate users cannot connect** → Denial of Service (DoS) ✓

**SYN Cookie Defense:**
1. Server B does **NOT allocate resources** when it receives a SYN
2. Instead, Server B encodes all connection info (IPs, ports, timestamp) into a **cryptographic hash** (the "cookie") and puts it in the **sequence number** of SYN+ACK
3. When the **real ACK arrives**, the ACK number contains the cookie+1
4. Server B verifies the cookie → **only then allocates resources**
5. Spoofed SYNs never complete the handshake → **no resources wasted** ✓

> Real clients complete the handshake properly → cookie verified → connection established normally.

---

### Q4. [CO2, C3 | Mark: 6]

A network has 5 nodes A, B, C, D, E. The link costs are:
**A-B: 2, A-C: 8, B-C: 3, B-D: 6, C-D: 1, C-E: 7, D-E: 2**

a) **Construct** the initial distance vector routing tables for ALL five nodes. [3]
b) Node B receives a distance vector update from Node C. **Show** the step-by-step update process and write B's new routing table. Identify which routes changed and what the new next hops are. [3]

---

### Q4 — SET 2 SOLUTION

#### Part a) Initial Distance Vector Tables

**Node A:** {A:0, B:2(B), C:8(C), D:∞, E:∞}
**Node B:** {A:2(A), B:0, C:3(C), D:6(D), E:∞}
**Node C:** {A:8(A), B:3(B), C:0, D:1(D), E:7(E)}
**Node D:** {A:∞, B:6(B), C:1(C), D:0, E:2(E)}
**Node E:** {A:∞, B:∞, C:7(C), D:2(D), E:0}

#### Part b) B receives update from C

**C's distance vector:** {A:8, B:3, C:0, D:1, E:7}

**Step 1 — B adds cost B-C = 3 to each of C's values:**

| Dest | C's value | + B-C (3) | Cost via C |
|------|-----------|-----------|------------|
| A | 8 | +3 | 11 |
| B | 3 | +3 | 6 |
| C | 0 | +3 | 3 |
| D | 1 | +3 | **4** |
| E | 7 | +3 | **10** |

**Step 2 — B compares with its old table:**

| To | B's old cost | Via C cost | min() | New cost | Next hop | Changed? |
|----|-------------|-----------|-------|----------|----------|---------|
| A | 2 | 11 | 2 | **2** | A | No |
| B | 0 | 6 | 0 | **0** | — | No |
| C | 3 | 3 | 3 | **3** | C | No |
| D | 6 | **4** | 4 | **4** | **C** | ✅ YES |
| E | ∞ | **10** | 10 | **10** | **C** | ✅ YES |

**B's Updated Routing Table:**

| To | Cost | Next Hop |
|----|------|----------|
| A | 2 | A |
| B | 0 | — |
| C | 3 | C |
| **D** | **4** | **C** ← Updated! (was 6 direct, now 4 via C) |
| **E** | **10** | **C** ← Updated! (was ∞, now 10 via C→E) |

---

### Q5. [CO2, C3 | Mark: 6]

Fig. 5 shows a network: Source → I → II → III(congested) → IV → Destination.

a) **Apply** and explain the **Implicit Signaling** and **Explicit Signaling (Backward)** congestion control methods for this network. [3]
b) **Explain** the Leaky Bucket algorithm. A host has a committed rate of **3 Mbps**. It sends 10 Mbps for 2 seconds, is silent for 3 seconds, then sends 1 Mbps for 5 seconds. Show the output using the Leaky Bucket. [3]

---

### Q5 — SET 2 SOLUTION

#### Part a) Implicit vs Explicit Signaling

**Implicit Signaling:**
- Node III does NOT send any signal to the source
- The **Source itself detects congestion** by observing symptoms:
  - **Timeout:** Sent a packet but no ACK received → packet likely dropped → congestion assumed
  - **3 Duplicate ACKs:** Receiving 3 identical ACKs → a packet was lost → mild congestion assumed
- Source **reduces its transmission rate** (TCP slow start / fast retransmit)
- No overhead of signaling messages; relies entirely on observation

```
Source → I → II → III(congested) → IV → Destination
  ↑ [notices timeout or dup ACKs and slows down on its own]
  [No signal from III — source guesses congestion]
```

**Explicit Signaling (Backward — toward source):**
- Node III **sets a congestion bit** in packets flowing **backward** (ACKs going toward source)
- Source receives ACK packets with congestion bit SET
- Source recognizes the signal and **reduces transmission rate immediately**

```
Data →   Source → I → II → III → IV → Destination
ACKs ←   Source ← I ← II ← III [sets ECN bit] ← IV ← Destination
          ↑ [Source sees bit, slows down]
```

| Method | Who detects? | Who signals? | How fast? | Example |
|--------|-------------|-------------|----------|---------|
| Implicit | Source | None | Slow | TCP timeout |
| Explicit (backward) | Congested node (III) | III → Source via ACKs | Fast | ECN (Explicit Congestion Notification) |

#### Part b) Leaky Bucket Algorithm

Committed rate = **3 Mbps**. The bucket outputs at a constant 3 Mbps regardless of input rate.

| Time | Input rate | Input total | Output rate | Output total | Overflow? |
|------|-----------|-------------|-------------|-------------|-----------|
| 0–2s | 10 Mbps | 20 Mbits | 3 Mbps | 6 Mbits | **Excess stored in bucket** |
| 2–5s | 0 Mbps | 0 Mbits | 3 Mbps | 9 Mbits | Bucket drains |
| 5–10s | 1 Mbps | 5 Mbits | 1 Mbps | 5 Mbits | Bucket empty, output=input |

**Total input = 25 Mbits over 10 seconds**
**Total output = 20 Mbits over 10 seconds** (3 Mbps × 10s = 30 Mbps max, but limited by input)
**Packets dropped if bucket overflows** (if bucket capacity < 14 Mbits worth of data)

```
Input:   10___10    0___0___0    1___1___1___1___1
Output:   3__3__3   3__3__3      1__1__1__1__1
Bucket:  fills→→   drains→→     empty
          0–2s       2–5s          5–10s
```

> **Key Points:**
> - Leaky bucket forces **constant output rate** (smooths bursty traffic)
> - Excess packets stored in bucket; dropped if bucket is **full**
> - Unlike Token Bucket, it does NOT allow accumulated credit for future bursts

---

---

# PART B: TOPIC-WISE ADDITIONAL PRACTICE QUESTIONS

---

## TOPIC 1: ARP & RARP (3 Additional Questions)

---

### ARP-Q1 [Moderate] — ARP Cache Table Operations

The ARP cache table of a host currently contains the following:

| State | Queue | Attempt | Time-Out | Protocol Addr | Hardware Addr |
|-------|-------|---------|----------|--------------|--------------|
| R | 5 | — | 450 | 114.5.7.89 | 457342ACAE32 |
| P | 2 | 2 | — | 129.34.4.8 | — |
| P | 14 | 5 | — | 201.11.56.7 | — |
| R | 9 | — | 60 | 19.1.7.82 | 4573E3242ACA |
| F | — | — | — | — | — |

**Questions:**
a) The output module receives a datagram for IP **114.5.7.89**. What happens? [1]
b) The output module receives a datagram for IP **200.50.3.1** which is NOT in the table. What happens? Show the updated table. [2]
c) 60 seconds later, the cache-control module runs. What changes occur? Show the updated table. [3]

**Solution:**

**a) IP 114.5.7.89 (State = R / RESOLVED):**
- Cache HIT! Hardware address = 457342ACAE32
- Output module extracts the MAC address directly
- Sends the IP datagram to the data link layer with MAC 457342ACAE32
- Time-out countdown continues (no reset needed yet)
- **No ARP request needed** ✓

**b) IP 200.50.3.1 (NOT in table):**
1. Cache MISS → ARP request must be sent
2. Find a FREE (F) slot in the table → use the existing FREE entry
3. New entry added: State=P, Attempt=1, Protocol Addr=200.50.3.1
4. New queue created for this destination, datagram enqueued
5. ARP broadcast request sent for IP 200.50.3.1

Updated table (new row replaces FREE slot):

| State | Queue | Attempt | Time-Out | Protocol Addr | Hardware Addr |
|-------|-------|---------|----------|--------------|--------------|
| R | 5 | — | 450 | 114.5.7.89 | 457342ACAE32 |
| P | 2 | 2 | — | 129.34.4.8 | — |
| P | 14 | 5 | — | 201.11.56.7 | — |
| R | 9 | — | 60 | 19.1.7.82 | 4573E3242ACA |
| **P** | **20** | **1** | — | **200.50.3.1** | — |

**c) After 60 seconds (cache-control updates):**
- **RESOLVED entries:** Time-out decremented by 60
  - 114.5.7.89: 450-60 = 390 (still RESOLVED)
  - 19.1.7.82: 60-60 = **0** → State becomes **FREE** (entry deleted!)
- **PENDING entries:** Attempt count incremented (another ARP sent)
  - 129.34.4.8: Attempt 2→3
  - 201.11.56.7: Attempt 5→6 (if max attempts exceeded → state→FREE, queued packets dropped)
  - 200.50.3.1: Attempt 1→2

Updated table after 60 seconds:

| State | Queue | Attempt | Time-Out | Protocol Addr | Hardware Addr |
|-------|-------|---------|----------|--------------|--------------|
| R | 5 | — | **390** | 114.5.7.89 | 457342ACAE32 |
| P | 2 | **3** | — | 129.34.4.8 | — |
| P | 14 | **6** | — | 201.11.56.7 | — |
| **F** | — | — | — | ~~19.1.7.82~~ | — |
| P | 20 | **2** | — | 200.50.3.1 | — |

---

### ARP-Q2 [Hard] — Proxy ARP

A company's main network (Network A) has hosts communicating normally. The IT team adds a new subnetwork (Network B) with hosts having IPs 192.168.1.20, 192.168.1.21, 192.168.1.22. A Proxy ARP router sits between the two networks.

Host M (on Network A, IP=192.168.1.5) sends an ARP request for IP 192.168.1.21 (on Network B).

**Explain** the complete Proxy ARP process step by step. Why does Host M believe it is communicating directly with 192.168.1.21?

**Solution:**

**Step 1:** Host M broadcasts ARP request on Network A:
- "Who has 192.168.1.21? Tell 192.168.1.5"

**Step 2:** The Proxy ARP router receives this request.
- The router checks its routing table
- It knows 192.168.1.21 is on its connected Network B
- The router decides to **respond on behalf of** 192.168.1.21

**Step 3:** Proxy ARP router sends ARP REPLY to Host M:
- "192.168.1.21 is at [Router's OWN MAC address]"
- The router uses its OWN MAC address in the reply, NOT 192.168.1.21's MAC

**Step 4:** Host M receives the reply:
- Host M caches: `192.168.1.21 → [Router's MAC]`
- Host M sends all packets for 192.168.1.21 to the router (using router's MAC)

**Step 5:** Router forwards packets:
- Router receives packet addressed to 192.168.1.21
- Router forwards it to the actual host 192.168.1.21 on Network B

**Why Host M doesn't realize a router is involved:**
- The ARP reply looked completely normal — standard ARP reply format
- Host M cached `192.168.1.21 → [MAC]` just like any normal ARP
- The router transparently handles all forwarding — Host M is unaware
- This is the definition of a **transparent (proxy) service**

---

### ARP-Q3 [Easy-Moderate] — ARP Packet Encapsulation

An ARP request packet is created and encapsulated in an Ethernet frame. The sending host has:
- MAC: B2:34:55:10:22:10
- IP: 130.23.43.20

Looking for IP: 130.23.43.25

**Show** the complete Ethernet frame with ARP data. What is the Ethernet type field value? Why is the destination MAC in the Ethernet frame different from the Target HW Address in the ARP packet?

**Solution:**

```
ETHERNET FRAME:
┌─────────────┬──────────────────┬──────────────────┬──────────┬───────────────────┬──────┐
│ Preamble+SFD│ Dest MAC         │ Source MAC       │ Type     │ DATA (ARP packet) │ CRC  │
│ 8 bytes     │ FF:FF:FF:FF:FF:FF│ B2:34:55:10:22:10│ 0x0806   │ 28 bytes          │4bytes│
└─────────────┴──────────────────┴──────────────────┴──────────┴───────────────────┴──────┘
```

```
ARP PACKET (28 bytes, inside DATA field):
┌────────────────────────────────────────────┐
│ Hardware Type:   0x0001                    │
│ Protocol Type:   0x0800                    │
│ Hardware Length: 0x06                      │
│ Protocol Length: 0x04                      │
│ Operation:       0x0001 (REQUEST)          │
│ Sender HW Addr:  B2:34:55:10:22:10        │
│ Sender IP Addr:  0x82172B14 (130.23.43.20)│
│ Target HW Addr:  0x000000000000 (UNKNOWN) │
│ Target IP Addr:  0x82172B19 (130.23.43.25)│
└────────────────────────────────────────────┘
```

**Ethernet Type = 0x0806** → identifies the payload as an ARP packet.

**Why destination MAC in Ethernet ≠ Target HW Address in ARP:**
- **Ethernet destination MAC = FF:FF:FF:FF:FF:FF** (broadcast) — tells the switch/hub to deliver the frame to ALL devices on the network segment
- **Target HW Address in ARP = 00:00:00:00:00:00** — this is the field WITHIN the ARP payload that we're asking about (currently unknown, hence all zeros)
- The Ethernet broadcast is the **delivery mechanism** (how the frame gets to all hosts)
- The ARP Target HW Address is the **question being asked** (we want this field filled in the reply)

---

## TOPIC 2: ROUTING PROTOCOLS (3 Additional Questions)

---

### RIP-Q1 [Moderate] — RIP Message Format & Split Horizon

Router R1 wants to send a RIP update to Router R2. R1's routing table shows:
- 130.10.0.0 — 1 hop — direct
- 130.11.0.0 — 1 hop — direct
- 195.2.4.0 — 2 hops — via R2 ← R1 learned this FROM R2
- 195.2.5.0 — 1 hop — direct

R1 sends this update OUT of interface 130.10.0.2 toward R2.

a) **Explain** the Split Horizon with Poison Reverse strategy. [2]
b) **Show** what R1 sends to R2 (with Split Horizon + Poison Reverse applied). What hop count is sent for 195.2.4.0 and why? [2]
c) What transport protocol does RIP use and on which port? [1]

**Solution:**

**a) Split Horizon with Poison Reverse:**

The basic problem: If R1 learned about network X from R2, and R1 later advertises X back to R2, R2 might think R1 has an independent path to X. If X becomes unreachable, this creates a routing loop (count-to-infinity).

**Split Horizon:** Don't advertise a route back to the neighbor you learned it FROM.

**Poison Reverse:** Instead of NOT advertising it, advertise it with **cost = 16 (infinity)** — actively "poisoning" the route. This is faster convergence than plain split horizon.

**b) RIP Update from R1 to R2 (with Poison Reverse):**

| Network | Actual Hop Count | Sent to R2 | Reason |
|---------|-----------------|-----------|--------|
| 130.10.0.0 | 1 | **1** | R1's direct link — advertise normally |
| 130.11.0.0 | 1 | **1** | R1's direct link — advertise normally |
| 195.2.4.0 | 2 | **16 (∞)** | **POISON!** R1 learned this FROM R2, so send ∞ back to R2 |
| 195.2.5.0 | 1 | **1** | R1's direct link — advertise normally |

For 195.2.4.0: R1 learned it from R2, so sending hop count=2 back to R2 would confuse R2 (R2 might think R1 has a different path). Instead, we send **16 (infinity)** to say "don't use me to reach 195.2.4.0 — I only know it through you."

**c) RIP uses UDP on well-known port 520.**

---

### DVR-Q1 [Hard] — Two-Node Instability (Count-to-Infinity)

Nodes A, B are connected (cost=4). Node X is directly connected to A (cost=2).

Initial state: A's cost to X = 2, B's cost to X = 6 (via A, cost 2+4=6).

**Node X fails.** Show the complete count-to-infinity instability problem step by step. At what value do A and B finally agree X is unreachable? How does Split Horizon solve this?

**Solution:**

**Before failure:** A's cost to X = 2 (direct), B's cost to X = 6 (via A)

**Node X fails. A detects the failure:**
- A sets its cost to X = ∞
- BUT before A can inform B, B sends an update to A claiming X is reachable at cost 6!

**The Loop:**

| Event | A's cost to X | B's cost to X |
|-------|-------------|-------------|
| Before X fails | 2 (direct) | 6 (via A) |
| X fails, A updates | **∞** | 6 (via A — stale/wrong) |
| A receives B's stale update: B says X=6, so A thinks X reachable at 6+4=**10** | **10** (via B) | 6 |
| B receives A's update: A says X=10, so B thinks X=10+4=**14** | 10 | **14** |
| A receives B's update: B says 14, so A thinks 14+4=**18** | **18** | 14 |
| B receives A's: 18+4=**22** | 18 | **22** |
| ... keeps growing ... | ↑ | ↑ |
| Eventually reaches **16** (RIP infinity) | 16 | 16 |

**Both A and B finally agree X is unreachable when cost reaches 16** (RIP's definition of infinity = 16 hops).

**How Split Horizon solves it:**
- B learned about X from A
- When B sends updates back to A, it **does NOT include X** (or reports X=16 with Poison Reverse)
- A receives NO update about X from B → A correctly keeps X = ∞
- B, seeing A reports X=∞, also updates X=∞
- No loop! Both converge to X=∞ immediately ✓

---

### DVR-Q2 [Moderate] — Three-Node Instability

Network: X connects to A (cost=2), A connects to B (cost=4), A connects to C (cost=3), B connects to C (cost=3). Initial costs: A-X=2, B-X=6(via A), C-X=5(via A).

**X fails.** A informs B but the packet to C is lost. Show how three-node instability occurs.

**Solution:**

**Before failure:**
- A→X: 2 (direct)
- B→X: 6 (via A: 4+2)
- C→X: 5 (via A: 3+2)

**X fails. A sends update to BOTH B and C (X=∞). Packet to C is LOST.**
- B receives update: B sets X=∞ ✓ (correct)
- C NEVER receives update: C still thinks X=5 (via A) ← stale!

**Now A gets C's stale update (C says X=5):**
- A thinks: "C knows a path to X! A can reach X via C at cost 3+5=**8**"
- A updates X=8 (via C)

**B gets A's update (A says X=8):**
- B thinks: "A knows a path! Cost = 4+8=**12**"
- B updates X=12

**A gets B's update (B says X=12):**
- But A now also receives C's update again... the loop continues with A using C's outdated info

This instability involves 3 nodes because C's information (never updated) acts as a persistent "false rumor" that keeps circulating through A and B, gradually inflating the cost.

**Resolution:** Eventually costs reach 16 (infinity) or TTL expires on the false information.
**Fix:** Split Horizon + Poison Reverse — C would report X=∞ back to A since C learned about X from A.

---

## TOPIC 3: CONGESTION CONTROL (3 Additional Questions)

---

### CC-Q1 [Easy] — Open Loop Policies

For each scenario below, identify which Open-Loop congestion control policy is being applied and explain why it helps:

a) A router discards low-priority audio data frames rather than high-priority video control frames when its buffer is 80% full.
b) A receiver sends only one ACK for every three packets it receives, rather than acknowledging each one.
c) A TCP sender uses Selective Repeat instead of Go-Back-N.

**Solution:**

**a) Discarding Policy:**
- The router is applying a **selective discarding policy**
- By discarding less-critical data (low-priority audio) while keeping control frames, it prevents the buffer from filling completely
- This prevents congestion before it occurs, while maintaining the integrity of critical transmissions
- For audio streams, dropping occasional frames is acceptable and barely noticeable

**b) Acknowledgment Policy:**
- This is **delayed/selective acknowledgment policy**
- Fewer ACK packets on the network = reduced traffic load
- Each ACK consumes bandwidth and processing; sending fewer ACKs reduces the contribution of acknowledgments to overall network load
- This is a proactive measure that reduces load before congestion starts

**c) Window Policy:**
- Using **Selective Repeat window** instead of Go-Back-N is a window policy decision
- Go-Back-N: if packet 5 is lost and window=10, packets 5-14 are ALL retransmitted → high load
- Selective Repeat: ONLY packet 5 is retransmitted → much less redundant traffic
- Fewer redundant retransmissions = less congestion

---

### CC-Q2 [Moderate] — TCP Congestion Window (Full Scenario)

A TCP sender starts with cwnd = 1 MSS, ssthresh = 16 MSS.

a) Show cwnd values for rounds 1 through 10 (assume no congestion for rounds 1-10). [2]
b) At round 10, a **timeout** occurs (cwnd at that point). Show what happens to ssthresh and cwnd. Then trace cwnd for rounds 11-16. [2]
c) At round 14, **3 duplicate ACKs** are received. Show the response (Fast Retransmit/Recovery). [2]

**Solution:**

**a) Rounds 1-10:**

| Round | cwnd | Phase |
|-------|------|-------|
| Start | 1 | Slow Start |
| 1 | 2 | Slow Start ×2 |
| 2 | 4 | Slow Start ×2 |
| 3 | 8 | Slow Start ×2 |
| 4 | 16 | Slow Start → **ssthresh reached** |
| 5 | 17 | Congestion Avoidance +1 |
| 6 | 18 | Congestion Avoidance +1 |
| 7 | 19 | Congestion Avoidance +1 |
| 8 | 20 | Congestion Avoidance +1 |
| 9 | 21 | Congestion Avoidance +1 |
| 10 | 22 | Congestion Avoidance +1 |

**b) Timeout at Round 10 (cwnd = 22):**

- **Timeout = strong sign of serious congestion**
- New ssthresh = **22/2 = 11 MSS**
- cwnd **resets to 1 MSS**
- Slow Start begins again

| Round | cwnd | Phase |
|-------|------|-------|
| 11 | 1 | Slow Start (reset after timeout) |
| 12 | 2 | Slow Start ×2 |
| 13 | 4 | Slow Start ×2 |
| 14 | 8 | Slow Start ×2 |
| **ssthresh=11 not yet reached** | | |
| 15 | 11 | Slow Start → reaches new ssthresh |
| 16 | 12 | Congestion Avoidance +1 |

**c) 3 Duplicate ACKs at Round 14 (cwnd = 8):**

- **3 dup ACKs = mild congestion signal** (packet lost but network still flowing)
- This triggers **Fast Retransmit** (immediately retransmit lost segment)
- Then **Fast Recovery:**
  - New ssthresh = **8/2 = 4 MSS**
  - cwnd = ssthresh + 3 = **4 + 3 = 7 MSS** (some implementations set cwnd = ssthresh)
  - Skip Slow Start → go directly to **Congestion Avoidance** from cwnd=7
  
| Round | cwnd | Phase |
|-------|------|-------|
| 14 (before dup ACK) | 8 | Slow Start |
| 14 (after dup ACK) | **7 (or 4)** | Fast Recovery → CA |
| 15 | 8 | Congestion Avoidance +1 |

> Key difference: Timeout → cwnd=1 (severe reset). 3 dup ACKs → cwnd=ssthresh (gentler recovery).

---

### CC-Q3 [Moderate] — QoS Flow Characteristics + Leaky Bucket

a) Define the four flow characteristics of QoS. For a **real-time stock trading application**, rank their importance (1=most critical) and justify each ranking. [3]

b) A host uses a Leaky Bucket with an output rate of **4 Mbps**. The bucket capacity is **8 Mbits**. Input: 12 Mbps for 1 second, then 0 Mbps for 3 seconds, then 6 Mbps for 2 seconds. Trace the bucket level and output for each second. [3]

**Solution:**

**a) Four QoS Flow Characteristics:**

| Characteristic | Definition | Rank for Stock Trading | Reason |
|---------------|-----------|----------------------|--------|
| **Reliability** | All packets must arrive correctly; no data loss | **1 (MOST CRITICAL)** | A missed or corrupted trade order = financial disaster |
| **Delay** | End-to-end transmission time | **2** | Low latency is crucial — every millisecond counts in trading |
| **Jitter** | Variation in delay for packets in same flow | **3** | Inconsistent timing could affect order sequencing |
| **Bandwidth** | Amount of data per unit time | **4 (LEAST CRITICAL)** | Trade data is relatively small; bandwidth not a bottleneck |

**b) Leaky Bucket Trace:**

Output rate = 4 Mbps constant. Bucket capacity = 8 Mbits.

| Second | Input | Bucket before | Incoming | Output | Overflow | Bucket after |
|--------|-------|--------------|----------|--------|----------|-------------|
| s=1 | 12 Mbps = 12 Mb | 0 | +12 | -4 | **max(0, 12-8) = 4 Mbits dropped!** | **8** (full) |
| s=2 | 0 Mbps | 8 | +0 | -4 | 0 | **4** |
| s=3 | 0 Mbps | 4 | +0 | -4 | 0 | **0** |
| s=4 | 0 Mbps | 0 | +0 | 0 (nothing to output) | 0 | **0** |
| s=5 | 6 Mbps = 6 Mb | 0 | +6 | -4 | 0 | **2** |
| s=6 | 6 Mbps = 6 Mb | 2 | +6 | -4 | 0 | **4** |

**Summary:**
- During second 1: bucket fills to capacity (8 Mb), 4 Mbits of burst data is **DROPPED**
- During seconds 2-3: bucket drains at 4 Mbps
- During seconds 5-6: input < output capacity, no overflow, bucket partially fills

> The leaky bucket converts bursty input (12 Mbps, 0, 6 Mbps) into smoothed output (4, 4, 4, 0, 4, 4 Mbps)

---

## TOPIC 4: TCP THREE-WAY HANDSHAKING (3 Additional Questions)

---

### TCP-Q1 [Easy] — Sequence Number Rules

Fill in ALL missing values in this TCP exchange:

```
Client → Server: SYN, seq=500
Server → Client: SYN+ACK, seq=?, ack=?
Client → Server: ACK, seq=?, ack=?
Client → Server: DATA (100 bytes), seq=?, ack=?
Server → Client: ACK, seq=?, ack=?
```

**Solution:**

```
Client → Server: SYN, seq=500                        [SYN consumes 1 seq#]
Server → Client: SYN+ACK, seq=3000, ack=501          [seq=3000 (server's ISN), ack=500+1]
Client → Server: ACK, seq=501, ack=3001              [ack=3000+1, seq stays 501 (no data)]
Client → Server: DATA (100 bytes), seq=501, ack=3001 [PSH+ACK, data bytes 501-600]
Server → Client: ACK, seq=3001, ack=601              [ack=501+100=601, next expected byte]
```

**Rules Recap:**
- SYN: seq = ISN (consumes 1 number)
- ack = (received seq) + 1 for SYN/FIN
- ack = (received seq) + (bytes received) for DATA
- Pure ACK: seq stays the same (no data, no consumption)

---

### TCP-Q2 [Hard] — Full TCP Session with Data Transfer

Host A (ISN=2000) establishes a TCP connection with Server S (ISN=7000). After connection:
1. A sends 500 bytes (Segment 1)
2. S acknowledges and sends 300 bytes (Segment 2)
3. A acknowledges (Segment 3)
4. A initiates termination

**Show ALL segments** with complete seq and ack numbers from start to finish.

**Solution:**

**Phase 1: Connection Establishment**
```
A→S: SYN,     seq=2000, ack=—                    [SYN consumes 1 → next A seq = 2001]
S→A: SYN+ACK, seq=7000, ack=2001                 [SYN+ACK consumes 1 → next S seq = 7001]
A→S: ACK,     seq=2001, ack=7001                 [pure ACK, no seq consumption]
```

**Phase 2: Data Transfer**
```
A→S: DATA(500B), seq=2001, ack=7001, PSH+ACK=1   [bytes 2001-2500]
S→A: DATA(300B)+ACK, seq=7001, ack=2501, PSH+ACK=1 [ack=2001+500=2501; bytes 7001-7300]
A→S: ACK,     seq=2501, ack=7301                 [ack=7001+300=7301]
```

**Phase 3: Connection Termination (A initiates)**
```
A→S: FIN+ACK, seq=2501, ack=7301, FIN=1         [FIN consumes 1 → next A seq = 2502]
S→A: FIN+ACK, seq=7301, ack=2502, FIN=1         [ack=2501+1=2502; FIN consumes 1]
A→S: ACK,     seq=2502, ack=7302                 [ack=7301+1=7302]
```

**Complete Summary Table:**
| Seg | Dir | Type | seq | ack | Bytes | Phase |
|-----|-----|------|-----|-----|-------|-------|
| 1 | A→S | SYN | 2000 | — | 0 | Establish |
| 2 | S→A | SYN+ACK | 7000 | 2001 | 0 | Establish |
| 3 | A→S | ACK | 2001 | 7001 | 0 | Establish |
| 4 | A→S | DATA+ACK | 2001 | 7001 | 500 | Transfer |
| 5 | S→A | DATA+ACK | 7001 | 2501 | 300 | Transfer |
| 6 | A→S | ACK | 2501 | 7301 | 0 | Transfer |
| 7 | A→S | FIN+ACK | 2501 | 7301 | 0 | Terminate |
| 8 | S→A | FIN+ACK | 7301 | 2502 | 0 | Terminate |
| 9 | A→S | ACK | 2502 | 7302 | 0 | Terminate |

---

### TCP-Q3 [Moderate] — Half-Close with Sorting Example

Client C sends a large dataset to Server S for sorting. Explain why a **half-close** is needed here. Show the complete sequence of segments, explaining which connections are open/closed at each stage.

**Solution:**

**Why half-close is needed:**
- Sorting requires ALL input data before processing can begin
- C must send ALL data and signal "no more data coming" — but still needs to RECEIVE the sorted output
- Full close would terminate BOTH directions simultaneously → C would miss the sorted results
- Solution: C **half-closes** its sending direction, keeps its receiving direction open

**Sequence:**

```
   Client C                                   Server S
      |                                            |
      | ── ESTABLISH CONNECTION (3-way HS) ──────► |
      |                                            |
      | ── DATA (entire dataset) ─────────────────► |
      | ◄── ACKs ──────────────────────────────── |
      |           [C sends all data, then...]      |
      |                                            |
      | ── FIN (Active close: C→S direction) ────► | Half-close!
      | ack received for FIN                       | C stops SENDING
      | ◄── ACK ───────────────────────────────── | (but still RECEIVING)
      |                                            |
      |     [Server sorts the data... takes time] |
      |                                            |
      | ◄── DATA (sorted results from S to C) ─── |
      | ── ACKs ──────────────────────────────────► |
      |                                            |
      | ◄── FIN (S closes S→C direction) ────────  | S is done sending
      | ── ACK ───────────────────────────────────► | Full close ✓
```

**State at each stage:**

| Stage | C→S direction | S→C direction |
|-------|--------------|--------------|
| After connection | OPEN | OPEN |
| After C's FIN | **CLOSED** | OPEN |
| While S sorts and sends data | CLOSED | OPEN |
| After S's FIN + C's ACK | CLOSED | **CLOSED** |

> The key insight: TCP is a **full-duplex** protocol. Each direction is independent and can be closed separately. The half-close closes ONE direction while keeping the OTHER open.

---

# QUICK REFERENCE SHEET

---

## ARP vs RARP Summary
| | ARP | RARP |
|-|-----|------|
| Known | IP address | MAC address |
| Want | MAC address | IP address |
| Request | Broadcast | Broadcast |
| Reply | Unicast | Unicast |
| Operation | 1=Req, 2=Reply | 3=Req, 4=Reply |
| Ethernet type | 0x0806 | 0x8035 |
| Needs server? | No | Yes |

## Dijkstra Algorithm Steps
1. Set source = 0, all others = ∞
2. Pick unvisited node with MINIMUM distance → visit it
3. For each NEIGHBOR: if (current dist + edge weight) < neighbor's dist → UPDATE
4. Mark visited, add to priority queue
5. Repeat until all visited or destination reached

## TCP Sequence Number Rules
| Segment | Seq# consumed? |
|---------|---------------|
| SYN | YES (+1) |
| SYN+ACK | YES (+1) |
| ACK (no data) | NO |
| FIN (no data) | YES (+1) |
| FIN+ACK | YES (+1) |
| DATA (N bytes) | YES (+N) |

## Congestion Control Summary
| Method | Type | Who signals | Who slows |
|--------|------|-------------|-----------|
| Backpressure | Closed-loop | Each node to upstream | Each node propagates back |
| Choke Packet | Closed-loop | Congested node → Source | Source directly |
| Implicit Signaling | Closed-loop | No one (timeout/dup ACK) | Source (TCP itself) |
| Slow Start | Open-loop (TCP) | — | Sender (exponential growth) |
| Congestion Avoidance | Open-loop (TCP) | — | Sender (linear growth) |

## TCP Slow Start / Congestion Avoidance
- **Below ssthresh:** cwnd doubles each round (×2, Exponential)
- **At/Above ssthresh:** cwnd += 1 each round (Linear/Additive)
- **Timeout detected:** ssthresh = cwnd/2, cwnd = 1 (restart Slow Start)
- **3 dup ACKs:** ssthresh = cwnd/2, cwnd = ssthresh (Fast Recovery)

---
*End of Practice Question Bank — CSE405/ICE302 Computer Networks*
*East West University | Instructor: Md. Khalid Mahbub Khan*

# CSE405 / ICE302 — Computer Networks
# Complete Study Material — Easy Language with Examples
### East West University | Based on Exam Syllabus

---

> **How to use this:** Read each concept, understand the real-life analogy first, then read the technical explanation. Every topic ends with a "Key Points for Exam" box.

---

# CHAPTER 1: ARP & RARP

---

## 1.1 What is ARP? Why do we need it?

### The Simple Idea

Imagine you're in a classroom and you want to pass a note to "Ali." You know Ali's **name** (like an IP address), but you need to know which **seat** Ali sits in (like a MAC address) to physically deliver the note.

You shout: *"Hey! Who is Ali? Please raise your hand!"*
Everyone hears it. Ali raises his hand → you now know which seat is Ali's.
Next time, you remember → no need to shout again.

**That's exactly what ARP does.**

In a network:
- **IP address** = the name (logical address, used for routing)
- **MAC address** = the seat number (physical address, used for actual delivery on a local network)
- **ARP** = the process of shouting "who has this IP? Tell me your MAC!"

### When is ARP needed?

Every time a device wants to send data to another device **on the same network**, it must know the destination's **MAC address**. IP alone is not enough for the data link layer (Ethernet). So ARP converts IP → MAC.

### The ARP Process — Step by Step

**Scenario:** Host A (IP: 192.168.1.1, MAC: AA:AA:AA:AA:AA:AA) wants to send data to Host B (IP: 192.168.1.2, MAC: unknown to A).

```
STEP 1: A checks its ARP cache
┌──────────────────────────────────────────────┐
│ ARP Cache (A's memory of IP→MAC mappings)   │
│ 192.168.1.5 → CC:CC:CC:CC:CC:CC  (known)   │
│ 192.168.1.2 → ???  NOT FOUND               │
└──────────────────────────────────────────────┘
→ Cache miss! Must send ARP request.

STEP 2: A broadcasts ARP REQUEST to everyone
"Who has 192.168.1.2? Tell 192.168.1.1!"
Destination Ethernet MAC: FF:FF:FF:FF:FF:FF (BROADCAST → all hosts receive it)

           ┌──────────────────────────────────────┐
A ─────────►    HUB/SWITCH    ──────────────────►  B (IP: 192.168.1.2) ← matches!
           │                  ├──────────────────►  C (IP: 192.168.1.3) ← ignores
           └──────────────────┴──────────────────►  D (IP: 192.168.1.4) ← ignores

STEP 3: B recognizes its OWN IP → sends unicast ARP REPLY
"192.168.1.2 is at BB:BB:BB:BB:BB:BB"
→ Sent ONLY to A (unicast, not broadcast)

STEP 4: A receives reply → updates its ARP cache
┌──────────────────────────────────────────────┐
│ ARP Cache (updated)                          │
│ 192.168.1.5 → CC:CC:CC:CC:CC:CC             │
│ 192.168.1.2 → BB:BB:BB:BB:BB:BB  ← NEW    │
└──────────────────────────────────────────────┘
→ A can now send the data frame with B's MAC address!
```

> **Golden Rule: ARP REQUEST = BROADCAST, ARP REPLY = UNICAST**

---

## 1.2 ARP Packet Anatomy — What's Inside?

The ARP packet has these fields (think of it like a form you fill out):

```
┌──────────────────────────────────────────────────────────────────┐
│  FIELD             │ SIZE    │ WHAT IT MEANS                      │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Hardware Type      │ 2 bytes │ Type of physical network           │
│                    │         │ Ethernet = 1 (0x0001)              │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Protocol Type      │ 2 bytes │ Which logical protocol             │
│                    │         │ IPv4 = 0x0800                      │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Hardware Length    │ 1 byte  │ Size of MAC address in bytes       │
│                    │         │ Ethernet = 6                       │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Protocol Length    │ 1 byte  │ Size of IP address in bytes        │
│                    │         │ IPv4 = 4                           │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Operation          │ 2 bytes │ 1 = ARP Request, 2 = ARP Reply    │
│                    │         │ 3 = RARP Request, 4 = RARP Reply  │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Sender HW Addr     │ 6 bytes │ MAC of the sender                  │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Sender Protocol    │ 4 bytes │ IP of the sender                   │
│ Addr               │         │                                    │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Target HW Addr     │ 6 bytes │ MAC of the target                  │
│                    │         │ In REQUEST: all zeros (unknown)    │
├────────────────────┼─────────┼────────────────────────────────────┤
│ Target Protocol    │ 4 bytes │ IP of the target (the IP we        │
│ Addr               │         │ are asking about)                  │
└──────────────────────────────────────────────────────────────────┘
Total ARP data = 28 bytes
```

**How to fill it for Request vs Reply:**

| Field | In REQUEST (asking) | In REPLY (answering) |
|-------|--------------------|--------------------|
| Operation | **1** | **2** |
| Sender HW | Requester's MAC | Responder's MAC |
| Sender IP | Requester's IP | Responder's IP |
| Target HW | **00:00:00:00:00:00** (unknown!) | Requester's MAC |
| Target IP | The IP we're asking about | The IP that was asked about |

---

## 1.3 The Four Cases Where ARP is Used

ARP isn't just used when sender and receiver are on the same network. Here are all four scenarios:

```
CASE 1: Sender and receiver are on the SAME network
         Target IP = Destination's actual IP
         ARP finds the destination's MAC directly

CASE 2: Sender wants to reach a host on ANOTHER network
         (Must go through a router first)
         Target IP = Router's IP (default gateway)
         ARP finds the router's MAC

CASE 3: A router receives a packet, needs to send to another router
         Target IP = Next router's IP (from routing table)
         ARP finds the next router's MAC

CASE 4: A router receives a packet, destination is on THIS network
         Target IP = Final destination's IP
         ARP finds the final host's MAC
```

---

## 1.4 ARP Cache — The Memory System

To avoid broadcasting ARP requests every single time, devices maintain an **ARP Cache** (a table of IP→MAC mappings).

```
ARP Cache Table:
┌────────┬──────┬─────────┬──────────┬──────────────┬──────────────────┐
│ State  │Queue │ Attempt │ Time-Out │ Protocol Addr│ Hardware Addr    │
├────────┼──────┼─────────┼──────────┼──────────────┼──────────────────┤
│   R    │  5   │   —     │   900    │ 180.3.6.1    │ ACAE32457342     │ ← RESOLVED
│   P    │  2   │   2     │   —      │ 129.34.4.8   │ —                │ ← PENDING
│   F    │  —   │   —     │   —      │ —            │ —                │ ← FREE slot
└────────┴──────┴─────────┴──────────┴──────────────┴──────────────────┘
```

**Three states:**
- **R (Resolved):** MAC address is known. Has a TTL (time-out). When TTL reaches 0, entry is deleted.
- **P (Pending):** ARP request was sent but reply hasn't come yet. Has an "Attempt" counter. If attempts exceed max → entry becomes FREE.
- **F (Free):** Empty slot, available for new entries.

**How the cache-control module works:**
- Every fixed interval (e.g., 60 seconds), it checks ALL entries
- RESOLVED entries: decrement their TTL by the elapsed time
- PENDING entries: increment the attempt counter, send another ARP request
- If TTL = 0 → entry → FREE
- If attempts > max → entry → FREE (give up on that destination)

---

## 1.5 ARP Encapsulation in Ethernet

The ARP packet itself is placed inside an **Ethernet frame**:

```
ETHERNET FRAME carrying an ARP packet:
┌─────────────┬──────────────────┬──────────────────┬─────────┬──────────────┬──────┐
│ Preamble    │ Destination MAC  │ Source MAC       │  Type   │ ARP Packet   │ CRC  │
│ + SFD       │                  │                  │         │ (28 bytes)   │      │
│ 8 bytes     │ 6 bytes          │ 6 bytes          │ 2 bytes │              │4bytes│
└─────────────┴──────────────────┴──────────────────┴─────────┴──────────────┴──────┘
                FF:FF:FF:FF:FF:FF   (sender's MAC)     0x0806
                (for broadcast)                       ← identifies ARP
```

**Type field = 0x0806** tells the receiver: "This Ethernet frame contains an ARP packet."
(Compare: Type = 0x0800 means IPv4, Type = 0x8035 means RARP)

---

## 1.6 Proxy ARP — The "Middleman"

### The Scenario

Imagine a new subnetwork is added to a building. The new hosts have IP addresses in the same range as the main network. But there's a router between them.

When Host P on the main network does ARP for a host on the new subnetwork, the ARP request **can't cross the router** (routers don't forward broadcasts). The host would never get a reply.

**Proxy ARP solves this:** The router answers ARP requests **on behalf of** hosts it can reach.

```
MAIN NETWORK                                 SUB NETWORK
                                             ┌─────────────────────┐
Host P ──► "Who has 192.168.1.21?"          │ 192.168.1.21        │
(broadcasts)                                 │ 192.168.1.22        │
            │                                │ 192.168.1.23        │
            │                       ┌────────┴─────┐              │
            │    Proxy ARP Router   │              │              │
            └──────────────────────►│  "I know     │              │
                                    │  192.168.1.21 │              │
                                    │  Use MY MAC"  │              │
                                    └──────┬────────┘              │
                                           │                        │
            ◄──────────────────────────────┘                       │
Host P gets: "192.168.1.21 is at [Router's MAC]"                   │
                                                                    │
Host P sends data to Router → Router forwards to 192.168.1.21 ────►│
```

**Host P is fooled** (in a good way) — it thinks 192.168.1.21 replied directly. It doesn't know a router is involved. This is called **transparent proxy**.

---

## 1.7 RARP — Reverse ARP

### The Concept

RARP is the exact **opposite of ARP**:
- ARP: "I know the IP, give me the MAC" → IP → MAC
- RARP: "I know my MAC, give me the IP" → MAC → IP

### When is RARP used?

When a **diskless workstation** or newly booted device doesn't know its own IP address but knows its hardware (MAC) address. It asks: "What IP address have I been assigned?"

```
RARP Process:
                            RARP SERVER
                         (has a table of MAC→IP)
Host T                        │
MAC: DE:AD:BE:EF:00:01         │
                               │
STEP 1: T broadcasts           │
"My MAC = DE:AD:BE:EF:00:01   │
 What is my IP?"               │
───────────────────────────────►
(broadcast to all)             │
                               │ RARP Server looks up:
                               │ DE:AD:BE:EF:00:01 → 10.20.30.25
                               │
STEP 2: Server replies (unicast)
◄──────────────────────────────
"Your IP address is 10.20.30.25"

T now knows its IP = 10.20.30.25 ✓
```

> **Golden Rule: RARP REQUEST = BROADCAST, RARP REPLY = UNICAST**

### ARP vs RARP — Side by Side

| | ARP | RARP |
|-|-----|------|
| **You know** | IP address | MAC address |
| **You want** | MAC address | IP address |
| **Request type** | Broadcast | Broadcast |
| **Reply type** | Unicast | Unicast |
| **Operation codes** | Request=1, Reply=2 | Request=3, Reply=4 |
| **Ethernet Type** | 0x0806 | 0x8035 |
| **Needs a server?** | No | **Yes — RARP server** |
| **Unknown field in request** | Target HW Addr (all zeros) | Sender & Target Protocol Addr |

> **RARP limitation:** RARP only provides an IP address. It can't give subnet mask, gateway, or DNS. DHCP replaced RARP because DHCP provides ALL configuration in one go.

---

### KEY POINTS FOR EXAM — ARP & RARP

```
✅ ARP: IP → MAC (broadcast request, unicast reply)
✅ RARP: MAC → IP (broadcast request, unicast reply)
✅ ARP packet Operation: 1=request, 2=reply, 3=RARP request, 4=RARP reply
✅ ARP Ethernet type = 0x0806, RARP Ethernet type = 0x8035
✅ Target HW Addr in ARP REQUEST = all zeros (00:00:00:00:00:00)
✅ ARP Cache states: R (Resolved), P (Pending), F (Free)
✅ Proxy ARP: Router answers ARP on behalf of hosts in other networks
✅ ARP data = 28 bytes (6+4+6+4 + 8 bytes header fields)
```

---

---

# CHAPTER 2: ROUTING PROTOCOLS

---

## 2.1 What is Routing?

### The Real-Life Analogy

Imagine you want to send a package from Dhaka to London. You don't send it directly — it goes through intermediaries: Dhaka post office → airport → customs → London airport → local delivery.

Each post office decides: "Where should I send this package next?" based on its knowledge of routes.

**In networking:** Routing is the process of **deciding the path** a packet should take from source to destination across multiple networks. The devices that make these decisions are called **Routers**.

### Intradomain vs Interdomain Routing

```
┌─────────────────────────────────────────────────────────────────────────┐
│                    THE INTERNET                                         │
│  ┌───────────────────┐    ┌───────────────────┐    ┌─────────────────┐ │
│  │  Autonomous System│    │  Autonomous System│    │ Autonomous     │ │
│  │  (AS1 - e.g. BTCL)│    │  (AS2 - e.g. Grameenphone)│ System 3    │ │
│  │  ┌───┐ ┌───┐      │    │  ┌───┐ ┌───┐      │    │  ┌───┐ ┌───┐  │ │
│  │  │R1 │─│R2 │      │◄──►│  │R3 │─│R4 │      │◄──►│  │R5 │─│R6 │  │ │
│  │  └───┘ └───┘      │    │  └───┘ └───┘      │    │  └───┘ └───┘  │ │
│  └───────────────────┘    └───────────────────┘    └───────────────┘ │
│    INTRADOMAIN routing          INTERDOMAIN routing between AS's       │
│    (RIP or OSPF inside AS)      (BGP between AS's)                     │
└─────────────────────────────────────────────────────────────────────────┘
```

- **Autonomous System (AS):** A group of networks under one administrative control (like a company or ISP)
- **Intradomain routing:** Routing INSIDE one AS → uses **RIP** or **OSPF**
- **Interdomain routing:** Routing BETWEEN different AS's → uses **BGP**

### Popular Routing Protocols

```
Routing Protocols
├── Intradomain (inside one AS)
│   ├── Distance Vector → RIP
│   └── Link State → OSPF
└── Interdomain (between AS's)
    └── Path Vector → BGP
```

---

## 2.2 Distance Vector Routing

### The Concept — "What My Neighbors Tell Me"

Think of distance vector routing like **asking your friends for directions**:
- You ask your friend Ali: "How far is the market from your place?"
- Ali says: "2 km."
- You know Ali lives 1 km from you.
- So: Market is 1 + 2 = 3 km from you!

Each router only knows:
1. The cost to its **direct neighbors**
2. What its **neighbors told it** about their routes

A router does NOT know the full network map — it only knows what its neighbors share.

### Distance Vector Routing Tables

Each router maintains a table:
- **To:** Destination network
- **Cost:** Minimum cost (hops or delay) to reach that destination
- **Next Hop:** Which neighbor to forward to

```
Network Example:
      5         3
A ─────────── B ─────────── E
│    2        │
└────── C ────┘
   3       4

A's Table:               B's Table:               C's Table:
To│Cost│Next            To│Cost│Next            To│Cost│Next
──┼────┼────            ──┼────┼────            ──┼────┼────
A │ 0  │ —             A │ 5  │ —             A │ 3  │ —
B │ 5  │ —             B │ 0  │ —             B │ 4  │ —
C │ 2  │ —             C │ 4  │ —             C │ 0  │ —
D │ 3  │ —             D │ 8  │ A             D │...  │...
E │ 6  │ C             E │ 3  │ —             E │...  │...
```

### Initialization — What You Know at the Start

At startup, each node ONLY knows its direct neighbors. Everything else = ∞.

```
A's Initial Table:
To │ Cost │ Next
───┼──────┼──────
A  │  0   │  —
B  │  2   │  B   ← direct link
C  │  3   │  C   ← direct link
D  │  ∞   │  —   ← don't know yet
E  │  ∞   │  —   ← don't know yet
```

### Updating the Table — The Bellman-Ford Logic

When Node A receives Node B's distance vector, A does this:

**Formula:** New cost via B = (A→B link cost) + (B's cost to destination)

```
B sends its vector: {A:0, B:0, C:4, D:2, E:3}
A-B link cost = 2

A calculates "what if I go through B?":
  Via B to A: 2+0 = 2  (worse than A's own 0, no change)
  Via B to C: 2+4 = 6  (worse than A's current 3, no change)
  Via B to D: 2+2 = 4  (A had ∞, so UPDATE to 4 via B!)
  Via B to E: 2+3 = 5  (A had ∞, so UPDATE to 5 via B!)

A's Updated Table:
To │ Cost │ Next
───┼──────┼──────
A  │  0   │  —
B  │  2   │  B
C  │  3   │  C   (unchanged)
D  │  4   │  B   ← NEW!
E  │  5   │  B   ← NEW!
```

> **Key Rule in Distance Vector:**
> If (link cost to neighbor) + (neighbor's cost to dest) < my current cost → **UPDATE!**

### How Updates Work — The Process

```
1. Every router starts with only direct neighbor costs
2. Periodically (e.g., every 30 seconds), each router sends its 
   complete routing table to its IMMEDIATE NEIGHBORS ONLY
3. Each router updates its own table using Bellman-Ford
4. This continues until the tables CONVERGE (no more changes)
5. The number of rounds needed = number of hops in the longest path
```

> **Rule: In distance vector routing, each node shares its routing table with its immediate neighbors periodically and when there is a change.**

---

## 2.3 Problems with Distance Vector — Instability

### Two-Node Instability (Count to Infinity)

**The Setup:**
```
X ──2── A ──4── B
(X is directly connected to A, B reaches X via A)

Before X fails:
A: X=2 (direct), B: X=6 (via A: 4+2)
```

**X fails. What happens?**

```
CORRECT behavior: A detects X failed → A sets X=∞ → tells B → B sets X=∞
                  Both agree X is unreachable. Done.

WHAT ACTUALLY HAPPENS (the problem):
```

| Time | Event | A's cost to X | B's cost to X |
|------|-------|-------------|-------------|
| t=0 | X fails | **∞** (A knows) | 6 (B doesn't know yet) |
| t=1 | B sends update before A can tell B | B says "X=6!" | 6 |
| t=2 | A receives B's update: "X=6 via B, so X= 6+4=**10** via B" | **10** | 6 |
| t=3 | B receives A's update: "X=10 via A, so X=10+4=**14** via A" | 10 | **14** |
| t=4 | A: 14+4=**18** | **18** | 14 |
| t=5 | B: 18+4=**22** | 18 | **22** |
| ... | keeps counting up... | ↑ | ↑ |
| Final | Reaches 16 (infinity in RIP) | 16 | 16 |

**Why does this happen?** B still thinks A has a valid path to X. A thinks B has a valid path. They keep believing each other's stale information. The cost "counts to infinity" = the count-to-infinity problem.

### Three-Node Instability

**The Setup:**
```
X ──2── A ──4── B
         └──3── C
         (C also has a path to X via A: cost 3+2=5)
```

X fails. A sends updates to BOTH B and C. But the packet to C gets **LOST**.

```
B receives update → B sets X=∞ ✓ (correct)
C never receives update → C still thinks X=5 (via A) ← stale/wrong
```

Now:
- A gets C's stale update (C says X=5) → A thinks "I can reach X via C at 3+5=8!" → A sets X=8
- B gets A's update (A says X=8) → B thinks X=8+4=12
- Loop continues between A, B, C with C's false info feeding the loop

The problem is even harder to resolve because there are three nodes perpetuating the false information.

### Solution: Split Horizon with Poison Reverse

**Split Horizon:** "Don't tell someone about a route you learned FROM them."
If B learned about X from A → B does NOT advertise X back to A.

**Poison Reverse (stronger):** Instead of silence, B tells A that X = **16 (∞/poison)**.
This actively kills the false route — much faster convergence.

```
With Poison Reverse:
B learned X from A → B sends to A: "X = 16 (unreachable)"
A receives this: "A can't use B to reach X" → A keeps X=∞ ✓
No loop ever forms! ✓
```

---

## 2.4 RIP — Routing Information Protocol

RIP is the **most popular distance vector protocol** used inside an autonomous system.

### Key Features of RIP

| Feature | Value |
|---------|-------|
| Type | Intradomain, Distance Vector |
| Metric | Hop count (number of routers to cross) |
| Max hops | 15 (16 = infinity/unreachable) |
| Update interval | Every 25-35 seconds |
| Transport | **UDP, Port 520** |
| Max networks per message | 25 |

### RIP Message Format

```
RIP MESSAGE:
┌────────────┬─────────┬──────────────────────────────────┐
│  Command   │ Version │ Reserved (all zeros)             │
├────────────┴─────────┴──────────────────────────────────┤
│  Family                  │  All Zeros (or Route Tag)    │  ← Repeated for
├──────────────────────────┴──────────────────────────────┤     each network
│                  Network Address                        │  ← up to 25 times
├─────────────────────────────────────────────────────────┤
│                  All Zeros                              │
├─────────────────────────────────────────────────────────┤
│                  All Zeros                              │
├─────────────────────────────────────────────────────────┤
│                  Distance (hop count)                   │
└─────────────────────────────────────────────────────────┘
Command: 1 = Request (ask for routes), 2 = Response/Update (share routes)
```

### RIP Timers

```
┌─────────────────────────────────────────────────────┐
│                   RIP TIMERS                        │
├──────────────────┬──────────────────────────────────┤
│ Periodic Timer   │ 25-35 sec                        │
│                  │ How often updates are sent        │
├──────────────────┼──────────────────────────────────┤
│ Expiration Timer │ 180 sec                          │
│                  │ If no update for 180s → route    │
│                  │ marked as expired (cost=16)       │
├──────────────────┼──────────────────────────────────┤
│ Garbage Timer    │ 120 sec                          │
│                  │ After expiration, wait 120s then  │
│                  │ delete the route completely       │
└──────────────────┴──────────────────────────────────┘
```

**Example:**
A routing table has 20 entries. 5 routes haven't been updated for 200 seconds. How many timers are running?
- 1 Periodic Timer (always 1)
- 15 Expiration timers (for the 15 active routes)
- 5 Garbage Collection timers (for the 5 expired routes)
- **Total = 21 timers**

> **Note: RIP uses the services of UDP on well-known port 520.**

---

## 2.5 Link State Routing

### The Concept — "I Know the WHOLE Map"

Link State routing is like **having a complete map of the city** before you decide your route. Every router knows the ENTIRE network topology.

**Distance Vector:** "Ask neighbors for directions, trust what they say."
**Link State:** "Each router broadcasts its own connections to EVERYONE. Everyone builds the complete map."

### How Link State Works — The Process

```
STEP 1: NEIGHBOR DISCOVERY
Each router finds its direct neighbors by sending HELLO packets.
Router A receives HELLO back from B and D → A knows its neighbors are B and D.

STEP 2: LINK STATE PACKET (LSP) CREATION
Each router creates a Link State Packet containing:
  - Router's ID
  - List of direct neighbors and link costs
  - Sequence number (to track freshness)
  - TTL (to expire old packets)

Example: A's LSP = {Router=A, Seq=1, TTL=60, Links: {B:2, D:4}}

STEP 3: FLOODING (sharing with everyone)
Each router sends its LSP to ALL other routers in the network.
(Not just neighbors — everyone!)
Each router forwards a received LSP to all ports EXCEPT where it came from.

STEP 4: FULL TOPOLOGY MAP
After flooding, every router has the same complete picture:
  A: {B:2, D:4}
  B: {A:2, C:3, D:1}
  C: {B:3, E:2, F:5}
  D: {A:4, B:1, E:3}
  E: {C:2, D:3, F:1}
  F: {C:5, E:1}

STEP 5: DIJKSTRA'S ALGORITHM
Each router independently runs Dijkstra on this map to find
the shortest path to every other router.
```

### The Link State Packet (LSP) Table

Each router stores received LSPs in a database. The LSP contains:
- **Sequence number:** Higher sequence = more recent. Old LSPs are ignored.
- **TTL (Time To Live):** Prevents LSPs from circulating forever. Decremented at each hop; discarded when TTL=0.
- **Cost:** The cost of the link to that neighbor.

```
Node B's LSP Database (what B received from all nodes):
┌────────────┬──────────────┬─────┬──────────────────────────────────┐
│  Node      │  Seq Number  │ TTL │  Neighbors (with costs)          │
├────────────┼──────────────┼─────┼──────────────────────────────────┤
│  A         │     5        │ 40  │  B:2, D:4                        │
│  B (self)  │     8        │ —   │  A:2, C:3, D:1                   │
│  C         │     3        │ 55  │  B:3, E:2, F:5                   │
│  D         │     7        │ 48  │  A:4, B:1, E:3                   │
│  E         │     2        │ 60  │  C:2, D:3, F:1                   │
│  F         │     4        │ 35  │  C:5, E:1                        │
└────────────┴──────────────┴─────┴──────────────────────────────────┘
```

### Distance Vector vs Link State — Comparison

| Feature | Distance Vector (RIP) | Link State (OSPF) |
|---------|----------------------|-------------------|
| What each node knows | Only neighbor info | Complete network map |
| Information shared | Entire routing table | Only own link costs |
| Sharing with | Immediate neighbors only | Everyone (flood) |
| Algorithm | Bellman-Ford | Dijkstra |
| Convergence speed | Slow | Fast |
| Bandwidth usage | Low | Higher (flooding) |
| Scalability | Small networks | Large networks |
| Count-to-infinity? | YES (a problem) | NO |

---

## 2.6 Dijkstra's Algorithm — Finding Shortest Path

### What It Does

Dijkstra's algorithm finds the **shortest path from one source node to ALL other nodes** in a network. It works step by step, always picking the closest unvisited node next.

### The Algorithm — Step by Step

```
SETUP:
- Source node distance = 0
- All other nodes = ∞ (unknown)
- Keep a "visited" set and a "priority queue" (unvisited nodes sorted by distance)

REPEAT until all nodes visited:
  1. Pick the unvisited node with SMALLEST distance → call it "current"
  2. For each NEIGHBOR of current that is NOT visited:
       new_dist = dist[current] + edge_weight(current, neighbor)
       if new_dist < dist[neighbor]:
           dist[neighbor] = new_dist
           next_hop[neighbor] = current   ← update the path!
  3. Mark "current" as visited
```

### Worked Example

**Network:**
```
        B ──3── C
       /|\       |\
      2 1 \      2 5
     /  |  \     |  \
    A   |   (   |   F
     \  |    )  |  /
      4 |     \ | 1
       \|      \|/
        D ──3── E
```

Edges: A-B=2, A-D=4, B-C=3, B-D=1, C-E=2, C-F=5, D-E=3, E-F=1

**Goal: Find shortest path from A to all nodes**

**Priority Queue at each step:**

| Step | Visit Node | dist[A] | dist[B] | dist[C] | dist[D] | dist[E] | dist[F] | Queue |
|------|-----------|---------|---------|---------|---------|---------|---------|-------|
| Init | — | **0** | ∞ | ∞ | ∞ | ∞ | ∞ | {A:0} |
| 1 | **A**(0) | 0 | **2**(A) | ∞ | **4**(A) | ∞ | ∞ | {B:2,D:4} |
| 2 | **B**(2) | 0 | 2 | **5**(B) | **3**(B)↓ | ∞ | ∞ | {D:3,C:5} |
| 3 | **D**(3) | 0 | 2 | 5 | 3 | **6**(D) | ∞ | {C:5,E:6} |
| 4 | **C**(5) | 0 | 2 | 5 | 3 | 6 | **10**(C) | {E:6,F:10} |
| 5 | **E**(6) | 0 | 2 | 5 | 3 | 6 | **7**(E)↓ | {F:7} |
| 6 | **F**(7) | 0 | 2 | 5 | 3 | 6 | 7 | Done ✓ |

**Note: In Step 2, D was updated from 4(via A) to 3(via B) because 2+1=3 < 4.**
**In Step 5, F was updated from 10(via C) to 7(via E) because 6+1=7 < 10.**

**Final Results:**

| Destination | Shortest Distance | Path (trace back) |
|-------------|-----------------|-------------------|
| B | 2 | A → B |
| D | 3 | A → B → D |
| C | 5 | A → B → C |
| E | 6 | A → B → D → E |
| **F** | **7** | **A → B → D → E → F** |

**How to trace the path:** Go backwards from destination.
F came from E (updated at step 5) → E came from D (step 3) → D came from B (step 2) → B came from A (step 1) → **A→B→D→E→F** ✓

### Quick Dijkstra Tip for Exams

```
Priority Array approach (easier to write in exam):

Round 1: Visit A. Update all neighbors. Circle the minimum.
Round 2: Visit the minimum. Update its neighbors (if better path found). Circle next minimum.
Round 3: Continue until destination is visited.

NEVER revisit a node that's already been visited (circled)!
If a node is updated, keep the SMALLER value.
```

---

### KEY POINTS FOR EXAM — ROUTING

```
✅ Distance Vector: Share routing table with NEIGHBORS only
✅ Link State: Flood LSP to EVERYONE, then run Dijkstra
✅ Count-to-infinity: DV problem solved by Split Horizon + Poison Reverse
✅ RIP: UDP port 520, max 15 hops, 25-35s periodic update
✅ RIP timers: Periodic(25-35s), Expiration(180s), Garbage(120s)
✅ Dijkstra: Always pick the MINIMUM unvisited node next
✅ When Dijkstra updates a distance: new = current + edge < old → UPDATE
✅ Link State tables show: Node, Sequence#, TTL, Neighbor costs
✅ Intradomain: RIP (DV) or OSPF (LS); Interdomain: BGP (Path Vector)
```

---

---

# CHAPTER 3: CONGESTION CONTROL

---

## 3.1 What is Congestion?

### The Real-Life Analogy

Imagine a highway with 4 lanes. During rush hour, 8 lanes worth of cars try to use it. The highway gets jammed. Cars slow down, stop, some people take detours. Eventually, the jam makes things WORSE — people honking, trying shortcuts, creating more chaos.

In networking: **Congestion** happens when too many packets try to use the same network resources (routers, links) at the same time. Routers' buffers fill up, packets get dropped, sources retransmit, making congestion worse.

```
Normal:     Source ──► Router1 ──► Router2 ──► Destination
            [flows smoothly, delay is low]

Congested:  Source ──► Router1 ──► Router2(FULL) ─X─► Destination
                                   ↑
                         [Buffer overflow! Dropping packets!
                          Sources retransmit → MORE packets → WORSE!]
```

### Two Types of Congestion Control

```
Congestion Control
├── OPEN LOOP (Prevention — stop it BEFORE it happens)
│   └── Design policies that prevent congestion from occurring
│       (handled by sender, receiver, or router — statically)
│
└── CLOSED LOOP (Removal — fix it AFTER it happens)
    └── Detect congestion and take action to remove it
        (uses feedback — the network tells the sender to slow down)
```

---

## 3.2 Open-Loop Congestion Control (5 Policies)

These are policies designed INTO the network protocols **before** congestion happens. Think of them as traffic rules that prevent jams.

### 1. Retransmission Policy

**The problem:** Retransmitting lost packets adds MORE packets to the network → makes congestion worse.

**The solution:** Design smart retransmission timers. Don't retransmit too quickly or too often.
- TCP uses **Adaptive RTO (Retransmission Timeout):** If no ACK comes, wait longer before retransmitting (exponential backoff)
- This prevents the "panic retransmission" that floods the network

### 2. Window Policy

**The problem:** Go-Back-N sends many packets again even if only ONE was lost.

**The solution:** Use **Selective Repeat** — only retransmit the specific lost packet.
- Fewer redundant retransmissions = less load on the network

```
Go-Back-N (bad for congestion):
Sent: 1,2,3,4,5,6,7 → packet 3 lost
Must resend: 3,4,5,6,7 ← 5 packets again! (even though 4,5,6,7 arrived fine)

Selective Repeat (better):
Sent: 1,2,3,4,5,6,7 → packet 3 lost
Must resend: 3 only ← just 1 packet!
```

### 3. Acknowledgment Policy

**The problem:** Every ACK is a packet too. Lots of ACKs = more traffic = more load.

**The solution:** Use **delayed ACKs** — receiver waits a moment and acknowledges multiple packets at once.

```
Without delayed ACK: Send P1 → ACK1, Send P2 → ACK2, Send P3 → ACK3
                     (3 data packets, 3 ACK packets = 6 total)

With delayed ACK:   Send P1,P2,P3 → ACK3 (covers all three)
                    (3 data packets, 1 ACK = 4 total) ← less load!
```

### 4. Discarding Policy

**The problem:** When router buffers fill up, they must drop SOMETHING.

**The solution:** Don't drop packets randomly — drop the **LEAST IMPORTANT** ones.
- Example: In audio streaming, drop packets carrying low-priority audio rather than control packets
- The audio might sound slightly worse, but the transmission continues

This is intelligent discarding — selectively drop packets that have the least impact.

### 5. Admission Policy

**The problem:** If a new flow joins an already-congested network, it makes things worse.

**The solution:** Before admitting a new connection/flow, **check if the network can handle it**.
- If the network is already at capacity → deny the new connection (or reduce its rate)
- Used in virtual-circuit networks (like ATM)
- It's like a bouncer at a club: "Sorry, we're at capacity — you'll have to wait outside"

---

## 3.3 Closed-Loop Congestion Control (4 Methods)

These methods detect existing congestion and take action to REMOVE it.

### 1. Backpressure

**The idea:** A congested node tells its UPSTREAM neighbor to slow down. This slows the neighbor, which then tells ITS upstream neighbor, and so on — all the way back to the source.

```
Data flows: ─────────────────────────────────────────────────────►
            Source ──► Node I ──► Node II ──► Node III ──► Node IV ──► Dest
                                              [CONGESTED!]

BACKPRESSURE travels OPPOSITE to data flow:
Node III → tells Node II: "Slow down! I'm congested!"
Node II slows → may get congested → tells Node I: "Slow down!"
Node I slows → tells Source: "Slow down!"
Source slows down ✓

◄─── [Backpressure signal propagates backward, hop by hop] ───
```

**Key properties:**
- Node-to-node (each hop is involved)
- Works only in **virtual-circuit networks** (each node knows its upstream)
- Slow to reach source (must travel hop by hop)
- Intermediate nodes are also affected (may become congested themselves)

### 2. Choke Packet

**The idea:** The congested node sends a special warning packet **directly to the SOURCE**, bypassing intermediate nodes.

```
Data flows: ─────────────────────────────────────────────────────►
            Source ──► Node I ──► Node II ──► Node III ──► Node IV ──► Dest
               ↑                              [CONGESTED!]
               │           CHOKE PACKET           │
               └───────────────────────────────────┘
               (direct message from III to Source)
               Node I and Node II are NOT warned
```

**Difference from Backpressure:**

| Feature | Backpressure | Choke Packet |
|---------|-------------|--------------|
| Signal path | Hop by hop backward | **Directly to source** |
| Intermediate nodes warned? | YES | **NO** |
| Speed | Slow | **Fast** |
| Network type | Virtual-circuit only | Any type |
| Example protocol | X.25 | ICMP Source Quench |

### 3. Implicit Signaling

**The idea:** No explicit signal is sent. The **source itself figures out** there's congestion by watching for symptoms.

Symptoms of congestion:
1. **Timeout:** Sent a packet, waited for ACK, but nothing came → packet was probably dropped → congestion!
2. **3 Duplicate ACKs:** Received 3 identical ACKs → a packet was lost → mild congestion!

When the source detects these symptoms → **it slows down on its own**.

```
Source → sends packet → waits for ACK → [TIMEOUT! no ACK received]
Source thinks: "Network must be congested — packet was dropped"
Source reduces its sending rate ✓

No signal from any router — source guessed from context.
```

TCP uses this approach (implicit signaling).

### 4. Explicit Signaling

**The idea:** The congested node **explicitly signals** congestion by setting a bit in packets.

Two directions:

**Backward Signaling (toward source):**
- Congested node sets a **congestion bit** in ACK packets traveling BACK to the source
- Source sees the bit → slows down

```
Data →   Source ──► I ──► II ──► III(congested) ──► IV ──► Dest
ACKs ←   Source ◄── I ◄── II ◄── III[sets bit!] ◄── IV ◄── Dest
         ↑ Source sees congestion bit in ACK → slows down
```

**Forward Signaling (toward destination):**
- Congested node sets a bit in data packets going FORWARD
- Destination receives the bit → slows its ACKs → source slows down

---

## 3.4 TCP Congestion Policy

TCP uses three algorithms together: **Slow Start**, **Congestion Avoidance**, and **Congestion Detection**.

### Key Concepts First

- **cwnd (Congestion Window):** How many packets the sender can have "in flight" (sent but not yet acknowledged)
- **ssthresh (Slow Start Threshold):** A boundary value. Below it → exponential growth. Above it → linear growth.
- **MSS (Maximum Segment Size):** The maximum amount of data in one TCP segment

**Actual window = minimum(cwnd, rwnd)** where rwnd = receiver's advertised window

### Phase 1: Slow Start (Exponential Increase)

**The idea:** Start slow, grow fast to quickly find the network's capacity.

```
cwnd starts at 1 MSS.
Every time an ACK is received → cwnd increases by 1 MSS.
(This means cwnd DOUBLES every round because a full window of ACKs arrives)

Round 0: cwnd = 1 → send 1 segment → receive 1 ACK → cwnd becomes 2
Round 1: cwnd = 2 → send 2 segments → receive 2 ACKs → cwnd becomes 4
Round 2: cwnd = 4 → send 4 segments → receive 4 ACKs → cwnd becomes 8
Round 3: cwnd = 8 → reaches ssthresh (e.g., 8) → STOP Slow Start

Growth: 1 → 2 → 4 → 8 (DOUBLES each round = EXPONENTIAL)
```

> **In the slow-start algorithm, the size of the congestion window increases exponentially until it reaches a threshold.**

### Phase 2: Congestion Avoidance (Additive Increase)

When cwnd reaches ssthresh, slow start stops. Now we grow more carefully.

```
Instead of doubling, cwnd increases by 1 MSS per round (no matter how many ACKs):

Round 3: cwnd = 8 (ssthresh reached)
Round 4: cwnd = 9 (8+1)
Round 5: cwnd = 10 (9+1)
Round 6: cwnd = 11 (10+1)
...

Growth: 8 → 9 → 10 → 11 → 12 (adds 1 per round = LINEAR = ADDITIVE)
```

> **In the congestion avoidance algorithm, the size of the congestion window increases additively until congestion is detected.**

### Phase 3: Congestion Detection (Multiplicative Decrease)

Congestion is detected in TWO ways, with DIFFERENT responses:

```
CASE 1 — TIMEOUT (serious congestion):
  A packet was sent, NO ACK received within the time limit.
  Packet was dropped (serious sign).

  Response: SEVERE!
  → ssthresh = cwnd / 2
  → cwnd = 1 (reset to beginning!)
  → Start Slow Start again from cwnd=1

CASE 2 — 3 DUPLICATE ACKs (mild congestion):
  Received the same ACK 3 times → a specific packet was lost,
  but other packets ARE getting through (network still working).

  Response: MODERATE!
  → ssthresh = cwnd / 2
  → cwnd = ssthresh (NOT reset to 1!)
  → Skip to Congestion Avoidance immediately
```

### Full Example: cwnd=1, ssthresh=16

```
Round │ cwnd  │ Phase               │ Rule
──────┼───────┼─────────────────────┼────────────────────
  0   │   1   │ Slow Start          │ initial
  1   │   2   │ Slow Start          │ ×2
  2   │   4   │ Slow Start          │ ×2
  3   │   8   │ Slow Start          │ ×2
  4   │  16   │ Slow Start→CA here  │ ×2 = ssthresh
  5   │  17   │ Congestion Avoidance│ +1
  6   │  18   │ Congestion Avoidance│ +1
  7   │  19   │ Congestion Avoidance│ +1
  8   │  20   │ ← TIMEOUT here!     │ +1
  ─── │ ──── │ ─────────────────── │ ────────────────────
         ssthresh = 20/2 = 10
         cwnd = 1 (reset)
  9   │   1   │ Slow Start again    │ reset
 10   │   2   │ Slow Start          │ ×2
 11   │   4   │ Slow Start          │ ×2
 12   │   8   │ Slow Start          │ ×2
 13   │  10   │ → CA here           │ reaches new ssthresh
 14   │  11   │ Congestion Avoidance│ +1
 15   │  12   │ Congestion Avoidance│ +1
```

---

### KEY POINTS FOR EXAM — CONGESTION CONTROL

```
✅ Open Loop = PREVENT (before congestion)
✅ Closed Loop = REMOVE (after congestion)
✅ Backpressure: hop-by-hop backward, intermediate nodes affected
✅ Choke Packet: directly to source, intermediate nodes NOT warned
✅ Implicit: source guesses from timeout/dup ACKs (TCP uses this)
✅ Explicit: congested node sets a bit in a packet
✅ Slow Start: cwnd doubles each round (×2, exponential)
✅ Congestion Avoidance: cwnd +1 per round (linear, starts at ssthresh)
✅ Timeout: ssthresh=cwnd/2, cwnd=1, restart Slow Start
✅ 3 dup ACKs: ssthresh=cwnd/2, cwnd=ssthresh, skip to CA
✅ Actual window = min(cwnd, rwnd)
```

---

---

# CHAPTER 4: QUALITY OF SERVICE (QoS)

---

## 4.1 What is QoS?

Quality of Service means "how well does the network meet the needs of a specific application?"

Different applications have different requirements:
- A phone call needs low delay but can tolerate minor packet loss
- An email needs perfect accuracy but doesn't care about delay
- A video game needs low and consistent delay
- A file download needs high bandwidth

QoS is about identifying and meeting these needs.

---

## 4.2 The Four Flow Characteristics

### 1. Reliability

**What it means:** Does every single packet reach the destination correctly?

**Analogy:** Imagine paying a courier to deliver a contract. You need EVERY page to arrive perfectly. If even one page is missing → the contract is invalid.

**Applications that need HIGH reliability:** Email, file transfer, web pages, banking transactions
**Applications that can tolerate LOW reliability:** Voice calls, live video streaming (a few dropped frames are barely noticeable)

### 2. Delay

**What it means:** How long does it take for a packet to travel from source to destination?

**Analogy:** When you're on a phone call, you speak and the other person should hear you almost instantly. If there's a 2-second delay → awkward pauses → terrible conversation.

**Applications that need LOW delay (real-time):** VoIP, video conferencing, online gaming, live streaming
**Applications that tolerate HIGH delay:** Email, file download, web browsing (within reason)

### 3. Jitter

**What it means:** The **variation** in delay. Are packets arriving at consistent intervals, or are they arriving unpredictably?

**Analogy:** Imagine a bus that should come every 10 minutes. If it comes at exactly 10 minutes each time → good (low jitter). If it comes at 8 min, then 15 min, then 3 min → terrible experience (high jitter).

```
Low Jitter (good for real-time):
Packet 1 departs at time 0, arrives at time 20ms
Packet 2 departs at time 1, arrives at time 21ms
Packet 3 departs at time 2, arrives at time 22ms
→ All experience same 20ms delay. Consistent. ✓

High Jitter (bad for real-time):
Packet 1 departs at time 0, arrives at time 20ms
Packet 2 departs at time 1, arrives at time 35ms
Packet 3 departs at time 2, arrives at time 15ms
→ Varying delays → audio/video breaks up ✗
```

**Jitter = max delay − min delay in a flow**

**Applications sensitive to jitter:** Audio/video conferencing, online gaming
**Applications not affected by jitter:** Email, file transfer

### 4. Bandwidth

**What it means:** How much data can be transmitted per unit of time (measured in Mbps, Gbps)?

**Analogy:** A wider highway allows more cars simultaneously. A wider "pipe" allows more data.

**Applications needing HIGH bandwidth:** 4K video streaming, video conferencing, large file transfers
**Applications needing LOW bandwidth:** Text email, chat messages, VoIP (voice uses surprisingly little bandwidth)

### Flow Characteristics Summary Table

| Application | Reliability | Delay | Jitter | Bandwidth |
|-------------|------------|-------|--------|-----------|
| Email/File Transfer | ★★★ HIGH | ★ LOW | ★ LOW | ★★ Medium |
| Voice/VoIP | ★ LOW | ★★★ LOW | ★★★ LOW | ★ Low |
| Video Conference | ★★ Medium | ★★★ LOW | ★★★ LOW | ★★★ HIGH |
| Online Gaming | ★★ Medium | ★★★ LOW | ★★★ LOW | ★ Low |
| Web Browsing | ★★★ HIGH | ★★ Medium | ★ LOW | ★★ Medium |

---

## 4.3 Leaky Bucket Algorithm

### The Real-Life Analogy

Imagine a bucket with a small hole at the bottom. Water (data) pours in from the top. No matter how fast water pours IN, water drips OUT at the same steady rate (determined by the hole size).

- **Input:** Can be bursty (pour quickly, then stop, then pour again)
- **Output:** Always constant (determined by the hole/rate)
- **Bucket overflows:** If you pour too fast for too long → water overflows → data is **dropped**

This is how the **Leaky Bucket Algorithm** works:

```
                     ┌──────────────────────────────────┐
Bursty Input:        │ Bucket (buffer)                  │
12 Mbps ────────────►│ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓               │
then 0 Mbps          │ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓               │
then 5 Mbps          │ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ (fills up)   │
                     │                                  │
                     └──────────┬───────────────────────┘
                                │ Constant output: 3 Mbps
                                ▼
Fixed Rate Output ─────────────► Network (smooth, constant)
```

### How It Works for Variable-Length Packets

```
1. Initialize counter n at each clock tick (n = max bytes per tick)
2. If packet size ≤ n: SEND the packet, decrement counter by packet size
3. If packet size > n: WAIT for next tick (or discard if bucket full)
4. Reset counter at next tick
```

### Leaky Bucket Example

Committed rate = 3 Mbps. Host sends: 12 Mbps for 2 seconds, silence for 3 seconds, 1 Mbps for 5 seconds.

```
Time  │ Input     │ Bucket state  │ Output    │ Notes
──────┼───────────┼───────────────┼───────────┼──────────────────────
0-1s  │ 12 Mbits  │ Fills: 12-3=9 │ 3 Mbits   │ Bucket starts filling
1-2s  │ 12 Mbits  │ 9 + 12 - 3   │ 3 Mbits   │ OVERFLOW! Drops excess
2-3s  │ 0 Mbits   │ Drains: -3   │ 3 Mbits   │ Bucket draining
3-4s  │ 0 Mbits   │ More drain   │ 3 Mbits   │ Continuing to drain
4-5s  │ 0 Mbits   │ May be empty │ ≤3 Mbits  │ Almost empty
5-10s │ 1 Mbit/s  │ Input < rate │ 1 Mbit/s  │ Output = Input (bucket empty)
```

**Key Properties of Leaky Bucket:**
- **Smooths bursty traffic** into constant-rate output
- **Drops packets** if bucket overflows (input too bursty for too long)
- Does NOT reward idle time (unused capacity is wasted)

### Token Bucket vs Leaky Bucket

```
LEAKY BUCKET:          TOKEN BUCKET:
┌──────────┐           ┌──────────┐
│ ▓▓▓▓▓▓▓ │ ← data    │ ●●●●●●● │ ← tokens added at rate r
│ ▓▓▓▓▓▓▓ │           │ ●●●●●●● │
└────┬─────┘           └──────────┘
     │ constant rate       each token allows 1 packet
     ▼                    idle time → tokens accumulate → burst allowed!
Output always fixed     Output can BURST up to bucket size!

Leaky bucket: "You can only go 60 km/h — always"
Token bucket: "You can accumulate speed credits when idle → burst later"
```

**The leaky bucket algorithm shapes bursty traffic into fixed-rate traffic by averaging the data rate. It may drop packets if the bucket is full.**

---

### KEY POINTS FOR EXAM — QoS

```
✅ Four flow characteristics: Reliability, Delay, Jitter, Bandwidth
✅ Real-time apps (VoIP, gaming): need LOW delay, LOW jitter
✅ Data transfer apps (email, FTP): need HIGH reliability
✅ Jitter = variation in delay (bad for audio/video)
✅ Leaky Bucket: smooths bursty traffic, constant output, drops on overflow
✅ Token Bucket: allows controlled bursting (tokens accumulate when idle)
✅ Leaky Bucket output rate = committed rate (always fixed)
✅ Scheduling techniques: FIFO, Priority Queuing, Weighted Fair Queuing
```

---

---

# CHAPTER 5: TCP — THREE-WAY HANDSHAKING

---

## 5.1 What is TCP?

TCP (Transmission Control Protocol) is a **connection-oriented, reliable** transport protocol. Unlike UDP (which just fires packets and hopes for the best), TCP:

- **Establishes a connection** before sending data
- **Guarantees delivery** (retransmits lost packets)
- **Ensures order** (reassembles out-of-order packets)
- **Controls flow** (doesn't overwhelm the receiver)
- **Terminates the connection** gracefully

TCP connection is **virtual** (not physical). The two computers just agree on states and sequence numbers. The underlying IP layer is still connectionless.

### Understanding Sequence Numbers

Every byte of data in TCP has a **sequence number**. This is how TCP tracks order and detects loss.

```
Imagine the data as a sequence of numbered packages:
[1][2][3][4][5][6][7][8][9][10]...

If package 5 is lost → sender retransmits only package 5
Receiver reassembles in correct order regardless of arrival order
```

**ACK number** = the sequence number the receiver EXPECTS next.
If receiver got bytes 1-500 → ACK = 501 (expecting byte 501 next)

---

## 5.2 Phase 1: Connection Establishment (Three-Way Handshake)

### The Analogy

Imagine two people starting a phone call:
1. Ali calls: "Hello, can you hear me?"
2. Sara replies: "Yes, I can hear you. Can you hear me?"
3. Ali says: "Yes, I can hear you too. Let's talk."

This mutual confirmation is the three-way handshake.

### The Three Steps

```
Host A (192.168.1.2)                          Server B (203.0.113.1)
         │                                              │
         │  ──── Segment 1: SYN ──────────────────────►│
         │  SYN=1, ACK=0                               │ B enters SYN_RECEIVED state
         │  seq = 8000  ← A's Initial Sequence Number  │
         │  (no data, but "consumes" seq# 8000)        │
         │                                              │
         │  ◄─── Segment 2: SYN + ACK ──────────────── │
         │  SYN=1, ACK=1                               │
         │  seq = 15000  ← B's Initial Sequence Number │
         │  ack = 8001   ← "I got your seq 8000, send 8001 next"
         │                                              │
         │  ──── Segment 3: ACK ──────────────────────►│
         │  SYN=0, ACK=1                               │ Connection ESTABLISHED ✓
         │  seq = 8001   ← (same, ACK doesn't consume) │
         │  ack = 15001  ← "I got your seq 15000, send 15001 next"
```

### Why is it THREE-WAY?

Because both sides need to:
1. **Send** their Initial Sequence Number (ISN) — so the other side knows where data starts
2. **Receive confirmation** that the other side got their ISN

Steps 1 and 2 handle A's ISN (A sends it, B confirms it).
Steps 2 and 3 handle B's ISN (B sends it, A confirms it).

One segment (Segment 2 = SYN+ACK) cleverly serves BOTH purposes — it's B's SYN and B's ACK for A's SYN at the same time.

### Sequence Number Rules for Establishment

```
╔═══════════════════════════════════════════════════════════════════════╗
║  RULE 1: A SYN segment cannot carry data, but CONSUMES 1 sequence#  ║
║  RULE 2: A SYN+ACK cannot carry data, but CONSUMES 1 sequence#      ║
║  RULE 3: An ACK (with no data) consumes NO sequence number           ║
╚═══════════════════════════════════════════════════════════════════════╝
```

**Memory trick:** SYN and FIN consume sequence numbers (like 1 imaginary byte). Pure ACK does not.

---

## 5.3 Phase 2: Data Transfer

After the connection is established, both sides can send data in **both directions simultaneously** (full-duplex).

### Data Transfer Example

Continuing from above: A's next seq = 8001, B's next seq = 15001.
A sends 2000 bytes in two segments. B sends 2000 bytes in one segment.

```
Host A                                              Server B
  │                                                    │
  │ ── Seg 4 (DATA: 1000 bytes) ─────────────────────►│
  │ seq=8001, ack=15001, PSH=1, ACK=1                 │
  │ data bytes: 8001 to 9000                          │
  │                                                    │
  │ ── Seg 5 (DATA: 1000 bytes) ─────────────────────►│
  │ seq=9001, ack=15001, PSH=1, ACK=1                 │
  │ data bytes: 9001 to 10000                         │
  │                                                    │
  │        ◄── Seg 6 (DATA: 2000 bytes) + ACK ────────│
  │        seq=15001, ack=10001, PSH=1, ACK=1         │
  │        data bytes: 15001 to 17000                 │
  │        ack=10001 → "got bytes 8001-10000 from A" │
  │                                                    │
  │ ── Seg 7 (ACK only) ─────────────────────────────►│
  │ seq=10000, ack=17001                              │
  │ "got bytes 15001-17000 from B"                    │
```

### Important Data Transfer Concepts

**PSH Flag (Push):** When the sender sets PSH=1, it tells the receiver: "Deliver this data to the application immediately, don't wait for more data to buffer." Used for interactive applications like telnet.

**Urgent Data:** The URG flag marks data that should be processed OUT OF ORDER (immediately). The URG pointer field indicates where urgent data ends. Used when a program needs to send an abort command while other data is being processed.

**ACK piggybacking:** ACKs can be included in DATA segments (instead of sending separate ACK packets). This is efficient.

---

## 5.4 Phase 3: Connection Termination (Three-Way Handshake)

### The Analogy

Ending a phone call:
1. Ali: "I'm done talking. Goodbye." → sends FIN
2. Sara: "Okay, goodbye too." → sends FIN+ACK
3. Ali: "Got it." → sends ACK

### Three-Way Termination

```
Host A (active close)                            Server B (passive close)
  │                                                    │
  │ ── Seg 1: FIN + ACK ──────────────────────────── ►│
  │ FIN=1, ACK=1                                      │
  │ seq = x,  ack = y                                 │
  │ [FIN with no data consumes 1 seq#]                │
  │                                                    │
  │ ◄── Seg 2: FIN + ACK ──────────────────────────── │
  │ FIN=1, ACK=1                                      │
  │ seq = y,  ack = x+1                               │ B says: "got your FIN (x), I'm done too"
  │ [FIN+ACK with no data consumes 1 seq#]            │
  │                                                    │
  │ ── Seg 3: ACK ────────────────────────────────── ►│ Connection
  │ ACK=1                                             │ TERMINATED ✓
  │ seq = x,  ack = y+1                               │
  │ [pure ACK, NO seq# consumed]                      │
```

### Sequence Number Rules for Termination

| Segment | Type | Consumes Seq#? | Why |
|---------|------|---------------|-----|
| Seg 1 | FIN + ACK | **YES +1** | FIN = 1 imaginary byte |
| Seg 2 | FIN + ACK | **YES +1** | FIN = 1 imaginary byte |
| Seg 3 | ACK only | **NO** | Pure ACK |

> **THE FIN SEGMENT CONSUMES ONE SEQUENCE NUMBER IF IT DOES NOT CARRY DATA.**

---

## 5.5 Half-Close

**What is it?** TCP allows ONE side to stop SENDING while still RECEIVING. This is called a half-close.

**When is it needed?** When a server needs to receive ALL data from the client before it can respond. Classic example: **sorting service**.

```
SORTING EXAMPLE:
Client has 10,000 records to sort. Sends them ALL to Server.
Server needs ALL records before sorting can begin.

PROBLEM: If client closes the connection after sending → Server can't send results back.
SOLUTION: Half-close — client closes its SENDING direction, keeps RECEIVING direction open.

Client ──── [sends all records] ──────────────────────────► Server
Client ──── [FIN] (closing C→S direction) ───────────────► Server
Client ◄─── [ACK] ──────────────────────────────────────── Server
                         [Server sorts...]
Client ◄─── [sends sorted results] ─────────────────────── Server
Client ──── [ACKs] ──────────────────────────────────────► Server
Client ◄─── [FIN] (closing S→C direction) ───────────────── Server
Client ──── [ACK] ───────────────────────────────────────► Server
                                                  FULLY CLOSED ✓
```

After client's FIN: Client **CANNOT** send data, but **CAN** receive data from Server.

---

## 5.6 SYN Flooding Attack

### How the Attack Works

A malicious attacker exploits the three-way handshake:
1. Attacker sends THOUSANDS of SYN packets with **fake (spoofed) source IPs**
2. Server sends SYN+ACK to each fake IP → **no real ACK ever comes back**
3. Server allocates resources for each "pending" connection (memory, timers, ports)
4. Server's connection table fills up completely
5. **Legitimate users cannot connect → Denial of Service (DoS)**

```
ATTACKER                              SERVER
   │                                     │
   │ SYN (fake IP: 1.1.1.1) ──────────►│ [allocates resources, starts timer]
   │ SYN (fake IP: 2.2.2.2) ──────────►│ [allocates resources, starts timer]
   │ SYN (fake IP: 3.3.3.3) ──────────►│ [allocates resources, starts timer]
   │  ... thousands more ...             │
   │                                     │ [TABLE FULL! Can't accept more!]
   │                                     │
REAL USER attempts to connect ─────────► REFUSED! No resources left
```

### SYN Cookie Defense

1. Server does **NOT** allocate resources when receiving a SYN
2. Server encodes all connection info into a **cryptographic hash** (cookie)
3. Server puts this cookie in the **seq number** of SYN+ACK
4. Only when **real ACK comes back** (with cookie+1 in ack field):
   - Server verifies the cookie
   - Server **then** allocates resources
5. Spoofed SYN packets never complete → no resources wasted ✓

---

### KEY POINTS FOR EXAM — TCP HANDSHAKING

```
✅ Three-way handshake: SYN → SYN+ACK → ACK
✅ SYN consumes 1 sequence number (imaginary byte)
✅ SYN+ACK consumes 1 sequence number
✅ ACK with no data consumes 0 sequence numbers
✅ FIN consumes 1 sequence number (same as SYN)
✅ ack = (received seq) + 1 for SYN/FIN
✅ ack = (received seq) + (bytes received) for data
✅ Connection termination: FIN → FIN+ACK → ACK
✅ Half-close: one direction closed, other still open
✅ SYN flooding: fake SYNs exhaust server resources
✅ SYN cookie: server allocates resources only after verifying ACK
✅ Simultaneous open: both TCPs send SYN+ACK → one connection established
```

---

---

# COMPLETE SUMMARY — EXAM CHEAT SHEET

---

## ARP/RARP Quick Facts
- ARP: IP→MAC | RARP: MAC→IP
- Both: Request=BROADCAST, Reply=UNICAST
- ARP packet = 28 bytes | Ethernet type = 0x0806 (ARP), 0x8035 (RARP)
- Operations: ARP-Req=1, ARP-Rep=2, RARP-Req=3, RARP-Rep=4
- Target HW Addr in ARP request = 00:00:00:00:00:00

## Routing Quick Facts
- Intradomain: RIP (DV), OSPF (LS) | Interdomain: BGP (Path Vector)
- DV: share table with neighbors | LS: flood LSP to everyone
- Count-to-infinity: DV problem | Fix: Split Horizon + Poison Reverse
- RIP: UDP port 520, max 15 hops, 16=infinity
- RIP timers: Periodic(25-35s), Expiration(180s), Garbage(120s)
- Dijkstra: always pick minimum unvisited, update neighbors

## Congestion Quick Facts
- Open Loop=prevent | Closed Loop=remove
- Backpressure: hop-by-hop backward
- Choke Packet: directly to source (bypasses intermediate nodes)
- Implicit: TCP guesses from timeout/dup ACKs
- Slow Start: cwnd×2 per round (below ssthresh)
- Congestion Avoidance: cwnd+1 per round (at/above ssthresh)
- Timeout: ssthresh=cwnd/2, cwnd=1
- 3 dup ACKs: ssthresh=cwnd/2, cwnd=ssthresh

## QoS Quick Facts
- 4 characteristics: Reliability, Delay, Jitter, Bandwidth
- Real-time: needs low delay + low jitter
- Leaky Bucket: constant output, drops on overflow
- Token Bucket: allows bursting (tokens accumulate)

## TCP Quick Facts
- Connection: SYN → SYN+ACK → ACK
- SYN, SYN+ACK, FIN: consume 1 seq# each
- Data: consumes N seq# (N = bytes)
- Pure ACK: consumes 0 seq#
- Termination: FIN+ACK → FIN+ACK → ACK
- ack number = last received byte + 1

---

*End of Study Material — CSE405/ICE302 Computer Networks*
*East West University | Instructor: Md. Khalid Mahbub Khan*
*Good luck on your exam!*

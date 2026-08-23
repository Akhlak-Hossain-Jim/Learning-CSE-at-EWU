# Lecture 07: Firewalls — The Gatekeepers of Cybersecurity

**Course:** Cyber Security Engineering  
**Reference Sources:** Intellipaat, NIST Guidelines for Electronic Mail Security, Statista Market Insights, Adrian Cantrill Cloud Networking Architecture.

---

## 1. Introduction to Firewalls

A **firewall** is a network security system (hardware, software, or cloud-based) that acts as a protective barrier between an internal trusted network (such as a private Local Area Network / LAN) and external untrusted networks (such as the Internet).

### Primary Objectives:
- Monitor and control incoming and outgoing network traffic.
- Enforce pre-determined security rules, Access Control Lists (ACLs), and policies.
- Prevent unauthorized access, malware propagation, data exfiltration, and cyber attacks.

---

### Visual Explanation: High-Level Firewall Architecture

```
[ THE INTERNET ]  ────────►  ║  FIREWALL  ║  ────────►  [ HOME / CORPORATE NETWORK ]
  (Untrusted)               ║  (Barrier) ║               (Trusted Internal LAN)
```

#### Diagram Explanation:
- **Internet (Left):** Unsecured public network where malicious actors, port scans, and automated attacks originate.
- **Firewall (Center Brick Wall):** Inspects all incoming packets against defined policies, filtering out unauthorized traffic and allowing only legitimate packets.
- **Protected Network (Right):** Internal computers, laptops, and application servers shielded from direct exposure.

---

## 2. The Growing Need for Firewalls

### Key Drivers:
- **Protect sensitive assets:** Protect proprietary databases, personal data, and infrastructure from external intrusion.
- **Network Segmentation:** Isolate critical segments (e.g., finance, HR, production) to limit lateral movement.
- **Regulatory Compliance:** Satisfy standards including GDPR, HIPAA, PCI-DSS, and ISO 27001.

### Global Cybercrime Cost Projection (Statista Insights)
The estimated annual worldwide cost of cybercrime is rapidly increasing:
- **2018:** $0.86 Trillion
- **2019:** $1.16 Trillion
- **2020:** $2.95 Trillion
- **2021:** $5.49 Trillion
- **2022:** $7.08 Trillion
- **2023:** $8.15 Trillion
- **2024:** $9.22 Trillion
- **2025:** $10.29 Trillion
- **2026:** $11.36 Trillion
- **2027:** $12.43 Trillion
- **2028:** $13.82 Trillion
- *Critical Stat:* **60% of Small and Midsize Businesses (SMBs)** that suffer a major cyberattack go out of business within 6 months.

---

## 3. Major Types of Firewalls

```
                               ┌────────────────────────────────┐
                               │       Types of Firewalls       │
                               └───────────────┬────────────────┘
          ┌────────────────────────────────────┼────────────────────────────────────┐
          ▼                                    ▼                                    ▼
┌───────────────────┐                ┌───────────────────┐                ┌───────────────────┐
│   Network-Based   │                │    Host-Based     │                │    Cloud-Based    │
│     Firewalls     │                │     Firewalls     │                │   (FWaaS / WAF)   │
└───────────────────┘                └───────────────────┘                └───────────────────┘
```

### Detailed Breakdown:

| Feature | Network-Based Firewall | Host-Based Firewall | Cloud-Based Firewall (FWaaS) |
| :--- | :--- | :--- | :--- |
| **Deployment Location** | Network perimeter or internal segment boundaries | Installed directly on individual endpoints/hosts | Deployed in cloud infrastructure / SaaS |
| **Form Factor** | Dedicated hardware appliance (e.g., Cisco ASA) or virtual appliance | Software running on OS (e.g., Windows Defender, Norton, McAfee) | Virtual firewall / Managed cloud service (e.g., AWS WAF, Cloudflare) |
| **Primary Scope** | Whole network / subnet traffic | Single host / endpoint device | Distributed cloud workloads, microservices |
| **Key Advantages** | Centralized control, high throughput, protects all downstream nodes | Granular process/user filtering, protects endpoint outside office network | Auto-scalable, low upfront CAPEX, pay-as-you-go, multi-region coverage |
| **Disadvantages** | High cost, blind to lateral movement within the LAN and insider threats | Difficult to manage at enterprise scale without centralized MDM; relies on host OS integrity | Dependent on ISP connectivity; requires vendor trust |
| **Primary Use Case** | Corporate perimeter, Datacenter DMZ | Laptops of remote workers on public Wi-Fi | Kubernetes microservices, web apps |

---

## 4. Network DMZ (Demilitarized Zone) Architecture

A **DMZ** (Demilitarized Zone) is a physical or logical subnet that isolates public-facing services from the organization's internal private network.

### Visual Explanation: Dual-Firewall DMZ Layout

```
[ PUBLIC INTERNET ]
        │
        ▼
 ┌──────────────┐
 │ Border Router│ (with initial IP packet filters)
 └──────┬───────┘
        │
        ▼
 ╔═════════════════════════════════╗
 ║   PERIMETER / EXTERNAL FIREWALL ║
 ╚══════════════╤══════════════════╝
                │
    ┌───────────┴─────────────────────────┐
    │          DMZ SEGMENT                │
    │  [Public Web Server]  [DNS Server]  │
    │  [Mail Server]        [Extranet]    │
    └───────────┬─────────────────────────┘
                │
 ╔══════════════╧══════════════════╗
 ║   INTERNAL / BACKEND FIREWALL   ║
 ╚══════════════╤══════════════════╝
                │
    ┌───────────┴─────────────────────────┐
    │     PRIVATE INTERNAL INTRANET       │
    │  [Workstations]   [Databases]       │
    │  [Internal Files] [Print Servers]   │
    └─────────────────────────────────────┘
```

#### Diagram Explanation:
1. **Perimeter Firewall:** Sits between the Internet / Border Router and the DMZ. Allows external users to access designated public ports (e.g., Port 80/443 for Web, Port 25 for Mail, Port 53 for DNS).
2. **DMZ (Middle Tier):** Holds public-facing servers. If a web server in the DMZ is compromised, the attacker does not automatically gain access to the internal network.
3. **Internal Firewall:** Strictly inspects and restricts traffic traveling from the DMZ into the private corporate intranet. Databases and confidential user data remain shielded behind this second layer.

---

## 5. Packet-Filtering Firewalls (Stateless)

A packet-filtering firewall inspects individual data packets at **OSI Layer 3 (Network Layer)** and **OSI Layer 4 (Transport Layer)** against an **Access Control List (ACL)**.

### Packet Inspection Criteria:
- **Source IP Address:** Sender's IP.
- **Destination IP Address:** Target's IP.
- **Protocol:** IP protocol type (TCP, UDP, ICMP).
- **Source Port:** Ephemeral port of client.
- **Destination Port:** Target service port (e.g., 80 for HTTP, 443 for HTTPS, 22 for SSH).

### Network Header Structures Inspected:
1. **IPv4 Header (20–24 bytes):** Version, IHL, Type of Service, Total Length, Identification, Flags (DF, MF), Fragment Offset, TTL, Protocol, Header Checksum, Source IP, Destination IP, Options.
2. **TCP Segment Header (20+ bytes):** Source Port, Destination Port, Sequence Number, Acknowledgment Number, Data Offset, Reserved, Control Flags (URG, ACK, PSH, RST, SYN, FIN), Window Size, Checksum, Urgent Pointer.

### ACL Rule Evaluation Mechanism:
- Rules are evaluated **sequentially (top-to-bottom)**.
- **First Match Wins:** When a packet matches a rule's conditions, the specified action (`ALLOW` / `DENY` / `DROP`) is immediately executed, and subsequent rules are skipped.
- **Default Policy:**
  - *Default Deny (Whitelisting):* Packets not explicitly allowed are dropped (Standard best practice).
  - *Default Allow (Blacklisting):* Packets not explicitly blocked are permitted (Insecure).

### Sample ACL Table:
| Rule # | Source IP | Destination IP | Protocol | Port | Action |
|:---:|:---:|:---:|:---:|:---:|:---:|
| **Rule 1** | Any | 192.168.1.1 | TCP | 80 | Allow |
| **Rule 2** | 203.0.113.0/24 | Any | Any | Any | Deny |
| **Rule 3 (Default)** | Any | Any | Any | Any | Deny |

---

### Visual Explanation: Packet Inspection Flowchart

```
           [ START ]
               │
               ▼
    [ Read Packet Header ]
               │
               ▼
     [ Read Next ACL Rule ]
               │
               ▼
       / Rule Matched? \ ───── YES ────► [ Log Packet Details ]
       \               /                         │
               │ NO                               ▼
               ▼                         / Action == ALLOW? \
      / Has Next Rule? \                 \                  /
      \                /                   │ YES        │ NO (DENY/DROP)
        │ YES       │ NO                    ▼            ▼
        │           └───────────────► [ DROP PACKET ] [ FORWARD PACKET ]
        └─── (Loop to next rule)             │                 │
                                             └────────┬────────┘
                                                      │
                                                      ▼
                                                   [ END ]
```

---

## 6. Stateful Inspection Firewalls

A **Stateful Inspection Firewall** tracks the operating state of active network connections and maintains a dynamic **State Table** in memory.

### Key Capabilities:
- Does not inspect packets in isolation; it checks whether a packet is part of an existing, legitimate session.
- **TCP Three-Way Handshake Verification:**
  1. `SYN` (Client $\rightarrow$ Server): Request connection.
  2. `SYN-ACK` (Server $\rightarrow$ Client): Acknowledge request.
  3. `ACK` (Client $\rightarrow$ Server): Final handshake confirmation.
- **Automatic Return Traffic Handling:** When an internal host initiates an outbound request (e.g., visiting a website), the firewall dynamically allows the returning inbound response packets without requiring an explicit static inbound ACL opening.

---

### Visual Explanation: Stateful vs. Stateless Traffic Flow

```
 CLIENT (119.18.36.73:13337)                           SERVER (1.3.3.7:443)
      │                                                         │
      │ ─── OUTBOUND REQUEST (SRC: 119.18.36.73:13337, ────────► │ (Inbound from Server's view)
      │                       DST: 1.3.3.7:443)                 │
      │                                                         │
      │                 [ STATE TABLE ENTRY CREATED ]           │
      │       [119.18.36.73:13337 <-> 1.3.3.7:443 | ESTABLISHED]│
      │                                                         │
      │ ◄── INBOUND RESPONSE (SRC: 1.3.3.7:443, ──────────────── │ (Outbound from Server's view)
      │                       DST: 119.18.36.73:13337)          │
      ▼                                                         ▼
```

### Sample State Table Entry:
| Source IP | Destination IP | Protocol | Source Port | Dest Port | Connection State |
|:---:|:---:|:---:|:---:|:---:|:---:|
| 119.18.36.73 | 1.3.3.7 | TCP | 13337 | 443 | ESTABLISHED |

---

## 7. Comparison: Stateful vs. Stateless Firewalls

| Feature / Metric | Stateless Packet Filtering | Stateful Inspection Firewall |
| :--- | :--- | :--- |
| **Inspection Basis** | Individual packet headers in isolation | Connection state, context, and session history |
| **State Table** | No state tracking | Yes, dynamic in-memory state table |
| **TCP Handshake Verification** | No | Yes (verifies SYN, SYN-ACK, ACK sequence) |
| **Handling of Return Traffic** | Requires static open inbound ports | Automatically permitted for valid active sessions |
| **Performance / Overhead** | Extremely fast, very low RAM/CPU usage | Slightly higher CPU/RAM overhead due to state tracking |
| **Vulnerability to Floods** | Resistant to connection state exhaustion | Vulnerable to SYN Floods & State Table Exhaustion |
| **Security Level** | Basic / Low | High |
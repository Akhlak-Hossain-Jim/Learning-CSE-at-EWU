# Firewalls: The Gatekeepers of Cybersecurity [cite: 5]

**OUTLINE** [cite: 5]
* Overview [cite: 5]
* Types [cite: 5]
* Applications [cite: 5]

---

## Introduction to Firewalls [cite: 5]
* A firewall in computer networks is a security system or software that operates as a barrier between an internal network (such as a private local area network, LAN) and external networks (such as the internet). [cite: 5]
* Its primary purpose is to control and monitor incoming and outgoing network traffic based on a set of pre-determined security rules, policies, and configurations. [cite: 5]
* Firewalls help effectively manage network traffic and provide defense against potential threats, such as unauthorized access attempts, malware infiltration, and other cyber risks. [cite: 5]
* The working of a firewall involves it acting as a wall between the Internet and a Home Network. [cite: 5]

## Importance of Firewalls [cite: 5]
* Firewalls protect sensitive data from external threats. [cite: 5]
* They enforce network segmentation for better control. [cite: 5]
* They aid compliance with data protection laws (e.g., GDPR, HIPAA). [cite: 5]
* 60% of SMBs that suffer cyberattacks go out of business within six months. [cite: 5]
* Cybercrime is expected to skyrocket, with the estimated annual cost of cybercrime worldwide increasing from 0.86 trillion U.S. dollars in 2018 to a projected 13.82 trillion U.S. dollars in 2028. [cite: 5]

## Types of Firewalls [cite: 5]
* 1) Network-Based Firewalls [cite: 5]
* 2) Host-Based Firewalls [cite: 5]
* 3) Cloud-Based Firewalls (Firewall-as-a-Service or FWaaS) [cite: 5]

### 1) Network-Based Firewalls [cite: 5]
* A network-based firewall is deployed at the boundary of a network to control traffic between internal and external networks or between different internal segments. [cite: 5]
* It operates at higher throughput to handle traffic for the entire network. [cite: 5]
* It can be hardware-based (e.g., Cisco ASA) or virtualized (e.g., AWS Security Groups). [cite: 5]
* It inspects packets for allowed or denied traffic. [cite: 5]
* An advantage is that it provides centralized control over network traffic. [cite: 5]
* Another advantage is that it is ideal for enterprise environments with multiple devices. [cite: 5]
* A disadvantage is its high initial cost and maintenance requirements. [cite: 5]
* Another disadvantage is that it cannot secure individual devices from insider threats. [cite: 5]
* Examples include perimeter firewalls protecting corporate networks and internal segmentation firewalls isolating sensitive departments. [cite: 5]
* A common use case is a corporate office with public-facing servers in a DMZ. [cite: 5]
* In a DMZ setup, a Border Router with IP Filters connects the Internet to the DMZ, which contains resources like a Public Web Server, DNS Server, Mail Server, and Extranet Server, while an internal Firewall protects the Intranet. [cite: 5]

### 2) Host-Based Firewalls [cite: 5]
* A host-based firewall is installed on individual devices to monitor and control incoming and outgoing traffic specific to that device. [cite: 5]
* It operates at the device level and enforces security policies locally. [cite: 5]
* It can filter traffic based on applications, users, or processes. [cite: 5]
* An advantage is that it directly protects endpoints from external threats. [cite: 5]
* Another advantage is that it provides granular control specific to a device's needs. [cite: 5]
* A disadvantage is that it is not suitable for managing multiple devices due to complexity. [cite: 5]
* Another disadvantage is that it relies heavily on the host's operating system, which can be exploited. [cite: 5]
* Examples include Windows Defender Firewall and third-party solutions like Norton or McAfee. [cite: 5]
* A common use case is laptop firewalls for remote employees accessing public Wi-Fi. [cite: 5]

### 3) Cloud-Based Firewalls [cite: 5]
* A cloud-based firewall is deployed on cloud infrastructure to secure distributed and scalable environments. [cite: 5]
* It is often delivered as a managed service by cloud providers or third parties. [cite: 5]
* It operates in virtualized or hybrid environments. [cite: 5]
* It is scalable and integrates with other cloud-native tools. [cite: 5]
* It protects workloads across multiple regions and environments. [cite: 5]
* An advantage is scalability and flexibility to adapt to changing workloads. [cite: 5]
* Another advantage is low upfront costs through pay-as-you-go pricing models. [cite: 5]
* A disadvantage is the dependence on internet connectivity for functionality. [cite: 5]
* Another disadvantage is that it requires trust in the cloud provider for security and privacy. [cite: 5]
* Examples include AWS WAF (Web Application Firewall) and Cloudflare Firewall. [cite: 5]
* A common use case is protecting microservices in a Kubernetes environment. [cite: 5]

### Comparison Table [cite: 5]

| Feature [cite: 5] | Network-Based Firewall [cite: 5] | Host-Based Firewall [cite: 5] | Cloud-Based Firewall [cite: 5] |
| :--- | :--- | :--- | :--- |
| **Deployment** [cite: 5] | Network perimeter or segments [cite: 5] | Individual devices [cite: 5] | Cloud infrastructure [cite: 5] |
| **Use Case** [cite: 5] | Enterprise networks [cite: 5] | End-user devices [cite: 5] | Scalable cloud applications [cite: 5] |
| **Advantages** [cite: 5] | Centralized control [cite: 5] | Granular endpoint protection [cite: 5] | Scalability and low cost [cite: 5] |
| **Disadvantages** [cite: 5] | Expensive, not for insiders [cite: 5] | Difficult for multiple devices [cite: 5] | Dependence on provider [cite: 5] |

---

## Packet-Filtering Firewalls [cite: 5]
* A packet-filtering firewall inspects individual data packets as they traverse the network, applying rules based on header information to decide whether to allow or block the packet. [cite: 5]
* It operates primarily at the Network Layer (Layer 3) and Transport Layer (Layer 4) of the OSI model. [cite: 5]
* Mechanisms of Packet Filtering include Rule-Based Inspection, Stateless Filtering, Default Policies, and Rule Evaluation Order. [cite: 5]

### Rule-Based Inspection [cite: 5]
* The firewall uses a set of predefined rules, often referred to as Access Control Lists (ACLs), to filter packets. [cite: 5]
* Rules specify conditions based on Source IP address (where the packet originates). [cite: 5]
* Rules specify conditions based on Destination IP address (where the packet is headed). [cite: 5]
* Rules specify conditions based on Source Port (port number on the sender's machine). [cite: 5]
* Rules specify conditions based on Destination Port (target application/service port, e.g., HTTP on port 80). [cite: 5]
* Rules specify conditions based on Protocol (TCP, UDP, ICMP, etc.). [cite: 5]

### IP Packet and TCP Segment Headers [cite: 5]
* The IP Header is 24 bytes long and contains fields such as Version, Length, Service type, Packet Length, Identification, Fragment Offset, Time To Live, Transport, Header Checksum, Source IP Address, Destination IP Address, Options, and Padding. [cite: 5]
* The TCP Segment Header contains fields such as Source port number, Destination port number, Sequence number, Acknowledgement number, Window size, Checksum, Urgent pointer, Options/Padding, and Data. [cite: 5]

### ACL Rule Table [cite: 5]
* Defines rules to permit or deny network traffic based on parameters like IP address, port, and protocol. [cite: 5]
* Evaluated sequentially; the first matching rule applies. [cite: 5]

| Rule [cite: 5] | Source IP [cite: 5] | Destination IP [cite: 5] | Protocol [cite: 5] | Port [cite: 5] | Action [cite: 5] |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Rule 1 [cite: 5] | Any [cite: 5] | 192.168.1.1 [cite: 5] | TCP [cite: 5] | 80 [cite: 5] | Allow [cite: 5] |
| Rule 2 [cite: 5] | 203.0.113.0 [cite: 5] | Any [cite: 5] | Any [cite: 5] | Any [cite: 5] | Deny [cite: 5] |

### Packet Inspection Flow Against ACL Rules [cite: 5]
* The process begins by reading the header of the packet. [cite: 5]
* It then reads the filtering rule to see if there is a Rule Match. [cite: 5]
* If the rule matches, it logs the packet details and then determines if it is an Allow or Deny rule. [cite: 5]
* If it is an Allow rule, the firewall will Forward the packet. [cite: 5]
* If it is a Deny rule, the firewall will Drop the packet. [cite: 5]
* If the rule does not match, it checks if there is a next rule to evaluate. [cite: 5]
* If there is no next rule, it will automatically Drop the packet. [cite: 5]

### Stateless Filtering [cite: 5]
* Each packet is inspected independently, without context about previous packets. [cite: 5]
* The firewall does not track the state of connections or sessions. [cite: 5]
* Implication: Fast and efficient but lacks the ability to detect attacks that span multiple packets. [cite: 5]

### Default Policies [cite: 5]
* Packet-filtering firewalls implement a default policy to handle packets that don't match any rules. [cite: 5]
* Default Deny: Block all traffic unless explicitly allowed. [cite: 5]
* Default Allow: Permit all traffic unless explicitly denied (less secure). [cite: 5]

### Rule Evaluation Order [cite: 5]
* Rules are evaluated sequentially, from top to bottom in the ACL. [cite: 5]
* Once a rule is matched, no further rules are checked. [cite: 5]
* Example Rule Set: 1. Allow HTTP (port 80) traffic from any source to the internal web server. 2. Deny all traffic from specific malicious IP ranges. 3. Default Deny for all other traffic. [cite: 5]

---

## Stateful Inspection Firewalls [cite: 5]
* A stateful inspection firewall tracks the state of active connections and uses this context to determine whether incoming or outgoing packets should be allowed or blocked. [cite: 5]
* It examines not just individual packets but the relationship between packets in a connection. [cite: 5]
* It maintains a state table to record the status of each connection. [cite: 5]
* Analogy: Think of it as a security guard that remembers who entered the building and lets them exit without re-checking credentials. [cite: 5]

### Stateful vs Stateless Firewalls [cite: 5]
* Each connection consists of a REQUEST and a RESPONSE. [cite: 5]
* Directionality (INBOUND or OUTBOUND) depends entirely on the perspective (CLIENT or SERVER). [cite: 5]
* From the CLIENT perspective, a REQUEST is OUTBOUND and a RESPONSE is INBOUND. [cite: 5]
* From the SERVER perspective, a REQUEST is INBOUND and a RESPONSE is OUTBOUND. [cite: 5]

### Mechanism of Stateful Inspection [cite: 5]
* **Connection Tracking:** The firewall inspects the initial packet of a connection to check if it matches predefined rules. [cite: 5]
* If allowed, the connection's details (source/destination IP, port, protocol) are recorded in a state table. [cite: 5]
* **State Table:** A database of active connections that tracks information like Source and destination IP addresses, Protocol (e.g., TCP/UDP), and Connection state (e.g., established, terminated). [cite: 5]

| Source IP [cite: 5] | Destination IP [cite: 5] | Protocol [cite: 5] | Port [cite: 5] | State [cite: 5] |
| :--- | :--- | :--- | :--- | :--- |
| 10.0.0.1 [cite: 5] | 192.168.1.10 [cite: 5] | TCP [cite: 5] | 80 [cite: 5] | Established [cite: 5] |

* **Three-Way Handshake Verification (for TCP):** The firewall monitors the TCP handshake (1. SYN: Client requests connection, 2. SYN-ACK: Server acknowledges the request, 3. ACK: Client confirms the connection). [cite: 5]
* It only allows traffic after a valid handshake to prevent spoofed or unauthorized packets. [cite: 5]
* **Return Traffic:** Automatically allows return traffic (e.g., HTTP response) without re-checking rules because the state table recognizes it as part of an existing connection. [cite: 5]

### Advantages and Limitations [cite: 5]
* **Advantages** [cite: 5]
  * **Contextual Filtering:** Can block packets that are out of context or do not match the state of an established connection. [cite: 5]
  * **Security:** More secure than stateless firewalls as it prevents attacks exploiting individual packet filtering. [cite: 5]
  * **Efficiency for Established Connections:** Faster processing for return traffic, reducing overhead for repetitive checks. [cite: 5]
* **Limitations** [cite: 5]
  * **Resource-Intensive:** The state table requires memory and processing power, especially in high-traffic environments. [cite: 5]
  * **Complexity:** Requires proper configuration to prevent inadvertent blocking or opening of connections. [cite: 5]
  * **Vulnerable to State Table Exhaustion:** Attackers can flood the firewall with fake connections (e.g., SYN flood attacks) to overwhelm the state table. [cite: 5]

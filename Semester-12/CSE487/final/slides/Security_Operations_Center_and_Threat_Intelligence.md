# Security Operations Center (SOC) & Threat Intelligence (TI)

**Course / Presentation Details:**
* **Institution:** University of Frontier Technology, Bangladesh (UFTB)
* **Presenter:** Rakib Hossen, Assistant Professor, Dept. of Cyber Security Engineering (CySE), UFTB

---

## 1. Introduction to the Security Operations Center (SOC)

**Definition:** A Security Operations Center (SOC) is a centralized organizational unit and facility responsible for continuously monitoring, detecting, analyzing, and responding to cybersecurity threats across an enterprise infrastructure.

### Core SOC Functions:
* **Prevention & Proactive Monitoring:** 24/7 scanning of network perimeters, endpoints, and cloud assets.
* **Alert Management & Triage:** Aggregation, correlation, and filtering of security alerts to eliminate false positives.
* **Incident Response:** Systematic containment, eradication, and recovery from active attacks.
* **Log Management:** Centralized log ingestion, indexing, and compliance auditing.
* **Security Intelligence & Threat Hunting:** Integrating external threat feeds to identify zero-day or stealth campaigns.
* **Security Posture Refinement:** Continuous hardening and tuning of detection rules.

---

## 2. The Three Pillars of a SOC

```
                      +-----------------------------+
                      |  SECURITY OPERATIONS CENTER |
                      +-----------------------------+
                                     |
         +---------------------------+---------------------------+
         |                           |                           |
         v                           v                           v
  +--------------+            +--------------+            +--------------+
  |    PEOPLE    |            |   PROCESS    |            |  TECHNOLOGY  |
  | Tier 1, 2, 3 |            | SOPs, Alerts |            |  SIEM, SOAR  |
  | Analysts & IR|            |  Playbooks   |            |   EDR, TIP   |
  +--------------+            +--------------+            +--------------+
```

### 1. People (Hierarchical Tier Architecture)
* **Tier 1 (Triage Specialist):**
  * Ingests raw logs and continuously monitors SIEM/EDR consoles.
  * Conducts preliminary alert triage and false-positive filtering to reduce alert fatigue.
  * Escalates confirmed security events to Tier 2.
* **Tier 2 (Incident Responder):**
  * Conducts deep-dive investigations and scope analysis across affected systems.
  * Executes containment protocols (endpoint isolation, network ACL blocks) and system remediation.
* **Tier 3 (Threat Hunter / Expert):**
  * Proactively hunts for stealthy, undetected threats and advanced persistent threats (APTs).
  * Performs malware reverse engineering, vulnerability assessments, and penetration tests.
  * Refines SIEM detection rules and analytics models.
* **SOC Manager & Incident Response Coordinator:**
  * Oversees operational performance, metrics, staffing, and reports directly to the **CISO**.

### 2. Process (Standard Operating Procedures & Playbooks)
* **SOPs:** Documented operational workflows for alert handling, escalation matrices, and cross-team communication.
* **Incident Playbooks:** Actionable execution steps tailored to specific attack types (phishing, ransomware, brute-force, SQL injection).

### 3. Technology (Core SOC Stack)
* **SIEM (Security Information & Event Management):** Central log aggregation, correlation rules, and event visualization (e.g., Splunk, IBM QRadar, Wazuh).
* **SOAR (Security Orchestration, Automation, and Response):** Automated playbooks for rapid threat containment and workflow orchestration.
* **EDR / XDR (Endpoint / Extended Detection and Response):** Granular host visibility, behavioral anomaly detection, and endpoint remediation.
* **TIP (Threat Intelligence Platform):** Feeds real-time indicators of compromise (IoCs) and threat context into monitoring engines.

---

## 3. Technology Comparison: EDR vs. XDR

| Feature / Dimension | EDR (Endpoint Detection & Response) | XDR (Extended Detection & Response) |
|---|---|---|
| **Monitoring Scope** | Endpoints only (workstations, servers) | Multi-layered (endpoints, network, cloud, identity, email) |
| **Data Sources** | Host system logs and process telemetry | Integrated cross-telemetry feeds |
| **Visibility** | Device-level visibility | End-to-end holistic environment visibility |
| **Detection Focus** | Host-based anomalies and malware | Complex, multi-stage attack chains across domains |
| **Response Capability** | Endpoint isolation, process killing | Multi-vector remediation (firewall block, revoke token, isolate host) |
| **Deployment Complexity** | Moderate; agent-based | Higher; requires cross-platform API integration |

---

## 4. SOC Incident Response Lifecycle (7 Phases)

```
[ 01 Alert ] --------> [ 02 Triage ] --------> [ 03 Investigation ]
                                                       |
[ 06 Recovery ] <----- [ 05 Eradication ] <--- [ 04 Containment ]
       |
[ 07 Reporting & Continuous Improvement ]
```

1. **Phase 1 (Alert):** SIEM generates an alert triggered by correlation rules or threat intelligence matches.
2. **Phase 2 (Triage):** Tier 1 analyst validates alert authenticity, severity, and urgency.
3. **Phase 3 (Investigation):** Tier 2 analyst conducts forensic artifact analysis and timeline reconstruction.
4. **Phase 4 (Containment):** Network segmentation, credential revocation, and host isolation to halt lateral spread.
5. **Phase 5 (Eradication):** Purging malware artifacts, patching exploited vulnerabilities, and closing unauthorized backdoors.
6. **Phase 6 (Recovery):** Restoring systems from trusted backups and validating operational integrity.
7. **Phase 7 (Reporting & Improvement):** Post-incident reviews, updating playbooks, and tuning detection logic.

---

## 5. Threat Intelligence (TI) Foundations

**Definition:** The disciplined process of gathering, analyzing, and applying actionable data regarding adversary motives, capabilities, and IoCs to strengthen defensive decisions.

### 4 Types of Threat Intelligence:

```
                      HIGH COMPLEXITY
                            ^
                            |
   Strategic Intelligence   |   Tactical Intelligence
   (Executive decisions,    |   (Real-time IoC blocking,
    long-term focus)        |    short-term tactical defense)
  --------------------------+---------------------------> LONG-TERM FOCUS
   Technical Intelligence   |   Operational Intelligence
   (Specific malware tools, |   (Attacker TTPs, campaign
    signatures & hashes)    |    tracking & motivations)
                            |
                            v
                      LOW COMPLEXITY
```

1. **Strategic:** High-level trends and business impact tailored for CISOs, board members, and executives.
2. **Tactical:** Direct tactical threat indicators (IoCs, signatures) for Tier 1/2 automated blocking.
3. **Operational:** Context around adversary campaigns, motivations, and attack vectors for incident responders.
4. **Technical:** Specific technical artifacts, malware compiler tools, and exploit details used by researchers.

---

## 6. Threat Modeling Frameworks & Indicators

### The Pyramid of Pain (David Bianco)

```
              /\
             /  \    TTPs (Tactics, Techniques & Procedures)   [TOUGH]
            /----\
           /      \   Tools (Mimikatz, Cobalt Strike)           [CHALLENGING]
          /--------\
         /          \  Network / Host Artifacts                  [ANNOYING]
        /------------\
       /              \ Domain Names                             [SIMPLE]
      /----------------\
     /                  \ IP Addresses                           [EASY]
    /--------------------\
   /                      \ Hash Values (SHA-256, MD5)           [TRIVIAL / EASY]
  +------------------------+
```

* **TTPs (MITRE ATT&CK):**
  * **Tactics:** The attacker's operational goal (e.g., Initial Access, Privilege Escalation).
  * **Techniques:** The method used to achieve the goal (e.g., Phishing, Pass-the-Hash).
  * **Procedures:** The exact step-by-step implementation observed in real-world attacks.

### Threat Intelligence Data Formats:
* **STIX (Structured Threat Information Expression):** Standardized structured language for threat data representation.
* **TAXII (Trusted Automated Exchange of Intelligence Information):** Application protocol for transporting STIX threat data over HTTPS.

---

## 7. SOC Operational Challenges & Common Use Cases

### Major Challenges:
* **Alert Fatigue:** High volume of alerts causing critical threats to be overlooked.
* **Skills Shortage:** Scarcity of qualified Tier 2/3 analysts and reverse engineers.
* **High Infrastructure Costs:** Expensive licensing and computational storage for multi-terabyte log retention.

### Standard SOC Correlation Rules Matrix:

| Use Case | Primary Telemetry Sources | Alert Condition Criteria | Action Taken |
|---|---|---|---|
| **Botnet Activity** | Firewall, IDS, DNS, Proxy | Outbound connection to known C2 domain | Display on active channel; auto-block IP |
| **Virus Outbreak** | Endpoint Antivirus / EDR | $\ge 3$ distinct infected endpoints within 10 min | Page desktop support; isolate infected hosts |
| **SQL Injection** | WAF, Web Server Logs | $\ge 5$ injection signatures in a short window | Block source IP on WAF; alert Tier 2 |
| **Brute Force** | Active Directory, VPN | Multiple failed logins followed by success | Lock account; trigger MFA step-up verification |

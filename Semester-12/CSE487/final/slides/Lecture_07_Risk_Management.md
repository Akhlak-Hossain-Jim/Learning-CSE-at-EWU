# Information Security Risk Management & Quantitative Analysis

**Course / Presentation Details:**
* **Subject:** Information Security Risk Management
* **Institution:** University of Frontier Technology, Bangladesh (UFTB)
* **Presenter:** Rakib Hossen, Assistant Professor, Dept. of Cyber Security Engineering (CySE), UFTB

---

## 1. Foundations of Information Assurance (IA)

```
                            [ INTEGRITY ]
                            /           \
             [ NON-REPUDIATION ]     [ AVAILABILITY ]
                     \                 /
              [ CONFIDENTIALITY ] - [ AUTHENTICATION ]
                         \             /
                    =========================
                    5 PILLARS OF INFO ASSURANCE
```

### The 5 Core Pillars:
1. **Confidentiality:** Restricting data access strictly to authorized users and processes.
2. **Integrity:** Safeguarding information from unauthorized modification, deletion, or tampering.
3. **Availability:** Ensuring timely, reliable access to data and systems for authorized users.
4. **Authentication:** Verifying the claimed identity of users, devices, or system entities.
5. **Non-repudiation:** Cryptographic assurance that a party cannot deny sending or authorizing a transaction/message.

---

## 2. Core Risk Concepts & The Risk Formula

* **Asset:** Any valuable hardware, software, data, or personnel belonging to the organization.
* **Threat:** Any potential circumstance or event with the capacity to cause harm to a system.
* **Vulnerability:** An unpatched flaw, misconfiguration, or weakness in system defenses.
* **Risk:** The net negative consequence when a threat agent successfully exploits an active vulnerability.

### The Governing Risk Equation:
$$\text{Risk} = \text{Likelihood (Probability)} \times \text{Impact (Consequence)}$$

```
[ Threat Actor ] === exploits ===> [ Vulnerability ] === causes ===> [ Business Impact ]
        \                                                                   /
         +-----------------> [ SECURITY RISK LEVEL ] <---------------------+
```

---

## 3. End-to-End Risk Management Lifecycle

```
[ 1. Establish Context ]
           |
[ 2. Risk Identification ] <=====> [ Communication & Consultation ]
           |                                     |
[ 3. Risk Analysis ]                             |
           |                                     |
[ 4. Risk Evaluation ]                           |
           |                                     |
[ 5. Risk Treatment / Response ] <===============> [ Monitoring & Critical Review ]
```

### Risk Evaluation Matrix:

| Risk Likelihood | Low Impact (10) | Moderate Impact (50) | High Impact (100) |
|---|---|---|---|
| **High (1.0)** | Low Risk ($10$) | Moderate Risk ($50$) | **High Risk ($100$)** |
| **Medium (0.5)** | Low Risk ($5$) | Moderate Risk ($25$) | **Moderate Risk ($50$)** |
| **Low (0.1)** | Low Risk ($1$) | Low Risk ($5$) | **Low Risk ($10$)** |

* **Risk Score Scale:** Low ($1\text{ to }10$), Medium ($>10\text{ to }50$), High ($>50\text{ to }100$).

### 6 Negative Risk Treatment Responses:
1. **Avoid:** Eliminate the risk by removing the asset, disabling the vulnerable function, or altering project architecture.
2. **Mitigate:** Deploy security controls, firewalls, and patches to decrease likelihood or impact.
3. **Transfer:** Shift financial liability to a third party (e.g., purchasing cyber insurance, outsourcing hosting).
4. **Accept:** Acknowledge residual risk when the mitigation cost exceeds the potential loss.
5. **Contingency Plan:** Formulate disaster recovery and incident response playbooks for execution upon risk materialization.
6. **Management Action:** Implement operational process changes, training, or organizational restructuring.

---

## 4. Asset Inventory & Threat Mapping in Banking Systems

| Asset Category | Target Particulars | Criticality | Common Vulnerabilities | Associated Risk Scenarios |
|---|---|---|---|---|
| **Core Software** | Core Banking System (CBS), Switching Engine | **High** | Software bugs, unauthorized config changes | System outage, financial transaction error |
| **Applications** | Document Management, HR System, Portals | **High / Medium** | Missing input validation, unpatched code | Cross-site scripting, unauthorized data access |
| **Databases** | CBS Database, Device Credentials, Source Code | **High** | Default passwords, lack of encryption | Massive customer PII leak, credential theft |
| **Human Resources**| C-Suite, IT Ops, End-Users | **High / Medium** | Phishing susceptibility, low security awareness | Social engineering, insider threat, credential theft |

---

## 5. Quantitative Risk Analysis: DoS Financial Calculation

### Problem Scenario:
* **Weekly Enterprise Profit:** $20,000 / week
* **Attack Impact:** 40% reduction in weekly profit per DoS event
* **Incident Frequency:** 7 DoS attacks per year
* **Security Vendor Proposal:** $10,000 / month ($120,000 / year) subscription fee

### Step-by-Step Mathematical Computation:

1. **Calculate Annual Rate of Occurrence (ARO):**
   $$\text{ARO} = 7\text{ attacks/year}$$

2. **Calculate Single Loss Expectancy (SLE):**
   $$\text{SLE} = \text{Asset Value} \times \text{Exposure Factor}$$
   $$\text{SLE} = \$20,000 \times 0.40 = \mathbf{\$8,000 / \text{attack}}$$

3. **Calculate Annualized Loss Expectancy (ALE):**
   $$\text{ALE} = \text{SLE} \times \text{ARO}$$
   $$\text{ALE} = \$8,000 \times 7 = \mathbf{\$56,000 / \text{year}}$$

4. **Evaluate Mitigation Return on Investment (Cost-Benefit):**
   $$\text{Total Annual Mitigation Cost (TCO)} = \$10,000 \times 12 = \mathbf{\$120,000 / \text{year}}$$
   $$\text{Net Annual Financial Deficit} = \$56,000 - \$120,000 = \mathbf{-\$64,000}$$

### Financial Verdict:
* **Is it a good investment?** **No**, based strictly on online sales loss, because the annual cost of the mitigation service ($120,000) exceeds the expected annual loss ($56,000) by **$64,000**.

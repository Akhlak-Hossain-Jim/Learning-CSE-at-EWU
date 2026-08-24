# Cyber Asset Inventory & Risk Assessment – Classroom

## 1. Overview and Assessment Attributes

This document details the cybersecurity asset inventory, threat modeling, and risk assessment tailored for an educational classroom environment.

### Assessment Attributes Defined:
* **Cyber-related Devices (Assets):** Hardware, peripherals, and networking components utilized in the classroom.
* **Vulnerabilities:** Inherent flaws, weaknesses, misconfigurations, or procedural gaps.
* **Risks:** The potential adverse events or compromises resulting from exploited vulnerabilities.
* **Impact (Imp):** The magnitude of harm or disruption to classroom operations and data integrity (Rated: Low, Medium, High, Very High).
* **Likelihood:** The probability that a threat actor or event will exploit the vulnerability (Rated: Low, Medium, High, Very High).
* **Priority:** Overall criticality ranking computed from Impact × Likelihood:
  * **Critical:** Immediate action required.
  * **Very High:** Top priority remediation.
  * **High:** Important security focus.
  * **Medium:** Moderate risk; scheduled remediation.
  * **Low:** Acceptable risk profile; monitor periodically.
* **Controls (Mitigation):** Preventive, detective, and corrective countermeasures.
* **Motivation:** Attacker objectives (e.g., disruption, data exfiltration, administrative privilege).
* **Attack Types:** Methods and vectors utilized by threat actors.

---

## 2. Cyber Asset Risk Assessment Matrix

> **Visual/Table Representation:** The table below structures all 12 evaluated classroom asset categories against risk parameters, evaluation criteria, and actionable mitigations.

| # | Asset | Vulnerability | Risk | Impact | Likelihood | Priority | Control (Mitigation) | Motivation | Attack Type |
|---|---|---|---|---|---|---|---|---|---|
| **1** | **Teacher Computer** | • Weak or Reused Passwords<br>• No antivirus<br>• Outdated OS<br>• Admin rights<br>• Unsecured input ports<br>• Unsecured Peripheral Device<br>• Unsecured Wi-Fi<br>• Full Admin Privileges for Daily Use<br>• Lack of Screen Locking / Auto Logout<br>• No Antivirus or Endpoint Protection | Unauthorized access, malware infection, data theft | High | Medium | **High** | • Enforce strong passwords<br>• Restrict admin privileges<br>• Install endpoint protection/antivirus<br>• Apply regular OS updates<br>• Enforce auto-lock screens | Administrative control, access to grading and institutional data | Malware, phishing |
| **2** | **Student PCs** | • Weak or Reused Passwords<br>• No antivirus<br>• Outdated OS<br>• Admin rights<br>• Unsecured input ports & peripherals<br>• Unsecured Wi-Fi<br>• Full Admin Privileges for Daily Use<br>• Lack of Screen Locking / Auto Logout<br>• No Endpoint Protection | Malware spread across the local network, student data theft | High | High | **Very High** | • Install managed antivirus<br>• Implement unique user logins<br>• Enforce strict least-privilege user restrictions | Access to student records, peer tampering | Malware distribution, phishing campaigns |
| **3** | **Laptops / Tablets** | • Lost or stolen portable devices<br>• Unencrypted storage<br>• Unsecured input ports<br>• Unsecured Wi-Fi<br>• No antivirus<br>• Shared user logins | Data breach, unauthorized local and remote access | High | High | **Very High** | • Full disk encryption (BitLocker/FileVault)<br>• Strong password/biometric policies<br>• Remote wipe and MDM integration | Access to personal and student data | Physical theft, data leakage |
| **4** | **Wi-Fi Router** | • Default credentials<br>• Open network access<br>• Outdated firmware<br>• Weak or no encryption (WEP/WPA)<br>• Open/Guest networks without isolation<br>• Remote management enabled | Full network compromise, eavesdropping, rogue pivoting | Very High | High | **Very High** | • Change default admin credentials<br>• Deploy WPA3 Enterprise/WPA3 Personal<br>• Segment guest and classroom networks<br>• Disable remote web management<br>• Apply regular firmware updates | Intercepting all classroom network traffic | Man-in-the-Middle (MitM), packet sniffing |
| **5** | **Smartboard** | • Remote access enabled<br>• Poor update frequency<br>• Unsecured wireless/network access<br>• Default admin credentials<br>• Outdated firmware/software<br>• Unrestricted USB / HDMI ports | Unauthorized control, class disruption, malicious display hijacking | Medium | Medium | **Medium** | • Disable unused remote access features<br>• Secure network configurations<br>• Change default credentials<br>• Restrict physical port tampering | Classroom disruption, espionage/spying | Software exploitation, unauthorized broadcast |
| **6** | **Projector** | • Unsecured input ports<br>• Remote access enabled<br>• Poor update schedule<br>• Unsecured wireless access<br>• Default admin credentials<br>• Outdated firmware<br>• Unrestricted USB/HDMI ports | Display hijacking, inappropriate/offensive content display | Low | Medium | **Low** | • Restrict management access<br>• Physically protect access cables and input interfaces | Pranks, instructional disruption | Local signal injection, input takeover |
| **7** | **Printer / Scanner** | • Unencrypted network traffic<br>• Exposed network interfaces<br>• Stored document cache in memory<br>• Physical access to USB/SD slots | Sensitive printed data leakage, network pivoting | Medium | Medium | **Medium** | • Secure printing protocols (TLS/IPPS)<br>• Auto-clear cache and memory buffers<br>• Network access control lists (ACLs) | Access to printed exams, records, sensitive documents | Data exfiltration, buffer eavesdropping |
| **8** | **External HDDs** | • Lack of hardware/software encryption<br>• High risk of physical loss or theft | Stored data theft or total loss | High | Medium | **High** | • Enforce hardware-level or software encryption<br>• Physical lockbox / cabinet storage when not in use | Access to bulk backups, sensitive files | Physical theft, unauthorized data extraction |
| **9** | **USB Drives** | • Malware carrier risk<br>• No access control or encryption | Malware/ransomware propagation, data exfiltration | Very High | High | **Critical** | • Disable USB storage via Group Policy / MDM<br>• Enforce endpoint USB scanning before mounting<br>• User cyber hygiene education | Easy attack vector for network infiltration | Malware drops, automated virus injection, data theft |
| **10** | **Webcams** | • No physical privacy cover<br>• Vulnerable camera drivers<br>• Unrestricted software permissions | Unauthorized video surveillance, invasion of privacy | High | Low | **Medium** | • Deploy physical sliding covers<br>• Disable drivers or disconnect webcams when not in use | Privacy breach, student/teacher spying | Remote access Trojans (RAT), spyware |
| **11** | **Network Switch** | • Poor physical rack security<br>• Unauthenticated physical access | Network tampering, traffic sniffing, rogue device connection | Medium | Low | **Low** | • Lock physical server/network cabinets<br>• Monitor switch ports with 802.1X / Port Security | Access to internal LAN communication | Packet sniffing, physical tap insertion |
| **12** | **Microphones** | • Constantly active / listening<br>• Lack of hardware mute switch | Eavesdropping, unauthorized audio surveillance | Medium | Low | **Low** | • Ensure microphones are muted when inactive<br>• Physically disconnect external microphones | Audio espionage, privacy invasion | Audio hijacking, spyware eavesdropping |

---

## 3. Summary Recommendations & Action Plan

1. **Identity & Access Management:** Implement strict password complexity policies, eliminate shared accounts, and restrict daily administrative rights across all endpoints.
2. **Endpoint & Data Protection:** Enforce full-disk encryption and MDM remote-wipe capabilities on laptops and portable media; deploy centrally managed antivirus/EDR.
3. **Removable Media Restrictions:** Restrict or disable USB storage access via endpoint policies to prevent automated malware injection.
4. **Patch & Firmware Lifecycle:** Regularly update OS, applications, and network firmware (especially Wi-Fi routers, switches, and smartboards).
5. **Network Segmentation & Hardening:** Isolate guest networks from classroom subnets, enforce WPA3, disable default credentials, and lock physical network cabinets.
6. **Cyber Hygiene Training:** Conduct periodic security awareness training for teachers and students regarding phishing, auto-locking unattended screens, and physical device care.

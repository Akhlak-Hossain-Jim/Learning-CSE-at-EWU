# Introduction to Cyber Attacks

**University of Frontier Technology, Bangladesh**

**Presented By:**
* Rakib Hossen
* Assistant Professor
* Dept. of Cyber Security Engineering (CySE), UFTB

---

## What is "Attack" in Cyber Security
* Attacks = Motive (Goal) + Method + Vulnerability
* An attack is an information security threat that involves an attempt to obtain, alter, destroy, remove, implant or reveal information without authorized access or permission.
* By making use of address spoofing and packet forwarding, the attacker can discretely sniff network packets without disrupting the traffic flow between the two ends.

## Classification of Attack
* **Passive Attacks:** Passive attacks do not tamper with the data and involve intercepting and monitoring network traffic and data flow on the target network. Examples of passive attacks include sniffing and eavesdropping. In passive attacks, the attacker does not alter the information but observes and monitors it, copies it, and then uses it to interfere in the network traffics and attack targeted machines. Intruding and monitoring of information is the main motive behind a Passive attack.
* **Active Attacks:** Active attacks tamper with the data in transit or disrupt the communication or services between the systems to bypass or break into secured systems. Examples of active attacks include DoS, Man-in-the-Middle, session hijacking, and SQL injection. An Active attack attempts to alter system resources or affect their operations. Active attacks involve some modification of the data stream or the creation of false statements.
* **Close-in Attacks:** Close-in attacks are performed when the attacker is in close physical proximity with the target system or network in order to gather, modify, or disrupt access to information. Examples include social engineering such as eavesdropping, shoulder surfing, and dumpster diving. Attacker can take the advantages of being physically close to the target devices.
* **Insider Attacks:** Insider attacks involve using privileged access to violate rules or intentionally cause a threat to the organization's information or information systems. Examples include theft of physical devices and planting keyloggers, backdoors, and malware. An insider attack is an attack from inside users (a person with authorized system access), who use their access credentials and knowledge of the network to attack the target machines. Malicious insiders intentionally use their access to sensitive data to harm the company. Inadvertent insiders cause damage to the company unintentionally.
* **Distribution Attacks:** Distribution attacks occur when attackers tamper with hardware or software prior to installation. Attackers tamper with the hardware or software at its source or in transit. Distribution attacks are the attacks using backdoors introduced to hardware or software systems at the time of manufacture. Once the hardware or software became functional, attackers can leverage the backdoor to attack the target devices.

### Active Attack vs Passive Attack

| Active Attack | Passive Attack |
| :--- | :--- |
| Attacker needs to have control media or network. | Attacker observe the communication in media or network. |
| It can be easily detected. | It cannot be easily detected. |
| It affects the system. | It does not affect the system. |
| It involves modification in data. | It involves in monitoring in data. |
| It does not check for loopholes or vulnerabilities. | It scans the ports and network in search for loopholes and vulnerabilities. |
| It is difficult to prevent network from active attack. | Passive attack can be prevented. |
| Types of active attack: Masquerade, replay, denial of service, modification of message. | Types of passive attack: release of message content, Traffic analysis. |

---

## Model for Network Security
* Sender wants to send a message to the Recipient in a confidential manner through the Information Channel.
* The Information Channel is considered insecure in nature.
* Therefore, if some third party (shown as Opponent) somehow gets the message, it will not be legible to the Opponent (that is, opponent must not be able to get any meaningful information from the message).
* To achieve the goal, Sender performs some security-related transformation of the message (called Encryption) to convert the original message to a secure message.
* The Sender uses some secret information (called Key) for the conversion.
* Afterwards, Sender sends the message to the Recipient via the insecurity channel.
* Upon receipt, the Recipient performs another security-related transformation of the message (called Decryption) to convert the secure message to the original message.
* The Recipient uses some secret information (called Key) for the conversion.
* The secured message is such that even though some opponent collects it during the transit, it will not be readable (that is, it would be impossible to get any useful meaning from the secure message).
* Trusted Third Party is some kind of service or company that both Sender and Recipient trusts for their secure communications (e.g., arbiter, distributer of secret information).
* Most often, the Trusted Third Party sends a secret Key to both the Sender and Recipient via pre-established secure communication channels between itself and the Sender and Recipient.

## Model for Network Access Security
* Information System is a very important component of any organization or company.
* There may be some legitimate users who may need to access the information system from outside the organization's network through the Access Channel (such as, MAN, WAN, or Internet).
* This provides opportunities to the Opponents (human opponents such as cybercriminals/hackers, and software opponents such as virus, worms) to try to access the information system through the Access Channel.
* Gatekeeper Functions are installed at the entry point of the organization's network.
* Such Gatekeeper Functions can be configured in network and security devices and software, such as Routers, Firewalls, Intrusion Detection Systems (IDS), Intrusion Prevention Systems (IPS), and Gateways.
* The model involves Information system Computing resources (processor, memory, I/O), Data, Processes, Software, and Internal security controls.

---

## Types of Cyber Attacks (Overview)
* **Business Email Compromise:** A type of phishing scam.
* **Cross Site Scripting:** Exploiting web site vulnerabilities, lead to other malicious web sites.
* **Zero-Day Exploit:** Exploit vulnerabilities before being released security patches for that.
* **SQL Injection:** Exploiting application vulnerabilities, inject malicious SQL commands.
* **Malware:** Malicious software.
* **Phishing:** Sending e-mails which have the link to malicious web-site, impersonating legitimate.
* **Man in the Middle Attack:** Intercept data transfer by eavesdropping.
* **DoS/DDoS:** Continually bombarding a targeted network with fake requests.

### Chance Cyber Attacks
* Better Chance for Attackers arises from: AI, IoT, Big Data, Block Chain, Cloud Computing, AR & VR, OSINT.

### Trend of Cyber Attacks (Statistics)
* **Attack Distribution (Top 10 2019) from HACKMAGGEDON:**
  * Malware/PoS Malware: 39.3%
  * Account Hijacking: 16.7%
  * Unknown: 12.0%
  * Targeted Attack: 10.7%
  * Vulnerability: 5.1%
  * Malicious Script Injection: 3.7%
  * Malicious Spam: 1.8%
  * DoS/DDoS: 1.7%
  * Fake Accounts/Pages: 1.5%
  * Misconfiguration: 1.1%
  * Other: 6.5%
* **Distribution of Attacks August 2022 from HACKMAGGEDON:**
  * Malware: 38.9%
  * Unknown: 20.3%
  * Account Takeover: 14.7%
  * Vulnerability: 5.6%
  * Coordinated Inauthentic Behavior: 4.6%
  * Targeted Attack: 4.6%
  * DDoS: 4.6%
  * Other categories include: Business Email Compromise, Social Engineering, Brute force/Credential stuffing, Malicious Browser Extension, SQLi, Malicious Script Injection, Defacement, Scripting attack, Deepfake, DNS Hijacking.

### Impact of Cyber Attack
* Cyber-attack or Leaked data can have impact on companies such as Lost revenue, Reputational damage and Operational disruption.

### Understanding Cyber-attack Situation
* Attackers use platforms and directories like Insecam (online cameras), Exploit Database (archive of exploits and vulnerable software), and Shodan (search engine for internet-connected devices).
* **Cyber Attack Guide From Russian Hackers:** Examples include advanced hacking guides with Metasploit, Malware Development (RATs, botnets, Rootkits), converting exe into PDF/XLS/DOC/JPG, Exploit development guides, Tech Tricks (Spoofing SMS, email, call), downloading free Apple Apps, Credit Card Hacking, Netbanking Hacking (bypass Virtual Keyboard), spreading guides to infect 100K/Victims per day, Advanced Email Hacking Tricks, and SET (Social Engineering Toolkit) module.

---

## Detailed Classification of Cyber attacks
* A cyber-attack is an exploitation of computer systems and networks.
* It uses malicious code to alter computer code, logic or data and lead to cybercrimes, such as information and identity theft.
* Due to the dependency on digital things, the illegal computer activity is growing and changing like any type of crime.
* Cyber-attacks can be classified into two main categories: **Web-based attacks** and **System-based attacks**.

### 1. Web-based Attacks
* These are the attacks which occur on a website or web applications.
* Some of the important web-based attacks are: Injection attacks, Zero-Day Exploit, File Inclusion attacks, DNS Spoofing, Session Hijacking, Phishing, Brute force, Denial of Service (DoS), Dictionary attacks, URL Interpretation, Man in the middle attacks, Cross-site scripting, Distributed Denial of Service (DDoS) attacks, Password Attack, Cryptojacking, and Identity-Based Attacks.

**Specific Web-Based Attack Mechanisms:**
* **Injection Attack / SQL Injection:** This type of attack allows an attacker to inject code into a program or query or inject malware onto a computer in order to execute remote commands that can read or modify a database or change data on a web site. Hacker identifies vulnerable SQL-driven website & injects malicious SQL query via input data; malicious SQL query is validated & command is executed by database; Hacker is granted access to view and alter records or potentially act as database administrator.
* **DNS Spoofing:** A client requests a real website from the DNS Server, but an attacker injects a fake DNS entry into the server, causing the server to resolve the client's request to a Fake Website.
* **Session Hijacking:** An attacker impersonates a request by intercepting an innocent user's authentic request to a server.
* **Phishing:** Attacker sends phishing mail to target; Victim clicks on Phishing link and visits fake website; Hacker collects important credentials; Hacker uses victim's credentials to access private information on the original website.
* **Brute Force:** An attacker guesses a list of username and password combinations and repeats login attempts until one is successful for credential validation.
* **Denial of Service (DoS):** An attacker uses slaves (compromised devices) to target a victim server with requests.
* **Distributed Denial of Service (DDoS):** A Bot Master uses a command and control server to direct a Botnet (multiple attacks from multiple systems in distributed locations) against a victim application resource/server.
* **Dictionary Attacks:** A Bot takes a guess from a dictionary file, attempts to login to a targeted account/system, and if the guess is incorrect, it tries the next guess until successful.
* **URL Interpretation / DNS Poisoning:** Injecting fake DNS entries so requests to real websites resolve to fake websites.
* **Zero-Day Exploit:** (1) A security flaw exists but is unbeknown to developers, making it vulnerable to attacks. (2) A hacker discovers the vulnerability and exploits it by malware injection. (3) A cyberattack ensues from the malware, potentially resulting in data loss. (4) Developers detect the attack and have zero days to mitigate it.
* **File Inclusion Attacks:** (1) Attacker injects malicious script to Web Application. (2) Malicious code is executed from attacker's website. (3) Server downloads malicious file from attacker's website. (4) Attacker gets control over the Web Application.
* **Man in the Middle Attacks:** A perpetrator forces a new connection, breaking the normal flow between client and server, placing themselves in the middle to intercept or alter data.
* **Cross-Site Scripting (XSS):** (1) Attacker creates a script-injected link. (2) Victim clicks on link and requests legitimate website. (3) Victim's browser loads legitimate website, but also malicious script. (4) Malicious script sends victim's private data to attacker.
* **Password Attack (Password Spraying):** A hacker tests one commonly used password (e.g., SOPH1976) against multiple users' accounts in a target authentication system.
* **Cryptojacking:** An attacker gets their malicious code or script on a website; a user visits the compromised website on their device, allowing the code to execute; the device begins crypto mining on behalf of the cyber criminal; when a data block is solved, the attacker receives a reward without the user's knowledge.
* **Identity-Based Attacks:** Hacker gathers a list of commonly-used passwords, tries the same common password across multiple accounts, and once a login is successful, harvests the sensitive data.

### 2. System-based Attacks
* These are the attacks which are intended to compromise a computer or a computer network.
* Some of the important system-based attacks are as follows: Virus, Worm, Trojan horse, Backdoors, Bots.

**What is Malware?**
* "Malware" is a short term for "malicious software," and it refers to any software specifically designed to harm, exploit, or compromise computer systems, devices, or data without the user's consent.
* Malware includes various types of malicious programs such as viruses, worms, Trojans, spyware, adware, and ransomware, among others.
* Its primary intent is to infiltrate, disrupt, or steal information from a computer or network, and it can cause significant damage to both individuals and organizations.
* The first malware, known as the "Creeper" virus, was created by Bob Thomas in the early 1970s. However, it wasn't as harmful as modern malware and was more of an experiment.
* Malware programmers develop and use malwares to: Attack browsers and track websites visited; Slow down systems and degrade system performance; Cause hardware failure, rendering computers inoperable; Steal personal information, including contacts; Erase valuable information, resulting in substantial data loss; Attack additional computer systems directly from a compromised system; Spam inboxes with advertising emails.
* An example of simple malware code is a batch program (`start notepad`, `goto A`) that continually opens notepad until the system is restarted.

**Different ways malware can enter your network:**
1. Instant Messenger applications
2. Portable hardware media/removable devices
3. Browser and email software bugs
4. Insecure patch management
5. Rogue/decoy applications
6. Untrusted sites and freeware web applications/software
7. Downloading files from the Internet
8. Email attachments
9. Network propagation
10. File sharing services (NetBIOS, FTP, SMB)
11. Installation by other malware
12. Bluetooth and wireless networks

**Types of Malware:**
* **VIRUS:** Spreads between computers. A computer virus is a malicious program that infects files or the system areas of a computer and then makes copies of itself. Viruses are harmful and can corrupt data and files; however, some viruses are harmless, too. Computer viruses need a host to replicate. When you run or open an infected file or program, the virus attaches itself to other files, spreading its code and potentially causing harm. For example, an attacker adds malicious code to a raw image, and when the user opens the image using an image viewer tool, the malicious code executes, resulting in a virus attack on the system.
* **WORM:** Spreads between computers in one company or location.
* **TROJAN:** Sneaks malware onto your computer.
* **SPYWARE:** Steals your data.
* **ADWARE:** Spams you with ads.
* **RANSOMWARE:** Encrypts files and blackmails you.
* **FILELESS MALWARE:** Operates in your system's memory.
* **ROOTKIT:** Gives remote access to your device.
* **BOTNET:** Turns your PC into a puppet.
* **KEYLOGGER:** Records user activity.

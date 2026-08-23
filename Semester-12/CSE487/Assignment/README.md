# CSE 487 - Cyber Security, Law, and Ethics

## Project: OS Command Injection Vulnerability Assessment

1. PROJECT OVERVIEW
   This project demonstrates the identification, exploitation, and mitigation of OS Command Injection vulnerabilities in a controlled, isolated Kali Linux VirtualBox environment.

2. LAB ENVIRONMENT REQUIREMENTS

- Oracle VirtualBox
- Kali Linux 2024.x (or later)
- PHP 8.x (pre-installed on Kali)
- Python 3 (pre-installed on Kali)
- cURL, Nmap

3. FILE STRUCTURE

   > - vulnerable-app/ : Contains the custom-built PHP web app (VulnShop)
   > - scripts/ : Contains automation, setup, and scanning scripts

4. SETUP INSTRUCTIONS
   - Boot up your Kali Linux VM.
   - Copy the 'vulnerable-app' and 'scripts' folders to your /home/kali/ directory.
   - Open a terminal and run the quick setup script:
   - `cd "/home/Assignment/OS Command Injection Vulnerability Assessment/scripts/vulnerable-app/"`
   - `sudo bash setup.sh`
   - (This will verify tools and start the PHP server on port 8080 or 9090).

5. EXECUTION INSTRUCTIONS

- To test manually:
  $ `bash manual_tests.sh`
- To run the automated scanner:
  $ `python3 injection_scanner.py`
- To perform network reconnaissance:
  $ `sudo bash network_scan.sh`

---

## ⚠️ DISCLAIMER & LEGAL WARNING

> **This repository is provided strictly for educational and academic purposes only.**

### Authorized Environment
All exploitation, vulnerability testing, and security assessments demonstrated in this project were performed **exclusively within an isolated sandbox environment** (Oracle VirtualBox with Kali Linux) on the author's own machine. No unauthorized systems, networks, or third-party infrastructure were targeted or affected at any point during this work.

### Educational Purpose
The content herein — including vulnerable application code, exploitation scripts, and attack payloads — is developed solely as part of the coursework for **CSE 487: Cyber Security, Law, and Ethics** at East West University. It is intended to illustrate common security vulnerabilities (specifically OS Command Injection) and their mitigations for **learning purposes only**.

### Legal & Ethical Notice
- **Do NOT** deploy, distribute, or use any content from this repository on production systems, public networks, or any environment without explicit written authorization from the system owner.
- **Do NOT** use the techniques or tools in this repository against any system you do not own or have explicit permission to test.
- Unauthorized access to computer systems is a **criminal offense** under applicable cybersecurity and computer misuse laws (including the Bangladesh Cyber Security Act, 2018, and equivalent international legislation).
- The authors and contributors of this repository **assume no liability** for any misuse, damage, or legal consequences arising from the use or misuse of this material.

### Responsible Disclosure
If any vulnerability or security concern is discovered through the use of concepts presented here, it should be reported responsibly to the appropriate parties and **not exploited maliciously**.

### No Warranty
This material is provided **"as is"** without warranty of any kind. Use at your own risk and only within legally and ethically authorized environments.

---

*This disclaimer is effective as of the date of the last commit and applies to all content within this repository.*

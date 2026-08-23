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

> WARNING: FOR AUTHORIZED LAB USE ONLY

> This software is intentionally vulnerable. Do NOT deploy this on a public network, production server, or any third-party system without explicit written authorization. Failure to comply with cybersecurity laws is a criminal offense.

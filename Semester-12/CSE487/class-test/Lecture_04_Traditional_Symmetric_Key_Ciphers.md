# Lecture 04: Traditional Symmetric-Key Ciphers

**Institution:** University of Frontier Technology, Bangladesh  
**Presented By:** Rakib Hossen, Assistant Professor  

---

## 1. Introduction to Symmetric-Key Ciphers

In a symmetric-key encryption scheme, communication occurs between two parties, traditionally referred to as **Alice** (sender) and **Bob** (receiver):
- **Plaintext ($P$):** The original readable message created by Alice.
- **Ciphertext ($C$):** The encrypted, unreadable message transmitted across the insecure channel.
- **Shared Secret Key ($K$):** A single secret key shared between Alice and Bob via a secure key-exchange channel.

### Mathematical Formulation
- **Encryption:**  
  $$C = E_K(P)$$
- **Decryption:**  
  $$P = D_K(C)$$
- **Invertibility Condition:**  
  $$D_K(E_K(x)) = E_K(D_K(x)) = x$$
- **Proof of Correctness:** Bob receives ciphertext $C$ and computes:
  $$P_1 = D_K(C) = D_K(E_K(P)) = P$$

---

### Visual Explanation: General Architecture & Concept

```
+------------------------------------+                         +-----------------------------------+
|               ALICE                |                         |                BOB                |
|  [Plaintext (P)]                   |                         |  [Plaintext (P)]                  |
|         │                          |                         |         ▲                         |
|         ▼                          |                         |         │                         |
|  ┌──────────────┐                  |   Secure Key Exchange   |  ┌──────────────┐                 |
|  │  Encryption  │ ◄─ [Shared Key] ─┼ - - - - - - - - - - - - ┼─►│  Decryption  │ ◄─ [Shared Key] │
|  │  Algorithm   │                  |                         |  │  Algorithm   │                 |
|  └──────┬───────┘                  |                         |  └──────▲───────┘                 |
|         │                          |                         |         │                         |
|         ▼                          |    Insecure Channel     |         │                         |
|  [Ciphertext (C)] ─────────────────┼─────────────────────────┼─► [Ciphertext (C)]                |
+------------------------------------+                         +-----------------------------------+
```

#### Diagram Explanations:
1. **Figure 3.1 (General Idea of Symmetric-Key Cipher):**
   - **Alice's Side:** Alice takes Plaintext $P$ and feeds it along with the Shared Secret Key $K$ into the Encryption Algorithm $E_K$. The result is Ciphertext $C$.
   - **Transmission:** Ciphertext $C$ is transmitted across an **Insecure Channel** (represented by a public transmission pipe) where adversaries (eavesdroppers) may intercept it.
   - **Key Exchange:** The Shared Secret Key $K$ must be agreed upon beforehand or transmitted via a separate **Secure Key-Exchange Channel**.
   - **Bob's Side:** Bob receives $C$, feeds it and the identical Shared Secret Key $K$ into the Decryption Algorithm $D_K$, recovering the original Plaintext $P$.

2. **Figure 3.2 (Locking and Unlocking with the Same Key):**
   - **Analogy:** A physical padlock where the *exact same physical key* is used to lock (encrypt) the message box at Alice's station and unlock (decrypt) the box at Bob's station.

---

## 2. Cryptanalysis & Attack Models

- **Cryptography:** The science and art of creating secret codes / secure communication mechanisms.
- **Cryptanalysis:** The science and art of breaking secret codes / analyzing ciphers to deduce plaintext or key material without knowing the key.

### Classification of Cryptanalytic Attacks

```
                        ┌──────────────────────────────┐
                        │    Cryptanalysis Attacks     │
                        └──────────────┬───────────────┘
          ┌────────────────────┬───────┴────────────┬────────────────────┐
          ▼                    ▼                    ▼                    ▼
┌───────────────────┐┌───────────────────┐┌───────────────────┐┌───────────────────┐
│  Ciphertext-Only  ││  Known-Plaintext  ││  Chosen-Plaintext ││ Chosen-Ciphertext │
└───────────────────┘└───────────────────┘└───────────────────┘└───────────────────┘
```

#### 1. Ciphertext-Only Attack (Figure 3.4)
- **Attacker's Knowledge:** Eve has intercepted only ciphertext messages $C_1, C_2, \dots, C_n$.
- **Objective:** Recover the plaintext $P$ or the secret key $K$.
- **Mechanism:** Eve feeds intercepted ciphertexts into an analysis engine (statistical methods, brute force) trying to deduce the underlying language patterns.

#### 2. Known-Plaintext Attack (Figure 3.5)
- **Attacker's Knowledge:** Eve has access to one or more previous pairs of plaintext and corresponding ciphertext: $(P_1, C_1), (P_2, C_2), \dots$.
- **Objective:** Determine the secret key $K$ to decrypt future messages.
- **Mechanism:** Eve uses known pairs alongside intercepted ciphertext to analyze the exact transformation rule.

#### 3. Chosen-Plaintext Attack (Figure 3.6)
- **Attacker's Knowledge:** Eve can choose arbitrary plaintext strings and obtain their corresponding ciphertexts from Alice's encryption system (e.g., Eve has temporary access to the encryption hardware).
- **Objective:** Break the encryption key by injecting specially crafted plaintext patterns.

#### 4. Chosen-Ciphertext Attack (Figure 3.7)
- **Attacker's Knowledge:** Eve can choose arbitrary ciphertext blocks and obtain their decrypted plaintexts from Bob's decryption system.
- **Objective:** Deduce the secret key by analyzing how the decryption engine handles specifically crafted ciphertext variations.

---

## 3. Substitution Ciphers

A substitution cipher replaces one symbol (letter, character, number) with another symbol.

### Types of Substitution Ciphers:
1. **Monoalphabetic Ciphers:** One-to-one mapping between plaintext symbols and ciphertext symbols. Each time a character occurs in the plaintext, it is mapped to the same ciphertext character.
   - *Example 3.1:* Plaintext `"hello"` $\rightarrow$ Ciphertext `"KHOOR"`. Both `'l'`s become `'O'`. (Monoalphabetic).
   - *Example 3.2:* Plaintext `"hello"` $\rightarrow$ Ciphertext with different characters for each `'l'` indicates polyalphabetic substitution.
2. **Polyalphabetic Ciphers:** One-to-many relationship. Each occurrence of a character in plaintext can have a different substitute character in ciphertext.

---

## 4. Additive Cipher (Shift / Caesar Cipher)

The additive cipher represents alphabet letters as integers in $\mathbb{Z}_{26}$:
$$\text{a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7, i=8, j=9, k=10, l=11, m=12,}$$
$$\text{n=13, o=14, p=15, q=16, r=17, s=18, t=19, u=20, v=21, w=22, x=23, y=24, z=25}$$

### Mathematical Equations:
- **Encryption:** $C = (P + k) \pmod{26}$
- **Decryption:** $P = (C - k) \pmod{26}$
- Plaintext $P$, Ciphertext $C$, and Key $k \in \mathbb{Z}_{26}$.

### Examples & Cryptanalysis:
- **Example 3.3 (Encryption with $k = 15$ on `"hello"`):**
  - $h (07) \rightarrow (07 + 15) \bmod 26 = 22 \rightarrow W$
  - $e (04) \rightarrow (04 + 15) \bmod 26 = 19 \rightarrow T$
  - $l (11) \rightarrow (11 + 15) \bmod 26 = 00 \rightarrow A$
  - $l (11) \rightarrow (11 + 15) \bmod 26 = 00 \rightarrow A$
  - $o (14) \rightarrow (14 + 15) \bmod 26 = 03 \rightarrow D$
  - **Ciphertext:** `WTAAD`
- **Example 3.4 (Decryption with $k = 15$ on `"WTAAD"`):**
  - $W (22) \rightarrow (22 - 15) \bmod 26 = 07 \rightarrow h$
  - $T (19) \rightarrow (19 - 15) \bmod 26 = 04 \rightarrow e$
  - $A (00) \rightarrow (00 - 15) \bmod 26 = 11 \rightarrow l$
  - $A (00) \rightarrow (00 - 15) \bmod 26 = 11 \rightarrow l$
  - $D (03) \rightarrow (03 - 15) \bmod 26 = 14 \rightarrow o$
  - **Plaintext:** `hello`
- **Caesar Cipher:** Historical additive cipher used by Julius Caesar with fixed key $k = 3$.
- **Brute-Force Attack (Example 3.5):**
  - Intercepted ciphertext: `UVACLYFZLJBYL`
  - Try keys $k=1 \dots 7$. At $k=7$, recovered plaintext: `notverysecure`.
- **Frequency Analysis / Statistical Attack (Example 3.6):**
  - Intercepted text: `XLILSYWIMWRSAJSVWEPIJSVJSYVQMPPMSRHSPPEVWMXMWASVX-LQSVILY-VVCFIJSVIXLIWIPPIVVIGIMZIWQSVISJJIVW`
  - Letter frequency count reveals `I` appears 14 times, `V` appears 13 times.
  - Since `'e'` is the most common letter in English ($e = 4$) and `'I'` = 8, key $k = (8 - 4) = 4$.
  - Plaintext: `"the house is now for sale for four million dollars it is worth more hurry before the seller receives more offers"`.

---

## 5. Multiplicative Cipher

### Mathematical Equations:
- **Encryption:** $C = (P \times k) \pmod{26}$
- **Decryption:** $P = (C \times k^{-1}) \pmod{26}$
- Plaintext $P, C \in \mathbb{Z}_{26}$, Key $k \in \mathbb{Z}_{26}^*$ (set of integers coprime to 26).
- **Key Domain:** Only 12 valid keys: $\mathbb{Z}_{26}^* = \{1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25\}$.
- **Example 3.8 (Encrypt `"hello"` with $k = 7$):**
  - $h (07) \rightarrow (07 \times 7) \bmod 26 = 23 \rightarrow X$
  - $e (04) \rightarrow (04 \times 7) \bmod 26 = 02 \rightarrow C$
  - $l (11) \rightarrow (11 \times 7) \bmod 26 = 25 \rightarrow Z$
  - $l (11) \rightarrow (11 \times 7) \bmod 26 = 25 \rightarrow Z$
  - $o (14) \rightarrow (14 \times 7) \bmod 26 = 20 \rightarrow U$
  - **Ciphertext:** `XCZZU`

---

## 6. Affine Cipher

Combines multiplicative and additive operations.

### Mathematical Equations:
- **Encryption:** $C = (P \times k_1 + k_2) \pmod{26}$
- **Decryption:** $P = ((C - k_2) \times k_1^{-1}) \pmod{26}$
- **Key Pair:** $(k_1, k_2)$ where $k_1 \in \mathbb{Z}_{26}^*$ (12 choices) and $k_2 \in \mathbb{Z}_{26}$ (26 choices).
- **Key Domain Size:** $12 \times 26 = 312$ possible keys.
- **Special Cases:**
  - Additive cipher is an affine cipher with $k_1 = 1$.
  - Multiplicative cipher is an affine cipher with $k_2 = 0$.

### Example 3.10 & 3.11:
- Key pair: $(7, 2)$. $7^{-1} \pmod{26} = 15$ because $(7 \times 15) \bmod 26 = 105 \bmod 26 = 1$.
- Encrypting `"hello"`:
  - $h (07) \rightarrow (07 \times 7 + 2) \bmod 26 = 51 \bmod 26 = 25 \rightarrow Z$
  - $e (04) \rightarrow (04 \times 7 + 2) \bmod 26 = 30 \bmod 26 = 04 \rightarrow E$
  - $l (11) \rightarrow (11 \times 7 + 2) \bmod 26 = 79 \bmod 26 = 01 \rightarrow B$
  - $l (11) \rightarrow (11 \times 7 + 2) \bmod 26 = 79 \bmod 26 = 01 \rightarrow B$
  - $o (14) \rightarrow (14 \times 7 + 2) \bmod 26 = 100 \bmod 26 = 22 \rightarrow W$
  - **Ciphertext:** `ZEBBW`
- Decrypting `"ZEBBW"` with $(7, 2)$:
  - $Z (25) \rightarrow ((25 - 2) \times 15) \bmod 26 = (23 \times 15) \bmod 26 = 345 \bmod 26 = 7 \rightarrow h$
  - Recovers `hello`.

---

## 7. General Monoalphabetic Substitution Cipher

- Instead of a mathematical formula, a complete 26-letter permutation table is agreed upon.
- **Key Space:** $26! \approx 4 \times 10^{26}$ keys.
- *Example Key Mapping:*
  - Plain: `abcdefghijklmnopqrstuvwxyz`
  - Cipher: `NOATRBECFUXDQGYLKHVIJMPZSW`
- *Example 3.13:*
  - Plaintext: `"this message is easy to encrypt but hard to find the key"`
  - Ciphertext: `ICFVQRVVNEFVRNVSIYRGAHSLIOJICNHTIYBFGTICRXRS`

---

## 8. Polyalphabetic Ciphers

### 1. Autokey Cipher
The key is a stream where the first element is a preset subkey $k_1$, followed by the plaintext characters themselves:
- $k = (k_1, P_1, P_2, P_3, \dots)$
- **Encryption:** $C_i = (P_i + k_i) \pmod{26}$
- **Decryption:** $P_i = (C_i - k_i) \pmod{26}$
- *Example 3.14 (Initial key $k_1 = 12$, Plaintext `"Attack is today"`):*
  - Plaintext letters: `a  t  t  a  c  k  i  s  t  o  d  a  y`
  - Plaintext numbers: `00 19 19 00 02 10 08 18 19 14 03 00 24`
  - Keystream: `12 00 19 19 00 02 10 08 18 19 14 03 00`
  - Ciphertext numbers: `12 19 12 19 02 12 18 00 11 07 17 03 24`
  - Ciphertext letters: `M  T  M  T  C  M  S  A  L  H  R  D  Y`

---

### 2. Playfair Cipher

The Playfair cipher encrypts letter pairs (digraphs) using a $5 \times 5$ grid of letters constructed from a keyword.

#### Rules for Constructing the $5 \times 5$ Key Matrix:
1. Fill the matrix row by row with unique letters from the keyword.
2. Fill the remaining cells with the rest of the alphabet in alphabetical order.
3. 'I' and 'J' share a single cell (or 'J' is omitted and replaced with 'I').

*Example Grid (Keyword: "MONARCHY"):*
| Row | C1 | C2 | C3 | C4 | C5 |
|:---:|:---:|:---:|:---:|:---:|:---:|
| **R1** | M | O | N | A | R |
| **R2** | C | H | Y | B | D |
| **R3** | E | F | G | I/J | K |
| **R4** | L | P | Q | S | T |
| **R5** | U | V | W | X | Z |

#### Text Preparation Rules:
1. Split plaintext into pairs of 2 letters (digraphs).
2. If two consecutive letters in a pair are identical, insert a filler/bogus letter (e.g., `'x'`).
   - `"hello"` $\rightarrow$ `'he' 'lx' 'lo'`
3. If an odd letter remains at the end, append an extra bogus letter (e.g., `'z'`).
   - `"helloe"` $\rightarrow$ `'he' 'lx' 'lo' 'ez'`

#### Encryption Rules:
1. **Same Row:** Replace each letter with the letter to its immediate **right** (wrap around to the left edge if at the rightmost column).
2. **Same Column:** Replace each letter with the letter immediately **below** it (wrap around to the top if at the bottom row).
3. **Form a Rectangle:** Replace each letter with the letter in its own row that lies on the column of the other letter (horizontal corners).

*Example 3.15:*
- Plaintext `"instruments"` with keyword `"monarchy"`:
  - Pairs: `in`, `st`, `ru`, `me`, `nt`, `sz`
  - `in` $\rightarrow$ `GA` (Rectangle)
  - `st` $\rightarrow$ `TL` (Rectangle)
  - `ru` $\rightarrow$ `MZ` (Rectangle)
  - `me` $\rightarrow$ `CL` (Rectangle)
  - `nt` $\rightarrow$ `AQ` (Rectangle)
  - `sz` $\rightarrow$ `TX` (Rectangle)
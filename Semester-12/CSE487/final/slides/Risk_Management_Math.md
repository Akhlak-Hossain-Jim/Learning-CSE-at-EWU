# Cybersecurity Risk Management – Quantitative Math Analysis

## 1. Scenario Problem Statement

**Scenario:**
Your company operates an online retail store generating an average weekly profit of **$20,000**. The store has suffered repeated Denial of Service (DoS) attacks, each causing an estimated **40% reduction in sales** during the affected week. Historical logs reveal an average frequency of **7 DoS attacks per year**.

A cybersecurity vendor proposes a DoS mitigation service at a subscription cost of **$10,000 per month**. Preliminary testing indicates that the service effectively mitigates DoS attacks.

### Key Questions:
1. What is the **Annual Rate of Occurrence (ARO)**?
2. What is the **Annualized Loss Expectancy (ALE)** of online sales lost to DoS attacks?
3. Is subscribing to this DoS mitigation service a **financially justified investment**?

---

## 2. Mathematical Risk Management Framework

> **Visual / Formula Reference Model:**

| Acronym | Term | Definition & Mathematical Formula |
|---|---|---|
| **AV** | Asset Value | Replacement costs and/or net financial profit earned through the asset: <br>$$\text{AV} = \text{Total baseline value or period profit}$$ |
| **EF** | Exposure Factor | Percentage of asset value lost when a specific incident occurs ($0.0\text{ to }1.0$): <br>$$\text{EF} = \frac{\text{Loss Amount}}{\text{Total Asset Value}}$$ |
| **SLE** | Single Loss Expectancy | Monetary loss expected each time an incident occurs: <br>$$\text{SLE} = \text{AV} \times \text{EF}$$ |
| **ARO** | Annualized Rate of Occurrence | Estimated frequency/probability of an incident occurring within a one-year timeframe. |
| **ALE** | Annualized Loss Expectancy | Expected total financial loss per year due to the specific threat: <br>$$\text{ALE} = \text{SLE} \times \text{ARO}$$ |
| **TCO** | Total Cost of Ownership | Aggregate cost of acquiring, maintaining, and running mitigation controls/countermeasures. |

---

## 3. Step-by-Step Mathematical Solutions

### Step 1: Calculate Annual Rate of Occurrence (ARO)
$$\text{ARO} = \text{Number of threat events per year}$$
* Given: 7 DoS attacks occur annually.
* **Result:**
  $$\mathbf{ARO = 7 \text{ attacks/year}}$$

---

### Step 2: Calculate Single Loss Expectancy (SLE) and Annualized Loss Expectancy (ALE)
1. **Determine Baseline Value per Event Period:**
   $$\text{Asset Value (AV per week)} = \$20,000$$
2. **Determine Exposure Factor (EF):**
   $$\text{EF} = 40\% = 0.40$$
3. **Compute SLE:**
   $$\text{SLE} = \text{AV} \times \text{EF} = \$20,000 \times 0.40 = \mathbf{\$8,000 \text{ per attack}}$$
4. **Compute ALE:**
   $$\text{ALE} = \text{SLE} \times \text{ARO} = \$8,000 \times 7 = \mathbf{\$56,000 / \text{year}}$$

---

### Step 3: Cost-Benefit Analysis of Mitigation Service

* **Annual Cost of Security Service (TCO):**
  $$\text{TCO} = \$10,000/\text{month} \times 12 \text{ months} = \mathbf{\$120,000 / \text{year}}$$

#### Comparative Scenarios:

* **Case A: Service Eliminates 100% of DoS Attacks**
  * Financial Savings = Baseline $\text{ALE} = \$56,000$
  * Annual Cost = $\$120,000$
  * $\text{Net Balance} = \text{Savings} - \text{Cost} = \$56,000 - \$120,000 = -\$64,000$ (**Net Annual Loss of $64,000**)
  * **Conclusion:** Not economically viable based purely on direct sales loss.

* **Case B: Service Reduces DoS Attacks by 75%**
  * Remaining Attacks = $25\% \times 7 = 1.75\text{ attacks/year}$
  * New $\text{ALE} = 1.75 \times \$8,000 = \$14,000$
  * Financial Savings = $\$56,000 - \$14,000 = \$42,000$
  * $\text{Net Balance} = \$42,000 - \$120,000 = -\$78,000$ (**Net Annual Loss of $78,000**)
  * **Conclusion:** Substantial negative return on investment.

* **Case C: Broad Strategic Valuation (Non-Direct Factors)**
  * The service remains unjustified based solely on direct weekly sales loss. It would only be viable if:
    1. It protects additional core enterprise systems and revenue channels.
    2. It prevents catastrophic contractual penalties, compliance fines, or irreversible brand reputation damage.
    3. The direct sales calculation significantly underestimates downstream customer churn and infrastructure restoration costs.

---

## 4. Final Solution Summary Table

| Metric / Parameter | Value / Assessment |
|---|---|
| **Annual Rate of Occurrence (ARO)** | **7 attacks / year** |
| **Single Loss Expectancy (SLE)** | **$8,000 / attack** |
| **Annualized Loss Expectancy (ALE)** | **$56,000 / year** |
| **Mitigation Service Cost (TCO)** | **$120,000 / year** ($10,000/month) |
| **Is it a Good Investment?** | **No**, because annual mitigation cost ($120,000) exceeds annual expected loss ($56,000) by **$64,000/year**. |

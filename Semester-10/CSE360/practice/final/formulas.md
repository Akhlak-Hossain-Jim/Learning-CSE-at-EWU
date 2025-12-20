# **Master Formula Sheet & Examples**

Here are all the mathematical formulas extracted from your slides (Chapters 5, 7, 11, 12) and practice problems.

#### **1. Processor Frequency & Cycle Time**

**Source:** `CSE360-Chap12-Sp24.pdf`

This is the foundation of all processor math. You must be able to convert between Frequency (Hertz) and Time (Seconds).

* **Formula:**


* : Clock Cycle Time (usually in nanoseconds, )
* : Clock Frequency (usually in GHz or MHz)


* **Conversions:**
* 
* 



**Example Question:**
A microprocessor is clocked at a rate of 5 GHz. How long is a single clock cycle?

**Solution:**

1. 
2. 
3. 

---

#### **2. Pipeline Speedup**

**Source:** `CSE360-Chap12-Sp24.pdf`

This measures how much faster a Pipelined processor is compared to a Non-Pipelined one.

* **Formula:**




* *Note: For an ideal pipeline, assume .*



**Example Question:**
A non-pipelined processor has a clock rate of 2.5 GHz and an average CPI of 4. An upgrade introduces a 5-stage pipeline, but the clock rate drops to 2 GHz. What is the speedup?

**Solution:**

1. **Calculate Old Time ():**
* Cycle Time = 
*  per instruction.


2. **Calculate New Time ():**
* Cycle Time = 
* Assume Ideal Pipeline CPI = 1.
*  per instruction.


3. **Calculate Speedup:**
* 
* *Result:* The new processor is 3.2 times faster.



---

#### **3. Disk Capacity & Formatting**

**Source:** `Hard disk calculation-net.pdf` & `05_External Memory_updated.pdf`

This calculates the total storage space of a hard drive.

* **Formula:**



**Example Question:**
Consider a disk pack with 16 surfaces, 128 tracks per surface, 256 sectors per track, and 512 bytes per sector. What is the total capacity?

**Solution:**

1. Multiply all values:


2. Convert to powers of 2 for easy math:


3. Convert to MB ():



---

#### **4. Disk Access Time**

**Source:** `Hard disk calculation-net.pdf`

This is the total time it takes to find and read data from a disk.

* **Formula:**


* ****: Time to move the arm to the track (usually given).
* ****: Average time to wait for the sector.
* 


* ****: Time to read the actual data bytes.
* 





**Example Question:**
A disk rotates at 3600 RPM. The average seek time is 11.5 ms. Calculate the average access time to read one sector. (Assume other values from the previous capacity example).

**Solution:**

1. **Seek Time:** Given as **11.5 ms**.
2. **Rotational Latency:**
* .
* Avg Latency = .


3. **Transfer Time:**
* Assuming we read 1 sector out of 256 sectors in a track.
* Time = .


4. **Total:**
* .



---

#### **5. DMA Cycle Stealing (CPU Slowdown)**

**Source:** `Prob_Ch7(12_14_15_16_17).pdf`

When a DMA (Direct Memory Access) controller transfers data, it "steals" bus cycles from the CPU, slowing the CPU down.

* **Formula:**


* *Tip:* Ensure both rates are in the same unit (usually Bytes/sec or Words/sec).



**Example Question:**
A DMA module transfers characters at 9600 bps (bits per second). The processor fetches instructions at 1 MIPS (1 million instructions/sec). By how much is the processor slowed down?

**Solution:**

1. **Convert DMA to Bytes:**
* .


2. **Determine CPU Capacity:**
* The CPU fetches 1 million instructions/sec. Assuming 1 instruction = 1 bus cycle (simplification often used in these specific slides).
* Capacity = .


3. **Calculate Slowdown:**
* The DMA steals 1200 cycles (one for each byte).
* 



---

#### **6. Effective Address (EA) Calculation**

**Source:** `CSE360-Chap11-Sp24.pdf` & `final ques.pdf`

This isn't a single formula, but a set of rules based on the **Addressing Mode**.
*Assume Register R1 = 400, Base Register = 100, Instruction Address field = 500.*

| Mode | Formula for EA | Example Calculation |
| --- | --- | --- |
| **Direct** |  |  |
| **Immediate** | No EA (Operand is the field) | Operand = 500 |
| **Indirect** |  | Look at memory address 500. If Mem[500] = 1100, then . |
| **Register** |  (Operand is in R1) |  |
| **Register Indirect** |  |  |
| **Displacement** |  |  |
| **PC Relative** |  | If , . |

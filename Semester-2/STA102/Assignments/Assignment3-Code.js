function Problem2(str) {
  let a = str.split(" ");
  let sA = a.map((el) => Number(el)).sort((a, b) => a - b);
  let n = sA.length;
  let sum = 0;
  for (el of sA) {
    sum += el;
  }
  let mean = sum / n;
  let median = sA[(n + 1) / 2];
  console.log("Sorted Array");
  console.log(sA);
  console.log(`n = ${n}`);
  console.log(`Sum of x = ${sum}`);
  console.log(`x_bar/Mean = ${mean}`);
  console.log(`Median = ${median}`);
  console.log("------------------------------------------------");
  let sum_x_bar_sqr = 0;
  for (el of sA) {
    sum_x_bar_sqr += (el - mean) * (el - mean);
    console.log(`(${el}-${mean})^2  = ${(el - mean) * (el - mean)}`);
  }
  let SD = Math.sqrt(sum_x_bar_sqr / (n - 1));
  let CoEf_sqwed = (3 * (mean - median)) / SD;
  let ShapeOfData =
    CoEf_sqwed >= -0.5 && CoEf_sqwed <= 0.5
      ? "The shape of Data is Symatric"
      : CoEf_sqwed > 0.5
      ? "The shape of Data is Right Skewed"
      : "The shape of Data is Left Skewed";
  let min = sA[0];
  let q1 = sA[((n + 1) * 25) / 100];
  let q2 = sA[((n + 1) * 50) / 100];
  let q3 = sA[((n + 1) * 75) / 100];
  let max = sA[n - 1];
  let IQR = q3 - q1;
  let UpperL = q3 + 1.5 * IQR;
  let LowerL = q1 - 1.5 * IQR;
  console.log("------------------------------------------------");
  console.log(`Sum of (x-x_bar)^2 = ${sum_x_bar_sqr}`);
  console.log(`Standard Deviation = sqrt(${sum_x_bar_sqr}/${n - 1}) = ${SD}`);
  console.log(`The coefficient of skewness is = ${CoEf_sqwed}`);
  console.log(ShapeOfData);
  console.log("------------------------------------------------");
  console.log(`Min = ${min}`);
  console.log(`Q1 = ${q1}`);
  console.log(`Q2 = ${q2}`);
  console.log(`Q3 = ${q3}`);
  console.log(`Max = ${max}`);
  console.log(`IQR = ${IQR}`);
  console.log(`Upper Limit = ${UpperL}`);
  console.log(`Lower Limit = ${LowerL}`);
}

Problem2(
  "46 52 46 40 42 46 40 37 46 40 52 32 37 32 52 40 32 52 40 52 46 46 52"
);

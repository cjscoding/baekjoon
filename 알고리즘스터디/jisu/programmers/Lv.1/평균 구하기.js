const solution = (arr) => {
  let sum = 0;
  arr.map((num) => (sum += num));
  return sum / arr.length;
};

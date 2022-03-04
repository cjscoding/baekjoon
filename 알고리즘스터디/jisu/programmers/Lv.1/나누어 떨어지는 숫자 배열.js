const solution = (arr, divisor) => {
  let result = [];

  arr.map((num) => {
    if (num % divisor === 0) {
      result.push(num);
    }
  });

  result.sort((a, b) => a - b);

  return result.length === 0 ? [-1] : result;
};

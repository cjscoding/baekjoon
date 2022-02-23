const solution = (numbers) => {
  let numArr = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

  numbers.map((num) => (numArr[num] = 1));

  let result = 0;
  for (let i = 0; i <= 9; i++) {
    if (numArr[i] === 0) result += i;
  }

  return result;
};

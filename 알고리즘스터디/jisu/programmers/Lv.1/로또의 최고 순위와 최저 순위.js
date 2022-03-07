const solution = (lottos, win_nums) => {
  let zero = 0;
  let isExist = 0;
  let isNotExist = 0;

  lottos.map((num) => {
    if (num === 0) zero++;
    else if (win_nums.indexOf(num) !== -1) isExist++;
    else isNotExist++;
  });

  let max = 7 - (zero + isExist);
  let min = 7 - isExist;
  max = max === 7 ? 6 : max;
  min = min === 7 ? 6 : min;

  let result = [max, min];
  return result;
};

const solution = (nums) => {
  let half = nums.length / 2;
  let isExist = [];
  let result = 0;
  nums.map((num) => {
    if (isExist.indexOf(num) === -1) {
      if (half > result) {
        isExist.push(num);
        result++;
      }
    }
  });
  return result;
};

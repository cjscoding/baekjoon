const solution = (num) => {
  let cnt = 0;

  while (cnt < 500) {
    if (num === 1) {
      return cnt;
    }
    cnt++;
    num = num % 2 === 0 ? num / 2 : num * 3 + 1;
  }

  return -1;
};

const solution = (n) => {
  let result = 0;
  for (let i = 2; i <= n; i++) {
    if (n % i === 1) {
      result = i;
      break;
    }
  }
  return result;
};

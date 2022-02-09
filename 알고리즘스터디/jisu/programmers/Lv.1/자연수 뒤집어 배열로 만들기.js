const solution = (n) => {
  let arr = n
    .toString()
    .split("")
    .reverse()
    .map((num) => parseInt(num));
  return arr;
};

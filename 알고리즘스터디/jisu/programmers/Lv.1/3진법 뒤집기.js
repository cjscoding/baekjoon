const solution = (n) => {
  let result = Number.parseInt(n.toString(3).split("").reverse().join(""), 3);
  return result;
};

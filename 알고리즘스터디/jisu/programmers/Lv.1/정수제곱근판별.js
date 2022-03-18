const solution = (n) => {
  let root = Math.sqrt(n);
  let result = parseInt(root) - root === 0 ? (root + 1) * (root + 1) : -1;
  return result;
};

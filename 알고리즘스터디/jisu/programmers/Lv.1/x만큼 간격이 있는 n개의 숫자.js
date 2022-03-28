const solution = (x, n) =>
  Array(n)
    .fill(x)
    .map((v, i) => (i + 1) * v);

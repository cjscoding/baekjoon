const solution = (N, A, B) => {
  let cnt = 1;

  while (Math.ceil(A / 2) !== Math.ceil(B / 2)) {
    A = Math.ceil(A / 2);
    B = Math.ceil(B / 2);
    cnt++;
  }

  return cnt;
};

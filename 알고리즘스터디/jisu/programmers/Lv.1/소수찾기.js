const solution = (n) => {
  let result = 0;

  for (let i = 2; i <= n; i++) {
    let cnt = 0;

    for (let j = 2; j <= i; j++) if (i % j == 0) cnt++;

    if (cnt < 2) result++;
  }

  return result;
};

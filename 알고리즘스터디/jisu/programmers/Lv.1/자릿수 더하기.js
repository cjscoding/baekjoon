const solution = (n) => {
  let a = (n + "").split("");
  let b = 0;

  for (let i = 0; i < a.length; ++i) b += parseInt(a[i]);
  return b;
};

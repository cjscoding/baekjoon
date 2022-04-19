const solution = (numbers) => {
  const ans = numbers
    .map((number) => number + "")
    .sort((a, b) => (b + a) - (a + b))
    .join("");
  return ans[0] === "0" ? "0" : ans;
};

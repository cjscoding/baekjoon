const solution = (price, money, count) => {
  let totalCount = (count * (count + 1)) / 2;
  let result = totalCount * price - money;

  return result < 0 ? 0 : result;
};

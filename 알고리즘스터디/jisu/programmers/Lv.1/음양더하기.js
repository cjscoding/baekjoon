const solution = (absolutes, signs) => {
  let answer = 0;
  absolutes.forEach(
    (v, i) => (answer = signs[i] ? (answer += v) : (answer -= v))
  );
  return answer;
};

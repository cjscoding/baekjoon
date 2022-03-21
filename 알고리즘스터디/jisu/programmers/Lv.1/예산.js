const solution = (d, budget) => {
  let answer = 0;
  let money = 0;

  d.sort((a, b) => a - b).forEach((value) => {
    money += value;
    if (money <= budget) answer++;
  });

  return answer;
};

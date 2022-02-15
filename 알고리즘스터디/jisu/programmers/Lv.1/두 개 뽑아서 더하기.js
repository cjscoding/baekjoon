const solution = (numbers) => {
  let answer = [];
  for (let i = 0; i < numbers.length; i++) {
    for (let j = 0; j < numbers.length; j++) {
      if (i === j) continue;
      let num = numbers[i] + numbers[j];
      if (answer.indexOf(num) === -1) answer.push(num);
    }
  }
  answer.sort((a, b) => a - b);
  return answer;
};

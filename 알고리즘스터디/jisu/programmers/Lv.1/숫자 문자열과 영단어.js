const solution = (s) => {
  const num = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];
  let answer = "";

  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) >= "0" && s.charAt(i) <= "9") {
      answer += s.charAt(i);
    } else {
      let tmp = "";
      while (num.indexOf(tmp) === -1) {
        tmp += s.charAt(i++);
      }
      let idx = num.indexOf(tmp);
      answer += idx.toString();
      i--;
    }
  }

  return parseInt(answer);
};

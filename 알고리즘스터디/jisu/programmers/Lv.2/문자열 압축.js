const solution = (s) => {
  let total = s.length;
  let answer = 1001;
  let temp;
  for (let l = 1; l <= total; l++) {
    temp = "";
    for (let i = 0; i < s.length; i++) {
      let info = str(l, i);
      temp += info.temp;
      i = info.i - 1;
    }
    answer = Math.min(answer, temp.length);
  }
  return answer;

  const num = (num) => {
    return num == 1 ? "" : num;
  };
  
  const str = (l, cur) => {
    let i = cur + l;
    let temp = "";
    if (cur + l <= total) {
      let cnt = 1;
      let target = s.slice(cur, cur + l);

      for (i = cur + l; i < total; i += l) {
        if (target == s.slice(i, i + l)) cnt++;
        else break;
      }
      temp += num(cnt) + target;
    } else temp = s.slice(cur, total);
    return { temp: temp, i: i };
  };
};

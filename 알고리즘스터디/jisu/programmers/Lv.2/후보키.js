const solution = (relation) => {
  let answer = 0;
  let tuple_len = relation.length;
  let attr_len = relation[0].length;
  let ary = [];

  let k = new Array();
  for (let i = 0; i < attr_len; i++) k.push(i.toString());

  const match_attr = (arr, str) => {
    str += arr[0];
    ary.push(str);
    if (arr.length == 1) return;
    for (let i = 1; i < arr.length; i++) match_attr(arr.slice(i), str);
  };

  for (let i = 0; i < k.length; i++) match_attr(k.slice(i), "");

  ary.sort((a, b) => {
    if (a.length < b.length) return -1;
    else if (a.length > b.length) return 1;
    else return 0;
  });

  for (let t = 0; t < ary.length; t++) {
    let infos = new Set();
    let comb = ary[t];
    for (let i = 0; i < tuple_len; i++) {
      let str = "";
      relation[i].forEach((x, j) => {
        if (comb.indexOf(j.toString()) >= 0) str += x + ".";
      });
      infos.add(str);
    }
    if (infos.size == tuple_len) {
      answer++;
      ary = ary.filter((x) => {
        let cnt = 0;
        for (let n = 0; n < comb.length; n++)
          if (x.indexOf(comb[n]) >= 0) cnt++;
        if (cnt == comb.length) return false;
        else return true;
      });
      t = -1;
    }
  }
  return answer;
};

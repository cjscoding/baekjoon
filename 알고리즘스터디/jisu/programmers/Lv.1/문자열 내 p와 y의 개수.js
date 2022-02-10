const solution = (s) => {
  let pCnt = 0;
  let yCnt = 0;
  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) === "p" || s.charAt(i) === "P") pCnt++;
    if (s.charAt(i) === "y" || s.charAt(i) === "Y") yCnt++;
  }
  return pCnt === yCnt ? true : false;
};

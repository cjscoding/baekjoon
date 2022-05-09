const solution = (strings, n) => {
  //localeCompare: 문자열 순서 비교 메서드
  return strings.sort((s1, s2) =>
    s1[n] === s2[n] ? s1.localeCompare(s2) : s1[n].localeCompare(s2[n])
  );
};

const solution = (s) => {
  let idx = Math.floor(s.length / 2);
  return s.length % 2 === 0 ? s.charAt(idx - 1) + s.charAt(idx) : s.charAt(idx);
};

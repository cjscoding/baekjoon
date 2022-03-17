const solution = (s, n) => {
  return s.replace(/([a-z])|([A-Z])/g, (c, lowerCase) => {
    let startCode = lowerCase ? "a".charCodeAt(0) : "A".charCodeAt(0);
    return String.fromCharCode(
      ((c.charCodeAt(0) - startCode + n) % 26) + startCode
    );
  });
};

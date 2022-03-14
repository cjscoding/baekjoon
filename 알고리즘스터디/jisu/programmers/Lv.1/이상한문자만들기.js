const solution = (s) => {
  let odd = false;
  let gap = "a".charCodeAt() - "A".charCodeAt();

  let result = "";

  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) !== " ") {
      if (odd) {
        if (s.charAt(i).charCodeAt() < "a".charCodeAt())
          result += String.fromCharCode(s.charAt(i).charCodeAt() + gap);
        else result += s.charAt(i);
      } else {
        if (s.charAt(i).charCodeAt() >= "a".charCodeAt())
          result += String.fromCharCode(s.charAt(i).charCodeAt() - gap);
        else result += s.charAt(i);
      }
      odd = !odd;
    } else {
      result += " ";
      odd = false;
    }
  }

  return result;
};

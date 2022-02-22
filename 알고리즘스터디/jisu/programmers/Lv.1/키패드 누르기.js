const solution = (numbers, hand) => {
  let left = [1, 4, 7];
  let center = [2, 5, 8, 0];
  let right = [3, 6, 9];

  let answer = "";
  let leftThumb = [3, 0];
  let rightThumb = [3, 2];
  numbers.map((num) => {
    if (left.indexOf(num) !== -1) {
      answer += "L";
      leftThumb = [left.indexOf(num), 0];
      console.log("111");
    } else if (right.indexOf(num) !== -1) {
      answer += "R";
      rightThumb = [right.indexOf(num), 2];
    } else {
      let c = center.indexOf(num);
      let dL = Math.abs(leftThumb[0] - c) + Math.abs(leftThumb[1] - 1);
      let dR = Math.abs(rightThumb[0] - c) + Math.abs(rightThumb[1] - 1);

      if (dL > dR) {
        answer += "R";
        rightThumb = [c, 1];
      } else if (dL < dR) {
        answer += "L";
        leftThumb = [c, 1];
      } else {
        if (hand === "left") {
          answer += "L";
          leftThumb = [c, 1];
        } else {
          answer += "R";
          rightThumb = [c, 1];
        }
      }
    }
  });

  return answer;
};

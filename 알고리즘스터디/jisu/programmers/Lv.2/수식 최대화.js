const solution = (expression) => {
  const arr = [
    ["+", "-", "*"],
    ["+", "*", "-"],
    ["-", "+", "*"],
    ["-", "*", "+"],
    ["*", "+", "-"],
    ["*", "-", "+"],
  ];

  //1. 수식을 숫자(num)과 기호(sign)으로 나눈다.
  let num = expression.split(/[^0-9]/);
  num = num.map((it) => {
    return parseInt(it);
  });
  const sign = [];
  for (let i = 0; i < expression.length; i++) {
    if (
      expression[i] === "*" ||
      expression[i] === "+" ||
      expression[i] === "-"
    ) {
      sign.push(expression[i]);
    }
  }

  let maxNum = 0;
  for (let i = 0; i < arr.length; i++) {
    //2. 배열과 수식을 복사한다.
    const copyNum = num.slice();
    const copySign = sign.slice();
    for (let j = 0; j < arr[i].length; j++) {
      for (let k = 0; k < copySign.length; k++) {
        if (copySign[k] === arr[i][j]) {
          if (copySign[k] === "*") {
            copyNum[k] *= copyNum[k + 1];
            copyNum.splice(k + 1, 1);
            copySign.splice(k, 1);
            k--;
          } else if (copySign[k] === "+") {
            copyNum[k] += copyNum[k + 1];
            copyNum.splice(k + 1, 1);
            copySign.splice(k, 1);
            k--;
          } else {
            copyNum[k] -= copyNum[k + 1];
            copyNum.splice(k + 1, 1);
            copySign.splice(k, 1);
            k--;
          }
        }
      }
    }
    //3. 계산후에 최댓값과 비교하여 최댓값을 찾는다.
    if (Math.abs(copyNum[0]) >= maxNum) {
      maxNum = Math.abs(copyNum[0]);
    }
  }
  return maxNum;
};

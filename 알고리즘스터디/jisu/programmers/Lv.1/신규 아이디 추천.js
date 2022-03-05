const solution = (new_id) => {
  let idArr = new_id.split("");

  for (let i = 0; i < idArr.length; i++) {
    let char = idArr[i];
    //1
    if (char >= "A" && char <= "Z") {
      idArr[i] = String.fromCharCode(char.charCodeAt(0) + 32);
      //2
    } else if (
      !(
        (char >= "a" && char <= "z") ||
        (char >= "0" && char <= "9") ||
        char === "-" ||
        char === "_" ||
        char === "."
      )
    ) {
      idArr[i] = "";
    }
  }

  let tmp = idArr.join("");
  idArr = tmp.split("");

  //3
  let pre = idArr[0];
  for (let i = 1; i < idArr.length; i++) {
    if (pre === "." && idArr[i] === ".") {
      idArr[i - 1] = "";
    }
    pre = idArr[i];
  }

  //4
  let result = idArr.join("");
  if (result.charAt(0) === ".") {
    result = result.slice(1, result.length);
  } else if (result.charAt(result.length - 1) === ".") {
    result = result.slice(0, result.length - 1);
  }

  //5
  if (result.length === 0) {
    result = "a";
  }

  //6
  if (result.length >= 16) {
    result = result.slice(0, 15);
  }

  //4
  if (result.charAt(0) === ".") {
    result = result.slice(1, result.length);
  } else if (result.charAt(result.length - 1) === ".") {
    result = result.slice(0, result.length - 1);
  }

  //7
  if (result.length <= 2) {
    let len = 3 - result.length;
    result = result.concat(result.charAt(result.length - 1).repeat(len));
  }

  return result;
};

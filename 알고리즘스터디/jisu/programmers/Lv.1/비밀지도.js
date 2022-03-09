const solution = (n, arr1, arr2) => {
  let result = [];

  for (let i = 0; i < n; i++) {
    let one = arr1[i].toString(2);
    let two = arr2[i].toString(2);

    if (one.length < n) one = "0".repeat(n - one.length) + one;
    if (two.length < n) two = "0".repeat(n - two.length) + two;

    let row = "";
    for (let j = 0; j < n; j++) {
      if (one.charAt(j) === "0" && two.charAt(j) === "0") row += " ";
      else row += "#";
    }

    result.push(row);
  }

  return result;
};

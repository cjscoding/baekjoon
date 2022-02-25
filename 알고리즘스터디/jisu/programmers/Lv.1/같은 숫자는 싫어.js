const solution = (arr) => {
  let result = [arr[0]];
  let frontValue = arr[0];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] !== frontValue) {
      result.push(arr[i]);
      frontValue = arr[i];
    }
  }

  return result;
};

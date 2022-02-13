const solution = (arr) => {
  if (arr.length === 1) return [-1];
  else {
    let minValue = Number.MAX_SAFE_INTEGER;
    let minIndex = -1;
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] < minValue) {
        minValue = arr[i];
        minIndex = i;
      }
    }
    arr.splice(minIndex, 1);
    return arr;
  }
};

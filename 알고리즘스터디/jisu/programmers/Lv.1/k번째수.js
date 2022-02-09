const solution = (array, commands) => {
  let answer = [];

  commands.map((arr) => {
    let copyArray = array;
    let newArray = array.slice(arr[0] - 1, arr[1]);
    newArray.sort((a, b) => a - b);
    answer.push(newArray[arr[2] - 1]);
  });

  return answer;
};

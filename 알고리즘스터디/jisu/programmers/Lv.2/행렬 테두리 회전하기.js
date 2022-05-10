const solution = (rows, columns, queries) => {
  const answer = [];
  let arr = Array.from(new Array(rows + 1), () =>
    new Array(columns + 1).fill(0)
  );

  for (let i = 1; i <= rows; i++) {
    for (let j = 1; j <= columns; j++) {
      arr[i][j] = (i - 1) * columns + j;
    }
  }

  for (let tc = 0; tc < queries.length; tc++) {
    const [x1, y1, x2, y2] = queries[tc];
    const stack = [];
    for (let i = y1; i < y2; i++) stack.push(arr[x1][i]);
    for (let i = x1; i < x2; i++) stack.push(arr[i][y2]);
    for (let i = y2; i > y1; i--) stack.push(arr[x2][i]);
    Î;
    for (let i = x2; i > x1; i--) stack.push(arr[i][y1]);

    answer.push(Math.min(...stack));
    const temp = stack.pop();
    stack.unshift(temp);

    for (let i = y1; i < y2; i++) arr[x1][i] = stack.shift();
    for (let i = x1; i < x2; i++) arr[i][y2] = stack.shift();
    for (let i = y2; i > y1; i--) arr[x2][i] = stack.shift();
    for (let i = x2; i > x1; i--) arr[i][y1] = stack.shift();
  }

  return answer;
};

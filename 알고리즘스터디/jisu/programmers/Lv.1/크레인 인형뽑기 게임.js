const solution = (board, moves) => {
  let result = 0;
  let bucket = [];

  for (let m = 0; m < moves.length; m++) {
    let idx = moves[m] - 1;
    for (let i = 0; i < board.length; i++) {
      let boardRow = board[i];
      if (boardRow[idx] !== 0) {
        bucket.push(boardRow[idx]);
        boardRow[idx] = 0;
        break;
      }
    }
    let len = bucket.length;
    if (len > 1) {
      if (bucket[len - 1] === bucket[len - 2]) {
        bucket.splice(len - 2);
        result += 2;
      }
    }
  }

  return result;
};

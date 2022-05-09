const solution = (grid) => {
  const answer = [];
  const [N, M] = [grid.length, grid[0].length];
  const routes = {};
  for (let r = 0; r < N; r++) {
    routes[r] = {};
    for (let c = 0; c < M; c++) {
      routes[r][c] = {
        u: 0,
        d: 0,
        l: 0,
        r: 0,
      };
    }
  }

  const bfs = (startR, startC, startDir) => {
    const queue = [[startR, startC, startDir, 0]];

    while (true) {
      let [r, c, dir, len] = queue.pop(0);
      r = r === N ? 0 : r === -1 ? N - 1 : r;
      c = c === M ? 0 : c === -1 ? M - 1 : c;

      if (r === startR && c === startC && dir === startDir && len) {
        return len;
      }

      routes[r][c][dir] = 1;
      switch (grid[r][c]) {
        case "S":
          queue.push(
            dir === "u"
              ? [r + 1, c, "u", len + 1]
              : dir === "d"
              ? [r - 1, c, "d", len + 1]
              : dir === "l"
              ? [r, c + 1, "l", len + 1]
              : [r, c - 1, "r", len + 1]
          );
          break;
        case "L":
          queue.push(
            dir === "u"
              ? [r, c + 1, "l", len + 1]
              : dir === "d"
              ? [r, c - 1, "r", len + 1]
              : dir === "l"
              ? [r - 1, c, "d", len + 1]
              : [r + 1, c, "u", len + 1]
          );
          break;
        case "R":
          queue.push(
            dir === "u"
              ? [r, c - 1, "r", len + 1]
              : dir === "d"
              ? [r, c + 1, "l", len + 1]
              : dir === "l"
              ? [r + 1, c, "u", len + 1]
              : [r - 1, c, "d", len + 1]
          );
          break;
      }
    }
  };

  const directions = ["u", "d", "l", "r"];
  for (let r = 0; r < N; r++) {
    for (let c = 0; c < M; c++) {
      directions.map((dir) => {
        if (!routes[r][c][dir]) {
          answer.push(bfs(r, c, dir));
        }
      });
    }
  }

  answer.sort((a, b) => a - b);

  return answer;
};

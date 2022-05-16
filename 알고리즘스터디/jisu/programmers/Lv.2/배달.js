function solution(N, road, K) {
  const totalDist = new Array(N + 1).fill(Infinity);
  const adj = Array.from({ length: N + 1 }, () => []);

  road.forEach(([a, b, c]) => {
    adj[a].push({ to: b, dist: c });
    adj[b].push({ to: a, dist: c });
  });

  const queue = [{ to: 1, dist: 0 }];
  totalDist[1] = 0;

  while (queue.length) {
    let { to, dist } = queue.pop();

    adj[to].forEach((step) => {
      if (totalDist[step.to] > totalDist[to] + step.dist) {
        totalDist[step.to] = totalDist[to] + step.dist;
        queue.push(step);
      }
    });
  }

  return totalDist.filter((dist) => dist <= K).length;
}

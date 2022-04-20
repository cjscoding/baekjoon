const solution = (priorities, location) => {
  let list = priorities.map((t, i) => ({
    my: i === location,
    val: t,
  }));
  let count = 0;
  while (true) {
    let cur = list.shift();
    if (list.some((t) => t.val > cur.val)) {
      list.push(cur);
    } else {
      count++;
      if (cur.my) return count;
    }
  }
};

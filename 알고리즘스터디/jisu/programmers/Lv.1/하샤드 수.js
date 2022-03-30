const solution = (x) => !(x % (x + "").split("").reduce((a, b) => +b + +a));

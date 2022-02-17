const solution = (sizes) => {
  let short = 0;
  let long = 0;
  sizes.map((size) => {
    size.sort((a, b) => a - b);
    long = size[0] >= long ? size[0] : long;
    short = size[1] >= short ? size[1] : short;
  });
  return short * long;
};

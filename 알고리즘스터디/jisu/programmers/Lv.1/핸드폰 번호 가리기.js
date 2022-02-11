const solution = (phone_number) => {
  let star = "*".repeat(phone_number.length - 4);
  let four = phone_number.slice(-4);
  return star + four;
};

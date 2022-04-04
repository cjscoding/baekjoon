// const solution = (s) => {
//   let min = s.length;

//   for (let i = 2; i < s / 2; i++) {
//     let made = "";
//     let same = 1;
//     let pat = "";
//     let start = 0;
//     let end = i;
//     out: while (true) {
//       let tmp = "";
//       for (let j = start; j < end; j++) {
//         if (j === s.length) {
//           made += tmp;
//           break out;
//         }
//         tmp += s.charAt(j);
//       }

//       if (tmp === pat) {
//         same++;
//       } else {
//         made += same;
//         made += pat;
//         same = 1;
//         pat = "";
//       }

//       start += i;
//       end += i;
//     }

//     min = Math.min(made.length, min);
//   }
// };

function solution(sequence, k) {
  let answer = [];
  let sum = 0;
  let head = 0;
  for (let i = 0; i < sequence.length; i++) {
    sum += sequence[i];
    if (sum > k) {
      while (sum > k) {
        sum -= sequence[head++];
      }
    }
    if (sum === k) {
      answer.push([head, i]);
    }
  }
  let min = sequence.length;
  let result = [];
  answer.forEach((element) => {
    if (min > element[1] - element[0]) {
      min = element[1] - element[0];
      result = [element[0], element[1]];
    }
  });
  return result;
}

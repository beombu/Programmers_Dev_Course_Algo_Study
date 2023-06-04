function solution(order) {
  let answer = 0;
  let boxNum = 1;
  const stack = [];

  for (const num of order) {
    let isTrue = false;
    while (true) {
      if (stack.length === 0) stack.push(boxNum++);
      if (num > stack.at(-1)) stack.push(boxNum++);
      else if (num === stack.at(-1)) {
        stack.pop();
        answer++;
        isTrue = true;
        break;
      } else break;
    }
    if (!isTrue) break;
  }
  return answer;
}

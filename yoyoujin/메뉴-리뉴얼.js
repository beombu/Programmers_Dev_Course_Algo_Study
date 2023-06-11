function solution(orders, course) {
  const answer = [];

  for (let i = 0; i < course.length; i++) {
    const map = {}; // 주문조합-주문횟수
    let max = 0;

    orders.forEach((v) => {
      Combinations(v.split(''), course[i]).forEach((x) => {
        if (!map[x]) map[x] = 1;
        else map[x]++;
      });
      for (const c in map) {
        if (map[c] > max) max = map[c];
      }
    });

    for (const c in map) {
      if (map[c] === max && max > 1) answer.push(c);
    }
  }

  return answer.sort();
}

const Combinations = (arr, num) => {
  // 재귀적으로 조합생성
  const results = [];

  if (num === 1) return arr.map((v) => [v]);

  arr.forEach((select, i, origin) => {
    const remainder = origin.slice(i + 1);
    const combinations = Combinations(remainder, num - 1);
    const combine = combinations.map((v) => [select, ...v].sort().join(''));
    results.push(...combine);
  });

  return results;
};

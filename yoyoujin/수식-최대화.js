function solution(expression) {
  let answer = [];
  const permutations = getPermutations(['+', '-', '*'], 3);
  permutations.forEach((permutation) => {
    const nums = expression.split(/(\D)/);
    permutation.forEach((exp) => {
      while (nums.includes(exp)) {
        const idx = nums.indexOf(exp);
        nums.splice(idx - 1, 3, caclulate(nums[idx - 1], nums[idx + 1], exp));
      }
    });
    answer.push(Math.abs(nums[0]));
  });

  return Math.max(...answer);
}

function caclulate(a, b, exp) {
  let numA = Number(a);
  let numB = Number(b);
  return exp === '*' ? numA * numB : exp === '+' ? numA + numB : numA - numB;
}

function getPermutations(arr, num) {
  const results = [];
  if (num === 1) return arr.map((v) => [v]);

  arr.forEach((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    const permutations = getPermutations(rest, num - 1);
    const attached = permutations.map((v) => [fixed, ...v]);
    results.push(...attached);
  });

  return results;
}

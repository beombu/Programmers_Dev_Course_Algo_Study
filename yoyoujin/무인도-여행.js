function solution(maps) {
  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  const dp = [...new Array(maps.length)].map((_, i) => [...new Array(maps[0].length)].fill(0));

  ret = [];

  for (let i = 0; i < maps.length; i++) {
    for (let j = 0; j < maps[0].length; j++) {
      if (maps[i][j] !== 'X' && !dp[i][j]) {
        let cnt = 0;
        const que = [[j, i]];
        while (que.length) {
          const [x, y] = que.shift();
          if (dp[y][x]) continue;

          cnt += +maps[y][x];
          dp[y][x] = 1;
          for (let k = 0; k < 4; k++) {
            const [nx, ny] = [x + dx[k], y + dy[k]];
            if (
              0 <= nx &&
              nx < maps[0].length &&
              0 <= ny &&
              ny < maps.length &&
              !dp[ny][nx] &&
              maps[ny][nx] !== 'X'
            ) {
              que.push([nx, ny]);
            }
          }
        }
        ret.push(cnt);
      }
    }
  }

  ret.sort((a, b) => a - b);

  return ret.length ? ret : [-1];
}

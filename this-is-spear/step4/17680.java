import java.util.Objects;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		CachePool cp = new CachePool(cacheSize);
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (String city : cities) {
			answer += cp.getOne(city.toLowerCase());
		}
		return answer;
	}

	private static class CachePool {
		private int s;
		private int c;
		private Node start;
		private Node end;

		public CachePool(int s) {
			this.s = s;
			this.c = 0;
			this.end = new Node("end", null, null);
			this.start = new Node("root", null, end);
			this.end.prv = start;
		}

		public int getOne(String name) {
			Node cur = new Node(name);

			// 존재하면 우선 순위 증가 (리턴 0)
			Node contains = contains(cur);
			if (contains != null) {
				// 이전 자리에서 삭제
				Node prv = contains.prv;
				Node nxt = contains.nxt;
				prv.nxt = nxt;
				nxt.prv = prv;

				// 루트 자리에서 추가
				Node startN = start.nxt;
				start.nxt = contains;
				startN.prv = contains;

				// cur 갱신
				contains.nxt = startN;
				contains.prv = start;
				return 1;
			}

			// 빈 공간이 있으면 값 추가
			if (c < s) {
				// 빈 공간이 남으면 추가 (리턴 1)
				Node nxt = start.nxt;
				// 루트 노드 수정
				start.nxt = cur;
				// 다음 노드의 이전 노드 수정
				nxt.prv = cur;
				// 자신 수정
				cur.prv = start;
				cur.nxt = nxt;
				c++;
				return 5;
			}

			// 존재하지 않으면 뒤에 빼고 root 뒤에 추가 (리턴 1)
			// 마지막 원소 삭제
			Node prv = end.prv;
			prv.prv.nxt = end;
			end.prv = prv.prv;

			// 원소 추가
			Node nxt = start.nxt;
			start.nxt = cur;
			nxt.prv = cur;

			// cur 갱신
			cur.nxt = nxt;
			cur.prv = start;
			return 5;
		}

		public Node contains(Node n) {
			Node cur = start;
			while (cur.nxt != null) {
				if (cur.nxt.equals(n)) {
					return cur.nxt;
				}
				cur = cur.nxt;
			}
			return null;
		}
	}

	private static class Node {
		private String name;
		private Node prv;
		private Node nxt;

		public Node(String name) {
			this.name = name;
		}

		public Node(String name, Node prv, Node nxt) {
			this.name = name;
			this.prv = prv;
			this.nxt = nxt;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return Objects.equals(name, node.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
}

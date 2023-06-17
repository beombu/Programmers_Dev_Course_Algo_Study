import java.util.ArrayList;
import java.util.List;

class Solution {

    // 인접 리스트를 사용하여 트리를 나타냅니다.
    private List<List<Integer>> adjList = new ArrayList<>();

    // DFS를 사용하여 서브트리의 노드 수를 세는 함수입니다.
    private int dfsCountNodes(int current, int parent) {
        // 현재 노드를 센다.
        int count = 1; 
        
        // 현재 노드에 연결된 이웃 노드들을 확인합니다.
        for (int neighbor : adjList.get(current)) {
            // 이웃이 부모 노드가 아닌 경우만 재귀적으로 DFS를 수행합니다.
            if (neighbor != parent) {
                count += dfsCountNodes(neighbor, current);
            }
        }
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // 인접 리스트를 사용하여 주어진 전선 정보로 트리를 생성합니다.
        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        
        // 최소 차이를 저장하는 변수를 최대값으로 초기화합니다.
        int minDifference = Integer.MAX_VALUE;
        
        // 각 전선을 하나씩 제거해보며 두 그룹의 노드 수 차이를 계산합니다.
        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            
            // v1을 루트로 하는 서브트리의 노드 수를 세고
            int nodesInFirstPart = dfsCountNodes(v1, v2);
            // v2를 루트로 하는 서브트리의 노드 수를 센다
            int nodesInSecondPart = dfsCountNodes(v2, v1);
            
            // 두 서브트리의 노드 수의 차이를 계산합니다.
            int difference = Math.abs(nodesInFirstPart - nodesInSecondPart);
            // 지금까지 찾은 최소 차이와 비교하여 더 작은 값을 저장합니다.
            minDifference = Math.min(minDifference, difference);
        }
        
        return minDifference;
    }

 }
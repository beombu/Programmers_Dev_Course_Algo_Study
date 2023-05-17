import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTime = 0;
        int index = 0;
        int truckWeightOnTheBridge = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            truckWeightOnTheBridge -= bridge.poll();
            totalTime++;

            if (truckWeightOnTheBridge + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                truckWeightOnTheBridge += truck_weights[index++];
            }else {
                bridge.offer(0);
            }
        }

        return totalTime + bridge_length;
    }
}

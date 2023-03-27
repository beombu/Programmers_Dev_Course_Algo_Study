package src._3주차;

public class 카펫 {
    public int[] solution(int brown,
                          int yellow) {
        int[] answer = bruteForth(brown, yellow);

        return answer;
    }

    public static int[] bruteForth(int brown,
                             int yellow){
        int area = brown + yellow;
        int width=0;
        int height=0;

        for(height=1; height<=area; height++){
            width = area/height;

            int yellowArea = (height-2) * (width-2);
            if(yellowArea == yellow){
                break;
            }
        }

        if(height > width){
            int temp = width;
            width = height;
            height = temp;
        }

        return new int[]{width, height};
    }
}

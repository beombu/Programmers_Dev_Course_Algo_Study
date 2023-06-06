import java.util.Arrays;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int leftResult = 0;
        int rightResult = 0;
        int len = Integer.MAX_VALUE;
        int[] result = new int[2];
        int sum = sequence[0]; // left랑 right은 처음에 0으로 같은 곳을 가리키니깐
        while(true){
            if(left == 0 && right == 0 && sum == k){ // 0번 인덱스부터 정답이면 바로 출력
                break;
            }
            if(left == sequence.length-1 && right ==sequence.length-1){ // left, right 둘 다 끝에 도달했으면
                if(sum==k){ // sum==k 조건 파악 후에 break;
                    leftResult = left;
                    rightResult = right;
                    break;
                }
                break;
            }
            if(sum<k && right<sequence.length-1){ // 아직 sum이 k보다 작으면
                right++;
                sum+=sequence[right];
            }else if(sum<k && right == sequence.length-1){ // sum은 k보다 작지만 right이 끝에 도달했으면 break
                break;
            }
            else if(sum==k){ // sum이 k랑 같아지면
                if(len>right-left){
                    len = right-left; // 길이를 갱신해서 저장
                    leftResult = left;
                    rightResult = right;
                }
                if(right<sequence.length-1){ // 아직 right이 이동 가능하면
                    right++;
                    sum+=sequence[right];
                }else if(right==sequence.length-1 && left<sequence.length-1){ // right은 이동 불가능하지만 left는 가능한 경우
                    left++;
                    sum-=sequence[left-1];
                }else{ // 이동 불가능한 경우
                    break;
                }
            }else if(sum>k && left<sequence.length-1){ // sum이 k보다 크고 left가 이동 가능하면
                left++;
                sum-=sequence[left-1];
            }

        }
        result[0] = leftResult;
        result[1] = rightResult;
        return result;
    }
}
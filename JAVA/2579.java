import java.io.*;


/**
 * 풀이 방법: DP(다이나믹 프로그래밍)으로 풀었습니다. 메모이제이션을 사용하였으며, 제출은 탑다운으로 하였고, 이후 추가 공부를 위해 바텀업 방식으로 풀었습니다
 * 접근 방법: 점화식을 뽑아내야하고, 탑 다운 방식으로 풀면 쉽게 풀 것 같다고 생각하여 DP 알고리즘으로 접근하였습니다.
 * 풀이 과정:
 * - 80%까지 생각해냈으나, 20%가 부족하여 결국 힌트를 참고해서 풀었습니다. -> 아직 DP에 대한 학습이 더 필요한 상태
 *
 * - 탑다운 방식으로 풀 경우
 * 1. 재귀 함수를 이용하여 풀었습니다.
 * 2. 0보다 작거나 같은 경우 0리턴(재귀함수 무한루프 방지), dp[n]이 있는 경우 해당 dp[n] 리턴(메모이제이션)을 해줍니다
 * 3. dp[n]이 없는 경우 점화식을 참고하여 풉니다. -> 생각해낸 점화식: dp[n] = Math.max(dp_count(n-3) + stairs[n-1], dp_count(n-2)) + stairs[n];
 * -> 계단이 4개 이상 있고 마지막 계단을 오르기 전을 생각해서 풀면 쉽게 점화식을 뽑아낼 수 있음
 * -> 연속된 3칸을 오를 수 없기 떄문에 다음 2가지 경우만 해당됨: n-2, n-3 + n-1 -> +2, 1+2
 * -> 여기서 n-1부분은 재귀를 해주면 안된다 -> 재귀를 하면 한칸씩 내려가는 경우가 생기기 떄문에 조건에 맞지 않음 따라서 n-3을 재귀로 돌려주고, n-1은 고정이 되기 위해 stairs[n-1]로 더해준다
 * -> 두 식 중에서 큰 것을 골라서 현재의 계단 값에 더해서 dp[n]에 넣어준다
 * -> 해당 dp[n]을 리턴하고 출력한다.
 *
 * - 바텀업 방식으로 풀 경우
 * 1. 반복문으로 푼다
 * 2. dp[1]에는 stairs[1]
 * 3. dp[2]에는 stairs[1]+stairs[2]
 * 4. 3부터 n까지  dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i]; 다음 점화식을 따른다.
 * 5. 해당 값을 출력한다
 *
 *
 * 시간복잡도: O(n) -> 단순 재귀함수면 O(2^n)으로 갈수도 있으나 DP의 메모이제이션을 활용하여 시간복잡도 O(n)으로 유지
 * 공간복잡도: O(n) -> 배열의 크기가 다 n+1 이므로
 *
 */




public class Main {

    static int[] dp; // static, 전역 배열은 0으로 int형일 경우 0으로 자동 초기화됨
    static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        dp = new int[n+1];
        int ans = 0;
        for(int i=1; i<n+1; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        if(n == 1){
            ans = stairs[n];
        }else if(n==2){
            ans = stairs[n] + stairs[n-1];
        }else if(n==3){
            ans = Math.max((stairs[n]+stairs[n-1]), (stairs[n] + stairs[n-2]));
        }else{

            // Top-down 방식
             ans = dp_count(n);

            /*
            Bottom-Up 방식
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
            for(int i=3; i<n+1; i++){
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            }
            ans = dp[n];*/


        }


        bw.write(ans+"");
        bw.close();



    }

    public static int dp_count(int n){
        if(n<=0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }else{
            dp[n] += Math.max(dp_count(n-3) + stairs[n-1], dp_count(n-2)) + stairs[n];
        }

        return dp[n];
    }


}

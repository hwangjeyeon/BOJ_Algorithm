import java.io.*;


/**
 * 풀이 방법: DP로 점화식 발견하여 풀었습니다 -> 점화식 찾아내는데 1분 걸린 엄청 쉬운 문제
 * 접근 방법: 점화식으로 바텀업 방식으로 제출, 추가 공부를 위해 탑다운 방식으로도 접근해서 풀었습니다
 * 풀이 과정:
 * - int형으로 하면 틀림 -> n이 커지면 int형 범위를 벗어난다 -> 따라서 int형 범위를 넘어나는지 확인 꼭 하고 넘어서면 long으로 선언하자
 * 1. 다음 점화식을 활용하여 탑다운은 재귀, 바텀업은 반복문으로 해결한다
 * - 탑다운 방식으로 풀 경우
 * -> 위 점화식 활용하여 재귀
 * - 바텀업 방식으로 풀 경우
 * -> 위 점화식 활용하여 반복문 해결
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long ans = 0;
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new long[n+1];

            if(n <= 3){
                bw.write(1+ "\n");
            }else{
                dp[1] = 1L;
                dp[2] = 1L;
                dp[3] = 1L;
                // 바텀 업 방식
                for(int j=4; j<n+1; j++){
                    dp[j] = dp[j-2] + dp[j-3];
                }

                // 탑 다운 방식
                // ans = dp_count(n);
                bw.write(ans+"\n");
            }


        }
        br.close();
        bw.close();



    }
/*  탑다운 방식
    public static long dp_count(int n){
        if(n <= 0 ){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        else {
            dp[n] = dp_count(n-2) + dp_count(n-3); // 이거 안 담고 그냥 리턴해버리면 메모이제이션이 안 되므로, 시간 복잡도가 O(2^n)나온다. 꼭 dp[n]에 저장하는 메모이제이션으로 풀기
        }
        return dp[n];

    }*/


}

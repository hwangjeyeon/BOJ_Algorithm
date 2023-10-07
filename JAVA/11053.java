import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - LIS(최장 증가 부분수열) 알고리즘을 공부 후에 풀었습니다.
 * - 배열로 주어진 숫자들의 현재 위치와 그 이전 위치를 비교하여 오름차순으로 나열할 수 있는지 확인하는 알고리즘
 * - 첫번째는 이전이 없기 때문에 무조건 길이가 1이다.
 * dp[i] = 각 숫자마다 가능한 부분수열의 길이
 * 1. 이중 for문으로 이전 dp,arr과 비교한다. 이때 비교하는 현재의 arr[i]가 arr[j]보다 크면 부분수열에 넣을 수 있다.
 * 2. 위 1번 조건을 만족하는경우 메모이제이션으로 dp에 저장한 이전 값들에 +1을 해서 해당 dp[i]에 저장한다. 이때 가장 큰 길이를 저장하기 위해서 dp[i] <= dp[j]조건을 추가한다
 * 3. 첫번째 for문이 끝날 때마다 ans에 Math.max로 ans와 dp[i]를 비교하여 큰 값을 ans에 넣어준다
 * 4. 최종 ans값을 출력한다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 * 
 * 기타사항:
 * - LIS, LCS, 2차원 배열 활용 점화식 등 dp 알고리즘으로 풀 수 있는 세부 유형들에 대한 기본적인 지식과 이해가 현재 필요한 상황이며, 백준에 있는 여러 문제를 풀면서 확실하게 체득할 계획입니다.
 *
 */




public class Main {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(N == 1){
            bw.write(1 + "");
        }else{
            dp[1] = 1;
            int ans = 0;
            for(int i=2; i<N+1; i++){
                dp[i] = 1;
                for(int j=1; j<i; j++){
                    if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                ans = Math.max(ans,dp[i]);
            }
            bw.write(ans + "");
        }
        bw.close();

    }

}

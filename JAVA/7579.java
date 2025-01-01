import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 처음에는 PQ를 두개 이용해서 메모리 크기 내림차순기준과 비용 오름차순 기준으로 비교하려고 했으나, 중간값만으로 결정될 경우 반례가 발생한다
 * 2. 두번째 선택한 방법은 DP와 배낭정리이다.
 * 3. 비용을 무게, 메모리 크기를 가치로 두고 배낭정리를 한다
 * 4. 먼저 배낭정리를 통해 비용의 최댓값을 구해나간다. 그리고 무게크기를 순회하는 동안 만약 현재 dp값이 m보다 크거나 같으면 정답과 현재 비용을 비교해서 최솟값으로 교체한다
 * 5. 완성한 정답을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*100001)
 * 공간복잡도: O(n*100001)
 *
 */
class Pair{
    int mem;
    int cost;

    public Pair(int mem){
        this.mem = mem;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Pair[] pairs = new Pair[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n+1; i++) {
            pairs[i].cost = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n+1][100001];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < 100001; j++) {
                if(pairs[i].cost > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], pairs[i].mem + dp[i-1][j-pairs[i].cost]);
                }
                if(dp[i][j] >= m){
                    ans = Math.min(ans, j);
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

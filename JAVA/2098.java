import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 외판원 순회문제 학습용으로 푼 문제다
 * 2. DP와 비트마스킹을 사용해서 문제를 해결할 수 있다
 * 3. 참고로 외판원 순회문제 TSP는 어떤 정점에서 시작해도 결과는 똑같다. 또한 한 정점에서 다른 모든 정점을 순회해서 다시 출발 정점으로 돌아오는 최적의 경로를 찾아야 한다
 * 4. DP는 N과 bit의 크기만큼으로 한다. bit값은 (1<<n) - 1이다
 * 5. dp 방문여부를 판단하기 위해 -1로 초기화한다
 * 6. tsp는 첫번째 지점인 0번을 기준으로 시작하며 그 결과를 바로 출력한다
 * 7. x는 현재 방문 지점이고, check는 방문 확인용 비트다
 * 8. 만약 모든 도시 방문을 완료한 경우 check는 앞서 설정한 bit 값과 같을 것이다
 * 9. 그럴 경우 만약 경로가 없으면 INF를 리턴하고 아니면 해당 경로로 리턴한다
 * 10. 그 외에 만약 DP를 방문했으면 그대로 DP를 리턴하고 DP에는 INF로 처리해둔다
 * 11. 아직 방문하지 않은 N개의 도시를 탐색한다. 다음 도시 방문 지점은 check | (1<<i) 현재 지점에서 갈 수 있는 i번 비트다
 * 12. 만약 경로가 없거나 (check & (1<<i) != 0)이라서 i도시를 이미 방문한 경우 건너뛴다
 * 13. 그외에는 dp[x][check]에 최솟값을 비교해 tsp의 다음 지점의 재귀값과 현재 지점의 arr[x][i]값을 합해 갱신한다
 * 14. 오나성한 dp값을 리턴하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    static int n;
    static int INF = 987654321;
    static int[][] arr;
    static int[][] dp;
    static int bit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bit = (1<<n) -1;
        arr = new int[n][n];
        dp = new int[n][bit];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(tsp(0,1)+"");

        br.close();
        bw.close();
    }

    private static int tsp(int x, int check) {
        if(check == bit){
            if(arr[x][0] == 0 ){
                return INF;
            }
            return arr[x][0];
        }

        if(dp[x][check] != -1){
            return dp[x][check];
        }

        dp[x][check] = INF;

        for (int i = 0; i < n; i++) {
            int nxt = check | (1<<i);
            if(arr[x][i] == 0 || (check & (1<<i)) != 0){
                continue;
            }
            dp[x][check] = Math.min(dp[x][check], tsp(i,nxt) + arr[x][i]);
        }
        return dp[x][check];
    }

}

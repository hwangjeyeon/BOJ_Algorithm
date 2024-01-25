import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 플로이드-워셜 알고리즘을 이용해서 풀었다
 * - 위 알고리즘을 이용하면 이전문제와 크게 다른점이 없고, 딱 두가지 고려해주면 된다
 * - 출발지와 목적지가 같은 경우가 여러번 입력으로 들어오는 경우를 고려해줘야 한다
 * - 앞에서 작은 비용이 입력되었는데, 뒤 입력에서 더 큰 비용이 업력되어서 덮어버릴 수 있다
 * - 따라서 Math.min으로 현재 해당 인덱스의 값과 입력 값의 비용중 더 작은 것으로 입력되도록 해줘야 한다.
 * - 두번째는 INF 설정이다. Integer.MAX_VALUE로 하면 오버플로우가 발생하므로, 적당히 큰 수로 취해준다.
 * - 이렇게 완성한 결과를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void floydWarshall(int[][] graph, int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF){
                    sb.append("0").append(" ");
                }else{
                    sb.append(graph[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

    }

    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j){
                    continue;
                }
                graph[i][j] = INF;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], cost);
        }

        floydWarshall(graph, n);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}

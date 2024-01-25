import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 플로이드-워셜 알고리즘 학습 목적으로 풀었습니다
 * - 주어진 2차원 배열에서 출발지 - 경유지가 1인경우, 경유지 - 목적지가 1인경우 해당 출발지-목적지 인덱스에 1을 넣는다
 * - 출발지 -경유지, 경유지 - 목적지가 모두 가능한 경우, 출발지 - 목적지도 가능하기 떄문.
 * - 이후 완성된 배열을 출력하면 정답이된다.
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
                    if(graph[j][i] == 1 && graph[i][k] == 1){
                        graph[j][k] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall(graph,n);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 플로이드 와샬로 풀 수 있는 문제인가 의문이 들었다. 다익스트라도 가능할 것 같기도 하고... 벨만포드도 불가능한건 아니라 생각했다
 * 2. 하지만 이 문제에서는 어떠한 길을 선택하더라도 같은 교차로를 다시 방문하는 경우가 있는지를 판단하는 문제다. 일단 다익스트라는 불가능하고, 벨만포드는 연결된 그래프에 한해서만 모든 탐색이 이루어지기 때문에 결국 플로이드 와샬을 선택해야한다
 * 3. 주어진 그래프는 방향 그래프이며 초기값은 최대치 + 1인 10001로 초기화하였다
 * 4. 플로이드 와샬을 통해 arr[j][i]가 1이고 arr[i][k]가 1이면 arr[j][k]는 1로 초기화한다. 이것은 해당 경로로 방문했음을 체크하는 것이다
 * 5. 이후 ans 값을 NO CYCLE로 초기화하고, 1번에서 출발한다고 했으니 arr[1][i]가 1이며, arr[i][i] 1인지 체크해서 만약 참이라면 CYCLE로 변경한다
 * 6. arr[i][1]이 1인지 체크하는 것은 해당 경로로 갈 수 있는지 체크하는 것이고, arr[i][i]는 사이클을 검사하는 것이다.
 * 7. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i==j){
                    continue;
                }
                arr[i][j] = 10001;
            }
        }

        for (int i = 1; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][a] = 1;
            }
        }

        floydWarshall(n);
        String ans = "NO CYCLE";
        for (int i = 1; i < n; i++) {
            if(arr[1][i] == 1 && arr[i][i] == 1){
                ans = "CYCLE";
            }
        }

        bw.write(ans);

        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(arr[j][i] == 1 && arr[i][k] == 1){
                        arr[j][k] = 1;
                    }
                }
            }
        }

    }

}


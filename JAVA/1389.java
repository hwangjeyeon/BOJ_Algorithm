import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 모든 지점에 대해 모든 지점과 연결될 수 있는 관계를 구하는 방법이라 플로이드 와샬로 풀 수 있는 문제다.
 * 2. 2차원 배열을 만들었으며, 관계는 양방향 관계를 1로 맺어주었다.
 * 3. 케빈 베이컨의 수가 가장 작은 사람을 출력하기 위해 플로이드 와샬 진행 후에 이중포문으로 한 지점의 값을 모두 더한 뒤, min보다 작다면 갱신하고 ans에 i를 넣는 방식으로 진행했다
 * 4. 이때 Integer.MAX_VALUE를 하면 예제 케이스가 1이 나와버린다. 아마 오버플로우가 발생한 것으로 예상되며 친구의 최대 관계수인 5000보다 1 큰 5001로 초기화했더니 문제가 해결되었다.
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int[][] list;
    static int min = Integer.MAX_VALUE;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(list[i], 5001);
            list[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a][b] = 1;
            list[b][a] = 1;
        }


        floydWarshall(n);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    list[j][k] = Math.min(list[j][k], list[j][i] + list[i][k]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int tmp = 0;
            for (int j = 1; j < n + 1; j++) {
                tmp += list[i][j];
            }
            if(min > tmp){
                min = tmp;
                ans = i;
            }

        }

    }

}


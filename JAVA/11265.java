import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 플로이드 와샬로 최단거리를 미리 정렬해둔다음 주어진 조건에 해당되는지 체크하면 되는 쉬운 문제다
 * 2. 처음에는 입력값을 관리하는 배열과 최단거리를 담을 배열을 별도로 분리하였는데, 예외때문에 문제가 틀려버린다
 * 3. 최단거리를 담는 배열은 최닷값으로 갱신해두고 timetable을 비교해서 업데이트 하는데, 그럼 갱신되지 않은 timetable로 비교하다보니 원하는 값을 얻지 못하는 예외가 발생한다
 * 4. 따라서 입력값을 관리하는 배열만을 가지고 플로이드 와샬 알고리즘을 돌려 최단거리를 미리 파악해둔 뒤, 주어진 조건에 해당되는지 체크하고 정답을 출력하면 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static int[][] timetable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        timetable = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                timetable[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floydWarshall(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            String ans = "Stay here\n";
            if(timetable[start][end] <= time){
                ans = "Enjoy other party\n";
            }
            bw.write(ans);
        }


        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(j == k){
                        continue;
                    }
                    timetable[j][k] = Math.min(timetable[j][k], timetable[j][i] + timetable[i][k]);
                }
            }
        }
    }

}


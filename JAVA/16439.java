import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 백트래킹으로 해결하는 문제다
 * 2. 방문배열을 두고 현재 번호에 해당하는 치킨을 선택했을때와 안했을 때로 백트래킹 기법을 이용하여 진행한다
 * 3. 깊이가 3이 되면 base condition이 되며, 이때 조건을 검증한다
 * 4. 이중포문을 도는데, 먼저 안쪽 포문에서는 m만큼 순회를 돌면서 방문체크된 번호에 해당되는 경우, max에 최댓값을 비교해서 넣어준다
 * 5. n만큼 반복하면서 max의 값을 sum에 더해준다
 * 6. 마지막으로 순회가 끝났을 때, ans에 sum과 비교해서 더 큰 값을 넣어주면 된다
 * 7. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(m^3*n*m)
 * 공간복잡도: O(n*m)
 *
 */



public class Main {


    static int[][] arr;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
            }
        }
        visited = new boolean[m];
        backtracking(n,m, 0,0);

        bw.write(ans+"");


        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int start, int depth) {
        if(depth == 3){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = 0; j < m; j++) {
                    if(visited[j]){
                        max = Math.max(max, arr[i][j]);
                    }

                }
                sum += max;
            }
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = start; i < m; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtracking(n,m, i+1, depth+1);
                visited[i] = false;
            }
        }

    }

}


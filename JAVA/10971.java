import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값이 11 이하라서 브루트포스나 백트래킹으로 풀 수 있는 문제다
 * 2. 백트래킹으로 풀었다. 외판원 문제는 어느 한 지점에서 시작했을 때, 다른 지점을 다 돌고 마지막에 시작지점으로 돌아오는 경우를 구하는 문제다
 * 3. 이때, 최소값을 구하기 위해 모든 지점을 시작지점으로 하여 탐색한다.
 * 4. 시작지점에 대해서는 꼭 방문 체크를해주자
 * 5. 백트래킹으로 모든 지역을 탐색하며, 이동 비용에 대해서도 파라미터에 넣어주자. 시작지점과 현재지점, depth모두 파라미터로 받는다
 * 6. depth가 n-1과 같을때가 base condition이다. 이때, 그 지점에서 바로 시작지점으로 가면 되기 때문에, 만약 그 지점이 0 이 아니라면 길이 있는 것이므로 arr[now][start]가 0이 아닐테 다음을 진행한다
 * 7. 현재 위치에서 시작위치로 가는 비용을 sum에 더하고 최솟값은 ans에 넣어준다
 * 8. 완성한 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n!)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {


    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtracking(i,i,0, n,0);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int start, int now, int depth, int n, int sum) {

        if(depth == n-1){
            if(arr[now][start] != 0){
                sum += arr[now][start];
                ans = Math.min(ans,sum);
            }
            return;
        }



        for (int i = 0; i < n; i++) {
            if(!visited[i] && arr[now][i] != 0){
                visited[i] = true;
                backtracking(start, i, depth+1, n,sum + arr[now][i]);
                visited[i] = false;
            }
        }

    }
}


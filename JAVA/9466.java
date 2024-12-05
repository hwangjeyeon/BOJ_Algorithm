import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 순환그래프냐 아니냐를 구분하는 문제다
 * 2. N의 최대를 보고 BFS인가 싶었는데, 연결된 사람으로 쭉 따라들어가며 순환그래프 여부를 파악하는 문제이므로 DFS로 해결하는 문제다
 * 3. 기존 dfs와 한가치 차이점이 있다면 방문배열만 사용하는 것이 아닌 완료 배열을 사용하는 것이다
 * 4. 이렇게 한다면, 탐색에 대해서는 다른 시작지점을 기준으로 했을 때, 상관없이 진행할 수 있으면서도 중복 탐색을 하지 않고 종료지점을 순환할 경우 종료지점을 찾아 정답을 찾을 수 있다
 * 5. 방문했던 지점을 다시 방문하면 순환하고 있다는 것이므로 ans 값을 증가시키고 해당 지점을 완료지점으로 표시한다
 * 6. 다시 순회해서 돌아올 때, 방문지점을 체크하기 전에 먼저 완료지점을 체크해서 만약 이미 완료되었다면 재귀를 종료시킨다
 * 7. 이후 이어지는 재귀들을 완료표시하고 방문은 해제하며 이후 탐색에는 열어둔다.
 * 8. 이렇게 구한 ans의 개수를 n에서 빼준다면 프로젝트 팀에 속하지 못한 학생들의 수를 구할 수 있다
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(t*n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    static int ans = 0;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            finish = new boolean[n+1];
            for (int i = 1; i < n+1; i++) {
                if(!finish[i]){
                    dfs(i);
                }
            }


            bw.write((n-ans)+"\n");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        if(finish[now]){
            return;
        }
        if(visited[now]){
            ans++;
            finish[now] = true;
        }

        visited[now] = true;
        dfs(arr[now]);
        finish[now] = true;
        visited[now] = false;
    }
}

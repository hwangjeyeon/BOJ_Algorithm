import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. BFS로 해결할 수 있는 문제다.
 * 2. DFS로 하기에는 K의 최대가 백만이기 때문에 불가능하고 bfs로 해야한다
 * 3. 방문배열은 모든 지점에 대해서로 크기를 구성한다
 * 4. 1을 더하는 경우와 곱하는 경우를 나눠서 BFS 탐색을 진행하며, 큐는 배열로 넣고, 현재값과 누적된 탐색값을 원소로 갖도록한다
 * 5. 방문배열을 통해 중복탐색을 방지하며, 큐에서 꺼낸값이 목표하는 target과 같으면 ans에 now[0]과 ans값을 비교하여 더 작은 값을 넣어준다
 * 6. 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(k)
 * 공간복잡도: O(k)
 *
 */



public class Main {

    static int[] dx = {1, 2};
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001];
        bfs(a, k);

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

    private static void bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == target){
                ans = Math.min(ans, now[1]);
            }


            for (int i = 0; i < 2; i++) {
                if(i == 0){
                    int nx = now[0] + dx[i];
                    if(nx <= target && !visited[nx]){
                        visited[nx] = true;
                        q.add(new int[]{nx, now[1] + 1});
                    }
                }else{
                    int nx = now[0] * dx[i];
                    if(nx <= target && !visited[nx]){
                        visited[nx] = true;
                        q.add(new int[]{nx, now[1] + 1});
                    }
                }
            }

        }

    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 2차원 배열로 네트워크를 구성하였다. 2차원 배열은 각각 특정 네트워크와 그 네트워크와 연결된 네트워크 번호로 인덱스가 구성되고, 값으로는 그 인덱스와 연결되었는가? 이다
 * 2. 0이면 연결되어 있지 않고, 1이면 연결되어있다. 이후 한가지 더 사용할 것인데, -1이면 탐색을 완료했다는 의미이다
 * 3. 입력값을 받는데 방향이 정해져 있지 않은 양방향 그래프이므로 주어진 두 값 모두 1로 연결시켜준다
 * 4. 이어서 BFS 탐색을 진행한다. 시작값인 1과 배열을 넘겨준다
 * 5. 큐를 사용하여 BFS 탐색을 진행한다. 시작값을 넣고 큐가 빌때까지 반복한다.
 * 6. 각 탐색마다 큐에서 poll한 값을 기준으로 순회를 진행한다. 만약 1이면 양방향 모두 -1로 바꿔주고, 큐에 해당 위치인 i를 넣은 뒤 count++를 해준다
 * 7. 한가지 더 고려할 사항이 있는데, 각 컴퓨터를 방문했는가를 판단해주어야 한다. 그렇지 않으면 중복으로 탐색해서 원하는 결과를 얻지 못하게 된다.
 * 8. 따라서 visited배열을 선언하고 6번 조건에서 방문을 하지 않았을 때 진행하도록 추가하고 진행과정에서 visited[] = true를 통해 방문했음을 표시한다
 * 9. 완성한 count를 출력하면 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {
    static int count = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first][second] = 1;
            arr[second][first] = 1;
        }

        bfs(arr, 1);
        bw.write(count+"");
        br.close();
        bw.close();
    }

    private static void bfs(int[][] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 1; i < arr[now].length; i++) {
                if(!visited[i] && arr[now][i] == 1){
                    arr[now][i] = -1;
                    arr[i][now] = -1;
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }


    }

}


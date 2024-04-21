import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 전형적인 BFS 문제이지만 몇가지를 고려해야한다.
 * 
 * 해결방법: 
 * 1. 텔레포트는 양방향이다. 단방향으로 하면 안된다! 
 * 2. 양방향으로 이을 때는 리스트배열을 선택하자! 메모리와 시간 초과 발생을 줄이기 위한 방법이다.
 * 3. 만약 일반적인 이동과 다른 속성을 확인해야 한다면 분리해서 탐색하자. 예를들어 +1, -1과 같은 단순 이동을 먼저 탐색하고 큐에 넣어주고, 해당 위치의 속성값에 해당하는 경우 (해당 문제에서는 텔레포트) 다시 탐색해서 리스트 배열에 연결된 정보를 이용해서 순회한다
 * 4. 이 문제에서는 방문 배열 대신 탐색 여부를 해당 지점이 0인지 아닌지로 판단하였다
 * 5. 그리고 추가적으로 최소 위치를 찾기 위해 도착지점이 현재 지점인 경우 탐색을 바로 종료하고 출력하였으며, 시간을 나타내기 위해 이전 지점의 값에 1을 더한 값을 현재 지점에 넣는 방식을 채택하였다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static List<Integer>[] lists;
    static int[] field;
    static int[] dx = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrived = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            lists[p1].add(p2);
            lists[p2].add(p1);
        }
        field = new int[n+1];
        bfs(n,start,arrived);
        bw.write(field[arrived]+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int start, int arrived) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == arrived){
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nx = now + dx[i];
                if(nx >= 0 && nx < n+1 && field[nx] == 0){
                    field[nx] = field[now] + 1;
                    q.add(nx);
                }
            }
            for (int i = 0; i < lists[now].size(); i++) {
                int teleport = lists[now].get(i);
                if(field[teleport] == 0){
                    field[teleport] = field[now] + 1;
                    q.add(teleport);
                }
            }


        }
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 좌표 시뮬레이션 탐색을 돌리는 BFS문제가 아니다.
 * 2. 이 문제는 좌표 하나씩 늘리는 것이 아닌, 각 지점을 노드로 잡고, 맨해튼 거리를 이용해서 탐색하는 문제다
 * 3. 먼저 맥주 20개가 50미터당 소비되니까 1000미터 이내에 현재지점에서 갈 수 있는 노드가 있으면 탐색을 진행할 수 있다
 * 4. 이를 이용하면 처음 시작지점과 편의점 그리고 도착 지점을 각 노드로 잡고 탐색을 한다
 * 5. 편의점의 개수만큼 탐색해서 만약 각 지점이 맨해튼 거리(x축차이 + y축차이)가 1000이하면 방문 여부를 체크하고 큐에 넣는다
 * 6. 만약 현재 지점에서 도착 지점까지의 맨해튼 거리가 1000이하면 isOk를 true로 하고 종료한다
 * 7. isOk에 따라 알맞는 정답을 출력하면 정답이 된다. 
 * 
 * - 이 문제는 플로이드 와샬로도 풀 수있는 문제다. 이후 플로이드-와샬 재복습 후 다시 풀어볼 계획이다
 * - 추가로 단순 좌표 시뮬레이션 유형의 BFS 문제에서 이렇게 각 좌표를 노드로 인식하고 탐색하는 문제는 처음 본 것 같다
 * - 해당 문제를 꼭 복습해서 해당 bfs 유형도 체득하자!
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static List<int[]> list;
    static boolean isOk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            isOk = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                list.add(new int[]{p2, p1});
            }
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startY, startX, endY, endX, n);
            if(isOk){
                bw.write("happy\n");
            }else{
                bw.write("sad\n");
            }
        }




        br.close();
        bw.close();
    }

    private static void bfs(int startY, int startX, int endY, int endX, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[]{startY, startX});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(Math.abs(now[0] - endY) + Math.abs(now[1] - endX) <= 1000){
                isOk = true;
                return;
            }

            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    int[] next = list.get(i);
                    if(Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) <= 1000){
                        visited[i] = true;
                        q.add(next);
                    }
                }
            }


        }

    }


}


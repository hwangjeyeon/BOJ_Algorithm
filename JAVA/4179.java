import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 상태변화를 동시에 해야하는 요소가 두개가 있어서 시뮬레이션을 돌려야하나 싶었는데, 그렇게 하면 시간초과 발생 위험이 있다
 * 2. 이 문제는 두 요소를 동시에 BFS를 해야한다. 대신 우선순위를 통해 적절히 조절해야한다
 * 3. 우선순위를 적절하게 조절하는 방법은 BFS의 자료구조를 큐에서 우선순위 큐로 바꾸는 것이다
 * 4. 처음에는 들어간 시간 순서대로 더 빨리 들어간 것을 먼저 우선순위가 높게 하도록 설정하였다
 * 5. 이어서 J의 초기 위치를 넣고, 불의 위치를 모두 우선순위 큐에 넣는다.
 * 6. 방문배열은 두 요소를 분리해서 서로 독립되게 방문체크하도록하자. 이번 풀이에서는 2차원 -> 3차원으로 늘려서 0은 J, 1은 불로 체크하도록 했다
 * 7. BFS하는 중 만약 이번에 뽑은 값이 J라면, 내 상하좌우의 위치가 인덱스를 벗어나는 값인지 확인하고 맞다면 정답에 현재까지 누적한 거리 + 1을 넣은 뒤 탐색을 종료한다
 * 8. BFS동안에는 빈칸만 이동하며 요소에 따라 구분지어서 큐에 넣는다. 
 * 9. J의 경우 불의 방문 여부와 자기자신의 방문여부를 모두 체크해서 넣고, 불은 자기자신의 방문여부만 체크해서 넣는다
 * 10. 이렇게 완성한 결과 ans의 변화가 없어 0이라면 IMPOSSIBLE을 출력하고 아니라면 그 값을 출력한다
 * 11. 하지만 이렇게 할 경우 88%에서 틀리는데 한가지를 생각하지 않았기 때문이다. 바로 큐에 들어온 시간이 같을 때, 불이 무조건 앞서야하는데 그 정렬조건을 추가하지 않았다
 * 12. 따라서 J보다 불을 우선순위 큐에서 더 우선순위가 높게 갖도록 설정하자
 * 13. 이렇게 하면 정답으로 잘 통과한다.
 * 
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(r*c + (r+c))
 * 공간복잡도: O(r*c)
 *
 */


public class Main {

    static char[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;
    static int ans = 0;
    static int[] start = new int[2];
    static List<int[]> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c][2];
        fire = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s[j];
                if(arr[i][j] == 'J'){
                    start[0] = i;
                    start[1] = j;
                }
                if(arr[i][j] == 'F'){
                    fire.add(new int[]{i,j});
                }
            }
        }

        bfs(r,c,start[0], start[1]);



        if(ans == 0){
            bw.write("IMPOSSIBLE");
        }else{
            bw.write(ans+"");
        }
        

        br.close();
        bw.close();
    }

    private static void bfs(int r, int c, int y, int x) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
            if(o1[2] == o2[2]){
                return o2[3] - o1[3];
            }
            return o1[2] - o2[2];
        });
        q.add(new int[]{y,x,0,1, 0});
        visited[y][x][0] = true;
        for (int i = 0; i < fire.size(); i++) {
            q.add(new int[]{fire.get(i)[0], fire.get(i)[1], 0, 2, 0});
            visited[y][x][1] = true;
        }
        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[3] == 1){
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(ny < 0 || ny >= r || nx < 0 || nx >= c){
                        ans = now[2] + 1;
                        return;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < r && nx >= 0 && nx < c && arr[ny][nx] == '.'){
                    if(now[3] == 1){
                        if(!visited[ny][nx][0] && !visited[ny][nx][1]){
                            q.add(new int[]{ny,nx, now[2] + 1, now[3], now[4] + 1});
                            visited[ny][nx][0] = true;
                        }
                    }else{
                        if(!visited[ny][nx][1]){
                            q.add(new int[]{ny,nx, now[2] + 1, now[3], now[4] + 1});
                            visited[ny][nx][1] = true;
                        }
                    }
                }
            }

        }

    }

}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 상하좌우 움직임과 말로 움직이는 경우를 나눠서 BFS를 하면 해결할 수 있을 것이라 생각하였다
 * 2. 대신 구분을 지어주기 위해서 방문배열을 boolean 타입의 3차원 배열로 설정하였고, 원하는 위치에 도착한 경우 이동거리로 ans를 갱신한 뒤 종료 후에 출력하도록 했다
 * 3. 못 찾는 경우를 대비해서 -1로 미리 설정해두었다
 * 4. 방문배열 1차원 인덱스의 0번은 상하좌우 탐색, 1번은 말 탐색으로 설정하였고, 각각을 독립적으로 생각해서 탐색하도록 했다
 * 5. 만약 0보다 작은 경우는 말 탐색을 하지 않고 continue한다
 * 6. 하지만 3%에서 틀렸다. 반례로 확인해봤을 때 다음과 같았다
 * 7. 반례 첫번째는 다음과 같다
 * 1
 * 6 5
 * 0 1 1 1 1 1
 * 1 1 0 1 1 1
 * 1 1 0 1 0 1
 * 1 1 0 0 1 1
 * 1 1 1 0 0 0
 *
 * 실행결과: 7
 * 8. 0 미만일 때, continue하면 이후 탐색을 못하고 -1이 출력된다
 * 9. 두번째는 다음과 같다
 * 2
 * 10 2
 * 0 0 1 0 0 1 0 0 1 0
 * 0 0 1 1 0 0 0 0 1 0
 * 10. 0 이하일때, -1이 출력된다. 앞서나간 말의 움직임 이후, 상하좌우로 움직였을 때, 미리 방문처리되어버리기 때문이다.
 * 11. 0이하이거나 미만일때 각각 실패한다. 다른 방법을 생각해야한다.
 * 12. int형 타입으로 방문 배열을 바꾸는 죽음의 비 문제를 떠올렸다. 하지만 이 문제는 체력이 존재하지 않기 때문에, 해당 방식은 적용하기 쉽지 않다
 *
 * 해결방법:
 * 1. 찾은 방법은 3차원 boolean 타입의 방문배열을 유지하지만, 조금 다르게 크기를 설정한다. 1차원 인덱스의 크기를 k+1로 설정해주는 것이다
 * 2. 이렇게 하면 k의 전체 크기가 k일 때, 해당 방문을 방문했는지 여부로 판단할 수 있고, 중복 탐색은 막으면서 독립적인 탐색에는 영향을 주지 않는다
 * 3. 처음일 떄는 k번째 인덱스에 true로 체크하고, 이어서 상하좌우 탐색일 때는 cur[3]위치를 방문하지 않은 경우 방문체크하고 큐에 넣는다
 * 4. 말 움직임일 때는 cur[3]-1위치를 방문하지 않은 경우 cur[3]-1위치를 방문체크하고 큐에 넣어준다
 * 5. 이렇게 하면 정답이 된다!
 * 
 * [테스트 케이스]
 * 1
 * 5 5
 * 0 1 1 1 1
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 1 0 1 1
 * 1 1 1 1 0
 *
 * 실행 결과: -1
 *
 *
 * 4
 * 6 5
 * 0 1 1 1 1 1
 * 1 1 0 1 1 1
 * 1 1 1 1 1 0
 * 1 1 1 0 1 1
 * 1 1 1 1 1 0
 *
 * 실행 결과: 3
 *
 *
 * 4
 * 6 5
 * 0 0 0 0 0 0
 * 0 1 0 1 1 0
 * 0 1 1 1 1 0
 * 0 1 1 0 1 0
 * 0 0 0 0 0 0
 *
 * 실행결과: 3
 *
 *
 * 4
 * 6 5
 * 0 0 0 0 0 0
 * 0 1 0 1 1 0
 * 0 1 1 1 1 0
 * 0 1 1 1 1 0
 * 0 0 0 0 0 0
 *
 * 실행결과: 5
 *
 *
 * 시간복잡도: O(h*w)
 * 공간복잡도: O(h*w)
 *
 */


public class Main {

    static int[][] arr;
    static int ans = -1;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] hx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w][k+1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(h,w,k);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int h, int w, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,k});
        visited[0][0][k] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == h-1 && cur[1] == w-1){
                ans = cur[2];
                return;
            }


            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < h && nx >= 0 && nx < w && !visited[ny][nx][cur[3]] && arr[ny][nx] == 0){
                    q.add(new int[]{ny,nx,cur[2] + 1, cur[3]});
                    visited[ny][nx][cur[3]] = true;
                }
            }
            if(cur[3] <= 0){
                continue;
            }


            for (int i = 0; i < 8; i++) {
                int ny = cur[0] + hy[i];
                int nx = cur[1] + hx[i];
                if(ny >= 0 && ny < h && nx >= 0 && nx < w && !visited[ny][nx][cur[3]-1] && arr[ny][nx] == 0){
                    q.add(new int[]{ny,nx,cur[2] + 1, cur[3]-1});
                    visited[ny][nx][cur[3]-1] = true;
                }
            }


        }



    }

}

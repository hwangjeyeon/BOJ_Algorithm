import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. BFS + 정육각형에 대한 이해 + 아이디어가 모두 충족해야 풀 수 있는 문제다
 * 2. 먼저 주어진 직사각형 좌표를 정사각형으로 변환하고, 탐색도 그에 맞춰서 준비해야한다
 * 3. BFS 탐색 y,x 배열은 주어진 그림을 보고 만들면 된다. 
 * 4. 직사각형 좌표로 주어진 배열은 그림을 보고 생각으로 변환해주어야 한다
 * 5. BFS에서는 현재 y가 홀수일 때와 짝수일 떄를 구분해서 탐색을 해준다
 * 6. 이어서 바깥쪽에서 보이는 벽의 개수를 세어주어야한다. 이 부분이 굉장히 까다롭다.
 * 7. 안쪽에 있는 벽이 없는 구역은 6번의 개수에서 제외해주어야한다. 
 * 8. 따라서 생각한 방법은 먼저 인접한 영역이 벽(1)이면 해당 좌표의 값을 가지고 있는 result 배열의 값을 1 증가시켜준다
 * 9. 8번 이면 continue해주고 만약 벽이 아니면 미방문시, 방문 체크하고 큐에 넣어서 탐색을 진행한다
 * 10. 이렇게 하면 바깥쪽에서 벽을 바라볼 때만 값이 세어진다. 안쪽에서 벽을 세는 경우는 없다
 * 11. 마지막 벽이 조금 걸리는데, outofIndex 에러도 있고, 맨 오른쪽 벽이 인접한 경우는 셀 수 없는 상황도 나온다
 * 12. 따라서 w+2, h+2로 애초에 배열의 값을 하나 더 추가해서 벽 없는 구역이 우측에 하나씩 더 있다고 가정하고 벽을 세어주었다
 * 13. 이제 완성한 result의 값들을 answer에 더해서 출력하면 정답이 된다.
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[][] result;
    static int[][] odd = {{0,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0}};
    static int[][] even = {{0,-1},{-1,-1,},{-1,0},{0,1},{1,0},{1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[h+2][w+2];
        visited = new boolean[h+2][w+2];
        result = new int[h+2][w+2];
        for (int i = 1; i < h+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < w+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    visited[i][j] = true;
                }

            }
        }

        bfs(0,0,w,h);
        int answer = 0;
        for (int i = 0; i < h + 2; i++) {
            for (int j = 0; j < w+2; j++) {
                answer += result[i][j];
            }
        }
        bw.write(answer+"");

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x, int w, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x, 0});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 6; i++) {
                int ny;
                int nx;
                if(now[0] % 2 == 0){
                    ny = now[0] + even[i][0];
                    nx = now[1] + even[i][1];
                }else{
                    ny = now[0] + odd[i][0];
                    nx = now[1] + odd[i][1];
                }

                if(ny >= 0 && nx >= 0 && ny < h+2 && nx < w+2){
                    if(arr[ny][nx] == 1){
                        result[y][x] += 1;
                        continue;
                    }

                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }


                }
            }


        }


    }


}


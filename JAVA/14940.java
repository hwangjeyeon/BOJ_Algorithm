import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 일단 최소 경시대회나 최대 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - BFS 탐색 알고리즘으로 해결했습니다.
 * 1. map을 입력받을 때 2를 발견하면 큐에 넣고 visited배열의 해당 위치에 0을 넣습니다
 * 2. 0을 발견하면 visited 배열에 0, 그외를 발견하면 visited 배열에 -1을 넣습니다
 * 3. BFS 탐색 알고리즘을 이용하여 상하좌우를 탐색하여 visited 배열에 값을 넣고 최종 값을 출력합니다.
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Queue<Integer> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = 0;
                }else if(map[i][j] == 0){
                    visited[i][j] = 0;
                }else{
                    visited[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();
            if(y-1 >= 0 && visited[y-1][x] == -1){
                visited[y-1][x] = visited[y][x] + 1;
                q.add(y-1);
                q.add(x);
            }

            if(y+1 < n && visited[y+1][x] == -1){
                visited[y+1][x] = visited[y][x] + 1;
                q.add(y+1);
                q.add(x);
            }

            if(x-1 >= 0 && visited[y][x-1] == -1){
                visited[y][x-1] = visited[y][x] + 1;
                q.add(y);
                q.add(x-1);
            }

            if(x+1 < m && visited[y][x+1] == -1){
                visited[y][x+1] = visited[y][x] + 1;
                q.add(y);
                q.add(x+1);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bw.write(visited[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

}

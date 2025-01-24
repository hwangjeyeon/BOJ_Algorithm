import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS와 깡구현을 섞은 문제다
 * 2. 통나무의 가운데 지점을 기준으로 탐색한다
 * 3. 방향도 기억해야하는데 가로일때와 세로일때를 구분해야한다
 * 4. 이점을 이용해서 중간 지점이 종료지점에 도착하면 방향에 따라 주위를 탐색해서 같은지 확인하고 같다면 지금까지의 거리를 리턴한다
 * 5. ans에 거리를 받아 출력하면 정답이 된다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */
class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Log{
    int x;
    int y;
    int dir;
    int dist;

    public Log(int x, int y, int dir, int dist) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.dist = dist;
    }
}


public class Main {

    static int n;
    static char[][] arr;
    static Pos[] start;
    static Pos[] end;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        start = new Pos[3];
        end = new Pos[3];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'B'){
                    start[idx1++] = new Pos(i, j);
                }
                if(arr[i][j] == 'E'){
                    end[idx2++] = new Pos(i, j);
                }
            }
        }
        int ans = bfs();

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[2][n][n];
        Queue<Log> q = new LinkedList<>();
        int nowDir = -1;
        if(start[0].y + 1 == start[1].y){
            nowDir = 0;
        }else{
            nowDir = 1;
        }
        q.add(new Log(start[1].x, start[1].y, nowDir, 0));
        visited[nowDir][start[1].x][start[1].y] = true;
        while(!q.isEmpty()){
            Log now = q.poll();

            if(now.x == end[1].x && now.y == end[1].y){
                if(now.dir == 0 && arr[now.x][now.y-1] == 'E' && arr[now.x][now.y+1] == 'E'){
                    return now.dist;
                }else if(now.dir == 1 && arr[now.x-1][now.y] == 'E' && arr[now.x+1][now.y] == 'E'){
                    return now.dist;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(!isRange(nx,ny,now.dir, i)){
                    continue;
                }
                if(visited[now.dir][nx][ny]){
                    continue;
                }

                visited[now.dir][nx][ny] = true;
                q.add(new Log(nx, ny, now.dir, now.dist+1));
            }

            if(canRotate(now.x, now.y)){
                if(now.dir == 0 && !visited[1][now.x][now.y]){
                    visited[1][now.x][now.y] = true;
                    q.add(new Log(now.x, now.y, 1, now.dist+1));
                }else if(now.dir == 1 && !visited[0][now.x][now.y]){
                    visited[0][now.x][now.y] = true;
                    q.add(new Log(now.x, now.y, 0, now.dist+1));
                }
            }

        }
        return 0;
    }

    private static boolean canRotate(int x, int y) {
        for (int i = x-1; i <= x + 1; i++) {
            for (int j = y-1; j <= y + 1; j++) {
                if(i < 0 || i >= n || j < 0 || j >= n){
                    return false;
                }
                if(arr[i][j] == '1'){
                    return false;
                }
            }
        }

        return true;
    }


    private static boolean isRange(int x, int y, int dir, int i) {
        switch(dir) {
            case 0:
                if(i < 2) {
                    if(x < 0 || x >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x][y - 1] == '1' || arr[x][y + 1] == '1'){
                        return false;
                    }
                }
                else {
                    if(y - 1 < 0 || y + 1 >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x][y - 1] == '1' || arr[x][y + 1] == '1'){
                        return false;
                    }
                }
                break;
            case 1:
                if(i < 2) {
                    if(x - 1 < 0 || x + 1 >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x - 1][y] == '1' || arr[x + 1][y] == '1'){
                        return false;
                    }
                }
                else {
                    if(y < 0 || y >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x - 1][y] == '1' || arr[x + 1][y] == '1'){
                        return false;
                    }
                }

                break;

        }

        return true;
    }
}

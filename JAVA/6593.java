import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그냥 간단한 3차원 BFS 문제다.
 * 2. 입력 조건에 맞춰서 시작지점과 종료지점 찾고 종료지점에 맞춰서 이동거리와 함꼐 정답을 출력하면 된다
 * 3. 만약 정답이 바뀌지 않은 경우 초기값인 실패했을 때의 값을 출력하므로 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(l*r*c)
 * 공간복잡도: O(l*r*c)
 *
 */
public class Main {

    static int l;
    static int r;
    static int c;
    static char[][][] arr;
    static String ans = "Trapped!";
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l == 0 && r == 0 && c == 0){
                break;
            }
            arr = new char[l][r][c];
            int[] start = new int[3];
            int[] end = new int[3];
            ans = "Trapped!";
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        arr[i][j][k] = s.charAt(k);
                        if(arr[i][j][k] == 'S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                        if(arr[i][j][k] == 'E'){
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs(start, end);
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[l][r][c];
        q.add(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(arr[now[0]][now[1]][now[2]] == arr[end[0]][end[1]][end[2]]){
                ans = "Escaped in " + now[3] + " minute(s).";
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nz = now[0] + dz[i];
                int ny = now[1] + dy[i];
                int nx = now[2] + dx[i];
                if(isRange(nz,ny,nx) && !visited[nz][ny][nx] && arr[nz][ny][nx] != '#'){
                   q.add(new int[]{nz, ny, nx, now[3]+1});
                   visited[nz][ny][nx] = true;
                }
            }

        }
    }

    private static boolean isRange(int nz, int ny, int nx) {
        return nz >= 0 && nz < l && ny >= 0 && ny < r && nx >= 0 && nx < c;
    }
}

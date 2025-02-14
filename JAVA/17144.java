import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 깡구현 문제 
 * 2. 주어진대로 구현하면된다. 확산은 동시에 이루어지므로 임시배열 만들어서 변경사항 반영 후 원본배열에 적용하는 방식으로 구현하면된다
 * 3. 주의할 점이 방문배열을 이용해서 동일한 좌표를 넣지 않도록 한다
 * 4. 처음에는 큐를 이용해서 풀었는데, 이럴 경우 시간이 자남에 따라 중복된 좌표가 큐에 들어가게 되므로 그러지 말고 그냥 시간마다 확산 로직에서 완전탐색을 진행한다
 * 5. 온풍기 위치가 0번열에 무조건 위치하고, 붙어서 상하로 두칸만 차지한다는 것을 이용해서 순환시켜주면 된다
 * 6. 또한 확산에서 음수가 되는 경우 0으로 바꿔준다
 * 7. 최종적으로 모든 배열의 값을 합산해서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(r*c)
 * 공간복잡도: O(r*c)
 *
 */


public class Main {

    static int r;
    static int c;
    static int t;
    static int[][] arr;
    static int[][] air;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int[] cry = {-1, 0, 1, 0};
    static int[] crx = {0, 1, 0, -1};
    static int[] rry = {1, 0, -1, 0};
    static int[] rrx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        air = new int[2][2];
        arr = new int[r][c];
        int pos = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1){
                    air[pos][0] = i;
                    air[pos][1] = j;
                    pos++;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spread();
            airCondition();
        }
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += arr[i][j] == -1 ? 0 : arr[i][j];
            }
        }
        bw.write(sum+"");

        br.close();
        bw.close();
    }

    private static void airCondition() {
        int fy = air[0][0]-1;
        int fx = air[0][1];
        for (int i = 0; i < 4; i++) {

            int ny = fy + cry[i];
            int nx = fx + crx[i];
            if(isRange(ny, nx) && ny <= air[0][0]){
                if(arr[ny][nx] == -1){
                    arr[fy][fx] = 0;
                    break;
                }
                arr[fy][fx] = arr[ny][nx];
                fy = ny;
                fx = nx;
                i--;

            }
        }
        fy = air[1][0] + 1;
        fx = air[1][1];
        for (int i = 0; i < 4; i++) {

            int ny = fy + rry[i];
            int nx = fx + rrx[i];
            if(isRange(ny, nx) && ny >= air[1][0]){
                if(arr[ny][nx] == -1){
                    arr[fy][fx] = 0;
                    break;
                }
                arr[fy][fx] = arr[ny][nx];
                fy = ny;
                fx = nx;
                i--;
            }
        }
    }


    private static void spread() {
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            tmp[i] = arr[i].clone();
        }
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] > 0){
                    int count = 0;
                    int sp = arr[i][j]/5;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(isRange(ny,nx) && tmp[ny][nx] != -1){
                            tmp[ny][nx] += sp;
                            count++;
                            if(!visited[ny][nx]){
                                visited[ny][nx] = true;
                            }

                        }
                    }
                    tmp[i][j] -= sp * count;
                    if(tmp[i][j] < 0){
                        tmp[i][j] = 0;
                    }
                    if(tmp[i][j] > 0){
                        visited[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            arr[i] = tmp[i].clone();
        }
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < r && nx >= 0 && nx < c;
    }

}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 깡구현 하면 된다. dx, dy 기법을 이용하면 조금 쉽게 구현할 수 있고, j-- 전략을 사용하면 퀸에 대해서도 쉽게 파악할 수 있다
 * 2. 몇가지 규칙을 잘 생각해야한다. 퀸은 장애물을 만나면 못 지나가지만 퀸이 지나간 자리는 지나갈 수 있다
 * 3. 나이트는 장애물을 넘을 수 있지만 장애물이 있는 위치로는 못간다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static int[][] arr;
    static int ans = 0;
    static int n;
    static int m;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] ddx = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] ddy = {-1, -2, 1, 2, -1, -2, 1, 2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                arr[x][y] = (i+1); // 1: 퀸, 2:나이트, 3: 폰
                lists.add(new int[]{x, y, (i+1)});
            }
        }

        for (int[] list : lists) {
            if(list[2] == 1){
                queen(list[0], list[1]);
            }else if(list[2] == 2){
                knight(list[0], list[1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();

    }

    private static void knight(int y, int x) {
        for (int j = 0; j < 8; j++) {
            int ny = y + ddy[j];
            int nx = x + ddx[j];
            if(isRange(ny, nx) && (arr[ny][nx] != 1 && arr[ny][nx] != 2 && arr[ny][nx] != 3)){
//                System.out.println(ny + " " + nx + " " + arr[ny][nx]);

                arr[ny][nx] = 4;
            }
        }
    }

    private static void queen(int x, int y) {
        int tmpX = x;
        int tmpY = y;
        for (int j = 0; j < 8; j++) {
            int ny = tmpX + dy[j];
            int nx = tmpY + dx[j];
            if(isRange(ny, nx) && (arr[ny][nx] != 1 && arr[ny][nx] != 2 && arr[ny][nx] != 3)){
                arr[ny][nx] = 4;
                j--;
                tmpX = ny;
                tmpY = nx;
                continue;
            }
            tmpX = x;
            tmpY = y;
        }
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < m;
    }
}

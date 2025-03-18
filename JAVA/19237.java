import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그냥 구현하면 된다. 깡구현 문제
 * 2. 상어는 클래스로 관리했고, smell은 클래스 만들지 않고 그냥 3차원 배열로 해서 관리했다
 * 3. 나머지는 조건에 맞춰서 구현하면 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*n*m)
 * 공간복잡도: O(n*n)
 *
 */
class Shark{
    int y;
    int x;
    int dir;
    int[][] prior = new int[4][4];

    public Shark(int y, int x){
        this.y = y;
        this.x = x;
    }

}

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int ans = 0;
    static Shark[] sharks;
    static int[][][] smell;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        sharks = new Shark[m];
        smell = new int[m][n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0){
                    sharks[arr[i][j]-1] = new Shark(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken()) - 1;
        }


        for (int i = 0; i < m; i++) {
            for (int tc = 0; tc < 4; tc++) {
                st = new StringTokenizer(br.readLine());
                int[] tmp = new int[4];
                for (int j = 0; j < 4; j++) {
                    tmp[j] = Integer.parseInt(st.nextToken()) - 1;
                }
                sharks[i].prior[tc] = tmp;
            }
        }
        spread();
        while(true){
            if(ans > 1000){
                ans = -1;
                break;
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                if(sharks[i] != null){
                    count++;
                }
            }
            if(count <= 1){
                break;
            }

            moves();
            arr = new int[n][n];
            for (int i = 0; i < m; i++) {
                if(sharks[i] == null){
                    continue;
                }
                if(arr[sharks[i].y][sharks[i].x] != 0){
                    sharks[i] = null;
                    continue;
                }
                arr[sharks[i].y][sharks[i].x] = i+1;
            }
            down();
            spread();
            ans++;

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void moves() {
        for (int tc = 0; tc < m; tc++) {
            Shark now = sharks[tc];
            if(now == null){
                continue;
            }
            List<int[]> lists = new ArrayList<>(); // 냄새없는 구간 개수
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(isRange(ny, nx)){
                    boolean isSmell = false;
                    for (int j = 0; j < m; j++) {
                        if(smell[j][ny][nx] != 0){
                            isSmell = true;
                            break;
                        }
                    }

                    if(!isSmell){
                        lists.add(new int[]{ny,nx, i});
                    }
                }
            }

            // 냄새 없는 구간이 하나라도 있으면 그 구간으로 이동
            if(!lists.isEmpty()){
                Shark shark = priorChecks(lists, now);
                sharks[tc] = shark;
                continue;
            }
            // 냄새 없는 구간이 아예 없으면 내 냄새가 있는 구간으로 이동
            lists = new ArrayList<>(); // 내 냄새가 있는 구간
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(isRange(ny, nx)){
                    if(smell[tc][ny][nx] != 0){
                        lists.add(new int[]{ny, nx, i});
                    }
                }
            }

            if(!lists.isEmpty()){
                Shark shark = priorChecks(lists, now);
                sharks[tc] = shark;
            }

        }

    }

    private static Shark priorChecks(List<int[]> list, Shark now) {
        int[] tmp = now.prior[now.dir];
        int ny = -1;
        int nx = -1;
        int dir = -1;
        Shark shark = null;
        for (int i = 0; i < 4; i++) {
            for (int[] a : list) {
                if(a[2] == tmp[i]){
                    ny = a[0];
                    nx = a[1];
                    dir = a[2];
                    break;
                }
            }
            if(ny != -1 && nx != -1 && dir != -1){
                shark = new Shark(ny, nx);
                shark.dir += dir;
                shark.dir %= 4;
                shark.prior = now.prior;
                break;
            }
        }

        return shark;
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }

    private static void down() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if(smell[i][j][l] != 0){
                        smell[i][j][l]--;
                    }
                }
            }
        }
    }

    private static void spread() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if(sharks[i] == null){
                        continue;
                    }
                    smell[i][sharks[i].y][sharks[i].x] = k;
                }
            }
        }
    }

}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 진짜 더러운 깡구현 문제..
 * 2. 각 말의 상태는 클래스로 보관한다
 * 3. 리스트 2차원 배열로, 각 배열에 쌓여있는 말의 상태를 보관한다
 * 4. 1000번까지 확인하고 만약 이것을 넘어선다면 -1로 출력하면된다. 그 이외에는 끝나는 회차를 출력한다
 * 5. 범위를 벗어나거나 파란색인 경우, 방향을 회전한다음 말의 방향 상태도 같이 변경해준다
 * 6. 이어서 바뀐 방향으로 다시 이동한 위치를 확인하고, 0이나 1일 경우 그에 맞춰서 두 위치의 리스트 2차원 배열에 있는 말들을 바꿔준다
 * 7. 만약 1인 경우는 뒤집어서 바꿔야한다
 * 8. 그리고 매번 말 움직일 때마다 모든 칸을 체크해서 4개 이상 있는 칸이 있는지 확인한다. 있다면 종료한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2*k)
 * 공간복잡도: O(n^2)
 *
 */

class Knight{
    int nowY;
    int nowX;
    int dir;
    Knight(int y, int x, int d){
        this.nowY = y;
        this.nowX = x;
        this.dir = d;
    }
}


public class Main {


    static int[][] arr;
    static int n;
    static int k;
    static Knight[] knights;
    static int[] dy = {0,0,0,-1,1};
    static int[] dx = {0, 1,-1,0,0};
    static List<Integer>[][] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        lists = new ArrayList[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                lists[i][j] = new ArrayList<>();
            }
        }

        knights = new Knight[k+1];
        for (int i = 1; i < k+1; i++) {
            st = new StringTokenizer(br.readLine());
            knights[i] = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lists[knights[i].nowY][knights[i].nowX].add(i);
        }
        int ans = 0;
        while(ans <= 1000){
            ans++;
            if(moves()){
                break;
            }
        }

        if(ans > 1000){
            ans = -1;
        }
        bw.write(ans+"");
        br.close();
        bw.close();
    }

    private static boolean moves() {
        for (int i = 1; i < k+1; i++) {
            Knight knight = knights[i];
            int ny = knight.nowY + dy[knight.dir];
            int nx = knight.nowX + dx[knight.dir];
            if(!isRange(ny, nx) || arr[ny][nx] == 2){
                knights[i].dir = change(knight.dir);
                int nny = knights[i].nowY + dy[knights[i].dir];
                int nnx = knights[i].nowX + dx[knights[i].dir];
                if(isRange(nny, nnx) && arr[nny][nnx] != 2){
                    if(arr[nny][nnx] == 0){
                        removes(knight.nowY, knight.nowX, nny, nnx, i, false);
                    }else{
                        removes(knight.nowY, knight.nowX, nny, nnx, i, true);
                    }
                }
            }else if(isRange(ny, nx)){
                if(arr[ny][nx] == 0){
                    removes(knight.nowY, knight.nowX, ny, nx, i, false);
                }else if(arr[ny][nx] == 1){
                    removes(knight.nowY, knight.nowX, ny, nx, i, true);
                }
            }

            if(finish()){
                return true;
            }

        }
        return false;
    }

    private static void removes(int py, int px, int ny, int nx, int num, boolean check) {
        int size = lists[py][px].size();
        boolean isOk = true;
        List<Integer> tmp = new ArrayList<>();
        int now = 0;
        for (int i = 0; i < size; i++) {
            if(lists[py][px].get(i) == num){
                now = i;
                isOk = false;
            }
            if(!isOk){
                tmp.add(lists[py][px].get(i));
            }
        }
        if(check){
            Collections.reverse(tmp);
        }
        for (int i = now; i < size; i++) {
            lists[py][px].remove(now);
        }
        for (int i = 0; i < tmp.size(); i++) {
            knights[tmp.get(i)].nowY = ny;
            knights[tmp.get(i)].nowX = nx;
            lists[ny][nx].add(tmp.get(i));
        }
    }

    private static boolean finish() {
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(lists[i][j].size() >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    private static int change(int dir) {
        switch(dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return -1;
    }

    private static boolean isRange(int ny, int nx) {
        if(ny>0 && ny<=n && nx>0 && nx<=n){
            return true;
        }
        return false;
    }
}

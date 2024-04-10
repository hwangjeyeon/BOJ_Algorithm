import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. backtracking으로 해결하는 문제다.
 * 2. 약간 스도쿠 문제랑 비슷한데, 미리 매직 스퀘어에 대한 개념을 조금 알고 있어야 한다
 * 3. 매직 스퀘어는 모든 행,열,대각선의 합이 각각 15가 되어야 한다
 * 4. 이를 활용해서 체크할 때 각 행, 열, 대각선이 15가 안 되면 false를 반환한다
 * 5. 또한 방문배열을 활용하는데, 각 자리에는 1~9의 수가 들어갈 수 있다. 따라서 각 수를 넣어보면서 백트래킹을 진행한다
 * 6. depth가 9에 도달하면 4번을 체크해주고 만약 true로 조건을 만족하면 ans와 비교해서 더 작은 sum을 min에 넣어주고 종료한다
 * 7. min을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */


public class Main {

    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        bw.write(min+"");
        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int sum) {
        if(depth == 9 && checked()){
            min = Math.min(sum, min);
            return;
        }


        int y = depth / 3;
        int x = depth % 3;

        for (int i = 1; i <= 9; i++) {
            if(!visited[i]){
                visited[i] = true;
                int tmp = arr[y][x];
                arr[y][x] = i;
                backtracking(depth+1, sum + Math.abs(tmp - i));
                visited[i] = false;
                arr[y][x] = tmp;
            }
        }

    }

    private static boolean checked() {
        int rowSum = 0;
        for (int i = 0; i < 3; i++) {
            rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += arr[i][j];
            }
            if(rowSum != 15){
                return false;
            }
        }
        int colSum = 0;
        for (int i = 0; i < 3; i++) {
            colSum = 0;
            for (int j = 0; j < 3; j++) {
                colSum += arr[j][i];
            }
            if(colSum!=15){
                return false;
            }
        }
        int cross1 = arr[0][0] + arr[1][1] + arr[2][2];
        int cross2 = arr[2][0] + arr[1][1] + arr[0][2];
        if(cross1 != 15 || cross2 != 15){
            return false;
        }


        return true;
    }

}

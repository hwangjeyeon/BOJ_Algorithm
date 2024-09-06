import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 완탐에 너무 약한 것 같다... 이 문제의 핵심은 4개의 방향으로 탐색을 한다는 것을 파악하는 것이다
 * 2. 맨 처음이 맨 왼쪽이 되기 위해서 해야하는 탐색은 아래, 오른쪽 아래, 오른쪽, 오른쪽위다
 * 3. 따라서 4개의 방향에 대해 해당 위치가 0이 아니면 탐색하는데, 누적된 오목 개수가 0이고, 검사한 결과가 5개라면 정답을 출력하면 된다
 * 4. 이때 검사는 방향을 넘겨주고, 해당 방향으로 재귀문을 돌려서 개수를 계속 1씩 추가하여 더해주어 누적한다
 * 5. 완성한 결과를 넘겨주면 검증이 되고 그 결과를 출력하면 된다
 * 6. 힌트를 참고한 최근 3개의 완탐은 블로그에 정리할 계획이다... 완탐이 너무 약해서 완탐 관련 문제랑 구현 문제 위주로 풀 계획이다
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    static int[][] arr = new int[21][21];
    static int[][][] memo = new int[21][21][4];
    static int[] dx = {1,1,0,-1};
    static int[] dy = {0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        bw.write(finds());

        br.close();
        bw.close();
    }

    private static String finds() {
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if(arr[j][i] != 0){
                    for (int k = 0; k < 4; k++) {
                        if(memo[j][i][k] == 0 && chk(j,i,k, arr[j][i]) == 5){
                            return arr[j][i] + "\n" + j + " " + i + "\n";
                        }
                    }
                }
            }
        }
        return "0";
    }

    private static int chk(int x, int y, int d, int type) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(arr[nx][ny] == type){
            return memo[nx][ny][d] = chk(nx,ny,d,type) + 1;
        }

        return 1;
    }

}


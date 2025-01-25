import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배열돌리기 구현 + 실제 회전횟수를 줄이기 위한 수학문제다
 * 2. 회전의 최대가 10^9이기 때문에 진짜 다 돌려버리면 시간 초과가 발생한다.
 * 3. 따라서 한가지 규칙을 생각하면 되는데, 어차피 한바퀴 도는 횟수만큼은 출력 결과에 영향을 주지 않는다.
 * 4. 이점을 이용하면 한바퀴 도는 횟수만큼은 차감하고, 나머지 횟수만큼만 생각하면 시간초과없이 구할 수 있을 것이다
 * 5. 구현은 조금 생각해서 해결해야하는데, 테두리의 맨 좌측 상단의 값을 기준으로 삼고, 우 <- 좌, 좌 <- 하, 하 <- 우, 우 <- 상 방향으로 회전시킨다
 * 6. 4방 편의 탐색을 이용해서 구현하면 조금 쉽게 구할 수 있다. 탐색의 범위는 현재 테두리 보다 크거나 같고 n-테두리, m-테두리보다 작으면 된다
 * 7. 현재 y와 x좌표는 갱신하는 값의 위치로 갱신한다. 그리고 만약 한 방향으로 갱신한다면 그 방향을 유지하기 위해 j--를 한다
 * 8. 갱신전에 맨 첫번째 값은 임시 변수에 보관한다. 그리고 처음 위치의 y+1 위치에 맨 첫번째 값을 넣어주면 한번 회전을 완료한다
 * 9. 이것을 r % (2*a, 2*b-4)만큼 반복한다
 * 10. 또한 n과 m을 초기값으로 하는 a와 b를 매 탐색마다 2씩 감소시키며 한 값이라도 0보다 작으면 종료하며, 매 탐색마다 start값도 증가시킨다
 * 11. 완성한 배열의 모든 값을 출력하면 정답이 된다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(rotate % (2*a + 2*b-4) * n*m)
 * 공간복잡도: O(n*m)
 *
 */
public class Main {

    static int n;
    static int m;
    static int r;
    static int[][] arr;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start = 0;
        int a = n;
        int b = m;
        while(a > 0 && b > 0 ){
            int rotateCount = r % (2*a + 2*b-4);
            rotated(start, rotateCount);

            a-=2;
            b-=2;
            start++;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static void rotated(int start, int rotateCount) {
        for (int i = 0; i < rotateCount; i++) {
            int last = arr[start][start];
            int y = start;
            int x = start;
            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                if(isRange(ny,nx, start)){
                    arr[y][x] = arr[ny][nx];
                    y = ny;
                    x = nx;
                    j--;
                }
            }
            arr[start+1][start] = last;
        }
    }

    private static boolean isRange(int ny, int nx, int start) {
        return ny >= start && ny < n-start && nx >= start && nx < m - start;
    }
}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진대로 구현하면 된다
 * 2. 5*5라서 간단하게 브루트포스로 이용하면 된다.
 * 3. 값을 바꾸고 나서 빙고 체크하고 빙고면 count해준 뒤 3개 이상일 경우에 지금까지 누적해온 횟수를 출력하고 종료하면 정답이 된다.
 * 4. 값을 바꿀 때마다 count한 빙고의 개수는 0으로 초기해준다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(5^4)
 * 공간복잡도: O(5^2)
 *
 */

public class Main {


    static int count = 0;
    static int ans = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int a = Integer.parseInt(st.nextToken());
                ans++;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (arr[k][l] == a) {
                            arr[k][l] = -1;
                        }
                    }
                }
                r();
                left();
                rotater();
                roatel();
                if (count >= 3) {
                    bw.write(ans + "");
                    br.close();
                    bw.close();

                    return;
                }
                count = 0;
            }
        }


    }

    private static void roatel() {
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == -1) {
                    tmp++;
                }
            }
            if (tmp == 5) {
                count++;
            }
        }
    }

    private static void rotater() {
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == -1) {
                    tmp++;
                }
            }
            if (tmp == 5) {
                count++;
            }
        }
    }

    private static void left() {
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == -1) {
                tmp++;
            }
        }

        if (tmp == 5) {
            count++;
        }
    }

    private static void r() {
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == -1) {
                tmp++;
            }
        }
        if (tmp == 5) {
            count++;
        }
    }

}

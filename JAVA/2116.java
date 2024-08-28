import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 브루트포스로 해결할 수 있는 문제다.
 * 2. 왜냐하면 4중 포문이 발생하는데 2번째 포문 빼고는 전부 6번만 돌고 2번째는 n번돌기 떄문이다
 * 3. 모든 경우에 대해 구하면 되는 문제다. 먼저 맨 아래에 있는 주사위의 윗면을 선택하는데, 1~6까지의 모든 경우를 다 선택하도록 6번의 포문을 돈다
 * 4. 이 6가지를 선택하면서, n개의 주사위를 확인하는데 먼저 6개의 주사위면을 확인하면서 아래 주사위의 윗면과 같은 번호를 확인하고, 그 번호를 선택했을 때, 6부터 감소하는 포문을 돌며 윗면/아래면과 같지 않는 가장 믄 수를 찾아준다
 * 5. 이렇게 찾은 가장 큰 수를 sum에다가 더해주며 그렇게 더한 결과와 ans를 비교하여 더 큰 값을 ans에 초기화해준다
 * 6. 참고로 윗면 선택의 기준은 주어진 주사위를 보면된다. 현재 인덱스의 마주하는 변의 수가 윗면이다.
 * 7. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(6^3 * n)
 * 공간복잡도: O(n*6)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][6];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            int down;
            int up = arr[0][topIdx(i)];

            for (int j = 0; j < n; j++) {
                int max = 0;

                for (int k = 0; k < 6; k++) {
                    if(arr[j][k] == up){
                        down = up;
                        up = arr[j][topIdx(k)];

                        for (int l = 6; l >=0 ; l--) {
                            if(l != down && l != up){
                                max = l;
                                break;
                            }
                        }
                        break;
                    }
                }
                sum += max;
            }
            ans = Math.max(ans, sum);
            sum = 0;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int topIdx(int i) {
        switch (i){
            case 0:
                return 5;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 0;
        }
        return -1;
    }
}



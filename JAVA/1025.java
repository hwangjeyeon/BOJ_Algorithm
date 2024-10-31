import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 결국 하나의 사각형이다. 상하좌우, 그리고 대각선 4가지 해서 총 8가지 경우가 나온다
 * 2. 이것을 잘 생각해보면 각 꼭짓점을 기준으로 탐색을 해보면 될 것이라는 것을 알 수 있다.
 * 3. n*m을 하면서 각 위치에서 -n~n, -m~m 범위의 행과 열의 등차를 각각 추가로 탐색한다면 후보군을 구할 수 있을 것이다
 * 4. 행열 등차가 모두 0인 경우는 이동이 없으므로 제외한다
 * 5. 인덱스 범위를 넘지 않는 선에서 완전 제곱수를 구한다.
 * 6. 위에서 선택된 시작 위치와 등차를 기준으로 해당 수의 완전 제곱수를 확인한다
 * 7. 행과 열에 대한 등차가 0을 포함할 수 있으므로 (모두 0인 경우는 제외) 임시 변수로 i와 j를 받아 관리하며 인덱스 범위가 넘지 않는 선에서 동시에 증가시킨다
 * 8. 현재 수를 관리할 now 변수를 0으로 초기화하여 관리하고, 자릿수를 증가시키며 확인한다. 따라서 10씩 곱해준다
 * 9. 현재 위치의 값을 now에 더해준다
 * 10. 이후 해당 수가 제곱수 인지, Math.sqrt를 통해 루트르 씌워서 변수로 받는다. 이때 int형 타입으로 받아, 제곱이 아닌 경우를 필터링할 수 있도록 한다
 * 11. 위에서 받은 변수를 제곱하여 now랑 같은지 확인하고 같다면 정답 출력을 위한 ans와 비교하여 더 큰 값을 찾는다
 * 12. 이어서 위치를 등차에 따라 동시에 증가시킨다.
 * 13. ans의 초기값은 -1로 두고 예외처리를 할 수 있도록 한다
 * 14. 완성한 ans는 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n^2*m^2*n)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = -n; k < n; k++) {
                    for (int l = -m; l < m; l++) {
                        if(k == 0 && l == 0){
                            continue;
                        }

                        int now = 0;
                        int dy = i;
                        int dx = j;
                        while(dy >=0 && dy < n && dx >=0 && dx < m){
                            now *= 10;
                            now += arr[dy][dx];

                            int chk = (int) Math.sqrt(now);
                            if(chk * chk == now){
                                ans = Math.max(ans, now);
                            }
                            dy += k;
                            dx -= l;
                        }

                    }
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}


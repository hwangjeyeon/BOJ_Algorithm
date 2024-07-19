import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 문제 양식이 플로이드 와샬과 비슷하여 플로이드 와샬로 풀었다
 * 2. Y면 1을 입력하고 아닌 경우 Integer.MAX_VALUE를 넣어야하는데 오버플로우 때문에 최대 경우의 수 + 1인 2501을 넣었다
 * 3. 이제 플로이드 와샬을 돌아주는데, 한가지 조건을 추가해야한다 j와 k가 같은경우 스킵한다 둘이 같은 경우는 친구가 아니라고 조건에서 말했기 때문이다
 * 4. 이어서 이중포문을 통해 배열을 돌면서 값이 2거나 1인 경우는 비교하는 둘의 다른 친구가 하나 존재한다는 것과 비교하는 둘이 친구라는 것을 의미하므로 카운팅해준다
 * 5. 이후 최대치를 찾기 위해 ans와 비교하여 주고 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == 'Y'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 2501;
                }
            }
        }

        floydWarshall(n);

        bw.write(ans+"");
        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == k){
                        continue;
                    }
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 2 || arr[i][j] == 1){
                    tmp++;
                }
            }
            ans = Math.max(ans, tmp);
        }

    }

}


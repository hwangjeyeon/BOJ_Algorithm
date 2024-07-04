import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 완전탐색하면서 현재 위치가 0이면 break하고, 아니라면 점프한 칸수의 위치에 현재 좌표를 넣어준다
 * 2. 단 범위를 벗어나지 않는 선에서만 진행한다
 *
 * 해결방법:
 * 1. 처음 시작 지점은 1로 시작해야한다. 처음 위치에서 시작하는 경우도 하나의 횟수로 생각하기 떄문이다
 * 2. 출력 크기 때문에 dp를 long 타입으로 해야한다
 * 3. 만약 현재 위치가 0이라면 break해서 반복문을 탈출한다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int jmp = arr[i][j];
                if(jmp == 0){
                    break;
                }
                if(j + jmp < n){
                    dp[i][j+jmp] += dp[i][j];
                }
                if(i + jmp < n){
                    dp[i+jmp][j] += dp[i][j];
                }
            }
        }

        bw.write(dp[n-1][n-1]+"");

        br.close();
        bw.close();
    }

}


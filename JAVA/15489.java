import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 미리 파스칼 삼각형을 dp 배열에 저장해두고 이후 탐색하면 쉽게 풀 수 있다
 * 2. 주어진 입력값을 보면 대략 30개에서 31개정도로 크기를 잡고 배열을 만들어두면된다
 * 3. 파스칼 삼각형은 왼쪽끝은 자기 위의 자기랑 같은 위치의 값만을 저장하고 오른쪽 끝은 자기 위의 자기보다 한칸 앞에 있는 값을 더해주면 된다
 * 4. 그외는 자기 위의 자기랑 같은 위치의 값과 이전의 값을 더해주면 된다
 * 5. 이렇게 파스칼의 삼각형을 만들어 둔 뒤에 특정 꼭짓점을 기준으로 하는 삼각형을 구해서 ans에 더해주고 종료 후에 출력하면 정답이 된다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O((r+w) * (c+i-r))
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        dp[0][0] = 1;
        int ans = 0;
        for (int i = 1; i < 31; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        for (int i = r; i < r+w; i++) {
            for (int j = c; j <= c + i - r; j++) {
                   ans += dp[i][j];
            }
        }
        bw.write(ans+"");
        br.close();
        bw.close();
    }



}


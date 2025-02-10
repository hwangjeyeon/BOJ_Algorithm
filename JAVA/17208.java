import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 입력 크기가 작아서 고민되었지만, 치즈버거와 감자튀김의 개수가 정해져있고, 주문들이 있을 때 어떤 주문 조합으로 선택하는 것이 가장 최적이냐는 내용을 바탕으로 배낭정리와 비슷하다 생각했다
 * 2. 다른 배낭정리와 다르게 이 문제는 판단해야하는 무게의 종류가 치즈버거와 감자튀김 즉, 2가지이다
 * 3. 가치는 주문의 개수라고 했을 때, 3차원 배열로 만들어서 n개의 주문에 대해서 치즈버거의 각각 남은 양을 인덱스로 하는 배낭정리 방법으로 해결하면 될 것이다
 * 4. 이때 각 주문의 개수를 개별로 분리할 수는 없으므로 치즈버거와 감자튀김이 현재 주문량보다 둘다 이하일 경우 배낭정리 점화식을 이용한다
 * 5. 간단하게 dp[i][j][l] = Math.max(dp[i-1][j][l], dp[i-1][j-arr[i][0]][l-arr[i][1]] + 1)을 하면된다. 만약 후자를 선택한 경우, 현재 주문을 선택하므로 1을 추가하면 된다
 * 6. 만약 위 조건을 만족시키지 못하면 그냥 dp[i][j][l] = dp[i-1][j][l] 점화식으로 적용하면 된다
 * 7. 완성한 dp[n][m][k]를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m*k)
 * 공간복잡도: O(n*m*k)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        int[][][] dp = new int[n+1][m+1][k+1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m+1; j++) {
                for (int l = 1; l < k+1; l++) {
                    if(arr[i][0] <= j && arr[i][1] <= l){
                        dp[i][j][l] = Math.max(dp[i-1][j][l], dp[i-1][j-arr[i][0]][l-arr[i][1]]+1);
                    }else{
                        dp[i][j][l] = dp[i-1][j][l];
                    }
                }
            }
        }
        bw.write(dp[n][m][k]+"");
        
        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 죽는 dp와 현재 생존자를 관리하는 dp를 따로 만들어서 관리해야한다
 * 2. 죽는 dp는 4부터 1로 초기화하고 생존 dp는 1부터 1로 초기화한다
 * 3. 이전 값을 birth 변수에 넣어두고, dp2[i] = dp2[i-1] * 2 - dp1[i]로 이전 생존자 * 2에 죽는 dp1의 값을 뺴준다
 * 4. 이어서 짝수면 i+4에, 홀수면 i+3에 현재 birth를 더해준다.
 * 5. dp[n]을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp1 = new int[25];
        int[] dp2 = new int[25];
        dp1[4] = 1;
        dp2[1] = 1;
        for (int i = 2; i < 21; i++) {
            int birth = dp2[i-1];
            dp2[i] = dp2[i - 1] * 2 - dp1[i];

            if(i % 2 == 0){
                dp1[i+4] += birth;
            }else{
                dp1[i+3] += birth;
            }
        }

        bw.write(dp2[n]+"");

        br.close();
        bw.close();
    }

}


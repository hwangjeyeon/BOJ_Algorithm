import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에는 날짜와, 주식을 클래스로 하는 객체를 생성해서 배열로 담아준 뒤, 주식을 기준으로 내림차순, 같을 경우 날자를 기준으로 오름차순 정렬을 하고 이중 포문으로 탐색했는데 시간초과가 발생하였다.
 * - 따라서 다른 방법을 모색해야했고, 생각한 방법은 역방향 탐색이다.
 * - 맨 마지막 값을 가장 큰 값이라 생각하고, 마지막에서 두번째 전부터 탐색해서 bigStock보다 작거나 현재 주식가격과 bigStock의 차이를 nowBenefits에 저장한다
 * - 만약 크다면 지금까지 얻은 nowBenefits를 ans에 더해주고 0으로 초기화한 뒤, bigStock을 현재 주식으로 바꿔준다
 * - 이렇게 역방향으로 순회한 뒤, 마지막에 nowBenefits를 ans에 넣어주는 갱신 작업을 하고 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stocks = new int[n];
            for (int j = 0; j < n; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            long nowBenefits = 0;
            long bigStock = stocks[n-1];
            for (int j = n-2; j >= 0; j--) {
                if(bigStock < stocks[j]){
                    ans += nowBenefits;
                    nowBenefits = 0;
                    bigStock = stocks[j];
                    continue;
                }
                nowBenefits += (bigStock - stocks[j]);
            }
            ans += nowBenefits;

            bw.write(ans+"\n");
        }



        br.close();
        bw.close();
    }

}


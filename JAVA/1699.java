import java.io.*;


/**
 * 풀이 과정:
 * dp[i]는 제곱수의 합의 최소 개수로 잡았다.
 * 첫번째 풀이는 O(n)으로 풀어보았다 -> 틀림
 * 1. 해당 i의 최대 제곱수, 예를들어 41인 경우 6^6=36 이므로 최대 제곱근은 6이다
 * 2. 해당 제곱수를 i에서 빼주고 이전에 메모이제이션으로 저장해둔 dp의 위치를 합해준다 -> dp[i-36] =dp[5] + 1
 * 3. 하지만 이 방식은 예외 처리를 해주지 못하고 있다 -> 이렇게 풀 경우 dp[5]는 2이고 둘을 합하면 3이 된다.
 * 4. 이것이 최소의 수가 된다고 착각할 수 있지만 다음과 같은 경우 더 최소의 개수로 풀 수 있다 -> 5^5 + 4^4 -> 2가지 경우
 * 5. 따라서 해당 예외 처리를 위해 반복문을 한번 더 사용하여 풀었다
 *
 * 두번째 풀이의 시간 복잡도는 O(n*sqrt(n))이다
 * 1. tmp에는 해당 i의 제곱근을 저장한다
 * 2. dp[i]에는 위 풀이 방식을 저장한다 dp[i] = dp[i-tmp*tmp] +1;
 * 3. 두번째 반복문에서는 j가 j<=tmp만큼까지 반복한다고 할 때, 현재 dp[i]와 dp[i-((tmp-j)*(tmp-j))]+1를 통해 최대 제곱근이 아니라 최대 제곱근보다 작은 제곱근 모두를 다 조사해서
 * 더 작은 경우를 조사한다.
 * 4. 위 과정을 통해 dp[i]에 저장하고 최종적으로 dp[n]을 저장한다.
 *
 * 시간복잡도: O(n*sqrt(n))
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dp = new long[n+1];
        if(n == 1){
            dp[1] = 1;
            bw.write(dp[n]+"");
        }else if(n==2){
            dp[2] = 2;
            bw.write(dp[n]+"");
        }else if(n==3){
            dp[3] = 3;
            bw.write(dp[n]+"");
        }else{
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for(int i=4; i<n+1; i++){
                int tmp = (int)Math.floor(Math.sqrt(i));
                dp[i] = dp[i-tmp*tmp]+1;
                for(int j=1; j<=tmp; j++){
                    dp[i] = Math.min(dp[i], dp[i-((tmp-j)*(tmp-j))]+1);
                }

            }
            bw.write(dp[n]+"");
        }



        bw.close();
    }

}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 2부터 그 수의 약수인 경우 약수의 개수 만큼 반복해서 나눠주고 해당 수를 출력한다
 * - 이렇게 했을 때, 소수인 경우만 출력되기 때문에 시간 복잡도 측면에서도 걱정할 필요가 없다.
 *
 * 시간복잡도: O(n*sqrt(n))
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=2; i<=n; i++){
            while(n%i==0){
                n /= i;
                bw.write(i + "\n");
            }
        }

        br.close();
        bw.close();
    }


}

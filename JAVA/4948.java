import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 에라토스테네스의 체를 이용하는 문제이다
 * - 에라토스테네스의 체를 이용하여 미리 지정해둔 범위의 배열에 소수인것과 아닌것을 구분해놓는다
 * - 그 뒤에, 범위 내를 순환하면서 소수인 경우의 개수를 세서 출력한다.
 *
 * 시간복잡도: O(n*sqrt(n))
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static boolean[] prime = new boolean[246913];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = -1;
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for(int j=i*i; j<prime.length; j+=i){
                prime[j] = true;
            }
        }

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            int start = n+1;
            int end = 2*n;
            int count = 0;

            for(int i=start; i<=end; i++){
                if(!prime[i]){
                    count++;
                }
            }

            bw.write(count+"\n");
        }



        br.close();
        bw.close();
    }

}

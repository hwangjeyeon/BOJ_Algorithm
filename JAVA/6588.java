import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 골드바흐 파티션 문제를 풀기 전에 골드바흐의 추측 문제를 푸는게 좋다고 해서 먼저 풀게 되었다
 * - 에라토스테네스의 체를 이용하여 미리 범위내의 모든 소수들을 판별하여 저장한다
 * - 골드바흐의 추측에 따르면 현재 소수와 주어진 수에서 현재 소수를 뺀 값을 더하면 답이 된다고 하는 것이다
 * - 이를 코드로 구현하면 된다 즉 i + (T-i) = T가 된다.
 * - 또한 b-a가 가장 큰 것을 구하므로, a가 가장 작은 수를 구하면 된다
 * - 가장 처음에 가능한 경우가 가장 b-a가 크므로 한번 조건문에 들어와서 출력하면 break로 조건문을 종료시킨다
 * - 그리고 시간초과를 해결하기 위해 범위를 T/2 + 1로 해주면 틀리지도 않고 시간초과도 해결한다
 *
 * 시간복잡도: O(nsqrt(n))
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        prime[0] = true;
        prime[1] = true;

        for(int i=2; i<Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for(int j=i*i; j<prime.length; j+=i){
                prime[j] = true;
            }
        }
        while(true){
            int T = Integer.parseInt(br.readLine());
            if(T == 0){
                break;
            }
            boolean count = false;
            for(int i=2; i<T/2+1; i++){
                if(!prime[i] && !prime[T-i]){
                        StringBuilder st = new StringBuilder(T + " = " + i + " + " + (T-i) + "\n");
                        bw.write(st.toString());
                        count = true;
                        break;
                }
            }

            if(!count){
                bw.write("Goldbach's conjecture is wrong.");
            }
        }




        br.close();
        bw.close();
    }


}

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 골드바흐의 추측 문제에 따르면 골드바흐 파티션을 쉽게 풀 수 있다
 * - 에라토스테네스의 체를 이용하여 범위 내의 모든 소수를 판별하여 저장한다
 * - 이후 입력받은 수인 n의 n/2범위 내에서 j가 소수이고 n-j가 소수인 경우를 찾아서 count를 증가시킨다
 * - 이때 n/2범위로 한정시켜서 단순히 두 수가 뒤바뀌는 중복의 경우 count증가를 막아준다.
 * - 이렇게 완성된 count값을 출력한다.
 *
 *
 * 시간복잡도: O(n*sqrt(n))
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

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=2; j<=n/2; j++){
                if(!prime[j] && !prime[n-j]){
                    count++;
                }
            }
            bw.write(count+"\n");
        }




        br.close();
        bw.close();
    }


}

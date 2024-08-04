import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 발상의 전환을 필요하는 문제다. 비트는 2의 제곱수의 합으로 이루어져 있는데 이 문제에서는 3의 제곱수로 바꿔 생각해야한다
 * 2. x를 하나 두고, n을 오른쪽으로 오른쪽 시프트 연산하면서 비교한다
 * 3. 이때 n&1이 1이면 ans에 x를 더해준다
 * 4. 이후 x에는 3을 곱해서 넣어주고 n을 오른쪽으로 한칸 시프트 연산해준다
 * 5. 이렇게 하는 것은 n의 각 자리수를 비교하면서 만약 1이라면 그 값을 더해주기 위함이다
 * 6. 이때 첫번째 자리는 3^0, 두번째는 3^1 이런식으로 ans에 더해서 값을 구한다
 * 7. 이것은 2의 제곱수의 값을 비트만 주어졌을 때 비교하는 방식이랑 같다. 예를들어 101 은 2^0과 2^2의 합이다. 
 * 8. 이것을 3^0, 3^2로 바꿔서 생각하면 해당 문제를 쉽게 풀 수 있다
 * 9. 완성된 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n의 비트수)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long x = 1;
        long ans = 0;

        while(n > 0){
            if((n&1) == 1){
                ans += x;
            }
            x *= 3;
            n = n >> 1;
        }


        bw.write(ans+"");

        br.close();
        bw.close();

    }

}

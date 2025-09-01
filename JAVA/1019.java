import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. a부터 n까지 각 숫자가 몇번 나오는지 문제로 바꿔서 해결하면 된다
 * 2. a의 일의 자리는 0이 되어야하며 아니면 a++로 맞춰춘다
 * 3. n의 일의 자리는 9가 되어야하고 아니면 n--로 맞춰준다
 * 4. 맞추는 과정에서 지나온 일의 자리수를 ++해준다
 * 5. 맞춘 후에는 a부터 n까지 일의 자리에 0부터 9는 총 (n/10 - a/10 + 1)번 등장한다
 * 6. 이를 구현하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    static int count = 1;
    static int[] page = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a = 1;
        while(a <= n){
            while(n % 10 != 9 && a <= n){
                calculate(n);
                n--;
            }
            while(a % 10 != 0 && a <= n){
                calculate(a);
                a++;
            }
            if(a > n){
               break;
            }
            a /= 10;
            n /= 10;
            for (int i = 0; i < 10; i++) {
                page[i] += (n - a + 1) * count;
            }
            count *= 10;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(page[i] + " ");
        }
        
        br.close();
        bw.close();
    }
    private static void calculate(int now){
        while(now > 0){
            page[now % 10] += count;
            now /= 10;
        }
    }

}

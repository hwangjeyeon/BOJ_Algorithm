import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 플러그를 연달아 꽂는다고 생각해보면 된다
 * 2. 처음수만 모두 사용할 수 있고, 이후부터는 연결을 위해 하나씩만 차감해서 사용할 수 있다
 * 3. 이를 이용해서 합산한뒤 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        for (int i = 0; i < n-1; i++) {
            sum += (Integer.parseInt(br.readLine())-1);
        }
        bw.write(sum+"");

        br.close();
        bw.close();
    }

}

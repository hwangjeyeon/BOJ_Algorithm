import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BigInteger로 안 풀면 런타임 에러가 난다. 최대 80~81길이의 숫자가 들어오기 때문에 기존 int, long타입으로는 범위를 벗어난다
 * 2. new BigInteger로 문자열과 진수를 옵션으로 받을 수 있다
 * 3. 또한 둘을 합하고 toString으로 문자열로 바꿀 수 있는데, 이때도 옵션을 2로 설정하여 진수를 2로 설정할 수 있다
 * 4. 이렇게 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken(), 2);
            BigInteger b = new BigInteger(st.nextToken(), 2);


            bw.write(a.add(b).toString(2)+"\n");

        }

        br.close();
        bw.close();
    }
}


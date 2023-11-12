import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 자바의 Integer.parseInt(n진수 숫자, 진수)를 활용하는 문제이다
 * - String으로 된 n진수 숫자가 필수이며, 해당 숫자의 진수가 몇인지 radix에 값을 넣어주어야 한다
 *
 * 개인적으로 parseInt()에 이런 기능이 있는지 처음 배우게 되었다.
 * 단순히 형변환만 하는 줄 알았는데, 이런 기능이 있다는 점에서, 아직 배울 것이 많구나라는 생각이 드는 문제였다
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {

//    static long[][] dp;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String count = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        int ans = Integer.parseInt(count,base);

        bw.write(ans + "");
        br.close();
        bw.close();
    }

}

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 문자열로 받고 형변환해서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        BigInteger n = new BigInteger(s, 2);

        bw.write(n.toString(8));

        br.close();
        bw.close();
    }

}

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 길이가 80까지 가능하므로 BigInteger를 써서 받고, 합산한다
 * 2. toString(2)로 이진수 문자열로 변환해서 출력하면 정답이 된다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken(), 2);
        BigInteger m = new BigInteger(st.nextToken(), 2);
        BigInteger sum = n.add(m);
        bw.write(sum.toString(2));

        br.close();
        bw.close();
    }
}

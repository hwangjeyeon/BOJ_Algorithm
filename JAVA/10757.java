import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BigInteger 사용연습 문제
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
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        bw.write(a.add(b)+"");

        
        br.close();
        bw.close();
    }

}

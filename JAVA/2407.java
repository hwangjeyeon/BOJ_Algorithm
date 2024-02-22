
import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - BigInteger를 사용하는 문제이다
 * - nCr = n! / (n-r)! * r! 공식을 이용하였다.
 * - a에다가는 n!을 적용하고 b에다가는 r!을 적용한뒤 마지막에 divide해주면 된다.
 * - 임의 정밀도 / 큰 수 연산은 대부분 BigInteger를 사용하던데 나중에 정리해서 개념 및 문제 풀이를 진행할 계획
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(n-i)));
            b = b.multiply(new BigInteger(String.valueOf(i+1)));
        }
        BigInteger answer = a.divide(b);
        bw.write(answer+"");
        br.close();
        bw.close();
    }
}


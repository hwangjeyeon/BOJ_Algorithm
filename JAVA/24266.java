import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n
 *         for j <- 1 to n
 *             for k <- 1 to n
 *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
 *     return sum;
 * }
 * - 수행횟수는 최악의 경우 n^3번 수행하게 된다. 이때 최대 입력 수는 500000이므로, long형 범위내로 풀어도 되나 BigInteger를 사용해보고 싶어 해당 방법으로 풀었다
 * - 또한 O(n^3)이란 시간복잡도를 가지므로, 최고차항의 수는 3이다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger n = new BigInteger(br.readLine());

        bw.write(n.multiply(n.multiply(n)) + "\n" + 3 + "");


        br.close();
        bw.close();
    }

}

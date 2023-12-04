import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n - 2
 *         for j <- i + 1 to n - 1
 *             for k <- j + 1 to n
 *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
 *     return sum;
 * }
 * - 조합을 생각해서 7C3을 생각했고, 가우스의 덧셈 공식도 생각해서 해당 방법으로 검증해서 (n*(n-1)*(n-2))/6라는 결과를 내었따
 * - for문이 3중 중첩으로 있기에 최고차항은 3이다.
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        bw.write((n*(n-1)*(n-2))/6 + "\n" + 3 + "");

        br.close();
        bw.close();
    }


}

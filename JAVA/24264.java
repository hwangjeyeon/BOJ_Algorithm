import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n
 *         for j <- 1 to n
 *             sum <- sum + A[i] × A[j]; # 코드1
 *     return sum;
 * }
 * - 반복문 만큼 해당 함수가 실행됩니다. 따라서 첫번째 출력은 입력값인 n^2
 * - 그리고 해당 시간 복잡도는 O(n^2)입니다 따라서 최고차항의 수는 2
 * - 이때 주의할 점은 n은 최대 500,000까지 들어올 수 있다. 이 최악의 경우의 수의 제곱은 int형 범위를 아득히 넘어서기때문에 long형으로 n을 입력 받아야 한다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        bw.write(n*n + "\n" + 2 + "");

        br.close();
        bw.close();
    }


}

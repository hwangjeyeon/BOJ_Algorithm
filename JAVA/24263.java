import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n
 *         sum <- sum + A[i]; # 코드1
 *     return sum;
 * }
 * - 반복문 만큼 해당 함수가 실행됩니다. 따라서 첫번째 출력은 입력값인 n
 * - 그리고 해당 시간 복잡도는 O(n)입니다 따라서 최고차항의 수는 1
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(n + "\n" + 1 + "");
        br.close();
        bw.close();
    }


}

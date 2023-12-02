import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n - 1
 *         for j <- i + 1 to n
 *             sum <- sum + A[i] × A[j]; # 코드1
 *     return sum;
 * }
 * - 위 함수에 몇가지 수를 대입해보면, 1부터 n-1번까지 더한 값이 수행 횟수로 나오게 된다.
 * - 또한 O(n^2)이란 시간복잡도를 가지므로, 최고차항의 수는 2이다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        for(int i=1; i<n; i++){
            sum += i;
        }
        bw.write(sum + "\n" + 2 + "");


        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 사칙연산 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += i;
        }
        bw.write(sum+"\n" + (sum*sum) + "\n");
        sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += (i*i*i);
        }

        bw.write(sum+"");

        br.close();
        bw.close();

    }
}

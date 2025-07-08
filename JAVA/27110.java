import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 사칙연산 문제다
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = 0;
        sum += a < n ? a : n;
        sum += b < n ? b : n;
        sum += c < n ? c : n;
        bw.write(sum+"");

        br.close();
        bw.close();
    }

}

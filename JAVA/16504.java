import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 그냥 다 더하면 되는 문제다.
 * 2. 단 long타입으로 해야 한다. int는 범위를 벗어난다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ans += Integer.parseInt(st.nextToken());
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }
}


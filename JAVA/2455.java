import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 합산 감산 연산과 최댓값 갱신 후, 최댓값을 출력하면 되는 문제다
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
        int sum = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            sum += in;
            sum -= out;
            max = Math.max(max, sum);
        }
        bw.write(max+"");


        br.close();
        bw.close();
    }

}

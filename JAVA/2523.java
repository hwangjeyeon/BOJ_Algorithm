import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n 번행을 그 n번만큼 별을 찍어주는데, 이걸 정방향 -> 역방향 순으로 하면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        bw.write(sb.toString()+"\n");

        br.close();
        bw.close();
    }

}

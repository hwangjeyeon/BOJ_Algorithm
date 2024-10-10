import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진대로 구현하면 되는 쉬운 문제다.
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
        final String GOL = "@";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 5; j++) {
                bw.write(GOL);
            }
            bw.write("\n");
        }

        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(GOL);
            }
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 5; j++) {
                bw.write(GOL);
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. total에서 9권의 책을 합한 값을 뺀것을 출력하면 정답이 된다
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
        int total = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        bw.write((total - sum) + "");


        br.close();
        bw.close();
    }

}

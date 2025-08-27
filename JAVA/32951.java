import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 입력값에서 2024를 빼면 정답이 된다
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
        bw.write((Integer.parseInt(br.readLine()) - 2024) + "");

        br.close();
        bw.close();
    }

}

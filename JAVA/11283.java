import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 가를 출력하면 44032가 나온다. 따라서 44031을 빼주고 그 값을 출력하면 정답이 된다.
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
        String s = br.readLine();
        int ans = (s.charAt(0) - 44031);
        bw.write(ans + "");

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. split해서 각 숫자를 파싱한다음 더해서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(",");
            bw.write((Integer.parseInt(s[0]) + Integer.parseInt(s[1]))+"\n");

        }

        br.close();
        bw.close();
    }

}

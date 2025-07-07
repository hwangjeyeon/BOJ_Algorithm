import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 수학적 사고로 풀면 되는 문제다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) * 2;
        bw.write((s-r1)+"");

        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. l*p한 값을 각 입력값 n에서 빼주면 되는 문제다
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
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int ans = l * p;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(n - ans + " ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}

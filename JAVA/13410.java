import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. StringBuilder를 이용해서 문자열로 바꾼다음 reverse해서 다시 파싱해서 Math.max 비교로 ans에 넣으면 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(k)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(n*i));
            ans = Math.max(ans, Integer.parseInt(String.valueOf(sb.reverse())));
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


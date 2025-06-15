import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. long 타입으로 바꿔서 절댓값 감산을 하면 정답이 된다
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
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        bw.write(Math.abs(n-m)+"");

        br.close();
        bw.close();
    }

}

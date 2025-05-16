import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *  1. 먼저 필수 재료를 set에 넣고, 이후 안넣은 재료를 파악하기 위해 remove해준다
 *  2. 하나 남은 set의 원소값을 출력하면 정답이 된다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            set.remove(st.nextToken());
        }
        for (String s : set) {
            bw.write(s);
        }

        br.close();
        bw.close();
    }
}

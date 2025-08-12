import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 중복제거 + 정렬해야하므로 TreeSet써서 입력 받은 뒤, 출력하면 정답이 된다
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
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer i : set) {
            bw.write(i+" ");
        }


        br.close();
        bw.close();
    }

}

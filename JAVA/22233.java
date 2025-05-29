import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. set을 이용해서 해결한느 문제다
 * 2. 미리 문자들을 받아두고 이후 split한 뒤 그 값들을 순회해서 포함여부를 확인해서 포함된다면 지워준다
 * 3. 그리고 set의 크기를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(",");

            for (int j = 0; j < s.length; j++) {
                if(set.contains(s[j])){
                    set.remove(s[j]);
                }
            }
            bw.write(set.size() + "\n");
        }

        br.close();
        bw.close();
    }
}

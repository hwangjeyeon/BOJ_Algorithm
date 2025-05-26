import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. map을 이용해서 count 세워준 다음 그 키값들을 모두 뽑아서 m이상인 경우의 개수를 세어준다
 * 2. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n * l)
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                int member = Integer.parseInt(st.nextToken());
                map.put(member, map.getOrDefault(member, 0) + 1);
            }
        }

        int ans = 0;
        for (Integer i : map.keySet()) {
            if(map.get(i) >= m){
                ans++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

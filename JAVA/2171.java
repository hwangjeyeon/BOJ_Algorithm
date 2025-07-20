import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 두 좌표를 대각선이라 생각하고 수직으로 내렸을 때, 원소에 포함되는지 여부를 적는 문제다
 * 2. 이 문제를 자바로 했을 때, 핵심은 이중포문 내에서 변수로 HashSet 지역변수를 선언하지 않는 것이다
 * 3. 이렇게 하면 힙 메모리에 쌓이면서 메모리 초과가 발생하므로 if문에서 바로 확인하는 방법으로 찾는다
 * 4. 마지막에 중복되는 경우를 고려해서 ans/2를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] xp = new int[n];
        int[] yp = new int[n];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xp[i] = x;
            yp[i] = y;
            map.computeIfAbsent(x, p -> new HashSet<>()).add(y);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                int x1 = xp[i];
                int y1 = yp[i];
                int x2 = xp[j];
                int y2 = yp[j];
                if(x1 == x2 || y1 == y2) {
                    continue;
                }

                if(map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    ans++;
                }
            }
        }

        bw.write(ans/2+"");

        br.close();
        bw.close();
    }

}

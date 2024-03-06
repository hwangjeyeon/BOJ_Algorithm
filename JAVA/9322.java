import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 먼저 첫번쨰 공개키가 중복이 되지 않으므로 그 순서를 value로 하는 map에 넣어준다
 * 2. 두번째 공개키를 받아 리스트에 배치 순서를 저장해놓는다
 * 3. 암호문을 map에 입력받는데 이번에는 리스트에 담겨있는 순서를 key로 하고 입력 키를 value로 한다
 * 4. 3 0 1 2로 담겨 있으면 암호문 순서대로 3 0 1 2이 key고 들어온 문자열 순서대로 value가 된다
 * 5. 이제 리스트 길이 만큼 순회하면서 리스트에 담긴 값을 암호문에 key로 넣어 값을 찾아 차례대로 출력하면 된다.
 *
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(T*n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map1 = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String key = st.nextToken();
                map1.put(key, j);
            }
            List<Integer> order = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String key = st.nextToken();
                order.add(map1.get(key));
            }

            st = new StringTokenizer(br.readLine());
            Map<Integer, String> map2 = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String key = st.nextToken();
                map2.put(order.get(j),key);
            }

            for (int j = 0; j < order.size(); j++) {
                bw.write(map2.get(j)+ " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }


}

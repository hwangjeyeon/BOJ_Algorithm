import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 단순히 TreeMap으로 하면 안된다. key 기준 정렬이 되어서 과목기준 오름차순이 되어버린다
 * 2. 따라서 이후에 list를 하나 만들고 정렬한다음 맨뒤에서 부터 체크할 포인터를 하나 만들어준다
 * 3. 이후 순회하며 최소 최댓값을 각각 더해가며 최종완성된 값들을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            String name = br.readLine();
            ans += map.get(name);
            map.remove(name);
        }
        int min = ans;
        int max = ans;
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int j = n-k-1;
        for (int i = 0; i < m-k; i++, j--) {
            max += list.get(j);
            min += list.get(i);
        }

        bw.write(min + " " + max);

        br.close();
        bw.close();
    }
}

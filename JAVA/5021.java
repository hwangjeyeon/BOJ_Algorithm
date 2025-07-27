import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 위상정렬을 배울 수 있는 좋은 문제
 * 2. 두가지 Map 자료구조를 활용해서 문제를 해결할 수 있다
 * 3. 먼저 최초 부모 이후의 사람들에 대해서, 자식의 이름을 기준으로 부모에 대한 관계를 넣어주고, -1로 일단 계승 파워를 구성한다
 * 4. 혈통순위는 Double로 해야하는데, 부모의 계승파워를 더한뒤 2로 나눠야하는데, 정수형으로 하면 소수점 부분이 절삭되기 떄문이다
 * 5. 이후, 모든 인원에 대해서 위상정렬로 계승 파워를 정한다. 여기서는 dfs로 구현했다
 * 6. 계승 파워가 -1이 아니면 이미 결정되었으므로 그대로 리턴, null이면 부모가 없으므로 가장 파워가 약한 0으로 초기화한다
 * 7. 이어서 부모에 대한 계승 파워를 dfs로 구한뒤, 그 합산 / 2의 값을 현재의 계승 파워로 한다
 * 8. 참고로 최초 왕은 계승 파워가 1이다
 * 9. 이후, 도전자와 계승자간의 파워차이를 구해 누가 계승할지 결정해준다
 * 10. 완성한 인원에 대해 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static HashMap<String, Double> height;
    static HashMap<String, List<String>> family;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String root = br.readLine();
        height = new HashMap<>();
        family = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String me = st.nextToken();
            family.computeIfAbsent(me, k -> new ArrayList<>());
            height.put(me, -1d);
            String parent1 = st.nextToken();
            family.get(me).add(parent1);
            height.put(parent1, -1d);

            String parent2 = st.nextToken();
            family.get(me).add(parent2);
            height.put(parent2, -1d);
        }
        height.put(root, 1d);


        for (String s : height.keySet()) {
            dfs(s);
        }

        String ans = br.readLine();

        for (int i = 1; i < m; i++) {
            String enemy = br.readLine();
            if(height.getOrDefault(ans, 0d) < height.getOrDefault(enemy, 0d)){
                ans = enemy;
            }
        }

        bw.write(ans);

        br.close();
        bw.close();
    }

    private static Double dfs(String now){

        if(height.get(now) != -1){
            return height.get(now);
        }

        if(family.get(now) == null){
            height.put(now, 0d);
            return height.get(now);
        }

        double parent1 = dfs(family.get(now).get(0));
        double parent2 = dfs(family.get(now).get(1));

        height.put(now, (parent1 + parent2) / 2);
        return height.get(now);
    }
}

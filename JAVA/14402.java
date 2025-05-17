import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Map<String, String>보다는 Map<String, Integer>로 계산하는 것이 더 편하다
 * 2. history가 +인 경우만 map에다가 넣는다
 * 3. history가 -인 경우, 가져온 값이 0보다 큰경우와 아닌 경우로 나눠준다
 * 4. 0보다 크지 않을 경우, 들어온 이력이 없으므로 야근이 되기 떄문에 ans를 증가시킨다
 * 5. 0보다 큰 경우 들어온 이력이 있기 떄문에 그 횟수를 1감소시킨다
 * 6. 최종적으로 map에 있는 모든 키를 순회해서 그 값을 ans에 더한다. 퇴근시간까지 나오지 않았기 때문에 야근한 사람들이다
 * 7. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(q)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String history = st.nextToken();
            if(history.equals("-")){
                if(map.getOrDefault(name, 0) > 0){
                    map.put(name, map.getOrDefault(name, 1) - 1);
                }else{
                    ans++;
                }
            }else{
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        for (String s : map.keySet()) {
            ans += map.get(s);
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 프로그래머스에서도 이미 풀어본 문제이다.
 * 2. 총 세번 순회를 해야한다. 먼저 map으로 마라토너들의 이름을 키값으로 받는데 중복된 이름이 있을 수도 있어서 Integer형으로 값으로 받아 그 숫자를 세어준다
 * 3. 이어서 받는 완주한 사람의 수만큼 각각의 key에서 값을 빼주고 최종 iter 순회를 할 때 해당 엔트리셋의 value가 0이 아니면 key를 출력하고 break하면 정답이 된다.
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            if(map.get(name) != null && map.get(name) > 0){
                map.put(name, map.get(name)-1);
            }
        }

        for(Map.Entry<String, Integer> maps : map.entrySet()){
            if(maps.getValue() != 0){
                bw.write(maps.getKey());
                break;
            }
        }

        br.close();
        bw.close();
    }


}

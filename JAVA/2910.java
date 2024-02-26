import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map을 이용해서 먼저 key값과 그 빈도를 value로 한다
 * - 입력된 순서대로 출력되도록 LinkedHashMap을 사용하였다.
 * - map을 정렬하기 위해서는 List에 key를 가져오고 람다식을 이용해서 sort하면된다.
 * - 이때 내림차순 정렬을 위해서는 compareTo를 이용한다
 * - 이렇게 완성한 리스트의 값을 map에 담긴 value만큼 출력하면 정답이 된다.
 * 
 * - MAP정렬 정리 
 * 1. Key값을 기준으로 정렬하기
 * - Collections을 이용하여 정렬한다
 * - 오름차순 시에는 Collections.sort()를 내림차순 시에는 Collections.reverse()를 사용한다
 * 2. Value값을 기준으로 정렬하기
 * - comparartor를 사용하여 정렬한다
 * - 오름차순/내림차순 전에 List에 map의 keySet을 담는다
 * - 해당 리스트를 sort하는데 람다식으로 간단하게 처리하면 다음과 같다
 * - list.sort((o1,o2) -> map.get(o1).compareTo(map.get(o2))) -> 오름차순
 * - list.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1))) -> 내림차순
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        List<Integer> key = new ArrayList<>(map.keySet());
        key.sort((o1, o2) ->  map.get(o2).compareTo(map.get(o1)));

        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < map.get(key.get(i)); j++) {
                bw.write(key.get(i) +" ");
            }
        }

        br.close();
        bw.close();
    }

}


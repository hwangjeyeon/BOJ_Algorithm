import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. Map으로 각 참가자 번호와 점수를 보관한다
 * 2. 우선순위 큐에 Map을 타입으로 하며, 내림차순 정렬로 보관한다.
 * 3. 2번 우선순위 큐를 통해서 k만큼 값을 poll해서 더하면 정답이 된다.
 * => 잘못 생각한 풀이
 * 1. 각 장르별로 1등을 뽑으면 된다
 * => 잘못 생각한 풀이
 * 1. 각 사람별로 가장 잘한 점수를 뽑으면 된다.
 * 2. 각 사람의 번호는 고유한 번호이므로 map을 사용해서 저장한다. 이때 값이 null이면 그냥 넣고 아니면 더 큰 값을 map의 value로 넣는다
 * 3. 이어서 내림차순 정렬된 우선순위 큐를 사용해서 저장하고 k만큼 뽑아서 ans에 더해준다
 * 4. String.format으로 "%.1f" 형식으로 출력하면 반올림된 값으로 출력되어서 정답이 된다.
 *
 * - 문제 해결:
 * - Math.round는 소수점 없이 다 날리고 정수 형태로 출력되도록 반올림하는 것이고, 소수점 이하 자릿수를 조정해서 반올림하고 싶으면 String.format("%.1f, 변수명)형식으로 출력하면 된다
 * - Map.merge -> HashMap.merge() 기능은 자바 8이후로 나온 기능이다.
 * -> 두 Map의 key가 같을 때, 덮어쓰거나 더하는 등의 연산을 할 수 있다.
 * -> map.forEach((key, value) -> map1.merge(key, value, (v1,v2) -> v1+v2));
 * -> map.forEach((key, value) -> map1.merge(key, value, (v1,v2) -> v2));
 * -> 이 문제에서는 두 정수, 실수타입을 하나의 맵에 저장하는데 메소드 래퍼런스를 이용하여, Math::max로 더 큰 값을 저장하게 하였다.
 * -> map.merge(number, count, Math::max);
 *
 *
 * 시간복잡도: O(n*m)
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
        Map<Integer, Double> map = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                double count = Double.parseDouble(st.nextToken());
                map.merge(number, count, Math::max);
            }
        }

        for(Map.Entry<Integer, Double> d : map.entrySet()){
            pq.add(d.getValue());
        }

        double ans = 0.0;
        for (int i = 0; i < k; i++) {
            ans += pq.poll();
        }

        bw.write(String.format("%.1f",ans));

        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 고민과 풀이:
 * 1. 그냥 Map에 값 입력받고, List에 Key를 받아서 오름차순 정렬한다
 * 2. 그리고 map에 입력 받을 때 전체 개수 세어서 각 list마다 그 값을 key로 하는 value를 count로 나눈뒤 String.format으로 포맷팅해서 출력하면 정답이다.
 *
 * 문제 해결:
 * - 해당 문제 정리할 때, TreeMap,HashMap등 같이 학습하기
 * - 리스트를 활용한 map 정렬도 같이 학습하기
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        Map<String, Double> map = new HashMap<>();
        double count = 0;
        while((input = br.readLine()) != null){
            map.put(input, map.getOrDefault(input,0.0)+1.0);
            count++;
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(s);
        }
//        list = list.stream().sorted().collect(Collectors.toList());
        Collections.sort(list, String::compareTo);

        for (int i = 0; i < list.size(); i++) {
            double ans = map.get(list.get(i)) / count;
            bw.write(list.get(i)+" ");
            bw.write(String.format("%.4f\n",ans*100.0));
        }



        br.close();
        bw.close();
    }


}

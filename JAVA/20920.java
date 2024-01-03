import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 자료구조 map과 list를 활용하여 푸는 문제이다.
 * - map을 이용하여 개수를 파악하고, list를 이용하여 정렬을 진행한다.
 * - 여기서 정렬 조건이 3가지나 되기 때문에, new Comparator<String>()을 오버라이딩해서 구현한다
 * - compare(String o1, String o2)을 구현한다
 * - 먼저 map.get(o1) != map.get(o2)조건으로 단어의 개수가 같은 경우는 2번 조건으로 가게한다
 * - 위 1번 조건에서 걸린 경우는, return maps.get(o2) - maps.get(o1)을 더 큰수를 먼저 정렬하게 한다 (내림차순)
 * - o1.length() != o2.length() 조건을 통해서 두 단어의 길이가 가지 않은 경우 3번 조건으로 가게한다
 * - 위 2번 조건에서 걸린 경우는, return o2.length() - o1.length() 조건을 통해 길이가 더 긴 경우 먼저 정렬하게 한다 (내림차순)
 * - 마지막으로 위 두가지 조건에 걸리지 않은 경우는 3번 조건을 통해서 알파벳 사전 순으로 앞에 있는 단어가 앞에 배치하도록 한다
 * - 따라서 o1.compareTo(o2)를 통해서 오름차순 정렬하게 해서 3번 조건을 만족시킨다
 * - 이렇게 완성한 정렬은 words 리스트에 저장되어있으므로, iteration을 통해 출력한다.
 *
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
        Map<String, Integer> maps = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length() < m){
                continue;
            }
            maps.put(s,maps.getOrDefault(s,0) + 1);
        }
        List<String> words = new ArrayList<>(maps.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(maps.get(o1) != maps.get(o2)){
                    return maps.get(o2) - maps.get(o1);
                }
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });

        for (String word : words) {
            bw.write(word + "\n");
        }


        br.close();
        bw.close();
    }

}

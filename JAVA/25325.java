import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. map과 리스트, 정렬을 위한 클래스 선언과 정렬 람다식 선언까지 해주면 되는 문제다
 * 2. 문제를 이해만 하면 자료구조 조합으로 쉽게 풀 수 있다
 * 3. 각 학생을 좋아하는 사람의 이름이 아닌, 현재 학생이 좋아하는 학생의 이름 목록으로 생각해야한다
 * 4. 그렇기에 그 학생을 좋아하는 사람이 현재 학생이기에 목록에 있는 학생의 좋아하는 사람 수를 늘려주면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Pair{
    String name;
    int num;

    public Pair(String name, int num) {
        this.name = name;
        this.num = num;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            map.put(name, 0);
            list.add(name);
        }

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            for (String s : a) {
                map.put(s, map.get(s) + 1);
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (String s : map.keySet()) {
            pairs.add(new Pair(s, map.get(s)));
        }
        Collections.sort(pairs, (o1, o2) -> {
            if(o1.num == o2.num) {
                return o1.name.compareTo(o2.name);
            }
            return o2.num - o1.num;
        });

        for (int i = 0; i < pairs.size(); i++) {
            bw.write(pairs.get(i).name + " " + pairs.get(i).num+"\n");
        }
        
        br.close();
        bw.close();
    }
}

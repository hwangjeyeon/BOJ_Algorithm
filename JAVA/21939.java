import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 이번에는 TreeSet과 HashMap을 이용하여 해결하는 문제다
 * 2. TreeSet으로 값의 자유로운 추가와 어려운 난이도 중 가장 번호가 큰 값, 쉬운 난이도중 가장 번호가 작은 값을 출력할 수 있다
 * 3. 이때 TreeSet은 Pair 쌍으로 등록하여야 한다
 * 4. solved로 TreeSet에서 제거하기 위해서 Pair 쌍에 대해서 알아야 한다
 * 5. 그러기 위해 문제 번호가 난이도를 key-value로 갖는 map을 하나 더 선언하여 관리하도록 하였다
 * 6. map의 key와 value를 가져와서 new Pair로 TreeSet에 넣으면 remove시 자동으로 제거된다
 * 7. new Pair라서 다른 객체인데 왜 기존 객체를 잘 찾아서 remove할 수 있을까? 바로 람다식으로 compare를 오버라이딩 했기 떄문이다
 * 8. compare를 오버라이딩하면 내부적으로 equals를 재정의하는 것을 내포한다. 따라서 별도의 equals나 hashcode를 재정의하지 않고도 remove가 제대로 동작하고 제거된다
 * 9. recommend일때 last().num과 first().num을 잘 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Pair{

    int num;
    int diff;

    public Pair(int num, int diff) {
        this.num = num;
        this.diff = diff;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Pair> treeSet = new TreeSet<>((o1, o2) ->{
            if(o1.diff == o2.diff){
                return o1.num - o2.num;
            }
            return Integer.compare(o1.diff, o2.diff);
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            treeSet.add(new Pair(num, diff));
            map.put(num, diff);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                treeSet.add(new Pair(num, diff));
                map.put(num, diff);
            }else if(order.equals("recommend")){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    bw.write(treeSet.last().num+"\n");
                }else{
                    bw.write(treeSet.first().num+"\n");
                }
            }else if(order.equals("solved")){
                int num = Integer.parseInt(st.nextToken());
                treeSet.remove(new Pair(num, map.get(num)));
            }

        }

        br.close();
        bw.close();
    }
}


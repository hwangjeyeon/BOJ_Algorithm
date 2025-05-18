import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시간에 대한 계산 자체는 Map을 사용하면 된다
 * 2. 비용 계산에 있어서는 클래스를 활용해야한다. 왜냐하면 정렬 형식을 맞추기 위해서는 Map으로는 부족하기 때문이다
 * 3. 완성된 결과를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Count{
    String name;
    Long money;

    public Count(String name, long money) {
        this.name = name;
        this.money = money;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] time = st.nextToken().split(":");
            String name = st.nextToken();
            map.put(name, map.getOrDefault(name, 0L) + Long.parseLong(time[0])*60 + Integer.parseInt(time[1]));
        }

        List<Count> countlist = new ArrayList<>();
        for (String s : map.keySet()) {
            long time = map.get(s);
            if(time <= 100){
                countlist.add(new Count(s,10));
            }else{
                time -= 100;
                countlist.add(new Count(s,((time%50) != 0 ? 10 + (time/50) * 3 + 3: 10 + (time/50)*3)));
            }
        }

        Collections.sort(countlist, (o1, o2) -> {
            if(o1.money.equals(o2.money)){
                return o1.name.compareTo(o2.name);
            }
            return o2.money.compareTo(o1.money);
        });

        for (Count count : countlist) {
            bw.write(count.name + " " + count.money + "\n");
        }
        
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.time.LocalTime;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 시간을 파싱해서 하나의 시간값으로 잡을 수도 있지만 자바에는 LocalTime이라는 타입이 존재한다.
 * 2. 입력값이 딱 LocalTime에 해당되기 떄문에, 해당 타입으로 입력값을 받는다
 * 3. 해당 문제는 스위핑으로 해결할 수 있다. 들어오는 시간과 나가는 시간이 존재하며, 그 시간 범위 내에 가장 많이 중첩되는 수를 구하기 때문이다
 * 4. 해당 접근으로 문제를 푼다면 type을 지정해서 하나의 리스트에 start는 1로 end는 -1로 지정해서 저장한다
 * 5. 스위핑을 위해 먼저 리스트를 time으로 오름차순 정렬한다
 * 6. 누적합 방식을 이용하는 스위핑의 특성으로 문제를 해결할 수 있다. sum이라는 누적합 변수를 하나 만들고 정답을 위한 ans 변수도 하나 만든다
 * 7. 입력값의 type을 sum에 더해준다. 이후 ans에는 sum과 비교했을 때, 더 큰 값이 들어가도록 한다
 * 8. 이 문제에서는 최소를 찾는 것이라 min으로 착각할 수 있지만, 결국 가장 많이 중첩되는 경우를 구하는 것이고 따라서 스위핑에서는 최대를 구하면 된다
 * 9. 완성한 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(2*n)
 *
 */

class Pair{

    LocalTime time;
    int type;

    public Pair(LocalTime time, int type) {
        this.time = time;
        this.type = type;
    }
}


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            LocalTime a = LocalTime.parse(st.nextToken());
            LocalTime b = LocalTime.parse(st.nextToken());
            pairs.add(new Pair(a,1));
            pairs.add(new Pair(b, -1));
        }

        pairs.sort((o1, o2) -> {
            return o1.time.compareTo(o2.time);
        });

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            sum += pairs.get(i).type;
            ans = Math.max(ans, sum);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. 처음 생각한 정렬 방법은 데드라인 오름차순 정렬 + 같을 경우 컵라면 수 내림차순 정렬이었다.
 * => 틀린 풀이, 데드라인이 작은 애들의 컵라면 받을 수 있는 수가 극단적으로 작을 경우 그닥 의미가 없다..
 * 2. 그럼 두번째는 컵라면 수 내림차순 정렬 + 같을 경우 데드라인 오름차순 정렬
 * => 이것도 틀린 풀이이다.
 * 3. 이 문제의 핵심은 위 1번 정렬을 하면서 컵라면을 최대로 받을 수 있는 경우를 찾아한다. 데드라인이 작은 것들을 아예 선택 안하고 컵라면 수가 많은 것들만 선택해도 되기때문에
 * 문제 접근을 다시 생각해야 한다.
 *
 * - 문제 해결:
 * 1. 힌트를 참고했는데, 나와 같은 생각을 하고 접근했다가 틀린 사람이 많았다
 * 2. 입력을 리스트로 받거나 배열로 받아 위 정렬을 진행하고 이후에 한가지 더 만족시켜야 하는 컵라면을 최대로 받을 수 있는 경우를 찾는 행위를 위해 우선순위 큐를 사용해야한다
 * 3. 우선순위 큐의 크기를 데드라인으로 생각하면 된다. 만약 배열의 시간이 데드라인보다 크기보다 크면 데드라인의 값을 하나 poll하면 된다
 * 4. 그리고 우선순위 큐에는 컵라면 개수를 넣어준다. 오름차순 정렬이기에 작은 값은 앞으로 가게 되어 위 3번 진행 시에 제일 먼저 빠지게 된다
 * 5. 이 과정을 진행하면 받을 수 있는 최대의 컵라면 개수를 얻을 수 있게 되고, 순회해서 모든 값을 더해주면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Problem{
    int time;
    int count;

    public Problem(int time, int count) {
        this.time = time;
        this.count = count;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Problem> lists = new ArrayList();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(time, count);
            lists.add(problem);
        }
        Collections.sort(lists, ((o1, o2) -> {
            return o1.time==o2.time ? o2.count - o1.count : o1.time - o2.time;
        }));

        int now = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(pq.isEmpty()){
                pq.add(lists.get(i).count);
                continue;
            }
            pq.add(lists.get(i).count);
            if(lists.get(i).time < pq.size()){
                pq.poll();
            }

        }

        for (Integer i : pq) {
            ans += i;
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}


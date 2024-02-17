import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 15903번 문제랑 비슷한 문제. 예전에 풀었던 유형이라 풀이 방법을 쉽게 떠올릴 수 있었다.
 * - 문제 설명을 읽어보면 정말 많은 분기를 고려해야할 것 같은 근심이 드는데 우선순위 큐로 오름차순 정렬시키고 맨앞 두수를 더해서 다시 우선순위 큐에 넣는 방식으로 풀면 된다는 것을 예제를 통해서 확인할 수 있다.
 * - 한가지 주의할 점은 ans만 long으로 하는 것이 아니라 우선순위 큐에서 poll하는 값, sum값 그리고 우선순위 큐의 자료형까지 모두 long형으로 선언해야한다
 * - 그래야지 오버플로우가 발생하지 않는다. 최악 ( 1000000 * 10000)이므로 int형 자료 범위를 아득히 넘는다
 * - 이 방식으로 풀고 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long ans = 0;
            while(!pq.isEmpty()){
                if(pq.size() == 1){
                    break;
                }
                long first = pq.poll();
                long second = pq.poll();
                long sum = first + second;
                ans += sum;
                pq.add(sum);
            }
            bw.write(ans+"\n");
        }


        br.close();
        bw.close();
    }

}


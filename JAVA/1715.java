import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 우선순위 큐를 활용하는 유형의 문제이다.
 * 2. 일단 가장 작은 값들끼리 더하면 문제의 조건을 충족하는 가장 효율적인 방법이다.
 * 3. 우선순위 큐를 활용하는 가장 전형적인 유형인 오름차순 정렬 후, 가장 앞에 두 수를 빼서 더한 뒤, 다시 우선순위큐에 넣는 방식이다.
 * 4. 이 과정에서 더한 값은 ans에 더해주고 다시 우선순위 큐에 넣어준다
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.add(input);
        }
        int ans = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


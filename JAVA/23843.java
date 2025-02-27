import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 모두 Long타입으로 지정해야 한다
 * 2. 입력 배열은 내림차순, 우선순위 큐는 오름차순 정렬한다
 * 3. n만큼 순회를 돌면서 만약 pq의 크기가 m보다 크거나 같으면 ans를 pq.poll()으로 갱신한다
 * 4. 이후 pq가 빌때까지 pq의 값을 빼서 ans를 갱신한다. 
 * 5. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
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
        Long[] arr = new Long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if(pq.size() >= m){
                ans = pq.poll();
            }

            pq.add(ans + arr[i]);
        }

        while(!pq.isEmpty()){
            ans = pq.poll();
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

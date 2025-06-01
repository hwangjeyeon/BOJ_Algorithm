import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 내림차순 정렬된 우선순위 큐를 활용해서, 가장 큰 값을 뽑을 수 있도록 한다
 * 2. 아이들이 원하는 선물의 개수를 파악하는 동안 우선순위 큐의 가장 큰 값이 선물의 개수보다 작은 경우 ans를 0으로 바꾼다
 * 3. ans의 초기값은 1이라는 점을 이용해서 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(logn)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int a = pq.poll();
            if(num > a){
                ans = 0;
            }else{
                a -= num;
            }
            pq.offer(a);
        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }
}

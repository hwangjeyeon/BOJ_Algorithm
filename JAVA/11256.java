import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 쉬운 문제다. 최소한의 상자로 사탕을 담기 위해서는 가장 큰 넓이에 먼저 담는 방법으로 그리디하게 선택하면 된다
 * 2. 따라서 자바의 우선순위 큐를 내림차순으로 등록되도록 사용해서 candy가 0보다 큰동안 그 넓이만큼 빼주고 count를 세어준뒤 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O(T*n)
 * 공간복잡도: O(T*n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.offer(h*w);
            }
            int ans = 0;
            while(candy > 0){
                candy -= pq.poll();
                ans++;
            }

            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}


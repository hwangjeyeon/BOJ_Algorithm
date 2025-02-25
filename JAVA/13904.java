import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 우선순위 큐를 사용하는 방법과 그냥 리스트를 사용하면서, 가능한 날짜중에서 가장 마지막 날짜부터 역순으로 탐색하는 방법이 있다
 * 2. 둘다 풀어봤으며, 이번 정리는 우선순위큐를 활용하는 방법만 정리했다. 이후 재풀이할 때 역순탐색방법도 정리할 계획이다
 * 3. 그리디하게 푸는 문제다. 일단 우선순위 큐를 사용해서 점수를 기준으로 내림차순 정렬하자
 * 4. 최대 날짜의 수는 1000일이다. PQ가 빌때까지 탐색하며, 현재 PQ에서 뽑은 날짜의 방문여부를 체크한다
 * 5. 만약 방문하지 않았다면 그 과제를 하면 된다. 그래서 정답에 현재 점수를 더하고 그 날짜를 방문체크한다
 * 6. 만약 방문하지 않았다면 그 날짜의 이전 날짜 중에서 한 날짜를 정해서 그 날짜에 현재 숙제를 하면 된다
 * 7. 이때 현재 날짜 - 1부터 0보다 클 동안에 감소 탐색을 진행하며, 방문하지 않았다면 똑같이 정답에 점수를 더하고 그 날짜를 방문체크한뒤 탐색을 탈출한다
 * 8. 완성한 ans를 출력하면 정답이 된다
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b});
        }
        boolean[] visited = new boolean[1001];
        int ans = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(!visited[now[0]]){
                ans += now[1];
                visited[now[0]] = true;
            }else{
                for (int i = now[0] - 1; i > 0; i--) {
                    if(!visited[i]){
                        ans += now[1];
                        visited[i] = true;
                        break;
                    }
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

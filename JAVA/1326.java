import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. BFS로 푸는 문제다.
 * 2. 현재의 위치에 적혀있는 숫자만큼 배수를 더해서 양 옆으로 갔을 때로 확장한 뒤, 정답을 찾는 문제이기 때문이다
 * 3. 문제에서 몇 번째를 시작하는 위치와 끝나는 위치로 주었기에 n+1로 설정해주고, 1번 인덱스부터 사용하였다
 * 4. 큐를 이용하여 BFS를 시작한다. 이때 타입은 배열로 하며, 0번인덱스는 현재 위치, 1번 인덱스는 누적된 이동 횟수로 한다
 * 5. 매 탐색마다 만약 큐에서 뽑은 현재 위치가 목적지라면 정답에 현재까지 누적된 이동횟수를 넣어주고 메소드를 종료시킨다
 * 6. 아닌경우 현재의 위치에 적힌 숫자를 move 변수에 담아준다
 * 7. 이어서 오른쪽으로 가는 경우와 왼쪽으로 가는 경우를 나눠서 탐색한 뒤 큐에 넣어준다
 * 8. 현재 위치를 시작으로 i에 move를 더해서 그 배수만큼 으론쪽으로 가는 경우를 모두 큐에 넣어주고, 반대의 경우는 i에 move를 빼서 그 배수만큼 왼쪽으로 가는 경우를 모두 큐에 넣어준다
 * 9. 최소 횟수를 구하기 위해 방문 배열을 이용하여 미방문한 경우만 탐색하도록 한다.
 * 10. 완성된 ans를 출력하면 정답이 된다. 못찾는 경우를 대비해 초기값을 -1로 설정해두면 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    static int[] arr;
    static int ans = -1;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bfs(n, start, end);

        bw.write(ans+"");


        br.close();
        bw.close();
    }

    private static void bfs(int n, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == end){
                ans = cur[1];
                return;
            }
            int move = arr[cur[0]];

            for (int i = cur[0]; i < n+1; i+=move) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, cur[1]+1});
                }
            }

            for (int i = cur[0]; i > 0; i-=move) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, cur[1]+1});
                }
            }

        }
    }

}


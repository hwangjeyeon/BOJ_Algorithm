import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BFS풀면 되는 쉬운 문제다.
 * 2. 주어진 조건에 맞게 배열을 준비하고 배열이 0이면 다이스 만큼 이동해서 탐색, 아니면 해당 값으로 이동하면 문제가 쉽게 해결된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] dice = {+1,+2,+3,+4,+5,+6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            arr[p1] = p2;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            arr[p1] = p2;
        }
        
        bfs(n,m,1);
        bw.write(arr[100]+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == 100){
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nMove = now[0] + dice[i];
                if(nMove > 0 && nMove < 101 && !visited[nMove]) {
                    if(arr[nMove] == 0){
                        q.add(new int[] {nMove, now[1]+1});
                        visited[nMove] = true;
                        arr[nMove] = now[1] + 1;
                    }else{
                        if(!visited[nMove]){
                            q.add(new int[] {arr[nMove], now[1]+1});
                            visited[arr[nMove]] = true;
                            arr[arr[nMove]] = now[1] + 1;
                        }
                    }

                }

            }


        }

    }


}


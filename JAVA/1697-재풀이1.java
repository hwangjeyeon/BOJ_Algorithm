import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {

    static StringBuilder sb = new StringBuilder();
    static int timer = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited =  new boolean[100001];
        bfs(n,m);

        bw.write(String.valueOf(timer));
        br.close();
        bw.close();
    }

    private static void bfs(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean isOk = false;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if(now == m){
                    isOk = true;
                    break;
                }

                if(now-1 >=0 && now-1 < 100001 && !visited[now-1]){
                    q.add(now-1);
                    visited[now-1] = true;
                }
                if(now+1 >= 0 && now+1 < 100001 && !visited[now+1]){
                    q.add(now+1);
                    visited[now+1] = true;
                }
                if(now*2 >= 0 && now*2 < 100001 && !visited[now*2]){
                    q.add(now*2);
                    visited[now*2] = true;
                }
            }
            if(isOk){
                break;
            }
            timer++;
        }

    }


}


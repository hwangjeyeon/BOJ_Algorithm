import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BFS로 풀면 되며, 큐에는 S,T,누적되는 count값을 넣어주면 된다
 *
 *
 * - 문제 해결:
 * 2. 만약 s가 t보다 커지면 continue해주고, 입력값 내 범위를 지정해줄 필요는 없다.
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            bfs(s,t);
            bw.write(sb.toString()+"\n");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int s, int t) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s,t,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == now[1]){
                sb.append(now[2]);
                return;
            }
            if(now[0] > now[1]){
                continue;
            }
            int[] select = {now[0]+1, 2*now[0]};
            for (int i = 0; i < 2; i++) {
                int ns = select[i];
                if(i==1){
                    q.add(new int[] {ns, now[1]+3, now[2]+1});
                }else{
                    q.add(new int[] {ns, now[1], now[2]+1});
                }
            }

        }
    }

}


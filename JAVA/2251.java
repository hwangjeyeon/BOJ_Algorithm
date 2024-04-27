import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 
 * 해결방법:
 * 1. BFS로 푸는 문제지만 탐색을 보내는 쪽과 받는 쪽으로 지정해서 해야한다
 * 2. 큐에는 A와 B에 남겨져 있는 현재 물의 양을 넣어준다
 * 3. 이때 만약 A와 B의 부피가 넘겨진 물의 양보다 작다면 그 크기만큼 빼서 더해준다
 * 4. 그다음 방문 여부를 체크하고 탐색을 반복하며, 만약 A의 위치의 값이 0이면 answer을 true로 바꿔준다
 * 5. 이제 해당하는 answer을 모두 출력하면 정답이 된다.
 * 6. 논리적으로 따져보는 문제이기에 다시 풀어볼 예정이다.
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {


    static int[] now;
    static boolean[] answer = new boolean[201];
    static boolean[][] visited = new boolean[201][201];
    static int[] from = {0,0,1,1,2,2};
    static int[] to = {1,2,0,2,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        now = new int[]{a,b,c};
        bfs(a,b,c);

        for (int i = 0; i < answer.length; i++) {
            if(answer[i]){
                bw.write(i +" ");
            }
        }
        br.close();
        bw.close();
    }

    private static void bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int A = tmp[0];
            int B = tmp[1];
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++) {
                int[] nx = {A,B,C};
                nx[to[i]] += nx[from[i]];
                nx[from[i]] = 0;
                if(nx[to[i]] > now[to[i]]){
                    nx[from[i]] = nx[to[i]] - now[to[i]];
                    nx[to[i]] = now[to[i]];
                }
                if(!visited[nx[0]][nx[1]]){
                    visited[nx[0]][nx[1]] = true;
                    q.add(new int[]{nx[0],nx[1]});
                    if(nx[0] ==0 ){
                        answer[nx[2]] = true;
                    }
                }

            }

        }



    }
}


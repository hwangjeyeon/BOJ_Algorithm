import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BFS를 이용하여 해결하는 문제이다.
 * - 해결방법은 각 층을 버튼 누른 횟수 즉 depth 깊이로 누적하여 저장하는 방식이다.
 * - count를 활용하였으나 계속 틀려서 위와 같은 방법으로 변경하였다.
 * - start는 1로 처리한다
 * - 이어서 큐에 start를 넣고 poll한 뒤, end랑 now랑 같은지 비교하여 같으면 탈출하고 아니면 계속진행한다
 * - now+up과 now-down이 각각 범위를 벗어나지 않고 방문을 하지 않았다면 (업뎃이 안 되었으므로 0인 경우) 큐에 각각의 분기를 넣어주고, 해당 visited 배열 인덱스에 현재 배열 인덱스 값 +1을 해준다.
 * - 이렇게 완성한 결과를 목표 층의 배열 값이 0이 아니면 시작점에서는 버튼이 눌리지 않았는데 방문 확인 목적으로 1로 처리했으므로 1을 빼주고 출력한다
 * - 위 조건이 아니면 문제에서 말하는 문자열을 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {
    static int[] visited;
    static void bfs(int height, int start, int end, int up, int down){
        visited = new int[height+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(end == now){
                break;
            }


            if(now + up < height+1 && visited[now+up]==0){
                q.add(now+up);
                visited[now+up] = visited[now]+1;
            }

            if(now - down > 0 && visited[now-down] == 0){
                q.add(now-down);
                visited[now-down] = visited[now]+1;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        bfs(F,S,G,U,D);

        if(visited[G] != 0){
            bw.write(String.valueOf(visited[G]-1));
        }else{
            bw.write("use the stairs");
        }

        for (int i = 0; i < F+1; i++) {
        }

        br.close();
        bw.close();
    }


}


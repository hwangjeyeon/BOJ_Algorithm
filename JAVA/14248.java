import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. bfs로 풀면되는 문제, 좌표 문제랑 조금 다른건 미리 배열을 만들지 말고 q에서 값을 꺼내는 각 순회마다 2가지 경우를 만들어서 풀어준다
 * 2. 하나는 현재위치에서 현재위치의 값을 빼는 경우 나머지 하나는 더하는 경우이다
 * 3. 이렇게 2가지 경우를 생각해서 각 경우가 범위를 벗어나지 않고 방문하지 않았으면 count를 증가시키고 출력하면 정답이 된다
 * 4. 참고로 처음 시작도 count를 세어줘야한다. 이를 포함해서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        bfs(n, start);
        bw.write(count + "");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        count++;
        while(!q.isEmpty()){
            int now = q.poll();
            int[] move = {now-arr[now],now+arr[now]};
            for (int i = 0; i < 2; i++) {
                if(move[i] > 0 && move[i] <= n && !visited[move[i]]){
                    visited[move[i]] = true;
                    q.add(move[i]);
                    count++;
                }
            }
        }

    }

}


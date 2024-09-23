import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 제한적인 백트래킹으로 문제를 해결하는 문제다
 * 2. 이 문제는 이해만 하면 백트래킹으로 해결해야함을 쉽게 유추할 수 있다
 * 3. 모든 지점을 순회하면서 그 지점을 시작으로 count 값을 누적해 더해가는 백트래킹을 해야한다
 * 4. 이때 count가 5가 되는 지점이 있다면 isFind를 true로 바꿔주고 종료시켜서 시간초과를 방지해야한다
 * 5. 또한 DFS 방식이기 때문에 백트래킹 방식으로 재귀함수 종료후에는 방문배열의 방문체크를 해제해야한다
 * 6. 이후 다시 돌아와서 어느 지점을 시작으로 백트래킹 했을 때, isFind가 true라면 break로 탈출해야한다. 그러지 않으면 시간초과가 발생한다
 * 7. 이점을 고려하여 탐색한 뒤 isFind에 따라 1또는 0을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n x m x 5)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static boolean[] visited;
    static List<Integer>[] lists;
    static boolean isFind = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            backtracking(1, i);
            if(isFind){
                break;
            }
        }

        if(isFind){
            bw.write("1");
        }else{
            bw.write("0");
        }

        br.close();
        bw.close();
    }

    private static void backtracking(int count, int now) {
        if(count == 5){
            isFind = true;
            return;
        }
        visited[now] = true;

        for (Integer i : lists[now]) {
            if(!visited[i]){
                backtracking(count+1, i);
            }
        }
        visited[now] = false;

    }

}


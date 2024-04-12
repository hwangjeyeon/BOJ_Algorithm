import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 문제 이해나 구현자체는 쉬운 문제이다.
 * 2. 일단 해당 문제를 이해했을때, 양방향이 아니라 단방향으로 구현해주면 된다.
 * 3. 그다음 bfs탐색으로 가장 많이 탐색되는 컴퓨터를 찾아주면 된다.
 * 
 * 해결방법:
 * 1. 첫번째 시도에서는 메모리 초과가 발생했다. 아무래도 2차원 배열로 그래프를 표현했기 때문인 것 같다
 * 2. 따라서 리스트 배열로 바꿔서 해결했다
 * 3. 하지만 추가로 시간초과가 발생했다. 문제가 굉장히 타이트해보인다...
 * 4. 이번 해결 방법은 정답을 가려내는 부분의 수정에서 있었다. 입력과 동시에 max값과 count값을 비교하고 리스트에 저장하는 방식으로 해서 발생하는 문제였다
 * 5. 따라서 해당 문제를 배열로 바꿔서, 순회 이후 가장 큰 값을 찾고 출력할때 가장 큰값과 같은 정점을 출력하도록 하였다.
 * 
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(nm)
 *
 */


public class Main {

    static List<Integer>[] arr;
    static int count = 0;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        ans = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            arr[p1].add(p2);
        }


        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }
        int max = 0;

        for (int i = 1; i < n+1; i++) {
            max = Math.max(max, ans[i]);
        }

        for (int i = 1; i < n + 1; i++) {
            if(ans[i] == max){
                bw.write(i+" ");
            }

        }



        br.close();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        count++;
        while(!q.isEmpty()){
            int now = q.poll();
            for (Integer i : arr[now]) {
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    ans[i]++;
                }
            }
        }
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 선행 조건이 존재하며, 순서를 구해야하는 문제인데, 사이클이 없는 (A<B조건 때문) 조건 덕분에 위상정렬로 쉽게 해결할 수 있는 문제다
 * 2. 위상정렬을 위한 선행조건을 담을 lists 리스트배열과 선행조건 개수를 담을 edge 배열, 그리고 순서를 담아줄 ans 배열을 하나씩 선언한다
 * 3. 선행과목에 후행 과목을 넣어주는 방식으로 이어주고 후행과목의 선행과목 개수를 증가시킨다
 * 4. 이후 위상정렬 알고리즘을 돌리며 edge가 0일 때 최초에 대해서는 ans++를 해주고, 이후 선행 조건이 있는 경우에 대해서는 선행 조건 배열 + 1한 값을 넣어준다
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n+m)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int[] edge;
    static List<Integer>[] lists;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edge = new int[n+1];
        lists = new ArrayList[n+1];
        ans = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            edge[b]++;
        }

        topological(n);
        for (int i = 1; i < n + 1; i++) {
            bw.write(ans[i]+ " ");
        }

        br.close();
        bw.close();
    }

    private static void topological(int n) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if(edge[i] == 0){
                q.add(i);
                ans[i]++;
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();

            for (Integer i : lists[tmp]) {
                edge[i]--;
                if(edge[i] == 0){
                    q.add(i);
                    ans[i] += ans[tmp] + 1;
                }
            }
        }

    }
}


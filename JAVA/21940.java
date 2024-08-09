import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. Ai -> bi로 가는 시간과 Bi에서 Ai로 가는 시간이 다를 수 있다는 내용을 보고 플로이드 워셜 문제임을 떠올리게 되었다
 * 2. 플로이드 워셜을 통해 이동할 수 있는 최단 거리를 구한다
 * 3. 이후, 정답배열을 만들고 각 노드별로 주어진 k개의 리스트에 있는 노드들을 왕복하는 시간중 최대를 구한다
 * 4. 그리고 이렇게 구한 왕복시간이 최대인 값을 min 변수와 비교해 min이 더 큰경우 정답 리스트를 비우고 현재 노드를 넣어준뒤 min을 교체한다
 * 5. 만약 같다면 그냥 리스트에 현재 노드를 넣어준다
 * 6. 각 리스트와 min은 나올 수 있는 가장 큰 시간인 200*200*1000인 40000001을 넣어준다
 * 7. 주의할 점은 dist의 i가 같은 경우는 0을 넣어준다.
 * 8. 완성된 리스트를 출력하면 된다. 어차피 처음 노드부터 탐색해서 넣어주므로 오름차순 정렬은 알아서 되어 있기 때문에 그냥 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

class Node{

    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}


public class Main {

    static int[][] dists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dists = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dists[i], 40000001);
            dists[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dists[a][b] = c;
        }

        int k = Integer.parseInt(br.readLine());
        List<Integer> lists = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            lists.add(a);
        }

        floydWarshall(n);


        List<Integer> ans = new ArrayList<>();

        int min = 40000001;
        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (Integer list : lists) {
                max = Math.max(max, dists[list][i] + dists[i][list]);
            }

            if(min > max){
                ans.clear();
                ans.add(i);
                min = max;
            }else if(min == max){
                ans.add(i);
            }
        }

        for (Integer an : ans) {
            bw.write(an+ " ");
        }

        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(dists[j][k] > dists[j][i] + dists[i][k]){
                        dists[j][k] = dists[j][i] + dists[i][k];
                    }
                }
            }
        }

    }

}

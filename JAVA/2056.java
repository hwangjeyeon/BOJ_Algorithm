import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 해당 문제 역시 DAG이며, 작업 순서가 존재하는 문제이기 때문에 위상정렬로 해결할 수 있는 문제다
 * 2. 기존 위상 정렬에 dp를 활용하여 해결해야한다. 
 *
 * 해결방법:
 * 1. result 배열을 하나 선언하며, 최초에는 해당 배열에 cost를 넣어준다
 * 2. 이후 순회하면서 result[i]에 result[i]와 result[tmp] + cost[i]한 값을 비교하여 더 큰 값을 넣어준다. 이는 현재 작업의 비용과 선행되어야하는 작업의 진행 시간 + 현재 작업의 비용시간을 비교했을 때 더 늦게 끝나는 작업을 찾는 과정이다
 * 3. 이렇게 해야하는 이유는 선행되어야하는 작업이 모두 끝나야지 다음 작업을 시작할 수 있으며, 그럴때 선행 작업중 가장 늦게 끝나는 것이 최소 시간이 될 수 있기 때문이다
 * 4. 위상정렬 후에, 다시 result를 순회하여 가장 큰값을 ans에 넣고 이후 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n+m)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    static List<Integer>[] lists;
    static int[] edge;
    static int[] cost;
    static int ans = 0;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        edge = new int[n+1];
        cost = new int[n+1];
        result = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            cost[i] = time;
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                lists[a].add(i);
                edge[i]++;
            }
        }
        topological(n);

        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, result[i]);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void topological(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            result[i] = cost[i];
            if(edge[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();

            for (Integer i : lists[tmp]) {
                edge[i]--;
                result[i] = Math.max(result[i], result[tmp] + cost[i]);
                if(edge[i] == 0){
                    q.add(i);
                }
            }
        }


    }
}


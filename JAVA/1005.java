import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 위상 정렬 학습 후, 해당 문제를 해결하였다
 * 2. 기본 위상정렬 구현에서 한가지를 더 생각하고 문제를 풀면 된다
 * 3. 먼저 주어진 그래프는 리스트 배열로 구현해주면 된다
 * 4. 입력받은 시간은 진입차수가 아니다. 진입차수는 위 3번에서 그래프로 구현할 때, second의 진입차수 배열 인덱스의 값을 증가시킨다
 * 5. 시간은 따로 craft 배열로 만들어서 관리해준다
 * 6. 이제 위상정렬을 할 차례이다. 큐를 만들고, 정답을 담을 배열을 하나 만들어준다
 * 7. 각 정답 배열에는 그 정답 인덱스와 동일한 craft 배열의 인덱스의 건설 시간을 먼저 넣어준다
 * 8. 이어서 진입차수 배열의 해당 인덱스가 0일때 큐에다가 넣어준다
 * 9. 큐가 빌때까지 순회를 반복한다. 큐에서 하나씩 뽑아서 해당 리스트 배열의 인덱스에 해당하는 모든 값을 확인한다
 * 10. 먼저 ans에 더 큰 값을 넣어주는 작업을 해주어야한다. 건물의 총 소요시간은 이전까지의 소요시간 + 현재 건물 시간이다.
 * 11. 만약 그냥 넣어준다면 이전 테크가 완성도 되지 않았는데, 넣어주는 경우가 발생한다. 따라서 ans[li] = Math.max(ans[li], ans[now] + craft[li]); 과정을 먼저 진행해준다
 * 12. 이어서 해당 노드의 진입차수를 감소시킨다
 * 13. 마지막으로 만약 해당 노드의 진입차수가 0이라면 큐에 다시 넣는다
 * 14. 이제 진행한 위상정렬을 바탕으로 문제에서 찾고 싶어하는 int[w]를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n+k)
 * 공간복잡도: O(n+k)
 *
 */

public class Main {

    // 임시 그래프
    static List<Integer>[] node = new ArrayList[9];

    // 그래프 노드 별, 진입차수
    static int[] edge = new int[9];
    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < edge.length; i++) {
            if(edge[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now +" ");
            List<Integer> list = node[now];
            for (int i = 0; i < list.size(); i++) {
                edge[list.get(i)]--;
                if(edge[list.get(i)] == 0){
                    q.offer(list.get(i));
                }
            }
        }

    }

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int time = 0;
            // 입력 시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 건설 시간
            int[] craft = new int[n+1];

            //진입차수
            int[] edge = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                craft[j] = Integer.parseInt(st.nextToken());
            }

            // 그래프
            List<Integer>[] list = new ArrayList[n+1];
            for (int j = 0; j < n+1; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                list[first].add(second);
                edge[second]++;
            }
            int w = Integer.parseInt(br.readLine());
            // 입력 끝
            
            // 위상정렬 시작
            Queue<Integer> q = new LinkedList<>();
            int[] ans = new int[n+1];
            for (int j = 1; j < n + 1; j++) {
                ans[j] = craft[j];
                if(edge[j] == 0){
                    q.offer(j);
                }
            }

            while(!q.isEmpty()){
                int now = q.poll();

                for(Integer li : list[now]){
                    ans[li] = Math.max(ans[li], ans[now] + craft[li]);
                    edge[li]--;

                    if(edge[li] == 0){
                        q.offer(li);
                    }
                }
            }
            bw.write(ans[w]+"\n");
        }

        br.close();
        bw.close();
    }

}


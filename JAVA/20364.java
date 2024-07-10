import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. dfs는 2^20이라는 시간복잡도 떄문에 시간초과가 발생한다
 * 2. 그냥 트리의 성질을 이용해서 푸는 문제다
 * 3. 자식 노드 / 2가 부모 노드 인덱스라는 것을 이용해서, 1까지 탐색한다.
 * 4. 이때 만약 방문했다면 ans에 해당 노드 인덱스를 넣는다
 * 5. 참고로 발견했을 때, 바로 break하면 안된다. 이후 부모 노드에서 이미 방문한 노드가 있을 수 있고, 탐색 과정이 최상위 루트 노드에서 내려가는 방식이라 최대한 상위 노드에 있는 것으로 출력하도록 해야한다
 * 6. ans가 0이면 해당 목표 위치까지 갈 수 있다는 의미이므로 해당 목표 위치를 방문처리하고 0을 그대로 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(qlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+2];
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int ans = 0;
            int tmp = x;

            while(tmp >= 1){
                if(visited[tmp]){
                    ans = tmp;
                }
                tmp/=2;
            }

            if(ans == 0){
                visited[x] = true;
            }

            bw.write(ans+"\n");
        }


        br.close();
        bw.close();
    }

}


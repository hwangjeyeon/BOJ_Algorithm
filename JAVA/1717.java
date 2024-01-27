import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 분리집합-유니온파인드 문제를 공부하고자 푼 문제
 * - 자신의 부모 노드를 가리킬 parent 배열을 하나 선언해준다
 * - 먼저 처음에는 각 노드들은 자기자신을 가리키도록 한다
 * - 이어서 command에 따라서 행동을 다르게 한다
 * - 0일 경우 union을 1일 경우 find를 한다
 * - union 메소드는 find를 통해 루트 노드의 값을 가져온 두 값을 비교한다
 * - 만약 같다면 같은 집합이므로 return;으로 그대로 종료하고, 같지 않을 경우 parent[b] = a를 통해 b노드 집합을 a노드 집합에 union한다
 * - find 메소드는 재귀함수로 자신의 부모 노드를 찾는 방식이며, 시간복잡도를 고려하여 자신의 루트 노드만을 가리키도록 압축하는 방식을 하였다.
 * - 만약 parent[a]가 파라미터로 넘어온 int a의 값과 같다면 자기 자신을 가리키는 루트 노드이므로 return a를 해준다
 * - 그렇지 않다면 루트노드가 아니므로 압축방식을 고려하여 parent[a]에 find(parent[a]) 재귀함수 실행 결과를 초기화해준다
 * - 이어서 parent[a]를 리턴한다
 * - 이런방식으로 완성된 유니온-파인드 함수를 통해 문제를 해결한다. 0일때는 단순히 union(a,b)만 해주면 된다
 * - 1일때는 find(a) == find(b)일 경우 두 집합이 같은 집합에 포함되어 있다는 의미이므로 YES를 출력한다
 * - 만약 아닐 경우 두 집합이 같은 집합에 포함되어 있지 않다는 의미이므로 NO를 출력한다
 * 
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(a,b);
            }else{
                if(find(a) == find(b)){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }

        br.close();
        bw.close();
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) {
            return;
        }else{
            parent[b] = a;
        }
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

}

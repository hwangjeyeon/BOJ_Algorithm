import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 최초로 교육 자료를 받는 인원이 최소가 되기 위해서는 하나의 그래프 내의 하나의 정점으로부터 모든 노드를 가도록 설정하면 된다
 * 2. 따라서 최초로 교육 자료를 받는 인원이 최소가 되려면 그래프별로 노드의 개수를 세어주면 된다.
 * 3. 그래프가 여러개라면 그 그래프별로 노드의 수를 곱해주면 된다.
 * 4. 유니온파인드를 이용해서 그래프별로 하나의 부모를 가리키도록 설정해준다.
 * 5  그 다음 Map을 이용하여 개수를 세어주고 map의 값들을 가져와서 count에 곱하고 출력한다.
 * 6. 하지만 map을 이용한 방법은 알 수 없는 이유로 계속 틀렸었다.
 *
 *
 * 해결방법:
 * 1. 새롭게 생각한 방법은 크기 상태를 관리할 배열을 하나 만드는 방법이다
 * 2. 부모 배열을 유니온파인드 할 때, 만약 수가 같지 않다면, size[x]와 size[y]를 비교하여 size[x]가 더 작다면 스왑해서 x가 더 크게 해준다
 * 3. 이어서 parent[y]에 x를 넣는 유니온 작업을 해주고, size[x]에는 size[y]를 더하는 누적 방식으로 크기를 갱신한다
 * 4. 이어서 순회를 하는데 해당 수의 root를 파인드한다
 * 5. 만약 해당 지점을 방문하지 않았다면 count에 해당 size[root]를 곱한 뒤 1000007를 모듈러 연산해준다
 * 6. 완성한 count를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n+m)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(size[x] < size[y]){
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            size[x] += size[y];
        }
    }

    private static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static int[] parent;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        size = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        long count = 1;
        boolean[] counted = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int root = find(i);
            if(!counted[root]){
                count = (count * size[root]) % 1000000007;
                counted[root] = true;
            }
        }

        bw.write(count+"");


        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 힌트를 읽고 여기서 하라는데로 구현하면 된다
 * 2. 처음 연결을 위한 list와 부모자식관계가 완성된 tree 리스트 배열을 하나씩 선언한다
 * 3. size배열을 선언해서 정답을 위한 dp로 가지고 있는다
 * 4. 또한 별도의 노드를 만들지 않고 부모 배열을 하나 만들어서 관리한다
 * 5. makeTree에서는 현재 시작 노드와 부모노드를 하나씩 받는다. 루트노드는 부모로 -1을 받는다
 * 6. 연결된 list의 배열의 수를 순회하면서 부모와 같지 않다면 tree 배열에 넣어주고 부모의 자식 위치에 cur를 넣어준다
 * 7. 이후 i를 cur로 cur를 parent로 넘겨주는 재귀함수를 실행한다
 * 8. countSubtreeNodes에서는 size[cur]를 1로 초기화한다
 * 9. 이어서 tree[cur]를 순회하면서 연결된 정점을 모두 불러와 재귀함수 파라미터로 넘겨주고 이후 size[cur]에 size[i]를 더해준다
 * 10. 위 과정을 각각 실행한 후에 순회를 돌면서 쿼리에 해당하는 size배열의 값을 출력하면 정답이 된다
 * 11. 만약 countSubtreeNodes을 쿼리 순회마다 한다면 시간 초과가 발생하므로 dp 역할을 하도록 해야한다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static List<Integer>[] list, tree;
    static int size[];
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        parent = new int[n+1];
        tree = new List[n + 1];
        size = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        makeTree(r, -1);
        countSubtreeNodes(r);
        for (int i = 0; i < q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            bw.write(size[tmp]+"\n");
        }



        br.close();
        bw.close();
    }

    private static void makeTree(int cur, int parents){
        for (Integer i : list[cur]) {
            if(i != parents){
                tree[cur].add(i);
                parent[i] = cur;
                makeTree(i, cur);
            }
        }
    }

    private static void countSubtreeNodes(int cur){
        size[cur] = 1;
        for (Integer i : tree[cur]) {
            countSubtreeNodes(i);
            size[cur] += size[i];
        }
    }

}


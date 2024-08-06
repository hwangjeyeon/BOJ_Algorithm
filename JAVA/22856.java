import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 출제자의 설명을 듣고 알게된 기발한 풀이로 풀게 되었다
 * 2. 트리의 규칙을 생각했을 때, n개의 노드가 있으면 n-1개의 간선이 있다. 두 노드간 왔다갔다 하는 것을 모든 노드가 했다고 생각했을 때, 2*(n-1)이 된다
 * 3. 이제 거꾸로 생각해보자. 노드간 왕복이 없는 구간은 어느 경우인가? 바로 루트 노드에서 오로지 오른쪽으로만 탐색을 하는 경우다!
 * 4. 따라서 오른쪽으로만 탐색하는 경우의 count를 세어주어서 그만큼 전체 왕복 탐색의 경우에서 빼주면 정답이 된다.
 * 5. 물론 이 문제를 중위 순회를 활용하여 풀 수 있다고도 했다. 따라서 이후 재풀이할 때는 중위순회를 이용하여 풀어볼 계획이다
 *
 * 시간복잡도: O(h(트리의 높이))
 * 공간복잡도: O(n)
 *
 */
class Tree{

    int left;
    int right;

    public Tree(int left, int right) {
        this.left = left;
        this.right = right;
    }
}


public class Main {

    static int ans = 0;
    static int count = 0;
    static Tree[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        trees = new Tree[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trees[a] = new Tree(b, c);
        }
        ans = (n-1)*2;

        searchRight(1);

        bw.write(ans - count + "");
        br.close();
        bw.close();
    }

    private static void searchRight(int cur) {
        if(trees[cur].right != -1){
            searchRight(trees[cur].right);
            count++;
        }
    }


}

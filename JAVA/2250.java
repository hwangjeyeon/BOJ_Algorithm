import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 리트코드 데일리 문제에서 최근 트리 순회관련된 문제가 나와가지고 중위 순회라는 키워드를 빠르게 뽑을 수 있었다
 * 2. 마치 좌표처럼 현재 정점과 연결된 left와 right는 반드시 각각 col이 작거나 커야한다
 * 3. 그렇다면 left부터 최대 깊이로 내려간다음 left -> root -> right 순으로 탐색한다면 문제에서 만족하는 그림이 완성될 것이다
 * 4. static한 row와 col 변수를 선언하고 row는 루트 노드 때문에 1로 초기화하자
 * 5. left와 right가 -1이 아니라면 각각 row를 증가시키고, 중위 순회 재귀를 진행한다
 * 6. left가 -1이라면 리프노드에 도착한 것이므로 이제 col을 증가시키고, 각 행에 대한 정점 정보를 가지고 있는 리스트 배열에 현재 열을 넣어준다
 * 7. right 확인 이후에는 root로 돌아가므로 row를 감소시킨다
 * 8. 이렇게 중위 순회로 완성된 각 행에 대한 정보를 가지고 탐색하며, 각 행에서의 트리의 너비를 구한 뒤, 최대값으로 갱신함과 동시에 현재 높이도 갱신해준다
 * 9. 이후 완성한 높이와 너비를 출력하면 정답이 된다.
 * 10. 다만 한가지 주의할 점이 이 문제에서 루트 노드를 1이라고 고정하지 않았다. '트리의 레벨은 가장 위쪽에 있는 루트 노드가 1이고 아래로 1씩 증가한다.'라는 문구는 레벨에 대한 내용이지 루트 노드에 대한 내용이 아니다
 * 11. 따라서 입력받을 때, 현재 정점에 left와 right가 연결되어 있다면 그 정점의 값을 늘려준 뒤, 만약 정점의 값이 0이라면 그 어떤 부모도 가지고 있지 않다는 것이므로 그것을 루트로 한디.
 * 12. 루트부터 시작해서 앞서 말한 대로 중위 순회를 한다면 정답을 구할 수 있을 것이다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class TreeNode{

    int left;
    int right;

    public TreeNode(int left, int right) {
        this.left = left;
        this.right = right;
    }
}


public class Main {

    static int n;
    static List<TreeNode>[] nodes;
    static int row = 1;
    static int col = 0;
    static List<Integer>[] lists;
    static int level;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        nodes = new List[n+1];
        lists = new List[n+1];

        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
            lists[i] = new ArrayList<>();
        }
        level = 0;
        ans = 0;

        int root = 0;
        int[] count = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(b != -1){
                count[b]++;
            }
            if(c != -1){
                count[c]++;
            }
            nodes[a].add(new TreeNode(b,c));
        }

        for (int i = 1; i < n + 1; i++) {
            if(count[i] == 0){
                root = i;
                break;
            }
        }


        inOrder(root);
        for (int i = 1; i < n + 1; i++) {
            if(!lists[i].isEmpty()){
                int start = lists[i].get(0);
                int end = lists[i].get(lists[i].size()-1);
                int width = end - start + 1;
                if(ans < width){
                    ans = width;
                    level = i;
                }
            }
        }


        bw.write(level + " " + ans);

        br.close();
        bw.close();
    }

    private static void inOrder(int now) {
        for (TreeNode val : nodes[now]) {
            if(val.left != -1){
                row++;
                inOrder(val.left);
            }
            col++;
            lists[row].add(col);
            if(val.right != -1){
                row++;
                inOrder(val.right);
            }
            row--;
        }
    }

}

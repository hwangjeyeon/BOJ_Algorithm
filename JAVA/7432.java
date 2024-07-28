import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 기존 트라이와 조금 다르게 자료구조를 구성한다.
 * 2. 기존에는 문자 단위로 Map에 젖아했다면 이번에는 문자열 단위로 저장한다. 따라서 endOfWord도 필요가 없다
 * 3. split을 해서 tmp에 저장해준다. \을 split하기 위해서는 \\\\을 regex에 넣어줘야한다
 * 4. 나머지는 기존 방식이랑 비슷하게 해서 insert하면 된다
 * 5. 이후 모든 노드를 출력하면 되는데 재귀를 이용해야한다
 * 6. 파라미터로 노드랑 깊이를 받는다. 처음에는 루트랑 0을 인수로 받는다.
 * 7. 파라미터의 노드를 기준으로 자식 노드가 null이 아니라면 로직을 진행한다
 * 8. 해당 노드의 모든 자식 키 값을 가져온 뒤, 오름차순 정렬을 해준다
 * 9. 이어서 순회를 돌면서 깊이만큼 " "을 붙여주고, 해당 문자열을 붙여준다
 * 10. 이후 재귀함수를 실행하여 현재 노드의 자식 문자열과 depth+1을 인수로 넘겨준다
 * 11. 이렇게 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*|S|)
 * 공간복잡도: O(n*|S|)
 *
 */

class Node{

    Map<String, Node> child;

    public Node() {
        this.child = new HashMap<>();
    }
}

class Trie{
    Node root = new Node();

    public void insert(String str){
        Node node = this.root;
        String[] tmp = str.split("\\\\");
        for (String s : tmp) {
            node.child.putIfAbsent(s, new Node());
            node = node.child.get(s);
        }
    }

}


public class Main {


    static Trie trie;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        trie = new Trie();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            trie.insert(s);
        }
        sb = new StringBuilder();
        searchAll(trie.root, 0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void searchAll(Node cur, int depth){
        Node node = cur;
        if(node.child != null){
            List<String> list = new ArrayList<>(node.child.keySet());
            Collections.sort(list);
            for (String s : list) {
                for (int i = 0; i < depth; i++) {
                    sb.append(" ");
                }
                sb.append(s).append("\n");
                searchAll(node.child.get(s), depth+1);
            }
        }
    }
}


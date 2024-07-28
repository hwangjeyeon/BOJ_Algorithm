import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 디스크 트리랑 비슷하게 풀면 되는 문자열 트라이 문제다.
 * 2. 입력만 조금 다르고 디스크 트리랑 똑같은 노드와 트라이 자료구조, 그리고 출력형식까지 똑같다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*k)
 * 공간복잡도: O(logn*k)
 *
 */

class Node {

    Map<String, Node> child;

    public Node(){
        child = new HashMap<>();
    }

}

class Trie{
    Node root = new Node();

    public void insert(String str) {
        Node cur = this.root;
        String[] tmp = str.split(" ");
        for (String s : tmp) {
            cur.child.putIfAbsent(s, new Node());
            cur = cur.child.get(s);
        }
    }

}


public class Main {


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String tmp = "";
            for (int j = 0; j < k; j++) {
                tmp += st.nextToken();
                if(j != k-1){
                    tmp += " ";
                }
            }
            trie.insert(tmp);
        }
        searchAll(trie.root, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void searchAll(Node cur, int depth){
        if(cur.child != null){
            List<String> list = new ArrayList<>(cur.child.keySet());
            Collections.sort(list);
            for (String s : list) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(s).append("\n");
                searchAll(cur.child.get(s), depth+1);
            }
        }
    }

}


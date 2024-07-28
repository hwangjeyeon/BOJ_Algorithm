import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 트라이를 활용하면 정말 쉽게 풀 수 있는 문제다.
 * 2. 기존 트라이에서 search 결과에 따라 마지막 노드의 endOfWord를 보내주는데 그 부분을 true로 보내주고 true일때 count를 세어주도록 변경하면 된다.
 * 3. 접두사를 찾는 것이므로 검색 문자가 포함되어있는지만 확인하면 되므로 true로 리턴하도록 설정해야 한다
 * 4. 이후 count를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(n)
 *
 */

class Node{
    Map<Character, Node> child;
    boolean endOfWord = false;

    public Node() {
        this.child = new HashMap<>();
        this.endOfWord = false;
    }
}

class Trie{
    Node root = new Node();

    public void insert(String str){
        Node node = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
        }
        node.endOfWord = true;
    }


    public boolean search(String str){
        Node node = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(node.child.containsKey(c)){
                node = node.child.get(c);
            }else{
                return false;
            }
        }
        return true;
    }

}



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            trie.insert(s);
        }
        int count = 0;

        for (int i = 0; i < m; i++) {

            String s = br.readLine();
            if(trie.search(s)){
                count++;
            }

        }


        bw.write(count+"");

        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 트라이를 이용하는 문제다.
 * 2. contains라는 새로운 메소드를 하나 만들어 풀었다. search를 살짝 변형하였다
 * 3. 탐색하면서 다음 노드가 있는지 확인하고 없으면 false를 리턴한다
 * 4. 이후 마지막 노드의 endOfWord가 true이면서, 만약 node.child가 isEmpty라면 false를 리턴한다. 이 경우는 자기자신을 찾는 경우이다
 * 5. 위 두가지 경우를 모두 건너뛴다면 true를 리턴한다. 해당하는 수가 있다는 것이다
 * 6. 결과에 따라 만약 있다면 isOk를 false로 바꾸고 만약 false라면 포함하고 있다는 것이므로 NO를 출력하고 아니라면 YES를 출력하면 정답이 된다
 *
 * - 이 문제는 startsWith로도 해결할 수 있다고 해서, 한번 나중에 단순 문자열 검색으로도 풀어볼 계획이다.
 *
 * 시간복잡도: O(T*n*|S|)
 * 공간복잡도: O(n*|S|)
 *
 */

class Node{

    Map<Character, Node> child;
    boolean endOfWord;

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

    public boolean contains(String str){
        Node node = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Node next = node.child.get(c);
            if(next == null){
                return false;
            }
            node = next;
        }

        if(node.endOfWord){
            if(node.child.isEmpty()){
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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                trie.insert(s);
                list.add(s);
            }
            boolean isOk = true;
            for (String s : list) {
                if(trie.contains(s)){
                    isOk = false;
                    break;
                }
            }

            if(!isOk){
                bw.write("NO\n");
            }else{
                bw.write("YES\n");
            }

        }


        br.close();
        bw.close();
    }
}


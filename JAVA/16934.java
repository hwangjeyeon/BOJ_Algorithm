import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 트라이를 이용하는 문제인데 조금 변형해서 풀어야 한다
 * 2. 이번에는 문자열이 아닌 문자를 Map에 저장한다. 한가지 특이한 점은 중복되는 문자열이 들어올 수 있으므로 개수를 세어주어야하는데, 이때 끝 부분을 boolean으로 하던 것을 int타입의 counts 변수로 바꿔준다
 * 3. 또한 트라이 자료구조에서 삽입 메소드를 호출하는 과정에서 문제 해결을 위한 로직을 같이 진행하여 Stirng 타입을 리턴하도록 한다
 * 4. 기존과 같이 진행하나 입력 문자열의 현재 문자가 노드의 자식으로 있는지 검증하고 만약 있다면 해당 자식으로 현재 노드를 교체한 뒤, StingBuilder에 해당 문자를 넣어준다. 접두사를 만들기 위한 과정이다
 * 5. 만약 존재하지 않는 다면, 기존 트라이 자료구조처럼 putIfAbsent(c, new Node())로 넣어주고, 해당 자식 노드로 현재 노드를 교체한다.
 * 6. 앞서 isEnd라는 boolean 변수를 하나 만들었는데, 해당 값이 false라면 StringBuilder에 해당 문자를 추가하고 true로 바꿔준다. 접두사 추가를 마무리 짓기 위함이다
 * 7. 이어서 모든 삽입이 끝난 뒤에 현재 노드의 counts를 확인한다 어느 수에 상관없이 일단 값을 올려주고, 만약 0이면 해당 StringBuilder를 그대로 리턴한다
 * 8. 만약 0이 아니라면 해당 StringBuilder에 counts를 append하여 리턴한다
 * 9. 입력으로 들어오는 문자열을 삽입할때마다 리턴된 결과를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*|S|)
 * 공간복잡도: O(n*|S|)
 *
 */
class Node{
    Map<Character, Node> child;
    int counts;

    public Node(){
        child = new HashMap<>();
        counts = 0;
    }

}

class Trie{
    Node root = new Node();

    public String insert(String str){
        Node cur = this.root;
        StringBuilder sb = new StringBuilder();
        boolean isEnd = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(cur.child.get(c) != null){
                cur = cur.child.get(c);
                sb.append(c);
            }else{
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
                if(!isEnd){
                    sb.append(c);
                    isEnd = true;
                }
            }
        }
        if(cur.counts == 0){
            cur.counts++;
            return sb.toString();
        }else{
            cur.counts++;
            return sb.append(cur.counts).toString();
        }

    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            bw.write(trie.insert(s)+"\n");
        }
        
        br.close();
        bw.close();
    }

}


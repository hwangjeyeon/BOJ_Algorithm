import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전에 Node를 구현해본 덕분에 이번에 더 확실히 이해할 수 있었고, 쉽게 완성할 수 있었다.
 * - 첫번째 노드만 while문 밖에서 new Node로 객체를 생성해준다
 * - 이후 노드는 while문 안에서 add로 추가해준다
 * - 이어서 while문 종료후에 후위 순회인 postOrder를 실행한다
 * - 완성된 StringBuilder를 출력해준다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void add(int value){
        if(value < this.value){
            if(this.left == null){
                left = new Node(value);
            }else{
                this.left.add(value);
            }
        }else if(value > this.value){
            if(this.right == null){
                right = new Node(value);
            }else{
                this.right.add(value);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}


public class Main {
    static Node tree;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        sb = new StringBuilder();

        tree = new Node(Integer.parseInt(br.readLine()));
        while((str = br.readLine()) != null){
            tree.add(Integer.parseInt(str));
        }
        postOrder(tree);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        sb.append(node.getValue()).append("\n");
    }

}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 트리에 대해 공부 후, 힌트를 참고하여 풀었습니다.
 * - 이후 문제는 힌트를 최소화하여 풀 계획입니다
 * - 트리 문제는 Node 클래스를 만들어야한다.
 * - 이 문제를 봤을 때, 현재 트리의 value와 내 left, right의 Node를 연결해야한다
 * - 일단 해당 클래스를 생성할 때, value를 받아 생성하고 left, right Node는 null로 초기화한다
 * - Node 배열을 만들어 관리해준다. 맨 꼭대기부터 왼쪽 오른쪽 순으로 만들어준다.
 * - 입력받은 n만큼 순회하여, 부모노드가 없는 경우 생성해서 배열에 넣어준다
 * - 이어서 left 노드가 '.'이 아니면 해당 left노드를 생성해서 배열에 저장하고 부모 노드의 left 노드를 해당 노드로 설정한다
 * - right도 left와 똑같이 진행한다
 * - 전위,중위,후위 순회 메소드를 구현한다
 * - Node를 파라미터로 받고 해당 node가 null일때 함수를 종료시킨다
 * - 재귀함수를 통해 left와 right를 각각 함수로 보내는데, 전위 중위 후위 차이는 다음과 같다.
 * - 먼저 StringBuilder에 값을 append하고 left, right 재귀함수 실행 - 전위
 * - left 재귀함수를 먼저 실행하고 StringBuilder에 값을 append한뒤, right 재귀함수 실행 - 중위
 * - 먼저 left, right 재귀함수 실행하고 StringBuilder에 값을 append한다 - 후위
 * - 이렇게 완성된 값을 저장하여 최종 출력하면 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


class Node{
    private char value;
    private Node left;
    private Node right;
    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
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
    static StringBuilder sb;

    static void preOrder(Node node){
        if(node == null){
            return;
        }
        sb.append(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.getLeft());
        sb.append(node.getValue());
        inOrder(node.getRight());
    }
    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        sb.append(node.getValue());
    }


    static Node[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        trees = new Node[n+1];
        sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // JAVA에서 char데이터 타입은 내부적으로 ASCII 코드 사용
            //루트 노드가 없으면
            if(trees[root - 'A'] == null){
                trees[root - 'A'] = new Node(root);
            }
            if(left != '.'){
                trees[left-'A'] = new Node(left);
                trees[root-'A'].setLeft(trees[left-'A']);
            }
            if(right != '.'){
                trees[right-'A'] = new Node(right);
                trees[root-'A'].setRight(trees[right-'A']);
            }
        }

        preOrder(trees[0]);
        sb.append("\n");
        inOrder(trees[0]);
        sb.append("\n");
        postOrder(trees[0]);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }


}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 먼저 구분을 위해 티켓을 alpha와 number로 구분된 Pair 클래스로 선언한다
 * 2. 입장 대기줄은 큐로 선언하며, 대기줄과 입장한 후의 상태는 스택으로 관리한다
 * 3. 큐랑 대기줄이 모두 빌떄까지 순회한다
 * 4. 큐에서 하나를 꺼내서 이제 다음 작업을 진행한다
 * 5. 먼저 입장한 후의 스택이 비어있지 않다면 순서에 맞게 잘 진행되고 있는지 체크한다. 만약 순서에 맞지 않다면 바로 break하고 ans를 바꿔 출력한다
 * 6. 이어서 대기줄의 값과 큐에서 뽑은 값을 비교한다. 큐의 값이 더 순서가 빠를때까지 대기줄에서 값을 뽑아 입장한 후의 스택에 넣는다. 이때 앞선 비교처럼 순서에 맞는지 체크해준다
 * 7. 이제 큐의 뒤가 비어있지 않다면 뒤와 비교한다. 뒤의 값보다 순서가 느리다면 현재 값은 대기 줄에 넣어준다
 * 8. 이 모든 조건을 지나친 경우에는 뽑은 큐의 값을 입장 후 스택에 넣어준다.
 *
 * 9. 위 풀이는 틀린 풀이..
 *
 * - 문제 해결:
 * 1. 미리순서를 정해놓으면 쉽게 풀 수 있다. 이를 위해 우선순위 큐를 활용해서 미리 순서를 정렬해두고 비교하는 방식으로 문제를 해결하면 된다
 * 2. 우선순위 큐가 빌떄까지 순회를 진행한다. 만약 큐가 비어있지 않으면서 큐의 꼭대기와 우선순위 큐의 꼭대기가 같다면 큐와 우선순위 둘다 빼준다
 * 3. 아니라면 스택이 비어있지 않으면서 스택의 꼭대기와 우선순위 큐의 꼭대기가 같은지 확인한다. 같다면 스택과 우선순위 큐 둘다 빼준다
 * 4. 둘다 아니라면 이제 큐가 비어있는지 확인하고 만약 비어있지 않다면 스택에 큐를 넣어준다. 만약 비어있다면 ans를 BAD로 바꾸고 탈출해서 정답을 출력하면 된다
 *
 * 시간복잡도: O(5*n)
 * 공간복잡도: O(5*n)
 *
 */

class Pair{

    String alpha;
    int number;

    public Pair(String alpha, int number) {
        this.alpha = alpha;
        this.number = number;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Pair> q = new LinkedList<>();
        Stack<Pair> wait = new Stack<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.alpha.compareTo(o2.alpha) == 0){
                return o1.number - o2.number;
            }
            return o1.alpha.compareTo(o2.alpha);
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                String[] input = st.nextToken().split("-");
                Pair pair = new Pair(input[0], Integer.parseInt(input[1]));
                q.add(pair);
                pq.add(pair);
            }
        }
        String ans = "GOOD";

        while(!pq.isEmpty()){
            if(!q.isEmpty() && pq.peek() == q.peek()){
                q.poll();
                pq.poll();
            }else if(!wait.isEmpty() && wait.peek() == pq.peek()){
                wait.pop();
                pq.poll();
            }else{
                if(!q.isEmpty()){
                    wait.push(q.poll());
                }else{
                    ans = "BAD";
                    break;
                }
            }
        }


        bw.write(ans);

        br.close();
        bw.close();
    }
}


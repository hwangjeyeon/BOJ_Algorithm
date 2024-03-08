import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 단순 들어온 숫자대로 가운데 수를 정렬하나 생각했는데, 예제를 확인하니 숫자 크기대로 정렬했을 때의 가운데값을 말하는 것이었다
 * 2. 따라서 큐가 아니라 우선순위 큐를 사용해야한다
 * 3. 시간제한때문에 우선순위 큐를 두개 사용해야겠다고 생각했다.
 *
 * - 문제 해결:
 * 1. 여기서부터 힌트를 참고했다. 우선순위큐를 두개 확인하는데 하나는 왼쪽에 하나는 오른쪽에 넣는다고 생각하자
 * 2. 하나는 내림차순 정렬되어있고 하나는 오름차순 정렬이다.
 * 3. 우선순위 큐에서 내림차순 정렬된 것의 꼭대기를 출력하면 가운데 값이 된다
 * 4. 순회하면서 입력 값을 받는다. 이때, 둘의 크기가 같으면 내림차순 정렬된 것에 아니면 오름차순 정렬된 것에 넣는다. 왜냐하면 처음 들어왔을 때, 출력을 위해서 이다.
 * 5. 이어서 두 우선순위큐 모두 비어있지 않으면 한가지 검사를 해야한다. 만약 내림차순 정렬된 큐에서 peek값이 오름차순 정렬된 큐의 peek값보다 클 경우이다.
 * 6. 둘을 검사해서 스왑하는데 이유는 내림차순 정렬된 값의 peek값을 출력해야하고, 두 수중에서 작은 수를 말해야하기 때문이다
 * 7. 또한 왼쪽은 작은 수들을 오른쪽은 큰수들을 정렬해둔 큐이므로, 순서가 꼬이지 않게 하기 위해서 스왑을 진행한다.
 * 8. 해당 검사 종료 후, 왼쪽 내림차순 정렬된 우선순위 큐의 peek값을 출력하면 정답이 된다.
 * 
 * - 우선순위 큐 두개를 사용하는 것까지는 유추해냈으나 그 이후를 유추해내지 못했다. 
 * - 연습 문제를 더 풀어보면서 유형을 익히고, 활용 실력을 더 키울 계획이다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(pq.size() == qp.size()){
                pq.add(input);
            }else{
                qp.add(input);
            }
            if(!pq.isEmpty() && ! qp.isEmpty()){
                if(pq.peek() > qp.peek()){
                    int tmp = pq.poll();
                    pq.add(qp.poll());
                    qp.add(tmp);
                }
            }

            bw.write(pq.peek()+"\n");
        }


        br.close();
        bw.close();
    }

}


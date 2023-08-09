import java.io.*;
import java.util.*;

/**
 * 풀이 방법: 우선순위 큐를 사용하여 풀었습니다
 * 접근 방법: 주어진 문제를 보고 먼저 큐를 사용해야하며, 내림차순 정렬을 해야하니 우선순위 큐를 사용하고 Collections.reverseOrder()로 정렬해야겠다고 생각했습니다
 * 변수 선언:
 * PriorityQueue<Integer> ans = 우선순위 큐 -> Collections.reverseOrder() -> 내림차순 정렬해서 받게 초기화 해준다
 * int N = 입력 받을 수의 개수
 * int x = 입력 받을 원소 값
 * 풀이 과정:
 * 1. 큐에 들어갈 값을 입력받습니다
 * 2. 해당 값이 0이면 큐가 비어있는지 확인하고 비어있으면 0을 출력하며, 비어있지 않으면 poll해서 큐의 맨 앞 값을 출력하고 제거합니다
 * 3. 0이 아니면 큐에 값을 추가합니다
 *
 * 맺음말:
 * Collections.reverseOrder() -> 이거 하나 빼고 최소 힙이랑 똑같습니다.
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> ans = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(ans.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(ans.poll()+"\n");
                }
            }else{
                ans.add(x);

            }

        }
        br.close();
        bw.close();

    }
}

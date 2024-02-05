import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 우선순위 큐를 이용하여 풀었다.
 * - 우선순위 큐의 규칙을 내림차순으로 설정하였다.
 * - 첫 입력인 1번 후보만 따로 변수로 빼고 나머지를 우선순위 큐에 넣는다
 * - 이어서 우선순위 큐가 비어있지 않다면 순회를 진행하는데 만약 큐의 맨 앞이 1번 후보보다 크거나 같으면 정답과 1번 후보 숫자를 늘려준다
 * - 이어서 우선순위 큐에 현재 우선순위 큐의 맨 앞 숫자에 1을 뺀 값을 추가하고 맨앞 숫자는 빼준다
 * - 만약 작다면 우선순위 큐의 맨 앞 숫자는 그냥 빼준다
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());
        int me = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            candidate.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;

        while(!candidate.isEmpty()){
            if(candidate.peek() >= me){
                ans++;
                me++;
                candidate.add(candidate.poll() - 1);
            }else{
                candidate.poll();
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}

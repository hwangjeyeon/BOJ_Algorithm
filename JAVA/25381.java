import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. A와 B의 인덱스를 담을 큐를 각각 생성한다
 * 2. 문자열을 순회하면서 A와 B면 각각의 큐에 담는다. 
 * 3. 만약 C이면 현재 인덱스보다 앞에 있는 B 인덱스가 있는 경우 ans를 증가시키고 B큐에서 poll한다
 * 4. 이렇게 해서 C의 경우를 제일 먼저 처리해준다. A와 B는 각각 뒤에 어떤 문자열이 오는 경우가 있지만 C의 경우에는 뒤에 어떠한 문자열도 오지 않아 제일 껄끄러워서 먼저 처리한다
 * 5. 이제 C와 앞에 있는 B가 모두 빠지고 나서는 A뒤에 B가 오는 경우를 뺴줘야 한다
 * 6. A와 B가 비지 않는 동안 순회를 반복한다
 * 7. 만약 A인덱스가 B 인덱스보다 작으면 두 큐 모두 poll하고 ans를 증가시킨다
 * 8. 만약 A인덱스가 작지 않으면 B큐만 poll한다. 이 조건을 기준으로 종료한다고 처음 생각했는데, A보다 앞선 B인덱스가 빠지고 나면 A 뒤에 있는 B인덱스가 큐에 들어있는 경우도 있기 때문에 B만 빼주고 어느 한쪽이 비거나 둘다 빌떄까지 반복한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(input.length)
 * 공간복잡도: O(input.length)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Queue<Integer> qA = new LinkedList<>();
        Queue<Integer> qB = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("A")){
                qA.add(i);
            }else if(input[i].equals("B")){
                qB.add(i);
            }else{
                if(!qB.isEmpty() && qB.peek() < i){
                    ans++;
                    qB.poll();
                }
            }
        }

        while(!qA.isEmpty() && !qB.isEmpty()){
            if(qA.peek() < qB.peek()){
                ans++;
                qA.poll();
                qB.poll();
            }else{
                qB.poll();
            }

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


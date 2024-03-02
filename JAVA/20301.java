import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. int형으로 해도 문제없는 입력 최대값이다.
 * 2. 먼저 배열에 1번부터 n까지 넣어준다
 * 3. int now라는 변수로 위치 포인터를 설정한다
 * 4. now에는 k를 더해주는데 만약 now가 n보다 커지면 n을 빼준다
 * 5. k를 위해서 count 변수를 하나 선언해준다
 * 6. count 변수가 m과 같아지면 isRight = !isRight를 한다. 그리고 count를 다시 0으로 초기화한다.
 * 7. 4번을 isRight가 true면 해주고 아닐 경우 now에서 k를 빼주는데 만약 1보다 작아지면 n을 더해준다.
 * 8. 위 진행 상황에서 now에 해당하는 배열의 값을 Queue에 넣어준다.
 * => 틀린 풀이
 * 
 * 1. 덱을 사용해서 문제를 해결하였다.
 * 2. 빼는 방향을 돌려가면서 뺀다? 여기서 큰 힌트를 얻었던 것 같다. 이전에 풀었던 어떤 문제(기억은 안남)와 유사했는데 그 문제도 덱으로 앞뒤 돌려가며 빼고 넣고 했던 기억이 나서 덱으로 풀었다.
 * 3. 플래그 변수 하나로 count가 m에 도달하면 방향을 바꿔주고 정방향일 때는 앞에 있는 것을 뒤로, 역방향일 떄는 뒤에 있는 것을 앞으로 넣어줬다
 * 4. now라는 변수로 k-1개까지는 3번을 진행하고 k번째에는 큐에다 넣도록 하였다. 위 순회는 큐가 n과 같아질 때까지 계속된다
 * 5. 완성한 큐를 순회하여 출력하면 정답이 된다.
 * 
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> de = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            de.addLast(i);
        }
        boolean isRight = true;
        int now = 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        while(q.size() < n){
            if(isRight){
               while(now < k-1){
                   de.addLast(de.pollFirst());
                   now++;
               }
               q.add(de.pollFirst());
               now = 0;
            }else{
                while(now < k-1){
                    de.addFirst(de.pollLast());
                    now++;
                }
                q.add(de.pollLast());
                now = 0;
            }
            count++;
            if(count == m){
                isRight = !isRight;
                count = 0;
            }
        }


        for (Integer i : q) {
            bw.write(i+" ");
        }

        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. 내림차순 정렬된 우선순위 큐를 활용해서 푸는 문제다.
 * 2. 0이면 우선순위큐가 비어있는지 확인하고 비어있으면 -1, 아니면 poll()해서 출력한다
 * 3. 0이 아닐 경우 첫번째 입력값 크기만큼 우선순위 큐에 추가한다.
 * 
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*a)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0")){
                if(pq.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(pq.poll()+"\n");
                }
            }else{
                for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                    pq.add(Integer.parseInt(input[j+1]));
                }
            }
        }


        br.close();
        bw.close();
    }

}


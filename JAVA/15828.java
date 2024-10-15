import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 큐를 쓰면 되는 쉬운 문제다
 * 2. 크기가 n보다 작으면 넣어주고, 0일 경우에는 poll한다. -1이면 무한루프를 탈출한다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(정보의 수)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        while(true){
            int packet = Integer.parseInt(br.readLine());
            if(packet == -1){
                break;
            }
            if(packet == 0){
                q.poll();
                continue;
            }


            if(q.size() < n){
                q.add(packet);
            }



        }

        for (Integer i : q) {
            bw.write(i + " ");
        }

        br.close();
        bw.close();
    }
}


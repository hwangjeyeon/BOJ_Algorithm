import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 덱을 이용하여 풀었다.
 * 2. 입력은 큐처럼 받기 위해 addLast를 이용해서 덱에 입력값을 넣는다
 * 3. 덱의 크기가 1보다 큰 동안에 반복하는데, 먼저 맨 앞값을 뺴준다.
 * 4. 이어서 다시 체크를해준다 만약 덱의 크기가 1보다 크면 break한다.
 * 5. 4번이 아니면 pollFirst로 맨 앞값을 가져와서 맨 뒤인 addLast에 넣어준다
 * 6. 위 순회가 종료된 후에 덱에 남아있는 값을 가져와서 출력한다.
 *
 *
 * - 문제 해결:
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
        Deque<Integer> de = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            de.addLast(i+1);
        }

        while(de.size() > 1){
            de.pollFirst();
            if(de.size() == 1){
                break;
            }
            de.addLast(de.pollFirst());
        }
        bw.write(de.getLast()+"");

        br.close();
        bw.close();
    }

}


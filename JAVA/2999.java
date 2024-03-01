import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 먼저 R이 가장 큰 값을 구해야 한다.
 * 2. 반복문으로 1부터 R의 크기만큼 순회했을 때, 나머지가 0인 경우 R값에 넣어준다. 이때 Math.max로 더 큰 값을 넣어주도록 한다.
 * 3. 이제 주어진 R값을 활용하여 해독 문자를 가져온다. 이중 포문을 사용해서 풀자
 * 4. R만큼 순회하는 동안 input.length/R만큼 순회하여 i+(R*j)에 해당하는 문자를 가져오자.
 * 5. 3~4번 과정에서 만들어진 StringBuilder 문자를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int R = 1;
        int tmp = 2;
        while(tmp <= input.length()){
            if(input.length() % tmp == 0 && tmp <= input.length() / tmp){
                R = Math.max(R, tmp);
            }
            tmp++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < input.length() / R; j++) {
                sb.append(input.charAt(i + (R * j)));
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}


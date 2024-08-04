import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 비트마스킹을 활용하고 주어진대로 구현하면 된다
 * 2. x의 길이를 줄여나가자. x가 0보다 큰동안 반복하면서 다음을 검사한다
 * 3. 만약 line이 x보다 크다면 line을 오른쪽으로 비트 이동시킨다
 * 4. 아니라면 x에 line만큼 빼주고 count를 증가시킨다
 * 5. count 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        int line = 64;
        int count = 0;
        while(x > 0){
            if(line > x){
                line = line >> 1;
            }else{
                x -= line;
                count++;
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();

    }

}

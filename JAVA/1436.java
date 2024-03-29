import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 666부터 시작해서 값을 1씩 증가시키면서 값을 비교한다
 * 2. 각 숫자를 문자로 바꾸고 문자열 길이-2만큼 순회하면서 해당 문자열이 "666"을 가지고 있는지 확인한다
 * 3. 가지고 있으면 count++해주고 break한다. 이것을 count가 n보다 작을 때 동안 반복한다
 * 4. 완성한 tmp를 출력하면 정답이 된다.
 *
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int tmp = 666;
        while(count < n){
            tmp++;
            String s = String.valueOf(tmp);

            for (int i = 0; i < s.length()-2; i++) {

                if(s.contains("666")){
                    count++;
                    break;
                }
            }
        }
        bw.write(tmp+"");

        br.close();
        bw.close();
    }

}

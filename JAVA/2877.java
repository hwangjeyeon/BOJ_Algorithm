import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 아이디어 문제다. 주어진 k에다가 1을 더한다음 그 수를 비트로 바꿔서 문자열로 저장한다. 이때 Integer.toBinaryString을 사용한다
 * 2. 맨 앞을 제외한 두번째 수부터 순회하며 1이면 StringBuilder에 7을 저장하고 0이면 4를 저장한다
 * 3. 이 완성한 문자열을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(|K|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String k = Integer.toBinaryString(Integer.parseInt(br.readLine())+1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < k.length(); i++) {
            if(k.charAt(i) == '1'){
                sb.append("7");
            }else{
                sb.append("4");
            }
        }

        bw.write(sb.toString());


        br.close();
        bw.close();
    }

}


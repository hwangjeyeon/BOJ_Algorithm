import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 1번 3번 인덱스의 값이 둘다 0이면 탈출한다
 * 2. 아닐경우 로직을 실행한다. R과 C의 인덱스 위치를 찾아준다
 * 3. 먼저 C 이후의 값을 확인한다. 그 값을 alpha에 int형으로 파싱해서 넣어준다
 * 4. alpha가 0보다 클동안 시작이 1이므로 1감소시키고, (char) ('A' + alpha%26)으로 StringBuilder에 넣어준다
 * 5. 그리고 alpha/=26으로 갱신해준다
 * 6. 앞에서부터 들어가야할 값이 뒤에서부터 들어갔으니 sb를 reverse해주고, 다음 R과 C사이의 수를 가져온다
 * 7. 이 값은 그냥 넣으면 되므로 StringBuilder에 넣고 최종 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(alpha)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String s = br.readLine();
            if(s.charAt(1) == '0' && s.charAt(3) == '0'){
                break;
            }
            int rIndex = 0;
            int cIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'C'){
                    cIndex = i;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            int alpha = Integer.parseInt(s.substring(cIndex+1));
            while(alpha > 0){
                alpha--;
                sb.append((char) ('A' + alpha%26));
                alpha /= 26;
            }
            sb.reverse();

            sb.append(s.substring(rIndex+1, cIndex));
            bw.write(sb.toString()+"\n");
        }

        br.close();
        bw.close();
    }
}

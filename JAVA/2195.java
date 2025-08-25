import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. p를 각 부분 문자열로 나눴을 때, s에 가장 많이 포함되도록 하면 됩니다
 * 2. 이를 위해 p의 첫번째 문자부터 차례대로 확인하면서 s에 포함되어있는 최대 부분문자열까지 잘라내면 됩니다
 * 3. 이렇게 하며 ans를 증가시켜주고 idx를 현재 i로 갱신하면됩니다
 * 4. 이를 위해 먼저 s가 p의 idx부터 i+1까지 포함되는지 확인하고 포함된다면 continue해주면 됩니다
 * 5. 완성한 ans를 출력하면 정답이 됩니다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|p|)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String p = br.readLine();

        int idx = 0;
        int ans = 0;
        for (int i = 0; i < p.length(); i++) {
            if(s.contains(p.substring(idx, i + 1))){
                continue;
            }
            ans++;
            idx = i;
        }
        bw.write((ans + 1) + "");

        br.close();
        bw.close();
    }

}

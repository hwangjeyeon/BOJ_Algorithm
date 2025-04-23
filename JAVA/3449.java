import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 해밍 거리는 두 개의 길이가 같은 문자열 사이의 거리입니다
 * 2. 즉, 몇개의 문자를 바꿔야 두 문자열이 같아지는지 구하는 것으로 서로 다른 문자의 개수를 세어주고 형식에 맞춰 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|s|)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String a = br.readLine();
            String b = br.readLine();
            int ans = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    ans++;
                }
            }
            bw.write("Hamming distance is " + ans + ".\n");
        }
        
        br.close();
        bw.close();

    }
}



import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 두 문자열이 길이가 같으면 0, 다르면 각 자리수가 다른 경우 break, 아닌 경우 ans++해서 출력하면 정답이 된다.
 *
 * 시간복잡도: O(l.length())
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        int ans = 0;

        if(l.length() == r.length()){
            for (int i = 0; i < l.length(); i++) {
                if(l.charAt(i) != r.charAt(i)){
                    break;
                }

                if(l.charAt(i) == '8'){
                    ans++;
                }
            }
        }



        bw.write(ans+"");
        br.close();
        bw.close();
    }
}


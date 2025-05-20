import java.io.*;

import java.util.*;

/**
 * 풀이 과정:
 * 1. s1에 s2가 포함되는지 확인하고 그에따라 ans를 출력하면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String ans = "no";
        if(s1.contains(s2)){
            ans = "go";
        }
        bw.write(ans);

        br.close();
        bw.close();

    }

}
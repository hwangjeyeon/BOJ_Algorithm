import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 알파벳 배열 만든뒤 문자열 위치의 해당하는 값을 증가시킨다
 * 2. 배열 크기만큼 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpha = new int[26];
        char[] s = br.readLine().toCharArray();
        for (int i = 0; i < s.length; i++) {
            alpha[s[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            bw.write(alpha[i] + " ");
        }



        br.close();
        bw.close();
    }
}


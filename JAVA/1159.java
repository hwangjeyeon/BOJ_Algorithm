import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 알파벳 배열 쓰면 되는 쉬운 문제다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = new char[26];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            a[s.charAt(0)-'a']++;
        }

        boolean isOk = false;
        for (int i = 0; i < 26; i++) {
            if(a[i] >=5){
                isOk = true;
                bw.write((char)(i+'a')+"");
            }
        }

        if(!isOk){
            bw.write("PREDAJA");
        }

        br.close();
        bw.close();

    }
}

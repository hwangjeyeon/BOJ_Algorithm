import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - StringBuilder와 reverse()메소드를 사용하여 풀었습니다.
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String palindrome = br.readLine();
        StringBuilder sb = new StringBuilder(palindrome);
        String chk = sb.reverse().toString();
        if(chk.equals(palindrome)){
            bw.write(1 +"");
        }else{
            bw.write(0+"");
        }

        br.close();
        bw.close();
    }

}

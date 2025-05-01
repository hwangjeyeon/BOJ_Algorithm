import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단하게 모음 세면 되는 문제다
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
        while(true){
            String s = br.readLine().toLowerCase();
            if(s.equals("#")){
                break;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                    count++;
                }
            }

            bw.write(count+"\n");
        }

        br.close();
        bw.close();
    }
}

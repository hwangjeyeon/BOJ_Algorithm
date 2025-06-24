import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
           String s = br.readLine();
           bw.write(s.toLowerCase()+"\n");
        }


        br.close();
        bw.close();
    }

}
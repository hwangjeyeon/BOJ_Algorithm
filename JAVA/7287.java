import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 단순 출력문제
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==0){
            bw.write("YONSEI");
        }else{
            bw.write("Leading the Way to the Future");
        }

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그냥 출력하면 정답이다
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
            bw.write( (i+1) + ". " + br.readLine() + "\n");
        }
        

        br.close();
        bw.close();
    }

}
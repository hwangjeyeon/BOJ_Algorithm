import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 단순히 합산한 후에 출력하면 정답이 된다
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
        int sum = 0;
        for(int i=0; i<5; i++){
          sum += Integer.parseInt(br.readLine());
        }
        bw.write(sum+"");
        
        br.close();
        bw.close();

    }

}
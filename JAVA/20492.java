import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 주어진 수식에 맞춰서 결과를 출력하면 정답이 된다
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
        int n = Integer.parseInt(br.readLine());
        bw.write((int)(n*0.78) + " " + (int)(n*0.8 + (n*0.2)*0.78));
        
        br.close();
        bw.close();
    }

}

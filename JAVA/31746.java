import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 홀수와 짝수 구분해서 다르게 출력하면 된다.
 *
 * - 문제 해결:
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
        int n = Integer.parseInt(br.readLine());

        if(n%2 == 1){
            bw.write("evoLmoCicS");
        }else{
            bw.write("SciComLove");
        }

        br.close();
        bw.close();
    }
}


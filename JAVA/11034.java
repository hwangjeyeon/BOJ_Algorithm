import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 수학적으로 사고하면 된다. a,b,c가 있다면 b-a와 c-b중 그 차이가 더 큰 값에서 1을 빼주면 정답이 된다.
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

        String input = "";
        while((input = br.readLine()) != null){
            String[] tmp = input.split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            bw.write(Math.max(b-a, c-b)-1+"\n");

        }

        br.close();
        bw.close();
    }

}


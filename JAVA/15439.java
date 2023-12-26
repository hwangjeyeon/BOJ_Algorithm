import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 같아도 되고 달라도 되면 n*n개가 나오지만 다른 조합인 경우 자신을 고르는 경우를 제외한 n*(n-1)개가 나오게된다
 * - 따라서 정답인 n*(n-1)을 출력하면 된다.
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

        bw.write(n*(n-1)+"");

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 첫 출력값은 가지고 간 뒤 남은 양으로 b-a이며, 두번째 출력값은 b를 그냥 출력하면 정답이 된다.
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write((b-a) + " " + b);


        br.close();
        bw.close();
    }
}


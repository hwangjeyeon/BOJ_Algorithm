import java.io.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 해석하고 A를 출력하면 정답이다
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
        int y = Integer.parseInt(br.readLine());
        bw.write("A");

        br.close();
        bw.close();
    }
}


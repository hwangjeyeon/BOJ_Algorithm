import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 기초 출력문제
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
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(":fan::fan::fan:\n:fan::").append(s).append("::fan:\n:fan::fan::fan:");
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}

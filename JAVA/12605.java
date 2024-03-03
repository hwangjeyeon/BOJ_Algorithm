import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. " "을 기준으로 split하여 입력값을 String[] 배열에 넣는다
 * 2. 스택에 값들을 넣어주고 주어진 양식에 맞춰서 스택에서 값을 꺼내서 출력하면 정답이다
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                stack.push(input[j]);
            }
            bw.write("Case #" + (i+1) + ": ");
            for (int j = 0; j < input.length; j++) {
                bw.write(stack.pop() +" ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

}


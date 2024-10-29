import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 두가지 선택지를 백트래킹 하는 방법을 선택했다. 백트래킹 하면서 두 선택지에 대해 문자를 추가하는 방식이었다
 * 2. 하지만 이 방식은 시간 복잡도 초과를 발생시킨다. 따라서 다른 방법을 선택해야 한다
 * 3. 이번에는 반대로 문자를 지우는 방식을 선택했다. T 문자에서 S 문자로 문자를 지우면서 백트래킹하는것이다
 * 4. 두 길이가 같아지면 종료하는데, 이때 두 문자열이 같으면 정답 변수를 1로 한다
 * 5. 이어서 맨 뒤가 A인 경우와 맨 앞이 B인 경우를 고려하여 백트래킹을 진행한다
 * 6. A인 경우는 substring으로 맨 뒤값 하나 빼고서 백트래킹으로 넘겨준다
 * 7. B인 경우는 맨 앞을 뺀 1번 인덱스부터 substring해서 백트래킹으로 넘겨준다.
 * 8. 이때 B는 넘길때, reverse해서 넘겨주어야 하므로 StringBuilder를 사용하여 reverse하여 넘겨준다
 * 9. 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(|T|-|S|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();
        backtracking(s, t);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(String s, String t) {
        if(s.length() == t.length()){
            if(s.equals(t)){
                ans = 1;
            }
            return;
        }
        if(t.charAt(t.length()-1) == 'A'){
            backtracking(s, t.substring(0, t.length()-1));
        }

        if(t.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(t.substring(1));
            backtracking(s, sb.reverse().toString());
        }

    }
}


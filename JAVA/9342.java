import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이걸 어떻게 구현하지 고민하다가 다시 보니까 이 문제는 정규표현식이었다
 * 2. 정규 표현식 패턴을 미리 정해놓고 이에 맞으면 Infected!를 출력하고 아니면 Good를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(t)
 * 공간복잡도: O(1)
 *
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String pattern = "[A-F]?A+F+C+[A-F]?";

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if(s.matches(pattern)){
                bw.write("Infected!\n");
            }else{
                bw.write("Good\n");
            }

        }


        br.close();
        bw.close();
    }
}


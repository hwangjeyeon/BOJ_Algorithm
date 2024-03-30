import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. 처음에는 문자열 구현을 하려고 했으나 너무 복잡해서 힌트를 참고해서 정규표현식으로 풀었다
 * 2. 다음에 풀때는 문자열 구현도 한번 완성해보자!
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String pattern = "^(100+1+|01)+$";

        boolean isAns = input.matches(pattern);

        if(isAns){
            bw.write("SUBMARINE");
        }else{
            bw.write("NOISE");
        }


        br.close();
        bw.close();
    }

}

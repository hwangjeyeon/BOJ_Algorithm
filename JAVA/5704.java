import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력범위를 a~z로 제한하고, Set에다가 범위안에 있는 문자라면 넣어준다
 * 2. Set의 크기가 26이 아니면 N, 맞으면 Y를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T*|S|)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s = br.readLine();
            Set<Character> set = new HashSet<>();
            if(s.equals("*")){
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    set.add(s.charAt(i));
                }
            }

            if(set.size() != 26){
                bw.write("N\n");
            }else{
                bw.write("Y\n");
            }

        }
        
        br.close();
        bw.close();
    }
}


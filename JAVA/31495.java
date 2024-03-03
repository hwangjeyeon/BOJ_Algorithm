import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if(!input[i].equals("\"")){
                stack.push(input[i]);
            }
        }

        if(!(input[0].equals("\"") && input[input.length-1].equals("\"")) || stack.isEmpty()){

            bw.write("CE");
        }else{
            for (String s : stack) {
                bw.write(s);
            }
        }

        br.close();
        bw.close();
    }

}


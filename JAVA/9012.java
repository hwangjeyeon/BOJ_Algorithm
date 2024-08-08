import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 스택을 활용하는 괄호 문제다
 * 2. (면 스택에 넣고 )이면 빼준다
 * 3. 이때 )인데 스택이 비어있거나 스택의 꼭대기가 (가 아니면 스택에 )를 넣고 break한다
 * 4. 스택이 비어있으면 YES 아니면 NO를 하면 정답이 된다.
 * 
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(T*|input|)
 * 공간복잡도: O(|input|)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (input[j] == '(') {
                    stack.add(input[j]);
                }else{
                    if(stack.isEmpty() || stack.peek() != '('){
                        stack.push(input[j]);
                        break;
                    }
                    stack.pop();
                }

            }

            if(stack.isEmpty()){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }


        br.close();
        bw.close();
    }

}

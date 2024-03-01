import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 만약 현재 문자열 값이 '('면 스택에 넣는다
 * 2. 만약 현재 문자열 값이 ')'면 검증을 해야한다
 * 3. 2번일때, 스택이 비어있거나 스택의 꼭대기값이 '('가 아니라면 ans의 값을 1 증가시킨다.
 * 4. 만약 3번이 아니고 '('이라면 스택을 pop해준다.
 * 5. 위 과정에서 pop되지 않은 찌꺼기가 남아있을 수 있다. 이 찌꺼기들은 괄호식을 만족하지 못하기에 스택의 사이즈 만큼을 정답에 더해준다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("(")){
                stack.push(input[i]);
            }else if(input[i].equals(")")){
                if(stack.isEmpty() || !stack.peek().equals("(")){
                    ans++;
                }else if(stack.peek().equals("(")){
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            ans += stack.size();
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }

}


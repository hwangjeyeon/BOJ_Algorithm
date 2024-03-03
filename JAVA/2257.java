import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 현재 값이 문자열이면 H,C,O에 해당하는 숫자로 스택에 넣는다
 * 2. 숫자면 스택에 있는 값을 pop해서 곱한 뒤에 다시 넣어둔다
 * 3. 현재 값이 (이면 0으로 스택에 넣는다.
 * 4. 현재 값이 )이면 int tmp =0;을 선언해준다. 여는 괄호는 0이므로 스택의 peek가 0일때 pop해주고 tmp를 스택에 넣어준뒤 순회를 종료한다.
 * 5. 0이 되기전까지는 tmp에 pop해서 넣어준다.
 * 6. 완성한 스택의 값을 모두 꺼내서 ans에 더한 뒤 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 * 
 * - 위 내용을 모두 생각했는데... 구현이 안되는건지 정리가 안되는지 결국 힌트를 참고했다 
 * - 다음에 풀때는 잘 정리해서 구현할 수 있도록 해야겠다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c == '('){
                stack.push(0);
            }else if(c == ')'){
                int tmp = 0;
                while(true){
                    if(stack.peek() == 0){
                        stack.pop();
                        stack.push(tmp);
                        break;
                    }
                    tmp += stack.pop();
                }
            }else if(c == 'H'){
                stack.push(1);
            }else if(c == 'C'){
                stack.push(12);
            }else if(c == 'O'){
                stack.push(16);
            }else if(c - '0' >= 0 && c - '0'<=9){
                int a = stack.pop();
                stack.push(a * Character.getNumericValue(c));
            }
        }
        int ans = 0;
        for (Integer i : stack) {
            ans += i;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


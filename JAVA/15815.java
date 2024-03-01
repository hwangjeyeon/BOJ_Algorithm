import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 자꾸 틀렸다고 해서 고생했는데 원인이 second가 먼저와야하는데 first를 먼저 와서 발생하는 문제였다 
 * 2. 그리고 큐를 사용해서 연산자를 저장하면 안 된다. 문제에서 주어지지는 않았지만 연산자 사이에 피연산자가 올 수 있기 때문이다.
 * 3. 따라서 그냥 쭉 입력값대로 순회해서 문제를 해결해야한다
 * 
 * - 맞게 구현했는데 틀렸다고 나와가지고 힌트를 참조했는데, 이건 뭐... 내가 기본 지식이 부족한건지 문제가 부실한건지 잘 모르겠다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        String input = br.readLine();
        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - '0';
            if(now >= 0){
                stack.push(String.valueOf(input.charAt(i)));
            }else{
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());

                if(input.charAt(i) == '+'){
                    stack.push(String.valueOf(second + first));
                }else if(input.charAt(i) == '-'){
                    stack.push(String.valueOf(second - first));
                }else if(input.charAt(i) == '*'){
                    stack.push(String.valueOf(second * first));
                }else if(input.charAt(i) == '/'){
                    stack.push(String.valueOf(second / first));
                }
            }
        }
        ans = Integer.parseInt(stack.pop());

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 괄호 예시를 통해서 스택을 활용해 풀 수 있음을 예상할 수 있다
 * 2. 입력값을 배열에 넣어주고 하나씩 확인해나간다
 * 3. 연산자에 대해 우선순위를 매겨준다. *,/는 1, +,-는 2, (,)는 3의 우선순위를 매기며 낮을 수록 파워를 강하게 해준다
 * 4. 이어서 피연산자면 StringBuilder에 넣어준다
 * 5. 피연산자가 아니면 연산자이므로 확인을 진행한다. 일단 (면 스택에 넣어주고 continue한다
 * 6. )면 stack이 비어있지 않고, stack의 꼭대기가 (가 아닌 동안 pop해서 StringBuilder에 넣어준다
 * 7. 이후 while문 종료 후. 찌꺼기인 (를 제거하기 위해 한번더 pop한다
 * 8. +,-,*,/인 경우 스택이 비어있지 않으면서 스택의 꼭대기의 우선순위 리턴숫자가 현재 배열의 우선순위 리턴 숫자보다 작은 동안에(우선순위가 큼을 의미함) pop해서 StringBuilder에 넣어준다
 * 9. 이후, 현재 연산자를 스택에 넣어준다
 * 10. 마지막에 스택이 빌때까지 값들을 다 뽑아내서 StringBuilder에 넣어준다
 * 11. 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(|S|)
 * 공간복잡도: O(|S|)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != '*' && arr[i] != '/' && arr[i] != '+' && arr[i] != '-' && arr[i] != '(' && arr[i] != ')'){
                sb.append(arr[i]);
            }else{

                if(arr[i] == '('){
                    stack.push(arr[i]);
                    continue;
                }
                if(arr[i] == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    continue;
                }

                if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/'){
                    while(!stack.isEmpty() && prior(stack.peek()) <= prior(arr[i])){
                        sb.append(stack.pop());
                    }
                    stack.push(arr[i]);
                }
            }


        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        bw.write(sb.toString());


        br.close();
        bw.close();
    }


    private static int prior(char a){
        switch (a){
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 2;
            case '-':
                return 2;
            case '(':
                return 3;
            case ')':
                return 3;
        }

        return -1;
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 일단 수식을 char 배열에 담아서 관리한다
 * 2. 수식을 Stack에 보관해준다.
 * 3. 연산자와 피연산자를 보관해줄 덱을 하나씩 만들어둔다
 * 4. 최초값은 스택에서 뽑아서 now에다가 넣어준다
 * 5. stack이 비어있지 않는 동안 순회를 돌면서 피연산자와 연산자를 구분하여 덱에 저장한다
 * 6. 피연산자인 경우 만약 now가 1~9사이일 경우 임시 스택과 StringBuilder를 하나 만들어준다
 * 7. 피연산자가 아닐때까지 스택에서 빼서 임시 스택에 넣어주고 이어서 0이 아닐때까지 빼주기 위해 임시 스택이 비어있지 않은데 맨 위가 0인 경우 0이 아닐떄까지 빼준다. 이때 크기가 1이면 단독 0이 가능하므로 제외해준다
 * 8. 이제 임시스택이 빌때까지 StringBuilder에 넣어준다.
 * 9. 파싱을 준비하기 위해 long 타입 변수를 하나 만들어주고 맨앞 수가 음수인경우 음수로 바꿔준다
 * 10. 음수 판단은 스택 크기가 1이고 스택 꼭대기 연산자가 '-'인 경우다.
 * 11. 이후 파싱해서 피연산자 덱에넣어준다
 * 9. 연산자인경우 그냥 연산자 덱에 넣어준다
 * 10. 이제 주어진 우선순위 대로 연산을 진행한다. opcode 덱의 크기에 따라 분류해서 처리해야한다.
 * 11. 먼저 2보다 큰 경우 피연산자 변수 2개, 연산자 변수 4개를 준비한다. 피연산자 연산자 모두 양끝에서 poll해주며, 연산자의 경우 뒤에서 poll하는 경우 순서를 주의한다.
 * 12. 우선순위 체크를 통해 만약 한쪽이 * / 일때 다른 한쪽이 + -이면 우선순위에 맞춰서 한쪽을 계산해서 넣어주고 다른 한쪽은 피연산자를 그대로 넣고 연산자도 넣어준다
 * 13. 만약 우선순위 체크를 통과 못하면 미리 값을 계산해서 더 큰쪽을 넣어준다. 같은 경우는 앞쪽을 넣어준다
 * 14. opcode가 2인경우, 1인경우 0인경우를 이제 나눠서 추가 처리를 해주어야 한다.
 * 15. opcode가 2인 경우는 앞선 방식이랑 똑같으나 변수의 개수만 조금 달라진다. 피연산자 변수의 개수를 3개로 줄인다. 이때 뒤에서 뽑는 변수의 개수를 1개로 한다
 * 16. opcode가 2인경우를 넘어간 후에 이제 1인경우와 아닌 경우를 if-else로 묶어 처리한다.
 * 17. 1인 경우 opcode와 피연산자 두개를 하나씩 앞뒤로 뽑은 다음 계산해서 ans에 넣어주고 아닌 경우 그냥 피연산자 덱에서 뽑아서 ans에 넣어준다
 * 18. 이제 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * - 디버깅 리스트 (제출 후 틀려서 고민했던 디버깅 사항들):
 * 1. 앞에 0이 연달아 올때 처리하는 로직 문제
 * 2. 덱의 opcode 개수에 따른 poll 개수차이때문에 발생한 null 문제
 * 3. 맨앞 두자리수 이상일 때 음수 처리하는 문제
 * 4. 덱에서 양 끝 뽑을 때 잘못 뽑은 문제
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(s.length)
 * 공간복잡도: O(s.length)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.add(s[i]);
        }
        Deque<Character> opcode = new ArrayDeque<>();
        Deque<Long> operand = new ArrayDeque<>();
        char now;
        while(!stack.isEmpty()){
            now = stack.pop();
            if(now >= '0' && now <= '9'){

                StringBuilder sb = new StringBuilder();
                Stack<Character> tmp = new Stack<>();
                tmp.push(now);
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    // 10000000
                    tmp.push(stack.pop());
                }
                while(!tmp.isEmpty() && tmp.peek() == '0' && tmp.size() != 1){
                    tmp.pop();
                }

                while(!tmp.isEmpty()){
                    sb.append(tmp.pop());
                }
                long res = Long.parseLong(sb.toString());
                if((stack.size()==1 && stack.peek() == '-')){
                    res = -res;
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                operand.addFirst(res);
            }else if(now == '+' || now == '-' || now == '*' || now == '/'){
                opcode.addFirst(now);
            }
        }
        long ans = 0;
        while(opcode.size() > 2){
            char first = opcode.pollFirst();
            char second = opcode.pollLast();
            long firstOne = operand.pollFirst();
            long firstTwo = operand.pollFirst();
            long secondTwo = operand.pollLast();
            long secondOne = operand.pollLast();

            if(priorChk(first, second)){
                if(first == '*' || first == '/'){
                    long result = calculate(first, firstOne, firstTwo);
                    operand.addFirst(result);
                    operand.addLast(secondOne);
                    operand.addLast(secondTwo);
                    opcode.addLast(second);
                }else if(second == '*' || second == '/'){
                    long result = calculate(second, secondOne, secondTwo);
                    operand.addLast(result);
                    operand.addFirst(firstTwo);
                    operand.addFirst(firstOne);
                    opcode.addFirst(first);
                }
            }else{
                long result1 = calculate(first, firstOne, firstTwo);
                long result2 = calculate(second, secondOne, secondTwo);
                if(result1 >= result2){
                    operand.addFirst(result1);
                    operand.addLast(secondOne);
                    operand.addLast(secondTwo);
                    opcode.addLast(second);
                }else{
                    operand.addLast(result2);
                    operand.addFirst(firstTwo);
                    operand.addFirst(firstOne);
                    opcode.addFirst(first);
                }
            }

        }

        if(opcode.size() == 2){
            char first = opcode.pollFirst();
            char second = opcode.pollLast();
            long firstOne = operand.pollFirst();
            long firstTwo = operand.pollFirst();
            long secondOne = operand.pollLast();

            if(priorChk(first, second)){
                if(first == '*' || first == '/'){
                    long result = calculate(first, firstOne, firstTwo);
                    operand.addFirst(result);
                    operand.addLast(secondOne);
                    opcode.addLast(second);
                }else if(second == '*' || second == '/'){
                    long result = calculate(second, firstTwo, secondOne);
                    operand.addLast(result);
                    operand.addFirst(firstOne);
                    opcode.addFirst(first);
                }
            }else{
                long result1 = calculate(first, firstOne, firstTwo);
                long result2 = calculate(second, firstTwo, secondOne);
                if(result1 >= result2){
                    operand.addFirst(result1);
                    operand.addLast(secondOne);
                    opcode.addLast(second);
                }else{
                    operand.addLast(result2);
                    operand.addFirst(firstOne);
                    opcode.addFirst(first);
                }
            }
        }

        if(opcode.size() == 1){
            char op = opcode.pop();
            long first = operand.pollFirst();
            long second = operand.pollLast();
            ans = calculate(op, first, second);
        }else{
            ans = operand.pop();
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static boolean priorChk(char first, char second) {
        if((first == '*' || first == '/') && (second == '+' || second == '-')){
            return true;
        }else if((first == '+' || first == '-') && (second == '*' || second == '/')){
            return true;
        }

        return false;
    }

    private static long calculate(char opcode, long operandOne, long operandTwo) {
        if(opcode == '+'){
            return operandOne + operandTwo;
        }else if(opcode == '-'){
            return operandOne - operandTwo;
        }else if(opcode == '*'){
            return operandOne * operandTwo;
        }else if(opcode == '/'){
            return operandOne / operandTwo;
        }
        return 0;
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 괄호 문제는 전통적으로 스택을 사용해 왔다. 이 문제도 결국 )나 ]가 나올 때까지 (와 [를 넣고 빼고 해야하는 문제이기 때문에 스택을 사용한다
 * 2. ()와 []는 각각 다른 스택을 사용한다
 * 3. )가 나오면 스택의 꼭대기를 보고 (가 있으면 pop해주고 없으면 break한 뒤, 0을 출력하도록 한다
 * 4. ]가 나오면 스택의 꼭대기를 보고 [가 있으면 pop해주고 없으면 break한 뒤, 0을 출력하도록 한다
 * 5. 3~4번 과정 중에 다음 검사를 한다. 스택이 비어있는지 꼭 검사를 해준다
 * 6. 각각의 스택이 비어있지 않다면 ans에 count1와 count2를 더해준다
 * 7. 3과 4번에서 각각 (나 [가 있으면 count1과 count2에 (둘다 초기값 1) 각각 2와 3을곱해준다
 * 8. 둘중 하나만 스택이 비면 count1과 count2를 ans에 더해주고, 두 스택 모두 비어있으면 count1과 count2를 곱한 뒤 ans에 더해준다
 *
 *
 * - 문제 해결:
 * 1. 스택과 count를 하나로 줄여도 되겠다고 문제 디버깅하면 깨닫게 되었다.
 * 2. 이어서 어차피 스택에서 뺄 때 괄호가 안 맞으면 0으로 처리하고 출력해버리니까 스택에 넣을 때 맞춰서 count에 2나 3을 곱해준다
 * 3. 이어서는 기존과 동일한데 딱 2가지만 추가하였다.
 * 4. 먼저 더하기를 구현하기 위해 지금이 )일 때, 내 이전이 (이거나 지금이 ]일때, 내 이전이 [이라면 지금까지 누적한 곱셈값을 더해준다
 * 5. 이어서 count에 값을 )이면 2만큼 나눠서 저장하고 ] 이면 3만큼 나눠서 저장한다.
 *
 * - 스택과 관련된 구현 문제이다. 조금더 문제에 집중하고 자료구조를 활용한 구현 능력을 늘리자
 * - 힌트 참고 문제이기에 이후 재풀이할 예정
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
        int count = 1;
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            String now = input[i];
            if(now.equals("(")){
                stack.push(now);
                count *= 2;
                continue;
            }else if(now.equals("[")){
                stack.push(now);
                count *= 3;
                continue;
            }

            if(now.equals(")")){
                if(stack.isEmpty() || !stack.peek().equals("(")){
                    ans = 0;
                    break;
                }else if(input[i-1].equals("(")){
                    ans += count;
                }
                stack.pop();
                count /= 2;
            }else if(now.equals("]")){
                if(stack.isEmpty() || !stack.peek().equals("[")){
                    ans = 0;
                    break;
                }else if(input[i-1].equals("[")){
                    ans += count;
                }
                stack.pop();
                count /= 3;
            }

        }

        if(!stack.isEmpty()){
            ans = 0;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


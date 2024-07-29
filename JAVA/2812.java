import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 처음에 생각한 방법은 PQ를 이용하여 숫자 오름차순 -> 같을경우 포지션 기준 오름차순으로 해결하려 했다
 * 2. 하지만 이 방법은 예제 3번을 통과할 수 없기에 다른 방법을 모색하였다
 * 3. 이 문제는 스택을 이용하면 쉽게 풀 수 있는 문제다
 * 4. 다른 스택 문제처럼 입력받은 문자열을 순회하면서 만약 스택에 넣은 peek값이 현재 문자보다 작고, count가 k개보다 작으며, 스택이 비어있지 않다면 while문을 통해 스택의 값을 빼고 count 값을 증가시킨다
 * 5. 이후 stack에 해당 문자를 넣어준다.
 * 6. 이후 StringBuilder에다가 stack의 값을 하나씩 pop해서 넣어주고, reverse한 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 * 6. 한가지 주의할점이 있다. 내림차순으로 나올 경우 4번 로직이 실행되지 않고 그대로 스택에 모두 넣어질 수 있다
 * 7. 따라서 순회 종료 후에 count가 k보다 작을떄까지 stack에서 pop해주고 count를 증가시켜준다
 * 
 *
 * 시간복잡도: O(n+k)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        int count = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(s[0]);
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() < s[i] && count < k){
                stack.pop();
                count++;
            }
            stack.push(s[i]);
        }

        while(count < k){
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        bw.write(sb.reverse().toString());

        br.close();
        bw.close();
    }

}


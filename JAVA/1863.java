import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 스택과 y축만을 비교하면 풀 수 있다.
 * 2. 다음 3가지 규칙을 발견하였다. 스택에 차례대로 넣었을 때, 현재 스택의 peek가 y축 입력값보다 크면 ans를 증가하고 pop한다
 * 3. 만약 같다면 continue한다. 스택에 넣지 않는다
 * 4. 입력 종료 후에 stack이 비어있지 않다면 0이 아닌 경우에만 ans를 증가시키고 pop을 한다.
 *
 * 해결방법:
 * 1. 이 과정을 처음에는 두개의 스택으로 하다가 자가당착에 빠져버렸다..
 * 2. 만약 같다면 스택에 넣지 않아도 된다
 * 3. 아이디어는 발견했지만 구현을 제대로 못해서 아쉽다. 다시풀어보자!
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
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > y){
                ans++;
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == y){
                continue;
            }
            stack.push(y);
        }

        while(!stack.isEmpty()){
            if(stack.peek() > 0){
                ans++;
            }

            stack.pop();
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }



}


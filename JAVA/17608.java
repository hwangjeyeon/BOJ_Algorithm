import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 쌓아둔 높이를 오른쪽에서 바라보면서 순회하는 문제니까.. 스택을 사용하면 된다
 * 2. 가장 큰 막대기 높이를 기준으로 현재 스택의 꼭대기 값보다 큰지를 확인한다. 크면 ans를 증가시킨다
 * 3. 매 순회마다 기존 max와 스택의 pop값을 비교하여 더 큰 값을 max에 넣는다.
 * 4. 순회는 스택의 크기가 1보다 클떄까지 하며 ans의 초기값은 맨 처음은 무조건 보니까 1로 한다
 * 5. 완성된 ans를 출력하면 정답이 된다.
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

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            stack.push(input);
        }
        int ans = 1;
        int max = 0;
        while(stack.size() > 1){
            max = Math.max(stack.pop(), max);
            if(max < stack.peek()){
                ans++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


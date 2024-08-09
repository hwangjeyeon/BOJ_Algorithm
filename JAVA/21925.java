import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 이 문제는 그리디와 DP로도 풀 수 있지만 스택으로 쉽게 풀 수 있다
 * 2. 팰린드롬의 대칭성에 주목해서 보면 괄호문제와 비슷하게 스택으로 풀 수 있을 것임을 유추할 수 있다
 * 3. 따라서 스택을 사용하여 문제를 해결한다. 첫번째 값은 스택에 넣어주고, 만약 스택이 비어있다면 값을 넣어주고 continue한다
 * 4. 만약 비어있지 않다면 팰린드롬 체크를 해주어야 한다. 현재 스택의 크기만큼 팰린드롬 체크를 해준다
 * 5. 팰린드롬 체크를 할 때는 원래는 새로운 스택을 하나 더 만들어서 체크하는 것이 가장 좋다
 * 6. 하지만 자바에서는 스택의 깊은 복사를 지원하는 라이브러리가 없는 것으로 알고 있어서 다른 방법을 모색하였다
 * 7. 크기만큼 순회하면서 만약 범위를 벗어나는 경우가 있으면 finish를 true로 바꾸고 false로 탈출한다
 * 8. 아니라면 stack의 peek가 아닌 get을 사용하여 배열의 값과 비교한다
 * 9. stack.get(size - i - 1)과 arr[idx + i]의 값이 equals하지 않다면 flase로 탈출한다
 * 10. 이후 모든 순회를 통과하면 stack을 clear하고 true로 탈출한다
 * 11. 이제 팰린드롬결과가 true라면 ans 값을 증가시키고, i에 size-1만큼 넣어준다. -1을 넣은 이유는 어차피 i가 한번 증가할 것이기 떄문이다
 * 12. false라면 스택에 현재 배열의 값을 넣어주면 된다. 이때 finish를 체크해서 만약 true라면 break해준다
 * 13. stack의 값이 비어있지 않다면 팰린드롬이 아닌 것이므로 ans를 -1로 초기화한다
 * 14. 이렇게 완성된 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n*logn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int[] arr;
    static boolean finish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            int size = stack.size();
            if(isPalindrome(stack, i,n)){
                ans++;
                i += size-1;
            }else{
                if(finish){
                    break;
                }
                stack.push(arr[i]);
            }

        }
        if(!stack.isEmpty()){
            ans = -1;
        }

        bw.write(ans+"");



        br.close();
        bw.close();
    }

    private static boolean isPalindrome(Stack<Integer> stack, int idx, int n) {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if(idx + i >= n){
                finish = true;
                return false;
            }

            if(!stack.get(size-i-1).equals(arr[idx + i])){
                return false;
            }
        }
        stack.clear();
        return true;
    }


}

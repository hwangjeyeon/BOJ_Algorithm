import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값때문에 고생한 문제다...
 * 2. Double형 출력은 오랜만에 보는 문제였지만 큰 문제가 되지는 않았다.
 * 3. String.format(%.2f,ans)로 소수점 자리 제한해서 출력하고 스택도 double형으로 받아지도록 설정해두었다
 * 4. 이전 후위표기법 문제를 떠올려서 second가 먼저나오고 그다음에 first가 나오도록 연산하는 것도 잘 해결하였다.
 * 5. 하지만 입력 부분에서 처음에는 A는 무조건 3번째 이런식으로 나오는 줄 알고 해당 문자열 - 'A' == i로 잘못 입력받는 잘못을 저질렀다
 * 6. 문제를 다시 읽어보니 그렇게 나오지 않을 가능성이 충분히 있었고, 그냥 문자열 쌩으로 받고 숫자만 따로 int형으로 받은 뒤, 문자열을 확인하는 순회동안 처리하도록 했다.
 * 7. 문자열을 char형으로 받은 뒤, c가 'A'와 'Z'사이에 있는지 먼저 확인한다. 만약 있다면 해당 input[c-'A']을 명시적 형변환으로 (double)형으로 변환해 스택에 넣어준다
 * 8. 그 외에는 이전 후위 표기법 문제를 생각해서 넣으면 된다.
 *
 * - 문제 해결:
 * 1. 6~7번을 힌트를 참고해서 풀었다..
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
        int[] input = new int[n];
        double ans;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'A' &&  c <='Z'){
                stack.push((double)input[c-'A']);
            }else {
                double first = stack.pop();
                double second = stack.pop();
                if(c == '+'){
                    stack.push(second + first);
                }else if(c == '-'){
                    stack.push(second - first);
                }else if(c == '*'){
                    stack.push(second * first);
                }else if(c == '/'){
                    stack.push(second / first);
                }
            }

        }

        ans = stack.pop();

        bw.write(String.format("%.2f",ans));

        br.close();
        bw.close();
    }

}


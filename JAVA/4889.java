import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 스택을 사용해서 해당 {이면 그냥 push하고 }이면 peek가 {인지 확인하고 맞으면 pop아니면 push한다
 * 2. 각 입력마다 스택의 크기를 출력한다.
 * => 틀린 풀이
 * 1. 1번까지는 맞는 풀이다
 * 2. 문제를 다시 자세히 읽으면 2번은 틀린 풀이가 되게 된다. 이 문제는 안정적인 문자열을 다 뽑아낸다음 불안정적인 문자열을 안정적인 문자열로 바꾸는 횟수가 정답이다
 * 3. 따라서 스택이 빌 때까지 비교하는데 각 순회마다 스택의 꼭대기 값을 하나 뽑아서 now에 저장하고 스택의 꼭대기와 비교했을 떄 {{, }}이면 ans++, }{이면 ans+=2해준다
 * 4. 그리고 3번 조건에 해당하면 스택의 값을 pop한다
 * 5. 완성한 ans를 출력하면 정답이다.
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
        String input = "";
        Stack<String> stack = new Stack<>();
        int count = 1;
        while(!(input = br.readLine()).contains("-")){
            String[] s = input.split("");
            for (int i = 0; i < s.length; i++) {
                if(s[i].equals("{")){
                    stack.push(s[i]);
                }else{
                    if(!stack.isEmpty() && stack.peek().equals("{")){
                        stack.pop();
                    }else{
                        stack.push(s[i]);
                    }
                }
            }
            int ans = 0;

            while(!stack.isEmpty()){
                String now = stack.pop();
                if(!stack.isEmpty()){
                    if(now.equals("{") && stack.peek().equals("{")){
                        ans++;
                        stack.pop();
                    }else if(now.equals("{") && stack.peek().equals("}")){
                        ans+=2;
                        stack.pop();
                    }else if(now.equals("}") && stack.peek().equals("}")){
                        ans++;
                        stack.pop();
                    }
                }
            }

            bw.write(count +". " + ans +"\n");
            stack.clear();
            count++;
        }


        br.close();
        bw.close();
    }

}


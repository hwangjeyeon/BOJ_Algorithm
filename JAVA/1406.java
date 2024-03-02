import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 키로거랑 유사한 문제이다. 왼쪽 스택과 오른쪽 스택을 사용하였다.
 * 2. 단순히 양쪽 끝만을 보는 문제는 덱을 쓰면 되고 중간에 있는 값까지 확인하면서 왼쪽과 오른쪽에 넣는 문제는 앞으로 두 스택을 활용하면 될 것 같다.
 * 3. L은 왼쪽에 있는 값을 빼서 오른쪽 스택에 넣는다
 * 4. D는 오른쪽에 있는 값을 빼서 왼쪽 스택에 넣는다
 * 5. B는 왼쪽에 있는 값을 빼준다
 * 6. 3~5는 모두 빼는 스택이 비어있지 않을 경우에만 진행한다
 * 7. P는 이후 오는 문자열을 왼쪽 스택에 더해준다.
 * 8. 모든 명령어 실행이 종료되면 이제 오른쪽 스택에 있는 모든 값을 빼서 왼쪽 스택에 넣어준다
 * 9. 마지막으로 왼쪽 스택에 있는 값들을 출력하면 정답이 된다.
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

        String[] input = br.readLine().split("");
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            left.push(input[i]);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("P")){
                left.push(command[1]);
            }else if(command[0].equals("L")){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }

            }else if(command[0].equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }

            }else if(command[0].equals("B")){
                if(!left.isEmpty()){
                    left.pop();
                }
            }
        }

        while(!right.isEmpty()){
            left.push(right.pop());
        }

        for(String s : left){
            bw.write(s);
        }
        br.close();
        bw.close();
    }

}


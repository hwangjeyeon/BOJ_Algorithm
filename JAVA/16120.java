import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 문제 이해가 어려운 문제였다. 하지만 간단하게 생각하자
 * 2. 결론적으로 A를 입력받았을 때, 앞에 있는 두 단어가 모두 P고 내 뒤도 P여야 한다. 이 경우를 만족하지 않는 경우를 찾으면 된다
 * 3. 스택을 활용하면 조건의 수를 조금 더 줄일 수 있다
 * 4. 만약 P라면 모두 스택에 넣어준다. 이후, A의 입력이 들어왔을 때, 스택의 크기만 확인하면 된다
 * 5. 크기가 2보다 크다면 P가 두개 앞에 있다는 의미이므로 조건이 성립된다
 * 6. ans를 정답 값으로 선언해두고 역으로 정답값이 아닐 때 순회를 탈출하도록 설계하자
 * 7. 현재 입력값이 A일 때, 만약 스택이 비어있다면 NP, 현재 i의 위치가 맨 끝일때도 NP, 스택의 크기가 2보다 작아도 NP이다.
 * 8. 이어서 P는 PPAP를 바꾼 것이므로 스택의 앞값 하나만 pop하고 A와 뒤에 있는 P는 건너 뛰기 위해 아무 작업 없이 i++를 해준다
 * 9. 이후 출력하면 되는데 두가지 반례를 더 생각해야 한다
 * 10. 먼저 PPPP같이 P만 들어오고 A가 아예 없는 경우다. 이것을 구분하기 isOk라는 boolean 변수를 하나 두고, 입력으로 A가 들어왔을 때 true로 바꾸도록 하자
 * 11. 순회 후에, 해당 값이 false면 NP다.
 * 12. 추가적으로 하나 더 생각해야하는데 P가 하나만 들어오면 이건 PPAP이다. 따라서 배열의 길이가 1이면 NP 조건을 회피한다
 * 13. 이제 정리된 ans를 출력하면 정답이 된다.
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
        boolean isOk = false;
        String ans = "PPAP";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A'){
                isOk = true;
                if(stack.isEmpty()){
                    ans = "NP";
                    break;
                }

                if(i == arr.length-1){
                    ans = "NP";
                    break;
                }
                if(arr[i+1] == 'A'){
                    ans = "NP";
                    break;
                }

                if(stack.size() < 2){
                    ans = "NP";
                    break;
                }
                stack.pop();

                i++;
                continue;
            }
            stack.push(arr[i]);
        }
        if(!isOk && arr.length > 1){
            ans = "NP";
        }


        bw.write(ans);


        br.close();
        bw.close();
    }

}


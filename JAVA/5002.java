import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 문제에 의하면 현재 확인해야하는 줄과 그 다음 줄까지만 비교할 수 있다
 * 2. 따라서 성별에 따라 각각의 스택으로 관리하고 비교하여 문제를 해결하면 된다
 * 3. 줄 순서대로 성별을 확인하여 스택에 넣어준다
 * 4. 이후 두 스택의 크기 차이를 비교한다
 * 5. x보다 큰 경우에는 다음 문자가 있다면 확인해서 현재와 같은 성별일 경우에만 현재 입력으로 들어온 스택에 대해 pop한 뒤, break한다.
 * 6. 이후 두 스택의 크기를 더한 값을 출력하면 정답이 된다.
 * 7. 한가지 예외 처리를 해야하는데, 마지막 부분에 대한 예외처리다. 맨 마지막 부분은 뒤에 단어하고 비교할 수가 없다
 * 8. 하지만 자기자신이 들어오면서 그 차이가 x를 넘어가는 경우가 있으므로 예외적으로 현재 들어온 문자에 대한 스택에서 값을 빼준다.
 *
 * 해결방법:
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
        int x = Integer.parseInt(br.readLine());

        String s = br.readLine();
        Stack<Character> man = new Stack<>();
        Stack<Character> woman = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M'){
                man.push(s.charAt(i));
            }else{
                woman.push(s.charAt(i));
            }
            int diff = Math.abs(man.size() - woman.size());
            if(diff > x){
                if(i+1 < s.length() && s.charAt(i+1) == s.charAt(i)){
                    if(s.charAt(i)=='M'){
                        man.pop();
                    }else{
                        woman.pop();
                    }
                    break;
                }

                if(i == s.length()-1){
                    if(s.charAt(i)=='M'){
                        man.pop();
                    }else{
                        woman.pop();
                    }
                }
            }
        }
        bw.write((man.size() + woman.size()) + "");

        br.close();
        bw.close();
    }

}


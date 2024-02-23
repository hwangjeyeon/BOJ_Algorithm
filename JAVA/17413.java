import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - <,>,공백이 나오는 경우는 answer에 그대로 삽입
 * - 이외에는 stack에 넣어주고 이후에 answer에 삽입하면 뒤집혀서 삽입되게 된다
 * - 넣어줄때는 <인경우와 공백인 경우, 그리고 s문자열 순회 종료후에 해주면 ㅗ딘다
 * - 완성한 answer을 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<'){
                while(!stack.isEmpty()){
                    answer += (char)stack.pop();
                }
                while (s.charAt(i) != '>'){
                    answer += (char)s.charAt(i);
                    i++;
                }
                if(s.charAt(i) == '>'){
                    answer += (char)s.charAt(i);
                    continue;
                }
            }
            if(s.charAt(i) == ' '){
                while(!stack.isEmpty()){
                    answer += (char)stack.pop();
                }
                answer += (char)s.charAt(i);
            }else{
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            answer += (char)stack.pop();
        }

        bw.write(answer);
        br.close();
        bw.close();
    }
}


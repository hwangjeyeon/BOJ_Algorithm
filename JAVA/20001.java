import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 고무오리 디버깅 끝을 입력받을 때까지 입력을 받는다
 * 2. 입력값이 문제이면 스택에 값을 넣는다
 * 3. 문제가 아니면 스택이 비어있는지 체크하고 비어있으면 스택에 값을 두번 넣는다
 * 4. 비어있지 않으면 pop을 해준다
 * 5. 입력 종료 후에, 스택이 비어있으면 고무오리야 사랑해를 출력하고 아니면 힝구를 출력하면 정답이 된다.
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

        Stack<String> s = new Stack<>();
        String input = br.readLine();
        while(!(input = br.readLine()).equals("고무오리 디버깅 끝")){
            if(input.equals("문제")){
                s.push("문제");
            }else{
                if(s.isEmpty()){
                    s.push("문제");
                    s.push("문제");
                }else{
                    s.pop();
                }
            }
        }

        if(s.isEmpty()){
            bw.write("고무오리야 사랑해");
        }else{
            bw.write("힝구");
        }


        br.close();
        bw.close();
    }

}


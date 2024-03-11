import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 스택을 떠올리면 정말 쉬운 문제이다
 * 2. 스택에 문자 하나씩 넣으면서 스택의 peek값이 현재 가리키고 있는 폭탄 문자와 같다면, 폭탄 문자열의 길이만큼 체크해서 pop을 해준다
 * 3. 만약 도중에 폭탄 문자열이 아닐경우를 대비해서 임시 tmp 스택을 만들어서 pop한 문자를 보관하고 아닐 경우 ans 스택에 다시 넣어준다
 * 4. 만약 ans 스택이 비어있으면 정해진 문자열을 출력하고 아니면 iter 순회로 ans 스택의 값을 출력한다.
 *
 * 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split("");
        String[] bomb = br.readLine().split("");
        Stack<String> ans = new Stack<>();
        int now = bomb.length-1;
        Stack<String> tmp = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            ans.push(input[i]);
            while(now >= 0 && !ans.isEmpty() && ans.peek().equals(bomb[now])){
                tmp.add(ans.pop());
                now--;
            }
            if(now == -1){
                tmp.clear();
            }

            if(now>=0 && !tmp.isEmpty()){
                while(!tmp.isEmpty()){
                    ans.push(tmp.pop());
                }
            }

            now = bomb.length-1;
        }

        if(ans.isEmpty()){
            bw.write("FRULA");
        }else{
            for (String an : ans) {
                bw.write(an);
            }
        }


        br.close();
        bw.close();
    }


}

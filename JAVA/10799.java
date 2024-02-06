import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열을 char형 배열로 받는다
 * - 첫번째 문자열을 스택에 넣어준다
 * - 위치가 char형 배열의 크기보다 작은동안 반복되는데 ')'문자일 경우 pop을 하고 pos를 증가시키고 아닐경우 현재 배열의 값을 add한 뒤 pos을 증가시킨다
 * - 한가지 조건이 더 추가되는데 ')'문자일 때 이전 인덱스의 배열의 값이 ')'이라면 막대기 하나의 길이가 끝난 것이므로 pop을 하고 ans를 1만 증가시킨다
 * - 만약 위 조건이 맞지 않다면 레이저가 쏴진 것이므로 pop을 하고 ans에 스택의 크기만큼 더해준다.
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] bar = br.readLine().toCharArray();

        Stack<Character> sb = new Stack<>();

        sb.add(bar[0]);
        int pos = 1;
        int ans = 0;
        while(pos < bar.length){
            if(bar[pos] == ')'){
                if(bar[pos-1] == ')'){
                    sb.pop();
                    ans++;
                }else{
                    sb.pop();
                    ans += sb.size();
                }
                pos++;
            }else{
                sb.add(bar[pos]);
                pos++;
            }

        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * 재귀
 * 1. 함수 형태 compress(주어진 문자열, 현재 위치, 탐색 문자열, 개수)
 * 2. base Condition 현재 문자열이 ')'이면 종료
 * 3. 재귀식 if(주어진문자열.charAt(현재위치) == '(') -> compress(주어진 문자열, 현재 위치+1, ')', 개수+1)
 *
 * - 문제 해결:
 * 1. 스택과 재귀를 같이 활용하는 문제이다
 * 2. 먼저 (와 )의 위치를 저장해놔야한다. 이때 스택과 배열을 사용한다
 * 3. 이후 함수를 사용해서 순회하는데, 만약 (가 발견되면 2번에서 지정한 범위만큼 진행되도록 재귀함수를 실행한다
 * 4. 재귀함수에서는 임시 변수 tmp를 0으로 초기화한다
 * 5. 이후 start부터 end까지 순회하는데 현재가 (일 경우 tmp에 이전 문자열 곱하기 지정한 범위만큼의 개수를 곱하고 (을 빼주기 위해 -1을 해준다
 * 6. 이후 i에 pos[i]로 초기화하여 ()범위가 끝나고 난 다음에서 시작하도록한다
 * 7. 만약 5번이 아닌 경우 그냥 tmp++를 한다.
 * 
 * 재귀
 * 1. 함수 형태 compress(시작위치, 끝나는 위치)
 * 2. base condition 자동 종료
 * 3. 재귀식 compress(i+1, friend[i])
 *
 * => 재귀로만 문제를 해결하려가다가 낭패를 봤다... 스택을 사용하면 좋겠다고 생각했는데, 앞으로 여러 방법을 활용해서 풀도록 사고를 갖춰야겠다
 * => 골드 문제는 금주 목~금에 정리를 한번 할 계획
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 */


public class Main {

    static int count = 0;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        pos = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.add(i);
            }
            if(s.charAt(i) == ')'){
                pos[stack.pop()] = i;
            }
        }

        count = compress(s, 0, s.length());

        bw.write(count+"");
        br.close();
        bw.close();
    }

    private static int compress(String s, int start, int end) {
        int tmp = 0;
        for (int i = start; i < end; i++) {
            if(s.charAt(i) == '('){
                tmp += Integer.parseInt(String.valueOf(s.charAt(i-1))) * compress(s, i+1, pos[i])-1;
                i = pos[i];
            }else{
                tmp++;
            }
        }
        return tmp;
    }
}


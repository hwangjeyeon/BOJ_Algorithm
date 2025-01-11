import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n이 작은데다가, 선택지가 2가지라서 백트래킹으로 해결할 수 있는 문제다
 * 2. operand와 operator를 분리해서 리스트로 관리한다
 * 3. 이어서 괄호를 추가하는지, 안하는 지 여부에 따라서 모두 탐색하는 백트래킹을 구현한다
 * 4. operator를 기준으로 해당 리스트의 크기보다 크거나 같으면 ans와 비교해서 더 큰 값으로 갱신한다
 * 5. 합산에 처음 operand를 인수로하고, operator의 인수를 0으로 하는 백트래킹을 시작한다
 * 6. 괄호를 추가하지 않는 경우, 현재 operand와 다음 operand를 합산해서 재귀식을 이어간다
 * 7. 만약 괄호를 추가하는 경우, 계속 이어나가지 말고 operand + 1의 위치와 operand+2의 위치의 값을 계산한다
 * 8. 그리고 이어서 현재 위치의 operand와 계산한 값을 재귀식으로 넘기고 operator의 인덱스를 2를 늘린다
 * 9. 따라서 괄호를 추가하는 경우는 operator+1이 크기보다 작은지 검사한 다음 진행한다
 * 10. 이제 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(2^(n/2))
 * 공간복잡도: O((n/2))
 *
 */
public class Main {

    static List<Long> operand = new ArrayList<>();
    static List<Character> operator = new ArrayList<>();
    static long ans = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if(i%2 == 1){
                operator.add(s.charAt(i));
            }else{
                operand.add((long) Character.getNumericValue(s.charAt(i)));
            }
        }


        backtracking(0,operand.get(0));

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int opt, long sum) {
        if(opt >= operator.size()){
            ans = Math.max(ans, sum);
            return;
        }

        if(opt + 1 < operator.size()){
            long tmp = cal(operator.get(opt + 1), operand.get(opt+1), operand.get(opt+2));
            backtracking(opt+2, cal(operator.get(opt), sum, tmp));
        }
        backtracking(opt+1, cal(operator.get(opt), sum, operand.get(opt+1)));
    }

    private static long cal(char opt, long n1, long n2){
        if(opt == '+'){
            return n1 + n2;
        }else if(opt == '-'){
            return n1 - n2;
        }else if(opt == '*'){
            return n1 * n2;
        }
        return 1;
    }

}

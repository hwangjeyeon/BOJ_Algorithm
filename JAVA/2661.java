import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 백트래킹 자체는 쉬운 문제였지만, 좋은 수열인지 검증하는 방법과, 시간초과를 극복하고 정답을 출력하는 방법을 생각하는 것이 까다로웠던 문제였다
 * 2. 백트래킹은 주어진대로 그냥 문자열에다가 1,2,3 중 하나를 붙이면 된다. 단, 좋은 수열 조건을 만족할때만이다
 * 3. 좋은 수열을 만족하려면, 주어진 문자열의 절반만큼, 모든 문자를 탐색해야한다
 * 4. 1부터 절반 길이만큼 탐색을 하면서, 현재 문자열의 길이에서 i만큼 뺀 값이 현재 문자열의 길이에서 2*i만큼 뺀 값에서 i만큼 뺀 값의 길이 문자열이랑 같은지 확인하고, 같다면 fasle를 리턴, 다 통과하면 true를 리턴한다
 * 5. base condition은 문자의 길이가 n과 같아졌을 때다. 이때, 처음 도달하는 경우가 가장 작은 숫자이며, 모든 경우를 다 리스트로 담기에는 시간초과와 메모리 초과가 모두 발생하는 3^80이기 때문에 최초값만 출력하고 시스템을 종료한다
 *
 *
 * 시간복잡도: O(80*40)
 * 공간복잡도: O(1)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        backtracking(n, "");

        br.close();
        bw.close();
    }

    private static void backtracking(int n, String s) {
        if(s.length() == n) {
            System.out.println(s);
            System.exit(0);
        }


        for (int i = 1; i < 4; i++) {
            if(chk(s + i)){
                backtracking(n, s+i);
            }
        }

    }

    private static boolean chk(String s) {
        int len = s.length()/2;

        for (int i = 1; i <= len; i++) {
            if(s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))){
                return false;
            }
        }


        return true;
    }
}


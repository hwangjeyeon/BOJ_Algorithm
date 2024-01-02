import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 하노이 탑 공식: 2^n - 1 (메르센 수)
 * - 정말 유명한 문제였고, 전공수업때도 들었는데 그때는 개념이 이해가 안 되었지만 이번에는 힌트를 참고했을 때, 이해되었다.
 * - 위 하노이 탑 공식을 이용하면 고리의 개수가 주어졌을 때, 이동 횟수를 구할 수 있다
 * - 이어서 하노이탑은 A->C, A->B, B->C 3가지 과정을 가진다
 * - 따라서 위 조건을 재귀함수로 표현하면 각각 다음과 같다
 * 1. 먼저 파라미터는 hanoi(int size, int A, int B, int C)이다.
 * 2. A -> B hanoi(size-1, A, C, B) 제일 큰 원판을 제외한 n-1개의 원판을 먼저 B로 이동시킨다
 * 3. A -> C hanoi(1, A, B, C) 제일 큰 원 원판을 C로 이동시킨다
 * 4. B -> C hanoi(size-1, B, A, C) 이제 다시 B에 있는 n-1개의 원판을 c로 이동시킨다
 * 하노이탑의 두가지 규칙 때문에 그렇다
 * 1. 한번의 한 개의 원판만 움직일 수 있다
 * 2. 큰 원판이 작은 원판 위에 있어서는 안된다.
 * - 이 과정으로 재귀함수를 진행한 뒤, 종료조건으로 size가 1일 때, A와 C를 출력하게 하면 된다.
 * - 
 *
 *
 *
 * 시간복잡도: O(2^n-1)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append((int) Math.pow(2, n) - 1).append("\n");
        hanoi(n, 1,2,3);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    static void hanoi(int size, int A, int B, int C){
        if(size == 1){
            sb.append(A)
                    .append(" ")
                    .append(C)
                    .append("\n");
            return;
        }

        hanoi(size-1, A, C, B);

        hanoi(1, A,B, C);
        hanoi(size-1, B,A, C);
    }

}

import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. n-queen 문제에서는 각 행또는 열별로 한줄씩 퀸을 배치하면서, 서로 공격받지 않게 배치하도록 문제를 풀면된다
 * 2. 행을 기준으로 탐색해도 되고, 열을 기준으로 탐색해도 된다
 * 3. 이번 문제에서는 행을 기준으로 탐색하며, 2차원 배열로도 만들 수 있지만 1차원 배열로도 가능하기 때문에 1차원 배열로 문제를 풀려고 한다.
 * 4. 배열의 좌표를 행으로 보고, 그 좌표의 값을 열로 본다.
 *
 * 5. 재귀:
 * 함수식: nQueen(int n , int depth)
 * base condition: n == depth -> count++;
 * 재귀식: nQueen(n, depth+1)
 *
 * 6. 재귀함수에서 두가지 검증을 거쳐야한다. 일단 자신의 행에는 하나만 놓이기 때문에 검사할 필요가 없고, 나와 같은 열에 있는지와 대각선에 있는지를 체크해야한다
 * 7. 위에서부터 차례대로 내려가는 식으로 확인하기 떄문에 이전 값들만 검사하면 된다.
 * 8. 결과에 따라 false와 true를 리턴해준다.
 * 9. 재귀문은 첫번 째 행에서 어디에 놓냐에 따라 이후 결과가 다양하게 달라진다. 다라서 주어진 행의 길이 만큼 순회하면서, 재귀함수를 실행하는 백트래킹을 이용한다
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 *
 */

public class Main {

    static int count = 0;
    static int[] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        field = new int[n];

        nQueen(n, 0);

        bw.write(count+"");
        br.close();
        bw.close();
    }

    private static void nQueen(int n, int depth) {
        if(n == depth){
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            field[depth] = i;
            if(chkQueen(depth)){
                nQueen(n, depth+1);
            }
        }


    }

    private static boolean chkQueen(int num) {
        for (int i = 0; i < num; i++) {
            if(field[num] == field[i]){
                return false;
            }

            if(Math.abs(num - i) == Math.abs(field[num] - field[i])){
                return false;
            }
        }

        return true;
    }
}

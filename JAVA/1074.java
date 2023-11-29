import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 분할정복과 재귀를 활용해서 푸는 문제이다.
 * - 이전에 풀었던 색종이 만들기 문제에서 배운 분할정복과 재귀 개념을 토대로 풀었다.
 * - 처음 고민할 때, 일단 시간복잡도는 분할정복 + 재귀로 풀면 크게 문제는 될 것 같지 않았다
 * - 하지만 메모리문제는 있을 것으로 보였다.
 * - 1. 그래서 배열을 사용하지 않는 방향으로 해야겠다고 먼저 생각하였다
 * - 2. 그다음 모든 사분면을 탐색하는 것을 지양해야겠다고 생각했다. 2^15 * 2^15가 최악에 경우인데 이 경우 512MB 메모리 제한을 아득히 넘어선다
 * - 따라서 먼저 x와 y가 어느 사분면에 존재하는지 판단하기 위해 조건문을 통해 해당하는 구역만 재귀 탐색을 하였다 -> 이 부분이 색종이 만들기 문제와의 차이점이다
 * - 그 다음 출력 값을 어떻게 해야하나도 고민했었다 주어진 입력값은 행과 열이기 때문에 이를 활용해야만 했다
 * - 따라서 규칙을 찾았고, 2사분면으로 갈 경우 현재 좌표에서 현재 크기의 제곱한 만큼이고 3사분면 4사분면은 각각 2와 3을 곱한 값이 방문한 횟수로 판단하면 되었다
 * - 해당 규칙을 통해서, 코드도 최적화하면서 풀었는데... 그래도 메모리 초과가 발생하였다
 * - 도중에 while문으로 바꿨는데 시간문제가 터졌고, 결국 다시 돌아와서 재귀에서 해결하려 했으나 여러번 메모리 초과 문제가 발생하였다.
 * - 고민 끝에 내린 결론은 처음 재귀 함수 호출할 때 주어지는 값에서 문제였었다.
 * - 2^n-1 * 2^n-1을 size로 해서 호출했기 떄문에 메모리 초과가 발생하였다. 따라서 2^n-1 *2를 하면 메모리 초과 문제가 발생하지 않으면서, 재귀함수 동작도 문제없이 가능했기에 해당 부분을 수정하였다
 * - 그 결과 문제를 해결할 수 있었다.
 *
 * - 메모리 초과 문제 터지기 전까지 문제는 혼자 풀었다. 개념에 대한 숙지가 점점 되어가고 있는 것 같다.
 * - 메모리 초과부터 힌트를 봤는데, 내가 혼자 풀었던 부분과 다른 부분이 거의 없었고, 결국 고민 끝에 위 방법으로 해결하였다
 * - 이제 분할 정복에 대한 맛보기를 보았고 Solved 클래스 3 은장도 달아서 그리디 알고리즘 개념 학습 후에 다시 분할정복으로 돌아와 개념 복습 및 심화 문제를 해결할 계획이다
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {
    static int c = 0;
    static int r = 0;
    static int count = 0;
    static int newSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        br.close();
        int size = (int)Math.pow(2,n-1) * 2;
        partition(size, 0, 0);



        bw.write(count + "");
        bw.close();
    }

    public static void partition(int n, int x, int y){
        if(r == y && c == x){
            return;
        }
        n /= 2;
        if(c < x+n && r < y+n){
            partition(n, x, y);
        }else if(c >= x+n && r >= y+n){
            count += n*n*3;
            partition(n, x + n, y + n);
        }else if(r >= y+n){
            count += n*n*2;
            partition(n, x, y + n);
        }else if(c >= x+n){
            count += n*n;
            partition(n, x + n, y);
        }

    }


}

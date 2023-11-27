import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 1. 일단 배열을 만들어서 입력 받고 생각한다
 * 2. 분할정복 및 재귀를 활용해서 해결하는 문제이다.
 * - 여기서 부터는 학습을 위해 힌트를 참고하였다 -> 이후 재 복습할 때, 힌트 없이 다시 구현할 예정
 * 3. 보드판의 전체를 순회했을 때, 다른 색깔이 있는 경우 4등분 해야한다. 이때 4등분은 같은 색깔만 있는 경우까지이다.
 * 4. 이를 재귀로 구현한다. -> 전체 크기를 n, 그리고 처음 시작 지점 0,0을 partition() 함수에 인수로 넣었다
 * 5. partition에서는 다음 로직을 실행한다. 같은 숫자만 있는지 판단하는 colorCheck(n, x, y)함수를 통해 true를 리턴하면 다음 로직을 진행한다
 * 6. 만약 해당 보드의 현재 좌표 값 x와 y가 0이면 white의 값을 증가, 아니면 blue의 값을 증가하고 종료한다. -> 이때 한 좌표만으로 판단해도 되는 이유는 이 좌표 외에 다른 영역이 모두 같은 색이기 때문이다
 * 7. 만약 false라면 원래 크기를 반으로 나눈 즉, n/2한 newSize 변수를 선언한다 그 다음 총 4개의 재귀함수를 호출한다. 좌상, 우상, 좌하, 우하 총 4개의 함수를 호출한다
 * 8. 각 함수는 각 영역에 맞춰서 x나 y를 다시 넘길 수도 있고 x+newSize나 y+newSize를 넘길 수도 있다
 * 9. ColorCheck에서는 파라미터의 보드판 크기인 n과 x,y좌표를 토대로 현재 영역을 순회해서 다른 색깔이 있는지 확인한다. x+n, y+n만큼 순회하며, 기준은 순회하기 전 파라미터의 x,y좌표로 한다
 * 10. 다른 색깔이 있으면 false를 리턴하고 없으면 true를 리턴한다
 * 11. 최종 색깔의 개수를 출력한다 white를 출력하고 blue를 출력하면 된다.
 *
 * - 분할 정복의 첫 개념을 공부하는 문제였다. 재귀에 대한 학습과, 해당 예제를 토대로 앞으로 공부할 계획이다.
 * - 이후 분할 정복 문제 하나 더 풀어보고, 그리디에 대한 학습 이후 분할정복에 대한 개념 공부를 다시 할 예정이다.
 *
 * 참고 출처: https://st-lab.tistory.com/227
 * 
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 *
 */




public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        partition(n, 0, 0);
        bw.write(white + "\n" + blue);

        br.close();
        bw.close();
    }

    public static void partition(int n, int x, int y){

        if(colorCheck(n, x, y)){
            if(board[y][x] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = n/2;
        partition(newSize, x, y);
        partition(newSize, x + newSize, y);
        partition(newSize, x, y+newSize);
        partition(newSize, x+newSize, y+newSize);
    }

    private static boolean colorCheck(int n, int x, int y) {
        int colorCriteria = board[y][x];

        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(board[i][j] != colorCriteria){
                    return false;
                }
            }
        }

        return true;
    }


}

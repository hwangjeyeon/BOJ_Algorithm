import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 별찍기랑 비슷한 점이 많다. 먼저 출력문을 담을 2차원 배열을 설정한다
 * - 좌표의 크기는 이전과 동일하게 m = 4*n - 3으로 구한다
 * - 첫번째와 두번째 행은 다르게 생각해야한다. 기존에 생각했던 배열에 넣는 방식과 재귀 함수를 통과하는 방식이 아닌 별도의 출력을 해줘야 한다
 * - 첫번째는 위에서 구한 m만큼 가로로 출력된다
 * - 두번째는 첫번째 열만 별을 찍어주면된다. 잘 보면 이후에 빈칸이 없기 때문에 딱 첫번째 열만 출력한다
 * - 세번째 열부터는 이제 본격적인 시작이다. 이번 규칙은 힌트 없이 유추해내었다.
 * - 맨처음 아래로 가는 것은 m만큼 내려간다. 이것은 먼저 배열에 담아둔다
 * - 이제부터는 재귀함수를 이용할 것이다. 오른쪽 방향으로 이동할 때 m-2만큼으로 이동하는 횟수가 줄어든다. 위쪽은 이전 오른쪽에서 줄어든 만큼과 동일하다
 * - 다시 왼쪽 방향으로 이동할 때 이전의 m값에 m-2만큼 줄어든다. 아래쪽 방향은 왼쪽 방향에서 줄어든 만큼과 동일하다
 * - 위 내용을 재귀함수에서 진행하면 된다
 * - 종료 조건은 m즉 순회하는 size가 0보다 작거나 같을 때이다.
 * - 파라미터는 시작지점을 의미하는 start와 순회하는 크기를 나타내는 size이다
 * - 재귀함수 인수는 start+2, size-2로 한다.
 * - 이렇게 완성된 배열을 출력하면 정답이 된다.
 *
 *
 * - 재귀함수를 만들 때, 고려할 사항
 * -> 파라미터
 * -> 종료조건
 * -> 재귀함수 인수
 * -> 재귀함수에서 진행할 내용
 *
 * 이 4가지를 생각해서 앞으로 재귀함수를 직접 구현해보자!
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static char[][] starMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = 4*n - 3;
        starMap = new char[m][m];
        if(n == 1){
            bw.write("*");
        }else{
            for(int i=0; i<m; i++){
                bw.write('*');
            }
            bw.write("\n" + "*" + "\n");

            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    starMap[i][j] = ' ';
                }
            }

            for(int i=0; i<m; i++){
                starMap[i][0] = '*';
            }

            inputStar(0, m);

            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    bw.write(starMap[i][j]+"");
                }
                bw.write("\n");
            }

        }


        br.close();
        bw.close();
    }

    private static void inputStar(int start, int size) {
        if(size <= 0){
            return;
        }
        //오른쪽,위
        for(int i=start; i<size; i++){
            starMap[size-1][i] = '*';
            starMap[i][size-1] = '*';
        }

        //왼쪽, 아래
        for(int i=start+2; i<size; i++){
            starMap[start][i] = '*';
            starMap[i-2][start+2] = '*';
        }

        inputStar(start+2, size-2);
    }
}

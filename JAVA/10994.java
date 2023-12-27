import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 힌트를 참고했다.
 * - 별 찍기 문제 유형이 처음인 것과 재귀에 구현에 미흡해서 그런지 해결방법에 대한 감이 아예 잡히지 않았다.
 * - 힌트를 보게 되더라도 최소한 규칙은 이끌어내자 - 요즘 너무 힌트 보기만 남발하는 것에 반성하는 중.
 * - 별찍기 유형은 이것을 출력한 배열이 필요하다.
 * - 숫자가 입력되었을 때 별찍기 좌표의 크기는 입력한 수 n에 4를 곱하고 3을 뺀 n*4-3이다.
 * - 이 규칙을 이용해서 배열을 빈칸 ' '으로 초기화한다
 * - 이후 재귀를 이용한다. 인수로 시작점과 순회할 크기를 넘겨준다
 * - 재귀함수에서는 현재 순회할 수 있는 범위에 '*'를 채워넣는다
 * - 이때 위 과정을 진행하는 것은 상단, 하단 , 좌, 우 양 끝단에서 반복한다
 * - 이 과정을 재귀를 통해 반복하는데, 다시 출력 예제를 확인하면 2번째 4번째.. 짝수번대에는 빈칸이 유지된다
 * - 따라서 start+2, m-2를 인수로 넘겨서 재귀한다
 * - 종료조건은 m==1일때로 해서 종료시킨다
 * - 이렇게 완성된 배열을 출력하면 정답이 된다
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
        int m = n*4 - 3;
        starMap = new char[m][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                starMap[i][j] = ' ';
            }
        }

        inputStar(0,m);

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                bw.write(starMap[i][j] + "");
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }

    private static void inputStar(int start, int m) {
        for(int i=start; i<m; i++){
            starMap[start][i] = '*';
            starMap[m-1][i] = '*';
            starMap[i][start] = '*';
            starMap[i][m-1] = '*';
        }

        if(m == 1){
            return;
        }
        inputStar(start+2, m-2);
    }
}

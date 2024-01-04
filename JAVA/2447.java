import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 힌트를 참고해서 풀었습니다
 * - 단순 재귀만이 아니라 이 문제는 분할정복 알고리즘까지 들어있다
 * - 주어진 3*3패턴이 반복되는 출력 형태를 확인할 수 있다.
 * - 빈칸은 주어진 3*3패턴에서 정가운데 즉 5번째에서 빈칸이 반복되는 것을 확인할 수 있다.
 * - 예제 입력을 확인했을 때도, 이 패턴이 반복되며, n=27일때는 이 패턴이 x축으로 3개씩, y축으로 3개씩 해서 총 9개 있는 것을 확인할 수 있다
 * - 위 과정을 한번 더 쪼개면 주어진 3*3패턴과 같은 것을 확인할 수 있다
 * - 이런식으로 유추해봤을 때, 재귀 + 분할정복을 이용하면 풀 수 있는 문제이다.
 * - char[][] 배열을 만들어서 '*'과 ' '을 저장한다.
 * - 분할 정복이므로 순회할 때, 현재 주어진 size만큼만 순회한다 즉 x+size와 y+size만큼 순회한다
 * - 재귀함수 파라미터는 int size, int x, int y, boolean blank이다.
 * - 종료조건은 blank==true이거나 size == 1일 때이다.
 * - blank이면 주어진 size만큼 순회해서 char[][]에 빈칸으로 채워넣는다
 * - size==1이면 해당 char[][]배열인 star[x][y]에 '*'을 채워넣는다
 * - 그 외에는 size만큼 순회하지만, 증가는 newSize=n/3씩 하여 분할정복 방식으로 시간초과 없이 진행하게 한다.
 * - 이때 blankChk를 통해 값을 증가시켜 5일때는 true, 아닐때는 false로 빈칸과 아닌 곳을 명백하게 구분해준다.
 * - 재귀함수는 starBuild(x,y,newSize,blankChk==5)이다.
 *
 * - 힌트를 보는 빈도를 줄이도록 노력해야겠다...
 * - 다른 일정이 많다보니 하루 1백준 하겠다는 욕심때문에, 자꾸 일정 시간 이상 보았을 때, 풀리지 않으면 힌트를 보게 되는 나쁜 습관이 생기는 것 같다
 * - 조금 더 고민하는 시간을 갖도록 노력해야겠다
 * 
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {


    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        stars = new char[n][n];

        starBuild(n,0,0, false);
        for(int i=0; i<n; i++){
            bw.write(stars[i]);
            bw.write("\n");
        }

        br.close();
        bw.close();
    }


    static void starBuild(int size, int x, int y, boolean blank){
        if(blank){
            for(int i=x; i<x+size; i++){
                for(int j=y;j<y+size; j++){
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if(size==1){
            stars[x][y] = '*';
            return;
        }

        int newSize = size/3;
        int blankChk = 0;
        for(int i=x; i<x+size; i+=newSize){
            for(int j=y; j<y+size; j+=newSize){
                blankChk++;
                starBuild(newSize,i,j, blankChk == 5);
            }
        }

    }


}

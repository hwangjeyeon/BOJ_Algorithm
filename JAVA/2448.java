import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 별찍기 출력문제는 잘게잘게 잘라야 한다
 * 2. 잘랐을 때 나오는 삼각형은 3가지이다. 맨 위 하나, 그 왼쪽 아래, 오른쪽 아래 이렇게 3가지다
 * 3. 배열은 빈칸으로 초기화한다. 세로는 n, 가로는 n*2-1만큼으로 크기를 지정한다
 * 4. 재귀를 돌아준다. 0과 n-1 그리고 크기인 n을 넘겨준다
 * 5. a는 세로, b는 가로 길이다. 
 * 6. n이 3이 되었을 때는 가장 작은 삼각형 자리에 모두 별을 넣어준다
 * 7. 만약 3이 아닐 경우는 더 잘게 조게는 3가지 재귀를 실행한다. 이때  n/2로 크기를 줄여주며, 위 삼각형은 a,b를 그대로 보내준다
 * 8. 왼쪽 아래는 a+n/2, b-n/2를 보내고 오른쪽 아래는 a+n/2, b+n/2를 보낸다
 * 9. 3에서는 a,b위치에 별을 찍고 a+1,(b-1, b+1)에 별을 찍으며 a+2, (b-2, b-1, b, b+1, b+2)에 별을 찍는다
 * 10. 이렇게 완성한 문자 배열을 이중포문으로 순회해서 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n*(n*2-1))
 * 공간복잡도: O(n*(n*2-1))
 *
 */



public class Main {

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n*2-1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recur(0, n-1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                bw.write(arr[i][j]);
            }
            bw.write('\n');
        }

        br.close();
        bw.close();
    }

    private static void recur(int a, int b, int n) {
        if(n == 3){
            arr[a][b] = '*';
            arr[a+1][b-1] = '*';
            arr[a+1][b+1] = '*';
            arr[a+2][b-2] = '*';
            arr[a+2][b-1] = '*';
            arr[a+2][b] = '*';
            arr[a+2][b+1] = '*';
            arr[a+2][b+2] = '*';
            return;
        }else{
            recur(a, b, n/2);
            recur(a + n/2, b - n/2, n/2);
            recur(a + n / 2, b + n / 2, n / 2);
        }
    }
}


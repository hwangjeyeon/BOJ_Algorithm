import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. n-queen문제와 백트래킹이 떠올랐다
 * 2. 일단 해당 행의 열이 모두 채워지면 다음 행으로 가고 이어서 행까지 모두 채워졌으면 탐색 후 출력한 뒤, 시스템을 종료한다. -> 시스템 종료를 하지 않고 메인에서 출력하면 틀린다... 왜그런지 찾아봐야겠다
 * 3. 이어서 만약 현재 배열의 값이 0이면 1부터 9까지 수중에서 하나를 넣고 백트래킹을 하는데 검증을 통과해야한다
 * 4. 검증에서는 같은 행, 같은 열, 3x3 네모박스 영역안에서 같은 수가 있는지를 확인한다
 * 5. 만약 마땅한 숫자를 찾지 못했다면 해당 배열을 다시 0으로 복귀하고 분기는 종료한다
 * 6. 이어서 해당 열의 탐색 인덱스를 증가시키는 재귀함수를 실행한다.
 * 
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(arr,0,0);
        br.close();
        bw.close();
    }

    private static void backtracking(int[][] arr, int row, int col){
        if(col == 9){
            backtracking(arr,row+1, 0);
            return;
        }
        if(row == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }


        if(arr[row][col] == 0){
            for (int i = 1; i <= 9; i++) {
                if(check(arr, row, col, i)){
                    arr[row][col] = i;
                    backtracking(arr, row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        backtracking(arr, row, col+1);
    }

    private static boolean check(int[][] arr, int row, int col, int value){
        for (int i = 0; i < 9; i++) {
            if(arr[row][i] == value){
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(arr[i][col] == value){
                return false;
            }
        }

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if(arr[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

}


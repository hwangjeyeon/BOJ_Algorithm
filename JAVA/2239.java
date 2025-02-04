import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그냥 전부 백트래킹하려고 했는데, 10^100이라 시간초과가 발생한다
 * 2. 따라서 0인 곳만 백트래킹으로 숫자를 적용해본다. 문제는 이래도 시간초과가 발생할 것이다
 * 3. 따라서 0이 아닌 곳에 백트래킹 하기 전에 스도쿠 조건을 만족시키는지 검사한다
 * 4. 만족시키면 백트래킹을 진행시킨다
 * 5. 최종장에 도착하면 마지막으로 모든 구역에 대해서 검사를 진행한다.
 * 6. 검사를 통과하면 스도쿠 배열을 모두 출력하고 시스템을 종료한다
 * 7. 맨 처음 base condition에 도착해서 스도쿠 조건을 만족시키는 값이 사전식 중 앞서는 것이기 때문에 도착 후 조건을 만족시키면 바로 종료시키면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(9*9^(선택적 백트래킹)))
 * 공간복잡도: O(9*9)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        backtracking(0, arr);

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int[][] arr) {
        if(depth == 81){
            if(solve(arr)){
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            return;
        }

        int y = depth / 9;
        int x = depth % 9;

        int[][] tmp = new int[9][9];
        for (int i = 0; i < 9; i++) {
            tmp[i] = Arrays.copyOf(arr[i], 9);
        }
        if(tmp[y][x] != 0){
            backtracking(depth+1, tmp);
        }else{
            for (int i = 1; i < 10; i++) {
                if(isOk(y,x, i, tmp)){
                    tmp[y][x] = i;
                    backtracking(depth+1, tmp);

                }
            }
        }
        
    }

    private static boolean solve(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if(list.contains(arr[i][j])){
                    return false;
                }
                list.add(arr[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if(list.contains(arr[j][i])){
                    return false;
                }
                list.add(arr[j][i]);
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if(list.contains(arr[k][l])){
                            return false;
                        }
                        list.add(arr[k][l]);
                    }
                }
            }
        }


        return true;
    }

    private static boolean isOk(int y, int x, int num, int[][] tmp) {
        for (int i = 0; i < 9; i++) {
            if(tmp[y][i] == num || tmp[i][x] == num){
                return false;
            }
        }
        int ny = y/3 * 3;
        int nx = x/3 * 3;
        for (int i = ny; i < ny+3; i++) {
            for (int j = nx; j < nx+3; j++) {
                if(tmp[i][j] == num){
                    return false;
                }
            }
        }
        
        return true;
    }
}

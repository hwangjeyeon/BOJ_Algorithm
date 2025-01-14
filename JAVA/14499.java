import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 깡구현 문제다. 과거 코드트리에서 푼적이 있는 문제.
 * 2. 주사위 클래스를 만든 다음에 현재 위치와 각 면의 숫자를 보관한다
 * 3. 이어서 움직임에 따라 고려해야할 3가지 요소를 구현한다
 * 4. 첫째, 이동 방향에 따라 주사위의 현재 위치를 변경한다. 단 좌표크기를 벗어나는 경우 무시하고 출력하지 않도록 한다
 * 5. 둘째, 주사위의 면을 움직인다
 * 6. 셋째, 현재 좌표의 값이 0일 경우와 아닐 경우를 구분해서 값을 변경하는 로직을 구현한다
 * 7. 이것을 각 order에 맞춰서 구현하고, 그때의 주사위 윗면을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */
class Dice{
    int nowY;
    int nowX;
    int[] diceNum;
    Dice(int nowY, int nowX){
        this.nowY = nowY;
        this.nowX = nowX;
        diceNum = new int[6];
    }
}


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] order = new int[k];
        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice(startY, startX);
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            int a = dir(order[i], dice, n, m, arr);
            if(a == 1){
                bw.write(dice.diceNum[0]+"\n");
            }
        }


        br.close();
        bw.close();
    }

    private static int dir(int d, Dice dice, int n, int m, int[][] arr){
        switch (d){
            case 1:
                if(dice.nowX + 1 < m){
                    dice.nowX++;
                }else{
                    return 0;
                }
                rotates(dice, d, n, m);
                solve(dice, arr, arr[dice.nowY][dice.nowX]);
                break;
            case 2:
                if(dice.nowX - 1 >= 0){
                    dice.nowX--;
                }else{
                    return 0;
                }
                rotates(dice, d, n, m);

                solve(dice, arr, arr[dice.nowY][dice.nowX]);
                break;
            case 3:
                if(dice.nowY - 1 >= 0){
                    dice.nowY--;
                }else{
                    return 0;
                }
                rotates(dice, d, n, m);
                solve(dice, arr, arr[dice.nowY][dice.nowX]);
                break;
            case 4:
                if(dice.nowY + 1 < n){
                    dice.nowY++;
                }else{
                    return 0;
                }
                rotates(dice, d, n, m);
                solve(dice, arr, arr[dice.nowY][dice.nowX]);
                break;
        }
        return 1;
    }

    private static void rotates(Dice dice, int d, int n, int m) {
        int[] tmp = dice.diceNum.clone();
        switch (d){
            case 1:
                dice.diceNum[0] = tmp[3];
                dice.diceNum[3] = tmp[5];
                dice.diceNum[5] = tmp[2];
                dice.diceNum[2] = tmp[0];
                break;
            case 2:
                dice.diceNum[0] = tmp[2];
                dice.diceNum[3] = tmp[0];
                dice.diceNum[5] = tmp[3];
                dice.diceNum[2] = tmp[5];
                break;
            case 3:
                dice.diceNum[0] = tmp[4];
                dice.diceNum[1] = tmp[0];
                dice.diceNum[5] = tmp[1];
                dice.diceNum[4] = tmp[5];
                break;
            case 4:
                dice.diceNum[0] = tmp[1];
                dice.diceNum[4] = tmp[0];
                dice.diceNum[5] = tmp[4];
                dice.diceNum[1] = tmp[5];
                break;
        }
    }

    private static void solve(Dice dice, int[][] arr, int now){
        switch (now){
            case 0:
                arr[dice.nowY][dice.nowX] = dice.diceNum[5];
                break;
            default:
                dice.diceNum[5] = arr[dice.nowY][dice.nowX];
                arr[dice.nowY][dice.nowX] = 0;
        }
    }

}

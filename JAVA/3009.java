import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 규칙을 발견하였다. x좌표와 y좌표를 입력 받아 배열에 넣는다.
 * - 이때 각 좌표집합에는 같은 숫자 쌍이 2개 있어야한다.
 * - 따라서 입력받은 3개의 수를 비교하여 쌍이 안되는 숫자를 찾고 그것을 정답으로 출력한다
 *
 * 시간복잡도: O(1) -> for문 있는데... 3번 도는게 끝이라서 그냥 상수 취급했습니다
 * 공간복잡도: O(1) -> 배열이긴 한데.. 3*2라서 그냥 상수 취급했습니다
 *
 *
 */




public class Main {

    //    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] arr = new int[3][2];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int x;
        int y;
        if(arr[0][0] == arr[1][0]){
            x = arr[2][0];
        }else{
            if(arr[0][0] == arr[2][0]){
                x = arr[1][0];
            }else{
                x = arr[0][0];
            }
        }

        if(arr[0][1] == arr[1][1]){
            y = arr[2][1];
        }else{
            if(arr[0][1] == arr[2][1]){
                y = arr[1][1];
            }else{
                y = arr[0][1];
            }
        }

        bw.write(x + " " + y);

        br.close();
        bw.close();
    }


}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 큰수부터 차례대로 몫을 배열에 저장하고 그 몫과 수를 곱한 값을 거스름돈에서 빼준다
 * - 마지막에는 남은 돈을 그대로 배열에 넣고 배열을 모두 출력한다.
 *
 *
 * 시간복잡도: O(n) 배열 순환은 4번 고정이라 상수시간으로 제외
 * 공간복잡도: O(n) 배열은 4개라서 그냥 무시함
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int change = Integer.parseInt(br.readLine());
            int[] arr = new int[4];
            arr[0] = change/25;
            change -= 25*arr[0];
            arr[1] = change/10;
            change -= 10*arr[1];
            arr[2] = change/5;
            change -= 5*arr[2];
            arr[3] = change;
            for(int j=0; j<4; j++){
                bw.write(arr[j] + " ");
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }


}

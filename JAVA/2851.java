import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 누적합 알고리즘 학습 후 연습 목적으로 풀었습니다.
 * - 각 배열 인덱스에 값을 입력하고 처음을 제외하고서 이전 값을 현재 인덱스에 더해준다
 * - 100에 가깝게 만들기 위해 100-ans의 절댓값보다 100-mushroom[i]의 절댓값이 더 작거나 같은 경우 ans에 mushroom[i]값을 넣어준다
 * - 이렇게 완성한 ans를 출력한다.
 * 
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] mushroom = new int[10];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
            if(i!=0){
                mushroom[i] += mushroom[i-1];
            }

            if(Math.abs(100-ans) >= Math.abs(100 - mushroom[i])){
                ans = mushroom[i];
            }

        }



        bw.write(String.valueOf(ans));


        br.close();
        bw.close();
    }
}

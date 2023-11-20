import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 소수 판별법만 알면 된다
 * - 합성수가 아닌 것들은 소수이다
 * - 구하고자 하는 값의 sqrt값 만큼까지 각 수로 나눴을 때, 나머지가 0인 경우가 존재하면 그것은 합성수이다 (단 1은 무조건 예외)
 * - 위 로직을 참고해서 최종 값들을 출력한다
 *
 * 시간복잡도: O(n*sqrt(n))
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int first = 0;


        for(int i=m; i<=n; i++){
            int check = 0;
            int sqrtN = (int)Math.sqrt(i);
            if(i == 1){
                continue;
            }
            if(i != 2 && i % 2 == 0){
                continue;
            }
            for(int j=3; j<=sqrtN; j++){
                if(i % j == 0){
                    check = -1;
                    break;
                }
            }
            if(check == 0){
                sum += i;
                if(first == 0){
                    first = i;
                }
            }

        }
        if(first == 0){
            bw.write(-1 + "");
        }else{
            bw.write(sum + "\n" + first);
        }


        br.close();
        bw.close();
    }


}

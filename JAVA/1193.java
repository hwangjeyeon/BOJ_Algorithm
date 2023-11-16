import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 지그재그로 도는 규칙을 알면 쉽게 풀 수 있다.
 * - 먼저 현재 분모 또는 분자의 최대 숫자를 확인한다.
 * -> 1부터 시작해서 입력한 숫자에서 뺐을 때, 0보다 작아지는 경우의 숫자가 최대 숫자가 된다
 * - 이 최대 숫자가 짝수냐 홀수 냐에 따라 분모와 분자의 배치를 뒤바꿔서 초기화하면 된다
 * 짝수는 왼쪽이 작고 오른쪽이 큰 부분부터 증감이 시작하며, 홀수는 왼쪽이 크고 오른쪽이 작은부분부터 증감이 시작한다
 * 이 규칙으로 최대숫자가 될때까지 뺴준 남은 입력값만큼 증감 방향대로 순회하여, 최종 정답을 출력한다
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        while(true) {
            if(n-i <= 0){
                break;
            }
            n = n-i;
            i++;
        }
        // 7일경우 i는 3
        int mom = 0;
        int child = 0;
        if(i%2 == 0){
            mom = 1;
            child = i;
            for(int j=1; j<n; j++){
                mom++;
                child--;
            }
        }

        if(i%2 == 1){
            mom = i;
            child = 1;

            for(int j=1; j<n; j++){

                mom--;
                child++;
            }
        }


        bw.write(mom + "/" + child);

        br.close();
        bw.close();
    }


}

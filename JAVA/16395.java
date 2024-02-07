import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - DP를 이용하여 풀었다.
 * - 미리 2차원 배열을 선언해두고 1과 최대 위치인 30에는 1을 넣어준다
 * - 그 외에는 다음 점화식을 따른다.
 * - pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]; -> 내 이전 높이의 이전 인덱스 값 + 내 이전 높이의 현재 인덱스 값
 * - 이제 입력받은 좌표를 배열에 인덱스로 넣어서 출력하면 정답이 된다.
 * - 입력값이 작아서 그냥 모든 배열 값 다 구해놓고 했다. 시간복잡도 고려해야하면, 딱 입력값 까지만으로 끊어내면 시간을 더 아낄 수 있을 것이다.
 *
 * - 조합론이 알고리즘 분류로 들어가 있어서 관련 풀이를 찾아보았다
 * - 문제에 정답이 들어가 있었다.. ㅋㅋㅋ n-1Ck-1가 이항계수라고 주어져 있었다. 이것을 활용하면 된다.
 * - 피보나치 함수와 조합 함수를 활용하였다. (n-1)! / ((k-1)! * (n-k)!)을 해주면 된다.
 * - 이때 주의할 점이 int나 long으로는 오버플로우가 발생하므로 double형 반환타입을 지정해줘야한다.
 * - 또한 정답 형식에 맞춰서 제출하기 위해 String.format으로 소수점 자리를 잘라내어서 출력해야한다.
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    // 조합 공식으로 풀 경우
    /*static double factorial(int n){
        if(n == 0){
            return 1;
        }
        return n* factorial(n-1);
    }

    static double combination(int n , int k){
        return factorial(n-1) / (factorial(k-1)*factorial((n-k)));
    }*/

    static int[][] pascal = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 31; i++) {
            for (int j = 1; j <= i; j++) {
                if(j==1 || j==30){
                    pascal[i][j] = 1;
                }else{
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }

        bw.write(String.valueOf(pascal[n][k]));
        //조합공식으로 풀 경우
//        bw.write(String.format("%.0f",combination(n,k)));
        br.close();
        bw.close();
    }
}


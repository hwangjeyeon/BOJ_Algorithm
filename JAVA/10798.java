import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 빈 부분은 빈칸으로 입력받아 구분 지어둔다
 * - 이후 StringBuilder에 합칠 떄, 빈칸은 무시하고 빈칸이 아닌 경우만 append한다
 * - 완성된 StringBuidler를 출력한다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1) -> 5*15 크기의 배열이라서... 이게 n 값으로 주어진다면 n^2이 될 것이다
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] arr = new char[5][15];

        for(int i=0; i<5; i++){
            String line = br.readLine();
            for(int j=0; j<15; j++){
                if(j<line.length()){
                    arr[i][j] = line.charAt(j);
                }else{
                    arr[i][j] = ' ';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] != ' '){
                    sb.append(arr[j][i]);
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }


}

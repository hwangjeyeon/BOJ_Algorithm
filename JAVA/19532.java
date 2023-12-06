import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * - 1번 해결방법은 완전 탐색으로 푸는 방법이다.
 * - 시간복잡도 계산했을 떄, 주어진 입력값에서 시간초과가 발생하지 않는다
 * - 따라서 2중 for문으로 일치하는 값이 나올때까지 돌리면 된다
 *
 * - 또 다른 해결방법은 수학공식 가감법을 이용하는 것인데, 이것은 이후 다시 공부할 떄 적용해서 풀어볼 예정이다
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());


        for(int i=-999; i<=999; i++){
            for(int j=-999; j<=999; j++){
                if(a*i + b*j == c && d*i + e*j == f){
                    bw.write(i + " " + j);
                }
            }
        }


        br.close();
        bw.close();
    }


}

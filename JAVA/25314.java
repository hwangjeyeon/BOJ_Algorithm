import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 일단 최소 경시대회나 최대 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 4값 만큼은 long int를 출력해야하므로 빼주고, 해당 값을 4로 나눈 몫만큼 반복해서 long 을 출력하면 뒤에 long int를 출력하면 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int tmp = n-4;
        int ans = tmp / 4;
        for(int i=0; i<ans; i++){
            bw.write("long ");
        }
        bw.write("long int");

        br.close();
        bw.close();
    }

}

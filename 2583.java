import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * 해결방법:
 * 1. 첫번째는 int로 두번째는 string으로 받아서 string의 마지막부터 차례대로 첫번째 숫자와 비교한 값을 출력한다
 * 2. int s = 1;로 ans에 곱해주고, 그 뒤에 10씩 곱해줘서 최종 결과를 출력한다
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

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int ans = 0;
        int s = 1;
        for(int i=b.length()-1; i>=0; i--){

            int tmp = b.charAt(i) - '0';
            bw.write(a*tmp + "\n");
            ans += a*tmp*s;
            s*= 10;

        }
        bw.write(ans + "");
        br.close();
        bw.close();
    }

}

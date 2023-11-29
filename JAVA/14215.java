import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 *
 * 삼각형의 성질을 이용하여, 가장 큰 변의 길이가 나머지 변의 합보다 크거나 같을 수 없다는 조건으로
 * 만약 크거나 같을 경우 그만큼 빼주는 방식으로 최대 둘레의 길이를 구해 출력한다.
 *
 *
 * 시간복잡도: O(1)
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

        int max = Math.max(Math.max(a, b),c);

        if(max == a){
            if(b+c <= max){
                a -= (a-(b+c))+1;
            }
        }else if(max == b){
            if(a+c <= max){
                b -= (b-(a+c))+1;
            }
        }else if(max == c){
            if(a+b <= max){
                c -= (c-(a+b))+1;
            }
        }

        bw.write(a+b+c + "");

        br.close();
        bw.close();
    }


}

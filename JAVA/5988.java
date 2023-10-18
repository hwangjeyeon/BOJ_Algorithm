import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * 해결방법:
 * - 입력 최대값이 10^60이므로 기존 자료형에서는 해당 범위를 담을 수 없기에 BigInteger를 사용해서 푸는 문제이다.
 * - 해당 방법을 이용해서 나머지 연산을 통해 짝수, 홀수 여부를 판단한다
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 * 기타사항:
 * - BigInteger에 대해 복습해볼 수 있었던 좋은 문제
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            BigInteger tmp = new BigInteger(br.readLine());
            if(tmp.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){
                bw.write("even" + "\n");
            }else{
                bw.write("odd"+"\n");
            }
        }
        br.close();
        bw.close();
    }

}

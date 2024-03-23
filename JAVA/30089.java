import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 투포인터 방식
 * -> 실패
 * 2. 먼저 뒤집은 문자열을 하나 저장해둔다. 그리고 원본과 비교해서 같으면 그대로 출력한다
 * 3. 만약 다르면 원본 문자열에 뒤집은 문자열의 두번째 값부터 붙이고 비교한다. 이때 비교는 startsWith()로 하자
 * -> 실패
 * -> 참고로 startWith를 쓰려면 띄어쓰기가 존재해야한다.
 *
 * 문제 해결:
 * 1. 처음과 끝값을 비교하자 -> 투포인터 형식
 * 2. 양 끝을 비교해서 같지 않으면 start++를 해주자.
 * 3  앞에서부터 한칸씩 뒤로 가면서 뒤에서부터 읽은 값과 동일한 구간을 찾는다
 * 
 * -> 이 문제는 다시 풀 예정. 펠린드롬 유형의 핵심을 보여주는 문제인 것 같아 다시 풀고 정리해야겠다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuilder input = new StringBuilder(br.readLine());
            int start = 0;
            while(true){
                boolean isOk = true;
                for (int j = 0; j + start < input.length(); j++) {
                    if(input.charAt(j + start) != input.charAt(input.length() - j - 1)){
                        start++;
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    break;
                }
            }
            for (int j = start - 1 ; j >= 0 ; j--) {
                input.append(input.charAt(j));
            }
            input.append("\n");
            bw.write(input.toString());
        }
        
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 자바 람다와 스트림에 대해 공부할 수 있었던 좋은 기회
 * - IntStream.range(0, 끝)을 통해 정수형 범위 생성 가능
 * - .filter(j -> alphabet[j].contains(String.valueof(dial.charAt(finalI))로 조건문 대체 가능
 * - .findFirst로 filter로 걸러진 값 중 첫번째 출력하고 orElse(-3)으로 아닌 경우 값 반환 처리 완료
 * - int finalI = i로 Effectively Final 문제 해결 -> 익명 클래스 혹은 람다식에서는 참조하는 외부 지역 변수는 final로 선언되거나 Effectively Final이어야 함
 * ->람다캡처링으로 외부 변수를 복사하는데, 문제는 final 선언을 하지 않으면, 이것이 최신의 값이라는 보장을 할 수 없기 떄문이다.
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String dial = br.readLine();
        int ans = 0;
        String[] alphabet = {"ABC", "DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        for(int i=0; i<dial.length(); i++){
            int finalI = i;
            ans += 3 + IntStream.range(0, alphabet.length)
                    .filter(j -> alphabet[j].contains(String.valueOf(dial.charAt(finalI))))
                    .findFirst()
                    .orElse(-3);
        }

        bw.write(ans+ "");
        br.close();
        bw.close();
    }

}

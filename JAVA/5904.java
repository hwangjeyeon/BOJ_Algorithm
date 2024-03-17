import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 재귀
 * 1. 함수식: moo(바로 직전까지 완성된 moo 문자열, 직전짜기 완성된 moo 문자열 전체 길이, 현재 k, n)
 * 2. base Condition: 직전짜기 완성된 moo 문자열 전체 길이보다 크면 문자열에서 해당 n번째 위치에 있는 수 StringBuilder에 저장
 * 3. 재귀식: moo(현재 완성된 moo 문자열, 현재 완성된 moo 문자열 전체 길이, 현재k+1, n)
 * => 메모리 초과 발생
 *
 * 문제 해결:
 * - 문자로 하니까 메모리초과가 발생한다. 최소 크기 범위로 생각을하자 가장 작게 조개지는 경우가 moo, 즉 3개인 점을 이용하자
 * - 또한 구조가 왼쪽 오른쪽에 직전 문자가 붙고 가운데에 k+2개의 o가 붙은 moo가 붙는다
 * 1. 함수식 moo(찾고자 하는 위치)
 * 2. base Condition n이 1이거나 3보다 작거나 같은 경우 -> s(0)일때 moo로 제일 작은크기는 3이다.
 * 3. 재귀식: moo(찾는 위치 - 현재 문자열 크기 + 직전 문자열 크기) -> 현재 문자열 크기 - 직전 문자열 크기 +1 <= 찾는 위치
 * 그 외에는 찾는 위치 == 직전 문자열 크기 + 1 -> m이 정답 재귀식 조건과 옆 조건이 아니면 o가 정답 -> 재귀식 조건은 새롭게 추가되는 문자열 전에 있는 경우고 나머지는 새롭게 추가되는 문자열 안에 찾는 위치가 있는 경우이다.
 *
 * 점화식:
 * - 그다음 문자 크기 = 현재 문자 크기*2 + 현재의 k+4
 * - 직전 문자 크기 = (현재 문자 크기-k-3)/2
 *
 * - 점화식을 뽑아내야지 풀 수 있는 문제라 생각보다 어려웠던 것 같다.. 재귀식 도출은 쉬웠으나 점화식 도출이 쉽지 않아 고전했던 문제이다
 * - 이제 재귀에대해 점점 익숙해져 가는데, 이런 골드 난이도의 재귀 활용 문제를 더 풀면서 재귀에 대해 더 익숙해지도록 학습할 계획이다.
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 *
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        moo(n);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void moo(int n) {
        int size = 3;
        int index = 0;
        if(n == 1){
            sb.append("m");
        }else if(n <= 3){
            sb.append("o");
        }else{
            while(size < n){
                size = size*2 + index+4;
                index++;
            }
            int last = (size-index-3)/2;

            if(size-last + 1 <= n){
                moo(n-size+last);
            }else if(n == last + 1){
                sb.append("m");
            }else{
                sb.append("o");
            }

        }
    }

}

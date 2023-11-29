import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * MenOfPassion(A[], n) {
 *     i = ⌊n / 2⌋;
 *     return A[i]; # 코드1
 * }
 * - 뭔소리하는지 이해를 못해서 검색했습니다...ㅎㅎ
 * - 검색해보니 이 문제는 시간복잡도에 대해 공부하는 문제로 해당 함수가 주어졌을 때, 그 함수의 시간복잡도를 생각해서 풀면 되는 문제더라구요
 * - 먼저 처음으로 출력되는 값은 무조건 1입니다. 함수 실행되면 연산 한번하고 그 배열 반환하는게 끝이라서 1입니다
 * - 또한 시간복잡도가 O(1)이 나오기 떄문에 최고차항은 0이 됩니다 만약 O(n)이라면 1이 될 것 같네요
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
        int n = Integer.parseInt(br.readLine());
        bw.write(1 + "\n" + 0 + "");
        br.close();
        bw.close();
    }


}

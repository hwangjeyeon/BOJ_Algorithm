import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 1부터 9까지 경우의 수를 모두 확인해보았을 때, 제곱수에서 값이 증가하는 것을 확인할 수 있다
 * - 따라서 입력받은 n의 sqrt값을 정답으로 출력한다
 * - 다른 풀이를 찾아보니 약수의 개수가 홀수인 경우 열고-닫고-열고를 진행해서 마지막에 열려있는다고 한다
 * - 짝수면 열고-닫고이다.
 * - 따라서 약수의 개수가 홀수인 경우 값이 증가하게 되고 이런 경우는 제곱수밖에 없다.
 *
 * 참고 풀이: https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-13909-%EC%B0%BD%EB%AC%B8-%EB%8B%AB%EA%B8%B0-JAVA
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        count = (int) Math.sqrt(n);

        bw.write(count + "");

        br.close();
        bw.close();
    }


}

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 예제를 통해서 규칙을 찾아내거나, 혹은 정수론의 약수 규칙에 대해서 알고 있으면 풀 수 있는 문제이다
 * - 어떤 수의 1과 자신을 제외한 모든 약수가 주어졌을 때, 최소값과 최대값을 곱하면 그 수가 정답이 된다.
 * - 따라서 들어온 입력값을 오름차순 한 뒤, 최소값과 최대값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<n; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        bw.write(numbers.get(0) * numbers.get(n - 1) + "");

        br.close();
        bw.close();
    }
}

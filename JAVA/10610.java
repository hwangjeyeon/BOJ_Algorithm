import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 각 잘수의 합이 3의 배수이면 3의 배수라는 것을 알아 풀 수 있는 문제입니다
 * 2. 가장 큰 수는 각 자리수를 정렬하고 정렬하고난 후 3의 배수인지 판별하고나서 출력해주면 된다
 * 3. 주어진 숫자를 오름차순으로 정렬하고 맨 끝원소부터 0번까지 탐색한 뒤 각 원소를 전부 더합니다
 * 4. 각 원소를 전부 더한 값 % 3 == 0인 경우와 0번 인덱스의 값이 0인 경우 출력한다
 * 5. 4번의 경우 각각 3의 배수인겨우와 30의 배수인 경우다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if(sum % 3 != 0 || arr[0] != '0'){
            sb = new StringBuilder();
            sb.append("-1");
        }

        bw.write(sb.toString()+"\n");
        
        br.close();
        bw.close();
    }

}

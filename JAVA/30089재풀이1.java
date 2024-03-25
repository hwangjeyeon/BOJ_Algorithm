import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 어느 지점부터 입력 문자열의 뒤에 append해야 펠린드롬 형태가 되는지 알아야한다.
 * 2. 따라서 이중포문을 통해 안쪽 순회에서 앞과 뒤를 비교해서 같지 않은 경우를 찾는다.
 * 3. 찾는 경우 바깥쪽 순회를 종료시키는 boolean을 false로 바꿔주고 안쪽 순회를 종료한다
 * 4. 이중 포문에서 바깥쪽 순회인 j의 역할은 문자열의 어느지점까지 펠린드롬 형태가 아닌가를 표시하는 기준점이다
 * 5. 안쪽 포문에서 find가 true로 바뀌면 그 지점-1부터 0까지 input 문자열에 append해준다
 * 6. 안쪽 포문에서는 기준이 되는 지점 j + 현재 순회 k의 문자열과 맨뒤 문자열인 길이 - 1 - k를 비교하여 같은지 다른지를 판단한다.
 * 7. 다르면 j가 순회를 통해 앞으로 이동하므로 원하는 결과를 얻을 수 있게 된다.
 *
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(T*input.length() * input.length())
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder input = new StringBuilder(br.readLine());
            boolean find;
            for (int j = 0; j < input.length(); j++) {
                find = true;
                for (int k = 0; j+k < input.length(); k++) {
                    if(input.charAt(j+k) != input.charAt(input.length()-1-k)){
                        find = false;
                        break;
                    }
                }
                if(find){
                    for (int k = j-1; k >= 0; k--) {
                        input.append(input.charAt(k));
                    }
                    break;
                }
            }
            input.append("\n");
            bw.write(input.toString());
        }

        br.close();
        bw.close();
    }

}


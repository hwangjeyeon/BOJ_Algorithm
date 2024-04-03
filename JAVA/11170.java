import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 그냥 테스트케이스마다 주어진 시작점과 끝점까지 각 수를 문자열로 바꾼다음에 그 길이만큼 탐색해서 0인경우 count를 증가시킨다
 * 2. 각 테스트케이스마다 count를 출력하면 정답이 된다.
 * 3. 시간초과를 고려해야하는데, T*각 n~m사이의 문자열의 길이이므로 최대가 100000이니까 7정도이므로 T 입력 최대값이 20인상황에서 시간초과는 발생하지 않는다.
 * 
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T*(N~M의 문자열 길이)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = start; j <= end; j++) {
                String s = String.valueOf(j);
                for (int k = 0; k < s.length(); k++) {
                    if(s.charAt(k) == '0'){
                        count++;
                    }
                }
            }
            bw.write(count+"\n");

        }

        br.close();
        bw.close();
    }
}


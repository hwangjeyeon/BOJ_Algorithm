import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀
 * 1. 함수식: lotto(number, 현재 뽑은 개수, 뽑는 숫자 시작 위치(start))
 * 2. base condition: 현재 뽑은개수 == 6
 * 3. 재귀식: lotto(number, 현재뽑은개수 + 1, i+1)
 *
 * 1. 방문배열을 사용해서 중복으로 뽑지 않도록 한다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static StringBuilder sb;
    static int[] pick;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0){
                break;
            }else{
                int[] number = new int[n];
                sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    number[i] = Integer.parseInt(st.nextToken());
                }
                pick = new int[6];
                visited = new boolean[n];
                lotto(number, 0, 0);
                sb.append("\n");
                bw.write(sb.toString());
            }

        }
        br.close();
        bw.close();
    }

    private static void lotto(int[] number, int count, int start) {
        if(count == 6){
            if(pick.length == 6){
                for (int i = 0; i < 6; i++) {
                    sb.append(pick[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                pick[count] = number[i];
                lotto(number, count+1, i+1);
                visited[i] = false;
            }
        }
    }

}


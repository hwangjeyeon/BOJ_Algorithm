import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식: backtracking(n,m,depth)
 * 2. base condition: m == depth
 * 3. 재귀식: backtracking(n,m,depth+1)
 *
 * 1. 입력값을 배열에 저장하고, 오름차순으로 정렬한다
 * 2. 이어서 함수를 실행하는데 재귀함수 실행 내에서는 상관없으나 같은 반복문 내에서 중복이 불가능하므로 before 함수를 이용한다
 * 3. 재귀함수 내에서 이전 단계에서 이미 탐색을 해도 출력가능하므로 방문배열은 필요없다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] input;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[m];
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backtracking(n,m,0);


        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void backtracking(int n , int m , int depth){
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < n; i++) {
            if(before != input[i]){
                before = input[i];
                arr[depth] = input[i];
                backtracking(n,m,depth+1);
            }
        }


    }
}


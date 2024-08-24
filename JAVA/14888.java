import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. n의 최대 입력값이 11이며, 연산자 우선순위를 무시한다는 점에서 백트래킹으로 쉽게 풀 수 있겠다고 생각하였다
 * 2. 문자열로 누적한 다음 마지막에 파싱해서 할까 했는데, 그것보다는 그냥 재귀식마다 풀어서 더하는 것이 더 편하겠다고 생각하고 그렇게 설계하였다
 * 3. 각 연산자의 개수도 파라미터로 같이 넘겨주어서 재귀식마다 그 이전 결과가 누적되도록 하였다
 * 4. 배열의 첫 숫자를 sum에다가 초기값으로 넘겨주며, 각 연산자 개수가 0이 아니라면 백트래킹으로 각 연산의 결과를 sum에 넘겨준다
 * 5. 이때 연산자의 개수도 각각 감소시켜서 넘겨준다
 * 6. 이어서 depth가 n-1이 되었을 때, 최솟값과 최댓값을 갱신해준다
 * 7. 완성한 결과를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(4^n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(n, 0, arr[0], operator[0], operator[1], operator[2], operator[3]);

        bw.write(max+"\n");
        bw.write(min + "");

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int depth, int sum, int plus, int minus, int multiply, int divide) {
        if(depth == n-1){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }


        if(plus != 0){
            backtracking(n, depth+1, sum + arr[depth+1], plus-1, minus, multiply, divide);
        }

        if(minus != 0){
            backtracking(n, depth+1, sum - arr[depth+1], plus, minus-1, multiply, divide);
        }

        if(multiply != 0){
            backtracking(n, depth+1, sum * arr[depth+1], plus, minus, multiply-1, divide);
        }

        if(divide != 0){
            backtracking(n, depth+1, sum / arr[depth+1], plus, minus, multiply, divide-1);
        }

    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 문제들과 크게 다를 것이 없는 문제이다.
 * - 한가지 솔루션은 중복되는 수열을 여러번 출력하지 않게 한다는 점과 입력 값에 중복으로 숫자가 들어간다는 것을 눈여겨 보면 된다.
 * - Set을 input에 쓸 수는 없다. 예제 3번을 만족시키지 않는다.
 * - 문제 해결의 핵심은 각 수열의 이전 depth 한번 사용한 input은 현재 depth에서 사용하면 안된다.
 * - 즉 재귀로 돌아왔을 때는 상관 없으나 반복문으로 돌아왔을 때는 중복되면 안된다.
 * - 이때 중복의 기준은 숫자를 기준으로 하는 것이 아니라 input의 값의 개수를 기준으로 한다.
 * - 따라서 before 변수를 선언해준다. 반복문 밖에서 0으로 초기화해서 선언해준다
 * - 반복문 안에서는 기존에 사용하던 로직과 재귀함수를 before != input.get(i) 조건을 통과하는 경우만 동작하게 한다
 * - 이렇게 하면 재귀로 돌아왔을 때는 다시 before변수가 0으로 초기화되면서, 이전 값에 영향을 받지 않고 반복문만 영향 받게 된다.
 * - 이렇게 완성한 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static int[] input;
    static int[] ans;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        ans = new int[m+1];
        sb = new StringBuilder();
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backTracking(n,m, 0);
        
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans[i])
                        .append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }

            if(before != input[i]){
                visited[i] = true;
                ans[depth] = input[i];
                before = input[i];
                backTracking(n,m,depth+1);
                visited[i] = false;
            }
        }

    }

}

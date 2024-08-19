import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹으로 문제를 풀 수 있겠다고 생각하였다
 * 2. 종료조건은 모든 영양소가 목표 범위를 넘어서는 경우다
 * 3. 최소 가격을 찾기 위해 ans를 하나 선언하고, 선택된 번호를 저장하기 위해 리스트를 하나 선언하였다
 * 4. visited를 이용하여, 모든 경우를 선택한지만 중복 선택은 막는 방법으로 백트래킹을 진행하였다
 * 5. 백트래킹에서 순서 리스트를 문자열 더하기로 추가해주었다.
 * 5. 이후, list를 오름차순 정렬하고, 리스트가 비어있으면 -1을 출력하면 아니면 ans와 0번째 인덱스의 값을 출력하였다
 *
 * - 문제 해결:
 * 1. 하지만 이 시도에서 틀렸습니다를 계속 얻게 되었다.
 * 2. 틀린 이유는 두가지인것으로 추측되는데, 먼저 선택 안할 경우다
 * 3. 현재 것을 선택안할 수도 있다는 생각을 하지 못했고, 따라서 백트래킹 재귀를 두개로 선언해주어야한다
 * 4. 저절로 visited 테크닉은 사용할 수가 없다
 * 5. 이어서 문자열로 저장하는 방식에서 문제가 생긴 것 같다. 아마, 사전순 출력 때문에 오름차순 정렬에서 문제가 생겼을 것이다
 * 6. 문자 하나하나로 정렬을 하다보니 아마 사전순 정렬에서 꼬였을 것이고 그래서 틀린 것으로 추측된다
 * 7. 따라서 int 타입으로 받고 비트마스킹을 참고하여 해당 문제를 해결하였다.
 * 8. sum에 (i<<depth)을 더한(|)값을 누적해서 재귀로 넘겨준다
 * 9. 최종장에서 n이 depth일때, 모든 영양소 조건과 ans 최소 조건을 만족하면 n만큼 순회를 돌아서 sum에서 (1<<i)를 뺀(&) 값이 0이 아닌 경우 i+1한 값을 StringBuilder에 넣는다
 * 10. 완성한 StringBuilder를 우선순위 큐에 넣어도 된다
 * 11. 우선순위 큐를 쓰건 리스트를 쓰건 상관없다. 단지 정렬을 한번 더 안하냐 하냐 차이이다
 * 12. 이후 다시 메인에서 출력하면 정답이 된다.
 *
 * 시간복잡도: O(2^n)
 * 공간복잡도: O(n*5)
 *
 */

public class Main {

    static int[] need;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        need = new int[4];
        arr = new int[n][5];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
            arr[i][3] = d;
            arr[i][4] = e;
        }
        backtracking(0,0,0,0,0, 0, n, 0);

        if(pq.isEmpty()){
            bw.write("-1");
        }else{
            bw.write(ans+"\n");
            bw.write(pq.poll());
        }

        br.close();
        bw.close();
    }

    private static void backtracking(int a, int b, int c, int d, int price, int sum, int n, int depth) {

        if(n == depth){
            if(a >= need[0] && b >= need[1] && c >= need[2] && d >= need[3]) {
                if(ans >= price){
                    if(ans > price){
                        pq.clear();
                    }
                    ans = price;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        if((sum & (1 << i)) != 0){
                            sb.append((i+1) + " ");
                        }
                    }
                    pq.add(sb.toString());
                }
            }
            return;
        }



        backtracking(a+arr[depth][0],b+arr[depth][1],c+arr[depth][2],d+arr[depth][3],price+arr[depth][4], sum | (1 << depth), n, depth+1);
        backtracking(a,b,c,d,price, sum, n, depth+1);

    }

}


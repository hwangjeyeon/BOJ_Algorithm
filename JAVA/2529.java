import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 문제와 입력 크기를 봤을 때, 백트래킹과 브루트포스 방법을 활용하는 것이 최적의 선택이 된다
 * 2. 부등호는 char 타입의 arr배열에 저장해서 관리해준다
 * 3. 이 문제의 핵심은 선택된 숫자는 모두 달라야 한다는 점을 이용하여 boolean 타입의 방문배열을 선언하여 활용하는 것이다
 * 4. 브루트포스로 시작지점을 0부터 9까지로 탐색하며, 매 시작마다 방문 배열을 초기화해준다
 * 5. 현재 i를 방문 체크하고 dfs를 시작하며, dfs 종료하면 방문 체크를 지운다
 * 6. backtracking에서도 비슷한 방법으로 진행한다
 * 7. 0부터 10까지 순회를 돌면서 방문을 하지 않았다면 비교할 이전 문자열을 가져온다
 * 8. 이전 문자열은 파라미터로 가져온 문자열의 depth번째의 문자이다. 이 문자를 가져와서 int형으로 파싱하면 된다
 * 9. last와 i를 비교해서 arr[depth]에 있는 부등호의 조건에 해당되는지 확인한다. 만약 해당된다면 dfs를 돌려준다
 * 10. dfs를 돌릴 때는 브루트포스에서 하던 시작 값 이전 방문 체크와 종료 후 방문 체크를 지우는 행위를 똑같이 해준다
 * 11. depth가 k라면 list에 넣고 종료하면된다
 * 12. list는 지금까지 완성된 문자열을 관리하는 자료구조이다
 * 13. 0부터 9까지 순차적으로 매 함수마다 순회하며 체크하기 때문에 제일 먼저 들어가는 값은 최소값이 되고, 마지막에 들어가는 최댓값이 된다
 * 14. 따라서 최대값은 list.size-1에서, 최소값은 0번째 인덱스에서 가져와서 출력하면 정답이 된다.
 * 
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(10!)
 * 공간복잡도: O(10! * 10)
 *
 */

public class Main {

    static char[] arr;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
         arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            backtracking(0, k, String.valueOf(i));
            visited[i] = false;
        }

        bw.write(list.get(list.size()-1) + "\n");
        bw.write(list.get(0)+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int k, String s) {
        if(depth == k){
            list.add(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(visited[i]){
               continue;
            }
            int last = Character.getNumericValue(s.charAt(depth));
            if((arr[depth] == '>' && last > i) || (arr[depth] == '<' && last < i)){
                visited[i] = true;
                backtracking(depth+1, k, s + i);
                visited[i] = false;
            }
        }
    }

}

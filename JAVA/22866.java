import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 내 오른쪽으로 볼 수 있는 건물을 한번 탐색하고, 내 왼쪽을 볼 수 있는 건물을 한번 더 탐색해서 볼 수 있는 건물의 개수와 가장 가까운 건물의 번호를 구한다
 * 2. 건물의 개수와 번호를 관리할 배열을 두개 선언해준다. 이때, 번호를 관리할 배열의 초기값은 두번째 탐색에서 최솟값을 찾을 때, 방해되지 않도록 초기값을 나올 수 있는 입력값의 가장 작은 수인 100001로 초기화한다
 * 3. 스택을 활용하여, 바라볼 수 있는 건물의 넘버를 갱신해준다. 스택이 비어있지 않거나 배열의 스택 peek 위치의 값이 현재 i의 높이 값보다 작거나 같은 동안 스택을 빼준다
 * 4. 이어서 첫 탐색에서는 스택의 크기를 개수를 관리하는 배열에 넣어주고, 만약 0보다 크다면 위치를 보관할 ans에 stack의 peek값을 넣어준다. 그리고 현재 위치를 스택에 넣어준다
 * 5. 이제 반대로 끝에서부터 왼쪽으로 이동한다. 똑같이 while문으로 검증하며, 스택의 크기를 이번에는 건물의 개수를 관리하는 배열에 더해준다
 * 6. 이번에는 스택이 비어있지 않고, 스택의 peek에서 현재 위치인 i를 뺀 값이 현재위치인 i에서 ans 배열에 보관되어 있는 위치값보다 작다면 ans에 stack.peek를 넣어준다
 * 7. 절댓값이 필요없는데 맨 뒤에서 탐색하기 때문에 스택의 peek에서는 현재 위치보다 더 큰 값이 들어있을 것이고, ans 역시 앞에서부터 탐색하기 때문에 i보다 작은 값이 들어있을 것이기 때문이다
 * 8. 그리고 여기서 만약 입력의 최솟값중 최댓값으로 초기화하지 않으면 이전 탐색에서 값을 발견하지 못한경우 0으로 초기화될 것이고 그러면 거리가 1인 경우가 최소가 되어야하는데, 갱신되지 않는 문제가 발생한다
 * 9. 따라서 꼭 초기화를 해주어야한다. 이어서 현재 위치값을 똑같이 스택에 넣고 끝까지 탐색한다
 * 10. 이제 n만큼 순회하면서 출력을한다. 크기는 그대로 출력하고, 만약 크기가 0보다 크다면 가장 가까운 건물의 번호를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = new int[n];
        int[] tops = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans[i] = -100001;
        }

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            tops[i] = stack.size();
            if(tops[i] > 0){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            tops[i] += stack.size();
            if(!stack.isEmpty() && stack.peek() - i < i - ans[i]){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            bw.write(tops[i] + " ");
            if(tops[i] > 0){
                bw.write((ans[i]+1)+"");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 오큰수와 비슷한 문제이다. 오큰수와 같이 풀어주자. 스택과 배열 인덱스를 활용하여 쉽게 풀 수 있음을 알 수 있는 문제다!
 * 2. 각 개수를 저장해둘 count와 정답, 입력값을 보관할 배열을 각각 선언하자
 * 3. 스택도 하나 선언해서 이후 풀이를 준비하자
 * 4. n만큼 순회하면서 입력값을 arr에 넣어준다. 그리고 count에서 입력값 인덱스 위치에서 값을 증가시켜 개수를 세어주자
 * 5. 이제 다시 n만큼 순회하면서 오등큰수를 찾아준다
 * 6. 스택이 비어있지 않고, 현재 배열값의 인덱스에 해당하는 count의 값이 스택의 peek에 있는 인덱스에 해당하는 count의 값보다 큰 동안에 ans의 stack.pop() 위치에 arr[i]를 넣어준다
 * 7. 지금까지 자신의 오큰등수를 찾지 못하던 위치 인덱스 값들이 스택에 들어가 있을 것이고, 발견하게 되면 현재 인덱스의 arr값으로 바꿔주는 것이다
 * 8. 이후 스택에 현재 인덱스를 넣어준다
 * 9. 끝나고 나서 스택이 빌때까지 ans의 stack.pop()의 위치에는 오큰등수를 찾지 못했으므로 -1을 넣어주낟
 * 10. 이후 n만큼 순회를하며 ans의 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[1000001];
        int[] ans = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && count[arr[i]] > count[arr[stack.peek()]]){
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }


        br.close();
        bw.close();
    }

}


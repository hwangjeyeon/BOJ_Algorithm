import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 일단 배열과 리스트로는 시간초과 때문에 사용할 수 없고, 큐를 사용하기에는 으른쪽에 있으면서 가장 왼쪽에 있는 수를 찾기 까다롭다 따라서 스택을 활용하여 풀이가 가능하다
 * 2. 처음 값은 스택에 무조건 넣어준다
 * 3. 이어서 들어오는 값이 스택의 꼭대기 값보다 크면 스택의 값을 pop해주고 임시 스택에 들어오는 값을 넣어준다.
 * 4. 3번 과정을 스택의 꼭대기 값보다 작아질 때까지 반복한다.
 * 5. 3~4번 과정을 진행하면서, 만약 현재 스택이 비게 된다면 임시 스택에 있는 값을 하나씩 출력하고, 현재 값을 스택에 넣어준다.
 * 6. 또한 마지막 까지 순회했는데 아직 스택에 값이 남아 있으면 스택이 비어있지 않을 때까지 스택의 꼭대기에 있는 값을 pop해서 그 값을 기준으로 다시 3~4번 과정을 반복한다
 * 7. 이때 6번은 자기보다 큰 값을 발견하면 임시 스택에 자기 자신을 넣어준다.
 * 8. 6번 과정에서 비교할 때 스택이 비어있으면 -1을 임시 스택에 넣어준다
 * 9. 이후 만들어진 임시스택을 하나씩 pop해서 출력한다
 * 10. 마지막 수는 오른쪽이 없기 때문에 무조건 -1을 출력하기 위해 -1을 추가로 출력한다.
 * => 틀린 풀이
 *
 * 1. 오른쪽부터 수를 하나 뽑아와서 비교한다.
 * 2. 먼저 정답 스택에는 -1을 하나 넣어준다.
 * 3. 이어서 비교마다 pop을 두번씩 하는데, 만약 첫번째 값이 두번째 값보다 크면 첫번째 값을 정답 스택에 넣어준다.
 * 4. 만약 첫번째 값이 두번째 값보다 작으면 정답 스택에 있는 값을 가져와서 두번째 값과 비교한다. 정답 스택에 있는 값이 더 크면 정답 스택을 다시 정답 스택에 넣어주고 아니면 -1을 넣어준다.
 * 5. 위 4번 과정에서 만약 정답 스택이 비어있다면 그냥 -1을 넣어준다.
 * => 틀린 풀이
 *
 * - 문제 해결:
 * 1. 입력을 정답 배열에 받는다.
 * 2. 스택에 넣는 값을 입력 배열의 인덱스로 잡아서 넣어준다
 * 3. 첫번째 배열은 자기자신을 넣어야 하므로 스택에 0을 넣어준다
 * 4. 스택이 비어있지 않고, 스택 꼭대기에 있는 인덱스의 좌표에 해당하는 배열의 값이 현재 배열의 값보다 작으면 해당 스택의 꼭대기에 있는 입력값을 현재 입력값으로 대체한다
 * 5. 4번은 조건을 만족하는한 반복하며, 해당하지 않는 경우 현재 좌표를 스택에 넣는다
 * 6. 이어서 스택이 빌때까지 해당하는 좌표의 배열의 값은 -1로 하고 배열을 순회하면서 출력하면 정답이 된다.
 *
 *
 * - 배열과 그 인덱스를 스택에 넣는다는 것은 생각하지 못한 방법이었다.
 * - 힌트를 참고한 만큼 다시 풀때는 내 자력으로 풀 수 있도록 하자.
 * - 이 문제는 까다로웠던 문제였다. 이중 포문으로 접근하지 않으면서 스택을 활용하다보니 순서 정렬에서 애로사항이 많았던 문제였다
 * - 하지만 입력을 배열로 받고 그 좌표를 스택에 넣는 방식, 그리고 조건에 해당되면 그 좌표의 값을 변경 시켜주는 방식 덕분에 애로사항을 쉽게 해결해 주었다.
 * - 힌트에서 얻은 새로운 방법을 체득하고 이후 문제에서도 적용할 수 있도록 복습하자.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && input[stack.peek()] < input[i]){
                input[stack.pop()] = input[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            input[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(input[i] + " ");
        }

        br.close();
        bw.close();
    }

}


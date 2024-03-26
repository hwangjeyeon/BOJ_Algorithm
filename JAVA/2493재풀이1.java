import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이: 
 * 1. 값과 위치를 모두 관리해야할 배열과 인덱스만을 가지고 있을 스택을 선택하였다.
 * 2. 스택 하나만 사용해서 값을 넣고 관리하자니, 해당 위치를 알 수 있는 방법이 없고, 스택에 인덱스만 넣어서 관리하지니 값 비교가 안 되어서 로직 자체가 성립이 안 된다
 * 3. 스택은 로직을 진행하는데에만 집중하도록 하고 배열에서 값과 위치를 모두 관리하도록 하였다
 * 4. 먼저 입력값들을 모두 배열에 넣는다
 * 5. 이후 다시 순회하는데, 처음 값은 무조건적으로 앞 쪽에 아무것도 없어서 0이므로 StringBuilder에 0을 넣어준다
 * 6. 만약 스택이 비어있지 않고, 현재 위치의 값이 스택의 peek의 값보다 크면, 현재 위치에서는 스택의 peek값을 바라볼 수 없으므로 pop해준다
 * 7. 6번 while문이 종료되고나서 스택의 크기를 확인한다 비어있으면 현재 값 앞에 현재 값보다 큰 탑이 없으므로 0을 출력한다
 * 8. 만약 존재하면 현재 탑의 크기보다 큰 탑이 존재하므로 stack.peek()의 값을 인덱스로 하는 배열의 값을 가져와서 출력한다
 * 9. 이어서 배열에 현재 인덱스 값을 넣어주고 순회를 진행한다
 * 10. 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * - 문제 해결:
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
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;

        }

        for (int i = 0; i < n; i++) {
            if(i == 0){
                sb.append("0 ");
                stack.add(i);
                continue;
            }
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }else{
                sb.append(stack.peek() + 1).append(" ");
            }

            stack.push(i);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}


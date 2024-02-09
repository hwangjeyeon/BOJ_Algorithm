import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 스택을 활용하는 문제였다. 
 * - 로직 구상은 쉽게 했으나, 메모리 초과 문제로 고생을 했던 문제이다
 * - 처음에는 스택에 입력으로 들어오는 높이를 넣었다. 하지만 이렇게 했더니, 첫번째로 메모리 초과가 발생하였다 
 * - 이 문제를 해결하기 위해 메소드로 빼놨던 로직을 반복문 안으로 가져왔다. 아마 메소드마다 새롭게 생성하는 스택 인스턴스와 그 스택에 값을 위치만큼 넣었던 것이 문제가 아니었나 싶다
 * - 이어서 반복문으로 가져왔을 때, 출력 초과 문제가 발생하였다. 로직에 아마 문제가 있었던 것 같다
 * - 그래서 새롭게 낸 해결책이 스택에 위치를 넣는 것이었다. 어차피 비교할 때마다 쓰면 되기 때문에 스택에 위치를 넣어주는 방식으로 했더니 문제가 풀렸다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
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
                sb.append(stack.peek()+1).append(" ");
            }
            stack.add(i);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }


}


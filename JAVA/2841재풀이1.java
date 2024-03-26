import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 스택 배열을 사용하여 해결하였다.
 * 2. 스택 배열은 먼저 인스턴스를 배열 크기만큼 생성한 뒤, 순회를 통해 크기만큼 각 배열의 스택 인스턴스를 추가로 생성해주어야한다
 * 3. n만큼 순회를 하면서 입력을 받는다. line은 스택 배열의 인덱스로 활용한다.
 * 4. 스택이 비어있으면 해당 line에 pret을 push한다
 * 5. 비어있지 않으면 스택의 peek가 pret보다 작은지 확인한다 작으면 그대로 스택에 넣고 count++한다
 * 6. 작지 않으면 비어있지 않고 peek보다 큰 동안 손가락을 떼는 행위인 pop과 count++를 진행한다
 * 7. 그다음 만약 peek와 pret이 같다면 continue하고 그렇지 않다면 pret에 손가락으로 눌러야 하니까 스택에 push하고 count++한다
 * 8. 완성된 count를 출력한다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack = new Stack[n+1];
        for (int i = 0; i < n; i++) {
            stack[i] = new Stack<>();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());
            if(stack[line].isEmpty()){
                stack[line].push(pret);
                count++;
            }else{
                if(stack[line].peek() < pret){
                    stack[line].push(pret);
                    count++;
                }else{

                    while (!stack[line].isEmpty() && stack[line].peek() > pret){
                        stack[line].pop();
                        count++;
                    }
                    if(!stack[line].isEmpty() && stack[line].peek() == pret){
                        continue;
                    }
                    stack[line].push(pret);
                    count++;
                }
            }
        }
        bw.write(count+"");
        br.close();
        bw.close();
    }

}


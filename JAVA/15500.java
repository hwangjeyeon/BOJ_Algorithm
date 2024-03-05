import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 일반 하노이탑을 생각하는데 조건덕분에 더 쉬워져서 그냥 첫번쨰 장대와 두번째 장대를 스택으로 생각하고 풀었다.
 * 2. 현재 원하는 원판의 직경을 기준으로 pop하며 해당 직경이 0보다 큰 동안에 반복한다. 찾으면 1씩 감소시켜준다
 * 문제 해결:
 * 1. while문을 돌면서 해결하는데 if문 4개로 처리하니까 시간초과가 발생하였다.
 * 2. 시간초과가 왜 발생할까에 대해 생각을 해봤는데, 2번에서 1번으로 가는 불필요한 경우가 존재하고, 해당 장대에 현재의 n에 해당하는 장대가 없을 경우 굳이 탐색할 필요가 없는데 탐색하기 때문이라고 생각하였다
 * 3. 따라서 해당 스택에 원하는 값이 있는가를 먼저 조건으로 해주고 그다음 스택이 빌때까지 해당 장대를 검사하도록 하였다.
 * 4. stack도 contains를 활용할 수 있다는 점을 오늘 처음알게 되었다 ㅋㅋ
 * 5. 만약 찾는 직경과 같다면 원래 하려고 했던 작업을 모두 하고 break하고 아니라면 첫 장대나 두번째 장대로 옮겨 준다
 * 6. 그리고 한가지 더 신경써야하는데 조건마다 while문을 돌리므로 while문 안에서 조건에 해당할 경우 ans를 증가시켜준다
 * 7. 완성한 StringBuilder와 ans를 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> second = new Stack<>();
        int ans = 0;
        while(count > 0){
            if(stack.contains(count)){
                while(!stack.isEmpty()){
                    if(stack.peek() == count){
                        count--;
                        sb.append("1 3\n");
                        stack.pop();
                        ans++;
                        break;
                    }else if(stack.peek() != count){
                        second.push(stack.pop());
                        sb.append("1 2\n");
                        ans++;
                    }
                }
            }else if(second.contains(count)){
                while(!second.isEmpty()){
                    if(second.peek() == count){
                        count--;
                        sb.append("2 3\n");
                        second.pop();
                        ans++;
                        break;
                    }else if(second.peek() != count){
                        stack.push(second.pop());
                        sb.append("2 1\n");

                        ans++;
                    }
                }
            }


        }
        bw.write(ans + "\n");
        bw.write(sb.toString());

        br.close();
        bw.close();
    }


}

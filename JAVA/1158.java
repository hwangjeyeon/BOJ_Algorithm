import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 큐를 활용하면 쉽게 해결할 수 있는 문제다
 * 2. k번이 지나고 나서가아닌 k번째에 진행해야하므로 count를 1로 초기화한다
 * 3. ans 큐를 하나 선언하고 입력값을 관리하는 q가 비어있을 때까지 다음을 반복한다
 * 4. count랑 k가 같으면 count를 1로 초기화한다. 이어서 ans에 q의 값을 poll해서 넣어준다. 이후 continue한다
 * 5. 만약 같지 않다면 q의 맨앞을 poll해서 맨 뒤에 add한다
 * 6. 이어서 count값을 증가시킨다
 * 7. ans의 값을 형식에 맞춰 출력한다. 마지막 값만 양식을 다르게 출력해야하니 조건을 하나 더 추가하여 양식에 맞춰 출력하면 정답이 된다
 * 
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(n^k)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            q.add(i);
        }
        int count = 1;
        Queue<Integer> ans = new LinkedList<>();
        while(!q.isEmpty()){
            if(count == k){
                count = 1;
                ans.add(q.poll());
                continue;
            }
            q.add(q.poll());
            count++;
        }

        bw.write("<");
        while(!ans.isEmpty()){
            if(ans.size() == 1){
                break;
            }
            bw.write(ans.poll()+", ");
        }
        bw.write(ans.poll()+">");



        br.close();
        bw.close();
    }

}

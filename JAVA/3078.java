import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 처음 풀이과정은 자료구조를 여러개 사용하여, k만큼 넣고 비교하는 방법이었다
 * 2. 하지만 이 방법들은 메모리 초과와 시간초과가 발생하여 틀린 풀이가 되었다.
 *
 * 해결방법:
 * 1. 정말 놀라운 방법으로 해결할 수 있었다
 * 2. 바로 큐배열을 사용하는 것이다. 리스트 배열이나 스택 리스트는 여러 문제에서 봐왔지만 큐 배열을 사용하는 것은 이번이 처음인 것 같다
 * 3. 큐배열의 크기는 최대 문자 길이 + 1로 잡는다. 따라서 21의 크기를 갖도록 한다
 * 4. ans는 long 타입으로 안하면 오버플로우가 발생한다
 * 5. 입력 문자는 바로 길이를 계산하여 숫자로 바꿔준다
 * 6. 그 숫자를 인덱스로 하는 큐배열을 가지고 풀이 로직을 돌린다
 * 7. 만약 비어있다면 해당 큐 배열 인덱스에 현재 순위인 i를 넣어준다
 * 8. 비어 있지 않다면, 먼저 큐배열의 해당 인덱스가 비어있지 않고, 현재 순위인 i에서 해당 큐 배열의 처음 값을 뺀 값이 k보다 큰지 확인한다
 * 9. 이 의미는 k의 범위를 벗어나는지 확인하는 작업이다. 벗어나는 것들은 모두 poll해서 제거한다
 * 10. 이후 ans에 해당 큐 배열의 리스트 크기를 더해주고, 큐에 현재 인덱스를 넣어준다
 * 11. 완성한 ans를 출력하면 정답이 된다.
 * 
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
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer>[] q = new LinkedList[21];
        for (int i = 0; i < 21; i++) {
            q[i] = new LinkedList<>();
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int input = br.readLine().length();
            if (q[input].isEmpty()) {
                q[input].add(i);
            }else{
                while(!q[input].isEmpty() && i - q[input].peek() > k){
                    q[input].poll();
                }
                ans += q[input].size();
                q[input].add(i);
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }
}


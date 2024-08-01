import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 한 좌석마다 20개의 비트가 있다고 가정하고 풀면 쉽게 풀 수 있따
 * 2. 3번 4번 명령어 덕분에 비트마스킹 문제임을 파악할 수 있었다
 *
 * 해결방법:
 * 1. 1번부터 시작하기 때문에 0번째부터 시작하도록 초기값을 -1로 하자. 이후 입력값은 더하는 형태로 c에다가 넣는다
 * 2. 원소를 더할때는 arr[b] |= (1 << c), 뺄때는 arr[b] &= ~(1 << c)이다
 * 3. 마지막 사람이 앉아있는지 확인하기 위해 1 << 19, 그리고 ~을 통해 하차 이후 이 값과 arr[b]를 & 비트연산하여 앉아있는 좌석만을 나타내고, 이후 << 1을 통해 왼쪽으로 밀어준다
 * 4. 처음에 사람이 앉아있는지 확인하기 위해 1 >> 0, 그리고 ~을 통해 하차 이후 이 값과 arr[b]를 & 비트연산하여 앉아있는 좌석만을 나타내고, 이 후 << 1을 통해 오른쪽으로 밀어준다
 * 5. 중복을 제거하기 위해 Set을 사용하여 모든 배열을 조사하여 넣어주고 그 크기를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int c = -1;
            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                c += Integer.parseInt(st.nextToken());
                arr[b] |= (1 << c);
            }else if(a == 2){
                int b = Integer.parseInt(st.nextToken());
                c += Integer.parseInt(st.nextToken());
                arr[b] &= ~(1 << c);
            }else if(a == 3){
                int b = Integer.parseInt(st.nextToken());
                arr[b] = ((arr[b] & ~(1 << 19)) << 1);
            }else{
                int b = Integer.parseInt(st.nextToken());
                arr[b] = ((arr[b] & ~(1 << 0)) >> 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            set.add(arr[i]);
        }
        bw.write(set.size()+"");
        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 큐를 이용한 BFS로 풀면 되는 문제이다.
 * - 분기를 어떻게 나눌까, 처음 저장하는 값을 어떻게 할까에 대한 고민을 많이 했다.
 * - 처음 저장하는 값은 루트 노드인 a를 넣을까, 아니면 그 밑에 분기를 넣을까에 대한 고민을 했는데 내 선택은 a를 넣는 것으로 했다.
 * - 두번째로는 분기를 어떻게 나눌까에 대한 고민이다. 문제에 주어진 연산 분기는 두가지인데 이것을 각각 poll해야할지 아니면 하나씩 poll해야할지에 대한 고민을 했다.
 * - 하지만 BFS 탐색 알고리즘을 생각했을 때, 하나씩 poll하는게 BFS 탐색 알고리즘에 더 맞기 때문에 하나씩 poll을 하도록 했다.
 * - 그리고 이번에는 그래프와 다르게 트리 노드처럼 생각해야 했고 카운트를 어떻게 해야할지에 대한 고민이 컸다
 * - 결국 생각한 것은 depth당 count를 증가시키는 것이 맞다고 생각하였다. 어떤 분기가 선택되든 그 분기까지 오기까지의 깊이를 정답으로 하기 때문이다.
 * - 그래서 큐 사이즈를 변수로 담아서 그 사이즈만큼 그 자식 노드에 해당하는 모든 경우를 순회해서 큐에 담기로 했다.
 * - 순회할때마다 poll을 해서 비교를 하는데 만약 b랑 같다면 가능한 경우가 있는지 없는지 체크하는 isOk를 true로 바꿔주고 count를 증가시킨뒤 break해준다
 * - 만약 같지 않다면 각 분기별로 비교해서 b보다 작거나 같으면 큐에 넣어준다.
 * - 이렇게 순회가 끝난 뒤, isOk가 true이면 종료하고 아니면 count를 증가시켜서 큐가 빌때까지 반복한다.
 * - 이렇게 완성한 결과를 isOk가 true면 count를 StringBuilder에 넣어주고 아니면 -1을 넣어준다
 * - 이후 완성한 StringBuilder를 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void bfs(long a, long b){
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);
        long count = 0;
        boolean isOk = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long branch = queue.poll();
                if(branch == b){
                    isOk = true;
                    count++;
                    break;
                }
                if(branch * 2 <= b){
                    queue.add(branch * 2);
                }
                if(branch*10 + 1 <= b){
                    queue.add(branch * 10 + 1);
                }
            }
            if(isOk){
                break;
            }
            count++;
        }
        if(isOk){
            sb.append(count);
        }else{
            sb.append("-1");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bfs(a,b);
        bw.write(sb.toString());


        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 첫 입력값을 루트 노드로 잡는다
 * 2. 이어지는 입력값들의 연속된 값을 확인하며, 루트 노드 배열안으로 값을 넣어준다
 * 3. 다음 입력값이 연속된 값이 아니면, 기준 노드(루트 노드)의 자식 값을 모두 불러와서 큐에 넣어준다.
 * 4. 그리고 이어서 큐의 값을 하나 빼고, 기준으로 삼아준다. 그리고 입력값을 넣어준다.
 * 5. 다음 입력값이 연속된 값이라면 기준 노드에 넣어주고, 아니라면 해당 기준 노드의 자식값을 모두 큐에 넣어준다.
 * 6. 이렇게 큐배열로하나 만들어주고 BFS로 탐색한 후에, 해당 k 노드를 가지고 있는 값을 찾아 부모 값을 불러온 뒤, 그 부모값의 자식 노드들을 모두 ans에 더한다
 * 7. 물론 k 노드를 포함하는 경우는 ans 합산에서 제외한다
 * 8. 하지만 이 방법은 정답은 잘 나오나 메모리 초과 문제가 발생하였다
 *
 *
 * 해결방법:
 * 1. 해결방법으로 힌트를 얻은 것은 parent 배열만을 이용해서 푸는 것이다.
 * 2. 따로 노드를 만들어서 주어진 트리를 만들고 순회하는 방법은 메모리가 초과하기 떄문에 parent 배열만을 만들어서 부모 값만으로 문제를 해결하는 것이 키포인트다.
 * 3. k가 있는 인덱스를확인할 index 배열을 0으로 초기화해주고, 연속된 값 검사를 위한 last와 부모 인덱스를 구분할 pivot을 -1로 초기화한다
 * 4. 1~n을 순회하면서 k랑 같으면 index에 현재 i를 넣어주고 만약 연속된 값이 아니라면 pivot++한다
 * 5. 그리고 parent[i]에 pivot을 넣어 부모 노드인덱스를 넣어주고 last 도 갱신해준다
 * 6. 이제 index의 부모 노드인 parent[index]를 father에 넣고 그 부모노드인 grandfather 변수에 parent[father]를 넣어준다
 * 7. father이나 grandfather이 0이면 루트 노드이므로 둘다 0이 아닌 경우 1~n을 순회하면서 father과 parent[i]가 같지 않고, grandfather이랑 parent[parent[i]]는 같은 인덱스를 발견하면 ans를 증가시킨다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0){
                break;
            }

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] parent = new int[n+1];
            int index = 0;
            int last = -1;
            int pivot = -1;
            for (int i = 1; i < n+1; i++) {
                if(arr[i] == k){
                    index = i;
                }

                if(last + 1 != arr[i]){
                    pivot++;
                }
                parent[i] = pivot;
                last = arr[i];
            }
            int father = parent[index];
            int grandfather = parent[father];
            long ans = 0;
            if(father != 0 && grandfather != 0){
                for (int i = 1; i < n+1; i++) {
                    if(father != parent[i] && grandfather == parent[parent[i]]){
                        ans++;
                    }
                }
            }


            bw.write(ans+"\n");

        }

        br.close();
        bw.close();
    }
}


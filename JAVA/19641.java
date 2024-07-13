import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 연결된 노드들을 오름차순 정렬을 해주어야한다
 * 2. 또한 left와 right를 표현하기 위해 2차원 배열을 하나 만들어준다
 * 3. dfs로 root부터 탐색을 하는데, root와 탐색 순서를 나타내는 n을 파라미터로한다. 이때 root는 제일 처음이니 1을 넘겨준다
 * 4. node배열의 cur의 0번째는 left다 순회마다 n을 left에 넣어준다
 * 5. 이어서 연결된 node들을 보는데 만약 left가 0이 아니라면 부모 라는 의미이므로 0인경우 dfs를 재귀함수로 호출한다. 이때 연결된 노드인 i와 n+1 인자값을 넘겨준다
 * 6. 모든 연결된 노드들을 확인한 후에 node의 cur의 1번째를 n+1로 초기화한다. 이는 right를 의미한다. 루트노드의 left부터 쭉 내려가서 리프 노드의 left를 본 뒤 right로 올라오는 형식이기 때문이다. 
 * 7. return은 누적해주기 위해 n+1로 해준다.
 * 8. 완성한 결과를 출력하면 정답이 된다. 
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static List<Integer>[] list;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        list = new List[n+1];
        node = new int[n+1][2];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    break;
                }
                list[a].add(tmp);
                list[tmp].add(a);
            }
            Collections.sort(list[a]);
        }

        int root = Integer.parseInt(br.readLine());
        dfs(root, 1);

        for (int i = 1; i < n + 1; i++) {
            bw.write(i + " " + node[i][0] + " " + node[i][1] + "\n");
        }


        br.close();
        bw.close();
    }

    private static int dfs(int cur, int n) {

        node[cur][0] = n;
        for (Integer i : list[cur]) {
            if(node[i][0] == 0){
                n = dfs(i, n+1);
            }
        }
        node[cur][1] = n+1;
        return n+1;
    }


}


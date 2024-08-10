import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 터렛 문제를 풀어서 원에 대한 접근은 조금 쉽게 할 수 있었으나, 처음 잘못된 풀이로 자꾸 틀려서 애먹었던 문제다
 * 2. 이 문제의 해결 핵심은 중심 지점이 주어졌을 때, y값은 모두 같기 때문에 r만큼 왼쪽, 오른쪽 범위를 지정해서 리스트에 넣고 왼쪽 값을 정렬해서 그 다음 지점의 원이 똑같이 했을 때, 범위에 걸치는지를 판단해주면 된다
 * 3. 이때 만약 다음 값의 왼쪽이 현재의 왼쪽보다 크고, 현재의 오른쪽이 다음 값의 오른쪽보다 크며, 현재의 오른쪽이 다음의 오른쪽보다 작거나 같을 때 ans를 NO로 하고 break하면 된다
 * 4. n-1만큼 순회하고 만약 모두 통과한다면 초기값인 YES를 출력하면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


class Node{

    int x;
    int r;
    int left;
    int right;

    public Node(int x, int r, int left, int right) {
        this.x = x;
        this.r = r;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Node(x, r, x-r, x + r));
        }
        list.sort((o1, o2)->{
            return o1.left - o2.left;
        });
        String ans = "YES";
        for (int i = 0; i < list.size()-1; i++) {
            if((list.get(i).left <= list.get(i+1).left 
                    && list.get(i).right >= list.get(i+1).left 
                    && list.get(i).right <= list.get(i+1).right)){
                ans = "NO";
            }
        }
        bw.write(ans);

        br.close();
        bw.close();
    }
}


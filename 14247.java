import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 그리디하게 풀려고 처음에는 현재 나무중에서 가장 큰 값을 자르는 나무로 선정하려고 했다. 같은 나무를 여러번 자를 수 있기 때문이다
 * 2. 하지만 그러기에는 시간초과 문제도 발생하고 원하는 결과를 얻지 못한다
 * 3. 가장 그리디하게 푸는 방법은 성장속도가 느린 나무부터 자르는 것이다
 * 4. 배열의 요소가 주어질 때 두가지 필드 중 한가지만으로도 그리디하게 풀 수 있다는 것을 염두해두자
 * 5. 또한 해당 문제를 잘 보면 최대값이 int형 범위를 벗어난다 따라서 long타입으로 지정해주고 풀어야한다.
 * 6. 정답을 출력할 때 현재 나무의 길이 + (i*성장속도)를 통해 ans에 더해주고 이후 ans를 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Tree{
    int nowHeight;
    int growth;

    public Tree(int nowHeight, int growth){
        this.nowHeight = nowHeight;
        this.growth = growth;
    }

}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Tree[] tree = new Tree[n];

        int[] tmp1 = new int[n];
        int[] tmp2 = new int[n];
        for (int i = 0; i < n; i++) {
            tmp1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp2[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            tree[i] = new Tree(tmp1[i], tmp2[i]);
        }
        Arrays.sort(tree, Comparator.comparingInt(o -> o.growth));
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += tree[i].nowHeight + ((long) i * tree[i].growth);
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }



}


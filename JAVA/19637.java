import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중포문으로 풀면 시간초과가 발생하기 때문에, 칭호에 대해서 클래스 배열로 정리한 뒤, 인덱스 범위를 이분탐색해서 해결하는 문제다
 * 2. 칭호의 타입이 다르기 때문에 별도의 클래스를 만들어서 해당 클래스 타입의 배열로 관리해준다
 * 3. 양 끝점을 인덱스로 잡고, left <= right인 동안 이분탐색을 진행한다
 * 4. 만약 중간 지점의 num보다 입력으로 들어온 num이 크다면 left를 mid+1로 좁혀서 정답을 찾는다
 * 5. 작거나 같다면 해당 지점이 정답의 후보가 된다. 하지만 최선의 결과를 찾기 위해 right를 mid-1로 해주며, 일단 정답 후보이므로 ans에 갱신해준다
 * 6. 이분탐색 결과 완성된 칭호값인 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(m*logn)
 * 공간복잡도: O(n)
 *
 */
class Pair{
    String name;
    int num;

    public Pair(String name, int num) {
        this.name = name;
        this.num = num;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n-1;
            String ans = "";
            while(left <= right){
                int mid = (left + right) / 2;
                if(num > pairs[mid].num){
                    left = mid+1;
                }else{
                    right = mid - 1;
                    ans = pairs[mid].name;
                }
            }
            bw.write(ans+"\n");

        }

        br.close();
        bw.close();
    }

}


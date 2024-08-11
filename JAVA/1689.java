import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 
 * - 문제 해결:
 * 1. 스위핑 기법을 이용해서 해결할 수 있는 문제다
 * 2. 시작점과 끝점을 분리해서 각각을 리스트에 넣어준다
 * 3. 시작점은 시작점 위치와 1, 끝점은 끝점 위치와 -1을 넣어준다
 * 4. 이후 정렬을 하는데 위치를 기준으로 오름차순 정렬 후, 같다면 타입을 기준으로 오름정렬해준다
 * 5. 이후 값을 하나씩 가져오면서 누적합을 해준다. 해당 타입을 sum에 더해주며 ans에는 ans와 sum중 큰 값을 넣어준다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(2*n)
 *
 */

class Pair{
    int num;
    int type;

    public Pair(int num, int type) {
        this.num = num;
        this.type = type;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(a, 1));
            pairs.add(new Pair(b, -1));
        }
        pairs.sort((o1, o2)->{
            if(o1.num == o2.num){
                return o1.type - o2.type;
            }
            return o1.num - o2.num;
        });

        int ans = 0;
        int sum = 0;
        for (Pair pair : pairs) {
            sum += pair.type;
            ans = Math.max(ans, sum);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }
}


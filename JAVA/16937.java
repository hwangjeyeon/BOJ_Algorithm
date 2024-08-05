import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 먼저 주어진 자료를 정리하자
 * 2. H는 모눈종이의 높이, W는 모눈종이의 넓이이다
 * 3. N은 스티커의 개수, R은 주어진 스티커의 높이 C는 주이전 스티커의 넓이이다
 * 4. 해당 문제는 스티커를 두개만 골라서 모눈종이를 덮는 경우를 구하고 이중 두 스티커의 넓이가 가장 큰 경우를 정답으로 출력하는 문제다
 * 5. 문제의 목표를 보았을 때, 모눈종이를 한칸한칸 탐색하는 것이 아닌 그냥 두 스티커를 골라서 모눈종이의 높이나 넓이를 벗어나지 않는지 확인하고, 안 벗어난다면 max와 비교하여 더 큰 값을 넣는 방식으로 진행하면된다
 * 6. 즉 브루트포스 방법으로 해결할 수 있다. 하지만 브루트포스의 문제는 시간제한에 걸려서 시간 초과가 발생할 수 있다는 점이다.
 * 7. 시간복잡도를 계산해보자 O(n^2)이라는 시간복잡도가 나올 것이고, n의 최대값은 100이니 10000이라는 순회를 돌 것이다. 
 * 8. 보통 1억번 순회하는 경우가 1초라고 가정하므로 해당 방법은 브루트포스로 해결하여도 시간제한에 걸리지 않는 다는 것을 알 수 있다
 * 9. 이제 브루트포스를 이용하여 문제를 해결해보자!
 * 
 * 10. Pair이라는 클래스를 하나 만들어서 r과 c를 관리하도록 하였고, 리스트로 Pair를 보관하였다
 * 11. 이때 r과 c가 모두 각각 h와 w보다 작거나 같은동안만 입력받도록 하였다. 만약 크다면 그 스티커는 조건에 부합하지 않기 때문에 선택하지 않을 것이기 때문이다
 * 12. 이어서 문제를 살펴보면 한가지 조건이 더 있다. 스티커는 90도로 회전이 가능하다
 * 13. 그 이야기는 r과 c를 바꿔서 Pair 쌍으로도 보관할 수 있다는 점이다. 이 역시 c가 h보다 작거나 r이 w보다 작은 경우에만 리스트에 넣어주자
 * 14. max 변수를 0으로 초기화해서 하나 만들어주고 pairs.size()만큼 이중포문을 돈다.
 * 15. 중복 선택은 불가능하므로, j의 초기값은 i+1로 해주자
 * 16. i와 j의 r과 c를 각각 더해서 height와 width 변수에 넣어주고 모눈종이를 벗어나는지 체크하자. 둘다 벗어난다면 continue해준다
 * 17. 아니라면 max에 두 스티커 넓이의 합과 비교하여 더 큰 값을 넣어주자
 * 18. 이렇게 완성한 max를 출력하면 정답이 된다. 초기값을 0으로 설정하였기에 두 스티커를 붙일 수 없는 경우 0을 출력하라는 조건도 해결된다
 * 
 * 19. 첫 제출에서 틀렸다. 원인을 분석해보니, 입력할 때 90도 회전하는 경우도 같이 넣기 때문에 하나의 스티커가 회전만 된 상태로 두번 선택될 수 있다는 것을 알게 되었다
 * 20. 따라서 구분을 위해 Pair 클래스에 num이라는 구분 필드를 하나 추가하였다. 그리고 입력때 i를 넣어준다
 * 21. 앞선 모눈종이 범위를 벗어나는지 체크하는 조건에서 i와 j의 num이 같은지도 추가한다. 이때 or 연산으로 체크해야지 잘못된 결과를 낳지 않는다
 * 22. 이 조건을 추가하고 max를 출력하면 정답이 된다!
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(2*n)
 *
 */


class Pair{

    int r;
    int c;
    int num;

    public Pair(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(r <= h && c <= w){
                pairs.add(new Pair(r, c, i));
            }

            if(c <= h && r <= w && r != c){
                pairs.add(new Pair(c, r, i));
            }
        }

        int max = 0;
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i+1; j < pairs.size(); j++) {
                int height = pairs.get(i).r + pairs.get(j).r;
                int width = pairs.get(i).c + pairs.get(j).c;
                if(height > h && width > w || pairs.get(i).num == pairs.get(j).num) {
                    continue;
                }
                max = Math.max(max, (pairs.get(i).r * pairs.get(i).c + pairs.get(j).r * pairs.get(j).c));
            }
        }

        bw.write(max+"");

        br.close();
        bw.close();

    }

}

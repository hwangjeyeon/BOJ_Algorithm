import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시작지점을 잡고, 비교하는 작업을 수행하는 스위핑을 통해 풀 수 있는 문제다
 * 2. 확인해야하는 상태값이 3개이므로 class를 만들어서 관리한다
 * 3. 리스트에 모두 넣고, 시작지점을 기준으로 오름차순 정렬한다
 * 4. 다만 시작지점이 같은 경우, 끝지점이 더 큰 것을 기준으로 해서 범위 내에 포함되도록 내림차순 정렬을 한다
 * 5. 이제 하나씩 뽑은 뒤, 그 값을 담을 리스트를 하나 더 만들어준다
 * 6. 비교를 위한 초기값을 -1, -1, Integer.MAX_VALUE로 설정해서 절대 결과에 영향을 주지 않도록 한다
 * 7. 만약 tmp에 있는 값의 끝지점이 이번에 뽑은 route의 시작지점보다 작다면 tmp를 ans 리스트에 넣어주고 route로 교체해준 뒤 continue한다
 * 8. 아닌 경우, 현재 tmp.e를 route.e와 비교 해서 더 큰값으로 바꿉니다, c는 더 작은 값으로 바꾼다
 * 9. 이렇게 할 경우, 중복되는 영역에 대해 더 작은 값으로 합쳐지면서, e가 더 큰 영역으로 합쳐질 수 있다
 * 10. 이후 초기 쓰레기값을 제외한 크기를 출력한뒤, 1번째 인덱스부터 s,e,c를 한줄로 출력을 반복한다면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Route{
    int s;
    int e;
    int c;

    public Route(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Route> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Route(s, e, c));
        }

        list.sort((o1, o2) -> {
            if (o1.s == o2.s) {
                return o2.e - o1.e;
            }
            return o1.s - o2.s;
        });
        List<Route> ans = new ArrayList<>();
        Route tmp = new Route(-1, -1, Integer.MAX_VALUE);
        for (Route route : list) {
            if(tmp.e < route.s){
                ans.add(tmp);
                tmp = route;
                continue;
            }

            tmp.e = Math.max(tmp.e, route.e);
            tmp.c = Math.min(tmp.c, route.c);
        }
        ans.add(tmp);

        bw.write(ans.size()-1+"\n");
        for (int i = 1; i < ans.size(); i++) {
            bw.write(ans.get(i).s + " " + ans.get(i).e + " " + ans.get(i).c+"\n");
        }

        br.close();
        bw.close();
    }

}

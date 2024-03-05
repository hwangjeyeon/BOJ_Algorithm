import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. L을 기준으로 오름차순 정렬을 한다
 * 2. 순회하면서 H를 이제 비교하자
 * 3. 만약 스택이 비어있다면 H를 넣어준다
 * 4. 스택이 비어있지 않다면 현재 H를 비교한다. 만약 H가 스택의 꼭대기 H보다 작거나 같다면 무시하고 크면 ans에 (현재 W - 스택 W) * (현재 H - 스택 H)를 더해준다
 * 5. 이어서 해당 인스턴스를 스택에 넣어준다
 * => 틀린 풀이
 *
 *
 * 문제 해결:
 * 1. 4번 조건인 오목하게 들어간 곳이 없게 하기 위해서 가장 높은 높이를 찾고 각각 왼쪽과 오른쪽에서 탐색을 해야한다
 * 2. 왼쪽은 위 풀이 그대로 하면 된다. 가장 높은 높이까지 맨 왼쪽을 시작으로 오른쪽으로 높이가 증가하도록 넓이를 구하면 된다
 * 3. 오른쪽도 위 풀이처럼 한다. 가장 높은 높이까지 맨 오른쪽 높이를 시작으로 왼쪽으로 높이가 증가하도록 넓이를 구하면 된다.
 * 4. L을 기준으로 오름차순 정렬을 하고 가장 높은 높이를 구하는 과정을 해야한다.
 * 5. 이어서 왼 -> 오와 오 -> 왼 과정에서 만약 스택의 꼭대기랑 높이가 같아 그 부분이 들어가는 경우를 생각해야하는데 그런 경우 스택이 비어있지 않으므로 isOk를 통해 중복으로 계산되지 않게 하고
 * 그 가장 큰 높이의 값이 ans에 더해지도록 한다
 * 6. 추가로 높이가 같은 경우도 위 두방향에서 모두 포함해야한다. 왜 그럴까에 대한 생각을 해보았는데 가장 높이가 큰 경우와 같은 높이인 좌표가 더 있을 수도 있다는 것을 생각해보면
 * 이렇게 순회를 해야지 정답이 되겠다고 생각하게 되었다.
 * 
 * - 정렬과 한쪽 방향 탐색까지는 생각했지만 역방향 탐색과 가장 높은 높이로 구분 짓고, 같은 높이도 포함해야한다는 것은 생각치도 못한 부분이었다
 * - 다시 풀어볼때는 힌트없이 고민하면서 풀면서 문제에 대해 확실하게 이해하고 얻어갈 수 있는 부분을 체크해야겠다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */
class Floor{
    int L;
    int H;

    public Floor(int l, int h) {
        L = l;
        H = h;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Floor[] floor = new Floor[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            floor[i] = new Floor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Stack<Floor> s = new Stack<>();
        int ans = 0;
        Arrays.sort(floor, (o1,o2) -> {
            return o1.L - o2.L;
        });

        Floor max = new Floor(0,0);
        for (int i = 0; i < n; i++) {
            if(max.H < floor[i].H){
                max.L = i;
                max.H = floor[i].H;
            }
        }

        for (int i = 0; i <= max.L; i++) {
            if(s.isEmpty()){
                s.push(floor[i]);
            }else{
                if(s.peek().H <= floor[i].H){
                    ans += s.peek().H * (floor[i].L - s.peek().L);
                    s.pop();
                    s.push(floor[i]);
                }
            }
        }
        boolean isOk = false;
        if(!s.isEmpty()){
            ans += s.peek().H;
            isOk = true;
        }
        s.clear();
        for (int i = n-1; i >= max.L; i--) {
            if(s.isEmpty()){
                s.push(floor[i]);
            }else{
                if(s.peek().H <= floor[i].H){
                    ans += s.peek().H * (s.peek().L - floor[i].L);
                    s.pop();
                    s.push(floor[i]);
                }
            }
        }
        if(!s.isEmpty() && !isOk){
            ans += s.peek().H;
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }


}

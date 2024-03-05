import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 값이 들어올때마다 쌓이는 형태로 체크를 해야하므로 스택을 사용한다
 * 2. 일단 비어있으면 스택에 넣고 ans를 증가시킨다
 * 3. 만약 현재 스택에 있는 값보다 들어오는 값이 크면 해당 값을 스택에 넣고 ans를 증가시킨다
 * 4. 크지 않으면 스택이 비어있지 않거나 스택에 있는 값이 들어오는 값보다 큰 동안에 스택에 있는 값을 pop하고 ans 값을 증가시킨다
 * 5. ans를 출력하면 정답이 된다.
 *
 * 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        long ans = 0;
        Stack<Integer>[] s = new Stack[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Stack<>();
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int nowN = Integer.parseInt(st.nextToken());
            int nowP = Integer.parseInt(st.nextToken());
            if(s[nowN].isEmpty()){
                s[nowN].push(nowP);
                ans++;
            }else{
                if(s[nowN].peek() < nowP){
                    s[nowN].push(nowP);
                    ans++;
                }else{
                    while(!s[nowN].isEmpty() && s[nowN].peek() > nowP) {
                        s[nowN].pop();
                        ans++;
                    }
                    if(s[nowN].isEmpty() || s[nowN].peek() != nowP){
                        s[nowN].push(nowP);
                        ans++;
                    }
                }
            }

        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }


}

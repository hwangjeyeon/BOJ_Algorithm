import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 
 * 해결방법:
 * 1. broken과 more 배열을 하나씩 만든다. 이때 여분을 한개씩 더 가져왔으므로 boolean으로 가볍게 표현하였다
 * 2. 그냥 순회하면서 비교하면되는데 일단 자기자신이 가장 중요해서 자기자신이 broken일때 more에 해당되는지 체크해준다
 * 3. 이후 내 좌우를 비교하는데, 탐색을 왼쪽에서부터 진행하므로 무조건 우선순위를 내 왼쪽으로 한다. 내 왼쪽의 more을 먼저 체크해주고 그다음 없으면 오른쪽을 체크해주어야 틀리지 않는다.
 * 4. 마지막으로 broken의 true 수를 count해서 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] broken = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
        boolean[] more = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            more[Integer.parseInt(st.nextToken())] = true;
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(broken[i] && more[i]){
                more[i] = false;
                broken[i] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(broken[i]){
                if(i == 1){
                    if(more[i+1]){
                        broken[i] = false;
                        more[i+1] = false;
                    }
                }else if (i == n){
                    if(more[i-1]){
                        broken[i]= false;
                        more[i-1] = false;
                    }
                }else{
                    if(more[i-1]){
                        broken[i] = false;
                        more[i-1] = false;
                    }else if(more[i+1]){
                        broken[i] = false;
                        more[i+1] = false;
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(broken[i]){
                count++;
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }
}


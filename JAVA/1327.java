import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 뒤집어서 비교해야 하므로 문자열로 저장해야한다
 * 2. 이어서 기준이될 정답을 하나 선언하고 비교해야한다. 따라서 입력값을 저장해둔 배열을 복사해서 임시 배열에 저장하고 pivot 문자열로 만들어둔다
 * 3. 중복되는 문자를 무시하기 위해 set을 선언하였고, 입력값이 작고, 결국은 모든 문자열을 다 확인해야하므로, bfs 탐색을 선택하였다.
 * 4. 문자열에서 양 옆으로 그 범위를 넓혀가는 유형은 보통 bfs로 생각하면 된다
 * 5. 기준점 left와 right를 0과 k로 선언해주고, 그 범위만큼 이전 중간 이후로 잘라서 넣어준다. 그 다음 큐에 해당 값과 그 횟수를 현재값에 1 더한 값으로 넣어준다
 * 6. 이후 left와 right를 증가시키고 right가 n보다 작거나 같은 동안 반복한다
 * 7. 이 과정에서 만약 pivot과 같은 수가 나오면 현재 값의 문자열을 return한다. set에도 해당 값을 넣어서 중복되는 값이 있으면 continue해준다
 * 8. 만약 모든 탐색 과정에서도 pivot과 같은 수를 발견하지 못할 경우 return -1을 해준다.
 * 9. 결과를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

class Node{
    String s;
    int count;

    public Node(String s, int count) {
        this.s = s;
        this.count = count;
    }
}



public class Main {

    static char[] arr;
    static char[] tmp;
    static String pivot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new char[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        tmp = Arrays.copyOf(arr,n);
        Arrays.sort(tmp);
        pivot = new String(tmp); // new String(char배열) -> String으로 만들어줌
        bw.write(bfs(new String(arr),k, n)+"");

        br.close();
        bw.close();
    }

    private static int bfs(String s, int k, int n) {
        Queue<Node> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Node(s, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.s.equals(pivot)){
                return now.count;
            }
            if(set.contains(now.s)){
                continue;
            }
            set.add(now.s);
            int left = 0;
            int right = k;
            while(right <= n){
                String pre = now.s.substring(0, left);
                StringBuilder mid = new StringBuilder().append(now.s.substring(left, right));
                String next = now.s.substring(right, n);


                q.add(new Node(pre + mid.reverse() + next,now.count + 1));
                left++;
                right++;
            }
        }
        return -1;
    }
}


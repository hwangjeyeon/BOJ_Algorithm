import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BufferedReader와 StringTokenizer를 사용하면 NoSuchElement 에러가 발생해서 Scanner로 바꿨다.
 * - 문제는 StringBuilder의 reverse를 활용해서 풀었다. 
 * - 이후 parse하면 0이 사라지므로 정답 배열에 파싱해서 넣어준다음 오름차순 정렬해주고 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(sc.next());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]).reverse();
            arr[i] = sb.toString();
        }

        Long[] ans = new Long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Long.parseLong(arr[i]);
        }
        Arrays.sort(ans);

        for (int i = 0; i < n; i++) {
            bw.write(ans[i]+"\n");
        }

        br.close();
        bw.close();
    }

}


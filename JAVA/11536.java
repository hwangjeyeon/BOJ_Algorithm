import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 비교할 배열과 원본 배열을 하나씩 준비해서 비교할 배열을 오름차순 정렬하면 된다
 * 2. 이후, 하나씩 비교하며 모두 같다면 증가하는 배열이다
 * 3. 아닌 경우, 뒤에 있는 값과(n-i-1) 원본의 처음 값을 비교해서 모두 같으면 내림차순이다
 * 4. 이 모든 것이 아니면 NEITHER이다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static final String INC = "INCREASING";
    static final String DEC = "DECREASING";
    static final String NEI = "NEITHER";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String ans = "";
        String[] arr = new String[n];
        String[] sort = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s;
            sort[i] = s;
        }
        Arrays.sort(sort);

        for (int i = 0; i < n; i++) {
            if(sort[i].equals(arr[i])){
                ans = INC;
            }else{
                ans = "";
                break;
            }
        }

        if(ans.equals(INC)){
            System.out.print(ans);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            if(sort[n-i-1].equals(arr[i])){
                ans = DEC;
            }else{
                ans = "";
                break;
            }
        }
        if(ans.equals(DEC)){
            System.out.print(ans);
            System.exit(0);
        }
        ans = NEI;
        System.out.print(ans);

        br.close();
        bw.close();

    }
}

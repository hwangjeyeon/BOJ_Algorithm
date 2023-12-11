import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 배열 B는 건드리지 말라는데, 출력해야하는 목표를 봤을 때 굳이 건드리지 않을 이유가 없다 
 * -> 만약 정렬된 배열을 출력하는 문제였다면 다르게 접근했을 수도 있다
 * - 따라서 배열 A는 오름차순, 배열 B는 내림차순으로 정렬해서 각 배열의 인덱스의 값을 곱해준 뒤, ans에 더해준다
 * - 최종 ans값을 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b, Comparator.reverseOrder());

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += a[i]*b[i];
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이분탐색으로 구하면 되는 문제이다
 * - 처음에 이해가 안 되었는데, 문제를 다시 읽어보니까 막대과자끼리 길이를 합치는 것이 아니고, 각 과자별로 길이를 잘라서 맞출 수 있다는 것을 알게 되었다.
 * - 그렇다면 각 막대별로 특정 길이로 과자를 잘랐을 때, 그 길이에 부합한지를 판단하고, 부합하다면 그 개수를 세어준다
 * - 이때 한가지 더 고려해야하는데, 어떤 막대 과자를 두번 이상 자를 수도 있다. 따라서 몫으로 개수를 세어주어야 한다
 * - 이렇게 해서 이분탐색을 통해 그 중간값을 찾고 정답으로 출력하면 된다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int ans = 0;
        while(min <= max){
            int mid = (min+max) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] >= mid){
                    count+= (arr[i]/mid);
                }
            }

            if(count >= m){
                min = mid+1;
                ans = Math.max(mid, ans);
            }else{
                max = mid-1;
            }

        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}


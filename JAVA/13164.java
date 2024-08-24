import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문제를 잘 읽어야 한다. 처음에는 잘못읽고, 최대한 똑같은 크기로 나눠서, 작은 값끼리 팀을 이루고 그 팀안에서 큰 값과 작은 값을 구하도록 하였다
 * 2. 하지만 이렇게 하면 최적해가 성립되지 않는다. 더 좋은 방법이 있기 때문이다
 * 3. 이번에는 줄서있는데로 앞 뒤 사람간의 키 차이의 차이를 구했다
 * 4. 그리고 그 차이를 리스트로 하여 오름차순 정렬을 해준다.
 * 5. 그 차이가 가장 작은 사람끼리 팀을 이루도록 해주며, 이때 k개의 팀이 나올려면 k-1개의 구분이 필요하다.
 * 6. 따라서 n에서 k개의 팀이 나로도록 n-k의 차이를 리스트에서 뽑아서 더해주면 정답이 된다.
 *
 * - 문제 해결:
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
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int pivot = n - k;
        long ans = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(arr[i+1] - arr[i]);
        }

        Collections.sort(list);
        for (int i = 0; i < pivot; i++) {
            ans += list.get(i);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}


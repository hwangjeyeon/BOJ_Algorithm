import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 문제에 따르면 팀을 구성하는 방법은 오름차순 정렬을 진행하고 양끝의 값을 팀 하나의 코딩 역량으로 지정하는 것이다.
 * 2. 이렇게 만든 팀은 n/2이고, n*2명의 사람이 있으므로, 무조건 짝수 팀이 나온다. 따라서 홀수의 경우를 고려하지 않아도 된다
 * 3. 이어서 각 팀의 코딩 역량중 최소값을 찾아서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) * 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int[] team = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            team[i] = arr[start] + arr[end];
            start++;
            end--;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.min(ans, team[i]);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }



}


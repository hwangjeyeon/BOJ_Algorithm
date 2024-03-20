import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀
 * 1. 함수식: backtracking(n, s, depth, 현재까지의 합)
 * 2. base condition:
 * - 1. n == depth -> return; -> 추가로 s == total이면 count++해준다
 * 3. 재귀식:
 *  -  backtracking(n,s,depth+1, 현재까지의 합 + input[i])
 *  -  backtracking(n,s,depth+1, 현재까지의 합)
 *
 * - 문제 해결:
 * 1. 이런 부분수열 문제는 그림을 그려봐야할 것 같다
 * 2. 수열을 글로 적으면 다음과 같은 두가지 경우를 고려해서 만들어지는 것을 확인할 수 있다
 * 2-1. 현재 합한 값에서 지금 값을 더한 경우
 * 2-2. 현재 합한 값에서 지금 값을 더하지 않은 경우
 * 3. 앞선 2번을 재귀로 넘겨주면 수학적 귀납법에 의해 트리형태로 쭉 진행되고, 백트래킹(가지치기)로 특정 값의 경우만 count++하도록 한다
 * 4. 또한 S가 0일 경우, 주어진 숫자들에서 S가 0이되는 경우가 없는 공집합의 경우 그대로 0이 출력되어서 원하는 결과를 얻지 않게 된다. 
 * 5. 따라서 S가 0일 경우는 count--를 해줘야 한다
 * 
 * - 앞으로 재귀 문제는 최대한 손그림으로 푸는 방법을 모색해보자.
 * 
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 */


public class Main {

    static int[] input;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(n,s, 0, 0);
        if(s == 0){
            count--;
        }

        bw.write(count + "");
        br.close();
        bw.close();
    }

    private static void backtracking(int n, int s, int depth, int total) {
        if(n == depth){
            if(s == total){
                count++;
                return;
            }
            return;
        }
        backtracking(n,s,depth+1, total + input[depth]);
        backtracking(n,s,depth+1, total);
    }

}


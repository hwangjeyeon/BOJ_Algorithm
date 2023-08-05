import java.io.*;
import java.util.StringTokenizer;

/**
 * 풀이 방법: 이분탐색,매개변수탐색 알고리즘 방식으로 풀었습니다
 * 접근 방법: 브루트 포스로 풀어야할지 다른 풀이 방식으로 풀어야할지 고민하기 위해서 먼저 입력으로 들어오는 수를 확인
 * - N은 최대 1000000 M은 2000000000 높이는 1000000000보다 작거나 같은 양의 정수 또는 0
 * - 입력 값을 확인했을 때 브루트포스로 풀면 시간초과가 발생할 것으로 예상된다.
 * - 이분 탐색으로 풀어서 순차 탐색으로 풀었을 때 발생하는 시간 초과 문제를 해결하기로 결정
 * 
 * 변수 선언:
 * - N과 M은 int형으로, 높이를 받는 tree[]배열은 오버플로우 발생을 예상하여 long형으로 선언하였다.
 * - M이 1부터 시작하므로 left는 1, right는 tree[]배열의 값 중 MAX값으로 설정
 * - mid는 left와 right를 2로 나눈 몫
 * - count는 mid로 각 tree[]에 원소와 비교했을 때 값을 담는 변수
 * - ans는 정답 출력을 위해 선언한 변수
 * 
 * 풀이 과정:
 * - 이분 탐색 알고리즘을 생각하여 left<=right동안 반복한다.
 * 1. count에는 tree[i]-mid 값을 넣어준다. 이때 tree[i]보다 mid가 클 수도 있는데, 이는 문제에서 원하는 것과 다르므로,
 * tree[i]-mid <=일 경우 음수 값을 넣어주는 것이 아닌 0을 넣어준다
 * 2-1 count값이 작은 경우, 높이를 너무 높게 설정하여 자른 것이므로 right를 mid-1로 설정해준다
 * 2-2. count 값이 큰 경우, 높이를 너무 낮게 설정하여 자른 것이므로 left를 mid+1로 설정해준다
 * 2-3. 2-2과정에서 ans와 mid값을 비교하여 더 큰 값을 ans에 담는다
 * 3. while문이 끝나고 나온 최종 ans값이 정답이므로 출력한다.
 *
 * 의문점:
 * - 2-3 과정에서 이해가 되지 않는 부분이 있었다.
 * 1. count와 M이 같은 경우가 존재하면 그 값이 정답이므로 ans에 바로 넣어주고 break; 하면 더 빠르게 해결되는 것이 아닌가?라는 의문이 들었다.
 * 2. 문제를 잘 읽어야 했다. "적어도 M미터의 나무를 집에 가져가기 위해서" -> 이 부분이 의문점을 해결하는데 핵심이었다. 
 * 3. 정확하게 떨어지는 경우가 존재하지 않는 반례가 존재한다는 것. 이때는 ans가 0으로 나와서 원하는 정답이 아니게 된다.
 * 4. 따라서 더 큰 값을 ans로 넣어주기 'ans = Math.max(ans, mid);'라는 코드가 나오게 되었다.
 * - 이 과정이 매개변수탐색과 이분탐색의 차이라는 것을 알게 되었습니다
 * 이분탐색: 일치하는 값을 찾으면 바로 함수를 종료 시킴
 * 매개변수탐색: 일치하는 값을 찾더라도 함수를 종료시키지 않고 모든 배열을 살펴본다.
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] tree = new long[N];
        long left=1, right=-1, mid;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            tree[i] = Long.parseLong(st.nextToken());
            right = Math.max(tree[i],right);
        }
        br.close();

        long count=0;
        long ans=0;
        while(left<=right){
            count =0;
            mid = (right+left)/2;
            for(int i=0; i<N; i++){
                if(tree[i]-mid <=0){
                    count+=0;
                }else{
                    count+=tree[i]-mid;
                }
            }
            if(count < M){
                right = mid-1;

            }else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        bw.write(ans+"");

        bw.close();
    }
}

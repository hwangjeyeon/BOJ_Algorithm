import java.io.*;
import java.util.StringTokenizer;

/**
 * 풀이 방법: 매개변수 탐색 알고리즘 방식으로 풀었습니다
 * 접근 방법:
 * - 입력 값을 보고 브루트포스로 푸는 것은 포기했다. -> 분명 시간 초과가 날 것이 뻔하므로!!
 * - 나무 자르기랑 비슷한 문제 매개변수 탐색 알고리즘 방식으로 풀어야한다.
 * - 이분 탐색 방법으로 풀면 틀렸습니다.라고 나온다 이 문제도 나무 자르기처럼 정확한 값이 나오지 않을 것이 분명. -> "첫째 줄에 N개를 만들 수 있는 랜선의 최대길이를"
 *
 * 변수 선언:
 * int K: 오영식이 이미 가지고 있는 랜선의 개수
 * int N: 필요한 랜선의 개수
 * long[] arr: 각 랜선의 길이(센티미터 단위) -> 2^31-1보다 작거나 같은 자연수라고 하기때문에 long형으로 설정
 * max: 각 랜선의 길이 중 가장 큰 값
 * min: 각 랜선의 길이 중 가장 작은 값 -> 2^31-1보다 작거나 같은 자연수이기때문에 1로 초기화
 * comp: 각 랜선의 길이 arr[i]를 다음에 나올 mid로 나눴을 때의 값들을 저장
 * mid: (max+min)/2 -> 범위의 중간 값
 *
 * 풀이과정:
 * - 이분 탐색 알고리즘을 생각하여 min<=max동안 반복한다
 * - 이번에는 필요한 랜선의 개수를 비교해야 하므로 '-'가 아닌 '/'연산을 해준다
 * 1. count에 arr[i]/mid 값을 더한다.
 * 2-1. count값과 N을 비교하고 count가 더 크면 짧게 자른 것이므로, min = mid+1을 해준다
 * 2-2. count 값과 N값을 비교하고 count가 더 작으면 길게 자른 것이므로, max = mid-1을 해준다
 * 2-3. 2-1에서 한가지를 더 해주는데 comp랑 현재 mid값을 비교하여 더 큰 값을 comp에 넣어준다 -> 정확히 같게 떨어지는 경우가 생기지 않을 수 있기 때문에 최대한 만들 수 있는 값으로 넣어주기 위해서
 * 3. 최종적으로 comp를 출력해주면 정답이 된다.
 *
 *
 *
 *
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long max = 0;
        for(int i=0; i<K; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        br.close();

        long min = 1;
        long comp = 0;

        while(min <= max){
            long mid = (min+max)/2;
            long count =0;

            for(int i=0; i<K; i++){
                count += arr[i]/mid;
            }

            if(count>= N){
                min = mid+1;
                comp = Math.max(comp, mid);

            }else{
                max = mid - 1;
            }

        }

        bw.write(comp+"");
        bw.close();
    }
}

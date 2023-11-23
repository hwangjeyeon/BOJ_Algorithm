import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 비트마스크 알고리즘에 대해 공부를 통해 풀었습니다.
 * - 하나의 bit를 하나의 데이터 상태로 두고 문제를 풀면 됩니다. 20개면 20개 비트 만들면 됨
 * - 0이면 공집합
 * - 꽉찬 집합하려면 (1 << n+1) -1; 하면 된다 -> n+1만큼 1이 이동 -> 여기서 -1하면 부호가 뒤집히면서 1~20까지 전부 1로 바뀜
 * - 원소 추가 s |= (1 << n); 항상 1로 만드는 연산인 OR 사용
 * - 원소 삭제 s &= ~(1 << n); 0이 가니까 AND 연산 때문에 항상 0으로 만듦
 * - 원소 포함 여부 확인 if((s & (1 << k)) == (1 << k))  s와 1<<k가 AND 연산으로 해당 원소 제외하고 나머지는 다 0으로 만들기 떄문에 해당 원소 포함 여부에 집중할 수 있고 확인할 수 있다
 * - 원소의 토글 s ^= (1 << k) XOR 연산으로 해당 원소가 있으면 끄고 없으면 킨다
 *
 * 그외 추가 공부
 * - 두 집합에 대해 연산하기 A|B(합집합) A&B(교집합) A&(~B)(A에서 B를 뺀 차집합) A^B(A와 B중 하나에만 포함된 원소들의 집합)
 * - 집합의 크기 구하기: Integer.bitCount(s)
 * - 최소 원소 찾기 s & (-s)
 * - 최소 원소 지우기 s &= (s-1)
 * 개념 참고: https://myeongju00.tistory.com/30
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

//    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int s = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                s |= (1 << x);
            }else if(command.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                s &= ~(1 << x);
            }else if(command.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                if((s & (1 << x)) == (1 << x)){
                    bw.write(1 + "\n");
                }else{
                    bw.write(0 + "\n");
                }
            }else if(command.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                s ^= (1 << x);
            }else if(command.equals("all")){
                s = (1 << 21) -1;

            }else if(command.equals("empty")){
                s = 0;
            }

        }

        br.close();
        bw.close();
    }


}

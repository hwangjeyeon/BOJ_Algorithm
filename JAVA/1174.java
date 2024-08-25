import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 해결포인트만 잘 잡으면 쉽게 풀 수 있는 문제다
 * 2. 9876543210이 최대라서 놀랍게도 백트래킹으로 풀 수 있는 문제다
 * 3. 해결 포인트는 9876543210을 미리 배열로 각각 관리해서 백트래킹 돌린 다음 결과를 list에 미리 넣어두면된다
 * 4. 백트래킹은 now와 depth만을 가진다. 만약 now가 list에 없는 원소라면 넣어주고, depth가 10일 경우 종료한다
 * 5. 백트래킹 재귀문은 두가지다. 현재 숫자를 선택하냐 안하냐이다.
 * 6. 만약 선택할 경우 현재 수에 10을 곱한 다음 arr[depth]를 더해서 넣어주고 depth+1으로 그 깊이를 더한다
 * 7. 만약 선택하지 않을 경우 그대로 now를 넘기며 depth+1으로 그 깊이를 더한다
 * 8. 이렇게 완성한 백트래킹의 결과를 리스트에 보관하며 오름차순 정렬을 진행해준다
 * 9. 그런 뒤, 만약 리스트크기보다 k가 크다면 -1을 출력하고 아니라면 0번 인덱스부터 시작하므로 k-1의 위치의 값을 가져와 출력하면 정답이 된다.
 *
 * 시간복잡도: O(2^10)
 * 공간복잡도: O(2^10)
 *
 */



public class Main {

    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        backtracking(0,0);

        Collections.sort(list);
        if(list.size() < k){
            bw.write("-1");
        }else{
            bw.write(list.get(k-1)+"");
        }

        br.close();
        bw.close();
    }

    private static void backtracking(long now, int depth) {
        if(!list.contains(now)){
            list.add(now);
        }

        if(depth == 10){
            return;
        }

        backtracking(10*now + arr[depth], depth+1);
        backtracking(now, depth+1);
    }
}


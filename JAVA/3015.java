import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중 for문으로 풀면 시간초과가 발생한다
 * 2. 입력값들을 배열로 받자.
 * 3. 배열을 순회하면서 현재 스택이 비어있으면 스택에 인덱스 위치를 넣어준다
 * 4. 비어있지 않다면 현재 배열의 값이 스택의 꼭대기 값과 비교한다
 * 5. 만약 배열의 값이 스택의 꼭대기 값보다 크다면 스택의 꼭대기 값을 pop한다. 이어서 해당 꼭대기 값인 배열의 인덱스에 그 인덱스와 현재 순회중인 인덱스의 위치간의 차이를 해당 배열에 저장해준다.
 * 6. 이어서 해당 배열의 인덱스 위치를 스택에 넣는다
 * 7. 만약 배열의 값이 스택의 꼭대기 값보다 작거나 같다면 해당 배열의 인덱스 위치를 스택에 넣어준다
 * 8. 순회 종료 후, 스택이 비어있지 않다면, 각각의 배열의 인덱스 위치에 배열 전체 크기와 해당 배열의 인덱스 위치간의 차이를 빼서 해당 배열 위치에 저장해준다
 * 9. 마지막으로 배열을 순회해서 ans에 값들을 더해주고 출력한다.
 * => 틀린 풀이
 *
 * - 문제 해결:
 * 1. 모노스택을 생각하는 문제다. 그중 내림차순을 유지해야한다
 * 2. 만약 스택이 비어있지 않고 스택의 꼭대기 값이 현재 입력값보다 작거나 같으면 그 이후로의 값은 더이상 볼 수 없게 된다. 따라서 스택의 값을 pop하고 스택에 현재 값을 넣어준다. 그리고 count 값도 증가시킨다.
 * 3. 2번은 while문으로 조건이 만족되는 동안 반복하며, 이후, 만약 스택에 값이 비어있지 않다면, 자신이 볼 수 있는 큰 값이 왼쪽에 하나 있기 때문에 그 값을 생각해서 ans에 값을 1 증가시킨다.
 * 4. 입력값을 이제 스택에 넣어준다.
 * 5. 하지만 한가지 문제점이 발생한다. 만약 같은 높이가 붙어있을 경우, 이후에 더 큰 값이 들어왔을 때, 중간에 삭제된 값을 볼 수 없기 떄문이다.
 * 6. 따라서 동일한 숫자의 개수를 세는 클래스와 필드를 설정해줘야한다. 만약 입력값이 스택의 꼭대기 값과 같다면 필드의 값을 증가시키면 된다.
 *
 * - 모노스택 구현을 다시 학습할 수 있었던 문제였다.
 * - 이어서 모노스택 구현할 경우, 만약 동일한 값이 있을 때의 처리에 대해서도 학습할 수 있었다.
 * - 이후 다시 풀때와 복습하게 될 때, 해당 문제와 비슷한 골드 난이도 문제를 같이 학습하여 이후 나오는 문제에서 틀리지 않도록 학습할 계획이다.
 * - 스택 관련 정리는 덱 문제집 작성 후, 스택의 활용 -> 스택 문제집 순으로 작성할 계획이다.
 * - 정리 후 1~2주 정도 뒤에 다시 풀 계획 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Pair{
    int value;
    int count;

    public Pair(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        int[] arr = new int[n];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            Pair pair = new Pair(input, 1);
            while(!stack.isEmpty() && stack.peek().value <= input){
                Pair top = stack.pop();
                ans+= top.count;
                if(top.value == input){
                    pair.count += top.count;
                }
            }

            if(!stack.isEmpty()){
                ans++;
            }

            stack.push(pair);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}


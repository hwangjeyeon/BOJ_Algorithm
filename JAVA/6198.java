import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 모노스택 이론을 이용하여 풀었습니다.
 * - 모노스택 이론은 스택 정렬을 위해 오른쪽에서 탐색한다는 것이다.
 * - 이것을 이용하여, 입력이 들어왔을 때, 이 값이 스택의 꼭대기값보다 같거나 작다면, 그 값은 더이상 앞의 아파트의 옥상을 볼 수 없으므로, pop을 해준다.
 * - 이것을 스택이 빌때까지 순회하는 방식으로 구현했으며, 만약 크다면 break해서 탈출한다.
 * - 입력이 들어올때마다, 스택을 다시 오른쪽에서 순회해서 구하는 모노스택을 이용한 풀이이다.
 * - 이후 순회를 탈출했다면, 스택의 크기를 count에 넣어주고, 이어서 입력을 스택에 push한다.
 * - 이후 count를 출력하면 정답이 된다.
 *
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
        Stack<Integer> apartmentHeight = new Stack<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int newHeight = Integer.parseInt(br.readLine());
            while(!apartmentHeight.isEmpty()){
                if(newHeight >= apartmentHeight.peek()){
                    apartmentHeight.pop();
                }else{
                    break;
                }
            }
            count += apartmentHeight.size();

            apartmentHeight.push(newHeight);
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력 정답을 리스트에 담는다.
 * 2. 2차원 배열에다가 각 문자들을 담는다.
 * 3. 이중 for문으로 순회를 한다. i는 리스트에 담긴 길이만큼 순회한다
 * 4. 각 문자들의 첫 좌표는 가로는 i 세로는 0으로 시작한다.
 * 5. j는 n만큼 진행하는데, ?를 발견하면 멈춘다.
 * 6. 이어서 리스트에서 i랑 같은 숫자를 찾는다. (indexOf 활용)
 * 7. 그 인덱스를 가로 좌표로 하고 세로는 n-1으로 시작한다
 * 8. n는 0과 같거나 큰동안 진행하는데 ?를 발견하면 멈춘다
 * 9. 두 순회동안 first와 second 변수를 활용한다. first는 i, second는 indexOf랑 같은 수로 초기화한다)
 * 10. 첫 순회하는동안 *를 발견하면 continue, -를 발견하면 first++한다
 * 11. 두번째 순회하는 동아 *를 발견하면 continue, -를 발견하면 second--한다
 * 12. 두 순회 종료 후, first와 second의 차의 절댓값이 1보다 크면 전체 순회를 종료하고 x를 출력한다
 * 13. 만약 1보다 작거나 같으면 first가 더 크면 first 좌표에 - 을 넣는다
 * 14. second가 더 크면 second 좌표에 - 을 넣는다
 * 15. 0이면 first 좌표에 .을 넣는다
 * => 여기에 스왑을 추가하면 된다.
 *
 * - 문제 해결:
 * 1. 내가 생각한 두가지 접근법은 맞았다
 * 2. 첫번째로는 위-> 아래방향으로 ?까지 순회, 아래 -> 위방향으로 순회는 맞았다
 * 3. 두 방향 순회 후 결과에 따라 ?의 위치가 같으면 *이고 한가지 차이면 -, 그 이상 차이나면 x를 출력하면 된다
 * 4. 이 문제의 해결방법은 각 위치에 정렬된 문자들을 사다리타고 내려가면서 스왑해주면 된다
 * 5. 내려가다가 -가 보이면 현재 위치의 문자를 오른쪽 문자와 스왑해준다
 * 6. 아래에서 위로 내려가는 방향도 위와 똑같이 해주면 된다.
 * 7. 마지막에 이제 비교를 하면 된다. front와 back의 현재 i인덱스의 값이 같으면 *를 append해주고 front[i]와 back[i+1]이 같으면 -를 append해준다
 * 8. 마지막으로 둘다 아니면 두칸 이상 차이나는 것이므로 만족하는 결과가 나오지 않기 떄문에 기존 StringBuilder를 초기화해주고 x를 k-1만큼 넣어준다
 * 9. 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * - String형 배열보다는 char형 배열이 더 쉽게 풀 수 있는 문제이다. 괜히 String형으로 고민하다가 고생했다....
 * -> 입력 방식에 따라서 String vs char 형 중에 편한 방식을 고르는 것을 1순위로 한다
 * -> 두번째는 비교해야하는 문자가 많을 경우, 이 문제처럼 좌표명면 형태의 문제인 경우 웬만하면 char형으로 쓰자
 *
 * => 탐색 방향과 정답 작성 추론까지는 좋았으나, 입력과 순회 인덱스 설정때문에 이후 추론을 하지 못해서 너무 아쉽다...
 * => 또한 위 아래의 현재의 문자 위치를 고정시켜놓고 -가 나오면 스왑한다는 방법은 전혀 추론하지 못했다. -> 난이도 높은 구현 문제에 대해 더 많이 풀면서 추론 능력을 더 키워야겠다
 * => 순회 인덱스 설정에 대해 너무 깊게 고민하지 말자.
 *
 *
 * 시간복잡도: O((k-1)^2)
 * 공간복잡도: O(n*(k-1))
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] front = new char[k];
        for (int i = 0; i < k; i++) {
            front[i] = (char)('A' + i);
        }

        char[] back = br.readLine().toCharArray();
        int height = -1;
        char[][] map = new char[n][k-1];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if(height == -1 && tmp.charAt(0) == '?'){
                height = i;
                continue;
            }
            map[i] = tmp.toCharArray();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < k - 1; j++) {
                if(map[i][j] == '-'){
                    char tmp = front[j];
                    front[j] = front[j+1];
                    front[j+1] = tmp;
                }
            }
        }


        for (int i = n-1; i > height; i--) {
            for (int j = 0; j < k-1; j++) {
                if(map[i][j] == '-'){
                    char tmp = back[j];
                    back[j] = back[j+1];
                    back[j+1] = tmp;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if(front[i] == back[i]){
                ans.append('*');
            }else if(front[i] == back[i+1]){
                ans.append('-');
                char tmp = front[i];
                front[i] = front[i+1];
                front[i+1] = tmp;
            }else{
                ans = new StringBuilder();
                ans.append("x".repeat(k-1));
                break;
            }
        }

        bw.write(ans.toString());

        br.close();
        bw.close();
    }

}


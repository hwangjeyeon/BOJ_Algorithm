import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹으로 풀어야하는 것은 쉽게 알 수 있었다. 시간복잡도도 해결되기에 이 문제는 백트래킹을 이용하면 쉽게 풀 수 있다
 * 2. 그렇지만 문제를 풀면서 점점 의문이 들었다. 일단 수를 만들어나가나는 과정은 두가지다. 왼쪽과 오른쪽에 붙이는 경우다
 * 3. 종료조건이될 문자열을 하나씩 선택하면서 붙여나가는 것은 문제가 되지 않았다.
 * 4. 하지만 숫자를 적는 과정에서 나온 수가 순서대로 모두 같다면 같은 방법이라고 하였는데, 그렇다면 과정이 같은지를 어떻게 판단해야할가 고민이 들었다
 * 5. 중복을 제거해야하기에 Set을 사용하는 것은 알겠는데, 이것을 어떻게 구현할 수 있을지 알지 못했다
 * 6. 단순히 위 과정을 두가지 백트래킹 나누어서 재귀문을 돌렸고, 중복선택을 하지 않도록 방문 배열도 하나 만들어서 백트래킹 형식으로 진행하였다
 * 7. 범위를 벗어나면 다시 끝 부분으로 가도록 하였고 크기가 정답 문자 크기랑 같은 경우 체크해서 ans를 증가시키도록 하였다.
 *
 * - 문제 해결:
 * 1. 하지만 이렇게 하면 과정의 중복도 체크하는 문제가 발생한다. 따라서 1%에서 바로 틀려버렸다
 * 2. 문제를 해결하는 방법은 과정도 문자열로 구분하여 넣어주는 것이다
 * 3. 또한 왼쪽과 오른쪽 선택 과정을 투포인터로 하나씩 더 선언하여, 파라미터로 넘겨준다
 * 4. 문자열을 좀 편하게 다루기 위해 문자배열로 바꾸었다
 * 5. 또한 과정의 중복을 제거하기 위해 Set 자료 구조도 하나 선택하였다
 * 6. 각 문자를 시작으로 할 때, left와 right를 현재 위치로 넘겨준다. 완성 문자열과 경로 문자열도 현재 위치의 문자로 넘겨준다
 * 7. 만약 left나 right가 둘다 범위의 끝에 도달하면 set에 완성한 경로를 넣어준다
 * 8. 이어서 left와 right가 각각 범위를 벗어나지 않으면 left-1, right+1을 넘겨준다
 * 9. 문자열에는 arr[left-1], arr[right+1]을 더해준다.
 * 10. 경로는 다음과 같이 구분하여 준다. 현재 경로인 path에 " "를 더해 띄어쓰기를 해주고, arr[left] + s나 s + arr[right]를 더해준다
 * 11. 또는 " " 없이 그냥 넣어줘도 된다. 이렇게 되면 완성된 문자열이 단계별로 누적되어 저장되기 떄문에, 과정의 중복을 제거할 수 있다
 * 12. 완성된 set의 크기를 출력하면 정답이 된다
 * 13. 이 문제는 다른 비슷한 문제처럼 완성 문자열을 보는 문제가 아니라 과정을 보는 문제였다.
 * 14. 비슷한 유형이 코테에 많이 나오니 꼭 숙지해두자!
 *
 * 시간복잡도: O(|n| * 2^|n|)
 * 공간복잡도: O(2^|n|)
 *
 */


public class Main {


    static char[] arr;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = br.readLine().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            dfs(i, i, "" + arr[i], "" + arr[i]);
        }

        bw.write(set.size()+"");

        br.close();
        bw.close();
    }

    private static void dfs(int left, int right, String s, String path) {
        if(left == 0 && right == arr.length-1){
            set.add(path);
            return;
        }

        if(left - 1 >= 0){
            dfs(left-1, right, arr[left-1] + s, path + " " + arr[left] + s);
        }

        if(right + 1 < arr.length){
            dfs(left, right+1, s + arr[right+1], path + " " + s + arr[right]);
        }
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 덱을 써서 앞뒤로 옮기는 방식을 사용하자
 * 2. 일단 n만큼 문장을 하나의 덱에 다 넣는다 뒤에다 쌓는 스택형식으로 넣어준다.
 * 3. 정답 문장은 스택에 넣어둔다
 * 4. 시뮬레이션 방식으로 진행할 것이다. 각 시뮬레이션마다 count를 0으로 하고 만약 0이 스택의 사이즈랑 같다면 한바뀌를 돌아도 해당 문장을 찾을 수 없는 것이므로 isOk를 false로 한 뒤 break한다
 * 5. 덱에 맨 뒤에 있는 값이 만약 정답의 peek와 같지 않다면 앞으로 보내고 count++한다
 * 6. 만약 같다면 둘다 pollLast와 pop을 해준다.
 * 7. isOk에 따라 정답을 출력한다.
 * => 틀린 풀이
 *
 * 1. 스택 배열을 사용하면 된다.
 * 2. 처음에 스택배열을 써야하나라는 고민을 했다가 첫 예제만 보고 잘못 판단해서 덱을 사용했었다.
 * 3. 각 문장마다 어느 위치에 단어가 있든지 상관없이 있기만 하면되는줄 알았는데, 각 문장에 끝에 있는 단어랑만 매치가 되어야했다.
 * 4. 따라서 덱은 사용 못하고 스택 방식으로 돌아와 여러 문장이 있으니 스택 배열을 선언해서 풀었다.
 * 5. 시뮬레이션을 돌려서 스택배열크기만큼 순회할 때 만약 각 스택 배열의 peek값이 정답을 담고있는 스택의 peek와 같다면 각각을 pop하고 isOk를 true로 한뒤 break해서 순회를 탈출한다
 * 6. 만약 순회하고나서 isOk가 false면 시뮬레이션을 탈출하고 isOk에 맞는 문장을 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n*L.length)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        Stack<String>[] s = new Stack[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Stack<>();
        }


        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                s[i].push(input[j]);
            }
        }
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
        boolean isOk = false;
        while(!stack.isEmpty()){
            isOk = false;
            for (int i = 0; i < n; i++) {
                if(!s[i].isEmpty() && s[i].peek().equals(stack.peek())){
                    s[i].pop();
                    stack.pop();
                    isOk = true;
                    break;
                }
            }

            if(!isOk){
                break;
            }
        }


        if (isOk){
            bw.write("Possible");
        }else{
            bw.write("Impossible");
        }

        br.close();
        bw.close();
    }

}


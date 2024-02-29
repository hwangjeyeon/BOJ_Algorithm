import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문제 이해가 조금 어려웠던 문제이다.
 * 2. 내가 이해한바로는 일단 각 줄에 단어가 있고 이 단어가 좋은 단어이면 개수를 카운트하면 된다
 * 3. 이어서 좋은 단어는 무조건 단어 위로만 곡선을 그어서 짝을 지어야한다.
 * 4. 같은 단어끼리 연달아 오는 경우는 무조건 좋은 단어이다.
 * 5. 만약 A와 B가 번갈아서 하나씩 오는 경우는 두 곡선이 교차를 해야지만 짝을 지을 수 있어서 좋은 단어 일 수 없다.
 * 6. 따라서 좋은 단어가 아닌 경우를 판단하는 기준이 더 적으니 이 기준을 if 조건으로 넣어서 필터를 걸어주면 된다
 * 7. 자료구조는 스택으로 하면 될 것 같다. 계속 쌓이고 늦게 들어온 단어를 체크해야 하는 경우가 생기기 때문이다.
 * 8. 먼저 각 입력을 String[] 배열에 담는다
 * 9. 스택도 하나 만들어주고 일단 비어있으면 무조건 담는다
 * 10. 배열이 비어있지 않다면 현재 문자열 배열의 값이 스택 꼭대기에 있는 값과 같으면 스택에 있는 값은 빼준다.
 * 11. 만약 같지 않다면 해당 문자열을 스택에 넣는다.
 * 12. 10번 이전에 한가지 더 조건을 걸어주어야 한다. 만약 스택 사이즈가 2보다 큰 경우와 아닌 경우이다.
 * 13. 스택 사이즈가 2보다 큰 경우 지그재그로 들어옴을 의미한다. 따라서 탈출하고 count를 증가시키지 않는다
 * 14. 만약 그렇지 않다면 위 과정을 반복해준다.
 *
 * 문제 해결:
 * 1. 위와 같이 풀이를 했지만 14%쯤? 에서 틀렸습니다가 나왔다. 반례 힌트를 통해서 해결하였다.
 * 2. 지그재그로 들어와도 상관 없다. 결국은 작게 아치형 곡선을 그리면 겹치지 않게 그릴 수 있다.
 * 3. 겹치게 그려야하는 경우는 스택에 쌓인 순서대로 끝까지 순회했을 때 못 빼는 경우이다. 이럴때 겹치게 아치형 곡선을 그려야 한다
 * 4. 따라서 일단 순회를 전부 하고 스택이 비어있는 경우만 count해주면 정답이 된다.
 *
 * - 처음 문제를 봤을 때, 큐나 덱으로도 할 수 있는거 아닌가 라는 생각을 했는데 스택을 사용해야하는 이유가 바로 위 문제해결에 있었다.
 * - 겹치지 않게 그리려면 쌓인 순서대로 붙어서 짝을 이루도록 해야한다. 즉 뒤에 값만 신경쓰면 된다. 
 * - 이것은 앞에서부터 시작하는 큐로는 불가능하고 덱도 가능하지만 굳이 스택을 써도 되는데 쓸 필요까지는 없어 보인다.
 * - 그렇기에 스택이 필요했던 것이고, 자료구조를 써야한다면 어떤 것을 쓰는 것이 좋을지 그리고 이 문제에서 왜 써야할지 어떻게 풀어나갈지 까지 생각하는 습관을 들이자
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            if(input.length%2 == 0){
                for (int j = 0; j < input.length; j++) {
                    if(stack.isEmpty()){
                        stack.push(input[j]);
                    }else{
                        if(stack.peek().equals(input[j])){
                            stack.pop();
                        }else{
                            stack.push(input[j]);
                        }
                    }
                }

                if(stack.isEmpty()){
                    count++;
                }
            }

        }

        bw.write(count + "");

        br.close();
        bw.close();
    }

}


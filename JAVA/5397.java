import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 커서를 이용해서 넣을 위치를 정하자
 * 2. 자료구조는 앞뒤로 넣고 빼고 싶어서 덱으로 정했다. 배열로 하면 문자열 길이와 테스트 케이스를 생각했을 때, 시간초과가 발생할 것이다.
 * 3. 커서의 위치를 기준으로 앞에다가 문자를 넣어주자. -> addFirst()로 초반에는 0이고 추가될 때마다 count++해준다
 * 4. <가 나오면 count--해준다.
 * 5. >가 나오면 coun++ 해준다.
 * 6. 문자열 입력이 들어오면 덱의 크기랑 count의 크기가 맞지 않을 경우 그 차이만큼 뒤나 앞에있는 수를 앞이나 뒤로 넘긴다. 그리고 각각 front와 back의 값을 올려준다.
 * => 아무리 생각해도 덱으로는 하기 어려워서 포기
 *
 * 1. 스택을 사용한다.
 * 2. 왼쪽 스택과 오른쪽 스택을 하나씩 만들어서 총 2개 사용한다
 * 3. <의 의미를 왼쪽 스택이 비어있지 않다면 수 하나를 오른쪽으로 옮긴다고 정의하자
 * 4. >의 의미는 오른쪽 스택이 비어있지 않다면 수 하나를 왼쪽으로 옮긴다고 정의하자
 * 5. -의 의미는 왼쪽 스택이 비어있지 않다면 수 하나를 pop한다고 정의하자.
 * 6. 3,4,5를 구현하고 순회 종료 후, 만약 오른쪽에 값이 남아있으면 전부 pop해서 왼쪽 스택에 넣어주자.
 * 7. 완성된 왼쪽 스택의 값을 출력한다.
 *
 * - 문제 해결:
 * 1. 처음에 덱으로 풀다가 풀이 힌트를 참고했다. 스택으로 푸는 문제였다..
 * 2. 각 자료구조를 여러개 쓰는 방법도 충분히 해법이 될 수 있다. 앞으로는 여러 자료구조를 사용하는 경우도 고려해보자
 *
 * 시간복잡도: O(T*n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            for (int j = 0; j < input.length; j++) {
                if(input[j].equals("-")){
                    if(!left.isEmpty()){
                        left.pop();
                    }

                }else if(input[j].equals("<")){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }

                }else if(input[j].equals(">")){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                }else{
                    left.push(input[j]);
                }
            }

            while(!right.isEmpty()){
                left.push(right.pop());
            }

            for (String s : left) {
                bw.write(s);
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }

}


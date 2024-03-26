import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. A는 뒤에 B가 오는 경우, B는 뒤에 C가 오는 경우 없애줄 수 있지만, C는 뒤에 어떠한 수가 오더라도 지울 수 없다
 * 2. 따라서 가장 먼저 지우는 것을 C로 선택하였다
 * 3. 입력값을 큐에 넣는데 어차피 C는 지울거니까 A와 B만 큐를 만들어준다. 큐에는 각 인덱스 값을 넣어줄 것이다
 * 4. A와 B에 따라 큐에 넣어주고 C가 오면 B가 비어있지 않고 B의 맨 앞 값이 C의 현재위치인 i보다 작을 경우 poll해준다. 그리고 count++도 해준다
 * 5. 이제 A 뒤에 B가 오는 경우를 확인하기 위해 두 큐가 비어있지 않은 동안에 순회를 반복한다
 * 6. 만약 A의 peek가 B의 peek보다 작으면 A와 B모두 poll하고 count를 증가시킨다
 * 7. 만약 작지 않을 경우, 큐에 쌓여있는 값 중 B가 A보다 작은 경우가 있을 수 있기 때문에 순회를 끊지 않고 반복하기 위해 b만 poll을 해준다
 * 8. 완성된 count를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(input.length)
 * 공간복잡도: O(input.length)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("A")){
                a.add(i);
            }else if(input[i].equals("B")){
                b.add(i);
            }else{
                if(!b.isEmpty() && b.peek() < i){
                   b.poll();
                   count++;
                }
            }
        }
        while(!a.isEmpty() && !b.isEmpty()){
            if(a.peek() < b.peek()){
                a.poll();
                b.poll();
                count++;
            }else{
                b.poll();
            }
        }

        bw.write(count+"");


        br.close();
        bw.close();
    }

}


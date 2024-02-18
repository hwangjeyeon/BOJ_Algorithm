import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - StringTokenizer를 통해서 미리 제거해줄 구분문자를 지정할 수 있다
 * -> new StringTokenizer(br.readLine(), "[],");
 * - 덱을 활용하는 문제이다. 처음에는 들어오는 순서대로 빼줄때는 큐를, 나가는 순서로 빼줄때는 스택을 사용하는 방법을 생각했는데 그렇게 두개의 자료형을 쓰느니 덱을 쓰는게 낫겠다고 생각하였다
 * - D가 들어올때는 현재 상태를 가지고 poll로 빼주면 된다. 하지만 R이 들어올때는 고민할 것이 있다.
 * - 정말 다 뒤집어야하는가? 덱에는 reverse기능이 없고 하더라도 시간초과 문제가 분명 발생할 것이다...
 * - 따라서 덱에 있는 요소들을 옮기지 말고 하는 방법을 생각해야한다.
 * - 그렇게 나온 방법이 구분자를 하나 boolean 변수로 선언해서 앞에서 뺄지 뒤에서 뺄지를 구분해서 빼주면 된다.
 * - R일때마다 pointer 변수에 !pointer를 넣어서 뒤집어준다
 * - D일때 pointer가 true면 앞에서 false면 뒤에서 빼준다
 * - 이어서 D일때 만약 덱이 비어있으면 isOk를 false로 바꿔준다.
 * - 이후 검사할 때 isOk가 false면 error를 출력하고 아니면 주어진 양식에 맞춰서 출력하면 된다.
 * - 출력할 때, 원소,원소 -> 이런식으로 해야한다 즉 원소, 원소처럼 띄어쓰기하면 틀린다.. 조심하자
 *
 *
 * 시간복잡도: O(T*N)
 * 공간복잡도: O(N)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            char[] command = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> arr = new ArrayDeque<>();
            for (int j = 0; j < size; j++) {
                arr.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isOK = true;
            boolean pointer = true; // true면 앞에서 false면 뒤에서
            for (int j = 0; j < command.length; j++) {
                char nowCommand = command[j];
                if(nowCommand == 'R'){
                    pointer = !pointer;
                }else{
                    if(arr.isEmpty()){
                        isOK = false;
                        break;
                    }
                    if(pointer){
                        arr.pollFirst();
                    }else{
                        arr.pollLast();
                    }
                    size--;
                }
            }

            if(!isOK){
                bw.write("error\n");
            }else{
                bw.write("[");
                if(pointer){
                    for (int j = 0; j < size; j++) {
                        if(j == size-1){
                            bw.write(arr.pollFirst()+"");
                            break;
                        }
                        bw.write(arr.pollFirst() + ",");
                    }
                }else{
                    for (int j = 0; j < size; j++) {
                        if(j == size-1){
                            bw.write(arr.pollLast()+"");
                            break;
                        }
                        bw.write(arr.pollLast() + ",");
                    }
                }
                if(i == T-1){
                    bw.write("]");
                }else{
                    bw.write("]\n");
                }

            }
        }


        br.close();
        bw.close();
    }

}


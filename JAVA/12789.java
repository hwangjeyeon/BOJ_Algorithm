import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 난장판으로 서있는 입력 받는 줄을 리스트로, 현재 통과하지 못하는 숫자들을 임시로 저장해두는 줄을 스택으로 저장한다
 * - 비교하는 줄은 스택을 사용하지 않고 단순히 변수값만으로 비교해도 된다.
 * - 검사할 것은 다음과 같다.
 * 1. 비교하는 값인 snackNumber와 리스트의 현재 값이 같은지
 * 2. 만약 대기하는 waitingStore 스택이 비어있지 않다면 그 peek값이 snackNumber와 같은지
 *
 * - 1번이 그렇다면 snackNumber의 값을 증가시키고, 그렇지 않다면 그 값을 stack에 넣는다
 * - 2번이 그렇다면 while문으로 반복해서 같을때까지 snackNumber 값을 증가시키고, 스택을 pop한다.
 * - 최종적으로 스택이 비어있으면 Nice, 아니면 Sad를 출력한다.
 * 
 * - 2번의 경우를 생각 못해서 좀 고민했던 문제다. 그것만 아니면 쉬운 문제
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
        List<Integer> waitingList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            waitingList.add(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> waitingStore = new Stack<>();
        int snackNumber = 1;

        for(int i=0; i<n; i++){
            while(!waitingStore.isEmpty() && waitingStore.peek() == snackNumber){
                waitingStore.pop();
                snackNumber++;
            }

            if (waitingList.get(i) == snackNumber) {
                snackNumber++;
            }else{
                waitingStore.push(waitingList.get(i));
            }
        }
        while(!waitingStore.isEmpty()){
            if(waitingStore.pop() != snackNumber){
                break;
            }
            snackNumber++;
        }

        if(waitingStore.isEmpty()){
            bw.write("Nice");
        }else{
            bw.write("Sad");
        }

        br.close();
        bw.close();
    }


}

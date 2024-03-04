import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. Map을 써야하나라는 고민을 잠깐 했지만 딱히 키:벨류관계는 아니고 클래스 필드로 설정하면 될 것 같아 Homework 클래스를 만들었다
 * 2. 큐나 덱을 쓰는지 않았는데 문제 진행 방식을 보니 스택이 더 적합해서 스택을 선택하였다
 * 3. input은 split으로 나눠서 1일때와 0일때를 구분지었다
 * 4. 1일때는 스택에 넣어준다. 이때 time을 1 감소시켜서 넣어준다
 * 5. 0이면 time이 0보다 크고 스택이 비어있지 않다면 스택의 꼭대기값의 time필드를 1 감소시킨다
 * 6. 이후 스택이 비어있지 않고 시간이 0일때는 해당 과제를 완료한 것이므로 ans에 value를 더해준다
 * 7. 최종적으로 완성한 ans를 출력하면 정답이 된다.
 * 
 * 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

class Homework{
    int value;
    int time;

    public Homework(int value, int time) {
        this.value = value;
        this.time = time;
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Homework> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("1")){
                int value = Integer.parseInt(input[1]);
                int time = Integer.parseInt(input[2]);
                s.push(new Homework(value, time-1));
            }else{
                if(!s.isEmpty() && s.peek().time > 0){
                    s.peek().time -= 1;
                }
            }

            if(!s.isEmpty() && s.peek().time == 0){
                ans += s.pop().value;
            }

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }


}

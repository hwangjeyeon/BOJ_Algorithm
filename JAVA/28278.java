import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 그냥 주어진 조건을 스택과 조건문으로 풀어나가면 되는 문제다
 * - 한가지 생각할 점이라면, 입력이 사이에 띄어쓰기를 두고 2글자 이상 들어오는 경우이다.
 * - 이 경우는 먼저 String으로 문자열을 받고 문자열의 길이가 1보다 큰 경우 StringTokenizer 활용, 아닌 경우는 그대로 파싱해서 해결한다.
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
        StringTokenizer st;
        int input;
        Stack<Integer> stacks = new Stack<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length() > 1){
                st = new StringTokenizer(s);
                input = Integer.parseInt(st.nextToken());
                if(input == 1){
                    input = Integer.parseInt(st.nextToken());
                    stacks.push(input);
                }
            }else{
                input = Integer.parseInt(s);
                if(input == 2){
                    if(!stacks.isEmpty()){
                        bw.write(stacks.pop()+"\n");
                    }else{
                        bw.write(-1+"\n");
                    }
                }else if(input == 3){
                    bw.write(stacks.size() + "\n");
                }else if(input == 4){
                    if(stacks.isEmpty()){
                        bw.write(1+"\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                }else if(input == 5){
                    if(!stacks.isEmpty()){
                        bw.write(stacks.peek() + "\n");
                    }else{
                        bw.write(-1 + "\n");
                    }
                }

            }
        }


        br.close();
        bw.close();
    }


}

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 덱에 대한 기능들을 공부하는 문제이다
 * - 그냥 주어진 조건에 맞춰서 출력하는 기능 설계하면 된다.
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
        Deque<Integer> de = new ArrayDeque<>();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            String command = br.readLine();
            if(command.length() > 1){
                st = new StringTokenizer(command);
                int commands = Integer.parseInt(st.nextToken());
                if(commands == 1){
                    de.addFirst(Integer.parseInt(st.nextToken()));
                }else if(commands == 2){
                    de.addLast(Integer.parseInt(st.nextToken()));
                }
            }else{
                int commands = Integer.parseInt(command);
                if(commands == 3){
                    if(de.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(de.pollFirst() + "\n");
                    }
                }else if(commands == 4){
                    if(de.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(de.pollLast() + "\n");
                    }
                }else if(commands == 5){
                    bw.write(de.size()+"\n");
                }else if(commands == 6){
                    if(de.isEmpty()){
                        bw.write(1+"\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                }else if(commands == 7){
                    if(de.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(de.getFirst() + "\n");
                    }
                }else if(commands == 8){
                    if(de.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(de.getLast() + "\n");
                    }
                }
            }
        }



        br.close();
        bw.close();
    }
}

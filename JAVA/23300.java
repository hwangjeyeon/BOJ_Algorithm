import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 덱 두개를 써서 BACK과 FRONT 역할을 하게 만들면 된다
 * 2. 주어진 문제의 프로세스 대로 구현하면 된다
 * 3. 압축할 때는, 중복되는 한가지 경우만 압축하는 것이 아니고 모든 BACK을 확인해서 압축해준다
 * 4. LAST와 FIRST를 어떻게 써야할지 잘 결정만 하면 된다
 * 5. 이 문제에서 의문점은 NOW의 초기 값이 0이면 통과하는데 -1이면 틀려버린다. 아마 음수번쨰 페이지가 있는듯 하다..
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(q)
 * 공간복잡도: O(q)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();
        int now = 0;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            switch(query){
                case "B":
                    if(back.isEmpty()){
                        continue;
                    }
                    front.addFirst(now);
                    now = back.pollLast();

                    break;
                case "F":
                    if(front.isEmpty()){
                        continue;
                    }
                    back.addLast(now);
                    now = front.pollFirst();

                    break;
                case "A":
                    if(now != 0){
                        back.addLast(now);
                    }
                    front.clear();
                    now = Integer.parseInt(st.nextToken());
                    break;
                case "C":
                    Deque<Integer> tmp = new ArrayDeque<>();

                    while(!back.isEmpty()){
                        if(tmp.isEmpty()){
                            tmp.addLast(back.pollLast());
                            continue;
                        }
                        if(Objects.equals(tmp.peekLast(), back.peekLast())){
                            back.pollLast();
                            continue;
                        }
                        tmp.addLast(back.pollLast());
                    }
                    while(!tmp.isEmpty()){
                        back.addFirst(tmp.pollFirst());
                    }
                    break;
            }
        }

        bw.write(now+"\n");
        if(back.isEmpty()){
            bw.write("-1");
        }else{
            while(!back.isEmpty()){
                bw.write(back.pollLast() + " ");
            }
        }

        bw.write("\n");
        if(front.isEmpty()){
            bw.write("-1");
        }else{
            while(!front.isEmpty()){
                bw.write(front.pollFirst() + " ");
            }
        }


        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 풀이 방법: 최대힙과 최소힙처럼 우선순위 큐를 사용하되, compare를 추가해서 푸는 방법입니다
 * 접근 방법: 문제를 보고 우선순위 큐를 사용해야 하고, 우선순위 큐의 조건을 변경해서 풀어야겠다고 생각했습니다
 * 변수 선언: 
 * PriorityQueue<Long> ans = 우선순위큐
 * -> @Override
 *             public int compare(Long o1, Long o2) {
 *
 *                 long tmp1 = Math.abs(o1);
 *                 long tmp2 = Math.abs(o2);
 *                 if(tmp1 != tmp2){
 *                     return Long.compare(tmp1, tmp2);
 *                 }else{
 *                     return Long.compare(o1, o2);
 *                 }
 *             } 
 * 위 과정을 통해서 절댓값이 같으면 두 수를 비교하여 오름차순 정렬, 같지 않으면 절댓값으로 두 수를 비교하여 오름차순 정렬을하게 했습니다
 * int N = 입력 횟수
 * long x = 입력 받을 원소 혹은 0
 * 풀이 과정: 
 * 1. 우선순위 큐의 정렬 조건을 만들어줍니다
 * 2. 이후 과정은 최소힙,최대힙 과정과 동일합니다.
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> ans = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {

                long tmp1 = Math.abs(o1);
                long tmp2 = Math.abs(o2);
                if(tmp1 != tmp2){
                    return Long.compare(tmp1, tmp2);
                }else{
                    return Long.compare(o1, o2);
                }
            }
        });
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            long x = Long.parseLong(br.readLine());
            if(x != 0 ){
                ans.add(x);
            }else{
                if(!ans.isEmpty()){
                    bw.write(ans.poll()+"\n");
                }else{
                    bw.write("0\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 풀이 방법: BFS 탐색 알고리즘을 이용하여 풀었습니다.
 * 접근 방법: 예전 C++ 테트리스 게임 제작을 시도했을 때가 생각났습니다. 상하좌우를 비교해서 방문 여부를 체크하고 풀고, 해당 배열의 모서리 부분을 감싸는 배열을 선언하여 -1으로 선언해두자라고 생각했습니다. -> index 아웃 문제 해결 목적
 * 풀이 과정:
 * 먼저 다음과 같은 기준을 세웠습니다
 *   - 배열의 모서리를 -1로 둘러싼다
 *   - 방문 배열을 따로 만들지 않고 방문했을 경우 1을 2로 바꿔준다
 *   - 탐색할 때 내 상하좌우를 다 받아오고 1이 있으면 그 지점을 기준으로 다시 너비 탐색을 한다
 *   - 지렁이 배치할 때, 각 좌표값의 +1만큼해줘서 배치한다
 * 그리고 다음과 같은 방식으로 풀었습니다
 * 1. 1,1부터 N-1, M-1까지 탐색을 진행한다
 * 2. 처음 1을 발견하면 해당 부분을 2로 바꾼다
 * 3. 그리고 그 주위에 1이 있는지 확인하고 1이 있으면 큐에 좌표를 넣는다
 * 4. 큐가 빌때까지 반복문을 돌리는데 먼저 큐에서 값을 하나 꺼내서 그 좌표값을 2로 만들고 상하좌우를 확인한다
 * 5. 상하좌우에 1이 있으면 그 좌표를 큐에 넣는다
 * 6. 해당 과정을 마치면 ans의 값을 1 증가시킨다.
 * 
 * 큐에 넣는 값을 자유자재로 넣고 싶은데 아직 미숙하여 다음과 같이 큐에 넣었습니다
 * - 큐에 넣는 방식 -> 세로, 가로 순으로 넣어준다 -> 어차피 poll 두번해주면 되기 때문에...
 * 
 * 문제 발생:
 * - 로직은 잘 동작하였으나 다음과 같은 문제가 발생하였습니다: "메모리 초과"
 * 1. 아무리 머리를 굴려보아도 52*52정도인데 메모리 초과가 발생할 수 없었습니다
 * 2. 해결방법을 찾고자 질문 게시판을 찾아보았고, 그 결과 원인을 파악할 수 있었습니다. 
 * 3. 바로 방문 체크를 상하좌우에 방문할 장소가 있는지 탐색할때 해줘야 한다는 것이었습니다 -> 이렇게 안 할 경우 중복으로 큐에 들어가게 되어 메모리 초과가 발생하게 됩니다.
 * 4. 따라서 해당 문제를 해결하기 위해 방문 장소 탐색 전에 방문 체크를 하던 것을 방문 장소 탐색할때 발견하면 방문 체크하도록 이동해주었습니다
 * ex) fields[chk1][chk2] = 2; => fields[chk1][chk2-1] = 2; 이런식으로 변경
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int bugs = Integer.parseInt(st.nextToken());
            int[][] fields = new int[M+2][N+2];
            int ans = 0;
            for(int j=0; j<M+2; j++){
                for(int k=0; k<N+2; k++){
                    if(j == 0 || k == 0 || j == M+1 || k == N+1){
                        fields[j][k] = -1;
                    }else{
                        fields[j][k] = 0;
                    }
                }
            }

            for(int j=0; j<bugs; j++){
                st = new StringTokenizer(br.readLine());
                int chk1 = Integer.parseInt(st.nextToken())+1;
                int chk2 = Integer.parseInt(st.nextToken())+1;
                fields[chk2][chk1] = 1;
            }

            Queue<Integer> killer = new LinkedList<>();
            for(int j=1; j<M+1; j++){
                for(int k=1; k<N+1; k++){
                    if(fields[j][k] == 1){

                        fields[j][k] = 2;
                        killer.add(j);
                        killer.add(k);

                        while(!killer.isEmpty()){
                            int chk1 = killer.poll();
                            int chk2 = killer.poll();
                            if(fields[chk1][chk2-1] == 1){
                                killer.add(chk1);
                                killer.add(chk2-1);
                                fields[chk1][chk2-1] = 2;
                            }
                            if(fields[chk1][chk2+1] == 1){
                                killer.add(chk1);
                                killer.add(chk2+1);
                                fields[chk1][chk2+1] = 2;
                            }

                            if(fields[chk1-1][chk2] == 1){
                                killer.add(chk1-1);
                                killer.add(chk2);
                                fields[chk1-1][chk2] = 2;
                            }

                            if(fields[chk1+1][chk2] == 1){
                                killer.add(chk1+1);
                                killer.add(chk2);
                                fields[chk1+1][chk2] = 2;
                            }
                        }
                        ans++;
                    }
                }
            }
            bw.write(ans+"\n");
            if(i!=T-1){
                st = new StringTokenizer(br.readLine());
            }
        }
            br.close();
            bw.close();
    }
}

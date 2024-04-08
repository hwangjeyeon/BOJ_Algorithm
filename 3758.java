import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 정렬을 이용하는 문제다. 
 * 2. 저장해야할 필드가 너무 많아 클래스를 만들어서 관리하였따
 * 3. teamId와 순서, 횟수, 점수합산 모두 int 필드로 관리했고, 문제당 최고점수는 map으로 관리하였다
 * 4. 순서대로 클래스를 만들어준 뒤에 정렬을 주어진 조건에 맞춰서 구현하였다
 * 5. 이후 주어진 팀 id랑 같은 팀의 id를 찾아서 발견한 순회의 j값 + 1을 순위로 지정하여 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T*N*M)
 * 공간복잡도: O(nm)
 *
 */

class Team{
    int teamId;
    Map<Integer, Integer> map;
    int order;
    int scores;
    int count = 0;

    public Team(int teamId, Map<Integer, Integer> map, int order) {
        this.teamId = teamId;
        this.map = map;
        this.order = order;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int t = Integer.parseInt(st.nextToken()); // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 개수
            List<Team> teams = new ArrayList<>();

            // 초기화
            for (int j = 0; j < n; j++) {
                teams.add(new Team(j+1, new HashMap<>(), 0));
            }

            // 입력값 처리
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                teams.get(id-1).order = j+1;
                teams.get(id-1).map.put(num, teams.get(id-1).map.getOrDefault(num,0));
                if(teams.get(id-1).map.get(num) < score){
                    teams.get(id-1).map.put(num, score);
                }
                teams.get(id-1).count++;
            }

            // 문제 접수 합산
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int l = 0; l < k; l++) {
                    tmp += teams.get(j).map.getOrDefault(l+1,0);
                }
                teams.get(j).scores = tmp;
            }

            Collections.sort(teams, (o1, o2) ->{
                if(o1.scores == o2.scores){
                    if(o1.count == o2.count){
                        return o1.order - o2.order;
                    }
                    return o1.count - o2.count;
                }

                return o2.scores - o1.scores;
            });
            for (int j = 0; j < n; j++) {
                if(teams.get(j).teamId == t){
                    bw.write(j+1+"\n");
                    break;
                }
            }

        }

        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - Map과 List를 활용한 버전이다.
 * - 소프트웨어 마에스트로 1차 코테를 이 문제 풀고 나서 봤다면 조금 더 많이 풀 수 있지 않았을까 싶다..
 * - 팀 이름을 키로 하며, 값으로는 멤버들의 이름을 담은 리스트를 가지는 map을 선언하고 입력으로 들어온 멤버 이름들을 저장한다
 * - 이어서 0번일때는 그냥 키 값을 가져와서 출력하고 1번일때는 엔트리셋으로 가져와서 해당하는 리스트에 멤버 이름이 있으면, 그 키값을 가져와 출력한다
 * 
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                members.add(br.readLine());
            }
            Collections.sort(members);
            map.put(teamName, members);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int number = Integer.parseInt(br.readLine());
            if(number == 1){
                for(Map.Entry<String, List<String>> stringListEntry : map.entrySet()){
                    if(stringListEntry.getValue().contains(name)){
                        bw.write(stringListEntry.getKey()+"\n");
                        break;
                    }
                }
            }else{
                List<String> members = map.get(name);
                for (String member : members) {
                    bw.write(member+"\n");
                }
            }
        }

        br.close();
        bw.close();
    }

}


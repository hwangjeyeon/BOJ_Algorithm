import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - map에 익숙해지자. 깡 구현 문제들 대부분이 for문 반복보다는 map활용 문제가 많았다.
 * - 그리고 무엇보다 이 문제는 map을 활용하면 정말 쉬운 문제다
 * - key값으로 이름을 넣고 enter과 leave를 value로 넣으면 된다. 동명이인이 없어서 key값에 중복이 없기 때문이다
 * - map을 정렬하는 방법은 리스트를 만들어서 그곳에 넣은 뒤 Collection으로 정렬해주면 된다
 * - 이때 enter이 value로 있는 key값만을 리스트에 넣어주기 위해 stream().filter().map(Map.Entry::getKey).collect(Collectors.toList());를 사용하였다
 * - 이후 Collections.reverse()를 사용해서 key 값이 담긴 리스트를 내림차순 정렬한다 (오름차순은 Collections.sort()를 하면 된다.)
 * -> 이 부분에서 계속 틀렸다고 나왔다. 왜냐하면 Collections.reverse()는 단순히 리스트의 값들을 역으로 바꿔주기 때문이다
 * -> 따라서 사전순으로 정렬하고 싶다면 Collections.reverseOrder()를 사용해야한다
 * -> 그렇기에 users.sort(Comparator.reverseOrder)를 사용하였다.
 * - 이후 리스트의 값을 foreach문으로 출력한다.
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
        HashMap<String, String> logs = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String keys = st.nextToken();
            String value = st.nextToken();
            if(logs.containsKey(keys)){
                logs.remove(keys);
            }else{
                logs.put(keys,value);
            }
        }

        List<String> users = new ArrayList<>(logs.keySet());
        users.sort(Comparator.reverseOrder());

        for(String key: users){
            bw.write(key+"\n");
        }

        br.close();
        bw.close();
    }

}

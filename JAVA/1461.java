import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 일단 입력 리스트를 오름차순으로 정렬한다.
 * - 양수 리스트와 음수 리스트를 나누는 것이 핵심이다.
 * - 그 다음 두 리스트 중 어떤 리스트가 더 큰지를 파악해서 더 큰 리스트의 가장 큰 값은 곱하지 않고 저장한다 (1)
 * - 양수 리스트와 음수리스트를 각각 순회하는데 이때 현재 i를 m으로 나눴을 때 나머지 0인 경우만 그 값을 더한다. 이때 위에서 말한 조건에 해당하지 않을 경우, 2를 곱해준다. (2)
 * -> 왜냐하면 왔다가 돌아가야 하는 걸음까지 생각해야하기 때문이다. (맨 마지막은 돌아가지 않아서 곱하지 않음)
 * - 양수 리스트는 내림차순으로 정렬한다. 왜냐하면 큰 거리를 기준으로 걸음 수를 세기 때문이다.
 * -> 이 기준으로 세어야지 더 그 것보다 작은 거리를 왔다갔다 하지 않으면서, 큰 거리를 가는 길에 책을 제자리에 둘 수 있기 때문이다
 * - 음수 리스트는 오름차순으로 정렬해야하는데, 이미 오름차순으로 처음에 정렬했기 때문에 따로 정렬하지 않는다
 * - (1)과 (2)의 과정을 반복해서 ans에 배열에 저장하고 출력한다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> bookPosition = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            bookPosition.add(Integer.parseInt(st.nextToken()));
        }
        bookPosition = bookPosition.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> posPosition = new ArrayList<>();
        List<Integer> negPosition = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(bookPosition.get(i) > 0){
                posPosition.add(bookPosition.get(i));
            }else if(bookPosition.get(i) < 0){
                negPosition.add(bookPosition.get(i));
            }
        }
        int max = -10001;
        int min = 10001;
        if(posPosition.isEmpty()){
            max = 0;
        }
        for(int i=0; i<posPosition.size(); i++){
            if(max < posPosition.get(i)){
                max = posPosition.get(i);
            }
        }
        if(negPosition.isEmpty()){
            min = 0;
        }
        for(int i=0; i<negPosition.size(); i++){

            if(min > negPosition.get(i)){
                min = negPosition.get(i);
            }
        }

        int where;
        if(Math.max(max, Math.abs(min)) == max){
            where = 1;
        }else{
            where = -1;
        }
        int ans = 0;
        Collections.sort(posPosition, Collections.reverseOrder());

        for(int i=0; i<posPosition.size(); i++){
            if(i%m == 0 && where == 1){
                ans+= posPosition.get(i);
                where = 0;
            }else if(i%m == 0){
                ans += (2 * posPosition.get(i));
            }
        }
        for(int i=0; i<negPosition.size(); i++){
            if(i%m == 0 && where == -1){
                ans += Math.abs(negPosition.get(i));
                where=0;
            }else if(i%m == 0){
                ans += (2 * Math.abs(negPosition.get(i)));
            }
        }


        bw.write(ans + "");

        br.close();
        bw.close();
    }

}

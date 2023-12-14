import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 입력받은 사과 리스트를 오름차순 정렬한다.
 * - 해당 리스트를 순회하면서, 스네이크버드보다 길이가 작거나 같으면 스네이크버드의 길이를 1 증가시킨다
 * - 만약 스네이크버드보다 크면 반복문을 break하고 스네이크버드의 길이를 출력한다.
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
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> height = new ArrayList<>();

        for(int i=0; i<n; i++){
            height.add(Integer.parseInt(st.nextToken()));
        }

        height = height.stream().sorted().collect(Collectors.toList());

        for(int i=0; i<height.size(); i++){
            if(L >= height.get(i)){
                L++;
            }else{
                break;
            }
        }

        bw.write(L + "");

        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * - 중앙값 때문에 리스트로 받은 다음 오름차순 정렬해서 평균과 중앙값 구한다음 출력하면 된다
 * - 자꾸 컴파일 에러 떠서 원인이 뭔가 찾아봤더니 arr = arr.stream().sorted().toList();가 자바 16이상부터 지원하기 때문이라고 한다...
 * - 백준은 자바 11까지 지원하기 때문에 다음과 같이 바꿔주어야 한다
 * -> arr = arr.stream().sorted().collect(Collectors.toList());
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();
        int avg = 0;
        int median = 0;
        for(int i=0; i<5; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        arr = arr.stream().sorted().collect(Collectors.toList());
        for(int i=0; i<5; i++){
            if(i==2){
                median = arr.get(i);
            }
            avg += arr.get(i);
        }

        bw.write(avg/5 + "\n" + median);



        br.close();
        bw.close();
    }


}

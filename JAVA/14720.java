import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 문제를 제대로 이해 못했어서 조금 시간이 걸렸었다
 * - 문제에서 주어진 순서가 깨진 순간부터 그 이후의 우유는 못 먹는다고 생각했다
 * - 그러나 그것이 아니었고 그냥 처음부터 끝까지 쭉 다 돌아다니면서, 순서에 맞춰서 마시는 횟수를 세면 되는 문제였다
 * - 그렇게 했을 때, 현재 마신 drinkState 변수를 선언해서, 반복문과 조건문을 잘 조합하면 쉽게 풀린다.
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> milkType = new ArrayList<>();
        for(int i=0; i<n; i++){
            milkType.add(Integer.parseInt(st.nextToken()));
        }
        int drinkCount = 0;
        int drinkState = 0;

        for(int i = 0; i< milkType.size(); i++){
            if(drinkState == 0 && milkType.get(i) == 0){
                drinkCount++;
                drinkState = 1;
            }else if(drinkState == 1 && milkType.get(i) == 1){
                drinkCount++;
                drinkState = 2;
            }else if(drinkState == 2 && milkType.get(i) == 2){
                drinkCount++;
                drinkState = 0;
            }

        }


        bw.write(drinkCount + "");


        br.close();
        bw.close();
    }

}

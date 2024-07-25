import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 리스트를 이용하자. 좀비의 정보를 가지고 있을 리스트와 데미지 정보를 보관하고 있을 리스트를 만들자
 * 2. 데미지를 미리 저장해두자. 저장해두는 데미지는 간단하다. ml까지는 현재 지점 + 1의 mk의 곱만큼 넣어주면 되고, ml이후부터는 ml * mk의 곱을 넣어주면 된다.
 * 3. 이제 데미지 리스트를 순회를 돌면서 현재 좀비 체력보다 데미지가 높은지 확인한다. 높지 않다면 폭탄을 사용해야 한다
 * 4. 폭탄을 사용하기 전에 먼저 폭탄의 개수를 확인한다. 0개보다 적거나 같으면 NO를 출력한다
 * 5. 폭탄이 있다면 사용한다. 하지만 폭탄을 사용하면서, 기관총을 사용하지 못해 이후 ml-1까지는 mk만큼 데미지가 차감되어야 한다
 * 6. 하지만 연달아 폭탄을 사용하는 경우, 그 여파의 종료 범위가 달라지고 차감되어야 하는 데미지도 달라진다
 * 7. 따라서 bomb이라는 큐를 만들고 폭탄 터질때, 현재 지점 + ml -1 지점을 넣어준다
 * 8. 이후, 차감 데미지는 만약 현재 지점이 현재지점 + ml -1 보다 작거나 같다면 큐의 크기 * mk만큼 해준다
 * 9. 만약 크다면 poll해주면 된다.
 * 10. 이 과정을 3번 과정에서 확인해준다. bomb 큐가 비어있을 수도 있기 때문에 비어있는지 여부도 꼭 체크해준다.
 * 11. lose true면 NO, false면 YES를 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O(l)
 * 공간복잡도: O(l)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ml = Integer.parseInt(st.nextToken());
        int mk = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> damage = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
            if(i+1 <= ml){
                damage.add((i+1) * mk);
            }else{
                damage.add(ml * mk);
            }
        }
        boolean lose = false;
        Queue<Integer> bomb = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            int health = list.get(i);
            if(!bomb.isEmpty()){
                if(bomb.peek() < i){
                    bomb.poll();
                }
                if(!bomb.isEmpty()){
                    health += mk * bomb.size();
                }
            }

            if(health > damage.get(i)){
                if(c <= 0){
                    lose = true;
                    break;
                }
                c--;
                bomb.add(i+ml-1);
            }
        }

        if(!lose){
            bw.write("YES");
        }else{
            bw.write("NO");
        }


        
        br.close();
        bw.close();
    }
}


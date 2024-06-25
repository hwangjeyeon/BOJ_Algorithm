import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 일단 상민이랑 지수인지 먼저 구분
 * 2. 1보다 큰지 비교하고 크면 상민이랑 지수에 해당하는 숫자를 time에 더하고 count를 1 빼서 다시 pq에 넣기, 그리고 상민 혹은 지수 큐에 count넣고 count++
 * 3. 1보다 작으면 큐에 넣지 않고, 상민 혹은 지수 큐에 count넣고 count++
 *
 *
 * 1. 위 풀이과정에는 한가지 허점이 존재한다. 처음 들어온 요청에 대해 반복해서 작업하고 있을 때, 추가 요청이 들어오는 경우 시간 갱신이 힘들다는 것이다.
 * 2. 따라서 접근을 다르게 하였다. 아예 입력할 때, count만큼 반복해서 큐에 넣어주고, 그 누적 시간 만큼 이후 들어오는 요청에 더해서 넣는 방식이다
 * 3. 해당 문제를 해결하기 위해 떠올린 방법은 우선순위 큐를 사용하는 방식이었다
 * 4. 미리 만들어둔 클래스 타입을 관리하는 우선순위 큐를 선언하고 time을 기준으로 오름차순 정렬, 같다면 color를 기준으로 오름차순 정렬한다
 * 5. 이후 각각의 리스트에다가 우선순위 큐가 빌 때까지 color 필드를 기준으로 저장한다. 순서는 count라는 변수를 별도로 선언해서 리스트에 넣을 때마다 count++해준다
 * 6. 이후 주어진 양식에 맞춰 출력한다.
 *
 * 해결방법:
 * 1. 처음에 리스트를 LinkedList<>()로 선언하였다. 이때 시간초과 문제가 발생하였다.
 * 2. 이후 ArrayList<>()로 선언하였더니 시간초과 문제가 해결되었다.
 * 3. LinkedList와 ArrayList의 get에서의 시간복잡도를 비교해보자. LinkedList는 O(n), ArrayList는 O(1)이다.
 * 4. ArrayList는 메모리에 하나의 정렬된 묶음으로 되어 있지만 LinkedList는 불규칙하게 메모리에 저장되어 있다. 따라서 탐색하는데 시간이 발생하고, get에서의 확연한 시간차이를 보인다.
 * 5. 해당 문제에서는 LinkedList를 사용하면 시간초과가 발생한다. 따라서 ArrayList로 해결해야한다.
 * 6. 정확하게 왜 시간초과가 발생하는지 계산해보면 최악의 경우 N*m으로 1000 * 100 = 100000 시간복잡도가 발생한다. 
 * 7. 이때 ArrayList는 O(1)이므로 6번 시간복잡도로 끝나서 1초 시간 제한 이내에 해결할 수 있지만 LinkedList의 시간복잡도가 O(n)이기 때문에 6번 시간복잡도에 더 곱해야하는 문제가 발생한다.
 * 8. O(n^2)이라는 최악의 결과를 낳을 수 있고 해당 문제에서는 시간초과로 그 결과를 보여주었다.
 * 9. 따라서 꼭 ArrayList를 사용하자
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n)
 *
 */
class Present{

    int time;
    char color;

    public Present(int time, char color) {
        this.time = time;
        this.color = color;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Present> pq = new PriorityQueue<>((o1,o2) ->{
            if(o1.time == o2.time){
                return o1.color - o2.color;
            }
            return o1.time - o2.time;
        });
        int tmpA = 0;
        int tmpB = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                if(color == 'B'){
                    if(tmpA >= time){
                        pq.add(new Present(tmpA, color));
                        tmpA += A;
                    }else{
                        pq.add(new Present(time, color));
                        tmpA = time + A;
                    }
                }else{
                    if(tmpB >= time){
                        pq.add(new Present(tmpB, color));
                        tmpB += B;
                    }else{
                        pq.add(new Present(time, color));
                        tmpB = time + B;
                    }
                }
            }
        }
        int count = 1;
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        while(!pq.isEmpty()){
            Present present = pq.poll();
            if(present.color == 'B'){
                p1.add(count);
            }else{
                p2.add(count);
            }
            count++;
        }

        bw.write(p1.size() + "\n");
        for (int i = 0; i < p1.size(); i++) {
            bw.write(p1.get(i) + " ");
        }
        bw.write("\n" + p2.size() + "\n");
        for (int i = 0; i < p2.size(); i++) {
            bw.write(p2.get(i)+" ");
        }


        br.close();
        bw.close();
    }



}


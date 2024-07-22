import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 조건에 의해 최소 스패닝 트리를 구현하라는 것을 확인할 수 있다
 * 2. 크루스칼 알고리즘을 이용하여 해당 문제를 풀었다
 * 3. 주어진 두 좌표와 그 좌표를 구분할 번호를 가지는 Node를 하나 만들고 입력값을 관리해줄 Node 배열을 하나 만든다
 * 4. 간선 클래스도 만드는데 시작지점, 끝 지점, 비용을 필드로 갖는다. 배열로 안 만들고 이렇게 만드는 이유는 비용이 다른 두 필드 타입과 다르기 떄문이다
 * 5. 좌표평면에서 두 점 사이의 거리는 sqrt((x1-x2)^2 + (y1-y2)^2)이다 이점을 이용하여 cost로 산정해둔다
 * 6. 이중 포문을 통해 중복되지 않도록 모든 정점을 이어주는 간선 리스트를 만들어준다. 
 * 7. 비용을 기준으로 오름차순 정렬한 뒤, 유니온파인드를 위한 부모 배열을 초기화하고 크루스칼을 진행하여 ans를 구한다
 * 8. ans를 두번째 자리까지 출력하도록 String.format을 이용하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

class Node{
    int num;
    double y;
    double x;

    public Node(int num, double y, double x) {
        this.num = num;
        this.y = y;
        this.x = x;
    }
}

class Edge{

    int start;
    int end;
    double cost;

    public Edge(int start, int end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}



public class Main {


    static List<Edge> dist;
    static Node[] stars;
    static double ans;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dist = new ArrayList<>();
        stars = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars[i] = new Node(i, b,a);
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dist.add(new Edge(stars[i].num,stars[j].num,Math.sqrt(Math.pow(stars[i].x - stars[j].x,2) + Math.pow(stars[i].y - stars[j].y,2))));
            }
        }
        dist.sort(Comparator.comparingDouble(o -> o.cost));
        ans = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        kruskal();


        bw.write(String.format("%.2f", ans));

        br.close();
        bw.close();
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x <= y){
                parent[y] = x;
            }else{
                parent[x] = y;
            }
        }
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }


    private static void kruskal() {
        for (int i = 0; i < dist.size(); i++) {
            if(find(dist.get(i).start) != find(dist.get(i).end)){
                ans += dist.get(i).cost;
                union(dist.get(i).start, dist.get(i).end);
            }
        }
    }

}


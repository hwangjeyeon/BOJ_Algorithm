import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */
class people{
    int weight;
    int height;

    public people(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        people[] people = new people[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people p = new people(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            people[i] = p;
        }
        int count = 1;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                if(people[i].height < people[j].height && people[i].weight < people[j].weight){
                    count++;
                }
            }
            rank[i] = count;
            count = 1;
        }


        for (int i = 0; i < n; i++) {
            bw.write(rank[i] + " ");
        }


        br.close();
        bw.close();
    }
}


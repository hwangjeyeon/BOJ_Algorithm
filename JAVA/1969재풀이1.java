import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 문제를 이해하는데 시간이 더 많이 걸린 문제다
 * 2. 이 문제는 각 자릿수마다 문자열들을 살펴봐야 한다. 즉 0번 인덱스에 대해 n개의 문자열을 살펴보고 1번 인덱스를 살펴보고 하는 세로 방향으로 살펴보는 문제다
 * 3. 각 자릿수마다 ACGT의 개수를 세어주는 배열을 만들어서 가장 큰 수를 찾고 그 수를 정답 문자열로 하여 완성한다
 * 4. count는 다시 nm만큼 순회하여 문자열마다 같지 않은 수를 세어서 count에 대해주고 출력해야한다
 * 5. 그리고 이 문제에서 같은 경우 사전순으로 출력하라 했으므로 switch문에서 A -> C -> G -> T순으로 해줘야지 문제를 풀 수 있게 된다.
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(n)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int[] atcg = new int[4];
            for (int j = 0; j < n; j++) {
                switch (arr[j].charAt(i)){
                    case 'A':
                        atcg[0]++;
                        break;
                    case 'C':
                        atcg[1]++;
                        break;
                    case 'G':
                        atcg[2]++;
                        break;
                    case 'T':
                        atcg[3]++;
                        break;
                }
            }
            int max = 0;
            int pos = 0;
            for (int k = 0; k < 4; k++) {
                if(max < atcg[k]){
                    pos = k;
                    max = atcg[k];
                }
            }
            if(pos == 0){
                sb.append("A");
            }else if(pos == 1){
                sb.append("C");
            }else if(pos == 2){
                sb.append("G");
            }else {
                sb.append("T");
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if(arr[i].charAt(j) != sb.toString().charAt(j)){
                    count++;
                }
            }
            ans += count;
        }

        bw.write(sb.toString() +"\n" + ans);



        br.close();
        bw.close();
    }

}

import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * if문의 연속으로 풀기
 * 1. 정렬 안하고도 풀 수 있을 것 같아 if문 연속으로 처리했다.
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 * - 정렬을 사용하여 푸는 방법
    * - compare(a,b)에서
    * 1. a<b일 경우 음수 리턴 (자리 유지)
    * 2. a==b일 경우 0 리턴 (자리 유지)
    * 3. a>b일 경우 양수 리턴(자리 바꿈)
    * 간단하게 생각하자
    * a,b에서 a가 왼쪽에 있으면 오름차순
    * a,b에서 a가 오른쪽에 있으면 내림차순
    * 시간복잡도는 더 안좋아졌지만 코드는 더 간결해졌다. compare는 정말 헷갈리는 문법이기에 반복적인 연습을 통해
    * 익숙해져야겠다.
    * 시간복잡도: O(n*log(n)) -> 반복분 n * 배열 정렬 log(n)
    * 공간복잡도: O(n)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] name = new String[n];
        int[] year = new int[n];
        int[] month = new int[n];
        int[] day = new int[n];

        for(int i=0; i<n; i++){
            name[i] = st.nextToken();
            day[i] = Integer.parseInt(st.nextToken());
            month[i] = Integer.parseInt(st.nextToken());
            year[i] = Integer.parseInt(st.nextToken());
            if(i < n-1){
                st = new StringTokenizer(br.readLine());
            }

        }
        String ans = "";
        int old = 2011;
        int old_index = -1;
        int young = 1989;
        int young_index = -1;
        for(int i=0; i<n; i++){
            if(old > year[i]){
                old = year[i];
                old_index = i;
            }else if(old == year[i]){
                if(month[old_index] > month[i]){
                    old_index = i;
                    old = year[i];
                }else if(month[old_index] == month[i]){
                    if(day[old_index] > day[i]) {
                        old_index = i;
                        old = year[i];
                    }
                }
            }
            if(young < year[i]){
                young = year[i];
                young_index = i;
            }else if(young == year[i]){
                if(month[young_index] < month[i]){
                    young_index = i;
                    young = year[i];
                }else if(month[young_index] == month[i]){
                    if(day[young_index] < day[i]) {
                        young_index = i;
                        young = year[i];
                    }
                }
            }

        }

        String[][] info = new String[n][4];
        //
        //        for(int i=0; i<n; i++){
        //            for(int j=0; j<4; j++){
        //                info[i][j] = st.nextToken();
        //            }
        //
        //            if(i < n-1){
        //                st = new StringTokenizer(br.readLine());
        //            }
        //
        //        }
        //
        //        Arrays.sort(info, new Comparator<String[]>() {
        //            @Override
        //            public int compare(String[] o1, String[] o2) {
        //                if (o1[3].equals(o2[3])) {
        //                    if (o1[2].equals(o2[2])) {
        //                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
        //                    }
        //                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
        //
        //                }
        //                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
        //            }
        //        });
        //
        //        bw.write(info[n-1][0] + "\n" + info[0][0]);

        bw.write(name[young_index] + "\n" + name[old_index]);
        br.close();
        bw.close();
    }

}

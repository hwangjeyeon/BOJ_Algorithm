import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int[][] like = new int[n*n+1][4];
        for(int p=0; p<n*n; p++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            // 좋아하는 친구 갱신 완료
            for(int i=0; i<4; i++){
                like[num][i] = Integer.parseInt(st.nextToken());
            }
            
            // 각 좌표에 대한 상태값 갱신 완료
            int[][][] state = new int[n][n][2];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    for(int k=0; k<4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny>=0 && ny < n && nx>=0 && nx < n){
                            if(arr[ny][nx] == 0){
                                state[i][j][1]++;
                            }else{
                                for(int l=0; l<4; l++){
                                    if(like[num][l] == arr[ny][nx]){
                                        state[i][j][0]++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }


            //최적의 장소를 찾는 로직
            int goodY = n*n;
            int goodX = n*n;
            int friend = 0;
            int blank = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] != 0){
                        continue;
                    }
                    
                    if(state[i][j][0] > friend){
                        goodY = i;
                        goodX = j;
                        friend = state[i][j][0];
                        blank = state[i][j][1];
                    }else if(state[i][j][0] == friend){
                        if(state[i][j][1] > blank){
                            goodY = i;
                            goodX = j;
                            blank = state[i][j][1];
                        }else if(state[i][j][1] == blank){
                            if(goodY > i){
                                goodY = i;
                                goodX = j;
                                
                            }else if(goodY == i){
                                if(goodX > j){
                                    goodY = i;
                                    goodX = j;
                                }
                            }
                        }
                    }
                    // if(num == 1 && i == 0 && j == 0){
                    //     System.out.println(friend + " " + blank);
                    // }

                }
            }
            arr[goodY][goodX] = num;
            
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int count = 0;
                for(int k=0; k<4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny>=0 && ny < n && nx>=0 && nx< n){
                        for(int l=0; l<4; l++){
                            if(like[arr[i][j]][l] == arr[ny][nx]){
                                count++;
                            }
                        }
                    }
                }
                if(count == 1){
                    ans += 1;
                }else if(count == 2){
                    ans += 10;
                }else if(count== 3){
                    ans += 100;
                }else if(count == 4){
                    ans += 1000;
                }
            }
        }
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(ans);
    }
}
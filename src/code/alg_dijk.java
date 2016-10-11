package code;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by william_lee on 8/31/16.
 */
public class alg_dijk {

    private static final int NUM=200;
    private static final int MAXD = 1000000;
    private static int[][]can;
    public static void main(String[]args){

        Scanner in = new Scanner(System.in);
        can = new int[200][200];
        for(int i=0;i<200;i++){
            for(int j=0;j<200;j++){can[i][j]=-1;}
        }

        String line;
        StringTokenizer st;
        String[]ctoks;
        int from;
        int to;
        int len;
        for(int c=1;c<=NUM;c++){
            line=in.nextLine();
            st=new StringTokenizer(line);
            from=Integer.parseInt(st.nextToken())-1;
            while(st.hasMoreTokens()) {
                ctoks = st.nextToken().split(",");
                to = Integer.parseInt(ctoks[0]) - 1;
                len = Integer.parseInt(ctoks[1]);
                can[from][to] = len;
            }
        }
        int[]dist=new int[200];
        for(int i=0;i<200;i++){ dist[i]=MAXD; }
        boolean[]v=new boolean[200];
        dist[0]=0;
        int minind;
        for(int ct=1;ct<=NUM;ct++){
            minind=-1;
            for(int i=0;i<NUM;i++){
                if(!v[i]&&(minind==-1 || dist[i]<dist[minind])){
                    minind=i;
                }
            }
            v[minind]=true;
            for(int j=0;j<NUM;j++){
                if(can[minind][j]>=0){
                    dist[j]=Math.min(dist[j], dist[minind]+can[minind][j]);
                }
            }
        }
        int[]list={7,37,59,82,99,115,133,165,188,197};
        for(int i=0;i<list.length;i++){
            System.out.print(dist[list[i]-1]+",");
        }
    }
}

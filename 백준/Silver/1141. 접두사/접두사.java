import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        for(int i=0; i<N; i++) list[i] = br.readLine();

        for(int i=0; i<N; i++){
            set.add(list[i]);

            List<String> tmpSet = new ArrayList<>(set);
            Collections.sort(tmpSet);

            for(int j=0; j<tmpSet.size()-1; j++){
                String fir = tmpSet.get(j);
                String sec = tmpSet.get(j+1);
                if(fir.length()<sec.length()){
                    boolean flag = true;
                    for(int k=0; k<fir.length(); k++){
                        if(fir.charAt(k)!=sec.charAt(k)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        set.remove(fir);
                        break;
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}

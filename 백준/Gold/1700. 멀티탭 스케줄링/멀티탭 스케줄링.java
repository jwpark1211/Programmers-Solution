import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] electronics;
    static List<Integer> multitab = new ArrayList<>();
    static int unplugCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        electronics = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            electronics[i] = Integer.parseInt(st.nextToken());
        }

        for (int curIdx = 0; curIdx < K; curIdx++) {
            int cur = electronics[curIdx];

            if (multitab.contains(cur)) continue;

            if (multitab.size() < N) {
                multitab.add(cur);
                continue;
            }

            // 앞으로 어떤 기기가 다시 사용되는지 찾기
            Map<Integer, Integer> nextUse = new HashMap<>();
            for (int i = 0; i < multitab.size(); i++) {
                int device = multitab.get(i);
                nextUse.put(device, Integer.MAX_VALUE); // 기본값: 더 이상 사용 안 됨
                for (int j = curIdx + 1; j < K; j++) {
                    if (electronics[j] == device) {
                        nextUse.put(device, j); // 가장 빠른 다음 사용 시점
                        break;
                    }
                }
            }

            // 가장 나중에 사용되거나, 안 쓰이는 기기를 찾음
            int target = -1;
            int latest = -1;
            for (int device : multitab) {
                int idx = nextUse.get(device);
                if (idx > latest) {
                    latest = idx;
                    target = device;
                }
            }

            multitab.remove(Integer.valueOf(target));
            multitab.add(cur);
            unplugCount++;
        }

        System.out.println(unplugCount);
    }
}

import java.util.*;

class Solution {
    
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1; // 초기 이동 횟수 (맨 오른쪽까지 이동하는 경우)

        for (int i = 0; i < length; i++) {
            // 현재 알파벳 변경 비용 추가
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A' 처리
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++; // 'A'가 끝나는 위치 찾기
            }

            // 최소 이동 거리 계산 (직진 vs 뒤로 돌아가기)
            move = Math.min(move, i + i + (length - next));
            move = Math.min(move, i + (length - next) + (length - next));
        }
        
        return answer + move; // 문자 변경 횟수 + 이동 횟수
    }
}

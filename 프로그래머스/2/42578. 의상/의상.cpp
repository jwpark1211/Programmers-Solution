#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> map;
    
    for(vector<string> clothe : clothes){
        map[clothe[1]]++;
    }
    
    unordered_map<string, int>::iterator iter; 
    int answer = 1;
    for(iter=map.begin(); iter!=map.end(); iter++){
        answer*=(iter->second+1);
    }
    
    return answer-1;
}
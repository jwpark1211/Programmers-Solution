#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> hm;
    
    for(vector<string> clothe : clothes){
        hm[clothe[1]]++;
    }
    
    for(auto key : hm){
        answer *= key.second+1;
    }
    
    return answer-1;
}
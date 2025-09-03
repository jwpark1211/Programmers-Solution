#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    vector<int> tmp;
    for(vector<int> command : commands){
        tmp.clear();
        for(int j=command[0]-1; j<=command[1]-1; j++) tmp.push_back(array[j]);
        sort(tmp.begin(), tmp.end());
        answer.push_back(tmp[command[2]-1]);
    }
    
    return answer;
}
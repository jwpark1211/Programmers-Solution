#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<bool> table (n+1,true);
    sort(reserve.begin(), reserve.end());
    sort(lost.begin(), lost.end());
    
    for(int i=0; i<lost.size(); i++){
        for(int j=0; j<reserve.size(); j++){
            if(lost[i]==reserve[j]){
                lost.erase(lost.begin()+i);
                reserve.erase(reserve.begin()+j);
                i--; j--;
            }
        }
    }
    
    for(int l : lost) table[l] = false;
    for(int r : reserve){
        if(r-1>=1 && table[r-1]==false) table[r-1]=true;
        else if(r+1<=n && table[r+1]==false) table[r+1]=true;
    }
    
    int answer = 0;
    for(int i=1; i<=n; i++) if(table[i]) answer++;

    return answer;
}
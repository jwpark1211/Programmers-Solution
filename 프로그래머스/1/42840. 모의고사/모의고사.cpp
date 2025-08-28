#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> man1 = {1,2,3,4,5};
    vector<int> man2 = {2,1,2,3,2,4,2,5};
    vector<int> man3 = {3,3,1,1,2,2,4,4,5,5};
    
    int cnt1 = 0;
    int cnt2 = 0;
    int cnt3 = 0;
    
    for(int i=0; i<answers.size(); i++){
        if(man1[i%man1.size()]==answers[i]) cnt1++;
        if(man2[i%man2.size()]==answers[i]) cnt2++;
        if(man3[i%man3.size()]==answers[i]) cnt3++;
    }
    
    vector<int> v {cnt1,cnt2,cnt3};
    int final_max = *max_element(v.begin(), v.end());
    if(cnt1==final_max) answer.push_back(1);
    if(cnt2==final_max) answer.push_back(2);
    if(cnt3==final_max) answer.push_back(3);


    
    return answer;
}
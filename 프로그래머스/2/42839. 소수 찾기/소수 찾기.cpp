#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> answerList;
bool isPrime(int n){
    if(n==0 || n==1) return false;
    for(int i=2; i<n; i++){
        if(n%i==0) return false;
    }
    return true;
}
void dfs(string res, vector<char> nums, vector<bool> visited){
    if(res.length()>nums.size()) return;
    else{
        //cout<<"res:"<<res<<endl;
        if(res.length()>=1 && isPrime(stoi(res))) answerList.push_back(stoi(res));
        for(int i=0; i<nums.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(res+nums[i],nums,visited);
                visited[i] = false;
            }
        }
    }
}
int solution(string numbers) {
    vector<char> nums;
    for(char c : numbers) nums.push_back(c);
    vector<bool> visited(numbers.length());
    dfs("",nums,visited);
    
    sort(answerList.begin(), answerList.end());
    auto it = unique(answerList.begin(), answerList.end());
    answerList.erase(it, answerList.end());
    return answerList.size();
}
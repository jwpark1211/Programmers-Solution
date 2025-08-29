#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string a, string b){
    if(stoi(a+b)>stoi(b+a)){
        return true;
    }
    return false;
}
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> nums;
    
    for(int i=0; i<numbers.size(); i++) 
        nums.push_back(to_string(numbers[i]));  
    sort(nums.begin(), nums.end(), compare);
    
    for(int i=0; i<nums.size(); i++){
        answer+=nums[i];
    }
    
    if(answer.length()>=2 && answer[0]=='0' && answer[1]=='0')
        answer="0";
    
    return answer;
}
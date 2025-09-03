#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string a, string b){
    if(stoi(a+b)>stoi(b+a)) return true;
    return false;
}
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> tmp;
    for(int n : numbers) tmp.push_back(to_string(n));
    sort(tmp.begin(), tmp.end(), compare);
    for(string s : tmp) answer += s;
    if(answer[0]=='0') return "0";
    return answer;
}
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    vector<string> v;
    
    string tmp = "";
    for(char c : s){
        if(c==' '){
            v.push_back(tmp);
            tmp="";
        }else{
            tmp+=c;
        }
    }
    v.push_back(tmp);
    
    string answer="";
    for(string str : v){
        for(int i=0; i<str.length(); i++){
            if(i==0) {
                string upper1 = "";  upper1+=toupper(str[i]);
                str.replace(0, 1, upper1);
            }else{
                string lower = ""; lower+=tolower(str[i]);
                str.replace(i, 1, lower);
            }
        }
        answer+=str;
        answer+=" ";
    }
    answer.pop_back();
    
    return answer;
}
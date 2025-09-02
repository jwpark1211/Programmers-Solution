#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    if(s[0]=='-') return(-1*stoi(s.substr(1,s.length()-1)));
    else return stoi(s);
}
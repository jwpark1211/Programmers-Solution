#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int tmpN=0;

bool compare(string a, string b){
    if(a[tmpN]==b[tmpN]){
        return a<b;
    }
    else if(a[tmpN]<b[tmpN]) return true;
    return false;
}
vector<string> solution(vector<string> strings, int n) {
    tmpN = n;
    sort(strings.begin(), strings.end(), compare);
    
    return strings;
}
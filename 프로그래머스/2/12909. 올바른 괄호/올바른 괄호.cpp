#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<int> st;
    for(char c : s){
        if(c=='(') st.push('(');
        else {
            if(st.empty()) return false;
            else st.pop();
        }
    }

    if(st.empty()) return true;
    return false;
}
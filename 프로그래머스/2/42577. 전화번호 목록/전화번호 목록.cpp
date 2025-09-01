#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool solution(vector<string> phone_book) { 
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());
    for(int i=0; i<phone_book.size()-1; i++){
        string a = phone_book[i];
        string b = phone_book[i+1];
        
        if(a.size()>b.size()) continue;
        
        for(int j=0; j<a.size(); j++){
            if(j==a.size()-1 && a[j]==b[j]) answer = false;
            else if(a[j]!=b[j]) break;
        }
    }
    return answer;
}
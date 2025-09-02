#include <string>
#include <iostream>
#include <regex>
#include <iterator>
using namespace std;

bool solution(string s)
{
    int p=0; 
    int y=0;
    
    for(char c : s){
        if(tolower(c)=='p') p++;
        if(tolower(c)=='y') y++;
    }
    
    return p==y;
}
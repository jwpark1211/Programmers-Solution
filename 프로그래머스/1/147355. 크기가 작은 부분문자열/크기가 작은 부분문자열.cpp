#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    int size = p.length(); //기준점
    
    for(int i=0; i<=t.length()-size; i++){
        if(p>=t.substr(i,size)){
            answer++;
        }
    }
    
    return answer;
}
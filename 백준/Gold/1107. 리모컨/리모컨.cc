#include <iostream>
#include <string>
using namespace std;

int N = 0; //이동하고자 하는 채널 번호 (0 ≤ N ≤ 500,000)
int M = 0; //고장난 번호의 개수 (0 ≤ M ≤ 10)
int broken[10]={};
int start = 100; //초기 채널 번호 
int min_click = 987654321; //최소 값(결과)

void solve(string comp){
    for(int i=0; i<=9; i++){
        if(broken[i]==0){
            string tmp = comp+to_string(i);
            min_click = min(min_click, abs(N-stoi(tmp))+(int)tmp.length());
            if(tmp.length()<6){
                solve(tmp);
            }
        }
    }
}

int main(void){
    //N입력 -> 최소값 초기화 
    cin>>N;
    min_click = abs(N-start);
    
    //M 입력 
    cin>>M;

    //broken Button - normal[0] broken[1]
    for(int i=0; i<M; i++){
        int brokenButton = -1;
        cin>>brokenButton;
        broken[brokenButton]=1;
    }

    solve("");
    cout<<min_click;
    return 0;
}
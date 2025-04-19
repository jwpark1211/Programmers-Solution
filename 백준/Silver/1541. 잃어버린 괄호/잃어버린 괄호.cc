#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    // 입력
    string formula;
    cin>>formula;
    char op[51];
    int number[51] = {0,};

    //문자열로 받은 연산식 변환 
    string num = ""; int opIdx = 0; int numIdx = 0;
    for(int i=0; i<formula.size(); i++){
        if(formula.at(i)=='+' || formula.at(i)=='-'){
            op[opIdx++] = formula.at(i);
            number[numIdx++] = stoi(num); num = "";
        }else{
            num+=formula.at(i);
        }
    }
    number[numIdx++] = stoi(num);

    int sum = number[0];
    for(int i=0; i<opIdx; i++){
        if(op[i]=='-'){
            int priority = number[i+1];
            for(int j=i+1; j<opIdx; j++){
                if(op[j]=='-'){
                    i = j-1;
                    break;
                }else{
                    priority+=number[j+1];
                    i = j+1;
                }
            }
            sum-=priority;
        }else{
            sum+=number[i+1];
        }
    }
    cout<<sum;
    
}

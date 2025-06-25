#include <iostream>
#include <algorithm>
#include <string>
#include <climits>
#include <iterator>
#include <queue>
using namespace std;

int H,W;
int block[501] = {0,};

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin>>H>>W;
    for(int i=0; i<W; i++){
        cin>>block[i];
    }

    int sum = 0;
    for(int i=1; i<W-1; i++){
        int left = *max_element(block,block+i);
        int right = *max_element(block+i+1,block+W);
        int sMax = min(left, right);
        if(sMax>block[i]){
            sum+=sMax-block[i];
        }
    }
    cout<<sum;
}
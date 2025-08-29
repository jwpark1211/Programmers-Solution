#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    long long low = 0;
    sort(times.begin(), times.end());
    
    long long high =  1LL * n * times[times.size()-1];
    
    while(low<=high){
        long long mid = (low+high)/2;
        
        long long cnt = 0;
        for(int t : times){
            cnt+= mid/t;
        }
        
        if(cnt<n){
            low = mid + 1;
        }else{
            high = mid - 1;
            answer = mid;
        }
    }
    
    return answer;
}
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int N = triangle.size();
    vector<vector<int>> sum(N, vector<int>(N,0));
   
    sum[0][0]=triangle[0][0];
    for(int i=1; i<triangle.size(); i++){
        for(int j=0; j<=i; j++){
            if(j==0){ //좌측 끝에 붙어있는 경우 
                sum[i][j]=sum[i-1][j]+triangle[i][j];
            }else{ //그 외 
                sum[i][j]=max(sum[i-1][j],sum[i-1][j-1])+triangle[i][j];
            }
        }
    }
    return *max_element(sum.at(N-1).begin(),sum.at(N-1).end());
}
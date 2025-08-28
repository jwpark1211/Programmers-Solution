#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    for(int i=0; i<sizes.size(); i++){
        int max_value = max(sizes[i][0],sizes[i][1]);
        int min_value = min(sizes[i][0],sizes[i][1]);
        sizes[i][0]=max_value;
        sizes[i][1]=min_value;
    }
    int w=0;
    int h=0;
    for(int i=0; i<sizes.size(); i++){
        w = max(w,sizes[i][0]);
        h = max(h,sizes[i][1]);
    }
    return w*h;
}
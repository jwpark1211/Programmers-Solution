#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> nums)
{
    int N = nums.size();
    int answer = 0;
    sort(nums.begin(), nums.end());
    nums.erase(unique(nums.begin(), nums.end()),nums.end());
    if(nums.size()>N/2) answer = N/2;
    else answer = nums.size();
    return answer;
}
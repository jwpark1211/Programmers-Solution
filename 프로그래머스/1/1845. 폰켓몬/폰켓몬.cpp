#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

int solution(vector<int> nums)
{
    unordered_set set(nums.begin(), nums.end());
    
    return min(nums.size()/2, set.size());
}
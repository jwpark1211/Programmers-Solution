#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    auto iter = unique(arr.begin(), arr.end());
    arr.erase(iter, arr.end());

    return arr;
}
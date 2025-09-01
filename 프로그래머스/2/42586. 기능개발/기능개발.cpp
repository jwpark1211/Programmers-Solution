#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

struct Prog{
    int progress;
    int speed;
};
vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<Prog> q;
    for(int i=0; i<speeds.size(); i++) q.push({progresses[i],speeds[i]});
    
    int day = 0;
    while(!q.empty()){
        Prog prog = q.front();
        q.pop();
        if((100-prog.progress)%prog.speed==0) 
            day = (100-prog.progress)/prog.speed;
        else day = (100-prog.progress)/prog.speed+1;
        int cnt = 1;
        while(true){
            Prog cur = q.front();
            //cout<<"day:"<<day<<endl;
            //cout<<"sum:"<<cur.progress+day*cur.speed<<endl;
            if(cur.progress+day*cur.speed>=100){
                cnt++;
                q.pop();
            } 
            else break;
        }
        answer.push_back(cnt);
    }
    
    return answer;
}
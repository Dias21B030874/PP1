#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
map<int, int> m;
map<int, vector<int>> v;
map<int, int>::iterator it;
map<int, vector<int>>::iterator it2;
 
struct node {
    int val;
    node * next;
    node(int x){
        val = x;
        next = NULL;
    }
};
 
struct ll{
    node * head;
    node * tail;
    ll(){
       head = NULL; 
       tail = NULL;
    }


    void add(int x){
        node * n = new node(x);
        if(head == NULL){
            head = tail = n;
        }else{
            tail->next = n;
            tail = n;
        }
    }


    void print(int n){
    node * temp = head;
    int tempCount = 1 , mode = 1;
    while(head) {
    ++m[head->val];
    head = head->next;
  }
    for(it = m.begin(); it != m.end(); it++) v[it->second].push_back(it->first);
    it2 = --v.end();
    sort(it2->second.begin(), it2->second.end());
    for(int i = it2->second.size() - 1; i >= 0; i--) cout << it2->second[i] << " ";
    }
};
 
int main(){
    int n;
    cin>>n;
    ll l;
    for(int i=0;i<n;i++){
        int x;cin>>x;
        l.add(x);
    }

    l.print(n);
}
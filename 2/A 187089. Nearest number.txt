#include <bits/stdc++.h>

using namespace std;
 
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


    void print(int c){
    node * temp = head;
    int i=0;
    int i1=0;
    int d=abs(c-temp->val);
    while(temp != NULL && c!=d){
        if(d>abs(c-temp->val)){
            d=abs(c-temp->val);
            i1=i;
        }
        i++;
        temp=temp->next;
    }
    cout<<i1<<" ";
    }
};
 
int main(){
    int n,a;
    cin>>n;
    ll l;
    for(int i=0;i<n;i++){
        int x;cin>>x;
        l.add(x);
    }

    cin>>a;
    l.print(a);
}
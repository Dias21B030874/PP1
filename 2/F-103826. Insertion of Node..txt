#include<iostream>

using namespace std;
struct node
{
    int val;
    // int cnt;
    node * next;
    node * prev;

    node(int x){
        val = x;
        // cnt = 0;
        next = NULL; 
        prev = NULL; 
    }
};

struct ll
{
    node * head;
    node * tail;
    ll(){
        head = NULL;
        tail = NULL;
    }
    void add(int x){
        node * newNode = new node(x);
        if(head == NULL){
            head = tail = newNode;
        }else{
            tail->next = newNode;
            tail->next->prev = tail;
            tail = newNode;
        }
    }
    void print(int k, int i){
        node * temp = head;
        node * x;
        node * y;
        node * s = new node(k);
        int t = 0;
        if(i == 0){
            cout << k << ' ';
            node * temp1 = head;
            while (temp1 != NULL){
                cout << temp1->val << " ";
                temp1 = temp1->next;
            }
        }else{
        while (temp != NULL)
        {
            if(t + 1 == i){
                x = temp->next;
                y = temp;
                y->next = s;
                s->next = x;
                break;
            }
            t++;
            
            temp = temp->next;
        }
        node * temp1 = head;
        while (temp1 != NULL){
            cout << temp1->val << " ";
            temp1 = temp1->next;
        }}
    }
};
int main(){

    int n;
    cin >> n;
    ll * l = new ll();
    for(int i = 0; i < n; i++){
        int r; cin >> r;
        l->add(r);
    }
    int k, i; cin >> k >> i; 
    l->print(k, i);
    return 0;
}
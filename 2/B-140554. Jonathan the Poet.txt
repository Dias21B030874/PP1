
#include <iostream>
 
using namespace std;
 
struct node
{
    string val;
    node * next;
 
    node(string x){
        val = x;
        next = NULL; 
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

    void add(string x){
        node * n = new node(x);
        if(head == NULL){
            head = tail = n;
        }else{
            tail->next = n;
            tail = n;
        }
    }


    void print(int a){
        node * temp = head;
        int i = 0;
        while (temp != NULL)
        {
            if(i >= a){
                cout << temp->val << ' ';
            }
            i++;
            temp = temp->next;
        }


        i = 0;
        node * temp1 = head;
        while (temp1 != NULL)
        {
            if(i < a){
                cout << temp1->val << ' ';
            }else{
                break;
            }
            i++;
            temp1 = temp1->next;
        }
        
    }

};

int main(){
 
    int n, a;
    cin >> n >> a;
    ll l;
    for(int i = 0; i < n; i++){
        string s; cin >> s;
        l.add(s);
    }
    l.print(a);
    return 0;
}
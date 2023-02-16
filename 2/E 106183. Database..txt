#include<iostream>

using namespace std;
int number = 0;
struct node
{
    string val;
    node * next;
    node * prev;

    node(string x){
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
    void add(string x){
        node * newNode = new node(x);
        if(head == NULL){
            if(x != ""){
            number++;
            head = tail = newNode;
            }
        }else{
            if(x != ""){
            node * k = tail;
            if(k->val != x){
                number++;
                tail->next = newNode;
                tail->next->prev = tail;
                tail = newNode;
            }
            }
        }
    }
    void print(){
        node * temp = tail;
        cout << "All in all: " << number << "\nStudents:";
        while (temp != NULL)
        {
            if((temp->val).size() != 0)
            cout << "\n" << temp->val;
            temp = temp->prev;
        }
        
    }
};



int main(){

    int n;
    cin >> n;
    ll * l = new ll();
    for(int i = 0; i < n; i++){
        string r; cin >> r;
        l->add(r);
    }
    l->print();
    return 0;
}
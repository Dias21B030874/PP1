#include<iostream>
using namespace std;
struct node
{
    string val;
    node * next;
    node * prev;

    node(string x){
        val = x;
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
    void add_front(string x){
        node * newNode = new node(x);
        if(!head){
            head = tail = newNode;
        }else{
            newNode->next = head;
            head->prev = newNode;
            head = newNode;
        }
        cout << "ok\n";
    }
    void add_back(string x){
        node * newNode = new node(x);
        if(!head){
            head = tail = newNode;
        }else{
            newNode->prev = tail;
            tail->next = newNode;
            tail = newNode;
        }
        cout << "ok\n";
    }
    void erase_front(){
        if(!head){
            cout << "error\n";
        }else{
            if(head == tail){
                cout << head->val << "\n"; 
                head = tail = NULL;
            }else{
            cout << head->val << "\n"; 
            head = head->next;
            // head->prev = NULL;
            }
        }
    }
    void erase_back(){
        if(!head){
            cout << "error\n";
        }else{
            if(head == tail){
                cout << head->val << "\n"; 
                head = tail = NULL;
            }else{
            cout << tail->val << "\n"; 
            tail = tail->prev;
            tail->next = NULL;
            }
        }
    }
    void front(){
        if(!head){
            cout << "error\n";
        }else{
            cout << head->val << "\n";
        }
    }
    void back(){
        if(!head){
            cout << "error\n";
        }else{
            cout << tail->val << "\n";
        }
    }
    void clear(){
        while(head != NULL){
            head = head->next;
        }
        cout << "ok\n";
    }
    void exit(){
        cout << "goodbye";
    }

};


int main(){

    string s;
    ll * l = new ll();
    while(cin >> s){
        if(s == "add_back"){
            string t; cin >> t;
            l->add_back(t);
        }
        if(s == "add_front"){
            string t; cin >> t;
            l->add_front(t);
        }
        if(s == "erase_front"){
            l->erase_front();
        }
        if(s == "erase_back"){
            l->erase_back();
        }
        if(s == "front"){
            l->front();
        }
        if(s == "back"){
            l->back();
        }
        if(s == "clear"){
            l->clear();
        }
        if(s == "exit"){
        l->exit();
        break;
        }
    }
    return 0;
}
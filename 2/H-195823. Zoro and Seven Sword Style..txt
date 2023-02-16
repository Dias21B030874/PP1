#include <iostream>
using namespace std;

int removed, sz;
 
struct Node{
    int val;
    Node* next;
    Node(): val(0), next(nullptr) {}
    Node(int x): val(x), next(nullptr) {}
    Node(Node* next): val(0), next(next) {}
    Node(int x, Node* next): val(x), next(next) {}
};
 
Node* insert(Node* head, Node* node, int p) {
  if(p > 1) insert(head->next, node, p - 1);
  else if(p) {
    node->next = head->next;
    head->next = node;
  }else {
    node->next = head;
    head = node;
  }
  return head;
}
 
Node* remove(Node* head, int p) {
  if(p > 1) remove(head->next, p - 1);
  else if(p) {
    removed = head->next->val;
    head->next = head->next->next;
  }
  else {
    removed = head->val;
    head = head->next;
  }
  return head;
}
 
Node* replace(Node* head, int p1, int p2) {
  head = remove(head, p1);
  head = insert(head, new Node(removed), p2);
  return head;
}
 
Node* reverse(Node* head) {
  Node *prev = NULL, *cur = NULL, *next = NULL;
  cur = head;
  while(cur) {
    next = cur->next;
    cur->next = prev;
    prev = cur;
    cur = next;
  }
  head = prev;
  return head;
}
 
void print(Node* head) {
  if(!head) return;
  cout << head->val << " ";
  print(head->next);
}
 
Node* cyclic_left(Node* head, int x) {
  x = x % sz;
  if(x == sz || x == 0) return head;
  Node *copy_head = head, *cur = new Node();
  cur->next = head;
  while(cur->next) cur = cur->next;
  for(int _ = 0; _ < x; _++) {
    cur->next = new Node(copy_head->val);
    copy_head = copy_head->next;
    cur = cur->next;
  }
  for(int _ = 0; _ < x; _++) head = head->next;
  return head;
}
 
Node* cyclic_right(Node* head, int x) {
  return cyclic_left(head, sz - x);
}
 
int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  Node* head = nullptr;
  while(true) {
    int command; cin >> command;
    if(command == 0) break;
    else if(command == 1) {
      int x, p;
      cin >> x >> p;
      head = insert(head, new Node(x), p);
      ++sz;
    }else if(command == 2) {
      int p;
      cin >> p;
      head = remove(head, p);
      --sz;
    }else if(command == 3) {
      print(head);
      cout << "\n";
    }else if(command == 4) {
      int p1, p2;
      cin >> p1 >> p2;
      head = replace(head, p1, p2);
    }else if(command == 5) head = reverse(head);
    else if(command == 6) {
      int x;
      cin >> x;
      head = cyclic_left(head, x);
    }else if(command == 7) {
      int x;
      cin >> x;
      head = cyclic_right(head, x);
    }
  }
  return 0;
}
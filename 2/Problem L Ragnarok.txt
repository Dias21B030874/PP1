# include <iostream>
# include <algorithm>
# include <cassert>

using namespace std;

struct Node {
  int val;
  Node *next;

  Node() {
    val = 0;
    next = NULL;
  }

};



int findMaxSum(int n, Node *head) {
	// Implement this function
    if (head == NULL)
        return 0;
 
    if (head->next == NULL)
        return head->val;

    int max_ending_here = head->val;

    int max_so_far = head->val;
 
    head = head->next;
 
    while (head != NULL) {
 
        max_ending_here = max(head->val,
                              max_ending_here + head->val);
        max_so_far = max(max_ending_here, max_so_far);
 
        head = head->next;
    }

    return max_so_far;
}
	

int main() {
  int n;
  cin >> n;

  Node *head, *tail;
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    Node *cur = new Node();
    cur -> val = x;

    if (i == 1) {
      head = tail = cur;
    } else {
      tail -> next = cur;
      tail = cur;
    }
  }

  cout << findMaxSum(n, head) << "\n";
  return 0;
}

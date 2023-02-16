/******************************************************************************

 

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

 

*******************************************************************************/
#include <iostream>
using namespace std;

int cnt = 0; 

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };
    

TreeNode *insert(TreeNode *tree, int val) {
  if(!tree) {
    tree = new TreeNode(val);
    return tree;
  }
  if(val <= tree->val) tree->left = insert(tree->left, val);
  else tree->right = insert(tree->right, val);
  return tree;
}
TreeNode *func(TreeNode * current, int k){
    if(k < current->val){
            return func(current->left,k);
        }else if(k == current->val){
            return current;
        }else if(k > current->val){
            return func(current->right,k);
        }
    }
    void answer(TreeNode * current){
        if(current == NULL) return;
        cout << current->val << " ";
        answer(current->left);
        answer(current->right);
    }
TreeNode *root;
int main()
{
    int n,p; cin >> n >> p;
    root = insert(root, p);
    for(int i = 1; i < n; i++){
        cin >> p;
        insert(root, p);
    }
    int k; cin >> k;
    TreeNode *ans = func(root,k);
    answer(ans);
    return 0;
}
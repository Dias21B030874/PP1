
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
int summ = 0;
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  int sum;
  TreeNode() : val(0), sum(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), sum(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), sum(x), left(left), right(right) {}
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
void print(TreeNode * current){
        if(current != NULL){
            print(current->right);
            cout << current->sum << " ";
            print(current->left);
        }
    }
    void find(TreeNode * current){
        if(current != NULL){
            find(current->left);
            current->sum = summ;
            summ = summ - current->val;
            find(current->right);
        }
    }
 
TreeNode *root;
int main()
{
    int n,p; cin >> n >> p;
    root = insert(root, p);
    summ = p;
    for(int i = 1; i < n; i++){
        cin >> p;
        insert(root, p);
        summ += p;
    }
    find(root);
    print(root);
    return 0;
}
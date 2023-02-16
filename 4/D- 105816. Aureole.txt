#include <iostream>
using namespace std;
int n, p, x, max_l;
int sum[5001];
struct TreeNode {
  int val, level;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), level(1), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), level(1), left(nullptr), right(nullptr) {}
  TreeNode(int x, int l) : val(x), level(l), left(nullptr), right(nullptr) {}
  TreeNode(int x, int l, TreeNode *left, TreeNode *right) : val(x), level(l), left(left), right(right) {}
 };
TreeNode *insert(TreeNode *tree, int val, int level = 1) {
  max_l = max(max_l, level);
  if(!tree) {
    tree = new TreeNode(val, level);
    sum[level] += val;
    return tree;
  }
  if(val <= tree->val) tree->left = insert(tree->left, val, level + 1);
  else tree->right = insert(tree->right, val, level + 1);
  return tree;
}
TreeNode *root;
int main() {
  cin >> n >> p;
  root = insert(root, p);
  for(int i = 1; i < n;i++) {
    cin >> p;
    insert(root, p);
  }
  cout << max_l << "\n";
  for(int i = 1; i <= max_l; i++) cout << sum[i] << " ";
  return 0;
}
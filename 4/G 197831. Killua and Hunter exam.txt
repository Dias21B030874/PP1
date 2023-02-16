/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>

using namespace std;
int cnt = 0;

struct Node {
	int data;
	Node* left;
	Node* right;

	Node(int data) {
		this->data = data;
		left = NULL;
		right = NULL;
	} 
};

Node* getMin(Node* root) {
	while (root->left != NULL) {
		root = root->left;
	}
	return root;
}

Node* add(Node* root, int data) {
	if (root == NULL) {
		return new Node(data);
	} else if (root->data > data) {
		if (root->left == NULL) {
			root->left = new Node(data);
		} else {
			root->left = add(root->left, data);
		}
	} else if (root->data < data) {
		if (root->right == NULL) {
			root->right = new Node(data);
		} else {
			root->right = add(root->right, data);
		}
	}
	return root;
}

Node* deleteNode(Node* root, int data) {
	if (root == NULL) {
		return NULL;
	} else if (root->data >= data) {
		root->left = deleteNode(root->left, data);
		return root;
	} else if (root->data <= data) {
		root->right = deleteNode(root->right, data);
		return root;
	} else {
		if (root->left == NULL && root->right == NULL) {
			delete root;
			return NULL;
		} else if (root->right == NULL) {
			Node* temp = root->left;
			delete root;
			return temp;
		} else if (root->left == NULL) {
			Node* temp = root->right;
			delete root;
			return temp;
		} else {
			Node* temp = getMin(root->right);
			root->data = temp->data;
			root->right = deleteNode(root->right, temp->data);
			return root;
		}
	}
}
Node *func(Node * current, int k){
    if(k < current->data){
            return func(current->left,k);
        }else if(k == current->data){
            return current;
        }else if(k > current->data){
            return func(current->right,k);
        }
    }
    void counter(Node * current){
        if(current != NULL){
            counter(current->left);
            cnt++;
            counter(current->right);
        }
    }
Node* find(Node* root, int x) {
	if (root == NULL) {
		return NULL;
	} else if (root->data == x) {
		return root;
	} else if (root->data < x) {
		return find(root->right, x);
	} else {
		return find(root->left, x);
	}
}
  int count(Node* root, int& cnt) {
    if (!root) return 0;

    int l = count(root->left, cnt);
    int r = count(root->right, cnt);

    cnt = max(l + r + 1, cnt);
    return max(l, r) + 1;
  }
Node *root;
int main()
{
    int n, m, k; cin >> n >> k;
    root = add(root, k);
    for(int i = 1; i < n; i++){
        cin >> k;
        add(root, k);
    }
    int cnt = 0;
    count(root, cnt);
    cout << cnt;

    return 0;
}

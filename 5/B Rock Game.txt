#include <iostream>
#include<algorithm>
#include<cmath>
using namespace std;

 

int n;
long long sum, pre;
long long a[200001];

 

void heapify_down(int v) {
    int best = v;
    if (2 * v <= n and a[2 * v] > a[best])
        best = 2 * v;
    if (2 * v + 1 <= n and a[2 * v + 1] > a[best])
        best = 2 * v + 1;
    if (v != best) {
        swap(a[v], a[best]);
        heapify_down(best);
    }
}


void heapify_up(int v) {
  while(v != 1 && a[v / 2] < a[v]) {
    swap(a[v / 2], a[v]);
    v = v / 2;
  }
}

 

void push(long long x) {
  a[++n] = x;
  heapify_down(n);
}

 

void heap_sort() {
  for(int i = 1; i <= n; i++) heapify_up(i);
}
long long get_max(){
    return a[1];
}
 long long delete_max(){
        swap(a[1], a[n]);
        n--;
        heapify_down(1);
    }

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for(int i = 1; i <= n; i++)cin >> a[i];
  heap_sort();
    while(n != 1) {
    pre = get_max();
    delete_max();
    pre = abs(pre - get_max());
    delete_max();
    push(pre);
  }
  cout << a[1];
  return 0;

}
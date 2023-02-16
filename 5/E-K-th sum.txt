#include <iostream>
using namespace std;

int q, k, i, cookie;
int a[100001];
long long sum;
string command;

void heapify_down(int v) {
  int best = v;
  if(2 * v <= i and a[2 * v] < a[best]) best = 2 * v;
  if(2 * v + 1 <= i and a[2 * v + 1] < a[best]) best = 2 * v + 1;
  if(v != best) {
    swap(a[v], a[best]);
    heapify_down(best);
  }
}

void change(int x) {
  a[1] = x;
  heapify_down(1);
}

void heapify_up(int v) {
  while(v != 1 && a[v / 2] > a[v]) {
    swap(a[v / 2], a[v]);
    v = v / 2;
  }
}

void push(int x) {
  a[++i] = x;
  heapify_up(i);
}

int get_min() { return a[1]; }

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> q >> k;
  for(int _ = 0; _ < q; _++) {
    cin >> command;
    if(command == "insert") {
      cin >> cookie;
      if(i < k) {
        sum += cookie;
        push(cookie);
      }
      else {
        if(cookie > get_min()) {
          sum += cookie - get_min();
          change(cookie);
        }
      }
    }else cout << sum << "\n";
  }
  return 0;
}
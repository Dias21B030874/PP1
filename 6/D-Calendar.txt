#include <iostream>
#include <string>
using namespace std;

int n;
string a[1001];

bool isbetter(string parent, string child) {
  int day_p = stoi(parent.substr(0, 2));
  int month_p = stoi(parent.substr(3, 2));
  int year_p = stoi(parent.substr(6, 4));
  int day_c = stoi(child.substr(0, 2));
  int month_c = stoi(child.substr(3, 2));
  int year_c = stoi(child.substr(6, 4));
  if(year_c > year_p) return true;
  else if(year_c == year_p) {
    if(month_c > month_p) return true;
    else if(month_c == month_p) return day_c > day_p;
    return false;
  }
  return false;
}

void heapify_down(int n, int v) {
  int best = v;
  if(2 * v <= n && isbetter(a[best], a[2 * v])) best = 2 * v;
  if(2 * v + 1 <= n && isbetter(a[best], a[2 * v + 1])) best = 2 * v + 1;
  if(best != v) {
    swap(a[best], a[v]);
    heapify_down(n, best);
  }
}

void heapify_up(int v) {
  while(v != 1 && isbetter(a[v / 2], a[v])) {
    swap(a[v / 2], a[v]);
    v /= 2;
  }
}

void delete_max(int &n) {
  swap(a[1], a[n--]);
}

void build() {
  for(int i = 1; i <= n; i++) heapify_up(i);
}

void heap_sort() {
  int _n = n;
  while(_n) {
    delete_max(_n);
    heapify_down(_n, 1);
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for(int i = 1; i <= n; i++) cin >> a[i];
  build();
  heap_sort();
  for(int i = 1; i <= n; i++) cout << a[i] << "\n";
  return 0;
}
#include <iostream>
using namespace std;

int n, m, target;
int a[200001];

int bin_search() {
  int l = 1, r = n, mid;
  while(l <= r) {
    mid = (l + r) / 2;
    if(a[mid] == target) return mid;
    else if(a[mid] > target) r = mid;
    else l = mid + 1;
    if(l == r) return l;
  }
  return mid;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for(int i = 1; i <= n; i++) {
    cin >> a[i];
    a[i] += a[i - 1];
  }
  for(int _ = 0; _ < m; _++) {
    cin >> target;
    cout << bin_search() << "\n";
  }
  return 0;
}
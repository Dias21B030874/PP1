#include <iostream>
#include <algorithm>
using namespace std;

int n, q, l1, r1, l2, r2, res, ll, rr;
int a[100001];

int bin_search(int target) {
  int l = 1, r = n, mid;
  while(l <= r) {
    mid = (l + r) / 2;
    if(a[mid] > target) {
      r = mid - 1;
      if(a[r] < target) return r;
    }
    else if(a[mid] < target) {
      l = mid + 1;
      if(a[l] > target) return l - 1;
    }
    else {
      l = mid;
      if(a[l + 1] != target) return l;
    }
    if(a[r] == target) return r;
  }
  return mid;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> q;
  for(int i = 1; i <= n; i++) cin >> a[i];
  sort(a, a + n + 1);
  for(int _ = 0; _ < q; _++) {
    cin >> l1 >> r1 >> l2 >> r2;
    res = bin_search(r1) - bin_search(l1 - 1) + bin_search(r2) - bin_search(l2 - 1);
    if(r1 <= r2 && l1 >= l2) res -= (bin_search(r1) - bin_search(l1 - 1));
    else if(r2 <= r1 && l2 >= l1) res -= (bin_search(r2) - bin_search(l2 - 1));
    else if(r1 >= l2 && l2 >= l1) res -= (bin_search(r1) - bin_search(l2 - 1));
    else if(r2 >= l1 && l2 <= l1) res -= (bin_search(r2) - bin_search(l1 - 1));
    cout << res << "\n";
  }
  return 0;
}
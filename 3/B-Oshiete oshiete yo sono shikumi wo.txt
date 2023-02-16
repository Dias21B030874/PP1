#include <iostream>
#include <algorithm>
using namespace std;

long long  n, k, sum, need;
long long  a[100001];

long long is_possible(long long x) {
  long long cnt = 0, local = 0;
  for(int i = 1; i <= n; i++) {
    if(a[i] + local > x) {
      ++cnt;
      local = a[i];
    }else if(a[i] + local == x) {
      ++cnt;
      local = 0;
    }else local += a[i];
  }
  return cnt;
}

long long bin_search() {
  long long l = 0, r = sum, mid;
  while(l < r) {
    mid = l + (r - l) / 2;
    if(is_possible(mid) < k) r = mid;
    else l = mid + 1;
  }
  return l;
}

long long check(long long x) {
  long long local = 0, maxx = 0;
  for(int i = 1; i <= n; i++) {
    if(a[i] + local > x) {
      maxx = max(maxx, local);
      local = a[i];
    }else if(a[i] + local == x) {
      maxx = max(maxx, local + a[i]);
      local = 0;
    }else local += a[i];
  }
  return maxx;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for(int i = 1; i <= n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  need = bin_search();
  cout << check(need);
  return 0;
}
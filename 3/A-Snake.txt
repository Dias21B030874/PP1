#include <iostream>
#include <vector>
using namespace std;

int t, n, m, ind, sec;
int need[10001], a[801][801];
vector<int> v;

int bin_search_v(int target) {
  int l = 0, r = v.size() - 1, mid;
  while(l <= r) {
    mid = (l + r) / 2;
    if(mid == v.size() - 1) return mid + 1;
    if(v[mid] >= target && v[mid + 1] < target) return mid + 1;
    if(v[mid] > target) l = mid + 1;
    else if(v[mid] < target) r = mid - 1;
  }
  return mid + 1;
}

int bin_search(int target) {
  int l = 1, r = m, mid;
  if(ind % 2 == 0) {
    while(l <= r) {
      mid = (l + r) / 2;
      if(a[ind][mid] == target) return mid;
      if(a[ind][mid] > target) r = mid - 1;
      else if(a[ind][mid] < target) l = mid + 1;
    }
  }else {
    while(l <= r) {
      mid = (l + r) / 2;
      if(a[ind][mid] == target) return mid;
      if(a[ind][mid] < target) r = mid - 1;
      else if(a[ind][mid] > target) l = mid + 1;
    }
  }
  return -1;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  for(int i = 1; i <= t; i++) cin >> need[i];
  cin >> n >> m;
  for(int i = 1; i <= n; i++) {
    for(int j = 1; j <= m; j++) {
      cin >> a[i][j];
    }
    if(i % 2) v.push_back(a[i][1]);
    else v.push_back(a[i][m]);
  }
  for(int i = 1; i <= t; i++) {
    ind = bin_search_v(need[i]);
    sec = bin_search(need[i]);
    if(sec == -1) cout << -1;
    else cout << ind - 1 << " " << sec - 1;
    cout << "\n";
  }
  return 0;
}
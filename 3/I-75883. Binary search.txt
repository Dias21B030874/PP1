#include <iostream>
using namespace std;

int n, x;
int a[100001];

string bin_search() {
  int l = 1, r = n, mid;
  while(l <= r) {
    mid = (l + r) / 2;
    if(a[mid] > x) r = mid - 1;
    else if(a[mid] < x) l = mid + 1;
    else return "Yes";
  }
  return "No";
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for(int i = 1; i <= n; i++) cin >> a[i];
  cin >> x;
  cout << bin_search();
  return 0;
}
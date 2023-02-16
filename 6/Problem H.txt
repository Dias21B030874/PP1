#include<bits/stdc++.h>
using namespace std;
int n;
char a[200001];
char target;
void heapify(char arr[], int n, int i)
{
    int largest = i;   
    int l = 2*i + 1; 
    int r = 2*i + 2; 

    if (l < n && arr[l] > arr[largest])
        largest = l;

    if (r < n && arr[r] > arr[largest])
        largest = r;

    if (largest != i)
    {
        swap(arr[i], arr[largest]);

        heapify(arr, n, largest);
    }
}

void heapSort(char arr[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i=n-1; i>=0; i--)
    {
    
        swap(arr[0], arr[i]);

        heapify(arr, i, 0);
    }
}
int bin() {
  int l = 1, r = n, mid;
  while(l <= r) {
    mid = (l + r) / 2;
    if(a[mid] <= target) l = mid + 1;
    else {
      if(a[mid - 1] <= target) return mid;
      r = mid - 1;
    }
    if(l == r && a[l] <= target) return 0;
  }
  return 0;
}

int main(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> a[i];
    } 
    cin >> target;
    //heapSort(a, n);
    int ans = bin();
    if(ans) cout << a[ans];
    else cout << a[1];
    return 0;
}
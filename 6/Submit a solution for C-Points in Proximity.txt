#include <algorithm>
#include <iostream>
#include <iterator>
#include <vector>
using namespace std;
int minDiff = 1000000;

void heapify(int arr[], int n, int i)
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

void heapSort(int arr[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i=n-1; i>=0; i--)
    {
    
        swap(arr[0], arr[i]);

        heapify(arr, i, 0);
    }
}

void printArray(int arr[], int n)
{
    for (int i=0; i<n; ++i)
        cout << arr[i] << " ";
    cout << "\n";
}
vector<vector<int>> minAbsDiffPairs(int arr[], int n)
{
 
    vector<vector<int>> ans;
    //int n = arr.size();
 
    heapSort(arr, n);
 
    for (int i = 0; i < n - 1; i++)
        minDiff = min(minDiff, abs(arr[i] - arr[i + 1]));
 
    for (int i = 0; i < n - 1; i++) {
        vector<int> pair;
        if (abs(arr[i] - arr[i + 1]) == minDiff) {
            pair.push_back(min(arr[i], arr[i + 1]));
            pair.push_back(max(arr[i], arr[i + 1]));
            ans.push_back(pair);
        }
    }
 
    return ans;
}

int main()
{
    int n; cin >> n;
    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
 
    vector<vector<int>> pairs = minAbsDiffPairs(arr, n);
 
    for (auto v : pairs)
        cout << v[0] << " " << v[1] << " ";
    return 0;
}

#include <iostream>

int n, m;
int d[1001][1001];
int a[1001];
using namespace std;
int partition(int array[], int low, int high) {
    int pivot = array[high];
    int i;
    i = low-1;
    for (int j = low; j < high; j++) {
        if (array[j] <= pivot ) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return (i+1);
    }

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    }
}

int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) cin >> d[j][i];
    }
    for(int i=0;i<m;i++){
        quickSort(d[i],0,n-1);
    }
    for(int i=n-1;i>=0;i--) {
    for(int j = 0; j < m; j++) cout << d[j][i] << " ";
    cout << "\n";
  }

    return 0;
}
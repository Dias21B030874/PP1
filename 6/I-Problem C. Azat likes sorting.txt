#include <bits/stdc++.h>
#include <stdio.h>
#include <string>
using namespace std;

void swap(string* a, string* b)
{
    string t = *a;
    *a = *b;
    *b = t;
}

void quickSort(string &str, int lb, int ub) {
    int low = lb, high = ub;
    int pivot = str[(low + high) / 2];

    do {
        while (str[low] < pivot) low++;

        while (str[high] > pivot) high--;

        if (low <= high) {
            swap(str[low], str[high]);
            low++; high--;
        }
    }while (low <= high);


    if (lb < high) quickSort(str, lb, high);

    if (low < ub) quickSort(str, low, ub);
}

int main()
{
    string s; cin >> s;
    quickSort(s, 0, s.size() - 1);
    cout << s;
    return 0;
}
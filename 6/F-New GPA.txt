#include <iostream>
#include <iomanip>
#include <map>
#include <bits/stdc++.h>
using namespace std;

int n, m, credit;
double sum_cred, sum_grade;
string name, surname, grade;
map<string, double> info{{"A+", 4.00}, {"A", 3.75}, {"B+", 3.50}, {"B", 3.00}, {"C+", 2.50}, {"C", 2.00}, {"D+", 1.50}, {"D", 1.00}, {"F", 0.00}};

struct Student {
  string name, surname;
  double gpa;
};

Student st;
Student a[100001];

bool isbetter(Student st1, Student st2) {
  if(st1.gpa > st2.gpa) return true;
  else if(st1.gpa == st2.gpa) {
    if(st1.name > st2.name) return true;
    else if(st1.name == st2.name) return st1.surname > st2.surname;
    return false;
  }
  return false;
}

void heapify_down(int n, int v) {
  int best = v;
  if(2 * v <= n && isbetter(a[2 * v], a[best])) best = 2 * v;
  if(2 * v + 1 <= n && isbetter(a[2 * v + 1], a[best])) best = 2 * v + 1;
  if(best != v) {
    swap(a[v], a[best]);
    heapify_down(n, best);
  }
}

void heapify_up(int v) {
  while(v != 1 && isbetter(a[v], a[v / 2])) {
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
  cin >> n;
  for(int i = 1; i <= n; i++) {
    sum_cred = sum_grade = 0;
    cin >> name >> surname >> m;
    st.name = name;
    st.surname = surname;
    for(int j = 0; j < m; j++) {
      cin >> grade >> credit;
      sum_cred += credit;
      sum_grade += credit * info[grade];
    }
    st.gpa = sum_grade / sum_cred;
    a[i] = st;
  }
  build();
  heap_sort();
  for(int i = 1; i <= n; i++) cout << a[i].name << " " << a[i].surname << " " << fixed << setprecision(3) << a[i].gpa << "\n";
  return 0;
}
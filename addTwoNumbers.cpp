/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
#include<math.h>
#include<iostream>
using namespace std;

struct ListNode{
  int val;
  ListNode* next;
  ListNode(int x)
    :val(x), next(nullptr){}
};

void displayList(const ListNode* n){
    while(n!=nullptr){
        cout << n->val << ", ";
        n=n->next;
    }
    cout << endl;
}

ListNode* createList(long x){

    if(x==0) return new ListNode(0);

    int exp=1;
    ListNode *head{nullptr}, *curr{nullptr}, *prev{nullptr};
    while(x>0){
        cout <<x << endl;
        long num = x%(long)pow(10,exp);
        x -= num;
        num = num/(long)pow(10,exp-1);

        curr = new ListNode(num);
        if(exp==1) head=curr;
        if(prev!=nullptr) prev->next = curr;
        prev = curr;
        exp++;
    }
    return head;
}

long toNum(const ListNode* n){
    int exp=0;
    const ListNode* it=n;

    long sum=0;
    while(it!=nullptr){
        sum+=(long)pow(10,exp)*it->val;
        it=it->next;
        exp++;
    }
    return sum;
}

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    // two listnodes with numbers
    /*
    want one list node with sum of numbers
    convert both list nodes to ordinary nuumbers, add the numbers, then convert back to list node form.
    create a starting sum. for each node, add the node val multiplied by some power of 10.
    got sum in int form.
    start taking digits off the sum by using modulus. Create list nodes out of the digits and chain them together
    return ans
    */

    return createList(toNum(l1) + toNum(l2));
}

int main(){
    ListNode* n1 = createList(200);
    ListNode* n2 = createList(500);
    displayList(addTwoNumbers(n1,n2));
}
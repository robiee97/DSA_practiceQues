#include <iostream>

using namespace std;

class ListNode
{
public:
    int data;
    ListNode *next;
    ListNode()
    {
        this->data = 0;
        this->next = NULL;
    }

    ListNode(int data, ListNode *next)
    {
        this->data = data;
        this->next = next;
    }
};

void addFirst(ListNode *&head, ListNode *&tail, int data)
{
    if (head == NULL)
    {
        head = tail = new ListNode(data, NULL);
    }
    else
    {
        ListNode *nn = new ListNode(data, head);
        head = nn;
    }
}

void addLast(ListNode *&head, ListNode *&tail, int data)
{
    if (head == NULL)
    {
        head = tail = new ListNode(data, NULL);
    }
    else
    {
        tail->next = new ListNode(data, NULL);
        tail = tail->next;
    }
}

/*ques: given ListNode{1,2,3,4,5},
int n,
you have to remove a node nth from last
like if removeNthFromLast(n=2)=>{1,2,3,5}
given that n is valid for the every node deletion
*/

//itr APPORACH
ListNode *getNodeAt(ListNode *head, int idx)
{
    if (head == NULL)
    {
        return NULL;
    }
    int j = 0;
    for (ListNode *i = head; i != NULL; i = i->next)
    {
        if (j == idx)
        {
            return i;
        }
        j++;
    }
    return NULL;
}

int getSize(ListNode *head)
{
    if (head == NULL)
    {
        return 0;
    }
    int c = 0;
    ListNode *i = head;
    while (i != NULL)
    {
        c++;
        i = i->next;
    }
    return c;
}
void removeNthFromLast(ListNode *&head, int n)
{
    //get size-n th Node
    int sz = getSize(head);

    ListNode *nm1 = getNodeAt(head, sz - n - 1);
    ListNode *nth = nm1->next;

    nm1->next = nth->next;
    delete nth;
}

//recursive APPROACH

void rNFLR(ListNode *&head, int n,int c)
{
    if (head == NULL)
    {
        return;
    }
    rNFLR(head->next, n,c--);
    if (c == n)
    {
        ListNode *temp = head->next;
        head->next = temp->next;
        delete temp;
    }
}

void display(ListNode *head)
{
    if (head == NULL)
    {
        return;
    }
    else
    {
        ListNode *i = head;
        while (i != NULL)
        {
            cout << i->data << ",";
            i = i->next;
        }
    }
}

int main(int argc, char **argv)
{
    ListNode *head = NULL;
    ListNode *tail = NULL;

    addLast(head, tail, 1);
    addLast(head, tail, 2);
    addLast(head, tail, 3);
    addLast(head, tail, 4);
    addLast(head, tail, 5);
    // removeNthFromLast(head, 2);
    int sz=getSize(head);
    rNFLR(head,2,sz);   
    display(head);
}
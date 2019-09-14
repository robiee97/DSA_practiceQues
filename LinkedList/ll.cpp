#include <iostream>
using namespace std;
class Node
{
public:
    int data;
    Node *next;

    Node()
    {
        this->data = 0;
        this->next = NULL;
    }

    Node(int data, Node *next)
    {
        this->data = data;
        this->next = next;
    }
};

void addLast(Node *&head, Node *&tail, int data)
{
    if (head == NULL)
    {
        head = tail = new Node(data, NULL);
    }
    else
    {
        Node *nn = new Node(data, NULL);
        tail->next = nn;
        tail = nn;
    }
}
void display(Node *head)
{
    for (Node *i = head; i != NULL; i = i->next)
    {
        cout << i->data << "->";
    }
    cout << endl;
}

int sizeList(Node *head)
{
    int counter = 0;

    Node *i = head;
    while (i != NULL)
    {
        counter++;
        i = i->next;
    }
    return counter;
}

void addFirst(Node *&head, Node *&tail, int data)
{
    if (head == NULL)
    {
        head = tail = new Node(data, NULL);
    }
    else
    {
        Node *nn = new Node(data, head);
        head = nn;
    }
}

int getFirst(Node *&head)
{
    if (head == NULL)
    {
        return 0;
    }
    return head->data;
}

int getLast(Node *&tail)
{
    if (tail == NULL)
    {
        return 0;
    }
    return tail->data;
}

int getAt(Node *&head, int idx)
{
    if (head == NULL)
    {
        return 0;
    }
    int j = 0;
    for (Node *i = head; i != NULL; i = i->next)
    {
        if (j == idx)
        {
            return i->data;
        }
        j++;
    }
    return 0;
}

Node *getNodeAt(Node *&head, int idx)
{
    if (head == NULL)
    {
        return NULL;
    }

    int j = 0;
    for (Node *i = head; i != NULL; i = i->next)
    {
        if (j == idx)
        {
            return i;
        }
        j++;
    }
    return NULL;
}

void addAt(Node *&head, Node *&tail, int data, int idx)
{
    int sz = sizeList(head);
    if (idx < 0 || idx > sz)
    {
        cout << "invalid" << endl;
    }
    else if (idx == 0)
    {
        addFirst(head, tail, data);
    }
    else if (idx == sz)
    {
        addLast(tail, tail, data);
    }
    else
    {
        Node *nm1 = getNodeAt(head, idx - 1);
        nm1->next = new Node(data, nm1->next);
    }
}
//removeFirst
void removeFirst(Node *&head, Node *tail)
{
    int sz = sizeList(head);
    if (sz == 0)
    {
        cout << "invalid";
        return;
    }
    else if (sz == 1)
    {
        Node *temp = head;
        head = tail = NULL;
        delete temp;
    }
    else
    {
        Node *p = head;
        head = head->next;
        delete p;
    }
}
//removeLast
void removeLast(Node *&head, Node *&tail)
{
    int sz = sizeList(head);
    if (sz == 0)
    {
        cout << "invalid";
        return;
    }
    else if (sz == 1)
    {
        Node *temp = head;
        head = tail = NULL;
        delete temp;
    }
    else
    {
        Node *temp = getNodeAt(head, sz - 2);
        temp->next = NULL;
        delete tail;
        tail = temp;
    }
}

// removeNodeAt
void removeAt(Node *&head, Node *&tail, int idx)
{
    int sz = sizeList(head);
    if (idx < 0 || idx >= sz)
    {
        return;
    }
    else if (idx == 0)
    {
        removeFirst(head, tail);
    }
    else if (idx == sz - 1)
    {
        removeLast(head, tail);
    }
    else
    {
        Node *m1 = getNodeAt(head, idx - 1);
        Node *n = m1->next;
        Node *p1 = n->next;

        m1->next = p1;
        delete n;
    }
}

void reverseDI(Node *head, Node *tail)
{
    int sz = sizeList(head);
    int i = 0;
    int j = sz - 1;
    while (i < j)
    {
        Node *one = getNodeAt(head, i);
        Node *two = getNodeAt(head, j);

        int temp = one->data;
        one->data = two->data;
        two->data = temp;

        i++;
        j--;
    }
}
void reversePI(Node *&head, Node *&tail)
{

    Node *prev = NULL;
    Node *curr = head;

    while (curr != NULL)
    {
        Node *next = curr->next;
        curr->next = prev;

        prev = curr;
        curr = next;
    }
    Node *temp = head;
    head = tail;
    tail = temp;
}

//displayReverse

void displayRev(Node *head)
{
    if (head == NULL)
    {
        return;
    }
    displayRev(head->next);
    cout << head->data << "->";
}
void reversePIrec(Node *head, Node *tail)
{
    if (head == tail)
    {
        return;
    }
    reversePIrec(head->next, tail);
    head->next->next = head;
}

void reverseDIrec(Node *&left, Node *right, int floor, int &sz)
{
    if (right == NULL)
    {
        return;
    }
    sz++;
    reverseDIrec(left, right->next, floor + 1, sz);
    if (floor >= sz / 2)
    {
        int temp = right->data;
        right->data = left->data;
        left->data = temp;
        left = left->next;
    }
}

bool isPallindrome(Node *&left, Node *right)
{
    if (right == NULL)
    {
        return true;
    }
    bool ans = isPallindrome(left, right->next);
    if (left->data != right->data)
    {
        return false;
    }
    left = left->next;
    return ans;
}

void fold(Node *&left, Node *right, int floor, int &sz, Node *&tail)
{
    if (right == NULL)
    {
        return;
    }
    sz++;
    fold(left, right->next, floor + 1, sz, tail);
    if (floor > sz / 2)
    {
        right->next = left->next;
        left->next = right;
        left = left->next->next;
    }
    else if (floor == sz / 2)
    {
        tail = right;
        tail->next = NULL;
    }
}
//No use of sizez,getnodeat,space,recursion in o(n)
int mid(Node *first, Node *second)
{
    while (second->next != NULL && second->next->next != NULL)
    {
        second = second->next->next;
        first = first->next;
    }
    return first->data;
}
int KthFromLast(Node *head, int k)
{
    Node *ele = head;
    Node *last = head;
    while (k >= 0)
    {
        last = last->next;
        k--;
    }
    while (last != NULL)
    {
        last = last->next;
        ele = ele->next;
    }
    return ele->data;
}

Node *khelp(Node *th, int k)
{
    Node *prev = NULL;
    Node *curr = th;

    for (int i = 0; i < k; i++)
    {
        Node *next = curr->next;
        curr->next = prev;

        prev = curr;
        curr = next;
    }
    th->next = curr;
    return prev;
}

void kReverse(Node *&head, Node *&tail, int k)
{
    int sz = sizeList(head);
    if (sz < k)
    {
        return;
    }
    int counter = 0;
    Node *t1 = head;
    Node *t2 = khelp(t1, k);
    head = t2;
    counter += k;

    while (sz - counter >= k)
    {
        Node *nt1 = t1->next;
        Node *nt2 = khelp(nt1, k);
        t1->next = nt2;
        t1 = nt1;
        counter += k;
    }
    if (counter == sz)
    {
        tail = t1;
    }
}

void krev2(Node *&head, Node *&tail, int k)
{
    Node *phead = NULL;
    Node *ptail = NULL;

    int sz = sizeList(head);

    while (head != NULL && sz >= k)
    {
        Node *chead = NULL;
        Node *ctail = NULL;

        for (int i = 0; i < k; i++)
        {
            int temp = head->data;
            removeFirst(head, tail);
            addFirst(chead, ctail, temp);
            sz--;
        }
        if (phead == NULL)
        {
            phead = chead;
            ptail = ctail;
        }
        else
        {
            ptail->next = chead;
            ptail = ctail;
        }
    }
    if (sz < k)
    {
        ptail->next = head;
    }
    head = phead;
    tail = ptail;
}
void dup(Node *&head, Node *&tail)
{

    Node *nh = NULL;
    Node *nt = NULL;

    while (head != NULL)
    {
        int temp = head->data;
        removeFirst(head, tail);

        if (nh == NULL || nt->data != temp)
        {
            addLast(nh, nt, temp);
        }
    }
    head = nh;
    tail = nt;
}

void seg(Node *&head, Node *&tail)
{
    Node *oh = NULL;
    Node *ot = NULL;
    Node *eh = NULL;
    Node *et = NULL;
    while (head != NULL)
    {
        int temp = head->data;
        removeFirst(head, tail);
        if (temp % 2 == 0)
        {
            addLast(eh, et, temp);
        }
        else
        {
            addLast(oh, ot, temp);
        }
    }
    if (oh != NULL && eh != NULL)
    {
        ot->next = eh;
        head = oh;
        tail = et;
    }
    else if (oh != NULL)
    {
        head = oh;
    }
    else if (eh != NULL)
    {
        head = eh;
    }
    else
    {
        head = NULL;
        tail = NULL;
    }
}

//floydCYCLE
void floydCYCLE(Node *&head)
{
    if (head == NULL)
    {
        return;
    }
    Node *slow = head;
    Node *fast = head;
    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast)
        {
            cout << "cycle";
            if (slow == head)
            {
                slow->next = NULL;
            }
            else
            {
                fast = head;
                while (slow->next != fast->next)
                {
                    slow = slow->next;
                    fast = fast->next;
                }
                slow->next = NULL;
                display(head);
                break;
            }
        }
    }
}
Node *midNode(Node *head, Node *tail)
{
    Node *first = head;
    Node *second = head;

    while (second != tail && second->next != tail)
    {
        second = second->next->next;
        first = first->next;
    }
    return first;
}

void mergeSL(Node *h1, Node *h2, Node *&oh, Node *&ot)
{
    Node *t1 = h1;
    Node *t2 = h2;

    while (t1 != NULL && t2 != NULL)
    {
        if (t1->data < t2->data)
        {
            addLast(oh, ot, t1->data);
            t1 = t1->next;
        }
        else
        {
            addLast(oh, ot, t2->data);
            t2 = t2->next;
        }
    }
    while (t1 != NULL)
    {
        addLast(oh, ot, t1->data);
        t1 = t1->next;
    }

    while (t2 != NULL)
    {
        addLast(oh, ot, t2->data);
        t2 = t2->next;
    }
}

void mergeSort(Node *&head, Node *&tail)
{
    if (head == tail)
    {
        Node *nn = new Node(head->data, NULL);
        head = tail = nn;
        return;
    }
    Node *mid = midNode(head, tail);

    Node *lh = head;
    Node *lt = mid;
    Node *rh = mid->next;
    Node *rt = tail;

    mergeSort(lh, lt);
    mergeSort(rh, rt);

    Node *fh = NULL;
    Node *ft = NULL;

    mergeSL(lh, rh, fh, ft);
    head = fh;
    tail = ft;
}
void imergeSL(Node *lh, Node *rh, Node *lt, Node *rt, Node *&oh, Node *&ot)
{
    Node *t1 = lh;
    Node *t2 = rh;

    while (t1 != NULL && t2 != NULL)
    {
        Node *rm = NULL;
        if (t1->data < t2->data)
        {
            rm = t1;
            t1 = t1->next;
            rm->next = NULL;
        }
        else
        {
            rm = t2;
            t2 = t2->next;
            rm->next = NULL;
        }
        if (oh == NULL)
        {
            oh = ot = rm;
        }
        else
        {
            ot->next = rm;
            ot = rm;
        }
    }
    if (t1 != NULL)
    {
        ot->next = t1;
        ot = lt;
    }
    else
    {
        ot->next = t2;
        ot = rt;
    }
}
void imergeSort(Node *&head, Node *&tail)
{
    if (head == tail)
    {
        return;
    }
    Node *mid = midNode(head, tail);

    Node *lh = head;
    Node *lt = mid;
    Node *rh = mid->next;
    Node *rt = tail;

    mid->next = NULL;

    imergeSort(lh, lt);
    imergeSort(rh, rt);

    Node *fh = NULL;
    Node *ft = NULL;

    imergeSL(lh, rh, lt, rh, fh, ft);
    head = fh;
    tail = ft;
}

int main(int argc, char **argv)
{
    Node *head = NULL;
    Node *tail = NULL;
    addAt(head, tail, 100, 0);
    // removeFirst(head, tail);
    addFirst(head, tail, 7);
    // removeLast(head, tail);
    addLast(head, tail, 1);
    addLast(head, tail, 2);
    addLast(head, tail, 3);
    addLast(head, tail, 4);
    addLast(head, tail, 4);
    // addLast(head, tail, 50);
    // addLast(head, tail, 89);

    // removeAt(head, tail, 0);
    addFirst(head, tail, 6);
    // addAt(head, tail, 1000, 6);
    // removeFirst(head, tail);
    // removeAt(head,tail,6);
    display(head);

    // reverseDI(head, tail);
    // reversePI(head, tail);

    // display(head);
    // displayRev(head);

    // reversePIrec(head, tail);
    // Node *i = head;
    // head = tail;
    // tail = i;
    // tail->next = NULL;

    // Node *left = head;
    // Node *right = head;
    // int floor = 0;
    // int size = 0;

    // reverseDIrec(left, right, floor, size);
    // display(head);

    // bool ans = isPallindrome(left, right);
    // if (ans)
    // {
    //     cout << "true";
    // }
    // else
    // {
    //     cout << "false";
    // }

    // cout<<endl;
    // fold(left, right, floor, size, tail);

    //abcdef=afbecd
    //abcdefg=agbfced

    // addLast(head, tail, 17);
    // display(head);

    // Node*first=head;
    // Node*second=head;
    // int ans=mid(first,second);
    // cout<<ans;

    // cout << KthFromLast(head, 0);

    // display(head);
    // kReverse(head, tail, 3);
    // display(head);
    // krev2(head, tail, 3);
    // seg(head, tail);
    // Node* nh=head;
    // Node* nt=tail;
    // dup(head, tail);

    // display(head);
    // tail->next = getNodeAt(head, 3);
    // floydCYCLE(head);
    // display(head);

    Node *sh = head;
    Node *st = tail;

    imergeSort(sh, st);
    // mergeSort(sh,st);
    display(sh);
    // display(head);
}
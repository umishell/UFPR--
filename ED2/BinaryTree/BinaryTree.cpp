
#include <iostream>
#include <random>
#include <chrono>
using namespace std;

// definition of tree
typedef struct tree {
    int data;
    struct tree* left;
    struct tree* right;
}Tree;
// Function to create new empry tree node
Tree* newEmptyTree(void) {
    return NULL;
}
// Function to create tree
Tree* newTree(char c, Tree* l, Tree* r) {
    Tree* t = (Tree*)malloc(sizeof(Tree));
    if (t == NULL) {
        cerr << "Error: Memory allocation failed for tree node." << endl;
        return NULL;
    }
    t->data = c;
    t->left = l;
    t->right = r;
    return t;
}
// Function to check if tree is empty
int TreeIsEmpty(Tree* t) {
    return (t == NULL);
}
// Function to clear tree
Tree* clearTree(Tree* t) {
    if (!TreeIsEmpty(t)) {
        clearTree(t->left);
        clearTree(t->right);
        free(t);
    }
    return NULL;
}
// Function to find specific data in node in tree
int searchTree(Tree* t, int data) {
    if (t == NULL) return 0;
    else if (data < t->data) return searchTree(t->left, data);
    else if (data > t->data) return searchTree(t->right, data);
    else return 1; //data found
}
// Function to insert new node into tree
Tree* insertTree(Tree* t, int data) {
    if (t == NULL) {
        t = (Tree*)malloc(sizeof(Tree));
        if (t == NULL) {
            cerr << "Error: Memory allocation failed for tree node." << endl;
            return NULL;  
        }
        t->data = data;
        t->left = t->right = NULL;
    }
    else if (data < t->data) t->left = insertTree(t->left, data);
    else                     t->right = insertTree(t->right, data);
    return t;
}

// Function to find the minimum node in a subtree
Tree* findMin(Tree* t) {
    if (t == NULL) return NULL;
    else while (t->left != NULL) t = t->left;
    return t;
}

// Function to remove a node from a binary search tree
Tree* deleteNode(Tree* t, int data) {
    if (t == NULL) {
        // Node not found in the tree
        return NULL;
    }
    else if (data < t->data) {
        t->left = deleteNode(t->left, data);
    }
    else if (data > t->data) {
        t->right = deleteNode(t->right, data);
    }
    else {
        // Node found - proceed with deletion
        Tree* temp = NULL;

        // Handle the case where the node to be deleted has no children
        if (t->left == NULL && t->right == NULL) {
            free(t);
            return NULL;
        }

        // Handle the case where the node to be deleted has only one child
        else if (t->left == NULL) {
            temp = t->right;
            free(t);
            return temp;
        }
        else if (t->right == NULL) {
            temp = t->left;
            free(t);
            return temp;
        }

        // Handle the case where the node to be deleted has two children
        else {       
            temp = findMin(t->right);
            // Replace the value of the node to be deleted with the successor's value
            t->data = temp->data;
            // Recursively delete the successor (which will have at most one child)
            t->right = deleteNode(t->right, temp->data);
        }
    }
    return t;
}

// Function to perform in-order traversal on the tree
void inOrderTraversal(Tree* t) {
    if (t != NULL) {
        inOrderTraversal(t->left);
        cout << t->data << " ";
        inOrderTraversal(t->right);
    }
}

int main()
{


    // EXERCISE 1
    cout << "EXERCISE 1" << endl;

    Tree* root = NULL;

    // Generate 30 random numbers from 0 to 999
    random_device rd;
    mt19937 generator(rd());
    uniform_int_distribution<int> distribution(0, 999);

    for (int i = 0; i < 30; i++) {
        int random_number = distribution(generator);
        root = insertTree(root, random_number);
    }

    // Print the tree in in-order traversal
    cout << "In-order traversal of the binary search tree with 30 random numbers:" << endl;
    inOrderTraversal(root);
    cout << endl;
    cout << "Numbers are in order." << endl;

    clearTree(root);


    // EXERCISE 2
    cout << "\nEXERCISE 2" << endl;

    root = NULL;

    // random_device rd;
    // mt19937 generator(rd());
    uniform_int_distribution<int> distribution2(0, 99999);

    for (int i = 0; i < 100000; i++) {
        int random_number = distribution2(generator);
        root = insertTree(root, random_number);
    }

    auto start = chrono::high_resolution_clock::now();
    bool found = searchTree(root, 100000);
    auto end = chrono::high_resolution_clock::now();
    chrono::duration<double, nano> diff = end - start;

    // Print search result and time
    if (found) cout << "Data value 100000 found in the binary search tree." << endl;
    else cout << "Data value 100000 not found in the binary search tree." << endl;
    cout << "Search time: " << diff.count() << " nanoseconds" << endl;

    clearTree(root);


    //EXERCISE 3
    cout << "\nEXERCISE 3" << endl;

    // Create the binary search tree with the given data
    root = NULL;
    root = newTree(50, newTree(30, newTree(20, newTree(10, NULL, NULL), NULL), newTree(40, newTree(35, NULL, NULL), newTree(45, NULL, NULL))), newTree(90, NULL, newTree(95, NULL, NULL)));

    // Print the tree in in-order traversal before each deletion
    cout << "Tree before deletion 1 (10): ";
    inOrderTraversal(root);
    cout << endl;

    // Remove node 10 (no children)
    root = deleteNode(root, 10);

    // Print the tree after deletion 1
    cout << "Tree after deletion 1 (10): ";
    inOrderTraversal(root);
    cout << endl;

    // Remove node 90 (one child)
    root = deleteNode(root, 90);

    // Print the tree after deletion 2
    cout << "Tree after deletion 2 (90): ";
    inOrderTraversal(root);
    cout << endl;

    // Remove node 40 (two children)
    root = deleteNode(root, 40);

    // Print the tree after deletion 2
    cout << "Tree after deletion 2 (40): ";
    inOrderTraversal(root);
    cout << endl;


    return 0;
}

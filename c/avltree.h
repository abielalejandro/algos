typedef struct AvlTreeNode {
    struct AvlTreeNode *left;
    int data;
    int height;
    int root;
    struct AvlTreeNode *right;
} AvlTreeNode; 

void printAvlTreeNode(struct AvlTreeNode *node);
AvlTreeNode *createAvlTreeNode(int data);
AvlTreeNode* insertItemAvlTreeNode(AvlTreeNode *node, int data);
int calculateHeightAlvTreeNode(AvlTreeNode *root);
void preOrderAvlTreeNode(AvlTreeNode *root);
void postOrderAvlTreeNode(AvlTreeNode *root);
void inOrderAvlTreeNode(AvlTreeNode *root);
void printAvlTree(AvlTreeNode *root);
AvlTreeNode *LLRotation(AvlTreeNode *node);
AvlTreeNode *RRRotation(AvlTreeNode *node);
AvlTreeNode *LRRotation(AvlTreeNode *node);
AvlTreeNode *RLRotation(AvlTreeNode *node);

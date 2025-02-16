#include "avltree.h"
#include <stdio.h>
#include <stdlib.h>

int balanceFactor(AvlTreeNode *node) {
  int rHeight = (node && node->right) ? node->right->height : 0;
  int lHeight = (node && node->left) ? node->left->height : 0;

  return lHeight - rHeight;
}

void preOrderAvlTreeNode(AvlTreeNode *root) {
  if (NULL == root)
    return;
  printf("[%d]", root->data);
  preOrderAvlTreeNode(root->left);
  preOrderAvlTreeNode(root->right);
}

void postOrderAvlTreeNode(AvlTreeNode *root) {
  if (NULL == root)
    return;
  postOrderAvlTreeNode(root->left);
  postOrderAvlTreeNode(root->right);
  printf("[%d]", root->data);
}

void inOrderAvlTreeNode(AvlTreeNode *root) {
  if (NULL == root)
    return;
  inOrderAvlTreeNode(root->left);
  printf("[%d]", root->data);
  inOrderAvlTreeNode(root->right);
}

void printAvlTreeNode(AvlTreeNode *node) {
  if (node == NULL)
    return;

  printf("Data=[%d]", node->data);
  printf("Height=[%d]", node->height);
  if (node->left != NULL) {
    printf("Left=[%d]", node->left->data);
  }

  if (node->right != NULL) {
    printf("Right=[%d]", node->right->data);
  }
  printf("\n");
}

void printAvlTree(AvlTreeNode *node) {
  if (node == NULL)
    return;
  if (node->left) {
    printAvlTree(node->left);
  }
  printf("Data=[%d] ", node->data);
  printf("Height=[%d] ", node->height);
  printf("Balance factor=[%d] ", balanceFactor(node));
  printf("\n");

  if (node->right) {
    printAvlTree(node->right);
  }
}

AvlTreeNode *createAvlTreeNode(int data) {
  AvlTreeNode *node = (struct AvlTreeNode *)malloc(sizeof(AvlTreeNode));
  if (node == NULL) {
    perror("Error creating a node");
    exit(1);
  }
  node->left = node->right = NULL;
  node->data = data;
  node->height = 1;
  node->root = 0;
  return node;
}

int calculateHeightAlvTreeNode(AvlTreeNode *node) {
  if (node == NULL)
    return 0;

  int rHeight = node->right ? node->right->height : 0;
  int lHeight = node->left ? node->left->height : 0;

  return rHeight > lHeight ? rHeight +1 : lHeight + 1;
}

AvlTreeNode *LLRotation(AvlTreeNode *node) {
  AvlTreeNode *left = node->left;
  AvlTreeNode *leftR = left->right;

  left->right = node;
  node->left = leftR;
  node->height = calculateHeightAlvTreeNode(node);
  left->height = calculateHeightAlvTreeNode(left);
  if (node->root == 1) {
    node->root = 0;
    left->root = 1;
  }
  return left;
}

AvlTreeNode *RRRotation(AvlTreeNode *node) {
  AvlTreeNode *right = node->right;
  AvlTreeNode *rightL = right->left;

  right->left = node;
  node->right = rightL;
  node->height = calculateHeightAlvTreeNode(node);
  right->height = calculateHeightAlvTreeNode(right);
  if (node->root == 1) {
    node->root = 0;
    right->root = 1;
  }
  return right;
}

AvlTreeNode *LRRotation(AvlTreeNode *node) {
  AvlTreeNode *left = node->left;
  AvlTreeNode *leftR = left->right;

  left->right = leftR->left;
  node->left = leftR->right;
  leftR->left = left;
  left->right = node;

  left->height = calculateHeightAlvTreeNode(left);
  node->height = calculateHeightAlvTreeNode(node);
  leftR->height = calculateHeightAlvTreeNode(leftR);
  if (node->root == 1) {
    node->root = 0;
    leftR->root = 1;
  }
  return leftR;
}

AvlTreeNode *RLRotation(AvlTreeNode *node) {
  AvlTreeNode *right = node->right;
  AvlTreeNode *rightL = right->left;

  right->left = rightL->right;
  node->right = rightL->left;
  rightL->right = right;
  right->left = node;

  right->height = calculateHeightAlvTreeNode(right);
  node->height = calculateHeightAlvTreeNode(node);
  rightL->height = calculateHeightAlvTreeNode(rightL);
  if (node->root == 1) {
    node->root = 0;
    rightL->root = 1;
  }
  return rightL;
}

AvlTreeNode *insertItemAvlTreeNode(AvlTreeNode *node, int val) {
  if (node == NULL) {
    return createAvlTreeNode(val);
  }

  if (val < node->data) {
    node->left = insertItemAvlTreeNode(node->left, val);
  } else if (val > node->data) {
    node->right = insertItemAvlTreeNode(node->right, val);
  }

  node->height = calculateHeightAlvTreeNode(node);

  if (balanceFactor(node) == 2 && balanceFactor(node->left) == 1) {
    return LLRotation(node);
  } else if (balanceFactor(node) == -2 && balanceFactor(node->left) == -1) {
    return RRRotation(node);
  } else if (balanceFactor(node) == 2 && balanceFactor(node->left) == -1) {
    return LRRotation(node);
  } else if (balanceFactor(node) == -2 && balanceFactor(node->left) == 1) {
    return RLRotation(node);
  }

  return node;
}

int main(int argc, char *argv[]) {
  AvlTreeNode *root = createAvlTreeNode(14);
  root->root = 1;
  root = insertItemAvlTreeNode(root, 17);
  root = insertItemAvlTreeNode(root, 11);
  root = insertItemAvlTreeNode(root, 7);
  root = insertItemAvlTreeNode(root, 53);
  root = insertItemAvlTreeNode(root, 4);
  root = insertItemAvlTreeNode(root, 13);
  root = insertItemAvlTreeNode(root, 12);
  root = insertItemAvlTreeNode(root, 8);
  root = insertItemAvlTreeNode(root, 60);
  root = insertItemAvlTreeNode(root, 19);
  root = insertItemAvlTreeNode(root, 16);
  root = insertItemAvlTreeNode(root, 20);
  inOrderAvlTreeNode(root);
  return 0;
}

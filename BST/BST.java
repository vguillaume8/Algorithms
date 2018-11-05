public class BST
{
   private treeNode root;
   private int size;
   private int counter;

   public int getSize()
   {
      return size;
   }

   public int getCounter(){
     return counter;
   }

   public treeNode getRoot()
   {
     return root;
   }

   public void setSize(int s)
   {
     size = s;
   }

   public void setRoot(treeNode r)
   {
     root = r;
   }

 public void Pre(treeNode curr, int leftDir, treeNode save)
 {
  if(curr != null)
  {
   treeNode newNode = new treeNode(curr.getData());
   if(save != null)
   {
    if(leftDir == 1)
    {
     save.setLeft(newNode);
    }
    else
    {
     save.setRight(newNode);
    }
   }
   save = newNode;
   Pre(curr.getLeft(), 1, save);
   Pre(curr.getRight(), 0, save);
  }
 } 

 //constructor
 public BST()
 {
  //initialize an empty binary search tree
  root = null;
  size = 0;
  counter = 0;
 }

  //copy constructor
  public BST(BST x)
  {
   size = x.getSize();
   treeNode xroot = x.getRoot();
   root = new treeNode(xroot.getData());
   Pre(xroot.getLeft(), 1, root);
   Pre(xroot.getRight(), 0, root);
  }
   
  //member methods

  public void insert(int y)
  {
    treeNode newNode = new treeNode(y);
    assert(newNode != null);
    size++;

    //initialize the new node
    if(root == null)
    {
     root = newNode; //insertion into previously empty tree
    }
    else
    {
     int leftDir = 0;
     treeNode save = null;
     treeNode curr = root; //initialize current node with root
     while(curr != null) //loop to locate insertion position
     {
       save = curr; //save the address of the current node
       counter++;
       if(y <= curr.getData()) //compare y to data of current node
       {
        curr = curr.getLeft(); //if y smaller than current data, continue left
        leftDir = 1;
       }
       else
       {
        curr = curr.getRight();//if y greater than current data, continue right
        leftDir = 0;
       }
     }
     if(leftDir == 1)
     {
      save.setLeft(newNode); //insert a left child
     }
     else
     {
      save.setRight(newNode); //insert a right child
     }
    }
   }

  public void trav()  
   {
    System.out.println("inorder traversal of the BST: " );
    inorder(root); //initial call for recursive inorder traversal
   }

  public void inorder(treeNode ptr)
  {
   if(ptr != null)
   {
    inorder(ptr.getLeft());
    System.out.println(ptr.getData());
    inorder(ptr.getRight());
   }
  }

  //class methods

  public static BST CombineBST(BST A, BST B, int x)
  //precondition: largest element of A <= x < smallest element of B 
  {
   BST Acopy = new BST(A);
   BST Bcopy = new BST(B);
   BST C = new BST(); //empty BST
   treeNode r = new treeNode(x);
   C.setRoot(r);
   r.setLeft(Acopy.getRoot());
   r.setRight(Bcopy.getRoot());
   C.setSize(A.getSize()+B.getSize()+1);
   return C;
  }




}

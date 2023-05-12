# Guessing_Game_Binary_Tree
Guessing game using binary trees

Link: http://cs.middlesexcc.edu/~schatz/csc236/labs/csc236.lab4.html

Lab 4


In this lab you will write a program which plays a guessing game. The program asks a series of yes/no questions to guess which animal the user is thinking of. If the program cannot guess the animal, the program asks the user for an additional question so that in the next round it can guess this animal.

To write this game, you will use a binary tree. The internal nodes of the tree will contain questions, and the leaf nodes will contain animals. The first question is in the root node of the tree. If the answer to a question is yes, then the left subtree will be explored; otherwise the right subtree will be explored. For example, suppose the tree contains:

If the answer to the first question is yes, then the question in the left child should be asked. If the answer to this question is yes, then the program should guess the animal in the left child, otherwise it should guess the animal in the right child.

If a guess is wrong, the program will ask what was the correct answer, and then the program will ask the user for a new yes/no question that it can use to distinguish between the guess and the correct answer. Then it will add the question and the guess to the tree. For example, if the user answers no to the first question, the program will guess snake. If the guess is wrong, the program will ask for the answer and another question (whose answer is yes for the new animal). Suppose the animal is spider and the question is "Do you have legs?". Then the program will update the tree to:

To start the game, create a tree with one question and two guesses.

Write a loop that will let the user play as many rounds as desired.

To easiest way to write the function to play one round of the game is to write a recursive function. The recursive case for the function is when the tree has more than one node. This means the root contains a question. The recursive case should print the question and read the answer, and then decide whether to make a recursive call for the left subtree or the right subtree.

The base case for the recursion is when the tree contains only one node. Since every node in our tree will have 0 or 2 children, you can check either child to tell whether you have reached the base case. In the base case the root contains a guess. The base case should print the guess. If the guess is incorrect then the program needs to ask for a new question and modify the tree to include the new question and the new animal. To modify the tree, save the animal in the node, replace it with the question, and then attach the old animal as the right child and the new animal as the left child.
BinTree Class

The BinTree class is different from the BST class, because the client code needs to move freely around the tree and attach and detach subtrees whereever they are needed. This means that the internal structure of the tree needs to be open to the client code. The nodes and links, which we are used to making private, need to be public so they can be manipulated by the client code. There is no class for the tree node, instead the BinTree class itself is the node.

The interface, the class, and other needed components can be found on canvas in Files in the Lab 2 folder. YOU MUST USE THE BINTREE CLASS FROM FILES.
Sample Execution

Think of an animal.
I will ask you a series of yes/no questions
 and I will try to guess the animal.If I can't guess the animal, you can help me learn
how to guess that animal by giving me a new question.


Think of an animal. When you're ready, press return.


Are you a mammal? [Please type y or n] => y

Are you a hamster? [Please type y or n] => n

I give up. What are you?
lion

Please enter a question that is true for a lion
and false for a hamster.
Do you roar?

Thanks for teaching me a new animal!

Shall we play again? [Please type y or n] => y

Think of an animal. When you're ready, press return.


Are you a mammal? [Please type y or n] => n

Are you a snake? [Please type y or n] => n

I give up. What are you?
spider

Please enter a question that is true for a spider
and false for a snake.
Do you have legs?

Thanks for teaching me a new animal!

Shall we play again? [Please type y or n] => y

Think of an animal. When you're ready, press return.


Are you a mammal? [Please type y or n] => n

Do you have legs? [Please type y or n] => y

Are you a spider? [Please type y or n] => n

I give up. What are you?
eagle

Please enter a question that is true for a eagle
and false for a spider.
Do you have wings?

Thanks for teaching me a new animal!

Shall we play again? [Please type y or n] => y

Think of an animal. When you're ready, press return.


Are you a mammal? [Please type y or n] => y

Do you roar? [Please type y or n] => y

Are you a lion? [Please type y or n] => y

Got it!!!


Shall we play again? [Please type y or n] => n


Email Me | Office Hours | My Home Page | Department Home | MCC Home Page

© Copyright Emmi Schatz 2023

import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {

        BinTree<String> tree = new BinTree<String>("Are you a mammal?", new BinTree<String>("hamster"), new BinTree<String>("snake"));

        Scanner input = new Scanner(System.in);

        System.out.println("Think of an animal.\nI will ask you a series of yes/no questions and I will try to guess the animal.\nIf I can't guess the animal, you can help me learn how to guess that animal by giving me a new question.");
        
        startGame(tree, input);
    }
 
    public static void startGame(BinTree<String> tree, Scanner input) {
        do {
            System.out.print("\nThink of an animal. When you're ready, press return.");
            input.nextLine();
            playGame(tree, tree, input);
            System.out.print("\nShall we play again? [Please type y or n] => ");
        } while(input.nextLine().toUpperCase().charAt(0) == 'Y');
    }

    public static void playGame(BinTree<String> tree, BinTree<String> parent, Scanner input) {

        //if tree has at least one node it is a question
        if(tree.left != null || tree.right != null) {
            System.out.print("\n" + tree.getInfo() + " [Please type y or n] => "); //print question

            if(input.nextLine().toUpperCase().charAt(0) == 'Y') { //if user input is yes
                playGame(tree.left, tree, input);
            } 
            else { //if user input is no
                if(tree.right != null) { //if right tree exists
                    playGame(tree.right, tree, input);
                }
                else {  //if right tree doesn't exist
                    System.out.println("I give up. What are you?");
                    String animal = input.nextLine();

                    tree.right = new BinTree<String>(animal);   //set new animal on right
        
                    System.out.println("Thanks for teaching me a new animal!");
                }
            }
        } 
        else { //else it is a leaf
            System.out.print("\nAre you a " + tree.getInfo() + "? [Please type y or n] => ");  //ask question

            if(input.nextLine().toUpperCase().charAt(0) == 'Y') { //if user input is yes
                System.out.println("\nGot it!!!");
            } 
            else {  //if user input no then it is a new animal
                System.out.println("\nI give up. What are you?");
                String animal = input.nextLine();
    
                System.out.println("\nPlease enter a question that is true for a " + animal + " and false for a " + tree.getInfo());
                
                tree.left = new BinTree<String>(animal); //set new animal to left
                tree.right = new BinTree<String>(tree.getInfo()); //set old animal to right
                tree.setInfo(input.nextLine()); //set question in current node
    
                System.out.println("\nThanks for teaching me a new animal!");
            }
        }        
    }

}

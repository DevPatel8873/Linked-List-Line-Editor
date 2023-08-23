import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;



class Main 
{
  public static void main (String[] args) throws IOException, FileNotFoundException
  {
    //makes the scanner + initialize variables 
    Scanner userInput = new Scanner(System.in);
  
    String textFile = "";
    String command = "";
    int curLine = 1;
    DoublyLinkedList lineEditor = new DoublyLinkedList();

    
    //asks user for file name
    System.out.println("Please enter a file name: ");
    textFile = userInput.next();

    
    //checks if the file exists
    while(!textFile.equals("alamater.txt"))
    {
      System.out.println("Please enter a valid file name: ");
      textFile = userInput.next();
    }

    Scanner file = new Scanner(new File(textFile));

    //change delimiter to new lines so the program can go through the text file line-by-line
    file.useDelimiter("\n");

    //insert each line of the text file into a doubly linked list
    while (file.hasNext())
    {
      lineEditor.insertAtTail(file.next());
    }


    

   //prints out possible commands
    System.out.println("Possible commands:\nq, quit program\nd, delete current line\nf, move forwards one line\nb, move backwards one line\nh, skip to the head of the text file\nt, skip to the tail of the text file\ni, insert a line after the currently selected one in the text file\np, print however many lines you want in the text file starting from your current point");

    //prints the first line
    System.out.println(lineEditor.getLine(curLine));
      
    //asks the user for a command
    System.out.println("Please enter a command: ");
    command = userInput.next();
    String validLetters = "qdfbhtip";

    //makes sure the user enters a valid command
    while (validLetters.indexOf(command.toLowerCase()) == -1 || command.length() != 1)
    {
      System.out.println("Invalid Command. Please enter a valid command: ");
     command = userInput.next();
    }

    //loop until command says to quit
    while (command != "q"){
      
      //determine what command the user entered
      switch (command)
      {
        //quit program
        case "q":
          break;
        //deletes the current line
        case "d":
          //if able to delete
          if (lineEditor.length() > 0)
          {
            if (curLine < lineEditor.length())
            {
              //delete current line
              lineEditor.deleteNode(lineEditor.getLine(curLine));
            
              //print out new current line post-deletion
              System.out.println(lineEditor.getLine(curLine));
            }
            else{
              //print out error if unable to move forwards
              System.out.println("ERROR: Could not move forwards, reached end of file");
            }     
          }
          //if unable to delete
          else{
            //print error
            System.out.println("ERROR: Cannot delete any more");
          }
            break;
        //move forwards 1 line
        case "f": 
            //only run if able to move forwards
            if (curLine < lineEditor.length())
            {
              //increment current line
              curLine++;

              //print new current line
              System.out.println(lineEditor.getLine(curLine));
            }
            //if unable to move forwards
            else
            {
              //print error
              System.out.println("ERROR: Reached end of file");
            }
            break;
        //move backwards
        case "b":
          //if able to move backwards
          if (curLine > 1)
          {
            //move back one line
            curLine--;

            //print new current line
            System.out.println(lineEditor.getLine(curLine));
          }
          //if unable to move backwards
          else
          {
            //print error
            System.out.println("ERROR: Reached start of file");
          }
          break;
        //skip to head
        case "h":
          //set current line to that of the head
          curLine = 1;

          //print out new current line
          System.out.println(lineEditor.getLine(curLine));
  
          break;
        //skip to tail
        case "t":
          //set current line to that of the head
          curLine = lineEditor.length() - 1;

          //print out new current line
          System.out.println(lineEditor.getLine(curLine));
          break;
        //insert a line after the current one
        case "i":
          //ask user to input new line
          System.out.println("Enter a line to add after this line: ");

          //get new line from user
          String newLine = userInput.next();
          
          //insert new line after the current one
          lineEditor.insertNodeAfter(newLine, curLine - 1);
  
          break;
        //print out a given number of lines after the current one
        case "p":
          //ask user for number of lines they would like to print
          System.out.println("How many lines do you want to print?: ");
          //get number of lines from user
          int lines = userInput.nextInt();

          //print out lines
          System.out.println(lineEditor.toString(lines));
          break;
        //if command entered is invalid
        default:
          //print that command is invalid
          System.out.print("Invalid command. ");
          break;
      }
      FileWriter replacer = new FileWriter(textFile);

      //if command does not say to quit, get the next one
      if (command != "q"){
        for(int i = 0; i < lineEditor.length(); i++)
        {
          replacer.write(lineEditor.getLine(i) + "\n");
        }
  
        replacer.close();
          
        //ask user for command
        System.out.println("Please enter a command: ");
        //get command from user
    command = userInput.next();
      }

    }

    
    

  }
}





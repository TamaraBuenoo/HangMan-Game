/* 
NOOO
 
*/

import java.io.*;
import java.util.*;
public class Hangmanin {  

//if user gets a letter wrong, then add body parts to hang man
public static void printHangMan(int wrong){
  
 
  if (wrong==1){
    System.out.println("|----------");
    System.out.println("|       ");
    System.out.println("|     O ");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
  }
  else if (wrong==2){
    System.out.println("|----------");
    System.out.println("|       ");
    System.out.println("|      O ");
    System.out.println("|      |");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("______");
 }
  else if (wrong==3){
    System.out.println("|----------");
    System.out.println("|       ");
    System.out.println("|      O ");
    System.out.println("|     -|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
 }
  else if (wrong==4){
    System.out.println("|----------");
    System.out.println("|        ");
    System.out.println("|      O ");
    System.out.println("|     -|-");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
 }
  else if (wrong==5){
    System.out.println("|----------");
    System.out.println("|         ");
    System.out.println("|      O ");
    System.out.println("|     -|- ");
    System.out.println("|     /");
    System.out.println("|");
    System.out.println("|");
 }
  else if (wrong==6){
    System.out.println("|----------");
    System.out.println("|        ");
    System.out.println("|      O  ");
    System.out.println("|     -|- ");
    System.out.println("|     / \\");
    System.out.println("|");
    System.out.println("|");
 }
  
} 

public static void printarray(char []array ){
  for (int i=0; i<array.length; i++){ //creates array
    System.out.print(array[i]);
  }
}

public static void main(String[] args) throws Exception //if error it's okay (the main class)
{
    System.out.println("Welcome to Hangman! ");
    System.out.println("**********************");
    System.out.println("Guess the word ! ");
	String[] animals = {"turtle", "seal", "cow", "kitten", "dolphin", "orangutans", "mouse", "chicken", "duck", "pigeon" };
    //array of 10 animal names
   Scanner scan = new Scanner(System.in);
  //String animal="";
  
  Random random1 = new Random(); //creates random under randompic
  String randompic = animals[random1.nextInt(animals.length)];
   
  char [] user= new char[randompic.length()]; //new array with random length
  //!printing the hyphens before guessing
  for (int i=0; i< randompic.length(); i++){
    //!replacing with hyphen
    //!double quotations is string and single quotes is character
    user[i]='_'; //PROBLEM HERE
  }
  printarray(user);
  //!if the user input contains a letter from the random word, then print the letter. Or else, print hyphen.
  int wrong=0;
  boolean correct=  true;

  /*
  for (int x=0; x< user.length; x++){
    if(user[x]=='_') {
        System.out.print(" _"); //println skips dont use
        correct = false;
    }
    else {
        System.out.print(" " + user[x]); //print is better
    }
  }
  */

  while (correct){
    System.out.println (" ");
    System.out.println("Enter a letter: ");
  String guessLetter= scan.nextLine(); 
  //!use what the user guesses
  //!converts it to a character
  //!storing the letter
  char guess= guessLetter.charAt(0);
  
  if (!randompic.contains(guessLetter)){
      wrong+=1;
      printHangMan(wrong);
    }
  for (int i=0; i< randompic.length(); i++){
    if (guess==(randompic.charAt(i))){
      //!if guess is right, we swap the hyphens with a letter
      user[i]=randompic.charAt(i);

    }
    else{
      //!continue next iteration of the for loop
     continue;
    }

    //!for loop that checks all the characters. If entered all the correct characters then they win. 

  //!loop through each letter in correct answer  
    String answer="";
    for (int j = 0; j < user.length; j++){ //check each letter
      answer+= user[j];
           
    }
        if (answer.equals(randompic)){ //!HERE TOO
            System.out.print("You win!");
            correct= false;
        }   
  }
    printarray(user);
    System.out.println();
    
//if the word doesn't contain the letter guess, then we print the hang man. if everything is wrong (6 times) then game over.
    
    if (wrong==6){
      correct=false;
      System.out.println("You have lost :( ");
      System.out.println("The correct word was " + randompic); //HERE
    }
  }
  
}
}

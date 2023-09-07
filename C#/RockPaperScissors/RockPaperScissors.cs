using System;
namespace Rockpapersicssors
{
class Program {
   public static void Main (String [] args) 
   {

    

    String inputPlayer,inpurcpu;
    int randomInt;
    
    bool Playagain=true;

    while(Playagain)

    {
         int scorePlayer=0;
         int scoreCpu=0;
         int ManyPlays=1;

       while (ManyPlays<=3)
      {
        

          Console.WriteLine("Choose between Rock Paper Sicssors");
         
     inputPlayer = Console.ReadLine();
    if (inputPlayer!=null)
    {
        
          
     Random r=new Random();
     randomInt=r.Next(1,4);

       switch (randomInt)
      {
        case 1:
        inpurcpu="Rock";
        Console.WriteLine("computer chose rock");
        if (inputPlayer==inpurcpu)
        {
            Console.WriteLine("Draw!!");
            
        }
        else if(inputPlayer=="Paper"){
            Console.WriteLine("Player Wins!!");
            scorePlayer++;
        }
        else if(inputPlayer=="Scissors"){
            Console.WriteLine("Cpu Wins!!");
            scoreCpu++;
        }
         ManyPlays++;
        break;

        case 2:
        inpurcpu="Paper";
        Console.WriteLine("computer chose Paper");
        if (inputPlayer==inpurcpu)
        {
            Console.WriteLine("Draw!!");
            
        }
        else if(inputPlayer=="Rock"){
            Console.WriteLine("Player Wins!!");
            scorePlayer++;
        }
        else if(inputPlayer=="Scissors"){
            Console.WriteLine("Cpu Wins!!");
            scoreCpu++;
        }
         ManyPlays++;
        break;

        case 3:
        inpurcpu="Sicssors";
        Console.WriteLine("computer chose Sicssors");

       if (inputPlayer==inpurcpu)
        {
            Console.WriteLine("Draw!!");
            
        }
        else if(inputPlayer=="Rock"){
            Console.WriteLine("Player Wins!!");
            scorePlayer++;
        }
        else if(inputPlayer=="Paper"){
            Console.WriteLine("Cpu Wins!!");
            scoreCpu++;
        }
         ManyPlays++;
        break;

        default:
        Console.WriteLine("Invalid input");
        break;

       
      }
    }else{
       Console.WriteLine("Invalid input. Please choose Rock, Paper, or Scissors.");
        continue;
    }
      Console.WriteLine("\n\nScores:\tPlayer:\t{0}\tCpu:\t{1}",scorePlayer,scoreCpu);
       
     }
     if(scorePlayer>scoreCpu){
        Console.WriteLine("Player Wins!!");
     }
     else
     {
        Console.WriteLine("CPU Wins!!");
       
          }
       Console.WriteLine("Do You want to Play : Yes Or No");
      string loop=Console.ReadLine();
      if(loop=="Y"){
        Playagain=true;
        Console.Clear();
       }
      else if(loop == "N"){
        Playagain = false;
       }
       else{
        Console.WriteLine("Invalid input Please enter Y OR N");
     }

     
   
  }
  }

 
  }
    
}
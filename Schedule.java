import java.util.*;
public class Schedule{
	public static void main(String[] argv){
		Scanner input=new Scanner(System.in);
		String data[][]={};int stringMax=0,stringMin=0;
		System.out.print("Enter how many (min 4) classes you want to add: ");
		stringMax=input.nextInt();
		if(stringMax<=4){stringMax=4;}
		data=new String[stringMax][3];//column 0 of 2nd part of the 2d array is course title;1 is day;2 is time;
		for(int i=stringMin;i<stringMax;i++){int j=0;
				if(j==0){
					System.out.print("Enter the class title EX: \"CIS_110\" NO SPACES: ");
					String inputS=input.next();
					data[i][j]=inputS;
					j+=1;
				}
				if(j==1){
					int days=0;String day[]={"M","T","W","R","F","Sa","Su"};
					String updateDays="";
					for(int d=0;d<7;d++){
						System.out.print("Is this class meeting on a "+day[d]+"? (1 for yes or not 1 for no): ");
						days=input.nextInt();
						if(days==1){
							updateDays+=day[d]+",";
						}
					}//end for;
					data[i][j]=updateDays;j+=1;
				}
				if(j==2){
					int t=0;String timeS="",timeE="",timeT;
					if(t==0){
						System.out.print("Enter the class start time in military time EX: \"1445 or 930\": ");
						timeS=input.next();t+=1;
					}
					if(t==1){
						System.out.print("Enter the class end time in military time EX: \"1445 or 930\": ");
						timeE=input.next();
					}
					timeT=timeS+" - "+timeE;
					data[i][j]=timeT;j+=1;
				}
			if(j==3&&i==stringMax-1){
				int yesno=0;//this acts as a boolean and an integer...;
				System.out.print("Add any more classes? '1' for yes or not '1' for no: ");
				yesno=input.nextInt();
				if(yesno==1){
					System.out.print("Add how many more classes? ");
					yesno=input.nextInt();
					if(yesno>0){
						stringMin=stringMax;
						stringMax+=yesno;
						data=new String[stringMax][3];
					}
				}
			}
		}//end for;
		for(int i=0;i<stringMax;i++){
			System.out.println("Class "+(i+1)+": Class title: "+data[i][0]);
		}//end for;
		int max=1,enterClass;String inputClass;boolean trueClass=false;
		for(int n=0;n<max;n++){
			while(trueClass==false){
				System.out.print("Enter a valid class title from the above list to get the class info: ");
				inputClass=input.next();
				for(int i=0;i<stringMax;i++){
					if(inputClass.equals(data[i][0])){
						System.out.println("The selected class information: ");
						System.out.println("Class "+(i+1)+": Class title: "+data[i][0]+"; Class days: "+data[i][1]+"; Class times: "+data[i][2]+";");
						trueClass=true;i=stringMax-1;
					}
					else{
						if(i==stringMax-1){
							System.out.println("You have inputted an incorrect class... Please input a correct one. ");
						}
					}
				}//end for;
			}//end while;
			System.out.print("Enter another class title? (1 for yes or not 1 for no): ");
			enterClass=input.nextInt();
			if(enterClass==1){
				max+=1;trueClass=false;
			}
		}//end for;
		System.out.println("You have decided to end the program.");
		input.close();
	}//end main;
}//end class;
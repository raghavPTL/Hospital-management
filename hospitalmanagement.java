import java.io.*; import java.util.*; import java.lang.*; class patient{
String name;
String age;
String gender;
String number;
String city;
String disease;
Main main = new Main();
patient( String name, String age, String gender, String number, String city,
String disease) {
this.name = name; this.age = age; this.gender = gender; this.number = number; this.city = city; this.disease = disease;
}
public patient() {
}
Scanner sc = new Scanner(System.in);
File myfile = new File("C:/codes/project.txt"); void newentry()
{
patient pr = new patient(); System.out.print("Enter name: "); Scanner sc = new Scanner(System.in); String temp = sc.next();
boolean flag =true;
for(int i = 0;i<main.arr.size();++i){
if(main.arr.get(i).name.compareTo(temp) == 0){ System.out.println("Entry Already exists.\nDo you want to edit the
entry\nEnter 1 for edit\nEnter 2 to exit"); int n = sc.nextInt();
if(n == 1){ editentry(); flag = false; break;
}
else if(n == 2){
flag = false;
break; }
} }
if(flag == true) { pr.name = temp;

System.out.print("Enter age: ");
pr.age = sc.next();
System.out.print("Enter gender: "); pr.gender = sc.next(); System.out.print("Enter city: ");
pr.city = sc.next();
System.out.print("Enter Contact Number: "); pr.number = sc.next(); System.out.print("Enter disease: "); pr.disease = sc.next();
main.arr.add(pr);
System.out.println("Entry added!!\n"); }
}
void displayall(){
int count = 0;
for(int i =0;i<main.arr.size();++i){
System.out.println("name: "+main.arr.get(i).name+"\nage: "+main.arr.get(i).age+"\nGender: "+main.arr.get(i).gender+"\nContact Number: "+main.arr.get(i).number+"\ncity: "+main.arr.get(i).city+"\ndisease: "+main.arr.get(i).disease);
System.out.println();
count++; }
if(count==0) System.out.println("No records");
}
void displayspecificentry(){
System.out.print("Enter the name to display details: "); String temp = sc.nextLine();
int flag = 0;
for(int i =0;i<main.arr.size();++i){
if(temp.equals(main.arr.get(i).name) == true){ System.out.println("name: "+main.arr.get(i).name+"\nage:
"+main.arr.get(i).age+"\nGender: "+main.arr.get(i).gender+"\nContact Number: "+main.arr.get(i).number+"\ncity: "+main.arr.get(i).city+"\ndisease: "+main.arr.get(i).disease);

System.out.println("Entry found successfully"); flag = 1;
break;
} }
if(flag == 0){
System.out.println("No such records found");
System.out.println("do you want to enter it as new record? \nEnter 1 for
yes \nEnter 2 for no");
int h = sc.nextInt();
if(h == 1){
patient pr = new patient(); newentry();
} }
}
void deletespecificentry(){
System.out.print("Enter the name to delete details: "); Scanner sc = new Scanner(System.in);
String temp = sc.next();
int flag = 0;
for(int i =0;i<main.arr.size();++i){ if(temp.equals(main.arr.get(i).name) == true){
main.arr.remove(i);
System.out.println("Entry deleted successfully"); flag = 1;
break;
} }
if(flag == 0){
System.out.println("No Such Entry Found!!");
} }
void deleteall(){
for(int i = 0;i<main.arr.size();++i){
main.arr.remove(i); }

}
void end(){
try {
FileWriter fileWriter = new FileWriter("project.txt");
for(int i =0;i<main.arr.size();++i){ fileWriter.write(main.arr.get(i).name +" "+main.arr.get(i).age +"
"+main.arr.get(i).gender+" "+main.arr.get(i).city +" "+main.arr.get(i).number+" "+main.arr.get(i).disease+"\n");
}
fileWriter.close(); }
catch (IOException e) { e.printStackTrace();
} }
void editentry(){ System.out.print("Enter name: "); Scanner sc = new Scanner(System.in); String temp = sc.next();
int h;
boolean flag = true;
for(int i = 0;i<main.arr.size();++i){
if(temp.equals(main.arr.get(i).name) == true){ flag = false;
while(true){
h = i;
System.out.println("Enter the choice you want to edit: "); System.out.println("Enter 1 to edit age\nEnter 2 to edit city\nEnter 3
to edit contact number\nEnter 4 to edit disease"); int n = sc.nextInt();
if(n == 1){ System.out.print("Enter age: "); main.arr.get(h).age = sc.next();
}
else if(n == 2){
System.out.print("Enter city: ");

main.arr.get(i).city = sc.next(); }
else if(n == 3){ System.out.print("Enter number: "); main.arr.get(i).number = sc.next();
}
else if(n == 4){
System.out.print("Enter disease: ");
main.arr.get(i).disease = sc.next(); }
System.out.println("Enter 1 to continue editing\nEnter 2 to go back to
System.out.print("Enter choice: "); int g = sc.nextInt();
if(g == 1){
continue; }
else if(g == 2){ System.out.println("editted!!"); break;
} }
} }
if(flag == true){
System.out.print("No such Entry exists\nEnter 1 to add the entry\nEnter 2
to go back to main menu\nEnter choice: "); int n = sc.nextInt();
if(n == 1){ newentry();
}
else {
System.out.println("Return to main menu "); }
} }
}
menu");

class Main {
static ArrayList<patient> arr = new ArrayList<patient>(); public static void main(String[] args) throws IOException{
Scanner sc = new Scanner(System.in); File myFile = new File("project.txt"); patient p = new patient();
try {
Scanner scan = new Scanner(myFile); while(scan.hasNextLine()){
patient pr = new patient();
String line = scan.nextLine(); String[] arrOfStr = line.split(" ", 6); //pr.id = arrOfStr[0];
pr.name = arrOfStr[0];
pr.age = arrOfStr[1];
pr.gender = arrOfStr[2];
pr.number = arrOfStr[3];
pr.city = arrOfStr[4];
pr.disease = arrOfStr[5]; arr.add(pr);
}
scan.close();
} catch (FileNotFoundException e) {
e.printStackTrace(); }
while(true) {
System.out.println("\nEnter 1 to add new entry \nEnter 2 to display all
entry\nEnter 3 for viewing specific entry\nEnter 4 for deleting specific entry\nEnter 5 for delete the list\nEnter 6 to edit entry\nEnter 7 to end the program");
System.out.print("Enter choice: ");
int n = sc.nextInt(); if(n == 1){
p.newentry(); }

else if(n==2){ System.out.println("All entries: "); p.displayall();
}
else if(n == 3){
p.displayspecificentry(); }
else if(n == 4){ p.deletespecificentry();
}
else if(n == 5){
p.deleteall(); }
else if(n == 7) {
p.end();
System.out.println("End of Program"); break;
}
else if(n == 6) {
p.editentry(); }
else{
System.out.println("Invalid Input,Enter Again");
} }
} }
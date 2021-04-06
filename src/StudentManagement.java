import java.util.Scanner;

public class StudentManagement {
    static String[] id, name, birthDate, score;
    static Scanner sc = new Scanner(System.in);
    static int size;

    static String[] removeElement(String[] array,int index_del){
        String[] newArray = new String[array.length-1];
        for (int i = 0; i < index_del; i++){
            newArray[i] = array[i];
        }
        for (int i = index_del+1; i < array.length; i++){
            newArray[i-1] = array[i];
        }
        return newArray;
    }

    static String[] addElement(String[] array, String value){
        String[] newArray = new String[array.length+1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        return newArray;
    }


    static void removeStudent(){
        System.out.println("Enter the ID of student to be removed: ");
        int index_del = sc.nextInt()-1;
        size--;
        for (int i = 0; i < size; i++){
            id[i] = Integer.toString(i+1);
        }
        name = removeElement(name, index_del);
        birthDate = removeElement(birthDate, index_del);
        score = removeElement(score, index_del);
        displayStudent();
    }

    static void addStudent(){
        sc.nextLine();
        System.out.println("Enter new student's name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new student's date of birth: ");
        String newBirthDate = sc.nextLine();
        System.out.println("Enter new student's score: ");
        String newScore = sc.nextLine();
        size++;
        id = addElement(id, Integer.toString(id.length+1));
        name = addElement(name, newName);
        birthDate = addElement(birthDate, newBirthDate);
        score = addElement(score, newScore);

        displayStudent();
    }

    static void editStudent(){
        System.out.println("Enter ID of the student to be edited: ");
        int index_edit = sc.nextInt()-1;
        System.out.println("Enter the code to edit the respective information: ");
        System.out.println("1. Edit name");
        System.out.println("2. Edit date of birth");
        System.out.println("3. Edit score");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:{
                System.out.println("Enter the edited name: ");
                name[index_edit] = sc.nextLine();
                break;
            }
            case 2:{
                System.out.println("Enter the edited date of birth: ");
                birthDate[index_edit] = sc.nextLine();
                break;
            }
            case 3:{
                System.out.println("Enter the edited score: ");
                score[index_edit] = sc.nextLine();
            }
            default:
                System.out.println("NO choice!");
        }

        displayStudent();
    }

    static void findMaxScore(){
        int maxScore = Integer.valueOf(score[0]);
        int maxId = 0;
        for (int i = 0; i < size; i++){
            if (Integer.valueOf(score[i]) > maxScore){
                maxScore = Integer.valueOf(score[i]);
                maxId = i;
            }
        }
        System.out.print(id[maxId]+"\t");
        System.out.print(name[maxId]+"\t");
        System.out.print(birthDate[maxId]+"\t");
        System.out.println(score[maxId]+"\t");
    }

    static void sortDescending(){
        for (int i = 0; i < size; i++){
            for (int j = i+1; j < size; j++){
                String tempId, tempName, tempDate, tempScore;
                if (Integer.valueOf(score[i]) < Integer.valueOf(score[j])){
                    tempId = id[i];
                    id[i] = id[j];
                    id[j] = tempId;

                    tempName = name[i];
                    name[i] = name[j];
                    name[j] = tempName;

                    tempDate = birthDate[i];
                    birthDate[i] = birthDate[j];
                    birthDate[j] = tempDate;

                    tempScore = score[i];
                    score[i] = score[j];
                    score[j] = tempScore;
                }
            }
        }
        displayStudent();
    }

    static void displayStudent(){
        System.out.println("Student list: ");
        for (int index = 0; index < size; index++){
            System.out.print(id[index]+".\t");
            System.out.print(name[index]+"\t");
            System.out.print(birthDate[index]+"\t");
            System.out.println(score[index]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args){

        System.out.println("Enter the number of students: ");
        size = sc.nextInt();
        sc.nextLine();

        int choice = -1;

        id = new String[size];
        for (int i = 0; i < size; i++){
            id[i] = Integer.toString(i+1);
        }

        name = new String[size];
        birthDate = new String[size];
        score = new String[size];
        for (int i = 0; i < size; i++){
            System.out.println("Enter the name of student "+(i+1)+": ");
            name[i] = sc.nextLine();
            System.out.println("Enter the date of birth of student "+(i+1)+": ");
            birthDate[i] = sc.nextLine();
            System.out.println("Enter the score of student "+(i+1)+": ");
            score[i] = sc.nextLine();
        }

        while(choice != 0){
            System.out.println("Menu: ");
            System.out.println("1. Display all students");
            System.out.println("2. Remove a student");
            System.out.println("3. Add a student");
            System.out.println("4. Edit a student");
            System.out.println("5. Find highest score");
            System.out.println("6. Sort from the Highest Score");
            System.out.println("0. Exit");
            System.out.println("Enter the code for each task: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: {
                    displayStudent();
                    break;
                }
                case 2: {
                    removeStudent();
                    break;
                }
                case 3: {
                    addStudent();
                    break;
                }
                case 4: {
                    editStudent();
                    break;
                }
                case 5: {
                    findMaxScore();
                    break;
                }
                case 6: {
                    sortDescending();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default:
                    System.out.println("No choice!");
            }
        }
    }
}

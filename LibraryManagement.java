import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Store 10 books maximum
        String[] bookName = new String[10];
        int[] bookId = new int[10];
        String[] status = new String[10]; // "Available" or "Issued"
        
        int totalBooks = 0; // How many books we have added
        
        // Add 2 books already
        bookName[0] = "Java Book";
        bookId[0] = 101;
        status[0] = "Available";
        totalBooks = 1;
        
        bookName[1] = "Python Book";
        bookId[1] = 102;
        status[1] = "Available";
        totalBooks = 2;
        
        while (true) {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Show All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            
            // Option 1: Show all books
            if (choice == 1) {
                System.out.println("\nAll Books:");
                for (int i = 0; i < totalBooks; i++) {
                    System.out.println(bookId[i] + " - " + bookName[i] + " - " + status[i]);
                }
            }
            
            // Option 2: Add new book
            else if (choice == 2) {
                if (totalBooks >= 10) {
                    System.out.println("Library is full!");
                } else {
                    System.out.print("Enter book ID: ");
                    bookId[totalBooks] = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    
                    System.out.print("Enter book name: ");
                    bookName[totalBooks] = sc.nextLine();
                    
                    status[totalBooks] = "Available";
                    totalBooks++;
                    
                    System.out.println("Book added!");
                }
            }
            
            // Option 3: Issue book
            else if (choice == 3) {
                System.out.print("Enter book ID to issue: ");
                int id = sc.nextInt();
                
                boolean found = false;
                for (int i = 0; i < totalBooks; i++) {
                    if (bookId[i] == id) {
                        found = true;
                        if (status[i].equals("Available")) {
                            status[i] = "Issued";
                            System.out.println("Book issued!");
                        } else {
                            System.out.println("Book already issued!");
                        }
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Book not found!");
                }
            }
            
            // Option 4: Return book
            else if (choice == 4) {
                System.out.print("Enter book ID to return: ");
                int id = sc.nextInt();
                
                boolean found = false;
                for (int i = 0; i < totalBooks; i++) {
                    if (bookId[i] == id) {
                        found = true;
                        if (status[i].equals("Issued")) {
                            status[i] = "Available";
                            System.out.println("Book returned!");
                        } else {
                            System.out.println("Book was not issued!");
                        }
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Book not found!");
                }
            }
            
            // Option 5: Exit
            else if (choice == 5) {
                System.out.println("Thank you!");
                break;
            }
            
            else {
                System.out.println("Wrong choice!");
            }
        }
        
        sc.close();
    }
}


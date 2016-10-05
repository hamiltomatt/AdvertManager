
package advertmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class AdvertManager {

    public static void main(String[] args) 
    {
        // Declare string value to return what the user inputs as menu choice
        String menuChoice = showMenu();
        // While user does not want to exit
        while (!menuChoice.equals("0"))
        {
            // This navigates through different cases for the menu choice
            switch (menuChoice) {
                case "1":
                    enterNewAdvert();
                    break;
                case "2":
                    displaySummaryOfAdverts();
                    break;
                case "3":
                    displaySummaryForMonth();
                    break;
                case "4":
                    findAndDisplayAdverts();
                    break;
                default:
                    System.out.println("There is an error with your selection, please try again");
                    break;
            }
            
            // Asks for new input of menyChoice
            menuChoice = showMenu();
        }
        System.out.println("Now closing the program");
    }
    
    // Displays the menu and returns a String of the user's input
    public static String showMenu()
    {
        System.out.println("Please input a number to select");
        System.out.println("1. Enter new advert");
        System.out.println("2. Display summary of adverts");
        System.out.println("3. Display summary of adverts for selected month");
        System.out.println("4. Find and display adverts");
        System.out.println("0. Exit");
        // Create scanner to get keyboard input
        Scanner keyboard = new Scanner(System.in);
        // This returns the String to be used by the main method
        return keyboard.nextLine();
    }
     
    // Creates and validates a new advert
    public static void enterNewAdvert()
    {
        // Create and instantiate a new advert
        Advert a = new Advert();
        // Declare scanner and instantiate
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        
        //Ask user to enter in client name
        System.out.println("Enter the client name (max of 30 characters)");
        // Input is sent to advert class to be validated, if valid a true value is returned
        boolean validFlag = a.setClientName(keyboard.nextLine());
        // While input is invalid, ask for re-entry until valid
        while(validFlag != true)
        {
            System.out.println("The client name you have entered is invalid, please try again");
            System.out.println("Enter the client name (max of 30 characters)");
            validFlag = a.setClientName(keyboard.nextLine());            
        }

        System.out.println();
        
        //Ask user to enter type
        System.out.println("Enter the type of advert by entering a value");
        System.out.println("1. Black and white");
        System.out.println("2. Colour");
        System.out.println("3. Double-sided wrapper");
        validFlag = a.setType(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The type you have entered is invalid, please try again");
            System.out.println("Enter the type of advert by entering a value");
            System.out.println("1. Black and white");
            System.out.println("2. Colour");
            System.out.println("3. Double-sided wrapper");
            validFlag = a.setType(keyboard.nextLine());
        }

        System.out.println();
        
        // Ask user to enter position
        System.out.println("Enter the position of advert by entering a value");
        System.out.println("1. In run of paper");
        System.out.println("2. On front cover");
        System.out.println("3. On back cover");
        System.out.println("4. Double-sided wrapper");
        validFlag = a.setPosition(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The position you have entered is invalid, please try again");
            System.out.println("Enter the position of advert by entering a value");
            System.out.println("1. In run of paper");
            System.out.println("2. On front cover");
            System.out.println("3. On back cover");
            System.out.println("4. Double-sided wrapper");
            validFlag = a.setPosition(keyboard.nextLine());
        }

        System.out.println();
        
        // Ask user to enter height
        System.out.println("Enter the height of advert in centimetres (must be multiple of 5 between 10 and 70, 0 for wrappers)");
        validFlag = a.setHeight(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The height you have entered is invalid, please try again");
            System.out.println("Enter the height of advert in centimetres (must be multiple of 5 between 10 and 70, 0 for wrappers)");
            validFlag = a.setHeight(keyboard.nextLine());
        }

        System.out.println();
        
        // Ask user to enter width
        System.out.println("Enter the width of advert in columns (max of 5, 0 for wrappers)");
        validFlag = a.setWidth(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The width you have entered is invalid, please try again");
            System.out.println("Enter the width of advert in columns (max of 5)");
            validFlag = a.setWidth(keyboard.nextLine());
        }

        System.out.println();
        
        // Ask user to enter artwork
        System.out.println("Is artwork required for advert? 1 for yes, 0 for no");
        //
        validFlag = a.setArtwork(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The value you have input is invalid, please try again");
            System.out.println("Is artwork required for advert? 1 for yes, 0 for no");
            validFlag = a.setArtwork(keyboard.nextLine());            
        }

        System.out.println();
        
        // Ask user to enter reference number
        System.out.println("Enter a reference number for this advert (e.g. A123ED)");
        validFlag = a.setReferenceNo(keyboard.nextLine());
        while(validFlag != true)
        {
            System.out.println("The reference number you have entered is invalid, please try again");
            System.out.println("Enter a reference number for this advert (e.g. A123ED)");
            validFlag = a.setReferenceNo(keyboard.nextLine());            
        }

        System.out.println();
        
        // If calcPrice completed, send back true
        validFlag = a.calcPrice();
        // If invalid, return error message
        if(validFlag == false)
        {
            System.out.println("There has been an error calculating the price with the inputs given, please try again");
        }
        // Else, continue with program
        else
        {
        displaySummary(a);        
        appendAdvert(a);
        }

    }
    
    // Displays the summary from an advert given
    public static void displaySummary(Advert a)
    {
        // Declare 13 string array, the summary
        String[] summary = new String[13];
        // Declare string arrays putting numerical advert variables to English
        String[] positions = {"Run", "Front", "Back", "Wrapper"};
        String[] columns = {"Wrapper", "One", "Two", "Three", "Four", "Five"};
        String[] types = {"B&W", "Colour", "Wrapper"};
        String[] arts = {"No", "Yes"};
        // Declare top and bottom strings as well as an empty string template
        summary[0] = "+------------------------------------------+";
        summary[12] = "+------------------------------------------+";        
        String empty = "|                                          |";

        summary[1] = empty;

        // Assign as start of string
        summary[2] = "|   Client: ";
        // Declare string which grabs clientName, which is concatenated onto end of summary string
        String s = a.getClientName();
        summary[2] = summary[2].concat(s);
        // Fills in empty space at end of array to make sure borders are in place
        for(int i = 30-s.length(); i >= 0; i--)
        {
            summary[2] = summary[2].concat(" ");
        }
        summary[2] = summary[2].concat("|");

        summary[3] = empty;
        
        summary[4] = "|     Date: ";
        s = a.getDate();
        // Replaces all dashes in string to spaces to look tidier
        s = s.replace("-", " ");
        // Concatenates date onto summary string
        summary[4] = summary[4].concat(s);
        // Fills in space between date and reference no
        for(int i = 16-s.length(); i >= 0; i--)
        {
            summary[4] = summary[4].concat(" ");
        }
        summary[4] = summary[4].concat("Ref: ");
        s = a.getReferenceNo();
        summary[4] = summary[4].concat(s);
        summary[4] = summary[4].concat("   |");

        summary[5] = "| Position: ";
        int pos = a.getPosition();
        // This attaches a particular string in an array declared above to turn numerical position value into English
        summary[5] = summary[5].concat(positions[pos-1]);
        for(int i = 15-(positions[pos-1].length()); i >= 0; i--)
        {
            summary[5] = summary[5].concat(" ");
        }
        summary[5] = summary[5].concat("Type: ");
        int type = a.getType();
        summary[5] = summary[5].concat(types[type-1]);
        for(int i = 8-(types[type-1].length()); i >= 0; i--)
        {
            summary[5] = summary[5].concat(" ");
        }
        summary[5] = summary[5].concat("|");

        summary[6] = "|  Columns: ";
        int col = a.getWidth();
        summary[6] = summary[6].concat(columns[col]);
        for(int i = 13-(columns[col].length()); i >= 0; i--)
        {
            summary[6] = summary[6].concat(" ");
        }
        summary[6] = summary[6].concat("Height: ");
        s = Integer.toString(a.getHeight()) + "cm";
        summary[6] = summary[6].concat(s);
        for(int i = 8 - s.length(); i >= 0; i--)
        {
            summary[6] = summary[6].concat(" ");
        }
        summary[6] = summary[6].concat("|");

        summary[7] = empty;

        summary[8] = "|  Artwork: ";
        int art = a.getArtwork();
        summary[8] = summary[8].concat(arts[art]);
        for(int i = 13 - arts[art].length(); i >= 0; i--)
        {
            summary[8] = summary[8].concat(" ");
        }
        summary[8] = summary[8].concat("Charge: ");
        // If artwork not needed, say none, else, write charge in pounds and pence
        if(art == 0)
        {
            summary[8] = summary[8].concat("None     |"); 
        }
        else if(art == 1)
        {
            int charge = a.getCharge();
            String pCharge = String.format("£%.2f", charge / 100.0);
            summary[8] = summary[8].concat(pCharge);
            for(int i = 8-pCharge.length(); i >= 0; i--)
            {
                summary[8] = summary[8].concat(" ");
            }
            summary[8] = summary[8].concat("|");
        }

        summary[9] = empty;

        //Get if its an account transaction
        summary[10] = "|";
        int isAccount = a.getIsAccount();
        String writtenPrice = null;
        // Variables to track number of characters needed preceding price string and proceding
        int pre;
        int pro;
        // Show Discounted Price when discount
        if(isAccount == 1)
        {
            writtenPrice = String.format("Discounted Price: £%.2f ", a.getDiscountPrice() / 100.0);
        }    
        else
        {
            writtenPrice = String.format("Price: £%.2f ", a.getPrice() / 100.0);
        }    
        
        // Calculate number of blank chars available around string
        int space = 42 - writtenPrice.length();
        // If number is not divisible by 2 (cannot be easily halved) one is divided by 2, other added by 1
        if(space%2 != 0)
        {
            pre = space / 2;
            pro = space / 2 + 1;
        }
        // If number divisible by 2, both divided by 2
        else
        {
            pre = space / 2;
            pro = space / 2;
        }

        // Count characters preceding string
        for(int i = 1; i <= pre; i++)
        {
            summary[10] = summary[10].concat(" ");
        }
        // Concatenate main string
        summary[10] = summary[10].concat(writtenPrice);
        // Count characters proceding string
        for(int i = 1; i <= pro; i++)
        {
            summary[10] = summary[10].concat(" ");
        }
        summary[10] = summary[10].concat("|");

        summary[11] = empty;

        // Display all lines sequentially to show summary
        System.out.println();
        for(int i = 0; i <= 12; i++)
        {
            System.out.println(summary[i]);
        }
        System.out.println();

    }
    
    public static void appendAdvert(Advert a)
    {
        // PrintWriter created
        PrintWriter output = null;
        // File created and instantiated
        File main = new File("main.txt");
        try
        {
            // FileWriter created, to write to main file
            FileWriter fw = new FileWriter(main, true);
            // PrintWriter assigned, to write to FileWriter fw
            output = new PrintWriter(fw);
        }
        catch(FileNotFoundException e)
        {
            // If file not found in directory
            System.out.println("There has been an error finding the file");
        }
        catch (IOException ex)
        {
            // If I/O error occurs
            System.out.println("There has been an input/output error");
        }
        
        // Print details of advert to file
        output.print(a.getDate() + "   ");
        output.print(a.getType() + "    ");
        output.print(a.getPosition() + "    ");
        output.print(a.getHeight() + "    ");
        output.print(a.getWidth() + "    ");
        // If artwork is needed or not
        if(a.getArtwork() == 0)
        {
            output.print("N    ");
                
        }
        else if(a.getArtwork() == 1)
        {
            output.print("Y    ");
        }
        output.print(a.getReferenceNo() + "    ");
        // If account transaction and has discount
        if(a.getIsAccount() == 0)
        {
            output.print(a.getPrice() + "    ");
        }
        else if(a.getIsAccount() == 1)
        {
            output.print(a.getDiscountPrice() + "    ");
        }
        output.print(a.getClientName() + "    ");
        // Use println to move down one for next input
        output.println();
        // Close the file
        output.close();
    }
    
    public static void displaySummaryOfAdverts()
    {
        Scanner keyboard = new Scanner(System.in);
        boolean validFlag = false;
        Scanner file = null;
        int i = 0;
        // While input is invalid, ask user to re-enter
        while(validFlag == false)
        {
            System.out.println("Please input a number you want to select");
            System.out.println("0. main.txt");
            System.out.println("1. agent.txt");
            String s = keyboard.nextLine();
            try
            {
                // If string to integer conversion fails, go to NumberFormatException
                i = Integer.parseInt(s);
                // If 0 or 1, then valid, else invalid
                if(i == 0)
                {
                    validFlag = true;
                }
                else if(i == 1)
                {
                    validFlag = true;
                }
                else
                {
                    System.out.println("There has been an error with your input, please try again");
                    validFlag = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("There was an error with your input, please try again");
                validFlag = false;
            }
        }
        
        if(i == 0)
        {
            // If 0, then create new File linking to main.txt inside creating a new scanner, and assigning that to scanner file
            // If file not found, go to FileNotFoundException
            try
            {
                file = new Scanner(new File("main.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
                    
        }
        else if(i == 1)
        {
            // If 1, connect to agent.txt
            try
            {
                file = new Scanner(new File("agent.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
        }
        
        int totalNo = 0;
        int noOfColour = 0;
        int totalOfPrices = 0;
        int averageOfPrices = 0;
        boolean isWrapper = false;
        int janAds = 0;
        int febAds = 0;
        int marAds = 0;
        int aprAds = 0;
        int mayAds = 0;
        int junAds = 0;
        int julAds = 0;
        int augAds = 0;
        int sepAds = 0;
        int octAds = 0;
        int novAds = 0;
        int decAds = 0;
        int type = 0;
        String rNo = null;
        int price = 0;
        
        // While there is more information in the next function of file
        while(file.hasNext())
        {
            // Increment totalNo to end up with the total number of adverts
            totalNo++;
            // Get date
            String date = file.next();
            // Get month by finding substring of date string
            String month = date.substring(3, 6);
            switch(month)
            {
                // In each case, add to month's specific variable
                case "Jan":
                    janAds++;
                    break;
                case "Feb":
                    febAds++;
                    break;
                case "Mar":
                    marAds++;
                    break;
                case "Apr":
                    aprAds++;
                    break;
                case "May":
                    mayAds++;
                    break;
                case "Jun":
                    junAds++;
                    break;
                case "Jul":
                    julAds++;
                    break;
                case "Aug":
                    augAds++;
                    break;
                case "Sep":
                    sepAds++;
                    break;
                case "Oct":
                    octAds++;
                    break;
                case "Nov":
                    novAds++;
                    break;
                case "Dec":
                    decAds++;
                    break;
                default:
                    System.out.println("There was an error with the file provided");
            }
            try
            {
                type = Integer.parseInt(file.next());
                if((type == 2) || (type == 3))
                {
                    // If type 2 or 3 (colour or wrapper), increment
                    noOfColour++;                    
                }
                else if(type == 3)
                {
                    // If type 3, are wrappers
                    isWrapper = true;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("There was an error with the file provided");
            }

            file.next();
            file.next();
            file.next();
            file.next();
            
            rNo = file.next();
            try
            {
                price = Integer.parseInt(file.next());
            }
            catch(NumberFormatException e)
            {
                System.out.println("There was an error with the file provided");
            }
            
            // If not wrapper
            if(isWrapper == false)
            {
                // If first character is an a, find the pre-discount price, add to total
                if((rNo.charAt(0) == 'A') || (rNo.charAt(0) == 'a'))
                {
                    totalOfPrices = totalOfPrices + (int)((price / 9.0f) * 10.0f);
                }
                // If first character is a c, find the price, add to total
                else if((rNo.charAt(0) == 'C') || (rNo.charAt(0) == 'c'))
                {
                    totalOfPrices = totalOfPrices + price;
                }
            }
            // Go to next line
            file.nextLine();
        }
        // Find average by taking total of prices and dividing by total number of adverts
        averageOfPrices = totalOfPrices / totalNo;
        
        // Display summary
        System.out.println();
        System.out.println("Total number of adverts: " + totalNo);
        System.out.println("Number of colour adverts (inc. wrappers): " + noOfColour);
        System.out.println("Average pre-discounted price of adverts (exc. wrappers): " + String.format("£%.2f ", averageOfPrices / 100.0));
        System.out.println("Number of adverts per month: ");
        System.out.println("Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec");
        System.out.println(janAds + "    " + febAds + "    " + marAds + "    " + aprAds + "    " + mayAds + "    " + junAds + "    " + julAds + "    " + augAds + "    " + sepAds + "    " + octAds + "    " + novAds + "    " + decAds);
        System.out.println();
    }
    
    public static void displaySummaryForMonth()
    {
        Scanner keyboard = new Scanner(System.in);
        boolean validFlag = false;
        Scanner file = null;
        int i = 0;
        // While invalid, ask for re-entry
        while(validFlag == false)
        {
            System.out.println("Please input a number you want to select");
            System.out.println("0. main.txt");
            System.out.println("1. agent.txt");
            String s = keyboard.nextLine();
            try
            {
                // If string to int conversion fails, go to NumberFormatException
                i = Integer.parseInt(s);
                // If not 0 or 1, display menu again
                if(i == 0)
                {
                    validFlag = true;
                }
                else if(i == 1)
                {
                    validFlag = true;
                }
                else
                {
                    System.out.println("There has been an error with your input, please try again");
                    validFlag = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("There was an error with your input, please try again");
                validFlag = false;
            }
        }
        
        if(i == 0)
        {
            try
            {
                file = new Scanner(new File("main.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
                    
        }
        else if(i == 1)
        {
            try
            {
                file = new Scanner(new File("agent.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
        }
        
        validFlag = false;
        while(validFlag == false)
        {
            System.out.println("Enter a month of the year by inputting its number (Jan is 1, Feb is 2 etc.)");
            String month = keyboard.nextLine();
            try
            {
                i = Integer.parseInt(month);
                if((i >= 1) && (i <= 12))
                {
                    validFlag = true;
                }
                else
                {
                    System.out.println("There has been an error with your input, please try again");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("There was an error with your input, please try again");
                validFlag = false;
            }
        }
        
        int totalNo = 0;
        int noOfColour = 0;
        int totalOfPrices = 0;
        int averageOfPrices = 0;
        boolean isWrapper = false;
        int type = 0;
        String rNo = null;
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int price = 0;
        
        // While there is more information in the next function of file
        while(file.hasNext())
        {
            // Get date
            String date = file.next();
            // Get month by finding substring of date string
            String month = date.substring(3, 6);
            // If month found is the month user entered
            if(month.equals(months[i-1]))
            {
                totalNo++;
                try
                {
                    type = Integer.parseInt(file.next());
                    if((type == 2) || (type == 3))
                    {
                        // If type 2 or 3 (colour or wrapper), increment
                        noOfColour++;                    
                    }
                    else if(type == 3)
                    {
                        // If type 3, are wrappers
                        isWrapper = true;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("There was an error with the file provided");
                }

                file.next();
                file.next();
                file.next();
                file.next();

                rNo = file.next();
                try
                {
                    price = Integer.parseInt(file.next());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("There was an error with the file provided");
                }

                // If not wrapper
                if(isWrapper == false)
                {
                    // If first character is an a, find the pre-discount price, add to total
                    if((rNo.charAt(0) == 'A') || (rNo.charAt(0) == 'a'))
                    {
                        totalOfPrices = totalOfPrices + (int)((price / 9.0f) * 10.0f);
                    }
                    // If first character is a c, find the price, add to total
                    else if((rNo.charAt(0) == 'C') || (rNo.charAt(0) == 'c'))
                    {
                        totalOfPrices = totalOfPrices + price;
                    }
                }
                   


            }
            // Move to next line
            file.nextLine(); 

        }
        // Find average by taking total of prices and dividing by total number of adverts
        averageOfPrices = totalOfPrices / totalNo;
        
        // Display summary
        System.out.println();
        System.out.println("Total number of adverts: " + totalNo);
        System.out.println("Number of colour adverts (inc. wrappers): " + noOfColour);
        System.out.println("Average pre-discounted price of adverts (exc. wrappers): " + String.format("£%.2f ", averageOfPrices / 100.0));
        System.out.println();
        
        
    }
    
    public static void findAndDisplayAdverts()
    {
        Scanner keyboard = new Scanner(System.in);
        String date;
        String type;
        String pos;
        String height;
        String width;
        String artwork;
        String price;
        boolean validFlag = false;
        boolean isMatch = false;
        Scanner file = null;
        int i = 0;
        // While input is invalid, repeat
        while(validFlag == false)
        {
            System.out.println("Please input a number you want to select");
            System.out.println("0. main.txt");
            System.out.println("1. agent.txt");
            String s = keyboard.nextLine();
            try
            {
                i = Integer.parseInt(s);
                if(i == 0)
                {
                    validFlag = true;
                }
                else if(i == 1)
                {
                    validFlag = true;
                }
                else
                {
                    System.out.println("There has been an error with your input, please try again");
                    validFlag = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("There was an error with your input, please try again");
                validFlag = false;
            }
        }
        
        // If 0. connect to main, else, agent
        if(i == 0)
        {
            try
            {
                file = new Scanner(new File("main.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
                    
        }
        else if(i == 1)
        {
            try
            {
                file = new Scanner(new File("agent.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("There was an error with the text file");
            }
        }
        
        //Ask user for string to search for
        System.out.println("Search for a specific reference no or client name");
        String search = keyboard.nextLine();
        while(file.hasNext())
        {
            // Stores data as local variables so are available if match is found
            date = file.next();
            type = file.next();
            pos =  file.next();
            height = file.next();
            width = file.next();
            String s = file.next();
            if("Y".equals(s))
            {
                artwork = "1";
            }
            else
            {
                artwork = "0";
            }
            String refNo = file.next();
            // If refNo contains contents of search, then is a match (is a match in any case, upper or lower)
            if((refNo.contains(search)) || (refNo.contains(search.toUpperCase())) || (refNo.contains(search.toLowerCase())))
            {
                isMatch = true;
            }
            
            price = file.next();
            String clientName = file.next() + " " + file.next();
            
            // If refNo contains contents of search, then is a match (is a match in any case, upper or lower)            
            if((clientName.contains(search)) || (clientName.contains(search.toUpperCase())) || (clientName.contains(search.toLowerCase()))) 
            {
                isMatch = true;
            }
            
            // If is match
            if(isMatch == true)
            {
                // Create and instantiate new advert
                Advert result = new Advert();
                // Fill with data we've collected
                result.setDate(date);
                result.setType(type);
                result.setPosition(pos);
                result.setHeight(height);
                result.setWidth(width);
                result.setArtwork(artwork);
                result.setReferenceNo(refNo);
                result.setClientName(clientName);
                // Calculate price to find missing information
                result.calcPrice();
                
                // Display summary of advert
                displaySummary(result);
            }
            
            // Match reset to false, moved to next line
            isMatch = false;
            file.nextLine();
        }
        System.out.println();
    }
    
}

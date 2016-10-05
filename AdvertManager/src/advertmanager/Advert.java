
package advertmanager;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Advert {

    private int height;
    private int width;
    private int position;
    private int type;
    private String clientName;
    private String referenceNo;
    private boolean isArtwork;
    private boolean isAccount;
    private String date;
    private int price;
    private int charge;
    private int discountPrice;
    
    Advert()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        date = sdf.format(cal.getTime());
    }
    
    public boolean setHeight(String s)
    {
        try
        {
            // If string s cannot be assigned to int i, go to NumberFormatException
            int i = Integer.parseInt(s);
            // If height is between 10 and 70
            if((i >= 10) && (i <= 70))
            {
                // If when height is divided by 5, remainder is 0 (multiple of 5)
                if(i%5 == 0)
                {
                    // Assign height, return true to show task has been completed
                    height = i;
                    return true;
                }
                else
                {
                    // Input is not valid, get user to re-enter
                    return false;
                }
            }
            // If input is 0, is wrapper so valid
            if(i == 0)
            {
                // Assign height, return true to show task has been completed
                height = i;
                return true;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setWidth(String s)
    {
        try
        {
            // If string s cannot be assigned to int i, go to NumberFormatException
            int i = Integer.parseInt(s);
            // If width is between 1 and 4
            if((i >= 0) && (i <= 5))
            {
                // Assign width, return true to show task has been completed
                width = i;
                return true;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setPosition(String s)
    {
        try
        {
            // If string s cannot be assigned to int i, go to NumberFormatException
            int i = Integer.parseInt(s);
            // If position is between 1 and 4
            if((i >= 1) && (i <= 4))
            {
                // Assign position, return true to show task has been completed
                position = i;
                return true;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setType(String s)
    {
        try
        {
            // If string s cannot be assigned to int i, go to NumberFormatException
            int i = Integer.parseInt(s);
            // If type between 1 and 3
            if((i >= 1) && (i <= 3))
            {
                // Assign type, return true to show task has been completed
                type = i;
                return true;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setClientName(String i)
    {
        // If length of name is 30 or below, or not blank, then set client name
        if((i.length() != 0) && (i.length() <= 30))
        {
            // Assign client name, return true to show task has been completed
            clientName = i;
            return true;
        }
        else
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setReferenceNo(String i)
    {
        // If length of reference number equals 6
        if(i.length() == 6)
        {
            // If second, third, fourth characters are digits
            if((Character.isDigit(i.charAt(1))) && (Character.isDigit(i.charAt(2))) && (Character.isDigit(i.charAt(3))))
            {
                // If fifth and sixth characters are letters
                if((Character.isLetter((i.charAt(0))) && (Character.isLetter(i.charAt(4))) && (Character.isLetter(i.charAt(5)))))
                {
                    // If first character is A or a
                    if((i.charAt(0) == 'A') || (i.charAt(0) == 'a'))
                    {
                        // // Assign reference no, is account so isAccount assigned true, return true to show task has been completed
                        isAccount = true;
                        referenceNo = i;
                        return true;
                    }
                    // If first character is C or c
                    else if((i.charAt(0) == 'C') || (i.charAt(0) == 'c'))
                    {
                        // Assign reference no, isn't account so isAccount assigned false, return true to show task has been completed
                        isAccount = false;
                        referenceNo = i;
                        return true;
                    }
                    else
                    {
                        // Input is not valid, get user to re-enter
                        return false;
                    }
                }
                else
                {
                    // Input is not valid, get user to re-enter
                    return false;
                }
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        else
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setArtwork(String s)
    {
        try
        {
            // If string s cannot be assigned to int i, go to NumberFormatException
            int i = Integer.parseInt(s);
            // If user enters 1, artwork is required
            if(i == 1)
            {
                // Assign isArtwork, return true to show task has been completed
                isArtwork = true;
                return true;
            }
            if(i == 0)
            {
                // Assign isArtwork, return true to show task has been completed
                isArtwork = false;
                return true;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            // Input is not valid, get user to re-enter
            return false;
        }
    }
    
    public boolean setDate(String s)
    {
        // If not blank and length is 11, then set
        if((!"".equals(s)) && (s.length() == 11))
        {
            date = s;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean setPrice(String s)
    {
        // Take string as int, if can't go to NumberFormatException
        try
        {
            price = Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    public int getHeight()
    {
        // Returns the height value
        return height;
    }
    
    public int getWidth()
    {
        // Returns the width value
        return width;
    }
    
    public int getPosition()
    {
        // Returns the position value
        return position;
    }
    
    public int getType()
    {
        // Returns the type value
        return type;
    }
    
    public String getClientName()
    {
        // Returns the client name
        return clientName;
    }
    
    public String getReferenceNo()
    {
        // Returns the reference number
        return referenceNo;
    }
    
    public int getArtwork()
    {
        if(isArtwork == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public String getDate()
    {
        // Returns date
        return date;
    }
    
    public int getPrice()
    {
        // Returns undiscounted price
        return price;
    }
    
    public int getCharge()
    {
        //Returns charge
        return charge;
    }
    
    public int getIsAccount()
    {
        if(isAccount==true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public int getDiscountPrice()
    {
        // Returns discounted price
        return discountPrice;
    }
    
    public boolean calcPrice()
    {
        // Sets price as height times width
        price = height * width;
        // If the type is black&white then
        if(type == 1)
        {
            // If the position is in run of paper
            if(position == 1)
            {
                price = price * 88;
            }
            // If position is on front cover
            else if(position == 2)
            {
                price = price * 132;
            }
            // If position is on back cover
            else if(position == 3)
            {
                price = price * 198;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        // If the type is colour
        else if(type == 2)
        {
            // If the position is in run of paper
            if(position == 1)
            {
                price = price * 123;
            }
            // If position is on front cover
            else if(position == 2)
            {
                price = price * 184;
            }
            // If position is on back cover
            else if(position == 3)
            {
                price = price * 277;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }
        // If position is a wrapper
        else if(type == 3)
        {
            // If position is a wrapper
            if(position == 4)
            {
                price = 241500;
            }
            else
            {
                // Input is not valid, get user to re-enter
                return false;
            }
        }

        // If advert needs artwork
        if(isArtwork == true)
        {
            // New integer is set to 15% of current price
            // Do decimal division then convert back to int
            charge = (int)((15.0f / 100.0f) * price);
            // If current charge is more than 3000 pence (#30)
            if(charge > 3000)
            {
                // Set charge down to 3000p
                charge = 3000;
            }
            // Add charge to price
            price = price + charge;
        }

        // If transaction is account, apply discount
        if(isAccount == true)
        {
            // Do decimal division then convert back to int
            discountPrice = (int)((90.0f / 100.0f) * price);
        }

        return true;
    }              
    
    
}

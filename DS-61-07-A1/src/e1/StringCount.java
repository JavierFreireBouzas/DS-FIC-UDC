package e1;

public class StringCount {
     /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords ( String text ) {

        String [] words;

        if (text == null)
            return 0;
        else {
            text = text.trim(); //delete the initial and final spaces
            words = text.split("\\s+"); //makes an array of the words
            return words.length;
        }
    }
    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar ( String text , char c) {

        int i, count = 0;

        if (text == null)
            return 0;
        else {
            for(i = 0; i < text.length(); i++){
                if(text.charAt(i) == c)
                    count++;
            }
        }
        return count;
    }
    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase ( String text , char c ) {

        int i, count = 0;
        String lowerCase;
        c = Character.toLowerCase(c);

        if (text == null)
            return 0;
        else {
            lowerCase = text.toLowerCase();
            for(i = 0; i < text.length(); i++){
                if(lowerCase.charAt(i) == c)
                    count++;
            }
        }
        return count;
    }
    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean isPasswordSafe ( String password ) {
        char[] passwordArray;
        int i;
        boolean boolUpper=false, boolLower=false, boolDigit=false, boolSpecial=false;

        if(password.length() < 8)
            return false;
        else {
            passwordArray = password.toCharArray(); //convert string into array of chars
            for (i = 0; i < passwordArray.length; i++){
                if (Character.isUpperCase(passwordArray[i]))
                    boolUpper = true;
                if (Character.isLowerCase(passwordArray[i]))
                    boolLower = true;
                if (Character.isDigit(passwordArray[i]))
                    boolDigit = true;
                if ((passwordArray[i] == '?') || (passwordArray[i] == '@') ||
                   (passwordArray[i] == '#') || (passwordArray[i] == '$') ||
                        (passwordArray[i] == '.') || (passwordArray[i] == ','))
                    boolSpecial = true;
            }
        }
        return (boolUpper && boolLower && boolDigit && boolSpecial);
    }
}

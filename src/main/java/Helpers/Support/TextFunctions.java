package Helpers.Support;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TextFunctions
{
    public boolean ContainsIgnoreCase( String haystack, String needle )
    {
        if(needle.equals(""))
            return true;
        if(haystack == null || needle == null || haystack .equals(""))
            return false;

        Pattern p = Pattern.compile(needle,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
        Matcher m = p.matcher(haystack);
        return m.find();
    }

    public String FindSubStringByBoundsValues(String orig, String leftBound, String rightBound)
    {
        int leftIndex = 0;
        if (leftBound.length()!=0)
        {
            if (!ContainsIgnoreCase(orig,leftBound))
            {
                return "";
            }

            leftIndex = orig.indexOf(leftBound)+leftBound.length();
        }
        if (!ContainsIgnoreCase(orig,leftBound))
        {
            return "";
        }
        int rightIndex;
        if (rightBound.length()==0)
        {
            rightIndex = orig.length();
        }
        else
        {
            if (!ContainsIgnoreCase(orig,rightBound))
            {
                return "";
            }
            rightIndex = orig.indexOf(rightBound);
        }

        return orig.substring(leftIndex,rightIndex);

    }
}

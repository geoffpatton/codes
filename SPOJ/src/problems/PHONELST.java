package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PHONELST
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++)
        {
            int phoneCount = Integer.parseInt(reader.readLine());
            boolean consistent = true;
            String[] phoneNumbers = new String[phoneCount];
            for (int j = 0; j < phoneCount; j++)
            {
                phoneNumbers[j] = reader.readLine().trim();
            }
            Arrays.sort(phoneNumbers);
            for (int j = 0; j < phoneCount - 1; j++)
            {
                if (phoneNumbers[j + 1].startsWith(phoneNumbers[j]))
                {
                    consistent = false;
                    break;
                }
            }
            String result = consistent ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
import java.util.Random;

class arrayOperations
{
    private final int[] ListA, ListB;
    private int[] commonElms, TheList;
    private int nElmsA, nElmsB, nElmsC;
    int SIZE, n, sum, count, max, min;

    Random rn = new Random();

    // Constructor.
    public arrayOperations()
    {
        SIZE = 50;
        ListA = new int[SIZE];
        ListB = new int[SIZE];
    }

    // Insert all the elements to each array.
    public void populateArrays()
    {
        // Populate ListA.
        nElmsA = rn.nextInt(49 - 1) + 1;
        int num;
        // Populates array with random number of elements based on nElms.
        for (int i = 0; i < nElmsA; i++)
        {
            num = rn.nextInt(101);
            // Checks if current number is already in array.
            for (int x = i; x >= 0; x--)
            {
                if (num == ListA[x])
                {
                    // Get new random number to avoid duplicate values.
                    num = rn.nextInt(101);
                    // Restart the search to look at all elements again.
                    x = i;
                }
            }
            ListA[i] = num;
        }
        // Populate ListB.
        nElmsB = rn.nextInt(49 - 1) + 1;
        for (int i = 0; i < nElmsB; i++)
        {
            num = rn.nextInt(101);
            for (int x = i; x >= 0; x--)
            {
                if (num == ListB[x])
                {
                    num = rn.nextInt(101);
                    x = i;
                }
            }
            ListB[i] = num;
        }
    }

    public void printArrays()
    {
        System.out.print("ListA: ");
        for (int i = 0; i < nElmsA; i++)
            System.out.print(ListA[i] + " ");

        System.out.print("\nListB: ");
        for (int x = 0; x < nElmsB; x++)
            System.out.print(ListB[x] + " ");
    }

    public void findCommonElms()
    {
        n = 0;
        // Array to store common elements.
        commonElms = new int[SIZE];
        // Loop through ListA.
        for (int i = 0; i < nElmsA; i++)
        {
            // Loop through ListB.
            for (int x = 0; x < nElmsB; x++)
            {
                // Check if current elements are the same.
                if (ListA[i] == ListB[x])
                {
                    // Store element in common elements array.
                    commonElms[n] = ListA[i];

                    // deleteElms method call to delete common element.
                    int a = i;
                    while (a < nElmsA) {
                        ListA[a] = ListA[a +1];
                        a++;
                    }
                    // Decrement size of the number of elements.
                    nElmsA--;

                    int b = x;
                    while (b < nElmsB) {
                        ListB[b] = ListB[b + 1];
                        b++;
                    }
                    nElmsB--;

                    // Increment the index used for commonElms array.
                    n++;
                    // Decrement i to begin at current index again for new value after deletion.
                    i--;

                    break;
                }
            }
        }

        // Sort the array.
        max = commonElms[0];
        min = commonElms[0];
        // Find minimum and maximum values.
        for (int i = 1; i < commonElms.length; i++)
        {
            if (commonElms[i] > max)
                max = commonElms[i];
            if (commonElms[i] < min)
                min = commonElms[i];
        }
        int range = max - min + 1;
        int[] countList = new int[range];
        int[] outputList = new int[n];
        // Initialize the count of each element in new array.
        for (int i = 0; i < n; i++)
            countList[commonElms[i] - min]++;

        // Sum of the indexes.
        for (int i = 1; i < countList.length; i++)
            countList[i] += countList[i - 1];

        // Find the index of each element of the original array in count array, and
        // place the elements in output array.
        for (int i = n - 1; i >= 0; i--)
        {
            outputList[countList[commonElms[i] - min] - 1] = commonElms[i];
            countList[commonElms[i] - min]--;
        }

        // Populate TheList with sorted values.
        int i = 0;
        while (i < n) {
            commonElms[i] = outputList[i];
            i++;
        }
    }

    public void printCommon()
    {
        System.out.print("\nCommon: ");
        for (int i = 0; i < n; i++)
            System.out.print(commonElms[i] + " ");
    }

    public void mergeArrays()
    {
        // Number of elements for TheList.
        nElmsC = nElmsA + nElmsB;
        TheList = new int[nElmsC];

        // Add elements from ListA.
        int a = 0;
        while (a < nElmsA) {
            TheList[a] = ListA[a];
            a++;
        }

        // Add elements from ListB.
        int x = 0;
        while (x < nElmsB) {
            TheList[nElmsA + x] = ListB[x];
            x++;
        }

        // Counting sort.
        // Find minimum & maximum elements.
        max = TheList[0];
        min = TheList[0];
        for (int i = 1; i < nElmsC; i++)
        {
            if (TheList[i] > max)
                max = TheList[i];
            if (TheList[i] < min)
                min = TheList[i];
        }
        int range = max - min + 1;
        int[] countList = new int[range];
        int[] outputList = new int[nElmsC];
        // Initialize the count of each element in new array.
        for (int i = 0; i < nElmsC; i++)
            countList[TheList[i] - min]++;

        // Sum of the indexes.
        for (int i = 1; i < countList.length; i++)
            countList[i] += countList[i - 1];

        // Find the index of each element of the original array in count array, and
        // place the elements in output array.
        for (int i = nElmsC - 1; i >= 0; i--)
        {
            outputList[countList[TheList[i] - min] - 1] = TheList[i];
            countList[TheList[i] - min]--;
        }

        // Populate TheList with sorted values.
        int i = 0;
        while (i < nElmsC) {
            TheList[i] = outputList[i];
            i++;
        }
    }

    public void printTheList()
    {
        System.out.print("\nMerged List: ");
        for (int i = 0; i < nElmsC; i++)
            System.out.print(TheList[i] + " ");
    }

    public void intArrayGame()
    {
        sum = 0;
        count = 0;
        // Check which array is smaller.
        if (nElmsB < nElmsA)
        {
            // Loop through ListB
            for (int x = 0; x < nElmsB; x++)
            {
                // Check if value is within bounds of ListA.
                if (ListB[x] <= nElmsA)
                    sum += ListA[ListB[x]];
                // Element was out of bound, so skip.
                else
                    count++;
            }
        }
        // Same process in reverse for ListA being smaller or equal.
        else
        {
            for (int i = 0; i < nElmsA; i++)
            {
                if (ListA[i] <= nElmsB)
                    sum += ListB[ListA[i]];
                else
                    count++;
            }
        }
    }

    public void printIntArrayGame()
    {
        // Print ListA.
        System.out.print("ListA: ");
        for (int i = 0; i < nElmsA; i++)
            System.out.print(ListA[i] + " ");

        // Print ListB.
        System.out.print("\nListB: ");
        for (int x = 0; x < nElmsB; x++)
            System.out.print(ListB[x] + " ");

        // Print sum.
        System.out.println("\nTarget sum: " + sum);

        // Print skipped elements count.
        System.out.println("Count of skipped elements: " + count);
    }
}

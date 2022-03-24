public class arrayOperationsMain
{

    public static void main(String[] args)
    {
        arrayOperations arr;
        arr = new arrayOperations();
        System.out.println("Part 1:");

        arr.populateArrays();
        arr.printArrays();

        arr.findCommonElms();
        arr.printCommon();
        arr.mergeArrays();
        arr.printTheList();

        System.out.println("\nPart 2:");

        arr.intArrayGame();
        arr.printIntArrayGame();
    }
}

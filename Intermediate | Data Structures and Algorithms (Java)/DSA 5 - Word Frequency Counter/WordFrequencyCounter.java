
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class WSObj {

    private int count = 0;
    private String data;

    WSObj(int c, String d) {
        this.count = c;
        this.data = d;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}

public class WordCounter {

    static WSObj[] hashTable;

    static void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        WSObj pivot = hashTable[lowerIndex + (higherIndex - lowerIndex) / 2];
        while (i <= j) {
            while (hashTable[i].getCount() > pivot.getCount()) {
                i++;
            }
            while (hashTable[j].getCount() < pivot.getCount()) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    static void swap(int i, int j) {
        WSObj temp = new WSObj(hashTable[i].getCount(), hashTable[i].getData());
        hashTable[i] = hashTable[j];
        hashTable[j] = temp;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/williamscott/Desktop/file.txt");
        Scanner fileIn = new Scanner(file);
        Scanner userIn = new Scanner(System.in);
        fileIn.useDelimiter("\\Z");
        String input = "";
        while (fileIn.hasNext()) {
            input += fileIn.next();
        }
        fileIn.close();

        input = input.replaceAll("\\r|\\n|\\)|\\(|\"|\\,|\\.|-", "");
        String inputWords[] = input.split(" ");

        int wordCount = inputWords.length;

        hashTable = new WSObj[wordCount];

        for (String string : inputWords) {

            int hash = (string.length() * (string.toLowerCase().charAt(0) * 5171)) % wordCount;

            if (hashTable[hash] == null) {
                hashTable[hash] = new WSObj(1, string);
            } else if (hashTable[hash] != null) {
                int pointer = hash;
                for (int i = 0; i < wordCount; i++) {
                    int p = (pointer + i) % wordCount;
                    if (hashTable[p] != null) {
                        if (hashTable[p].getData().equalsIgnoreCase(string)) {
                            hashTable[p].setCount(hashTable[p].getCount() + 1);
                            break;
                        }
                    } else if (hashTable[p] == null) {
                        hashTable[p] = new WSObj(1, string);
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < wordCount; i++) {
            if (hashTable[i] == null) {
                hashTable[i] = new WSObj(0, "");
            }
        }

        quickSort(0, wordCount - 1);

        for (WSObj wSObj : hashTable) {
            if (wSObj.getCount() > 0) {
                System.out.println("- " + wSObj.getCount() + " " + wSObj.getData());
            }
        }

        System.out.println("Threshold: ");
        int t = userIn.nextInt();
        for (WSObj wSObj : hashTable) 
            if (wSObj.getCount() > 0 && wSObj.getCount() >= t) 
                System.out.println("- " + wSObj.getCount() + " " + wSObj.getData());
    }
}

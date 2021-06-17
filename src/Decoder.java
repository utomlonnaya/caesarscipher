import java.util.Arrays;
import java.util.Locale;

public class Decoder {
    public void caesarCipherDecoder(String source) {
        String russianCharsUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String russianCharsLowerCase = russianCharsUpperCase.toLowerCase();

        for (int shift = 0; shift < 32; shift++) {
            StringBuilder string = new StringBuilder();
            for (int index = 0; index < source.length(); index++) {
                int upperIndex = russianCharsUpperCase.indexOf(source.charAt(index));
                int lowerIndex = russianCharsLowerCase.indexOf(source.charAt(index));
                boolean isUpperCase = upperIndex >= 0;
                boolean isLowerCase = lowerIndex >= 0;

                if (isUpperCase) {
                    int indexOfSymbolToAdd = shift + upperIndex;
                    if (indexOfSymbolToAdd > 32) {
                        indexOfSymbolToAdd = changeIndex(indexOfSymbolToAdd);
                    }
                    char symbolToAdd = russianCharsUpperCase.charAt(indexOfSymbolToAdd);
                    string.append(symbolToAdd);
                } else if (isLowerCase) {
                    int indexOfSymbolToAdd = shift + lowerIndex;
                    if (indexOfSymbolToAdd > 32) {
                        indexOfSymbolToAdd = changeIndex(indexOfSymbolToAdd);
                    }
                    char symbolToAdd = russianCharsLowerCase.charAt(indexOfSymbolToAdd);
                    string.append(symbolToAdd);
                } else {
                    string.append(source.charAt(index));
                }
            }
            System.out.println(string);
        }
    }

    public int changeIndex(int indexOfSymbolToAdd) {
        return indexOfSymbolToAdd % 33;
    }
}
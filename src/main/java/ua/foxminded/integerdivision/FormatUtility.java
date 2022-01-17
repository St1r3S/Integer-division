package ua.foxminded.integerdivision;

public final class FormatUtility {
    private FormatUtility() {
    }

    public static String repeatCharacter(int quantity, char character) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}

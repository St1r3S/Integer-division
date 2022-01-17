package ua.foxminded.integerdivision;

import static ua.foxminded.integerdivision.FormatUtility.repeatCharacter;

public class EurasiaFormatter implements Formatter {
    @Override
    public String format(Result result) {

        StringBuilder resultString = new StringBuilder();
        int spacesQuantity = 1;
        if (Integer.signum(result.getDividend()) < 0) {
            spacesQuantity++;
        }
        if (!result.getMinuendList().isEmpty() && !result.getSubtrahendList().isEmpty()) {
            resultString.append("_").append(result.getDividend()).append(repeatCharacter(spacesQuantity - 1, ' ')).append("|").append(result.getDivisor()).append("\n");
            resultString.append(repeatCharacter(spacesQuantity, ' '));
            resultString.append(repeatCharacter(String.valueOf(result.getMinuendList().getFirst()).length() - String.valueOf(result.getSubtrahendList().getFirst()).length(), ' '));
            resultString.append(result.getSubtrahendList().getFirst());
            int stringDelta = String.valueOf(result.getDividend()).length() - String.valueOf(result.getSubtrahendList().getFirst()).length();
            resultString.append(repeatCharacter(stringDelta, ' ')).append("|");
            resultString.append(repeatCharacter(String.valueOf(result.getQuotient()).length(), '-')).append("\n");
            resultString.append(repeatCharacter(spacesQuantity, ' ')).append(repeatCharacter(String.valueOf(result.getMinuendList().getFirst()).length(), '-'));
            resultString.append(repeatCharacter(stringDelta, ' ')).append("|").append(result.getQuotient()).append("\n");
            int i;
            for (i = 1; i < result.getMinuendList().size(); i++) {
                resultString.append(repeatCharacter(i + spacesQuantity - 1, ' ')).append("_").append(result.getMinuendList().get(i)).append("\n");
                resultString.append(repeatCharacter(i + spacesQuantity, ' ')).append(result.getSubtrahendList().get(i)).append("\n");
                resultString.append(repeatCharacter(spacesQuantity, ' ')).append(FormatUtility.repeatCharacter(i, ' '));
                resultString.append(repeatCharacter(String.valueOf(result.getMinuendList().get(i)).length(), '-')).append("\n");
            }
            resultString.append(repeatCharacter(i + spacesQuantity, ' ')).append(" ").append(result.getReminder());
        } else {
            resultString.append("There is integer divider!\n");
            resultString.append("Your answer is ").append(result.getQuotient()).append(" with ").append(result.getReminder()).append(" in the reminder.");
        }
        return resultString.toString();
    }

}

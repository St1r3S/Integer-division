package ua.foxminded.integerdivision;

import static ua.foxminded.integerdivision.FormatUtility.repeatCharacter;

public class NetherlandsFormatter implements Formatter {
    @Override
    public String format(Result result) {

        StringBuilder resultString = new StringBuilder();
        int divisorLengthPlusThree = String.valueOf(result.getDivisor()).length() + 3;
        int spacesQuantity = 0;
        if (Integer.signum(result.getDividend()) < 0) {
            spacesQuantity++;
            divisorLengthPlusThree += spacesQuantity;
        }
        if (!result.getMinuendList().isEmpty() && !result.getSubtrahendList().isEmpty()) {
            resultString.append(result.getDivisor()).append(" / ").append(result.getDividend()).append(" \\ ").append(result.getQuotient()).append("\n");
            resultString.append(repeatCharacter(String.valueOf(result.getDivisor()).length() + 3 + spacesQuantity, ' ')).append(result.getSubtrahendList().getFirst()).append("\n");
            resultString.append(repeatCharacter(divisorLengthPlusThree, ' '));
            resultString.append(repeatCharacter(String.valueOf(result.getMinuendList().getFirst()).length(), '-')).append("\n");
            int i;
            for (i = 1; i < result.getMinuendList().size(); i++) {
                resultString.append(repeatCharacter(i + divisorLengthPlusThree, ' ')).append(result.getMinuendList().get(i)).append("\n");
                resultString.append(repeatCharacter(i + divisorLengthPlusThree, ' ')).append(result.getSubtrahendList().get(i)).append("\n");
                resultString.append(repeatCharacter(i + divisorLengthPlusThree, ' '));
                resultString.append(repeatCharacter(String.valueOf(result.getMinuendList().get(i)).length(), '-')).append("\n");
            }
            if (result.getDividend() - result.getDivisor() * result.getQuotient() == result.getReminder() && result.getMinuendList().getLast() - result.getSubtrahendList().getLast() == 0) {
                resultString.append(repeatCharacter(1 + spacesQuantity, ' '));
                if (Integer.signum(result.getDivisor()) < 0) {
                    spacesQuantity++;
                }
            }
            if (result.getMinuendList().isEmpty() && result.getSubtrahendList().isEmpty()) {
                spacesQuantity--;
            }
            resultString.append(repeatCharacter(i + divisorLengthPlusThree + spacesQuantity, ' ')).append(result.getReminder());
        } else {
            resultString.append("There is integer divider!\n");
            resultString.append("Your answer is ").append(result.getQuotient()).append(" with ").append(result.getReminder()).append(" in the reminder.");
        }
        return resultString.toString();
    }
}

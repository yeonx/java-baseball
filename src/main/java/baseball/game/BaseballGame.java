package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.RESTART;
import static baseball.constant.GameMessage.END_MESSAGE;
import static baseball.constant.GameMessage.RESTART_MESSAGE;
import static baseball.number.ComputerNumber.createComputerNumber;
import static baseball.validator.RestartNumberValidator.checkValidationRestartNumber;
import static baseball.number.UserNumber.checkInputUserNumber;

public class BaseballGame {

    public static List<Integer> computerNumbers;
    public static List<Integer> userNumbers;
    private static CompareNumbers compareNumbers = new CompareNumbers();

    public static void playBaseballGame(){
        computerNumbers = createComputerNumber();
        compareNumbers.resetStrikeBall();
        while (compareNumbers.strike!=BALL_LEN) {
            userNumbers = checkInputUserNumber();
            compareNumbers.resetStrikeBall();
            compareNumbers.compareNumber();
            compareNumbers.userNumberResult();
        }
        System.out.println(END_MESSAGE);
        askRestartGame();
    }

    public static void askRestartGame(){
        System.out.println(RESTART_MESSAGE);
        String restartNumber = Console.readLine();
        checkValidationRestartNumber(restartNumber);
        restartGame(restartNumber);
    }

    public static void restartGame(String restartNumber){
        if (restartNumber.equals(RESTART)) playBaseballGame();
    }

}

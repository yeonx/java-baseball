package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.GameMessage.*;
import static baseball.game.ComputerNumber.createComputerNumber;
import static baseball.exception.RestartNumberValidator.checkValidationRestartNumber;
import static baseball.game.UserNumber.checkInputUserNumber;

public class BaseballGame {

    private static List<Integer> computerNumbers;
    private static List<Integer> userNumbers;

    private static int strike;
    private static int ball;

    public static void resetStrikeBall(){
        strike=0;
        ball=0;
    }

    public static void playBaseballGame(){
        computerNumbers = createComputerNumber();
        resetStrikeBall();
        while (strike!=3) {
            userNumbers = checkInputUserNumber();
            resetStrikeBall();
            compareNumber();
            userNumberResult();
        }
        System.out.println(END_MESSAGE);
        restartGame();
    }

    public static void compareNumber(){
        for(int i=0;i<3;i++){
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);
            if (!computerNumbers.contains(userNumber)) continue;
            if (userNumber == computerNumber) strike++;
            else if (userNumber != computerNumber) ball++;
        }
    }

    public static void userNumberResult(){
        if(ball==0 && strike==0) System.out.print(NOTHING);
        if(ball>0) System.out.print(ball + BALL);
        if(strike>0) System.out.print(strike + STRIKE);
        System.out.println();

    }

    public static void restartGame(){
        System.out.println(RESTART_MESSAGE);
        String restartNumber = Console.readLine();
        checkValidationRestartNumber(restartNumber);
        if (restartNumber.equals("1")) {
            playBaseballGame();
        }
    }

}

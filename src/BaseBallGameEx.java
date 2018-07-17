import java.util.Scanner;

public class BaseBallGameEx implements BaseBallGame {

    public static final int MENU_START = 1;
    public static final int MENU_EXIT = 2;
    public static final int MENU_ERROR = -1;

    public static final int MAX_TRY_COUNT = 9;
    public static final int HIT_LENGTH = 3;

    @Override
    public void play() {
        while (true) {
            printMenu();
            int selectedMenu = selectMenu();
            if (selectedMenu == MENU_START) {
                playGame();
            } else if (selectedMenu == MENU_EXIT) {
                exitGame();
            } else {
                printInputError();
            }
        }
    }

    private void printMenu() {
        System.out.println("================================================");
        System.out.println("           1. 게임 시작 2. 게임 종료");
        System.out.println("================================================");
    }

    private int selectMenu() {
        try {
            int input = new Scanner(System.in).nextInt();
            if (input == MENU_START || input == MENU_EXIT) {
                return input;
            } else {
                return MENU_ERROR;
            }
        } catch (Exception e) {
            return MENU_ERROR;
        }
    }

    private void playGame() {
        int[] randomNumbers = createRandomNumbers();
        int tryCount = 0;
        while (tryCount < MAX_TRY_COUNT) {
            int[] inputNumbers = inputNumbersFromUser();
            GameResult result = getResult(randomNumbers, inputNumbers);
            printResult(result);
            if (result.strike == HIT_LENGTH) {
                win();
                return;
            }
            tryCount++;
        }
        lose();
    }

    private void printResult(GameResult result) {
        System.out.println(result.strike + "S " + result.ball + "B " + result.out + "O");
    }

    private GameResult getResult(int[] randomNumbers, int[] inputNumbers) {
        // TODO
        GameResult result = new GameResult();
        result.strike = 3;
        return result;
    }

    private int[] inputNumbersFromUser() {
        // TODO
        return new int[]{3, 1, 5};
    }

    private int[] createRandomNumbers() {
        // TODO
        return new int[]{1, 3, 5};
    }

    private void win() {
        System.out.println("이겼다");
    }

    private void lose() {
        System.out.println("졌다");
    }

    private void exitGame() {
        System.exit(0);
    }

    private void printInputError() {
        System.out.println("잘못된 값을 입력 하였습니다..");
    }
}

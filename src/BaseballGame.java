import java.util.*;

public class BaseballGame {

    

    int[] randomnum = new int[3];
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();
    }


    public void run() {

        System.out.println("================================================\r" +
                "           1. 게임 시작 2. 게임 종료\r" +
                "================================================");
        startcheck();

    }

    public void startcheck() {
        int startendnum = scan.nextInt();
        if (startendnum == 1) {
            start();
        } else if (startendnum == 2) {
            System.exit(0);
        } else {
            System.out.println("잘못된 값을 입력 하였습니다.. 1 또는 2를 입력하세요");
            startcheck();
        }
    }

    public void start() {
        Random randomGenerator = new Random();
        int trynum = 0;

        for (int i = 0; i < 3; i++) {
            randomnum[i] = randomGenerator.nextInt(10);
            for (int j = 0; j < 3; j++) {
                if (randomnum[i] == randomnum[j]) {
                    i--;
                }
            }
        }
        check();
    }

    public void check() {


        int strike = 0;
        int ball = 0;
        int out = 3;
        int taja[] = new int[3];
        System.out.println("3개의 값을 입력하세요");

        for (int i = 0; i < 3; i++) {
            taja[i] = scan.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (randomnum[i] == taja[j]) {
                        strike++;
                    }
                }
                if (i != j) {
                    if (randomnum[i] == taja[j]) {
                        ball++;
                    }
                }

            }
            out = out - strike - ball;
            System.out.println(strike + "스트라이크" + ball + "볼" + out + "아웃");

        }


    }

}

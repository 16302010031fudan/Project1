import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Project {
    private static boolean checkMap(String s1) {
        int k = 0;
        boolean result ;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= 9; j++) {
                if (s1.charAt(i * 10 + j) == '0')
                    k++;
            }
        } if(k == 70)
               result = true;
        else
            result = false;
        return result;
    }
    //将字符串转化为数组
    private static char[][] changeToArray(String string) {
        char[][] anotherArray = new char[7][10];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= 9; j++) {
                anotherArray[i][j] = string.charAt(i * 10 + j);
            }
        }
        return anotherArray;
    }
    //将数组转化为字符串
    private static String changeToString(char[][]array){
        String string = "";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= 9; j++) {
                string += array[i][j];
            }
        }
        return string;
    }
    //判断可否撤销悔棋及撤销悔棋中current的变化
    private static int redo(int currentStep, int lastStep, int nextStep) {
        if (nextStep <= lastStep) {
            currentStep = nextStep;
        } else {
            System.out.println("Invalid redo.");
        }
        return currentStep;
    }
    //判断可否悔棋及悔棋中current的变化
    private static int undo(int currentStep, int nextStep) {
        if (nextStep >= 0) {
            currentStep = nextStep;
        } else {
            System.out.println("Invalid undo.");
        }
        return currentStep;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //  输出地形地图
        File mapOne = new File("data.txt");
        Scanner scannerone = new Scanner(mapOne);
        String map = "";
        for (int i = 0; i < 7; i++) {
            map += scannerone.nextLine();
            map += '\n';
        }
        File mapTwo = new File("animalRight.txt");
        Scanner scannedtwo = new Scanner(mapTwo);
        String animalRight = "";
        for (int i = 0; i < 7; i++) {
            animalRight += scannedtwo.nextLine();
            animalRight += '\n';

        }

        File mapthree = new File("animalLeft.txt");
        Scanner scannedthree = new Scanner(mapthree);
        String animalLeft = "";
        for (int i = 0; i < 7; i++) {
            animalLeft += scannedthree.nextLine();
            animalLeft += '\n';
        }

        int u = 0;
        Boolean player = true;
        Scanner input = new Scanner(System.in);
        String gameTip = "游戏操作如下："  +  "\n" + "输入undo:悔棋一步"  + "\n" +
                "输入redo:撤销悔棋一步" + "\n" + "输入restart:重新开始游戏" + "\n" +
                "输入exit：退出游戏" + "\n" + "输入help:帮助";
        System.out.println(gameTip);
        char[][][] boardHistoryLeft = new char[1000][][];
        char[][][] boardHistoryRight = new char[1000][][];
        int lastStep = 0;
        int currentStep = 0;
        int nextStep ;
         boardHistoryLeft[currentStep] = changeToArray(animalLeft);
        boardHistoryRight[currentStep] = changeToArray(animalRight);


        mainbody:
        while (true) {
            animalLeft = changeToString(boardHistoryLeft[currentStep]);
            animalRight = changeToString(boardHistoryRight[currentStep]);
            if (checkMap(animalLeft)) {
                System.out.println("恭喜右方获胜");
                break mainbody;
            } else if (checkMap(animalRight)) {
                System.out.println("恭喜左方胜出");
                break mainbody;
            }else {
            if (u == 0) {
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j <= 9; j++) {
                        if (j < 9) {
                            int chees = Integer.parseInt(String.valueOf(map.charAt(i * 10 + j)));
                            int ar = Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j)));
                            int al = Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j)));
                            if (al == 0 && ar != 0) {
                                switch (ar) {
                                    case 1:
                                        System.out.print(" 鼠1");
                                        break;
                                    case 2:
                                        System.out.print(" 猫2");
                                        break;
                                    case 3:
                                        System.out.print(" 狼3");
                                        break;
                                    case 4:
                                        System.out.print(" 狗4");
                                        break;
                                    case 5:
                                        System.out.print(" 豹5");
                                        break;
                                    case 6:
                                        System.out.print(" 虎6");
                                        break;
                                    case 7:
                                        System.out.print(" 狮7");
                                        break;
                                    case 8:
                                        System.out.print(" 象8");
                                        break;
                                    default:
                                        System.out.println();
                                        break;
                                }
                            } else if (ar == 0 && al != 0) {
                                switch (al) {
                                    case 1:
                                        System.out.print("1鼠 ");
                                        break;
                                    case 2:
                                        System.out.print("2猫 ");
                                        break;
                                    case 3:
                                        System.out.print("3狼 ");
                                        break;
                                    case 4:
                                        System.out.print("4狗 ");
                                        break;
                                    case 5:
                                        System.out.print("5豹 ");
                                        break;
                                    case 6:
                                        System.out.print("6虎 ");
                                        break;
                                    case 7:
                                        System.out.print("7狮 ");
                                        break;
                                    case 8:
                                        System.out.print("8象 ");
                                        break;
                                    default:
                                        System.out.println();
                                        break;
                                }
                            } else {
                                switch (chees) {
                                    case 0:
                                        System.out.print("    ");
                                        break;
                                    case 1:
                                        System.out.print(" 水 ");
                                        break;
                                    case 2:
                                    case 4:
                                        System.out.print(" 陷 ");
                                        break;
                                    case 3:
                                    case 5:
                                        System.out.print(" 家 ");
                                        break;
                                    default:
                                        System.out.println();
                                        break;
                                }
                            }
                        } else
                            System.out.print("\n");
                    }
                }
                u = 1;
            } else {
                if (player == true) {
                    System.out.print("请左方输入：");
                    String left = input.nextLine();
                    if (left.length() != 2) {
                        if (left.equals("exit")) {
                            break mainbody;
                        } else if (left.equals("restart")) {
                            currentStep = 0;
                            lastStep = 0;
                            player = true;
                            u = 0;
                        } else if (left.equals("redo")) {
                            nextStep = currentStep + 1;
                            if(nextStep > lastStep){
                                System.out.println("Invalid redo.");
                            }else{
                            currentStep = redo(currentStep, lastStep, nextStep);
                                player = !player;
                             u = 0;}
                        } else if (left.equals("undo")) {
                            nextStep = currentStep - 1;
                            if(nextStep < 0){
                                System.out.println("Invalid undo.");
                            }else{
                            currentStep = undo(currentStep, nextStep);
                            player = !player;
                            u = 0;}
                        } else if (left.equals("help")) {
                            String a = "移动指令由两部分组成，" + "\n" +
                                    "第一部分为数字1到8，分别对应鼠(1)，猫（2），狼（3),狗（4），豹（5），虎（6），狮（7），象（8）" + "\n" +
                                    "第二部分是字母adws中的一个，w对应向上，s对应向下，a对应向左，d对应向右" + "\n" +
                                    "如1d代表鼠向右走一步，4w代表狗向上走一步";
                            System.out.println(a);
                            u = 0;
                        } else {
                            System.out.println("非法输入");
                        }
                    } else {
                        String s1 = left.substring(0, 1);
                        String direction = left.substring(1, 2);
                        char k1 = left.charAt(0);
                        char d1 = left.charAt(1);
                        if (k1 > '0' && k1 < '9' && (d1 == 'a' || d1 == 's' || d1 == 'd' || d1 == 'w')) {
                            int number = Integer.parseInt(s1);
                            int count = 0;
                            here:
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 9; j++) {
                                    int al = Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j)));//寻找相应动物
                                    if (al == number) {
                                        switch (direction) {
                                            case "a":
                                                if (j - 1 < 0) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 5) {
                                                    System.out.println("恭喜左方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 2))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 3))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 4))) ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 4))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 3) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + s1 + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + "0" + animalRight.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) != 2) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + s1 + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + "0" + animalRight.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 4))) &&
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 0) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 4) + s1 + animalLeft.substring(i * 10 + j - 3, i * 10 + j )
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 4) + "0000" + animalRight.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 2) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + s1 + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + "0" + animalRight.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1)))) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + s1 + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + "0" + animalRight.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "d":
                                                if (j + 1 > 8) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 5) {
                                                    System.out.println("恭喜左方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 2))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 3))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 4))) ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 4))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + s1 + animalLeft.substring(i * 10 + j + 2, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 1) + "0" + animalRight.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) != 2) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + s1 + animalLeft.substring(i * 10 + j + 2, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 1) + "0" + animalRight.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 4))) &&
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 4))) == 0) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + 1, i * 10 + j + 4)
                                                            + s1 + animalLeft.substring(i * 10 + j + 5, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 1) + "0000" + animalRight.substring(i * 10 + j + 5, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 2) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + s1 + animalLeft.substring(i * 10 + j + 2, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 1) + "0" + animalRight.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1)))) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + s1 + animalLeft.substring(i * 10 + j + 2, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 1) + "0" + animalRight.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "w":
                                                if (i - 1 < 0) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) != 1 ) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 5) {
                                                    System.out.println("恭喜左方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 20))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 30))) ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 30))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 3) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + s1 + animalLeft.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + "0" + animalRight.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) != 2) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + s1 + animalLeft.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + "0" + animalRight.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 30))) &&
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 30))) == 0) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 30) + s1 + animalLeft.substring(i * 10 + j - 29, i * 10 + j)
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 30) + "0" + animalRight.substring(i * 10 + j - 29, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 2) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + s1 + animalLeft.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + "0" + animalRight.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10)))) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + s1 + animalLeft.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalLeft.substring(i * 10 + j + 1, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + "0" + animalRight.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "s":
                                                if (i + 1 > 6) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 5) {
                                                    System.out.println("恭喜左方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 20))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 30))) ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 30))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 3) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalLeft.substring(i * 10 + j + 11, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 10) + "0" + animalRight.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) != 2) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    ;
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalLeft.substring(i * 10 + j + 11, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 10) + "0" + animalRight.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 30))) &&
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 30))) == 0) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + j + 1, i * 10 + j + 30)
                                                            + s1 + animalLeft.substring(i * 10 + j + 31, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 30) + "0" + animalRight.substring(i * 10 + j + 31, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 2) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalLeft.substring(i * 10 + j + 11, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 10) + "0" + animalRight.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10)))) {
                                                    animalLeft = animalLeft.substring(0, i * 10 + j) + "0" + animalLeft.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalLeft.substring(i * 10 + j + 11, 70);
                                                    animalRight = animalRight.substring(0, i * 10 + j + 10) + "0" + animalRight.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                        }
                                        break here;
                                    } else
                                        count++;
                                }
                            }
                            if (count > 69) {
                                System.out.println("该动物已死");
                                continue mainbody;
                            }
                            lastStep = ++currentStep;
                            boardHistoryLeft[currentStep] = changeToArray(animalLeft);
                            boardHistoryRight[currentStep] = changeToArray(animalRight);
                        } else {
                            System.out.println("非法输入");
                        }
                    }
                } else {
                    System.out.print("请右方输入：");
                    String right = input.nextLine();
                    if (right.length() != 2) {
                        if (right.equals("exit")) {
                            break mainbody;
                        } else if (right.equals("restart")) {
                            currentStep = 0;
                            lastStep = 0;
                            player = true;
                            u = 0;
                        } else if (right.equals("redo")) {
                            nextStep = currentStep + 1;
                            if(nextStep > lastStep){
                                System.out.println("Invalid redo.");
                            }else{
                            currentStep = redo(currentStep, lastStep, nextStep);
                            player = !player;
                            u = 0;}
                        } else if (right.equals("undo")) {
                            nextStep = currentStep - 1;
                            if(nextStep < 0){
                                System.out.println("Invalid undo.");
                            }else{
                            currentStep = undo(currentStep, nextStep);
                            player = !player;
                            u = 0;}
                        } else if (right.equals("help")) {
                            String a = "移动指令由两部分组成，" + "\n" +
                                    "第一部分为数字1到8，分别对应鼠(1)，猫（2），狼（3),狗（4），豹（5），虎（6），狮（7），象（8）" +
                                    "第二部分是字母adws中的一个，w对应向上，s对应向下，a对应向左，d对应向右" + "\n" +
                                    "如1d代表鼠向右走一步，4w代表狗向上走一步";
                            System.out.println(a);
                        } else {
                            System.out.println("非法输入");
                        }
                    } else {
                        String s1 = right.substring(0, 1);
                        String direction = right.substring(1, 2);
                        char k1 = right.charAt(0);
                        char d1 = right.charAt(1);
                        if (k1 > '0' && k1 < '9' && (d1 == 'a' || d1 == 's' || d1 == 'd' || d1 == 'w')) {
                            int number = Integer.parseInt(s1);
                            int count1 = 0;
                            here1:
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 9; j++) {
                                    int ar = Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j)));//寻找相应动物
                                    if (ar == number) {
                                        switch (direction) {
                                            case "a":
                                                if (j - 1 < 0) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 3) {
                                                    System.out.println("恭喜右方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 2))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 3))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 4))) ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 4))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + s1 + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + "0" + animalLeft.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) != 4) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + s1 + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + "0" + animalLeft.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 4))) &&
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 4))) == 0) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 4) + s1 + animalRight.substring(i * 10 + j -3, i * 10 + j )
                                                            + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 4) + "0000" + animalLeft.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 1))) == 4) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + s1 + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + "0" + animalLeft.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 1)))) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 1) + s1 + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 1) + "0" + animalLeft.substring(i * 10 + j, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "d":
                                                if (j + 1 > 8) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 3) {
                                                    System.out.println("恭喜右方方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 2))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 3))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 4))) ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 4))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 5) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + s1 + animalRight.substring(i * 10 + j + 2, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 1) + "0" + animalLeft.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) != 4) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + s1 + animalRight.substring(i * 10 + j + 2, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 1) + "0" + animalLeft.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 4))) &&
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 4))) == 0) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 4)
                                                            + s1 + animalRight.substring(i * 10 + j + 5, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 1) + "0000" + animalLeft.substring(i * 10 + j + 5, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 1))) == 4) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + s1 + animalRight.substring(i * 10 + j + 2, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 1) + "0" + animalLeft.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 1)))) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + '0' + s1 + animalRight.substring(i * 10 + j + 2, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 1) + "0" + animalLeft.substring(i * 10 + j + 2, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "w":
                                                if (i - 1 < 0) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) != 1) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 3) {
                                                    System.out.println("恭喜右方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 20))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 30))) ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 30))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 5) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + s1 + animalRight.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + "0" + animalLeft.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) != 4) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + s1 + animalRight.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + "0" + animalLeft.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 30))) &&
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j - 30))) == 0) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 30) + s1 + animalRight.substring(i * 10 + j - 29, i * 10 + j)
                                                            + "0" + animalRight.substring(i * 10 + j, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 30) + "0" + animalLeft.substring(i * 10 + j - 29, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j - 10))) == 4) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + s1 + animalRight.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + "0" + animalLeft.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j - 10)))) {
                                                    animalRight = animalRight.substring(0, i * 10 + j - 10) + s1 + animalRight.substring(i * 10 + j - 9, i * 10 + j)
                                                            + "0" + animalRight.substring(i * 10 + j + 1, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j - 10) + "0" + animalLeft.substring(i * 10 + j - 9, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                            case "s":
                                                if (i + 1 > 6) {
                                                    System.out.println("超出边界");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) != 0 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) != 1 ) {
                                                    System.out.println("与己方动物冲突");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 3) {
                                                    System.out.println("恭喜右方胜出");
                                                    break mainbody;
                                                } else if (number != 1 && number != 6 && number != 7 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1) {
                                                    System.out.println("该动物无法下河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && (Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10))) == 1 ||
                                                        Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 20))) == 1)) {
                                                    System.out.println("有鼠阻挡，无法跳河");
                                                    continue mainbody;
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 30))) ||
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 30))) != 0)) {
                                                    System.out.println("你跳不了河，注意");
                                                    continue mainbody;
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 5) {
                                                    System.out.println("无法进入自己的家");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) == 1) {
                                                    System.out.println("河中鼠不能吃陆上象");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10))) == 8 &&
                                                        Integer.parseInt(String.valueOf(map.charAt(i * 10 + j))) != 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalRight.substring(i * 10 + j + 11, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 10) + "0" + animalLeft.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0; //鼠吃象
                                                } else if (number == 8 && Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10))) == 1) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number < Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10)))
                                                        && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) != 4) {
                                                    System.out.println("你吃不了对方，快跑吧");
                                                    continue mainbody;
                                                } else if (number == 1 && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalRight.substring(i * 10 + j + 11, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 10) + "0" + animalLeft.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0;   //鼠下河
                                                } else if ((number == 6 || number == 7) && Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 1
                                                        && number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 30))) &&
                                                        Integer.parseInt(String.valueOf(animalRight.charAt(i * 10 + j + 30))) == 0) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 30)
                                                            + s1 + animalRight.substring(i * 10 + j + 31, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 30) + "0" + animalLeft.substring(i * 10 + j + 31, 70);
                                                    player = !player;
                                                    u = 0; //狮虎跳河
                                                } else if (Integer.parseInt(String.valueOf(map.charAt(i * 10 + j + 10))) == 4) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalRight.substring(i * 10 + j + 11, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 10) + "0" + animalLeft.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0; //吃陷阱中的动物；
                                                } else if (number >= Integer.parseInt(String.valueOf(animalLeft.charAt(i * 10 + j + 10)))) {
                                                    animalRight = animalRight.substring(0, i * 10 + j) + "0" + animalRight.substring(i * 10 + j + 1, i * 10 + j + 10)
                                                            + s1 + animalRight.substring(i * 10 + j + 11, 70);
                                                    animalLeft = animalLeft.substring(0, i * 10 + j + 10) + "0" + animalLeft.substring(i * 10 + j + 11, 70);
                                                    player = !player;
                                                    u = 0;  //普通的吃敌方动物
                                                }
                                                break;
                                        }
                                        break here1;
                                    } else
                                        count1++;
                                }
                            }
                            if (count1 > 69) {
                                System.out.println("该动物已死");
                                continue mainbody;
                            }
                            lastStep = ++currentStep;
                            boardHistoryLeft[currentStep] = changeToArray(animalLeft);
                            boardHistoryRight[currentStep] = changeToArray(animalRight);
                        } else {
                            System.out.println("非法输入");
                            continue mainbody;
                        }
                    }
                }
            }
             }
            }
            System.out.println("游戏结束");
        }
    }

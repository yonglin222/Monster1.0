package project;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends Monster {
    public GameManager(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public static void main(String[] args) {
        // Monster 객체들을 저장할 ArrayList를 생성
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster("슬라임", 30, 8, 5));
        monsterList.add(new Monster("고블린", 50, 12, 4));
        monsterList.add(new Monster("오크", 80, 15, 7));
        monsterList.add(new Monster("스켈레톤", 60, 14, 10));
        monsterList.add(new Monster("트롤", 120, 18, 6));
        monsterList.add(new Monster("골렘", 100, 20, 25));
        monsterList.add(new Monster("와이번", 150, 25, 15));
        monsterList.add(new Monster("리치", 130, 35, 12));
        monsterList.add(new Monster("키메라", 200, 30, 20));
        monsterList.add(new Monster("드래곤", 300, 40, 30));

        for ()
    }

}
//        Monster monster1 = new Monster("슬라임", 30, 8, 3);
//        Monster monster2 = new Monster("오크", 40, 12, 5);
//
//        while(monster1.getHp() > 0 && monster2.getHp() > 0){
//            int damage = monster1.getAttack() - monster2.getDefense();
//            if(damage <= 0) damage=0;
//
//            int newHp = monster2.getHp() - damage;
//            monster2.setHp(newHp > 0 ? newHp : 0);
//
//            System.out.println(monster1.getName() + "의 기본공격! "+ monster2.getName() + "는 데미지" +damage +"를 입었다 ");
//            System.out.println(monster2.getName() + " 남은체력 : " + monster2.getHp());
//            System.out.println();
//            if (monster2.getHp() < 0) break;
//            try {
//                // 1000 밀리초 = 1초 동안 실행을 멈춥니다.
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // sleep 도중 방해를 받았을 때 처리할 코드를 여기에 작성할 수 있습니다.
//                // 지금은 비워두어도 괜찮습니다.
//                e.printStackTrace();
//            }
//
//            damage = monster2.getAttack() - monster1.getDefense();
//            if(damage <= 0) damage=0;
//
//            newHp = monster1.getHp() - damage;
//            monster1.setHp(newHp > 0 ? newHp : 0);
//
//            System.out.println(monster2.getName() + "의 기본공격! "+ monster1.getName() + "는 데미지" +damage +"를 입었다 ");
//            System.out.println(monster1.getName() + " 남은체력 : " + monster1.getHp());
//            System.out.println();
//            if (monster1.getHp() < 0) break;
//
//            try {
//                // 1000 밀리초 = 1초 동안 실행을 멈춥니다.
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // sleep 도중 방해를 받았을 때 처리할 코드를 여기에 작성할 수 있습니다.
//                // 지금은 비워두어도 괜찮습니다.
//                e.printStackTrace();
//            }
//        }
//    }
//}

package project;

import java.util.ArrayList;
import java.util.Scanner;
class NormalMonster extends Monster {
    public NormalMonster(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }
    @Override
    public int attack(Monster target) {
        // ## 로직 설명
        // 20%의 확률로 치명타가 발동하는지 확인합니다.
        int damage = attack();
        if (Math.random() < 0.2) {
            // 조건식이 true일 때 20% 확률로 실행될 코드
            // 치명타가 터지면, 공격력 * 2를 하여 피해량을 두 배로 만들고
            // 상대의 방어도를 무시합니다. 특별한 메시지를 출력합니다.
            damage = 2 * getAttack();
            if (damage <= 0) damage = 0;
            System.out.println("치명타공격!");
            return damage;
        }else {
            damage = getAttack() - getDefense();
            if (damage <= 0) damage = 0;
            System.out.println("기본공격");
            return damage;

            // 치명타가 터지지 않으면, 기본계산 피해량(공격력 - 상대방어력)만 반환됩니다.
        }
    }
}
class FireMonster extends Monster {
    private int fireSkillDamage;
    public FireMonster(String name, int hp, int attack, int defense, int fireSkillDamage) {
        super(name, hp, attack, defense);
        this.fireSkillDamage = fireSkillDamage;
    }

    @Override
    public int attack(Monster target) {
        // 이제 attack 메서드는 먼저 기본 공격을 항상 수행하고 피해량을 계산합니다.
        // 그 다음 35% 확률로 스킬이 발동됩니다
        if (Math.random() < 0.35) {
            // 스킬이 발동되면 기존에 계산된 damage에 스킬 피해량을 누적하여 더해줍니다.

            // 따라서 스킬은 이제 공격을 대체하는 것이 아닌, 강력한 '추가타' 개념이 됩니다.
            // 최종 계산된 피해량을 반환합니다.
        }
        return 0;

    }
}

public class GameManager {
    public static void main(String[] args) {
        // Monster 객체들을 저장할 ArrayList를 생성
        ArrayList<Monster> monsterList = new ArrayList<>();
        monsterList.add(new NormalMonster("슬라임", 30, 8, 5));
        monsterList.add(new NormalMonster("고블린", 50, 12, 4));
        monsterList.add(new NormalMonster("오크", 80, 15, 7));
        monsterList.add(new NormalMonster("스켈레톤", 60, 14, 10));
        monsterList.add(new NormalMonster("트롤", 120, 18, 6));
        monsterList.add(new NormalMonster("골렘", 100, 20, 25));
        monsterList.add(new NormalMonster("와이번", 150, 25, 15));
        monsterList.add(new NormalMonster("리치", 130, 35, 12));
        monsterList.add(new NormalMonster("키메라", 200, 30, 20));
        monsterList.add(new NormalMonster("드래곤", 300, 40, 30));
        monsterList.add(new FireMonster("이프리트", 140, 22, 18, 35));
        monsterList.add(new FireMonster("헬하운드", 90, 28, 10, 25));
        monsterList.add(new FireMonster("파이어 골렘", 180, 25, 22, 20));

        for (Monster m : monsterList) {
            m.info();
        }
        // (도전 과제) 플레이어가 몬스터 목록에서 두 마리를 선택하여
        // 싸움을 붙이는 로직을 구현해 보세요.
        Scanner scanner = new Scanner(System.in);
        System.out.println("0~9번중 첫번째 몬스터를 고르시오: ");
        int first = scanner.nextInt();

        System.out.println("0~9번중 두번째 몬스터를 고르시오: ");
        int second = scanner.nextInt();

        // first, second 가 0~9사이로 선택할수 있도록 만들기
        if (first < 0 || second < 0 || first > 9 || second > 9)
            System.out.println("잘못된 선택입니다.");

        Monster monster1 = monsterList.get(first);
        Monster monster2 = monsterList.get(second);

        while(monster1.getHp() > 0 && monster2.getHp() > 0) {
            int damage = monster1.getAttack() - monster2.getDefense();
            if (damage <= 0) damage = 0;


            int newHp = monster2.getHp() - damage;
            monster2.setHp(newHp > 0 ? newHp : 0);

            System.out.println(monster1.getName() + "의 기본공격! " + monster2.getName() + "는 데미지" + damage + "를 입었다 ");
            System.out.println(monster2.getName() + " 남은체력 : " + monster2.getHp());
            System.out.println();
            if (monster2.getHp() <= 0) break;
            try {
                // 1000 밀리초 = 1초 동안 실행을 멈춥니다.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // sleep 도중 방해를 받았을 때 처리할 코드를 여기에 작성할 수 있습니다.
                // 지금은 비워두어도 괜찮습니다.
                e.printStackTrace();
            }

            damage = monster2.getAttack() - monster1.getDefense();
            if (damage <= 0) damage = 0;

            newHp = monster1.getHp() - damage;
            monster1.setHp(newHp > 0 ? newHp : 0);

            System.out.println(monster2.getName() + "의 기본공격! " + monster1.getName() + "는 데미지" + damage + "를 입었다 ");
            System.out.println(monster1.getName() + " 남은체력 : " + monster1.getHp());
            System.out.println();
            if (monster1.getHp() <= 0) break;

            try {
                // 1000 밀리초 = 1초 동안 실행을 멈춥니다.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // sleep 도중 방해를 받았을 때 처리할 코드를 여기에 작성할 수 있습니다.
                // 지금은 비워두어도 괜찮습니다.
                e.printStackTrace();
            }
        }
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

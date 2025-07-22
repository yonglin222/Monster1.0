package project;

import java.util.ArrayList;
import java.util.Scanner;
class NormalMonster extends Monster {
    public NormalMonster(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }
    @Override
    public int attack(Monster target) {
        int damage;
        if (Math.random() < 0.2) {
            damage = Math.max(0, 2 * getAttack());
            System.out.println(getName() + "의 치명타공격! 확정피해 " + damage);
        }else {
            damage = Math.max(0, getAttack() - target.getDefense());
            System.out.println(getName() + "의 일반공격 피해 " + damage +
                " (공격력: " + getAttack() + ", 상대 방어력: " + target.getDefense() + ")");
        }
        return damage;
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
        int damage = Math.max(getAttack() - target.getDefense(), 0);
        System.out.println(getName() + "의 일반공격 피해 " + damage +
                " (공격력: " + getAttack() + ", 상대 방어력: " + target.getDefense() + ")");
        if (Math.random() < 0.35) {
            System.out.println("스킬 발동!!! 화염공격 피해 " +fireSkillDamage );
            damage = damage + fireSkillDamage;
        }
        return damage;
    }
}
public class GameManager {
    public static void main(String[] args) {
        // Monster 객체들을 저장할 ArrayList를 생성
        ArrayList<Monster> monsterList = new ArrayList<>();
        // 0번 슬라임
        monsterList.add(new Troll("슬라임", 30, 8, 5));
        // 1번 고블린
        monsterList.add(new Troll("고블린", 50, 12, 4));
        // 2번 오크
        monsterList.add(new Troll("오크", 80, 15, 7));
        // 3번 스켈레톤
        monsterList.add(new Troll("스켈레톤", 60, 14, 10));
        // 4번 트롤
        monsterList.add(new Troll("트롤", 120, 18, 6));
        // 5번 골렘
        monsterList.add(new Troll("골렘", 100, 20, 25));
        // 6번 와이번
        monsterList.add(new Troll("와이번", 150, 25, 15));
        // 7번 리치
        monsterList.add(new Troll("리치", 130, 35, 12));
        // 8번 키메라
        monsterList.add(new Troll("키메라", 200, 30, 20));
        // 9번 드래곤
        monsterList.add(new Troll("드래곤", 300, 40, 30));
        // 10번 이프리트
        monsterList.add(new Hellhound("이프리트", 140, 22, 18, 35));
        // 11번 헬하운드
        monsterList.add(new Hellhound("헬하운드", 90, 28, 10, 25));
        // 12번 파이어골렘
        monsterList.add(new Hellhound("파이어 골렘", 180, 25, 22, 20));

        for (Monster m : monsterList) {
            m.info();
        }
        // (도전 과제) 플레이어가 몬스터 목록에서 두 마리를 선택하여
        // 싸움을 붙이는 로직을 구현해 보세요.
        Scanner scanner = new Scanner(System.in);
        System.out.println("0~12번중 첫번째 몬스터를 고르시오: ");
        int first = scanner.nextInt();

        System.out.println("0~12번중 두번째 몬스터를 고르시오: ");
        int second = scanner.nextInt();

        // first, second 가 0~9사이로 선택할수 있도록 만들기
        if (first < 0 || second < 0 || first > 12 || second > 12)
            System.out.println("잘못된 선택입니다.");

        Monster monster1 = monsterList.get(first);
        Monster monster2 = monsterList.get(second);

        System.out.println("--- 전투 시작 ---");
        int turn = 1;

        while(monster1.getHp() > 0 && monster2.getHp() > 0) {
            System.out.println("--- " + turn + " 턴 ---");
            Monster attacker = (turn % 2 == 0) ? monster2 : monster1;
            Monster defender = (turn % 2 == 0) ? monster1 : monster2;
            int newHp = defender.getHp() - attacker.attack(defender);
            defender.setHp(Math.max(newHp, 0));

            System.out.println(defender.getName() + " 남은체력 : " + defender.getHp());
            // ✨ 추가된 회복 스킬 발동 로직 ✨
            // 공격 턴을 마친 attacker가 Healable 타입인지 확인
            if (attacker instanceof Healable) {
                // 25% 확률로 회복 스킬 사용
                if (Math.random() < 0.25) {
                    ((Healable) attacker).heal(); // ???이게 좀 이해안되요
                    System.out.println(attacker.getName() + "체력 : " + attacker.getHp());
                }
            }
            System.out.println();
            if (defender.getHp() <= 0) {
                System.out.println(attacker.getName() +" 전투 승리!");
                break;
            }
            turn++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            newHp = monster1.getHp() - monster2.attack(monster1);
//            monster1.setHp(newHp > 0 ? newHp : 0);
//            System.out.println(monster2.getName() + "nster2.attack(monster1) + "를 입었다 ");
//            System.out.println(monster1.getName() + " 남은체력 : " + monster1.getHp());
//            System.out.println();
//            if (monster1.getHp() <= 0) {
//                System.out.println(monster2.getName() +" 전투 승리!");
//                break;
//
//            }
//            turn++; // 여기서 turn 변수가 1 증가합니다!
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

package project;

import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("0~12번중 첫번째 몬스터를 고르시오: ");
        int first = scanner.nextInt();

        System.out.println("0~12번중 두번째 몬스터를 고르시오: ");
        int second = scanner.nextInt();

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
        }
    }
}

package project;

// NormalMonster를 상속받고, Healable 능력을 가짐
public class Troll extends NormalMonster implements Healable {

    public Troll(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    // Healable 인터페이스의 규칙에 따라 heal() 메서드를 구현
    @Override
    public void heal() {
        // 최대 체력의 10%를 회복함
        int healAmount = (int) (getMaxHp() * 0.1);
        int newHp = Math.min(getMaxHp(), getHp() + healAmount);
        setHp(newHp);
        System.out.println(getName() + "이(가) " + healAmount + "만큼 체력을 회복했습니다.");
    }
}

package project;

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
        } else {
            damage = Math.max(0, getAttack() - target.getDefense());
            System.out.println(getName() + "의 일반공격 피해 " + damage +
                    " (공격력: " + getAttack() + ", 상대 방어력: " + target.getDefense() + ")");
        }
        return damage;
    }
}

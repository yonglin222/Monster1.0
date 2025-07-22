package project;

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
            System.out.println("스킬 발동!!! 화염공격 피해 " + fireSkillDamage);
            damage = damage + fireSkillDamage;
        }
        return damage;
    }
}

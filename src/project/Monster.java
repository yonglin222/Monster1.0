package project;

public abstract class Monster {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;

    public Monster() {
    }

    public Monster(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
//public void setHp(int newHp) {
//    // 여기서 newHp가 0보다 작으면 0으로 설정하는 로직을 추가할 수도 있어요.
//    // monster2.setHp(newHp > 0 ? newHp : 0); 와 같은 삼항 연산자를 사용하면 됩니다.
//    this.hp = newHp;
//}

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

//    public abstract void info();
    public void info(){
        System.out.println("이름:" + name + " 체력:" + hp + "/" + maxHp + " 공격력:" + attack + " 방어력: " + defense);
    }
    public abstract int attack(Monster target);


}
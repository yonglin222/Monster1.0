package project;

public class GameManager extends Monster {
    public GameManager(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public static void main(String[] args) {
        Monster monster1 = new Monster("슬라임", 30, 8, 3);
        Monster monster2 = new Monster("오크", 40, 12, 5);

        while(monster1.getHp() > 0 && monster2.getHp() > 0){
            int damage = monster1.getAttack() - monster2.getDefense();
            if(damage <= 0) damage=0;

            Monster newHp = new setHp(newHp > 0 ? newHp : 0);
//            int newHp = monster2.getHp() - damage;
            monster2.setHp(newHp > 0 ? newHp : 0);

            System.out.println(monster1.getName() + "의 기본공격! "+ monster2.getName() + "는 데미지" +damage +"를 입었다 ");
            System.out.println(monster2.getName() + " 남은체력 : " + newHp);
            System.out.println();

            damage = monster2.getAttack() - monster1.getDefense();
            if(damage <= 0) damage=0;

            newHp = monster1.getHp() - damage;
            monster1.setHp(newHp > 0 ? newHp : 0);

            System.out.println(monster2.getName() + "의 기본공격! "+ monster1.getName() + "는 데미지" +damage +"를 입었다 ");
            System.out.println(monster1.getName() + " 남은체력 : " + newHp);
            System.out.println();



        }
        // 피해량만큼 상대방의 hp를 setHp() 메서드를 이용해 깎아주세요.



    }


}

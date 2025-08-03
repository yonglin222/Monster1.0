package project;
/*이번 단계에서는 게임의 주인공인 Player 클래스를 만듭니다.
  Player는 다른 몬스터들처럼 싸울 수 있을 뿐만 아니라,
  경험치를 통해 레벨업하고, 스탯을 직접 분배하여 성장하는 특별한 존재입니다.
  RPG 성장 시스템: 경험치 획득 → 레벨업 → 능력치 향상의 순환 구조
  자원 관리 시스템: HP(체력)와 MP(마나)를 관리하여 전략적 플레이 유도
  커스터마이징 시스템: 스탯 포인트를 통해 플레이어가 직접 캐릭터 특성 결정
  다양한 전투 옵션: 일반공격, 스킬공격, 힐링 등 상황에 맞는 행동 선택
  지속적인 발전: 몬스터 처치를 통한 경험치 획득으로 끊임없는 캐릭터 성장
 */

 class Player extends Monster {
     private int skillAttack;
     private int mp;

     public Player(String name, int hp, int attack, int defense, int mp, int skillAttack) {
         super(name, hp, attack, defense);
         this.mp = mp;
         this.skillAttack = skillAttack;
     }

     @Override
     public int attack(Monster target) {
         int damage;
         if (Math.random() < 0.15) {
             damage = Math.max(0, 2 * getAttack());
             System.out.println(getName() + "의 치명타공격! 확정피해 " + damage);
         } else {
             damage = Math.max(0, getAttack() - target.getDefense());
             System.out.println(getName() + "의 일반공격 피해 " + damage +
                     " (공격력: " + getAttack() + ", 상대 방어력: " + target.getDefense() + ")");
         }
         return damage;
     }
     public int skillAttack(Monster target) {
         int skillDamage;
         if (mp > 20) {

         }

     }

 }

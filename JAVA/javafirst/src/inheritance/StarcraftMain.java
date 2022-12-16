package inheritance;

public class StarcraftMain {
    public static void main(String[] args) {
        /*
        //Protoss 공격 호출
        Protoss protoss = new Protoss();
        protoss.attack();

        //Zerg 공격 호출
        Zerg zerg = new Zerg();
        zerg.attack();

        //Terran 공격 호출
        Terran terran = new Terran();
        terran.attack();
*/
        Starcraft star = new Protoss();
        star.attack();

        star = new Zerg();
        star.attack();

        star = new Terran();
        star.attack();

        // 추상 클래스는 인스턴스 생성을 할 수 없기 때문에
        // new를 할 수 없어서 에러
//        star = new Starcraft();
//        star.attack();
    }
}

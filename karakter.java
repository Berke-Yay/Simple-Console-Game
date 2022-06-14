package projeler;
public class karakter {
    String name;
    int hp=3000;
    int basic_attack=200;
    int level=1;
    int physical_defense=20;

    public int skill1(){
        int skill_attack=500;
        return skill_attack;
    }
    public int skill2(){
        int healing=40;
        return healing;
    }
    public int skill3(){
        int defense_increase=7;
        return defense_increase;
    }
}

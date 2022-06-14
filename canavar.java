package projeler;
public class canavar {
    String name;
    int hp;
    int basic_attack;
    String buff;
    canavar(String name,int hp,int basic_attack,String buff){
        this.name=name;
        this.hp=hp;
        this.basic_attack=basic_attack;
        this.buff=buff;
    }
    public String toString() {2
        String bilgiler= "Düşman tipi: "+name+" Can: "+hp+" Saldırı gücü: "+basic_attack+" Keserseniz vereceği buff: "+buff;
        return bilgiler;
          
    }
}

package meghanemiles.midlandstech.xmlapplication;

import android.widget.TextView;

public class Countries {
    private String name;
    private String population;

    public Countries(String newName, String newPopulation){
        setName(newName);
        setPopulation(newPopulation);
    }
    public void setName(String newName){
        name = newName;
    }
    public void setPopulation(String newPopulation){
        population = newPopulation;
    }
    public String getName(){
        return name;
    }
    public String getPopulation(){
        return population;
    }
    public String toString(){
        return name +"; " + population;
    }

}

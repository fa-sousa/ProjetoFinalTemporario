package example.aula_01.com.projetoxtrackteste.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PojoList {

    @SerializedName("employeeList")
    private ArrayList<PojoDemo> pojoDemo;

    public ArrayList<PojoDemo> getPojoDemo(){
        return pojoDemo;
    }

    public void setPojoDemo(ArrayList<PojoDemo> pojoDemo) {
        this.pojoDemo = pojoDemo;
    }

}
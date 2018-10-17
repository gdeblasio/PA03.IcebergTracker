package icebergtracker;

import java.time.LocalDate;
import java.time.Month;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class IcebergTracker {
    
    MultiValuedMap<Iceberg,IcebergData> mapa = new ArrayListValuedHashMap<>();
    
    public static void main(String[] args) {
        IcebergTracker icebergTracker = new IcebergTracker();
        icebergTracker.output();
    }

    public IcebergTracker() { 
        Iceberg iceberg1 = new Iceberg(1, "cabo ABC", LocalDate.of(2017, Month.MARCH, 1));
        Iceberg iceberg2 = new Iceberg(2, "bahía DEF", LocalDate.of(2017, Month.MARCH, 10));;
        
        mapa.put(iceberg1, new IcebergData(LocalDate.of(2018, Month.MARCH, 1), 
                iceberg1, "80º N 15' E", 9e9));
        mapa.put(iceberg1, new IcebergData(LocalDate.of(2018, Month.MARCH, 30), 
                iceberg1, "80º N 12' E", 8e9));
        mapa.put(iceberg2, new IcebergData(LocalDate.of(2018, Month.MARCH, 1), 
                iceberg2, "88º S 15' W", 7e9));
        mapa.put(iceberg2, new IcebergData(LocalDate.of(2018, Month.MARCH, 30), 
                iceberg2, "88º S 30' W", 6e9));
    }
    
    private void output() {
        for (IcebergData d : mapa.values()) {
            System.out.println(d);
        }
    }
    
}

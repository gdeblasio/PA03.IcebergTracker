package icebergtracker;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class IcebergTracker {
    
    List<Iceberg> icebergs = new ArrayList<>();
    List<IcebergPosition> positions = new ArrayList<>();
    List<IcebergVolume> volumes = new ArrayList<>();
    
    public static void main(String[] args) {
        IcebergTracker icebergTracker = new IcebergTracker();
        icebergTracker.output();
    }

    public IcebergTracker() {
        icebergs.add(new Iceberg(1, "cabo XYZ", LocalDate.of(2017, Month.MARCH, 1)));
        icebergs.add(new Iceberg(2, "bahía ABC", LocalDate.of(2017, Month.MARCH, 10)));
        
        positions.add(new IcebergPosition(LocalDate.of(2018, Month.SEPTEMBER, 1), 
                icebergs.get(0), "88ºN 24'E"));
        positions.add(new IcebergPosition(LocalDate.of(2018, Month.OCTOBER, 1), 
                icebergs.get(0), "80ºN 12'E"));
        
        positions.add(new IcebergPosition(LocalDate.of(2018, Month.SEPTEMBER, 1), 
                icebergs.get(1), "77ºS 02'W"));
        positions.add(new IcebergPosition(LocalDate.of(2018, Month.OCTOBER, 1), 
                icebergs.get(1), "78ºS 03'W"));
        
        volumes.add(new IcebergVolume(LocalDate.of(2018, Month.SEPTEMBER, 1), 
                icebergs.get(0), 9e9));
        volumes.add(new IcebergVolume(LocalDate.of(2018, Month.OCTOBER, 1), 
                icebergs.get(0), 8e8));
        volumes.add(new IcebergVolume(LocalDate.of(2018, Month.SEPTEMBER, 1), 
                icebergs.get(1), 7e7));
        volumes.add(new IcebergVolume(LocalDate.of(2018, Month.OCTOBER, 1), 
                icebergs.get(1), 6.5e7));
    }
    
    private void output() {
        for (Iceberg i : icebergs) {
            System.out.println(i.toString());
            
            for (IcebergPosition p : positions) {
                if (p.getIceberg().equals(i)) {
                    System.out.println(p.toString());
                    
                    for (IcebergVolume v : volumes) {
                        if (v.getIceberg().equals(i) 
                                && v.getDate().equals(p.getDate())) {
                            System.out.println(v.toString());
                        }
                    }
                }
            }
        }
    }
    
}

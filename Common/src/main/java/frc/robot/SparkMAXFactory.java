package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class SparkMAXFactory {


    // create a CANTalon with the default (out of the box) configuration
    public static CANSparkMax createDefaultSparkMax(int id) {
        return new CANSparkMax(id, MotorType.kBrushless);
    }

   

    public static CANSparkMax createPermanentSlaveSparkMax(int slave_id, CANSparkMax master, boolean opposeMasterDirection) {
       
        final CANSparkMax spark = createSpark(slave_id);
        spark.follow(master, opposeMasterDirection);
        return spark;
    }


    private static CANSparkMax createSpark(int id) {
        CANSparkMax spark = new CANSparkMax(id,MotorType.kBrushless);
        spark.clearFaults();

        return spark;
    }
}
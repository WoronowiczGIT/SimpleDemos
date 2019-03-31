package SDA.SOLID.DependencyInversion.UniversalRemote;

public class Remote {
   ControllableDevice device;

   Remote(ControllableDevice device){
       this.device = device;
   }

   void volumeUP(){
       device.increaseVolume();
   }
   void volumeDown(){
       device.decreaseVolume();
   }

   void  turnON(){
       device.turnOFF();
   }
   void turnOFF(){
       device.turnOFF();
   }
}

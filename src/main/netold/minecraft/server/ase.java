package net.minecraft.server;
import java.util.Random;

class ase extends asl {

   // $FF: synthetic field
   final asd aD;


   ase(asd var1, int var2, arm var3) {
      super(var2, var3);
      this.aD = var1;
   }

   public bhc a(Random var1) {
      return var1.nextBoolean()?asd.aD:asd.aE;
   }
}

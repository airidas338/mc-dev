package net.minecraft.server;
import java.util.Random;

class bkl implements bks {

   private bkl() {}

   public boolean a(blf var1) {
      if(var1.c[ej.f.a()] && !var1.b[ej.f.a()].d && var1.c[ej.b.a()] && !var1.b[ej.b.a()].d) {
         blf var2 = var1.b[ej.f.a()];
         return var2.c[ej.b.a()] && !var2.b[ej.b.a()].d;
      } else {
         return false;
      }
   }

   public blb a(ej var1, blf var2, Random var3) {
      var2.d = true;
      var2.b[ej.f.a()].d = true;
      var2.b[ej.b.a()].d = true;
      var2.b[ej.f.a()].b[ej.b.a()].d = true;
      return new bkv(var1, var2, var3);
   }

   // $FF: synthetic method
   bkl(bkj var1) {
      this();
   }
}

package net.minecraft.server;
import java.util.Random;

class afu extends zy {

   private final EntitySilverfish a;
   private ej b;
   private boolean c;


   public afu(EntitySilverfish var1) {
      super(var1, 1.0D, 10);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      if(this.a.u() != null) {
         return false;
      } else if(!this.a.s().m()) {
         return false;
      } else {
         Random var1 = this.a.bb();
         if(var1.nextInt(10) == 0) {
            this.b = ej.a(var1);
            Location var2 = (new Location(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
            IBlock var3 = this.a.o.getData(var2);
            if(BlockMonsterEggs.d(var3)) {
               this.c = true;
               return true;
            }
         }

         this.c = false;
         return super.a();
      }
   }

   public boolean b() {
      return this.c?false:super.b();
   }

   public void c() {
      if(!this.c) {
         super.c();
      } else {
         World var1 = this.a.o;
         Location var2 = (new Location(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
         IBlock var3 = var1.getData(var2);
         if(BlockMonsterEggs.d(var3)) {
            var1.a(var2, aty.be.P().a(BlockMonsterEggs.a, axu.a(var3)), 3);
            this.a.y();
            this.a.J();
         }

      }
   }
}

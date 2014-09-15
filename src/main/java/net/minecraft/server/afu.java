package net.minecraft.server;
import java.util.Random;

class afu extends PathfinderGoalRandomStroll {

   private final EntitySilverfish a;
   private EnumFacing b;
   private boolean c;


   public afu(EntitySilverfish var1) {
      super(var1, 1.0D, 10);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      if(this.a.u() != null) {
         return false;
      } else if(!this.a.getNavigation().m()) {
         return false;
      } else {
         Random var1 = this.a.bb();
         if(var1.nextInt(10) == 0) {
            this.b = EnumFacing.a(var1);
            Location var2 = (new Location(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
            IBlockData var3 = this.a.o.getData(var2);
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
         IBlockData var3 = var1.getData(var2);
         if(BlockMonsterEggs.d(var3)) {
            var1.a(var2, Blocks.MONSTER_EGGS.P().a(BlockMonsterEggs.a, axu.a(var3)), 3);
            this.a.y();
            this.a.J();
         }

      }
   }
}

package net.minecraft.server;
import java.util.Random;

class aev extends PathfinderGoal {

   private EntityEnderman a;


   public aev(EntityEnderman var1) {
      this.a = var1;
   }

   public boolean a() {
      return !this.a.o.Q().b("mobGriefing")?false:(this.a.ck().c().r() != Material.AIR?false:this.a.bb().nextInt(20) == 0);
   }

   public void e() {
      Random var1 = this.a.bb();
      World var2 = this.a.o;
      int var3 = MathHelper.c(this.a.s - 2.0D + var1.nextDouble() * 4.0D);
      int var4 = MathHelper.c(this.a.t + var1.nextDouble() * 3.0D);
      int var5 = MathHelper.c(this.a.u - 2.0D + var1.nextDouble() * 4.0D);
      Location var6 = new Location(var3, var4, var5);
      IBlock var7 = var2.getData(var6);
      Block var8 = var7.c();
      if(EntityEnderman.co().contains(var8)) {
         this.a.a(var7);
         var2.a(var6, aty.a.P());
      }

   }
}

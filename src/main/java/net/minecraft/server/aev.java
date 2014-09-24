package net.minecraft.server;
import java.util.Random;

class aev extends PathfinderGoal {

   private EntityEnderman a;


   public aev(EntityEnderman var1) {
      this.a = var1;
   }

   public boolean a() {
      return !this.a.o.getGameRules().getBoolean("mobGriefing")?false:(this.a.ck().c().getMaterial() != Material.AIR?false:this.a.bb().nextInt(20) == 0);
   }

   public void e() {
      Random var1 = this.a.bb();
      World var2 = this.a.o;
      int var3 = MathHelper.floor(this.a.s - 2.0D + var1.nextDouble() * 4.0D);
      int var4 = MathHelper.floor(this.a.t + var1.nextDouble() * 3.0D);
      int var5 = MathHelper.floor(this.a.u - 2.0D + var1.nextDouble() * 4.0D);
      Location var6 = new Location(var3, var4, var5);
      IBlockData var7 = var2.getData(var6);
      Block var8 = var7.c();
      if(EntityEnderman.co().contains(var8)) {
         this.a.a(var7);
         var2.a(var6, Blocks.AIR.P());
      }

   }
}

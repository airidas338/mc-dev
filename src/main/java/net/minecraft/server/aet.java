package net.minecraft.server;
import java.util.Random;

class aet extends PathfinderGoal {

   private EntityEnderman a;


   public aet(EntityEnderman var1) {
      this.a = var1;
   }

   public boolean a() {
      return !this.a.o.getGameRules().getBoolean("mobGriefing")?false:(this.a.ck().c().getMaterial() == Material.AIR?false:this.a.bb().nextInt(2000) == 0);
   }

   public void e() {
      Random var1 = this.a.bb();
      World var2 = this.a.o;
      int var3 = MathHelper.floor(this.a.s - 1.0D + var1.nextDouble() * 2.0D);
      int var4 = MathHelper.floor(this.a.t + var1.nextDouble() * 2.0D);
      int var5 = MathHelper.floor(this.a.u - 1.0D + var1.nextDouble() * 2.0D);
      Location var6 = new Location(var3, var4, var5);
      Block var7 = var2.getData(var6).c();
      Block var8 = var2.getData(var6.b()).c();
      if(this.a(var2, var6, this.a.ck().c(), var7, var8)) {
         var2.setTypeAndData(var6, this.a.ck(), 3);
         this.a.a(Blocks.AIR.P());
      }

   }

   private boolean a(World var1, Location var2, Block var3, Block var4, Block var5) {
      return !var3.canPlace(var1, var2)?false:(var4.getMaterial() != Material.AIR?false:(var5.getMaterial() == Material.AIR?false:var5.d()));
   }
}

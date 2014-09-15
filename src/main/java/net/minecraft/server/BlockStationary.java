package net.minecraft.server;
import java.util.Random;

public class BlockStationary extends BlockFluids {

   protected BlockStationary(Material var1) {
      super(var1);
      this.a(false);
      if(var1 == Material.LAVA) {
         this.a(true);
      }

   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(World var1, Location var2, IBlockData var3) {
      BlockFlowing var4 = a(this.J);
      var1.a(var2, var4.P().a(b, var3.b(b)), 2);
      var1.a(var2, (Block)var4, this.a(var1));
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(this.J == Material.LAVA) {
         if(var1.Q().b("doFireTick")) {
            int var5 = var4.nextInt(3);
            if(var5 > 0) {
               Location var6 = var2;

               for(int var7 = 0; var7 < var5; ++var7) {
                  var6 = var6.a(var4.nextInt(3) - 1, 1, var4.nextInt(3) - 1);
                  Block var8 = var1.getData(var6).c();
                  if(var8.J == Material.AIR) {
                     if(this.e(var1, var6)) {
                        var1.a(var6, Blocks.FIRE.P());
                        return;
                     }
                  } else if(var8.J.c()) {
                     return;
                  }
               }
            } else {
               for(int var9 = 0; var9 < 3; ++var9) {
                  Location var10 = var2.a(var4.nextInt(3) - 1, 0, var4.nextInt(3) - 1);
                  if(var1.isEmpty(var10.a()) && this.m(var1, var10)) {
                     var1.a(var10.a(), Blocks.FIRE.P());
                  }
               }
            }

         }
      }
   }

   protected boolean e(World var1, Location var2) {
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         if(this.m(var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private boolean m(World var1, Location var2) {
      return var1.getData(var2).c().getMaterial().h();
   }
}

package net.minecraft.server;
import java.util.Random;

public class BlockFalling extends Block {

   public static boolean M;


   public BlockFalling() {
      super(Material.SAND);
      this.a(CreativeModeTab.b);
   }

   public BlockFalling(Material var1) {
      super(var1);
   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      var1.a(var2, (Block)this, this.a(var1));
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      var1.a(var2, (Block)this, this.a(var1));
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         this.e(var1, var2);
      }

   }

   private void e(World var1, Location var2) {
      if(d(var1, var2.b()) && var2.o() >= 0) {
         byte var3 = 32;
         if(!M && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
            if(!var1.isStatic) {
               EntityFallingBlock var5 = new EntityFallingBlock(var1, (double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, var1.getData(var2));
               this.a(var5);
               var1.addEntity((Entity)var5);
            }
         } else {
            var1.setAir(var2);

            Location var4;
            for(var4 = var2.b(); d(var1, var4) && var4.o() > 0; var4 = var4.b()) {
               ;
            }

            if(var4.o() > 0) {
               var1.a(var4.a(), this.P());
            }
         }

      }
   }

   protected void a(EntityFallingBlock var1) {}

   public int a(World var1) {
      return 2;
   }

   public static boolean d(World var0, Location var1) {
      Block var2 = var0.getData(var1).c();
      Material var3 = var2.J;
      return var2 == Blocks.FIRE || var3 == Material.AIR || var3 == Material.WATER || var3 == Material.LAVA;
   }

   public void a_(World var1, Location var2) {}
}

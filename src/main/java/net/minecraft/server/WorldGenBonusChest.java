package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class WorldGenBonusChest extends WorldGenerator {

   private final List a;
   private final int b;


   public WorldGenBonusChest(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      Block var4;
      while(((var4 = var1.getData(var3).c()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.o() > 1) {
         var3 = var3.b();
      }

      if(var3.o() < 1) {
         return false;
      } else {
         var3 = var3.a();

         for(int var5 = 0; var5 < 4; ++var5) {
            Location var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.isEmpty(var6) && World.a((IBlockAccess)var1, var6.b())) {
               var1.setTypeAndData(var6, Blocks.CHEST.P(), 2);
               TileEntity var7 = var1.getTileEntity(var6);
               if(var7 instanceof TileEntityChest) {
                  StructurePieceTreaasure.a(var2, this.a, (IInventory)((TileEntityChest)var7), this.b);
               }

               Location var8 = var6.f();
               Location var9 = var6.e();
               Location var10 = var6.c();
               Location var11 = var6.d();
               if(var1.isEmpty(var9) && World.a((IBlockAccess)var1, var9.b())) {
                  var1.setTypeAndData(var9, Blocks.TORCH.P(), 2);
               }

               if(var1.isEmpty(var8) && World.a((IBlockAccess)var1, var8.b())) {
                  var1.setTypeAndData(var8, Blocks.TORCH.P(), 2);
               }

               if(var1.isEmpty(var10) && World.a((IBlockAccess)var1, var10.b())) {
                  var1.setTypeAndData(var10, Blocks.TORCH.P(), 2);
               }

               if(var1.isEmpty(var11) && World.a((IBlockAccess)var1, var11.b())) {
                  var1.setTypeAndData(var11, Blocks.TORCH.P(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}

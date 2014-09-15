package net.minecraft.server;
import java.util.Random;

public class BlockMobSpawner extends BlockContainer {

   protected BlockMobSpawner() {
      super(Material.STONE);
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityMobSpawner();
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      int var6 = 15 + var1.random.nextInt(15) + var1.random.nextInt(15);
      this.b(var1, var2, var6);
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }
}

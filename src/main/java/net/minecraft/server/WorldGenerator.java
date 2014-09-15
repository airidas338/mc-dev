package net.minecraft.server;
import java.util.Random;

public abstract class WorldGenerator {

   private final boolean a;


   public WorldGenerator() {
      this(false);
   }

   public WorldGenerator(boolean var1) {
      this.a = var1;
   }

   public abstract boolean generate(World var1, Random var2, Location var3);

   public void e() {}

   protected void a(World var1, Location var2, Block var3) {
      this.a(var1, var2, var3, 0);
   }

   protected void a(World var1, Location var2, Block var3, int var4) {
      this.a(var1, var2, var3.a(var4));
   }

   protected void a(World var1, Location var2, IBlockData var3) {
      if(this.a) {
         var1.a(var2, var3, 3);
      } else {
         var1.a(var2, var3, 2);
      }

   }
}

package net.minecraft.server;
import java.util.Random;

public abstract class bmu {

   protected IBlockData a;


   protected bmu() {
      this.a = Blocks.AIR.P();
   }

   public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

   public IBlockData a() {
      return this.a;
   }
}

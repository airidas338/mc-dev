package net.minecraft.server;
import java.util.Random;

public abstract class bmu {

   protected IBlock a;


   protected bmu() {
      this.a = Blocks.a.P();
   }

   public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

   public IBlock a() {
      return this.a;
   }
}

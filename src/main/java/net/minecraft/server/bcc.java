package net.minecraft.server;
import java.util.Random;

public class bcc extends Block {

   public bcc() {
      super(Material.G);
      this.a(akf.c);
   }

   public void a(World var1, Location var2, IBlock var3, Entity var4) {
      var4.aB();
   }

   public boolean c() {
      return false;
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.F;
   }

   protected boolean G() {
      return true;
   }
}

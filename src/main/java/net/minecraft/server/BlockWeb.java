package net.minecraft.server;
import java.util.Random;

public class BlockWeb extends Block {

   public BlockWeb() {
      super(Material.WEB);
      this.a(CreativeModeTab.c);
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

   public Item a(IBlock var1, Random var2, int var3) {
      return Items.F;
   }

   protected boolean G() {
      return true;
   }
}

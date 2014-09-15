package net.minecraft.server;
import java.util.Random;

public class BlockStainedGlass extends awt {

   public static final bev a = bev.a("color", akv.class);


   public BlockStainedGlass(Material var1) {
      super(var1, false);
      this.j(this.L.b().a(a, akv.a));
      this.a(CreativeModeTab.b);
   }

   public int a(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   public MaterialMapColor g(IBlockData var1) {
      return ((akv)var1.b(a)).e();
   }

   public int a(Random var1) {
      return 0;
   }

   protected boolean G() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, akv.b(var1));
   }

   public void c(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic) {
         BlockBeacon.d(var1, var2);
      }

   }

   public void b(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic) {
         BlockBeacon.d(var1, var2);
      }

   }

   public int c(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}

package net.minecraft.server;

public class BlockStandingSign extends BlockSignAbstract {

   public static final bew a = bew.a("rotation", 0, 15);


   public BlockStandingSign() {
      this.j(this.L.b().a(a, Integer.valueOf(0)));
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      if(!var1.getData(var2.b()).c().getMaterial().isBuildable()) {
         this.b(var1, var2, var3, 0);
         var1.setAir(var2);
      }

      super.doPhysics(var1, var2, var3, var4);
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}

package net.minecraft.server;

public class BlockSandstoneRed extends Block {

   public static final bev a = bev.a("type", azr.class);


   public BlockSandstoneRed() {
      super(Material.STONE);
      this.j(this.L.b().a(a, azr.a));
      this.a(CreativeModeTab.b);
   }

   public int a(IBlockData var1) {
      return ((azr)var1.b(a)).a();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, azr.a(var1));
   }

   public int c(IBlockData var1) {
      return ((azr)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
